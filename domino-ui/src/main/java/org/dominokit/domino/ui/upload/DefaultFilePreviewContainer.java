package org.dominokit.domino.ui.upload;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class DefaultFilePreviewContainer extends BaseDominoElement<HTMLDivElement, DefaultFilePreviewContainer>
        implements FilePreviewContainer<HTMLDivElement, DefaultFilePreviewContainer>,
        FileUploadStyles {

    private final Row rootRow;

    public DefaultFilePreviewContainer() {
        rootRow = Row.create()
                .addCss(dui_gap_2)
                .addCss(dui_file_preview_container);
        init(this);
    }

    @Override
    public DefaultFilePreviewContainer appendChild(FileItem fileItem) {
        rootRow.span2(fileItem);
        return this;
    }

    @Override
    public HTMLDivElement element() {
        return rootRow.element();
    }
}
