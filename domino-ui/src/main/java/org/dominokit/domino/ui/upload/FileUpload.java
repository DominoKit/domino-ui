package org.dominokit.domino.ui.upload;

import elemental2.dom.*;
import jsinterop.base.Js;

import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasName;
import org.jboss.elemento.IsElement;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.div;
import static org.jboss.elemento.Elements.input;

public class FileUpload extends BaseDominoElement<HTMLDivElement, FileUpload> implements HasName<FileUpload> {

    private Row row = Row.create();
    private Column column = Column.span(2, 2, 4, 6, 12);
    private int thumbSpanXLarge = 2;
    private int thumbSpanLarge = 2;
    private int thumbSpanMedium = 4;
    private int thumbSpanSmall = 6;
    private int thumbSpanXSmall = 12;

    private int thumbOffsetXLarge = -1;
    private int thumbOffsetLarge = -1;
    private int thumbOffsetMedium = -1;
    private int thumbOffsetSmall = -1;
    private int thumbOffsetXSmall = -1;

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

    private UploadRequestSender requestSender = (XMLHttpRequest::send);

    private Optional<DropEffect> dropEffect = Optional.empty();

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
            if(dropEffect.isPresent() && files.length > 0) {
                ((DragEvent) evt).dataTransfer.dropEffect = dropEffect.get().getEffect();
            }
            if (!singleFile || files.length == 1) {
                uploadFiles(files);
            } else {
                notifySingleFileError();
            }
            removeHover();
            evt.stopPropagation();
            evt.preventDefault();
        });
        formElement.addEventListener("dragover", evt -> {
            if(dropEffect.isPresent()) {
                ((DragEvent) evt).dataTransfer.dropEffect = dropEffect.get().getEffect();
            }
            addHover();
            evt.stopPropagation();
            evt.preventDefault();
        });
        formElement.addEventListener("dragleave", evt -> {
            if(dropEffect.isPresent()) {
                ((DragEvent) evt).dataTransfer.dropEffect = dropEffect.get().getEffect();
            }
            if( isFormUploadElement(evt.target) )
                removeHover();
            evt.stopPropagation();
            evt.preventDefault();
        });
        filesContainer.appendChild(row.element());
        init(this);
    }

    public FileUpload setRequestSender(UploadRequestSender requestSender) {
        if (nonNull(requestSender)) {
            this.requestSender = requestSender;
        }
        return this;
    }

    private void notifySingleFileError() {
        Notification.createWarning(errorMessage).show();
    }

    private boolean isFormUploadElement(EventTarget target) {
    	HTMLElement element = Js.uncheckedCast(target);
    	return element == formElement.element();
    }
    
    private void addHover() {
        formElement.style().add("file-upload-hover");
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
        addedFileItems.forEach(fileItem -> fileItem.upload(requestSender));
    }

    private void addFilePreview(File file) {
        FileItem fileItem = FileItem.create(file, new UploadOptions(url, maxFileSize, successCodesProvider));
        Column previewColumn = Column.span(thumbSpanXLarge, thumbSpanLarge, thumbSpanMedium, thumbSpanSmall, thumbSpanXSmall)
                .appendChild(fileItem.element());

        if (thumbOffsetXLarge >= 0) {
            previewColumn.onXLargeOffset(Column.OnXLargeOffset.of(thumbOffsetXLarge));
        }
        if (thumbOffsetLarge >= 0) {
            previewColumn.onLargeOffset(Column.OnLargeOffset.of(thumbOffsetLarge));
        }
        if (thumbOffsetMedium >= 0) {
            previewColumn.onMediumOffset(Column.OnMediumOffset.of(thumbOffsetMedium));
        }
        if (thumbOffsetSmall >= 0) {
            previewColumn.onSmallOffset(Column.OnSmallOffset.of(thumbOffsetSmall));
        }
        if (thumbOffsetXSmall >= 0) {
            previewColumn.onXSmallOffset(Column.OnXSmallOffset.of(thumbOffsetXSmall));
        }

        row.appendChild(previewColumn);
        addedFileItems.add(fileItem);

        fileItem.addRemoveHandler(removedFile -> {
            previewColumn.element().remove();
            addedFileItems.remove(fileItem);
        });

        onAddFileHandlers.forEach(handler -> handler.onAddFile(fileItem));

        if (fileItem.isCanceled()) {
            fileItem.remove();
        }

        if (autoUpload && !fileItem.isCanceled() && !fileItem.isRemoved()) {
            fileItem.upload(requestSender);
        }
    }

    private void removeHover() {
        formElement.style().remove("file-upload-hover");
    }

    private void createHiddenInput() {
        hiddenFileInput = input("file")
                .style("visibility: hidden; position: absolute; top: 0px; left: 0px; height: 0px; width: 0px;").element();
        DomGlobal.document.body.appendChild(hiddenFileInput);
    }

    public static FileUpload create() {
        return new FileUpload();
    }

    @Override
    public HTMLDivElement element() {
        return formElement.element();
    }

    public FileUpload appendChild(Node child) {
        uploadMessageContainer.appendChild(child);
        return this;
    }

    @Override
    public FileUpload appendChild(IsElement<?> child) {
        return appendChild(child.element());
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
        addedFileItems.forEach(fileItem -> fileItem.setUrl(url));
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

    public Optional<DropEffect> getDropEffect() {
        return dropEffect;
    }

    public FileUpload setDropEffect(DropEffect dropEffect) {
        if(nonNull(dropEffect)) {
            this.dropEffect = Optional.of(dropEffect);
        }
        return this;
    }

    @FunctionalInterface
    public interface OnAddFileHandler {
        void onAddFile(FileItem fileItem);
    }
}
