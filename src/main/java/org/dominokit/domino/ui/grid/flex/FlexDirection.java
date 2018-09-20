package org.dominokit.domino.ui.grid.flex;

public enum FlexDirection {
    LEFT_TO_RIGHT("row"),
    RIGHT_TO_LEFT("row-reverse"),
    TOP_TO_BOTTOM("column"),
    BOTTOM_TO_TOP("column-reverse");

    private String style;

    FlexDirection(String style) {
        this.style = style;
    }

    public String getStyle() {
        return style;
    }
}
