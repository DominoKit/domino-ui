package org.dominokit.domino.ui.tabs;

public enum TabsAlign {
    LEFT("tabs-left"), CENTER("tabs-center"), RIGHT("tabs-right");

    private String align;

    TabsAlign(String align) {
        this.align = align;
    }

    public String getAlign() {
        return align;
    }
}
