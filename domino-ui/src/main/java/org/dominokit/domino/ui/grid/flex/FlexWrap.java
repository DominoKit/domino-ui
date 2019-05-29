package org.dominokit.domino.ui.grid.flex;

import org.dominokit.domino.ui.style.IsCssClass;

public enum FlexWrap implements IsCssClass {
    NO_WRAP(FlexStyles.FLEX_WRAP_NOWRAP),
    WRAP_TOP_TO_BOTTOM(FlexStyles.FLEX_WRAP_WRAP),
    WRAP_BOTTOM_TO_TOP(FlexStyles.FLEX_WRAP_WRAP_REVERSE);

    private String style;

    FlexWrap(String style) {
        this.style = style;
    }

    @Override
    public String getStyle() {
        return style;
    }
}
