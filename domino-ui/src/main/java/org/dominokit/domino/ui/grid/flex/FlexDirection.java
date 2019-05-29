package org.dominokit.domino.ui.grid.flex;

import org.dominokit.domino.ui.style.IsCssClass;

public enum FlexDirection implements IsCssClass {
    LEFT_TO_RIGHT(FlexStyles.FLEX_DIR_ROW),
    RIGHT_TO_LEFT(FlexStyles.FLEX_DIR_ROW_REVERSE),
    TOP_TO_BOTTOM(FlexStyles.FLEX_DIR_COLUMN),
    BOTTOM_TO_TOP(FlexStyles.FLEX_DIR_COLUMN_REVERSE);

    private String style;

    FlexDirection(String style) {
        this.style = style;
    }

    @Override
    public String getStyle() {
        return style;
    }
}
