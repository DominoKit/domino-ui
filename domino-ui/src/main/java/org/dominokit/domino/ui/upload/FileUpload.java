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

import elemental2.dom.DragEvent;
import elemental2.dom.Element;
import elemental2.dom.File;
import elemental2.dom.FileList;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.XMLHttpRequest;
import jsinterop.base.Js;
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
import org.dominokit.domino.ui.IsElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.utils.DominoUIConfig.CONFIG;

/**
 * A component for uploading files (photos, documents or any other file type) from local storage
 *
 * @see BaseDominoElement
 * @see HasName
 */
public class FileUpload extends BaseDominoElement<HTMLDivElement, FileUpload>
        implements HasName<FileUpload>, FileUploadStyles, HasComponentConfig<UploadConfig>, HasLabels<UploadLabels> {

    public static final Supplier<List<Integer>> DEFAULT_SUCCESS_CODES = () -> Arrays.asList(200, 201, 202, 203, 204, 205, 206, 207, 208, 226);
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

    /**
     * @return new instance
     */
    public static FileUpload create() {
        return new FileUpload();
    }

    /**
     * @return new instance
     */
    public static FileUpload create(FilePreviewFactory filePreviewFactory, FilePreviewContainer<?, ?> filePreviewContainer) {
        return new FileUpload(filePreviewFactory, filePreviewContainer);
    }

    /**
     * @return new instance
     */
    public static FileUpload create(FilePreviewFactory filePreviewFactory) {
        return new FileUpload(filePreviewFactory);
    }

    /**
     * @return new instance
     */
    public static FileUpload create(FilePreviewFactory filePreviewFactory, FilePreviewContainer<?, ?> filePreviewContainer, IsElement<?> decoration) {
        return new FileUpload(filePreviewFactory, filePreviewContainer, decoration);
    }

    public FileUpload(FilePreviewFactory filePreviewFactory, FilePreviewContainer<?, ?> filePreviewContainer) {
        this.filePreviewFactory = filePreviewFactory;
        root = div().addCss(dui_file_upload)
                .appendChild(messagesContainer = div().addCss(dui_file_upload_messages))
                .appendChild(hiddenFileInput =
                        input("file").addCss(dui_file_upload_input))
                .appendChild(filesContainer = filePreviewContainer);
        elementOf(filesContainer.element())
                .addCss(dui_file_preview_container);
        init(this);
        root.addClickListener(evt -> hiddenFileInput.element().click());
        hiddenFileInput.addEventListener(
                "change",
                evt -> uploadFiles(hiddenFileInput.element().files));
        root.addEventListener(
                "drop",
                evt -> {
                    evt.stopPropagation();
                    evt.preventDefault();

                    FileList files = ((DragEvent) evt).dataTransfer.files;
                    Optional.ofNullable(dropEffect)
                            .ifPresent(effect -> {
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
                    Optional.ofNullable(dropEffect).ifPresent(
                            effect -> ((DragEvent) evt).dataTransfer.dropEffect = effect.getEffect());
                    addHover();
                });
        root.addEventListener(
                "dragleave",
                evt -> {
                    evt.stopPropagation();
                    evt.preventDefault();
                    Optional.ofNullable(dropEffect).ifPresent(
                            effect -> ((DragEvent) evt).dataTransfer.dropEffect = effect.getEffect());
                    if (Js.<HTMLElement>uncheckedCast(evt.target) == root.element()) {
                        removeHover();
                    }
                });
    }

    public FileUpload(FilePreviewFactory filePreviewFactory, FilePreviewContainer<?, ?> filePreviewContainer, IsElement<?> decoration) {
        this(filePreviewFactory, filePreviewContainer);
        setDecoration(decoration.element());
    }

    public FileUpload(FilePreviewFactory filePreviewFactory) {
        this(filePreviewFactory, CONFIG.getUIConfig().getDefaultFilePreviewContainer().get());
    }

    public FileUpload() {
        this(CONFIG.getUIConfig().getFilePreviewFactory(), CONFIG.getUIConfig().getDefaultFilePreviewContainer().get());
    }

    public FileUpload setDecoration(IsElement<?> decoration) {
        return setDecoration(decoration.element());
    }

    public FileUpload setDecoration(Element decoration) {
        if(nonNull(this.decoration) && this.decoration.isInitialized()){
            this.decoration.remove();
        }
        if(nonNull(decoration)){
            this.decoration = LazyChild.of(elementOf(decoration).addCss(dui_file_upload_decoration), root);
            this.decoration.get();
        }
        return this;
    }

    public void setMaxAllowedUploads(int maxAllowedUploads) {
        this.maxAllowedUploads = maxAllowedUploads;
    }

    public int getMaxAllowedUploads() {
        return maxAllowedUploads;
    }

    /**
     * Sets the sender of the upload request when the request is ready to be sent
     *
     * @param requestSender the {@link UploadRequestSender}
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

    /**
     * Sends the requests for uploading all files
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLDivElement element() {
        return root.element();
    }

    /**
     * Enables multiple files upload
     *
     * @return same instance
     */
    public FileUpload setMultiUpload(boolean multiUpload) {
        hiddenFileInput.element().multiple = multiUpload;
        return this;
    }

    /**
     * @see <a href='https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/accept'>MDN docs for accept attribute</a>
     * Sets the accepted files extensions
     *
     * @param acceptedFiles a comma separated string containing all the accepted file extensions
     * @return same instance
     */
    public FileUpload accept(String acceptedFiles) {
        hiddenFileInput.element().accept = acceptedFiles;
        return this;
    }

    /**
     * @see <a href='https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/accept'>MDN docs for accept attribute</a>
     * Sets the accepted files extensions
     *
     * @param acceptedFiles a comma separated string containing all the accepted file extensions
     * @return same instance
     */
    public FileUpload accept(Collection<String> acceptedFiles) {
        return accept(String.join(",", acceptedFiles));
    }


    /**
     * Sets a handler to be called when file is added
     *
     * @param fileItemHandler a {@link FileItemHandler}
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
     * FileUpload#uploadFiles(FileList)} or {@link FileUpload#uploadAllFiles()}
     *
     * @return same instance
     */
    public FileUpload manualUpload() {
        this.autoUpload = false;
        return this;
    }

    public FileUpload setAutoUpload(boolean autoUpload){
        this.autoUpload = autoUpload;
        return this;
    }

    /**
     * @return the hidden file input element
     */
    public InputElement getInputElement() {
        return hiddenFileInput;
    }

    /**
     * @return the files container
     */
    public DominoElement<HTMLElement> getFilesContainer() {
        return (DominoElement<HTMLElement>) filesContainer;
    }

    /**
     * @return the added file items
     */
    public List<FileItem> getAddedFileItems() {
        return addedFileItems;
    }

    /**
     * @return all {@link FileItemHandler} defined
     */
    public List<FileItemHandler> getOnAddFileHandlers() {
        return fileItemHandlers;
    }

    /**
     * @return true if auto upload is set, false otherwise
     */
    public boolean isAutoUpload() {
        return autoUpload;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return hiddenFileInput.element().name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FileUpload setName(String name) {
        hiddenFileInput.element().name = name;
        return this;
    }


    /**
     * @return the {@link DropEffect} configured
     */
    public Optional<DropEffect> getDropEffect() {
        return Optional.ofNullable(dropEffect);
    }

    /**
     * Sets the drop effect
     *
     * @param dropEffect the {@link DropEffect}
     * @return same instance
     */
    public FileUpload setDropEffect(DropEffect dropEffect) {
        if (nonNull(dropEffect)) {
            this.dropEffect = dropEffect;
        }
        return this;
    }

    /**
     * A handler to be called when file is added
     */
    @FunctionalInterface
    public interface FileItemHandler {
        /**
         * @param fileItem the added {@link FileItem}
         */
        void handle(FileItem fileItem);
    }
}
