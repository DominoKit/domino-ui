///*
// * Copyright © 2019 Dominokit
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *     http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//package org.dominokit.domino.ui.upload;
//
//import static java.util.Objects.nonNull;
//import static org.jboss.elemento.Elements.div;
//import static org.jboss.elemento.Elements.input;
//
//import elemental2.dom.*;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//import java.util.function.Supplier;
//import jsinterop.base.Js;
//import org.dominokit.domino.ui.grid.Column;
//import org.dominokit.domino.ui.grid.Row;
//import org.dominokit.domino.ui.grid.Row_12;
//import org.dominokit.domino.ui.icons.BaseIcon;
//import org.dominokit.domino.ui.notifications.Notification;
//import org.dominokit.domino.ui.utils.BaseDominoElement;
//import org.dominokit.domino.ui.utils.DominoElement;
//import org.dominokit.domino.ui.utils.HasName;
//import org.jboss.elemento.IsElement;
//
///**
// * A component for uploading files (photos, documents or any other file type) from local storage
// *
// * @see BaseDominoElement
// * @see HasName
// */
//public class FileUpload extends BaseDominoElement<HTMLDivElement, FileUpload>
//    implements HasName<FileUpload> {
//
//  private final Row<Row_12> row = Row.create();
//  private int thumbSpanXLarge = 2;
//  private int thumbSpanLarge = 2;
//  private int thumbSpanMedium = 4;
//  private int thumbSpanSmall = 6;
//  private int thumbSpanXSmall = 12;
//
//  private int thumbOffsetXLarge = -1;
//  private int thumbOffsetLarge = -1;
//  private int thumbOffsetMedium = -1;
//  private int thumbOffsetSmall = -1;
//  private int thumbOffsetXSmall = -1;
//
//  private final DominoElement<HTMLDivElement> formElement =
//      DominoElement.of(div()).css("file-upload");
//  private final DominoElement<HTMLDivElement> uploadMessageContainer =
//      DominoElement.of(div()).css("file-upload-message");
//  private final DominoElement<HTMLDivElement> uploadIconContainer =
//      DominoElement.of(div()).css("file-upload-message-icon");
//  private HTMLInputElement hiddenFileInput;
//  private final DominoElement<HTMLDivElement> filesContainer = DominoElement.of(div());
//  private final List<FileItem> addedFileItems = new ArrayList<>();
//  private double maxFileSize;
//  private String url;
//
//  private final List<OnAddFileHandler> onAddFileHandlers = new ArrayList<>();
//  private boolean autoUpload = true;
//  private boolean singleFile = false;
//  private String errorMessage = "Only one file is allowed to be uploaded";
//
//  private Supplier<List<Integer>> successCodesProvider =
//      () -> Arrays.asList(200, 201, 202, 203, 204, 205, 206, 207, 208, 226);
//
//  private UploadRequestSender requestSender = (XMLHttpRequest::send);
//
//  private Optional<DropEffect> dropEffect = Optional.empty();
//
//  public FileUpload() {
//    uploadMessageContainer.appendChild(uploadIconContainer);
//    createHiddenInput();
//    formElement.appendChild(uploadMessageContainer);
//    formElement.appendChild(filesContainer);
//
//    hiddenFileInput.addEventListener(
//        "change",
//        evt -> {
//          uploadFiles(hiddenFileInput.files);
//        });
//    uploadMessageContainer.addEventListener("click", evt -> hiddenFileInput.click());
//    formElement.addEventListener(
//        "drop",
//        evt -> {
//          FileList files = ((DragEvent) evt).dataTransfer.files;
//          if (dropEffect.isPresent() && files.length > 0) {
//            ((DragEvent) evt).dataTransfer.dropEffect = dropEffect.get().getEffect();
//          }
//          if (!singleFile || files.length == 1) {
//            uploadFiles(files);
//          } else {
//            notifySingleFileError();
//          }
//          removeHover();
//          evt.stopPropagation();
//          evt.preventDefault();
//        });
//    formElement.addEventListener(
//        "dragover",
//        evt -> {
//          dropEffect.ifPresent(
//              effect -> ((DragEvent) evt).dataTransfer.dropEffect = effect.getEffect());
//          addHover();
//          evt.stopPropagation();
//          evt.preventDefault();
//        });
//    formElement.addEventListener(
//        "dragleave",
//        evt -> {
//          dropEffect.ifPresent(
//              effect -> ((DragEvent) evt).dataTransfer.dropEffect = effect.getEffect());
//          if (isFormUploadElement(evt.target)) removeHover();
//          evt.stopPropagation();
//          evt.preventDefault();
//        });
//    filesContainer.appendChild(row.element());
//    init(this);
//  }
//
//  /**
//   * Sets the sender of the upload request when the request is ready to be sent
//   *
//   * @param requestSender the {@link UploadRequestSender}
//   * @return same instance
//   */
//  public FileUpload setRequestSender(UploadRequestSender requestSender) {
//    if (nonNull(requestSender)) {
//      this.requestSender = requestSender;
//    }
//    return this;
//  }
//
//  private void notifySingleFileError() {
//    Notification.createWarning(errorMessage).show();
//  }
//
//  private boolean isFormUploadElement(EventTarget target) {
//    HTMLElement element = Js.uncheckedCast(target);
//    return element == formElement.element();
//  }
//
//  private void addHover() {
//    formElement.addCss("file-upload-hover");
//  }
//
//  private void uploadFiles(FileList files) {
//    if (singleFile) {
//      addedFileItems.forEach(FileItem::remove);
//      addedFileItems.clear();
//    }
//    for (int i = 0; i < files.length; i++) {
//      File file = files.item(i);
//      addFilePreview(file);
//    }
//    hiddenFileInput.value = "";
//  }
//
//  /** Sends the requests for uploading all files */
//  public void uploadAllFiles() {
//    addedFileItems.forEach(fileItem -> fileItem.upload(requestSender));
//  }
//
//  private void addFilePreview(File file) {
//    FileItem fileItem =
//        FileItem.create(file, new UploadOptions(url, maxFileSize, successCodesProvider));
//    Column previewColumn =
//        Column.span(
//                thumbSpanXLarge, thumbSpanLarge, thumbSpanMedium, thumbSpanSmall, thumbSpanXSmall)
//            .appendChild(fileItem.element());
//
//    if (thumbOffsetXLarge >= 0) {
//      previewColumn.onXLargeOffset(Column.OnXLargeOffset.of(thumbOffsetXLarge));
//    }
//    if (thumbOffsetLarge >= 0) {
//      previewColumn.onLargeOffset(Column.OnLargeOffset.of(thumbOffsetLarge));
//    }
//    if (thumbOffsetMedium >= 0) {
//      previewColumn.onMediumOffset(Column.OnMediumOffset.of(thumbOffsetMedium));
//    }
//    if (thumbOffsetSmall >= 0) {
//      previewColumn.onSmallOffset(Column.OnSmallOffset.of(thumbOffsetSmall));
//    }
//    if (thumbOffsetXSmall >= 0) {
//      previewColumn.onXSmallOffset(Column.OnXSmallOffset.of(thumbOffsetXSmall));
//    }
//
//    row.appendChild(previewColumn);
//    addedFileItems.add(fileItem);
//
//    fileItem.addRemoveHandler(
//        removedFile -> {
//          previewColumn.element().remove();
//          addedFileItems.remove(fileItem);
//        });
//
//    onAddFileHandlers.forEach(handler -> handler.onAddFile(fileItem));
//
//    if (fileItem.isCanceled()) {
//      fileItem.remove();
//    }
//
//    if (autoUpload && !fileItem.isCanceled() && !fileItem.isRemoved()) {
//      fileItem.upload(requestSender);
//    }
//  }
//
//  private void removeHover() {
//    formElement.removeCss("file-upload-hover");
//  }
//
//  private void createHiddenInput() {
//    hiddenFileInput =
//        input("file")
//            .style(
//                "visibility: hidden; position: absolute; top: 0px; left: 0px; height: 0px; width: 0px;")
//            .element();
//    DomGlobal.document.body.appendChild(hiddenFileInput);
//  }
//
//  /** @return new instance */
//  public static FileUpload create() {
//    return new FileUpload();
//  }
//
//  /** {@inheritDoc} */
//  @Override
//  public HTMLDivElement element() {
//    return formElement.element();
//  }
//
//  /** {@inheritDoc} */
//  @Override
//  public FileUpload appendChild(Node child) {
//    uploadMessageContainer.appendChild(child);
//    return this;
//  }
//
//  /** {@inheritDoc} */
//  @Override
//  public FileUpload appendChild(IsElement<?> child) {
//    return appendChild(child.element());
//  }
//
//  /**
//   * Enables multiple files upload
//   *
//   * @return same instance
//   */
//  public FileUpload multipleFiles() {
//    hiddenFileInput.multiple = true;
//    this.singleFile = false;
//    return this;
//  }
//
//  /**
//   * Enables uploading only a single file
//   *
//   * @return same instance
//   */
//  public FileUpload singleFile() {
//    hiddenFileInput.multiple = false;
//    this.singleFile = true;
//    return this;
//  }
//
//  /**
//   * Sets the accepted files extensions
//   *
//   * @param acceptedFiles a comma separated string containing all the accepted file extensions
//   * @return same instance
//   */
//  public FileUpload accept(String acceptedFiles) {
//    hiddenFileInput.accept = acceptedFiles;
//    return this;
//  }
//
//  /**
//   * Sets the maximum accepted file size
//   *
//   * @param maxFileSize the maximum size of the file
//   * @return same instance
//   */
//  public FileUpload maxFileSize(double maxFileSize) {
//    this.maxFileSize = maxFileSize;
//    return this;
//  }
//
//  /**
//   * Sets the url for uploading the files to
//   *
//   * @param url the url of the server
//   * @return same instance
//   */
//  public FileUpload setUrl(String url) {
//    this.url = url;
//    addedFileItems.forEach(fileItem -> fileItem.setUrl(url));
//    return this;
//  }
//
//  /**
//   * Sets a handler to be called when file is added
//   *
//   * @param onAddFileHandler a {@link OnAddFileHandler}
//   * @return same instance
//   */
//  public FileUpload onAddFile(OnAddFileHandler onAddFileHandler) {
//    onAddFileHandlers.add(onAddFileHandler);
//    return this;
//  }
//
//  /**
//   * Sets that the file should be automatically uploaded when the user adds it
//   *
//   * @return same instance
//   */
//  public FileUpload autoUpload() {
//    this.autoUpload = true;
//    return this;
//  }
//
//  /**
//   * Sets that the file should be uploaded only when calling {@link
//   * FileUpload#uploadFiles(FileList)} or {@link FileUpload#uploadAllFiles()}
//   *
//   * @return same instance
//   */
//  public FileUpload manualUpload() {
//    this.autoUpload = false;
//    return this;
//  }
//
//  /** @return the files container */
//  public Row<Row_12> getRow() {
//    return row;
//  }
//
//  /** @return The form element */
//  public DominoElement<HTMLDivElement> getFormElement() {
//    return DominoElement.of(formElement);
//  }
//
//  /** @return the upload message container */
//  public DominoElement<HTMLDivElement> getUploadMessageContainer() {
//    return DominoElement.of(uploadMessageContainer);
//  }
//
//  /** @return the upload icon container */
//  public DominoElement<HTMLDivElement> getUploadIconContainer() {
//    return DominoElement.of(uploadIconContainer);
//  }
//
//  /** @return the hidden file input element */
//  public DominoElement<HTMLInputElement> getHiddenFileInput() {
//    return DominoElement.of(hiddenFileInput);
//  }
//
//  /** @return the files container */
//  public DominoElement<HTMLDivElement> getFilesContainer() {
//    return DominoElement.of(filesContainer);
//  }
//
//  /** @return the added file items */
//  public List<FileItem> getAddedFileItems() {
//    return addedFileItems;
//  }
//
//  /** @return the maximum accepted file size */
//  public double getMaxFileSize() {
//    return maxFileSize;
//  }
//
//  /** @return the url for the server */
//  public String getUrl() {
//    return url;
//  }
//
//  /** @return all {@link OnAddFileHandler} defined */
//  public List<OnAddFileHandler> getOnAddFileHandlers() {
//    return onAddFileHandlers;
//  }
//
//  /** @return true if auto upload is set, false otherwise */
//  public boolean isAutoUpload() {
//    return autoUpload;
//  }
//
//  /** {@inheritDoc} */
//  @Override
//  public String getName() {
//    return hiddenFileInput.name;
//  }
//
//  /**
//   * Sets the upload icon
//   *
//   * @param icon a {@link BaseIcon}
//   * @return same instance
//   */
//  public FileUpload setIcon(BaseIcon<?> icon) {
//    uploadIconContainer.appendChild(icon);
//    return this;
//  }
//
//  /**
//   * Sets the column span for a file preview
//   *
//   * @param xLarge the span when the screen is X large
//   * @param large the span when the screen is Large
//   * @param medium the span when the screen is Medium
//   * @param small the span when the screen is Small
//   * @param xSmall the span when the screen is X small
//   * @return same instance
//   */
//  public FileUpload setThumbSpans(int xLarge, int large, int medium, int small, int xSmall) {
//    this.thumbSpanXLarge = xLarge;
//    this.thumbSpanLarge = large;
//    this.thumbSpanMedium = medium;
//    this.thumbSpanSmall = small;
//    this.thumbSpanXSmall = xSmall;
//    return this;
//  }
//
//  /**
//   * Sets the column offset for a file preview
//   *
//   * @param xLarge the offset when the screen is X large
//   * @param large the offset when the screen is Large
//   * @param medium the offset when the screen is Medium
//   * @param small the offset when the screen is Small
//   * @param xSmall the offset when the screen is X small
//   * @return same instance
//   */
//  public FileUpload setThumbOffset(int xLarge, int large, int medium, int small, int xSmall) {
//    this.thumbOffsetXLarge = xLarge;
//    this.thumbOffsetLarge = large;
//    this.thumbOffsetMedium = medium;
//    this.thumbOffsetSmall = small;
//    this.thumbOffsetXSmall = xSmall;
//    return this;
//  }
//
//  /**
//   * Sets the success codes for upload files
//   *
//   * @param successCodesProvider a {@link Supplier} for getting the success codes
//   */
//  public void setSuccessCodesProvider(Supplier<List<Integer>> successCodesProvider) {
//    this.successCodesProvider = successCodesProvider;
//  }
//
//  /** {@inheritDoc} */
//  @Override
//  public FileUpload setName(String name) {
//    hiddenFileInput.name = name;
//    return this;
//  }
//
//  /**
//   * Sets the error message when uploading file fails
//   *
//   * @param errorMessage the error message
//   * @return same instance
//   */
//  public FileUpload setSingleFileErrorMessage(String errorMessage) {
//    this.errorMessage = errorMessage;
//    return this;
//  }
//
//  /** @return the {@link DropEffect} configured */
//  public Optional<DropEffect> getDropEffect() {
//    return dropEffect;
//  }
//
//  /**
//   * Sets the drop effect
//   *
//   * @param dropEffect the {@link DropEffect}
//   * @return same instance
//   */
//  public FileUpload setDropEffect(DropEffect dropEffect) {
//    if (nonNull(dropEffect)) {
//      this.dropEffect = Optional.of(dropEffect);
//    }
//    return this;
//  }
//
//  /** A handler to be called when file is added */
//  @FunctionalInterface
//  public interface OnAddFileHandler {
//    /** @param fileItem the added {@link FileItem} */
//    void onAddFile(FileItem fileItem);
//  }
//}
