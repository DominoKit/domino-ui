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
import static org.dominokit.domino.ui.utils.DominoUIConfig.CONFIG;

import elemental2.dom.DragEvent;
import elemental2.dom.Element;
import elemental2.dom.File;
import elemental2.dom.FileList;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.XMLHttpRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import jsinterop.base.Js;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.config.HasComponentConfig;
import org.dominokit.domino.ui.config.UploadConfig;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.InputElement;
import org.dominokit.domino.ui.i18n.HasLabels;
import org.dominokit.domino.ui.i18n.UploadLabels;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasName;
import org.dominokit.domino.ui.utils.LazyChild;

/**
 * A component for uploading files (photos, documents or any other file type) from local storage
 *
 * @see BaseDominoElement
 * @see HasName
 * @author vegegoku
 * @version $Id: $Id
 */
public class FileUpload extends BaseDominoElement<HTMLDivElement, FileUpload>
    implements HasName<FileUpload>,
        FileUploadStyles,
        HasComponentConfig<UploadConfig>,
        HasLabels<UploadLabels> {

  /** Constant <code>DEFAULT_SUCCESS_CODES</code> */
  public static final Supplier<List<Integer>> DEFAULT_SUCCESS_CODES =
      () -> Arrays.asList(200, 201, 202, 203, 204, 205, 206, 207, 208, 226);

  private final DivElement root;
  private final DivElement messagesContainer;

  private final InputElement hiddenFileInput;
  private final FilePreviewContainer<?, ?> filesContainer;
  private final List<FileItem> addedFileItems = new ArrayList<>();
  private final FilePreviewFactory filePreviewFactory;
  private LazyChild<DominoElement<Element>> decoration;
  private final List<FileItemHandler> fileItemHandlers = new ArrayList<>();
  private boolean autoUpload = true;
  private int maxAllowedUploads = Integer.MAX_VALUE;

  private UploadRequestSender requestSender = (XMLHttpRequest::send);

  private DropEffect dropEffect;

  /** @return new instance */
  /**
   * create.
   *
   * @return a {@link org.dominokit.domino.ui.upload.FileUpload} object
   */
  public static FileUpload create() {
    return new FileUpload();
  }

  /** @return new instance */
  /**
   * create.
   *
   * @param filePreviewFactory a {@link org.dominokit.domino.ui.upload.FilePreviewFactory} object
   * @param filePreviewContainer a {@link org.dominokit.domino.ui.upload.FilePreviewContainer}
   *     object
   * @return a {@link org.dominokit.domino.ui.upload.FileUpload} object
   */
  public static FileUpload create(
      FilePreviewFactory filePreviewFactory, FilePreviewContainer<?, ?> filePreviewContainer) {
    return new FileUpload(filePreviewFactory, filePreviewContainer);
  }

  /** @return new instance */
  /**
   * create.
   *
   * @param filePreviewContainer a {@link org.dominokit.domino.ui.upload.FilePreviewContainer}
   *     object
   * @return a {@link org.dominokit.domino.ui.upload.FileUpload} object
   */
  public static FileUpload create(FilePreviewContainer<?, ?> filePreviewContainer) {
    return new FileUpload(CONFIG.getUIConfig().getFilePreviewFactory(), filePreviewContainer);
  }

  /** @return new instance */
  /**
   * create.
   *
   * @param filePreviewFactory a {@link org.dominokit.domino.ui.upload.FilePreviewFactory} object
   * @return a {@link org.dominokit.domino.ui.upload.FileUpload} object
   */
  public static FileUpload create(FilePreviewFactory filePreviewFactory) {
    return new FileUpload(filePreviewFactory);
  }

  /** @return new instance */
  /**
   * create.
   *
   * @param filePreviewFactory a {@link org.dominokit.domino.ui.upload.FilePreviewFactory} object
   * @param filePreviewContainer a {@link org.dominokit.domino.ui.upload.FilePreviewContainer}
   *     object
   * @param decoration a {@link org.dominokit.domino.ui.IsElement} object
   * @return a {@link org.dominokit.domino.ui.upload.FileUpload} object
   */
  public static FileUpload create(
      FilePreviewFactory filePreviewFactory,
      FilePreviewContainer<?, ?> filePreviewContainer,
      IsElement<?> decoration) {
    return new FileUpload(filePreviewFactory, filePreviewContainer, decoration);
  }

  /**
   * Constructor for FileUpload.
   *
   * @param filePreviewFactory a {@link org.dominokit.domino.ui.upload.FilePreviewFactory} object
   * @param filePreviewContainer a {@link org.dominokit.domino.ui.upload.FilePreviewContainer}
   *     object
   */
  public FileUpload(
      FilePreviewFactory filePreviewFactory, FilePreviewContainer<?, ?> filePreviewContainer) {
    this.filePreviewFactory = filePreviewFactory;
    root =
        div()
            .addCss(dui_file_upload)
            .appendChild(messagesContainer = div().addCss(dui_file_upload_messages))
            .appendChild(hiddenFileInput = input("file").addCss(dui_file_upload_input))
            .appendChild(filesContainer = filePreviewContainer);
    elementOf(filesContainer.element()).addCss(dui_file_preview_container);
    init(this);
    root.addClickListener(evt -> hiddenFileInput.element().click());
    hiddenFileInput.addEventListener("change", evt -> uploadFiles(hiddenFileInput.element().files));
    root.addEventListener(
        "drop",
        evt -> {
          evt.stopPropagation();
          evt.preventDefault();

          FileList files = ((DragEvent) evt).dataTransfer.files;
          Optional.ofNullable(dropEffect)
              .ifPresent(
                  effect -> {
                    if (files.length > 0) {
                      ((DragEvent) evt).dataTransfer.dropEffect = effect.getEffect();
                    }
                  });
          int maxAllowed = hiddenFileInput.element().multiple ? maxAllowedUploads : 1;
          if (maxAllowed > files.length) {
            messagesContainer
                .clearElement()
                .setTextContent(getLabels().getMaxFileErrorMessage(maxAllowed, files.length));
          } else {
            uploadFiles(files);
          }
          removeHover();
        });
    root.addEventListener(
        "dragover",
        evt -> {
          evt.stopPropagation();
          evt.preventDefault();
          Optional.ofNullable(dropEffect)
              .ifPresent(effect -> ((DragEvent) evt).dataTransfer.dropEffect = effect.getEffect());
          addHover();
        });
    root.addEventListener(
        "dragleave",
        evt -> {
          evt.stopPropagation();
          evt.preventDefault();
          Optional.ofNullable(dropEffect)
              .ifPresent(effect -> ((DragEvent) evt).dataTransfer.dropEffect = effect.getEffect());
          if (Js.<HTMLElement>uncheckedCast(evt.target) == root.element()) {
            removeHover();
          }
        });
  }

  /**
   * Constructor for FileUpload.
   *
   * @param filePreviewFactory a {@link org.dominokit.domino.ui.upload.FilePreviewFactory} object
   * @param filePreviewContainer a {@link org.dominokit.domino.ui.upload.FilePreviewContainer}
   *     object
   * @param decoration a {@link org.dominokit.domino.ui.IsElement} object
   */
  public FileUpload(
      FilePreviewFactory filePreviewFactory,
      FilePreviewContainer<?, ?> filePreviewContainer,
      IsElement<?> decoration) {
    this(filePreviewFactory, filePreviewContainer);
    setDecoration(decoration.element());
  }

  /**
   * Constructor for FileUpload.
   *
   * @param filePreviewFactory a {@link org.dominokit.domino.ui.upload.FilePreviewFactory} object
   */
  public FileUpload(FilePreviewFactory filePreviewFactory) {
    this(filePreviewFactory, CONFIG.getUIConfig().getDefaultFilePreviewContainer().get());
  }

  /** Constructor for FileUpload. */
  public FileUpload() {
    this(
        CONFIG.getUIConfig().getFilePreviewFactory(),
        CONFIG.getUIConfig().getDefaultFilePreviewContainer().get());
  }

  /**
   * Setter for the field <code>decoration</code>.
   *
   * @param decoration a {@link org.dominokit.domino.ui.IsElement} object
   * @return a {@link org.dominokit.domino.ui.upload.FileUpload} object
   */
  public FileUpload setDecoration(IsElement<?> decoration) {
    return setDecoration(decoration.element());
  }

  /**
   * Setter for the field <code>decoration</code>.
   *
   * @param decoration a {@link elemental2.dom.Element} object
   * @return a {@link org.dominokit.domino.ui.upload.FileUpload} object
   */
  public FileUpload setDecoration(Element decoration) {
    if (nonNull(this.decoration) && this.decoration.isInitialized()) {
      this.decoration.remove();
    }
    if (nonNull(decoration)) {
      this.decoration =
          LazyChild.of(elementOf(decoration).addCss(dui_file_upload_decoration), root);
      this.decoration.get();
    }
    return this;
  }

  /**
   * Setter for the field <code>maxAllowedUploads</code>.
   *
   * @param maxAllowedUploads a int
   */
  public void setMaxAllowedUploads(int maxAllowedUploads) {
    this.maxAllowedUploads = maxAllowedUploads;
  }

  /**
   * Getter for the field <code>maxAllowedUploads</code>.
   *
   * @return a int
   */
  public int getMaxAllowedUploads() {
    return maxAllowedUploads;
  }

  /**
   * Sets the sender of the upload request when the request is ready to be sent
   *
   * @param requestSender the {@link org.dominokit.domino.ui.upload.UploadRequestSender}
   * @return same instance
   */
  public FileUpload setRequestSender(UploadRequestSender requestSender) {
    if (nonNull(requestSender)) {
      this.requestSender = requestSender;
    }
    return this;
  }

  private void addHover() {
    root.addCss("dui-hovered");
  }

  private void uploadFiles(FileList files) {
    for (int i = 0; i < files.length; i++) {
      File file = files.item(i);
      addFilePreview(file);
    }
    hiddenFileInput.element().value = "";
  }

  /** Sends the requests for uploading all files */
  public void uploadAllFiles() {
    addedFileItems.forEach(fileItem -> fileItem.upload(requestSender));
  }

  private void addFilePreview(File file) {
    FileItem fileItem = FileItem.create(file, new UploadOptions(), filePreviewFactory);

    fileItemHandlers.forEach(handler -> handler.handle(fileItem));

    fileItem.validateSize();

    filesContainer.appendChild(fileItem);
    addedFileItems.add(fileItem);

    fileItem.addRemoveHandler(
        removedFile -> {
          addedFileItems.remove(fileItem);
        });

    if (fileItem.isCanceled()) {
      fileItem.remove();
    }

    if (autoUpload && !fileItem.isCanceled() && !fileItem.isRemoved()) {
      fileItem.upload(requestSender);
    }
  }

  private void removeHover() {
    root.removeCss("dui-hovered");
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }

  /**
   * Enables multiple files upload
   *
   * @return same instance
   * @param multiUpload a boolean
   */
  public FileUpload setMultiUpload(boolean multiUpload) {
    hiddenFileInput.element().multiple = multiUpload;
    return this;
  }

  /**
   * accept.
   *
   * @see <a href='https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/accept'>MDN docs for
   *     accept attribute</a> Sets the accepted files extensions
   * @param acceptedFiles a comma separated string containing all the accepted file extensions
   * @return same instance
   */
  public FileUpload accept(String acceptedFiles) {
    hiddenFileInput.element().accept = acceptedFiles;
    return this;
  }

  /**
   * accept.
   *
   * @see <a href='https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/accept'>MDN docs for
   *     accept attribute</a> Sets the accepted files extensions
   * @param acceptedFiles a comma separated string containing all the accepted file extensions
   * @return same instance
   */
  public FileUpload accept(Collection<String> acceptedFiles) {
    return accept(String.join(",", acceptedFiles));
  }

  /**
   * Sets a handler to be called when file is added
   *
   * @param fileItemHandler a {@link org.dominokit.domino.ui.upload.FileUpload.FileItemHandler}
   * @return same instance
   */
  public FileUpload onAddFile(FileItemHandler fileItemHandler) {
    fileItemHandlers.add(fileItemHandler);
    return this;
  }

  /**
   * Sets that the file should be automatically uploaded when the user adds it
   *
   * @return same instance
   */
  public FileUpload autoUpload() {
    this.autoUpload = true;
    return this;
  }

  /**
   * Sets that the file should be uploaded only when calling {@link
   * FileUpload#uploadFiles(FileList)} or {@link
   * org.dominokit.domino.ui.upload.FileUpload#uploadAllFiles()}
   *
   * @return same instance
   */
  public FileUpload manualUpload() {
    this.autoUpload = false;
    return this;
  }

  /**
   * Setter for the field <code>autoUpload</code>.
   *
   * @param autoUpload a boolean
   * @return a {@link org.dominokit.domino.ui.upload.FileUpload} object
   */
  public FileUpload setAutoUpload(boolean autoUpload) {
    this.autoUpload = autoUpload;
    return this;
  }

  /** @return the hidden file input element */
  /**
   * getInputElement.
   *
   * @return a {@link org.dominokit.domino.ui.elements.InputElement} object
   */
  public InputElement getInputElement() {
    return hiddenFileInput;
  }

  /** @return the files container */
  /**
   * Getter for the field <code>filesContainer</code>.
   *
   * @return a {@link org.dominokit.domino.ui.utils.DominoElement} object
   */
  public DominoElement<HTMLElement> getFilesContainer() {
    return (DominoElement<HTMLElement>) filesContainer;
  }

  /** @return the added file items */
  /**
   * Getter for the field <code>addedFileItems</code>.
   *
   * @return a {@link java.util.List} object
   */
  public List<FileItem> getAddedFileItems() {
    return addedFileItems;
  }

  /** @return all {@link FileItemHandler} defined */
  /**
   * getOnAddFileHandlers.
   *
   * @return a {@link java.util.List} object
   */
  public List<FileItemHandler> getOnAddFileHandlers() {
    return fileItemHandlers;
  }

  /** @return true if auto upload is set, false otherwise */
  /**
   * isAutoUpload.
   *
   * @return a boolean
   */
  public boolean isAutoUpload() {
    return autoUpload;
  }

  /** {@inheritDoc} */
  @Override
  public String getName() {
    return hiddenFileInput.element().name;
  }

  /** {@inheritDoc} */
  @Override
  public FileUpload setName(String name) {
    hiddenFileInput.element().name = name;
    return this;
  }

  /** @return the {@link DropEffect} configured */
  /**
   * Getter for the field <code>dropEffect</code>.
   *
   * @return a {@link java.util.Optional} object
   */
  public Optional<DropEffect> getDropEffect() {
    return Optional.ofNullable(dropEffect);
  }

  /**
   * Sets the drop effect
   *
   * @param dropEffect the {@link org.dominokit.domino.ui.upload.DropEffect}
   * @return same instance
   */
  public FileUpload setDropEffect(DropEffect dropEffect) {
    if (nonNull(dropEffect)) {
      this.dropEffect = dropEffect;
    }
    return this;
  }

  /** A handler to be called when file is added */
  @FunctionalInterface
  public interface FileItemHandler {
    /** @param fileItem the added {@link FileItem} */
    void handle(FileItem fileItem);
  }
}
