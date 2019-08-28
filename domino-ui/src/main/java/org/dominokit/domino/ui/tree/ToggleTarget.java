package org.dominokit.domino.ui.tree;

public enum ToggleTarget {
    ANY("tgl-any"), ICON("tgl-icon"), EXPAND_COLLAPSE_INDICATOR("tgl-expand");
    private String style;

    ToggleTarget(String style) {
        this.style = style;
    }

    public String getStyle() {
        return style;
    }
}
