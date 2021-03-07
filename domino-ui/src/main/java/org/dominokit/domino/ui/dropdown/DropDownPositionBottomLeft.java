package org.dominokit.domino.ui.dropdown;

import elemental2.dom.DOMRect;
import elemental2.dom.HTMLElement;

import static elemental2.dom.DomGlobal.window;
import static org.dominokit.domino.ui.style.Unit.px;

/**
 * Positions the menu on the bottom left of its target element
 */
public class DropDownPositionBottomLeft implements DropDownPosition {

    /**
     * {@inheritDoc}
     */
    @Override
    public void position(HTMLElement actionsMenu, HTMLElement target) {
        DOMRect targetRect = target.getBoundingClientRect();
        DOMRect actionsRect = actionsMenu.getBoundingClientRect();
        actionsMenu.style.setProperty("top", px.of((targetRect.top + window.pageYOffset) + targetRect.height));
        actionsMenu.style.setProperty("left", px.of(targetRect.left + window.pageXOffset - actionsRect.width));
    }
}
