package org.dominokit.domino.ui.button;

public enum CircleSize {
    SMALL("btn-circle"),
    LARGE("btn-circle-lg");

    private String style;

    CircleSize(String style) {
        this.style = style;
    }

    public String getStyle() {
        return style;
    }
}
