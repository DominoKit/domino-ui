package org.dominokit.domino.ui.button;

/**
 * An enum that lists all predefined button sizes.
 * each enum value represent one css class that changes the button height.
 */
public enum ButtonSize {
    /**
     * Large height
     */
    LARGE("lg"),
    /**
     * Medium height
     */
    MEDIUM("md"),
    /**
     * Small height
     */
    SMALL("sm"),
    /**
     * Extra small height
     */
    XSMALL("xs");

    private String style;

    /**
     *
     * @param style String css class name
     */
    ButtonSize(String style) {
        this.style = style;
    }

    /**
     *
     * @return String css class name for a button size
     */
    public String getStyle() {
        return style;
    }
}
