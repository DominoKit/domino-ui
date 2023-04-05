package org.dominokit.domino.ui.thumbnails;

import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.style.HasCssClass;
import org.dominokit.domino.ui.style.SpacingCss;

public enum ThumbnailDirection implements HasCssClass {
    ROW(SpacingCss.dui_flex_row),
    ROW_REVERSE(SpacingCss.dui_flex_row_reverse),
    COLUMN(SpacingCss.dui_flex_col),
    COLUMN_REVERSE(SpacingCss.dui_flex_col_reverse);

    private final CssClass cssClass;

    ThumbnailDirection(CssClass cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public CssClass getCssClass() {
        return cssClass;
    }
}
