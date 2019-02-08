package org.dominokit.domino.ui.grid.flex;

import org.dominokit.domino.ui.style.IsCssClass;

public enum FlexJustifyContent implements IsCssClass {
    START("flex-just-start"),
    END("flex-just-end"),
    CENTER("flex-just-center"),
    SPACE_BETWEEN("flex-just-space-between"),
    SPACE_AROUND("flex-just-space-around"),
    SPACE_EVENLY("flex-just-space-evenly");

    private String style;

    FlexJustifyContent(String style) {
        this.style = style;
    }

    @Override
    public String getStyle() {
        return style;
    }
}
