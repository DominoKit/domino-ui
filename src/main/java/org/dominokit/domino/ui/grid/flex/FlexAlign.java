package org.dominokit.domino.ui.grid.flex;

public enum FlexAlign {
    START("flex-start"),
    END("flex-end"),
    CENTER("center"),
    STRETCH("stretch"),
    BASE_LINE("base-line");

    private String style;

    FlexAlign(String style) {
        this.style = style;
    }

    public String getStyle() {
        return style;
    }
}
