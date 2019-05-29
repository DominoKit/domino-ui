package org.dominokit.domino.ui.grid.flex;

import org.dominokit.domino.ui.style.IsCssClass;

public enum FlexAlign implements IsCssClass {
    START(FlexStyles.FLEX_ALIGN_START),
    END(FlexStyles.FLEX_ALIGN_END),
    CENTER(FlexStyles.FLEX_ALIGN_CENTER),
    STRETCH(FlexStyles.FLEX_ALIGN_STRETCH),
    BASE_LINE(FlexStyles.FLEX_ALIGN_BASELINE);

    private String style;

    FlexAlign(String style) {
        this.style = style;
    }

    @Override
    public String getStyle() {
        return style;
    }
}
