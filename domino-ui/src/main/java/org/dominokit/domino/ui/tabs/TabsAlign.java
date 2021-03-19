package org.dominokit.domino.ui.tabs;

/**
 * An enum to list possible values for tabs align
 */
public enum TabsAlign {
    /**
     * Tabs headers will be aligned to the left of the tab panel
     */
    LEFT("tabs-left"),
    /**
     * Tabs headers will be aligned to the center of the tab panel
     */
    CENTER("tabs-center"),
    /**
     * Tabs headers will be aligned to the right of the tab panel
     */
    RIGHT("tabs-right");

    private String align;

    /**
     *
     * @param align String css class name for the tab align
     */
    TabsAlign(String align) {
        this.align = align;
    }

    /**
     *
     * @return String css class name for the tab align
     */
    public String getAlign() {
        return align;
    }
}
