package org.dominokit.domino.ui.grid.flex;

import org.dominokit.domino.ui.style.IsCssClass;

public enum FlexAlign implements IsCssClass {
    START("flex-start"),
    END("flex-end"),
    CENTER("center"),
    STRETCH("stretch"),
    BASE_LINE("baseline");

    private String style;

    FlexAlign(String style) {
        this.style = style;
    }

    @Override
    public String getStyle() {
        return style;
    }
}
