package org.dominokit.domino.ui.grid.flex;

import org.dominokit.domino.ui.style.IsCssClass;

public enum FlexAlign implements IsCssClass {
    START("flex-align-start"),
    END("flex-align-end"),
    CENTER("flex-align-center"),
    STRETCH("flex-align-stretch"),
    BASE_LINE("flex-align-baseline");

    private String style;

    FlexAlign(String style) {
        this.style = style;
    }

    @Override
    public String getStyle() {
        return style;
    }
}
