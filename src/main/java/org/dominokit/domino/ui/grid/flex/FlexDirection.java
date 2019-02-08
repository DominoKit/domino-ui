package org.dominokit.domino.ui.grid.flex;

import org.dominokit.domino.ui.style.IsCssClass;

public enum FlexDirection implements IsCssClass {
    LEFT_TO_RIGHT("flex-dir-row"),
    RIGHT_TO_LEFT("flex-dir-row-reverse"),
    TOP_TO_BOTTOM("flex-dir-column"),
    BOTTOM_TO_TOP("flex-dir-column-reverse");

    private String style;

    FlexDirection(String style) {
        this.style = style;
    }

    @Override
    public String getStyle() {
        return style;
    }
}
