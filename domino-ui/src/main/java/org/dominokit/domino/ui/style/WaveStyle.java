package org.dominokit.domino.ui.style;

/**
 * An enum representing the wave styles supported
 */
public enum WaveStyle {

    FLOAT("waves-float"),
    CIRCLE("waves-circle"),
    RIPPLE("waves-ripple"),
    BLOCK("waves-block");

    private final String style;

    WaveStyle(String style) {
        this.style = style;
    }

    /**
     * @return the css style of the wave style
     */
    public String getStyle() {
        return style;
    }
}
