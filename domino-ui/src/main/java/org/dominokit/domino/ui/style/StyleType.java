package org.dominokit.domino.ui.style;

/**
 * Enum that lists different predefined informative styles
 * <p>
 *     Each enum value represent a different css class to style the element
 * </p>
 */
public enum StyleType {
    /**
     * a default style that indicate no special information
     */
    DEFAULT("default"),
    /**
     * marks an element as a primary.
     */
    PRIMARY("primary"),
    /**
     * indicates a success operation
     */
    SUCCESS("success"),
    /**
     * mark an element as one that has some information
     */
    INFO("info"),
    /**
     * mark an element as one that requires user attention
     */
    WARNING("warning"),
    /**
     * indicates an error or something went wrong
     */
    DANGER("danger");

    private String style;

    /**
     *
     * @param style String css class name
     */
    StyleType(String style) {
        this.style = style;
    }

    /**
     *
     * @return the css class name that represent the informative style.
     */
    public String getStyle() {
        return style;
    }
}
