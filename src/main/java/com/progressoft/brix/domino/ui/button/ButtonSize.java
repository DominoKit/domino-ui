package com.progressoft.brix.domino.ui.button;

public enum ButtonSize {
    LARGE("lg"),
    SMALL("sm"),
    XSMALL("xs");

    private String style;

    ButtonSize(String style) {
        this.style = style;
    }

    public String getStyle() {
        return style;
    }
}
