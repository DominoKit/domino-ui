package org.dominokit.domino.ui.upload;

import elemental2.dom.*;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasName;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.input;

public class FileUpload extends BaseDominoElement<HTMLDivElement, FileUpload> implements HasName<FileUpload> {

    private Row row = Row.create();
    private Column column = Column.span(2, 2, 4, 6, 12);
    private int thumbSpanXLarge = 2;
    private int thumbSpanLarge = 2;
    private int thumbSpanMedium = 4;
    private int thumbSpanSmall = 6;
    private int thumbSpanXSmall = 12;

    private int thumbOffsetXLarge = 0;
    private int thumbOffsetLarge = 0;
    private int thumbOffsetMedium = 0;
    private int thumbOffsetSmall = 0;
    private int thumbOffsetXSmall = 0;

    private DominoElement<HTMLDivElement> formElement = DominoElement.of(div().css("file-upload"));
    private DominoElement<HTMLDivElement> uploadMessageContainer = DominoElement.of(div().css("file-upload-message"));
    private DominoElement<HTMLDivElement> uploadIconContainer = DominoElement.of(div().css("file-upload-message-icon"));
    private HTMLInputElement hiddenFileInput;
    private DominoElement<HTMLDivElement> filesContainer = DominoElement.of(div());
    private List<FileItem> addedFileItems = new ArrayList<>();
    private double maxFileSize;
    private String url;

    private List<OnAddFileHandler> onAddFileHandlers = new ArrayList<>();
    private boolean autoUpload = true;
    private boolean singleFile = false;
    private String errorMessage = "Only one file is allowed to be uploaded";

    private Supplier<List<Integer>> successCodesProvider = () -> Arrays.asList(200, 201, 202, 203, 204, 205, 206, 207, 208, 226);

    public FileUpload() {
        uploadMessageContainer.appendChild(uploadIconContainer);
        createHiddenInput();
        formElement.appendChild(uploadMessageContainer);
        formElement.appendChild(filesContainer);

        hiddenFileInput.addEventListener("change", evt -> {
            uploadFiles(hiddenFileInput.files);
        });
        uploadMessageContainer.addEventListener("click", evt -> hiddenFileInput.click());
        formElement.addEventListener("drop", evt -> {
            FileList files = ((DragEvent) evt).dataTransfer.files;
            if (!singleFile || files.length == 1) {
                uploadFiles(files);
            } else {
                notifySingleFileError();
            }
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
        init(this);
    }

    private void notifySingleFileError() {
        Notification.createWarning(errorMessage).show();
    }

    private void addHover() {
        formElement.style().add("file-upload-hover");
        uploadMessageContainer.style().setPointerEvents("none");
        uploadIconContainer.style().setPointerEvents("none");
    }

    private void uploadFiles(FileList files) {
        if (singleFile) {
            addedFileItems.forEach(FileItem::remove);
            addedFileItems.clear();
        }
        for (int i = 0; i < files.length; i++) {
            File file = files.item(i);
            addFilePreview(file);
        }
        hiddenFileInput.value = "";
    }

    public void uploadAllFiles() {
        addedFileItems.forEach(FileItem::upload);
    }

    private void addFilePreview(File file) {
        FileItem fileItem = FileItem.create(file, new UploadOptions(url, maxFileSize, successCodesProvider));
        Column previewColumn = Column.span(thumbSpanXLarge, thumbSpanLarge, thumbSpanMedium, thumbSpanSmall, thumbSpanXSmall)
                .offset(thumbOffsetXLarge, thumbOffsetLarge, thumbOffsetMedium, thumbOffsetSmall, thumbOffsetXSmall)
                .appendChild(fileItem.asElement());

        fileItem.addRemoveHandler(removedFile -> {
            previewColumn.asElement().remove();
            addedFileItems.remove(fileItem);
        });

        onAddFileHandlers.forEach(handler -> handler.onAddFile(fileItem));
        if (!fileItem.isCanceled()) {
            addedFileItems.add(fileItem);
            row.appendChild(previewColumn);
        }

        if (autoUpload) {
            fileItem.upload();
        }

    }

    private void removeHover() {
        formElement.style().remove("file-upload-hover");
        uploadMessageContainer.style().setPointerEvents("auto");
        uploadIconContainer.style().setPointerEvents("auto");
    }

    private void createHiddenInput() {
        hiddenFileInput = input("file")
                .style("visibility: hidden; position: absolute; top: 0px; left: 0px; height: 0px; width: 0px;").asElement();
        DomGlobal.document.body.appendChild(hiddenFileInput);
    }

    public static FileUpload create() {
        return new FileUpload();
    }

    @Override
    public HTMLDivElement asElement() {
        return formElement.asElement();
    }

    public FileUpload appendChild(Node child) {
        uploadMessageContainer.appendChild(child);
        return this;
    }

    public FileUpload appendChild(IsElement child) {
        return appendChild(child.asElement());
    }

    public FileUpload multipleFiles() {
        hiddenFileInput.multiple = true;
        this.singleFile = false;
        return this;
    }

    public FileUpload singleFile() {
        hiddenFileInput.multiple = false;
        this.singleFile = true;
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

    public DominoElement<HTMLDivElement> getFormElement() {
        return DominoElement.of(formElement);
    }

    public DominoElement<HTMLDivElement> getUploadMessageContainer() {
        return DominoElement.of(uploadMessageContainer);
    }

    public DominoElement<HTMLDivElement> getUploadIconContainer() {
        return DominoElement.of(uploadIconContainer);
    }

    public DominoElement<HTMLInputElement> getHiddenFileInput() {
        return DominoElement.of(hiddenFileInput);
    }

    public DominoElement<HTMLDivElement> getFilesContainer() {
        return DominoElement.of(filesContainer);
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

    public FileUpload setIcon(BaseIcon<?> icon) {
        uploadIconContainer.appendChild(icon);
        return this;
    }

    public FileUpload setThumbSpans(int xLarge, int large, int medium, int small, int xSmall) {
        this.thumbSpanXLarge = xLarge;
        this.thumbSpanLarge = large;
        this.thumbSpanMedium = medium;
        this.thumbSpanSmall = small;
        this.thumbSpanXSmall = xSmall;
        return this;
    }

    public FileUpload setThumbOffset(int xLarge, int large, int medium, int small, int xSmall) {
        this.thumbOffsetXLarge = xLarge;
        this.thumbOffsetLarge = large;
        this.thumbOffsetMedium = medium;
        this.thumbOffsetSmall = small;
        this.thumbOffsetXSmall = xSmall;
        return this;
    }

    public void setSuccessCodesProvider(Supplier<List<Integer>> successCodesProvider) {
        this.successCodesProvider = successCodesProvider;
    }

    @Override
    public FileUpload setName(String name) {
        hiddenFileInput.name = name;
        return this;
    }

    public FileUpload setSingleFileErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    @FunctionalInterface
    public interface OnAddFileHandler {
        void onAddFile(FileItem fileItem);
    }
}
