/*
 * Copyright © 2019 Dominokit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dominokit.domino.ui.upload;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.upload.FilePreviewFactory.UNITS;

import elemental2.core.JsNumber;
import elemental2.dom.File;
import elemental2.dom.FormData;
import elemental2.dom.HTMLElement;
import elemental2.dom.XMLHttpRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;

/**
 * A component representing the upload file
 *
 * @see BaseDominoElement
 * @see FileUpload
 */
public class FileItem extends BaseDominoElement<HTMLElement, FileItem> {

  private final File file;
  private final UploadOptions options;
  private final List<RemoveFileHandler> removeHandlers = new ArrayList<>();
  private final List<ErrorHandler> errorHandlers = new ArrayList<>();
  private final List<ProgressHandler> progressHandlers = new ArrayList<>();
  private final List<BeforeUploadHandler> beforeUploadHandlers = new ArrayList<>();
  private final List<SuccessUploadHandler> successUploadHandlers = new ArrayList<>();
  private final List<CancelHandler> cancelHandlers = new ArrayList<>();
  private XMLHttpRequest request;
  private boolean canceled;
  private boolean removed;
  private boolean uploaded;
  private String fileName;
  private UploadRequestSender requestSender;

  private IsFilePreview<?> filePreview;

  /**
   * @param file the {@link File}
   * @param options the {@link UploadOptions}
   * @return new instance
   */
  public static FileItem create(
      File file, UploadOptions options, FilePreviewFactory previewFactory) {
    return new FileItem(file, options, previewFactory);
  }
  /**
   * @param file the {@link File}
   * @return new instance
   */
  public static FileItem create(File file, FilePreviewFactory previewFactory) {
    return new FileItem(file, new UploadOptions(), previewFactory);
  }

  public FileItem(File file, UploadOptions options, FilePreviewFactory previewFactory) {
    this.file = file;
    this.options = options;
    this.fileName = file.name;
    this.filePreview = previewFactory.forFile(this);

    init(this);
  }

  /** @return true if the uploaded file is image */
  public boolean isImage() {
    return file.type.startsWith("image");
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return filePreview.element();
  }

  /** @return the {@link File} */
  public File getFile() {
    return file;
  }

  /** @return the size of the file in a readable format */
  public String readableFileSize() {
    return formatSize(file.size);
  }

  private String formatSize(double size) {
    int threshold = 1024;
    if (Math.abs(size) < threshold) return size + " B";

    int unitIndex = -1;
    do {
      size /= threshold;
      ++unitIndex;
    } while (Math.abs(size) >= threshold && unitIndex < UNITS.length - 1);
    return new JsNumber(size).toFixed(1) + " " + UNITS[unitIndex];
  }

  private void updateProgress(double progress) {
    filePreview.onUploadProgress(progress);
    progressHandlers.forEach(handler -> handler.onProgress(progress, request));
  }

  /**
   * Adds a handler to be called when removing the file
   *
   * @param removeHandler A {@link RemoveFileHandler}
   * @return same instance
   */
  public FileItem addRemoveHandler(RemoveFileHandler removeHandler) {
    removeHandlers.add(removeHandler);
    return this;
  }

  /**
   * Adds a handler to be called when an error happens while uploading the file
   *
   * @param errorHandler A {@link ErrorHandler}
   * @return same instance
   */
  public FileItem addErrorHandler(ErrorHandler errorHandler) {
    errorHandlers.add(errorHandler);
    return this;
  }

  /**
   * Adds a handler to be called when file is uploading providing the progress
   *
   * @param progressHandler A {@link ProgressHandler}
   * @return same instance
   */
  public FileItem addProgressHandler(ProgressHandler progressHandler) {
    progressHandlers.add(progressHandler);
    return this;
  }

  /**
   * Adds a handler to be called before uploading the file
   *
   * @param beforeUploadHandler\ A {@link BeforeUploadHandler}
   * @return same instance
   */
  public FileItem addBeforeUploadHandler(BeforeUploadHandler beforeUploadHandler) {
    beforeUploadHandlers.add(beforeUploadHandler);
    return this;
  }

  /**
   * Adds a handler to be called when the file is uploaded successfully
   *
   * @param successUploadHandler A {@link SuccessUploadHandler}
   * @return same instance
   */
  public FileItem addSuccessUploadHandler(SuccessUploadHandler successUploadHandler) {
    successUploadHandlers.add(successUploadHandler);
    return this;
  }

  /**
   * Adds a handler to be called when uploading the file is canceled
   *
   * @param cancelHandler A {@link CancelHandler}
   * @return same instance
   */
  public FileItem addCancelHandler(CancelHandler cancelHandler) {
    cancelHandlers.add(cancelHandler);
    return this;
  }

  public FileItem withOptions(ChildHandler<FileItem, UploadOptions> handler) {
    handler.apply(this, options);
    return this;
  }

  public UploadOptions getOptions() {
    return options;
  }

  /** Uploads the file */
  public void upload() {
    if (nonNull(requestSender)) {
      upload(requestSender);
    } else {
      upload(XMLHttpRequest::send);
    }
  }

  /**
   * Uploads the file
   *
   * @param requestSender a {@link UploadRequestSender} to use for sending the request
   */
  public void upload(UploadRequestSender requestSender) {
    this.requestSender = requestSender;
    if (!isExceedsMaxFile() && !uploaded && !isCanceled()) {
      resetState();
      if (!Optional.ofNullable(options.getUrl()).isPresent()) {
        filePreview.onUploadFailed("URL is not provided in the FileItem upload options.");
        throw new IllegalArgumentException("URL is not provided in the FileItem upload options.");
      }

      request = options.getXmlHttpRequest().orElseGet(XMLHttpRequest::new);

      request.upload.addEventListener("loadstart", evt -> filePreview.onUploadStarted());

      request.upload.addEventListener("loadend", evt -> filePreview.onUploadCompleted());

      request.upload.onprogress =
          p0 -> {
            if (p0.lengthComputable) updateProgress(p0.loaded);
          };

      request.onabort =
          p0 -> {
            filePreview.onUploadCanceled();
            cancelHandlers.forEach(handler -> handler.onCancel(request));
          };

      request.addEventListener(
          "readystatechange",
          evt -> {
            if (request.readyState == 4) {
              if (this.options.getSuccessCodesProvider().get().contains(request.status))
                onSuccess();
              else if (!canceled) onError();
            }
          });
      request.open("post", options.getUrl());
      FormData formData = new FormData();
      formData.append(fileName, file);
      beforeUploadHandlers.forEach(handler -> handler.onBeforeUpload(request, formData));
      requestSender.onReady(request, formData);
    }
  }

  private void resetState() {
    canceled = false;
    removed = false;
  }

  public boolean isExceedsMaxFile() {
    return options.getMaxFileSize() > 0 && file.size > options.getMaxFileSize();
  }

  private void onSuccess() {
    uploaded = true;
    filePreview.onUploadSuccess();
    successUploadHandlers.forEach(handler -> handler.onSuccessUpload(request));
  }

  private void onError() {
    filePreview.onUploadFailed(getErrorMessage());
    errorHandlers.forEach(handler -> handler.onError(request));
  }

  private String getErrorMessage() {
    final boolean hasErrorText =
        request.responseType != null
            && (request.responseType.isEmpty() || request.responseType.equals("text"))
            && !request.responseText.isEmpty();
    return hasErrorText ? request.responseText : "Error while sending request";
  }

  /** {@inheritDoc} */
  @Override
  public FileItem remove() {
    super.remove();
    this.removed = true;
    removeHandlers.forEach(handler -> handler.onRemoveFile(file));
    return this;
  }

  /**
   * Sets the url of the server
   *
   * @param url the server url
   * @return same instance
   */
  public FileItem setUrl(String url) {
    options.setUrl(url);
    return this;
  }

  /** @return the file name */
  public String getFileName() {
    return fileName;
  }

  /**
   * Sets the file name
   *
   * @param fileName the new file name
   */
  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  /** @return all the {@link RemoveFileHandler} */
  public List<RemoveFileHandler> getRemoveHandlers() {
    return removeHandlers;
  }

  /** @return all the {@link ErrorHandler} */
  public List<ErrorHandler> getErrorHandlers() {
    return errorHandlers;
  }

  /** @return all the {@link ProgressHandler} */
  public List<ProgressHandler> getProgressHandlers() {
    return progressHandlers;
  }

  /** @return all the {@link BeforeUploadHandler} */
  public List<BeforeUploadHandler> getBeforeUploadHandlers() {
    return beforeUploadHandlers;
  }

  /** @return all the {@link SuccessUploadHandler} */
  public List<SuccessUploadHandler> getSuccessUploadHandlers() {
    return successUploadHandlers;
  }

  /**
   * Cancels the upload request
   *
   * @return same instance
   */
  public FileItem cancel() {
    if (request != null) {
      canceled = true;
      request.abort();
    }
    return this;
  }

  /** @return all the {@link CancelHandler} */
  public List<CancelHandler> getCancelHandlers() {
    return cancelHandlers;
  }

  /** @return true if the upload request is canceled */
  public boolean isCanceled() {
    return canceled;
  }

  /** @return true if the file is removed */
  public boolean isRemoved() {
    return removed;
  }

  /** @return true if the file is uploaded */
  public boolean isUploaded() {
    return uploaded;
  }

  public void validateSize() {
    if (isExceedsMaxFile()) {
      filePreview.onUploadFailed(
          "File is too large, maximum file size is " + formatSize(options.getMaxFileSize()));
    }
  }

  /** A handler to be called when the file is removed */
  @FunctionalInterface
  public interface RemoveFileHandler {
    void onRemoveFile(File file);
  }

  /** A handler to be called when the upload request fails */
  @FunctionalInterface
  public interface ErrorHandler {
    void onError(XMLHttpRequest request);
  }

  /** A handler which provides the upload progress */
  @FunctionalInterface
  public interface ProgressHandler {
    /**
     * @param loaded the loaded bytes
     * @param request the request
     */
    void onProgress(double loaded, XMLHttpRequest request);
  }

  /** A handler to be called before uploading the file */
  @FunctionalInterface
  public interface BeforeUploadHandler {
    /**
     * @param request the request
     * @param formData a form data for adding extra information needed
     */
    void onBeforeUpload(XMLHttpRequest request, FormData formData);
  }

  /** A handler to be called when the file is successfully uploaded */
  @FunctionalInterface
  public interface SuccessUploadHandler {
    void onSuccessUpload(XMLHttpRequest request);
  }

  /** A handler to be called when the upload request is canceled */
  @FunctionalInterface
  public interface CancelHandler {
    void onCancel(XMLHttpRequest request);
  }
}
