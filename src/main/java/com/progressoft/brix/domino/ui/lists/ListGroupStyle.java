package com.progressoft.brix.domino.ui.lists;

public enum  ListGroupStyle {

    SUCCESS("list-group-item-success"),
    WARNING("list-group-item-warning"),
    INFO("list-group-item-info"),
    ERROR("list-group-item-danger");

    private String style;

    ListGroupStyle(String style) {
        this.style = style;
    }

    public String getStyle() {
        return style;
    }
}
