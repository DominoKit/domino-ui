package org.dominokit.domino.ui.dropdown;

import elemental2.dom.ClientRect;
import elemental2.dom.HTMLElement;

import static elemental2.dom.DomGlobal.window;

public class DropDownPositionBottomRight implements DropDownPosition {
    @Override
    public void position(HTMLElement actionsMenu, HTMLElement target) {
        ClientRect targetRect = target.getBoundingClientRect();
        ClientRect actionsRect = actionsMenu.getBoundingClientRect();
        actionsMenu.style.setProperty("top", ((targetRect.top + window.scrollY) + targetRect.height + 35 + "px"));
        actionsMenu.style.setProperty("left", targetRect.left + window.scrollX + targetRect.width + "px");
    }
}
