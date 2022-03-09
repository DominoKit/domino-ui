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
import static org.jboss.elemento.Elements.h;

import elemental2.core.JsNumber;
import elemental2.dom.*;
import java.util.ArrayList;
import java.util.List;
import org.dominokit.domino.ui.Typography.Paragraph;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.popover.PopupPosition;
import org.dominokit.domino.ui.popover.Tooltip;
import org.dominokit.domino.ui.progress.Progress;
import org.dominokit.domino.ui.progress.ProgressBar;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.thumbnails.Thumbnail;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.Elements;

/**
 * A component representing the upload file
 *
 * @see BaseDominoElement
 * @see FileUpload
 */
public class FileItem extends BaseDominoElement<HTMLDivElement, FileItem> {
  private static final String[] UNITS = {"KB", "MB", "GB", "TB"};
  private static final String ELLIPSIS_TEXT = "ellipsis-text";

  private final Thumbnail thumbnail = Thumbnail.create();
  private FileImage fileImage;
  private HTMLParagraphElement fileSizeParagraph;
  private HTMLHeadingElement fileNameTitleContainer;
  private final HTMLDivElement footerContainer = Elements.div().element();
  private final HTMLElement messageContainer =
      DominoElement.of(Elements.p()).css(ELLIPSIS_TEXT).element();
  private HTMLDivElement progressElement;
  private ProgressBar progressBar;
  private final HTMLElement deleteIcon = Icons.ALL.delete().element();
  private final HTMLElement cancelIcon = Icons.ALL.cancel().element();
  private final HTMLElement refreshIcon = Icons.ALL.refresh().element();

  private final File file;
  private final UploadOptions options;

  private final List<RemoveFileHandler> removeHandlers = new ArrayList<>();
  private final List<ErrorHandler> errorHandlers = new ArrayList<>();
  private final List<ProgressHandler> progressHandlers = new ArrayList<>();
  private final List<BeforeUploadHandler> beforeUploadHandlers = new ArrayList<>();
  private final List<SuccessUploadHandler> successUploadHandlers = new ArrayList<>();
  private final List<CancelHandler> cancelHandlers = new ArrayList<>();
  private String successMessage;
  private String errorMessage;
  private XMLHttpRequest request;
  private boolean canceled;
  private boolean removed;
  private boolean uploaded;
  private String fileName;
  private UploadRequestSender requestSender;
  private Tooltip tooltip;

  /**
   * @param file the {@link File}
   * @param options the {@link UploadOptions}
   * @return new instance
   */
  public static FileItem create(File file, UploadOptions options) {
    return new FileItem(file, options);
  }

  public FileItem(File file, UploadOptions options) {
    this.file = file;
    this.options = options;
    initFileImage();
    initFileTitle();
    initFileSizeParagraph();
    initFooter();
    initProgress();
    initThumbnail();

    if (isExceedsMaxFile()) {
      invalidate("File is too large, maximum file size is " + formatSize(options.getMaxFileSize()));
    }

    init(this);
    this.fileName = file.name;
  }

  private void initFileImage() {
    if (isImage()) fileImage = FileImage.createImageFile(file);
    else fileImage = FileImage.createDefault();
  }

  /** @return true if the uploaded file is image */
  public boolean isImage() {
    return file.type.startsWith("image");
  }

  private void initFileTitle() {
    fileNameTitleContainer =
        DominoElement.of(h(3)).css(ELLIPSIS_TEXT).textContent(file.name).element();
    fileNameTitleContainer.style.margin = CSSProperties.MarginUnionType.of("0px");
    Tooltip.create(fileNameTitleContainer, file.name);
  }

  private void initFileSizeParagraph() {
    fileSizeParagraph = Paragraph.create("File size : " + readableFileSize()).element();
  }

  private void initFooter() {
    initDeleteIcon();
    initCancelIcon();
    initRefreshIcon();
    initMessageContainer();
    footerContainer.style.display = "inline-block";
    footerContainer.style.width = CSSProperties.WidthUnionType.of("100%");
    footerContainer.style.height = CSSProperties.HeightUnionType.of("25px");
    footerContainer.appendChild(deleteIcon);
    footerContainer.appendChild(cancelIcon);
    footerContainer.appendChild(refreshIcon);
    footerContainer.appendChild(messageContainer);
  }

  private void initDeleteIcon() {
    deleteIcon.style.cssFloat = "right";
    deleteIcon.style.cursor = "pointer";
    deleteIcon.addEventListener("click", evt -> remove());
  }

  private void initCancelIcon() {
    cancelIcon.style.cssFloat = "right";
    cancelIcon.style.cursor = "pointer";
    cancelIcon.addEventListener("click", evt -> cancel());
    hideCancelIcon();
  }

  private void initRefreshIcon() {
    refreshIcon.style.cssFloat = "right";
    refreshIcon.style.cursor = "pointer";
    refreshIcon.addEventListener(
        "click",
        evt -> {
          if (nonNull(requestSender)) {
            upload(requestSender);
          } else {
            upload();
          }
        });
    hideRefreshIcon();
  }

  private void initMessageContainer() {
    messageContainer.style.height = CSSProperties.HeightUnionType.of("20px");
  }

  private void initProgress() {
    progressBar = ProgressBar.create(file.size);
    progressElement = Progress.create().appendChild(progressBar).element();
    progressElement.style.marginBottom = CSSProperties.MarginBottomUnionType.of("0px");
    progressElement.style.height = CSSProperties.HeightUnionType.of("5px");
  }

  private void initThumbnail() {
    thumbnail.element().appendChild(fileImage.element());
    thumbnail.appendCaptionChild(fileNameTitleContainer);
    thumbnail.appendCaptionChild(fileSizeParagraph);
    thumbnail.appendCaptionChild(footerContainer);
    thumbnail.appendCaptionChild(progressElement);
    thumbnail.getContentElement().style().cssText("cursor: default !important").setPadding("5px");
    thumbnail.getContentElement().remove();
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return thumbnail.element();
  }

  private void setThumbnailBorder(Color red) {
    thumbnail.element().style.border = "1px solid " + red.getHex();
  }

  /** @return the {@link File} */
  public File getFile() {
    return file;
  }

  /**
   * The title of the file size
   *
   * @param sizeTitle the title
   * @return same instance
   */
  public FileItem setSizeTitle(String sizeTitle) {
    fileSizeParagraph.textContent = sizeTitle;
    return this;
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

  private void updateProgress(double loaded) {
    progressBar.setValue(loaded);
    progressHandlers.forEach(handler -> handler.onProgress(loaded, request));
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

      request = new XMLHttpRequest();
      request.upload.addEventListener(
          "loadstart",
          evt -> {
            hideRefreshIcon();
            hideDeleteIcon();
            showCancelIcon();
          });

      request.upload.addEventListener(
          "loadend",
          evt -> {
            hideCancelIcon();
            showDeleteIcon();
          });

      request.upload.onprogress =
          p0 -> {
            if (p0.lengthComputable) updateProgress(p0.loaded);
          };

      request.onabort =
          p0 -> {
            showRefreshIcon();
            showDeleteIcon();
            resetProgress();
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

  private void showRefreshIcon() {
    refreshIcon.style.display = "inline-block";
  }

  private void hideRefreshIcon() {
    refreshIcon.style.display = "none";
  }

  private void hideDeleteIcon() {
    deleteIcon.style.display = "none";
  }

  private void showDeleteIcon() {
    deleteIcon.style.display = "inline-block";
  }

  private void showCancelIcon() {
    cancelIcon.style.display = "inline-block";
  }

  private void hideCancelIcon() {
    cancelIcon.style.display = "none";
  }

  private void resetState() {
    thumbnail.element().style.border = "1px solid #ddd";
    messageContainer.textContent = "";
    canceled = false;
    removed = false;
    updateProgress(0);
    updateProgressBackground(Color.BLUE);
  }

  private boolean isExceedsMaxFile() {
    return options.getMaxFileSize() > 0 && file.size > options.getMaxFileSize();
  }

  private void resetProgress() {
    progressBar.setValue(0);
  }

  private void onSuccess() {
    uploaded = true;
    setThumbnailBorder(Color.GREEN);
    updateProgressBackground(Color.GREEN);
    updateProgress(file.size);
    setMessage(getSuccessMessage(), Color.GREEN);
    successUploadHandlers.forEach(handler -> handler.onSuccessUpload(request));
  }

  private String getSuccessMessage() {
    return successMessage == null ? "Uploaded successfully" : successMessage;
  }

  private void onError() {
    invalidate(getErrorMessage());
    updateProgressBackground(Color.RED);
    errorHandlers.forEach(handler -> handler.onError(request));
    showRefreshIcon();
    showDeleteIcon();
  }

  private String getErrorMessage() {
    if (errorMessage != null) return errorMessage;

    final boolean hasErrorText =
        request.responseType != null
            && (request.responseType.isEmpty() || request.responseType.equals("text"))
            && !request.responseText.isEmpty();
    return hasErrorText ? request.responseText : "Error while sending request";
  }

  /**
   * Invalidates the file preview with an error message
   *
   * @param message the error message
   */
  public void invalidate(String message) {
    setThumbnailBorder(Color.RED);
    setMessage(message, Color.RED);
  }

  private void setMessage(String message, Color color) {
    messageContainer.textContent = message;
    messageContainer.style.color = color.getHex();
    if (nonNull(tooltip)) {
      tooltip.setContent(DomGlobal.document.createTextNode(message));
    } else {
      tooltip = Tooltip.create(messageContainer, message).position(PopupPosition.BOTTOM);
    }
  }

  private void updateProgressBackground(Color background) {
    progressBar.setBackground(background);
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

  /** @return the {@link FileImage} element */
  public FileImage getFileImage() {
    return fileImage;
  }

  /** @return the file size element */
  public DominoElement<HTMLParagraphElement> getFileSizeParagraph() {
    return DominoElement.of(fileSizeParagraph);
  }

  /** @return the file name container */
  public DominoElement<HTMLHeadingElement> getFileNameTitleContainer() {
    return DominoElement.of(fileNameTitleContainer);
  }

  /** @return the footer container */
  public DominoElement<HTMLDivElement> getFooterContainer() {
    return DominoElement.of(footerContainer);
  }

  /** @return the delete icon */
  public DominoElement<HTMLElement> getDeleteIcon() {
    return DominoElement.of(deleteIcon);
  }

  /** @return the message container */
  public DominoElement<HTMLElement> getMessageContainer() {
    return DominoElement.of(messageContainer);
  }

  /** @return the progress element */
  public DominoElement<HTMLDivElement> getProgressElement() {
    return DominoElement.of(progressElement);
  }

  /** @return the {@link ProgressBar} */
  public ProgressBar getProgressBar() {
    return progressBar;
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
   * Sets the message to be shown when the file is uploaded
   *
   * @param successMessage the message
   * @return same instance
   */
  public FileItem setSuccessUploadMessage(String successMessage) {
    this.successMessage = successMessage;
    return this;
  }

  /**
   * Sets the message to be shown when uploading file fails
   *
   * @param errorMessage the message
   * @return same instance
   */
  public FileItem setErrorUploadMessage(String errorMessage) {
    this.errorMessage = errorMessage;
    return this;
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

  /** @return the cancel icon */
  public DominoElement<HTMLElement> getCancelIcon() {
    return DominoElement.of(cancelIcon);
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
