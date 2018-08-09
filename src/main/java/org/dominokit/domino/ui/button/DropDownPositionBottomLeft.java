package org.dominokit.domino.ui.button;

import elemental2.dom.HTMLElement;

public class DropDownPositionBottomLeft implements DropDownPosition {
    @Override
    public void position(HTMLElement actionsMenu, HTMLElement target) {
        actionsMenu.style.setProperty("top", "100%");
        actionsMenu.style.setProperty("left", "-250%");
    }
}
