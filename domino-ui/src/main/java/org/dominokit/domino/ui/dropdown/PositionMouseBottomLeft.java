package org.dominokit.domino.ui.dropdown;

import elemental2.dom.DOMRect;
import elemental2.dom.HTMLElement;
import elemental2.dom.MouseEvent;

import static org.dominokit.domino.ui.style.Unit.px;

/**
 * Positions the menu on the bottom left of the mouse click location
 */
public class PositionMouseBottomLeft implements DropDownPosition {

    private final MouseEvent mouseEvent;

    public PositionMouseBottomLeft(MouseEvent mouseEvent) {
        this.mouseEvent = mouseEvent;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void position(HTMLElement actionsMenu, HTMLElement target) {
        DOMRect actionsRect = actionsMenu.getBoundingClientRect();

        actionsMenu.style.setProperty("top", px.of(mouseEvent.clientY));
        actionsMenu.style.setProperty("left", px.of(mouseEvent.clientX - actionsRect.width));
    }
}
