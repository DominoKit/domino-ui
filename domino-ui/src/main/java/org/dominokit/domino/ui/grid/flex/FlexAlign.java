package org.dominokit.domino.ui.grid.flex;

import org.dominokit.domino.ui.style.IsCssClass;

/**
 * Am enum representing the alignment of flex
 */
public enum FlexAlign implements IsCssClass {
    /**
     * The alignment will be at the start of the layout
     */
    START(FlexStyles.FLEX_ALIGN_START, "flex-start"),
    /**
     * The alignment will be at the end of the layout
     */
    END(FlexStyles.FLEX_ALIGN_END, "flex-end"),
    /**
     * The alignment will be at the center of the layout
     */
    CENTER(FlexStyles.FLEX_ALIGN_CENTER, "center"),
    /**
     * The alignment will cover all the layout
     */
    STRETCH(FlexStyles.FLEX_ALIGN_STRETCH, "stretch"),
    /**
     * The alignment will be based on the original alignment
     */
    BASE_LINE(FlexStyles.FLEX_ALIGN_BASELINE, "baseline");

    private final String style;
    private final String value;

    FlexAlign(String style, String value) {
        this.style = style;
        this.value = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getStyle() {
        return style;
    }

    /**
     * @return The style
     */
    public String getValue() {
        return value;
    }
}
