package org.dominokit.domino.ui.upload;

public interface FilePreviewFactory {
    String[] UNITS = {"KB", "MB", "GB", "TB"};
    IsFilePreview<?> forFile(FileItem fileItem);
}
