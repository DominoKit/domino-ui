package org.dominokit.domino.ui.grid.flex;

public enum FlexJustifyContent {
    START("flex-start"),
    END("flex-end"),
    CENTER("center"),
    SPACE_BETWEEN("space-between"),
    SPACE_AROUND("space-around"),
    SPACE_EVENLY("space-evenly");

    private String style;

    FlexJustifyContent(String style) {
        this.style = style;
    }

    public String getStyle() {
        return style;
    }
}
