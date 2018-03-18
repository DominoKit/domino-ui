package com.progressoft.brix.domino.ui.style;

public enum StyleType {
    DEFAULT("default"),
    PRIMARY("primary"),
    SUCCESS("success"),
    INFO("info"),
    WARNING("warning"),
    DANGER("danger");

    private String style;

    StyleType(String style) {
        this.style = style;
    }

    public String getStyle() {
        return style;
    }
}
