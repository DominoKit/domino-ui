package org.dominokit.domino.ui.upload;

import elemental2.core.JsNumber;
import elemental2.dom.*;
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

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.upload.UploadOptions.*;
import static org.jboss.elemento.Elements.h;

public class FileItem extends BaseDominoElement<HTMLDivElement, FileItem> {
    private static final String[] UNITS = {"KB", "MB", "GB", "TB"};
    private static final String ELLIPSIS_TEXT = "ellipsis-text";

    private Thumbnail thumbnail = Thumbnail.create();
    private FileImage fileImage;
    private HTMLParagraphElement fileSizeParagraph;
    private HTMLHeadingElement fileNameTitleContainer;
    private HTMLDivElement footerContainer = Elements.div().element();
    private HTMLElement messageContainer = Elements.p().css(ELLIPSIS_TEXT).element();
    private HTMLDivElement progressElement;
    private ProgressBar progressBar;
    private HTMLElement deleteIcon = Icons.ALL.delete().element();
    private HTMLElement cancelIcon = Icons.ALL.cancel().element();
    private HTMLElement refreshIcon = Icons.ALL.refresh().element();

    private File file;
    private UploadOptions options;

    private List<RemoveFileHandler> removeHandlers = new ArrayList<>();
    private List<ErrorHandler> errorHandlers = new ArrayList<>();
    private List<ProgressHandler> progressHandlers = new ArrayList<>();
    private List<BeforeUploadHandler> beforeUploadHandlers = new ArrayList<>();
    private List<SuccessUploadHandler> successUploadHandlers = new ArrayList<>();
    private List<CancelHandler> cancelHandlers = new ArrayList<>();
    private String successMessage;
    private String errorMessage;
    private String unsentMessage = "Error while sending request";
    private XMLHttpRequest request;
    private boolean canceled;
    private boolean removed;
    private boolean uploaded;
    private String fileName;
    private UploadRequestSender requestSender;

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
        if (isImage())
            fileImage = FileImage.createImageFile(file);
        else
            fileImage = FileImage.createDefault();
    }

    public boolean isImage() {
        return file.type.startsWith("image");
    }

    private void initFileTitle() {
        fileNameTitleContainer = h(3).css(ELLIPSIS_TEXT).textContent(file.name).element();
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
        refreshIcon.addEventListener("click", evt -> {
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
        progressElement = Progress.create()
                .appendChild(progressBar)
                .element();
        progressElement.style.marginBottom = CSSProperties.MarginBottomUnionType.of("0px");
        progressElement.style.height = CSSProperties.HeightUnionType.of("5px");
    }

    private void initThumbnail() {
        thumbnail.element().appendChild(fileImage.element());
        thumbnail.appendCaptionChild(fileNameTitleContainer);
        thumbnail.appendCaptionChild(fileSizeParagraph);
        thumbnail.appendCaptionChild(footerContainer);
        thumbnail.appendCaptionChild(progressElement);
        thumbnail.getContentElement().style()
                .cssText("cursor: default !important")
                .setPadding("5px");
        thumbnail.getContentElement().remove();
    }

    @Override
    public HTMLDivElement element() {
        return thumbnail.element();
    }

    private void setThumbnailBorder(Color red) {
        thumbnail.element().style.border = "1px solid " + red.getHex();
    }

    public File getFile() {
        return file;
    }

    public FileItem setSizeTitle(String sizeTitle) {
        fileSizeParagraph.textContent = sizeTitle;
        return this;
    }

    public String readableFileSize() {
        return formatSize(file.size);
    }

    private String formatSize(double size) {
        int threshold = 1024;
        if (Math.abs(size) < threshold)
            return size + " B";

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

    public FileItem addRemoveHandler(RemoveFileHandler removeHandler) {
        removeHandlers.add(removeHandler);
        return this;
    }

    public FileItem addErrorHandler(ErrorHandler errorHandler) {
        errorHandlers.add(errorHandler);
        return this;
    }

    public FileItem addProgressHandler(ProgressHandler progressHandler) {
        progressHandlers.add(progressHandler);
        return this;
    }

    public FileItem addBeforeUploadHandler(BeforeUploadHandler beforeUploadHandler) {
        beforeUploadHandlers.add(beforeUploadHandler);
        return this;
    }

    public FileItem addSuccessUploadHandler(SuccessUploadHandler successUploadHandler) {
        successUploadHandlers.add(successUploadHandler);
        return this;
    }

    public FileItem addCancelHandler(CancelHandler cancelHandler) {
        cancelHandlers.add(cancelHandler);
        return this;
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

            request = new XMLHttpRequest();
            request.upload.addEventListener("loadstart", evt -> {
                hideRefreshIcon();
                hideDeleteIcon();
                showCancelIcon();
            });

            request.upload.addEventListener("loadend", evt -> {
                hideCancelIcon();
                showDeleteIcon();
            });

            request.upload.onprogress = p0 -> {
                if (p0.lengthComputable)
                    updateProgress(p0.loaded);
            };

            request.onabort = p0 -> {
                showRefreshIcon();
                showDeleteIcon();
                resetProgress();
                cancelHandlers.forEach(handler -> handler.onCancel(request));
            };

            request.addEventListener("readystatechange", evt -> {
                if (request.readyState == 4) {
                    if (this.options.getSuccessCodesProvider().get().contains(request.status))
                        onSuccess();
                    else if (!canceled)
                        onError();
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
        if (errorMessage != null)
            return errorMessage;

        final boolean hasErrorText = request.responseType != null && (request.responseType.isEmpty() || request.responseType.equals("text")) && !request.responseText.isEmpty();
        return hasErrorText ? request.responseText : "Error while sending request";
    }

    public void invalidate(String message) {
        setThumbnailBorder(Color.RED);
        setMessage(message, Color.RED);
    }

    private void setMessage(String message, Color color) {
        messageContainer.textContent = message;
        messageContainer.style.color = color.getHex();
        Tooltip.create(messageContainer, message).position(PopupPosition.BOTTOM);
    }

    private void updateProgressBackground(Color background) {
        progressBar.setBackground(background);
    }

    @Override
    public FileItem remove() {
        super.remove();
        this.removed = true;
        removeHandlers.forEach(handler -> handler.onRemoveFile(file));
        return this;
    }

    public FileItem setUrl(String url) {
        options.setUrl(url);
        return this;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public FileImage getFileImage() {
        return fileImage;
    }

    public DominoElement<HTMLParagraphElement> getFileSizeParagraph() {
        return DominoElement.of(fileSizeParagraph);
    }

    public DominoElement<HTMLHeadingElement> getFileNameTitleContainer() {
        return DominoElement.of(fileNameTitleContainer);
    }

    public DominoElement<HTMLDivElement> getFooterContainer() {
        return DominoElement.of(footerContainer);
    }

    public DominoElement<HTMLElement> getDeleteIcon() {
        return DominoElement.of(deleteIcon);
    }

    public DominoElement<HTMLElement> getMessageContainer() {
        return DominoElement.of(messageContainer);
    }

    public DominoElement<HTMLDivElement> getProgressElement() {
        return DominoElement.of(progressElement);
    }

    public ProgressBar getProgressBar() {
        return progressBar;
    }

    public List<RemoveFileHandler> getRemoveHandlers() {
        return removeHandlers;
    }

    public List<ErrorHandler> getErrorHandlers() {
        return errorHandlers;
    }

    public List<ProgressHandler> getProgressHandlers() {
        return progressHandlers;
    }

    public List<BeforeUploadHandler> getBeforeUploadHandlers() {
        return beforeUploadHandlers;
    }

    public List<SuccessUploadHandler> getSuccessUploadHandlers() {
        return successUploadHandlers;
    }

    public FileItem setSuccessUploadMessage(String successMessage) {
        this.successMessage = successMessage;
        return this;
    }

    public FileItem setErrorUploadMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    public FileItem setUnsentMessage(String unsentMessage) {
        this.unsentMessage = unsentMessage;
        return this;
    }

    public FileItem cancel() {
        if (request != null) {
            canceled = true;
            request.abort();
        }
        return this;
    }

    public DominoElement<HTMLElement> getCancelIcon() {
        return DominoElement.of(cancelIcon);
    }

    public List<CancelHandler> getCancelHandlers() {
        return cancelHandlers;
    }

    public String getUnsentMessage() {
        return unsentMessage;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public boolean isRemoved() {
        return removed;
    }

    public boolean isUploaded() {
        return uploaded;
    }

    @FunctionalInterface
    public interface RemoveFileHandler {
        void onRemoveFile(File file);
    }

    @FunctionalInterface
    public interface ErrorHandler {
        void onError(XMLHttpRequest request);
    }

    @FunctionalInterface
    public interface ProgressHandler {
        void onProgress(double loaded, XMLHttpRequest request);
    }

    @FunctionalInterface
    public interface BeforeUploadHandler {
        void onBeforeUpload(XMLHttpRequest request, FormData formData);
    }

    @FunctionalInterface
    public interface SuccessUploadHandler {
        void onSuccessUpload(XMLHttpRequest request);
    }

    @FunctionalInterface
    public interface CancelHandler {
        void onCancel(XMLHttpRequest request);
    }
}
