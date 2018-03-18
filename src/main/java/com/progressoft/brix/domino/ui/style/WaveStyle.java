package com.progressoft.brix.domino.ui.style;

public enum WaveStyle {

    FLOAT("waves-float"),
    CIRCLE("waves-circle"),
    RIPPLE("waves-ripple"),
    BLOCK("waves-block");

    private final String style;

    WaveStyle(String style) {
        this.style = style;
    }

    public String getStyle() {
        return style;
    }
}
