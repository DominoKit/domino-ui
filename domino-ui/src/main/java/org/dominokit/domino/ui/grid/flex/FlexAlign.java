package org.dominokit.domino.ui.grid.flex;

import org.dominokit.domino.ui.style.IsCssClass;

public enum FlexAlign implements IsCssClass {
    START(FlexStyles.FLEX_ALIGN_START, "flex-start"),
    END(FlexStyles.FLEX_ALIGN_END, "flex-end"),
    CENTER(FlexStyles.FLEX_ALIGN_CENTER, "center"),
    STRETCH(FlexStyles.FLEX_ALIGN_STRETCH, "stretch"),
    BASE_LINE(FlexStyles.FLEX_ALIGN_BASELINE, "baseline");

    private String style;
    private String value;

    FlexAlign(String style, String value) {
        this.style = style;
        this.value = value;
    }

    @Override
    public String getStyle() {
        return style;
    }

    public String getValue() {
        return value;
    }
}
