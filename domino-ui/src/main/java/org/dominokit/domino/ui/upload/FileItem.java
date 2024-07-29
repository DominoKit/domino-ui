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
import static org.dominokit.domino.ui.utils.Domino.*;

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
 * Represents an item in the file upload component that corresponds to a selected file for upload.
 * It encapsulates the file, upload options, and various event handlers.
 *
 * @see BaseDominoElement
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

  private final FileUpload fileUpload;

  /**
   * Creates a new {@code FileItem} instance for the given file, options, file preview factory, and
   * file upload.
   *
   * @param file The file to be associated with this item.
   * @param options The upload options for this file item.
   * @param previewFactory The factory for creating the file preview.
   * @param fileUpload The parent file upload component.
   * @return A new {@code FileItem} instance.
   */
  public static FileItem create(
      File file, UploadOptions options, FilePreviewFactory previewFactory, FileUpload fileUpload) {
    return new FileItem(file, options, previewFactory, fileUpload);
  }
  /**
   * Creates a new {@code FileItem} instance for the given file, using the default upload options
   * and the provided file preview factory and file upload.
   *
   * @param file The file to be associated with this item.
   * @param previewFactory The factory for creating the file preview.
   * @param fileUpload The parent file upload component.
   * @return A new {@code FileItem} instance.
   */
  public static FileItem create(
      File file, FilePreviewFactory previewFactory, FileUpload fileUpload) {
    return new FileItem(file, new UploadOptions(), previewFactory, fileUpload);
  }

  /**
   * Initializes a new {@code FileItem} with the given file, options, file preview factory, and file
   * upload.
   *
   * @param file The file to be associated with this item.
   * @param options The upload options for this file item.
   * @param previewFactory The factory for creating the file preview.
   * @param fileUpload The parent file upload component.
   */
  public FileItem(
      File file, UploadOptions options, FilePreviewFactory previewFactory, FileUpload fileUpload) {
    this.file = file;
    this.options = options;
    this.fileName = file.name;
    this.fileUpload = fileUpload;
    this.filePreview = previewFactory.forFile(this, fileUpload);

    init(this);
  }

  /**
   * Checks if the file associated with this item is an image.
   *
   * @return {@code true} if the file is an image, {@code false} otherwise.
   */
  public boolean isImage() {
    return file.type.startsWith("image");
  }

  /**
   * @dominokit-site-ignore {@inheritDoc}
   *     <p>Retrieves the HTML element representing this file item.
   * @return The HTML element.
   */
  @Override
  public HTMLElement element() {
    return filePreview.element();
  }

  /**
   * Retrieves the file associated with this item.
   *
   * @return The associated file.
   */
  public File getFile() {
    return file;
  }

  /**
   * Converts the file size into a human-readable format.
   *
   * @return A human-readable string representing the file size.
   */
  public String readableFileSize() {
    return formatSize(file.size);
  }

  /**
   * Converts the given file size into a human-readable format.
   *
   * @param size The file size to be formatted.
   * @return A human-readable string representing the file size.
   */
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

  /**
   * Updates the upload progress and triggers progress handlers.
   *
   * @param progress The current upload progress as a double value.
   */
  private void updateProgress(double progress) {
    filePreview.onUploadProgress(progress);
    progressHandlers.forEach(handler -> handler.onProgress(progress, request));
  }

  /**
   * Adds a handler for the removal of this file item.
   *
   * @param removeHandler The handler to be added.
   * @return This {@code FileItem} instance to allow method chaining.
   */
  public FileItem addRemoveHandler(RemoveFileHandler removeHandler) {
    removeHandlers.add(removeHandler);
    return this;
  }

  /**
   * Adds a handler for upload errors.
   *
   * @param errorHandler The handler to be added.
   * @return This {@code FileItem} instance to allow method chaining.
   */
  public FileItem addErrorHandler(ErrorHandler errorHandler) {
    errorHandlers.add(errorHandler);
    return this;
  }

  /**
   * Adds a handler for tracking upload progress.
   *
   * @param progressHandler The handler to be added.
   * @return This {@code FileItem} instance to allow method chaining.
   */
  public FileItem addProgressHandler(ProgressHandler progressHandler) {
    progressHandlers.add(progressHandler);
    return this;
  }

  /**
   * Adds a handler to be executed before the file upload.
   *
   * @param beforeUploadHandler The handler to be added.
   * @return This {@code FileItem} instance to allow method chaining.
   */
  public FileItem addBeforeUploadHandler(BeforeUploadHandler beforeUploadHandler) {
    beforeUploadHandlers.add(beforeUploadHandler);
    return this;
  }

  /**
   * Adds a handler for successful upload completion.
   *
   * @param successUploadHandler The handler to be added.
   * @return This {@code FileItem} instance to allow method chaining.
   */
  public FileItem addSuccessUploadHandler(SuccessUploadHandler successUploadHandler) {
    successUploadHandlers.add(successUploadHandler);
    return this;
  }

  /**
   * Adds a handler for cancelling the file upload.
   *
   * @param cancelHandler The handler to be added.
   * @return This {@code FileItem} instance to allow method chaining.
   */
  public FileItem addCancelHandler(CancelHandler cancelHandler) {
    cancelHandlers.add(cancelHandler);
    return this;
  }

  /**
   * Applies a child handler to set upload options for this file item.
   *
   * @param handler The child handler for configuring upload options.
   * @return This {@code FileItem} instance to allow method chaining.
   */
  public FileItem withOptions(ChildHandler<FileItem, UploadOptions> handler) {
    handler.apply(this, options);
    return this;
  }

  /**
   * Retrieves the upload options associated with this file item.
   *
   * @return The upload options.
   */
  public UploadOptions getOptions() {
    return options;
  }

  public void upload() {
    if (nonNull(requestSender)) {
      upload(requestSender);
    } else {
      upload(XMLHttpRequest::send);
    }
  }

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

  /** Resets the state of the file item, clearing canceled and removed flags. */
  private void resetState() {
    canceled = false;
    removed = false;
  }

  /**
   * Checks whether the file size exceeds the maximum allowed size.
   *
   * @return {@code true} if the file size exceeds the maximum allowed size, otherwise {@code
   *     false}.
   */
  public boolean isExceedsMaxFile() {
    return options.getMaxFileSize() > 0 && file.size > options.getMaxFileSize();
  }

  /** Handles the success of the file upload, triggering success-related actions. */
  private void onSuccess() {
    uploaded = true;
    filePreview.onUploadSuccess();
    successUploadHandlers.forEach(handler -> handler.onSuccessUpload(request));
  }

  /** Handles errors during the file upload, triggering error-related actions. */
  private void onError() {
    filePreview.onUploadFailed(getErrorMessage());
    errorHandlers.forEach(handler -> handler.onError(request));
  }

  /**
   * Retrieves the error message from the upload response or provides a default message.
   *
   * @return The error message, or a default message if none is available.
   */
  private String getErrorMessage() {
    final boolean hasErrorText =
        request.responseType != null
            && (request.responseType.isEmpty() || request.responseType.equals("text"))
            && !request.responseText.isEmpty();
    return hasErrorText ? request.responseText : "Error while sending request";
  }

  /**
   * Removes the file item from the DOM and marks it as removed.
   *
   * @return This FileItem instance for method chaining.
   */
  @Override
  public FileItem remove() {
    super.remove();
    this.removed = true;
    removeHandlers.forEach(handler -> handler.onRemoveFile(file));
    return this;
  }

  /**
   * Sets the URL to which the file will be uploaded.
   *
   * @param url The URL to set for the file upload.
   * @return This FileItem instance for method chaining.
   */
  public FileItem setUrl(String url) {
    options.setUrl(url);
    return this;
  }

  /**
   * Gets the name of the file.
   *
   * @return The name of the file.
   */
  public String getFileName() {
    return fileName;
  }

  /**
   * Sets the name of the file.
   *
   * @param fileName The name to set for the file.
   */
  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  /**
   * Gets a list of handlers for file removal events.
   *
   * @return A list of RemoveFileHandler instances.
   */
  public List<RemoveFileHandler> getRemoveHandlers() {
    return removeHandlers;
  }

  /**
   * Gets a list of handlers for file error events.
   *
   * @return A list of ErrorHandler instances.
   */
  public List<ErrorHandler> getErrorHandlers() {
    return errorHandlers;
  }

  /**
   * Gets a list of handlers for file progress events.
   *
   * @return A list of ProgressHandler instances.
   */
  public List<ProgressHandler> getProgressHandlers() {
    return progressHandlers;
  }

  /**
   * Gets a list of handlers for before upload events.
   *
   * @return A list of BeforeUploadHandler instances.
   */
  public List<BeforeUploadHandler> getBeforeUploadHandlers() {
    return beforeUploadHandlers;
  }

  /**
   * Gets a list of handlers for successful file upload events.
   *
   * @return A list of SuccessUploadHandler instances.
   */
  public List<SuccessUploadHandler> getSuccessUploadHandlers() {
    return successUploadHandlers;
  }

  /**
   * Cancels the file upload by aborting the associated request if it exists.
   *
   * @return This FileItem instance for method chaining.
   */
  public FileItem cancel() {
    canceled = true;
    if (request != null) {
      request.abort();
    }
    return this;
  }

  /**
   * Gets a list of handlers for cancel events during file upload.
   *
   * @return A list of CancelHandler instances.
   */
  public List<CancelHandler> getCancelHandlers() {
    return cancelHandlers;
  }

  /**
   * Checks if the file upload has been canceled.
   *
   * @return {@code true} if the file upload has been canceled, otherwise {@code false}.
   */
  public boolean isCanceled() {
    return canceled;
  }

  /**
   * Checks if the file item has been removed from the DOM.
   *
   * @return {@code true} if the file item has been removed, otherwise {@code false}.
   */
  public boolean isRemoved() {
    return removed;
  }

  /**
   * Checks if the file has been successfully uploaded.
   *
   * @return {@code true} if the file has been successfully uploaded, otherwise {@code false}.
   */
  public boolean isUploaded() {
    return uploaded;
  }

  /**
   * Validates the size of the file and displays an error message if it exceeds the maximum allowed
   * size.
   *
   * @see #isExceedsMaxFile()
   */
  public void validateSize() {
    if (isExceedsMaxFile()) {
      filePreview.onUploadFailed(
          "File is too large, maximum file size is " + formatSize(options.getMaxFileSize()));
    }
  }

  /**
   * Gets the parent FileUpload component to which this file item belongs.
   *
   * @return The parent FileUpload instance.
   */
  public FileUpload getFileUpload() {
    return fileUpload;
  }

  /** Functional interface for handling file removal events. */
  @FunctionalInterface
  public interface RemoveFileHandler {
    /**
     * Handles the removal of a file.
     *
     * @param file The removed file.
     */
    void onRemoveFile(File file);
  }

  /** Functional interface for handling file error events. */
  @FunctionalInterface
  public interface ErrorHandler {
    /**
     * Handles errors that occur during file upload.
     *
     * @param request The XMLHttpRequest associated with the error.
     */
    void onError(XMLHttpRequest request);
  }

  /** Functional interface for handling file progress events. */
  @FunctionalInterface
  public interface ProgressHandler {
    /**
     * Handles progress events during file upload.
     *
     * @param loaded The number of bytes loaded.
     * @param request The XMLHttpRequest associated with the progress event.
     */
    void onProgress(double loaded, XMLHttpRequest request);
  }

  /** Functional interface for handling before upload events. */
  @FunctionalInterface
  public interface BeforeUploadHandler {
    /**
     * Handles events that occur just before the file upload starts.
     *
     * @param request The XMLHttpRequest associated with the upload.
     * @param formData The FormData containing the file to be uploaded.
     */
    void onBeforeUpload(XMLHttpRequest request, FormData formData);
  }

  /** Functional interface for handling successful file upload events. */
  @FunctionalInterface
  public interface SuccessUploadHandler {
    /**
     * Handles successful file upload events.
     *
     * @param request The XMLHttpRequest associated with the successful upload.
     */
    void onSuccessUpload(XMLHttpRequest request);
  }

  /** Functional interface for handling file upload cancellation events. */
  @FunctionalInterface
  public interface CancelHandler {
    /**
     * Handles file upload cancellation events.
     *
     * @param request The XMLHttpRequest associated with the canceled upload.
     */
    void onCancel(XMLHttpRequest request);
  }
}
