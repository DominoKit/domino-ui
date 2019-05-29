package org.dominokit.domino.ui.dropdown;

import elemental2.dom.ClientRect;
import elemental2.dom.HTMLElement;

import static elemental2.dom.DomGlobal.window;
import static org.dominokit.domino.ui.style.Unit.px;

public class DropDownPositionTopLeft implements DropDownPosition {
    @Override
    public void position(HTMLElement actionsMenu, HTMLElement target) {
        ClientRect targetRect = target.getBoundingClientRect();
        ClientRect actionsRect = actionsMenu.getBoundingClientRect();
        actionsMenu.style.setProperty("top", px.of((targetRect.top + window.pageYOffset) - actionsRect.height));
        actionsMenu.style.setProperty("left", px.of(targetRect.left + window.pageXOffset - actionsRect.width));
    }
}
