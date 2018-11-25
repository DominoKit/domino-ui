package org.dominokit.domino.ui.dropdown;

import elemental2.dom.ClientRect;
import elemental2.dom.HTMLElement;

import static elemental2.dom.DomGlobal.window;

public class DropDownPositionTop implements DropDownPosition {
    @Override
    public void position(HTMLElement actionsMenu, HTMLElement target) {
        ClientRect targetRect = target.getBoundingClientRect();
        ClientRect tooltipRect = actionsMenu.getBoundingClientRect();
        actionsMenu.style.setProperty("top", ((targetRect.top + window.pageYOffset) - tooltipRect.height) + "px");
        actionsMenu.style.setProperty("left", targetRect.left + window.pageXOffset + "px");
    }
}
