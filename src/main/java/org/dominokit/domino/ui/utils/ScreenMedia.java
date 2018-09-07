package org.dominokit.domino.ui.utils;

public enum ScreenMedia {
    XSMALL_ONLY("xsmall-only"),
    XSMALL_AND_UP("xsmall-and-up"),

    SMALL_ONLY("small-only"),
    SMALL_AND_DOWN("small-and-down"),
    SMALL_AND_UP("small-and-up"),

    MEDIUM_ONLY("medium-only"),
    MEDIUM_AND_DOWN("medium-and-down"),
    MEDIUM_AND_UP("medium-and-up"),

    LARGE_ONLY("large-only"),
    LARGE_AND_DOWN("large-and-down"),
    LARGE_AND_UP("large-and-up"),

    XLARGE_ONLY("xlarge-only"),
    XLARGE_AND_DOWN("xlarge-and-down"),
    XLARGE_AND_UP("xlarge-and-up");

    private String style;

    ScreenMedia(String style) {
        this.style = style;
    }

    public String getStyle() {
        return style;
    }
}
