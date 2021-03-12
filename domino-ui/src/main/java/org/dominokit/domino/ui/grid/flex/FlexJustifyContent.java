package org.dominokit.domino.ui.grid.flex;

import org.dominokit.domino.ui.style.IsCssClass;

/**
 * An enum representing how content is distributed inside the layout
 */
public enum FlexJustifyContent implements IsCssClass {
    /**
     * At the start of the layout
     */
    START(FlexStyles.FLEX_JUST_START),
    /**
     * At the end of the layout
     */
    END(FlexStyles.FLEX_JUST_END),
    /**
     * At the center of the layout
     */
    CENTER(FlexStyles.FLEX_JUST_CENTER),
    /**
     * Evenly distributed over all the content; first item at the start and last item at the end of the layout
     */
    SPACE_BETWEEN(FlexStyles.FLEX_JUST_SPACE_BETWEEN),
    /**
     * Evenly distributed over all the content
     */
    SPACE_AROUND(FlexStyles.FLEX_JUST_SPACE_AROUND),
    /**
     * Evenly distributed over all the content with the same spacing between all items
     */
    SPACE_EVENLY(FlexStyles.FLEX_JUST_SPACE_EVENLY);

    private final String style;

    FlexJustifyContent(String style) {
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
