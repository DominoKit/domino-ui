package org.dominokit.domino.ui.grid.flex;

import org.dominokit.domino.ui.style.IsCssClass;

/**
 * An enum representing the wrapping of the layout
 */
public enum FlexWrap implements IsCssClass {
    /**
     * No wrap of the items
     */
    NO_WRAP(FlexStyles.FLEX_WRAP_NOWRAP),
    /**
     * Wrap the items from top to bottom
     */
    WRAP_TOP_TO_BOTTOM(FlexStyles.FLEX_WRAP_WRAP),
    /**
     * Wrap the items from bottom to top
     */
    WRAP_BOTTOM_TO_TOP(FlexStyles.FLEX_WRAP_WRAP_REVERSE);

    private final String style;

    FlexWrap(String style) {
        this.style = style;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getStyle() {
        return style;
    }
}
