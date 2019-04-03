package org.dominokit.domino.ui.grid.flex;

import org.dominokit.domino.ui.style.IsCssClass;

public enum FlexJustifyContent implements IsCssClass {
    START(FlexStyles.FLEX_JUST_START),
    END(FlexStyles.FLEX_JUST_END),
    CENTER(FlexStyles.FLEX_JUST_CENTER),
    SPACE_BETWEEN(FlexStyles.FLEX_JUST_SPACE_BETWEEN),
    SPACE_AROUND(FlexStyles.FLEX_JUST_SPACE_AROUND),
    SPACE_EVENLY(FlexStyles.FLEX_JUST_SPACE_EVENLY);

    private String style;

    FlexJustifyContent(String style) {
        this.style = style;
    }

    @Override
    public String getStyle() {
        return style;
    }
}
