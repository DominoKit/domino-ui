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
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.elementOf;
import static org.dominokit.domino.ui.utils.Domino.input;
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
import java.util.stream.Collectors;
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
 * The `FileUpload` class provides a user interface for uploading files to a server. It allows users
 * to select and upload one or multiple files, with options for customization and configuration.
 *
 * <p>Usage example:
 *
 * <pre>
 * // Create a FileUpload component
 * FileUpload fileUpload = FileUpload.create();
 *
 * // Set the maximum number of allowed uploads
 * fileUpload.setMaxAllowedUploads(5);
 *
 * // Set a custom request sender for handling file uploads
 * fileUpload.setRequestSender(myCustomRequestSender);
 *
 * // Enable auto-upload (files are uploaded automatically after selection)
 * fileUpload.autoUpload();
 *
 * // Set the accepted file types
 * fileUpload.accept("image/*,application/pdf");
 *
 * // Add an event handler for when a file is added
 * fileUpload.onAddFile(fileItem -> {
 *     // Handle the added fileItem
 * });
 *
 * // Set a custom decoration for the component
 * fileUpload.setDecoration(myCustomDecorationElement);
 * </pre>
 *
 * @see FileItem
 * @see FilePreviewFactory
 * @see FilePreviewContainer
 * @see UploadOptions
 * @see UploadRequestSender
 * @see DropEffect
 * @see BaseDominoElement
 */
public class FileUpload extends BaseDominoElement<HTMLDivElement, FileUpload>
    implements HasName<FileUpload>,
        FileUploadStyles,
        HasComponentConfig<UploadConfig>,
        HasLabels<UploadLabels> {

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
  private UploadConfig config;
  private boolean showPreview = true;

  /**
   * Creates a new instance of the `FileUpload` component.
   *
   * @return A new `FileUpload` instance.
   */
  public static FileUpload create() {
    return new FileUpload();
  }

  /**
   * Creates a new instance of the `FileUpload` component with a custom file preview factory and
   * file preview container.
   *
   * @param filePreviewFactory The file preview factory to use.
   * @param filePreviewContainer The file preview container to use.
   * @return A new `FileUpload` instance with the specified factory and container.
   */
  public static FileUpload create(
      FilePreviewFactory filePreviewFactory, FilePreviewContainer<?, ?> filePreviewContainer) {
    return new FileUpload(filePreviewFactory, filePreviewContainer);
  }

  /**
   * Creates a new instance of the `FileUpload` component with a default file preview factory and a
   * custom file preview container.
   *
   * @param filePreviewContainer The file preview container to use.
   * @return A new `FileUpload` instance with the default factory and the specified container.
   */
  public static FileUpload create(FilePreviewContainer<?, ?> filePreviewContainer) {
    return new FileUpload(CONFIG.getUIConfig().getFilePreviewFactory(), filePreviewContainer);
  }

  /**
   * Creates a new instance of the `FileUpload` component with a custom file preview factory and the
   * default file preview container.
   *
   * @param filePreviewFactory The file preview factory to use.
   * @return A new `FileUpload` instance with the specified factory and the default container.
   */
  public static FileUpload create(FilePreviewFactory filePreviewFactory) {
    return new FileUpload(filePreviewFactory);
  }

  /**
   * Creates a new instance of the `FileUpload` component with a custom file preview factory, file
   * preview container, and decoration element.
   *
   * @param filePreviewFactory The file preview factory to use.
   * @param filePreviewContainer The file preview container to use.
   * @param decoration The decoration element to use.
   * @return A new `FileUpload` instance with the specified factory, container, and decoration.
   */
  public static FileUpload create(
      FilePreviewFactory filePreviewFactory,
      FilePreviewContainer<?, ?> filePreviewContainer,
      IsElement<?> decoration) {
    return new FileUpload(filePreviewFactory, filePreviewContainer, decoration);
  }

  /** Creates a new instance of the `FileUpload` component with default configurations. */
  public FileUpload() {
    this(
        CONFIG.getUIConfig().getFilePreviewFactory(),
        CONFIG.getUIConfig().getDefaultFilePreviewContainer().get());
  }

  /**
   * Creates a new instance of the `FileUpload` component with a custom file preview factory and the
   * default file preview container.
   *
   * @param filePreviewFactory The file preview factory to use.
   */
  public FileUpload(FilePreviewFactory filePreviewFactory) {
    this(filePreviewFactory, CONFIG.getUIConfig().getDefaultFilePreviewContainer().get());
  }

  /**
   * Creates a new instance of the `FileUpload` component with a custom file preview factory and
   * file preview container.
   *
   * @param filePreviewFactory The file preview factory to use.
   * @param filePreviewContainer The file preview container to use.
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
    hiddenFileInput.addEventListener("change", evt -> tryUpload(hiddenFileInput.element().files));
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
          tryUpload(files);
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

  private void tryUpload(FileList files) {

    int maxAllowed = isMultiUpload() ? maxAllowedUploads : 1;
    int addedFiles = addedFileItems.size();
    List<FileItem> uploadedFiles =
        addedFileItems.stream().filter(FileItem::isUploaded).collect(Collectors.toList());
    int remainingAllowed = Math.max(0, maxAllowed - (addedFiles - uploadedFiles.size()));
    int existing = addedFiles - uploadedFiles.size();
    int ignored = files.length - remainingAllowed;
    if (files.length > remainingAllowed) {
      if (getConfig().isMaxUploadsOverflowAllowed()) {
        uploadedFiles.forEach(FileItem::remove);
        List<File> toBeUploaded = files.asList().subList(0, remainingAllowed);
        uploadFiles(toBeUploaded);

        messagesContainer
            .clearElement()
            .setTextContent(
                getLabels()
                    .getMaxFileErrorMessage(maxAllowed, existing, remainingAllowed, ignored));
      } else {
        messagesContainer
            .clearElement()
            .setTextContent(
                getLabels().getMaxFileErrorMessage(maxAllowed, existing, 0, files.length));
      }
    } else {
      uploadFiles(files.asList());
    }
  }

  /**
   * Creates a new instance of the `FileUpload` component with a custom file preview factory, file
   * preview container, and decoration element.
   *
   * @param filePreviewFactory The file preview factory to use.
   * @param filePreviewContainer The file preview container to use.
   * @param decoration The decoration element to use.
   */
  public FileUpload(
      FilePreviewFactory filePreviewFactory,
      FilePreviewContainer<?, ?> filePreviewContainer,
      IsElement<?> decoration) {
    this(filePreviewFactory, filePreviewContainer);
    setDecoration(decoration.element());
  }

  /**
   * Sets a custom decoration element for the `FileUpload` component using an {@link IsElement}
   * instance. The decoration element is typically used to enhance or style the appearance of the
   * component.
   *
   * @param decoration The decoration element provided as an {@link IsElement} instance.
   * @return The current `FileUpload` instance for method chaining.
   */
  public FileUpload setDecoration(IsElement<?> decoration) {
    return setDecoration(decoration.element());
  }

  /**
   * Sets a custom decoration element for the `FileUpload` component using a native {@link Element}.
   * The decoration element is typically used to enhance or style the appearance of the component.
   *
   * @param decoration The decoration element provided as a native {@link Element}.
   * @return The current `FileUpload` instance for method chaining.
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
   * Sets the maximum number of allowed uploads.
   *
   * @param maxAllowedUploads The maximum number of allowed uploads.
   */
  public FileUpload setMaxAllowedUploads(int maxAllowedUploads) {
    this.maxAllowedUploads = maxAllowedUploads;
    return this;
  }

  /**
   * Gets the maximum number of allowed uploads.
   *
   * @return The maximum number of allowed uploads.
   */
  public int getMaxAllowedUploads() {
    return maxAllowedUploads;
  }

  /**
   * Sets a custom request sender for handling file uploads.
   *
   * @param requestSender The custom request sender.
   * @return The current `FileUpload` instance for method chaining.
   */
  public FileUpload setRequestSender(UploadRequestSender requestSender) {
    if (nonNull(requestSender)) {
      this.requestSender = requestSender;
    }
    return this;
  }

  /**
   * Adds a CSS class to the root element to indicate that a file is being dragged over the
   * component.
   */
  private void addHover() {
    root.addCss("dui-hovered");
  }

  /**
   * Uploads a list of files to the server.
   *
   * @param files The list of files to upload.
   */
  public FileUpload uploadFiles(List<File> files) {
    for (int i = 0; i < files.size(); i++) {
      File file = files.get(i);
      addFilePreview(file);
    }
    hiddenFileInput.element().value = "";
    return this;
  }

  /** Uploads all added files to the server. */
  public FileUpload uploadAllFiles() {
    addedFileItems.forEach(fileItem -> fileItem.upload(requestSender));
    return this;
  }

  @Override
  public UploadConfig getOwnConfig() {
    return config;
  }

  public FileUpload setConfig(UploadConfig config) {
    this.config = config;
    return this;
  }

  /**
   * Adds a file preview for the given file and handles its actions.
   *
   * @param file The file to create a preview for.
   */
  private void addFilePreview(File file) {
    if (isMultiUpload()) {
      removeUploadedFiles();
    }
    FileItem fileItem = FileItem.create(file, new UploadOptions(), filePreviewFactory, this);

    fileItem.addRemoveHandler(
        removedFile -> {
          addedFileItems.remove(fileItem);
        });

    fileItemHandlers.forEach(handler -> handler.handle(fileItem));

    fileItem.validateSize();

    if (showPreview) {
      filesContainer.appendChild(fileItem);
    }

    addedFileItems.add(fileItem);

    if (fileItem.isCanceled()) {
      fileItem.remove();
    }

    if (autoUpload && !fileItem.isCanceled() && !fileItem.isRemoved()) {
      fileItem.upload(requestSender);
    }
  }

  /** Removes the CSS class indicating that a file is being dragged over the component. */
  private void removeHover() {
    root.removeCss("dui-hovered");
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }

  /**
   * Sets whether the component allows multiple file uploads.
   *
   * @param multiUpload Set to `true` to allow multiple file uploads, `false` otherwise.
   * @return The current `FileUpload` instance for method chaining.
   */
  public FileUpload setMultiUpload(boolean multiUpload) {
    hiddenFileInput.element().multiple = multiUpload;
    if (multiUpload) {
      hiddenFileInput.setAttribute("multiple", true);
    } else {
      hiddenFileInput.removeAttribute("multiple");
    }

    return this;
  }

  /**
   * Checks if the component allows multiple file uploads.
   *
   * @return `true` if multiple file uploads are allowed, `false` otherwise.
   */
  public boolean isMultiUpload() {
    return hiddenFileInput.element().multiple;
  }

  /**
   * Sets the accepted file types for file selection.
   *
   * @param acceptedFiles A comma-separated list of accepted file types (e.g.,
   *     "image/*,application/pdf").
   * @return The current `FileUpload` instance for method chaining.
   */
  public FileUpload accept(String acceptedFiles) {
    hiddenFileInput.element().accept = acceptedFiles;
    return this;
  }

  /**
   * Sets the accepted file types for file selection from a collection of accepted file types.
   *
   * @param acceptedFiles A collection of accepted file types.
   * @return The current `FileUpload` instance for method chaining.
   */
  public FileUpload accept(Collection<String> acceptedFiles) {
    return accept(String.join(",", acceptedFiles));
  }

  /**
   * Adds a handler for when a file is added to the component.
   *
   * @param fileItemHandler The file item handler to add.
   * @return The current `FileUpload` instance for method chaining.
   */
  public FileUpload onAddFile(FileItemHandler fileItemHandler) {
    fileItemHandlers.add(fileItemHandler);
    return this;
  }

  /**
   * Enables auto-upload mode, where files are uploaded automatically after selection.
   *
   * @return The current `FileUpload` instance for method chaining.
   */
  public FileUpload autoUpload() {
    this.autoUpload = true;
    return this;
  }

  /**
   * Enables manual-upload mode, where files are not automatically uploaded after selection.
   *
   * @return The current `FileUpload` instance for method chaining.
   */
  public FileUpload manualUpload() {
    this.autoUpload = false;
    return this;
  }

  /**
   * Sets the upload mode for the component.
   *
   * @param autoUpload Set to `true` for auto-upload mode, `false` for manual-upload mode.
   * @return The current `FileUpload` instance for method chaining.
   */
  public FileUpload setAutoUpload(boolean autoUpload) {
    this.autoUpload = autoUpload;
    return this;
  }

  /**
   * Gets the input element used for selecting files.
   *
   * @return The input element for file selection.
   */
  public InputElement getInputElement() {
    return hiddenFileInput;
  }

  /**
   * Gets the container element that holds the added file items.
   *
   * @return The container element for added file items.
   */
  public DominoElement<HTMLElement> getFilesContainer() {
    return (DominoElement<HTMLElement>) filesContainer;
  }

  /**
   * Gets the list of added file items.
   *
   * @return A list of added file items.
   */
  public List<FileItem> getAddedFileItems() {
    return addedFileItems;
  }

  /**
   * Removes all added file items from the component.
   *
   * @return The current `FileUpload` instance for method chaining.
   */
  public FileUpload removeFileItems() {
    new ArrayList<>(addedFileItems).forEach(FileItem::remove);
    addedFileItems.clear();
    return this;
  }

  private void removeUploadedFiles() {
    List<FileItem> uploaded =
        addedFileItems.stream().filter(FileItem::isUploaded).collect(Collectors.toList());
    addedFileItems.removeAll(uploaded);
    uploaded.forEach(FileItem::remove);
  }

  /**
   * Gets a list of file item handlers that are executed when a file is added to the component.
   *
   * @return A list of file item handlers.
   */
  public List<FileItemHandler> getOnAddFileHandlers() {
    return fileItemHandlers;
  }

  /**
   * Checks if the component is in auto-upload mode.
   *
   * @return `true` if the component is in auto-upload mode, `false` otherwise.
   */
  public boolean isAutoUpload() {
    return autoUpload;
  }

  /**
   * Retrieves the name attribute of the hidden file input element associated with this `FileUpload`
   * component. The name attribute is used when submitting the uploaded file(s) as part of a form.
   *
   * @return The name attribute of the hidden file input element.
   */
  @Override
  public String getName() {
    return hiddenFileInput.element().name;
  }

  /**
   * Sets the name attribute for the hidden file input element associated with this `FileUpload`
   * component. The name attribute is used when submitting the uploaded file(s) as part of a form.
   *
   * @param name The name to be set as the name attribute.
   * @return The current `FileUpload` instance for method chaining.
   */
  @Override
  public FileUpload setName(String name) {
    hiddenFileInput.element().name = name;
    return this;
  }

  /**
   * Gets the current drop effect for file drag-and-drop operations.
   *
   * @return An optional drop effect, or `null` if not set.
   */
  public Optional<DropEffect> getDropEffect() {
    return Optional.ofNullable(dropEffect);
  }

  /**
   * Sets the drop effect for file drag-and-drop operations.
   *
   * @param dropEffect The drop effect to set.
   * @return The current `FileUpload` instance for method chaining.
   */
  public FileUpload setDropEffect(DropEffect dropEffect) {
    if (nonNull(dropEffect)) {
      this.dropEffect = dropEffect;
    }
    return this;
  }

  /** @return true if uploaded files will show a preview in the preview container */
  public boolean isShowPreview() {
    return showPreview;
  }

  /**
   * When set to true, uploaded files will show a preview in the preview container, otherwise they
   * wont
   *
   * @param showPreview boolean.
   * @return same component instance
   */
  public FileUpload setShowPreview(boolean showPreview) {
    this.showPreview = showPreview;
    return this;
  }

  /**
   * A functional interface for handling file items when they are added to the `FileUpload`
   * component.
   */
  @FunctionalInterface
  public interface FileItemHandler {
    /**
     * Handles a file item.
     *
     * @param fileItem The file item to handle.
     */
    void handle(FileItem fileItem);
  }
}
