package org.dominokit.domino.ui.tree;

/**
 * An enum representing what toggles the tree item
 */
public enum ToggleTarget {
    /**
     * any element inside the item
     */
    ANY("tgl-any"),
    /**
     * the icon of the item
     */
    ICON("tgl-icon");

    private final String style;

    ToggleTarget(String style) {
        this.style = style;
    }

    /**
     * @return the CSS style
     */
    public String getStyle() {
        return style;
    }
}
