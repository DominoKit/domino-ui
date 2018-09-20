package org.dominokit.domino.ui.grid.flex;

public enum FlexWrap {
    NO_WRAP("nowrap"),
    WRAP_TOP_TO_BOTTOM("wrap"),
    WRAP_BOTTOM_TO_TOP("wrap-reverse");

    private String style;

    FlexWrap(String style) {
        this.style = style;
    }

    public String getStyle() {
        return style;
    }
}
