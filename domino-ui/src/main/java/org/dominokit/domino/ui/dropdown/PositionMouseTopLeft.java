package org.dominokit.domino.ui.dropdown;

import elemental2.dom.DOMRect;
import elemental2.dom.HTMLElement;
import elemental2.dom.MouseEvent;

import static org.dominokit.domino.ui.style.Unit.px;

/**
 * Positions the menu on the top left of the mouse click location
 */
public class PositionMouseTopLeft implements DropDownPosition {

    private final MouseEvent mouseEvent;

    public PositionMouseTopLeft(MouseEvent mouseEvent) {
        this.mouseEvent = mouseEvent;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void position(HTMLElement actionsMenu, HTMLElement target) {
        DOMRect actionsRect = actionsMenu.getBoundingClientRect();

        actionsMenu.style.setProperty("top", px.of(mouseEvent.clientY - actionsRect.height));
        actionsMenu.style.setProperty("left", px.of(mouseEvent.clientX - actionsRect.width));
    }
}
