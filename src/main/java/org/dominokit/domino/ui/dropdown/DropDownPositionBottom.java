package org.dominokit.domino.ui.dropdown;

import elemental2.dom.ClientRect;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;

import static elemental2.dom.DomGlobal.window;

public class DropDownPositionBottom implements DropDownPosition {
    @Override
    public void position(HTMLElement actionsMenu, HTMLElement target) {
        ClientRect targetRect = target.getBoundingClientRect();
        actionsMenu.style.setProperty("top", (targetRect.top + window.pageYOffset + targetRect.height) + "px");
        actionsMenu.style.setProperty("left", targetRect.left + window.pageXOffset + "px");
    }
}
