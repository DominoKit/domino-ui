package org.dominokit.domino.ui.grid.flex;

import org.dominokit.domino.ui.style.IsCssClass;

public enum FlexWrap implements IsCssClass {
    NO_WRAP("flex-wrap-nowrap"),
    WRAP_TOP_TO_BOTTOM("flex-wrap-wrap"),
    WRAP_BOTTOM_TO_TOP("flex-wrap-wrap-reverse");

    private String style;

    FlexWrap(String style) {
        this.style = style;
    }

    @Override
    public String getStyle() {
        return style;
    }
}
