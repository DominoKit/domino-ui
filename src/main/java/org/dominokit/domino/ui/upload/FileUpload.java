package org.dominokit.domino.ui.upload;

import elemental2.dom.*;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.row.Row;
import org.dominokit.domino.ui.utils.HasName;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.List;

public class FileUpload implements IsElement<HTMLDivElement>, HasName<FileUpload> {

    private Row row = Row.create();
    private Column column = Column.create()
            .onLarge(Column.OnLarge.two)
            .onMedium(Column.OnMedium.four)
            .onSmall(Column.OnSmall.six)
            .onXSmall(Column.OnXSmall.twelve);

    private HTMLDivElement formElement = Elements.div().css("domino-file-upload").asElement();
    private HTMLDivElement uploadMessageContainer = Elements.div().css("domino-file-upload-message").asElement();
    private HTMLDivElement uploadIconContainer = Elements.div().css("domino-file-upload-message-icon").asElement();
    private HTMLInputElement hiddenFileInput;
    private HTMLDivElement filesContainer = Elements.div().asElement();
    private List<FileItem> addedFileItems = new ArrayList<>();
    private double maxFileSize;
    private String url;

    private List<OnAddFileHandler> onAddFileHandlers = new ArrayList<>();
    private boolean autoUpload = true;

    public FileUpload() {
        uploadMessageContainer.appendChild(uploadIconContainer);
        createHiddenInput();
        formElement.appendChild(uploadMessageContainer);
        formElement.appendChild(filesContainer);

        hiddenFileInput.addEventListener("input", evt -> {
            uploadFiles(hiddenFileInput.files);
        });
        uploadMessageContainer.addEventListener("click", evt -> hiddenFileInput.click());
        formElement.addEventListener("drop", evt -> {
            uploadFiles(((DragEvent) evt).dataTransfer.files);
            removeHover();
            evt.preventDefault();
        });
        formElement.addEventListener("dragover", evt -> {
            addHover();
            evt.preventDefault();
        });
        formElement.addEventListener("dragleave", evt -> {
            removeHover();
            evt.preventDefault();
        });
        filesContainer.appendChild(row.asElement());
    }

    private void addHover() {
        formElement.classList.add("domino-file-upload-hover");
    }

    private void uploadFiles(FileList files) {
        for (int i = 0; i < files.length; i++) {
            File file = files.item(i);
            addFilePreview(file);
        }
    }

    public void uploadAllFiles() {
        addedFileItems.forEach(FileItem::upload);
    }

    private void addFilePreview(File file) {
        FileItem fileItem = FileItem.create(file, new UploadOptions(url, maxFileSize));
        Column previewColumn = column.copy().addElement(fileItem.asElement());

        fileItem.addRemoveHandler(removedFile -> {
            previewColumn.asElement().remove();
            addedFileItems.remove(fileItem);
        });

        if (autoUpload)
            fileItem.upload();

        addedFileItems.add(fileItem);
        row.addColumn(previewColumn);
        onAddFileHandlers.forEach(handler -> handler.onAddFile(fileItem));
    }

    private void removeHover() {
        formElement.classList.remove("domino-file-upload-hover");
    }

    private void createHiddenInput() {
        hiddenFileInput = Elements.input("file")
                .style("visibility: hidden; position: absolute; top: 0px; left: 0px; height: 0px; width: 0px;").asElement();
        DomGlobal.document.body.appendChild(hiddenFileInput);
    }

    public static FileUpload create() {
        return new FileUpload();
    }

    @Override
    public HTMLDivElement asElement() {
        return formElement;
    }

    public FileUpload appendChild(Node child) {
        uploadMessageContainer.appendChild(child);
        return this;
    }

    public FileUpload multipleFiles() {
        hiddenFileInput.multiple = true;
        return this;
    }

    public FileUpload singleFile() {
        hiddenFileInput.multiple = false;
        return this;
    }

    public FileUpload accept(String acceptedFiles) {
        hiddenFileInput.accept = acceptedFiles;
        return this;
    }

    public FileUpload maxFileSize(double maxFileSize) {
        this.maxFileSize = maxFileSize;
        return this;
    }

    public FileUpload setUrl(String url) {
        this.url = url;
        return this;
    }

    public FileUpload onAddFile(OnAddFileHandler onAddFileHandler) {
        onAddFileHandlers.add(onAddFileHandler);
        return this;
    }

    public FileUpload autoUpload() {
        this.autoUpload = true;
        return this;
    }

    public FileUpload manualUpload() {
        this.autoUpload = false;
        return this;
    }

    public Row getRow() {
        return row;
    }

    public Column getColumn() {
        return column;
    }

    public HTMLDivElement getFormElement() {
        return formElement;
    }

    public HTMLDivElement getUploadMessageContainer() {
        return uploadMessageContainer;
    }

    public HTMLDivElement getUploadIconContainer() {
        return uploadIconContainer;
    }

    public HTMLInputElement getHiddenFileInput() {
        return hiddenFileInput;
    }

    public HTMLDivElement getFilesContainer() {
        return filesContainer;
    }

    public List<FileItem> getAddedFileItems() {
        return addedFileItems;
    }

    public double getMaxFileSize() {
        return maxFileSize;
    }

    public String getUrl() {
        return url;
    }

    public List<OnAddFileHandler> getOnAddFileHandlers() {
        return onAddFileHandlers;
    }

    public boolean isAutoUpload() {
        return autoUpload;
    }

    @Override
    public String getName() {
        return hiddenFileInput.name;
    }

    public FileUpload setIcon(Icon icon) {
        uploadIconContainer.appendChild(icon.asElement());
        return this;
    }

    @Override
    public FileUpload setName(String name) {
        hiddenFileInput.name = name;
        return this;
    }

    @FunctionalInterface
    public interface OnAddFileHandler {
        void onAddFile(FileItem fileItem);
    }
}
