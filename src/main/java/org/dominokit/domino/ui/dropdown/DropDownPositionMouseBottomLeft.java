package org.dominokit.domino.ui.dropdown;

import elemental2.dom.ClientRect;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;
import elemental2.dom.MouseEvent;

import static elemental2.dom.DomGlobal.window;
import static org.dominokit.domino.ui.style.Unit.px;

public class DropDownPositionMouseBottomLeft implements DropDownPosition {

    private final MouseEvent mouseEvent;

    public DropDownPositionMouseBottomLeft(MouseEvent mouseEvent) {
        this.mouseEvent = mouseEvent;
    }

    @Override
    public void position(HTMLElement actionsMenu, HTMLElement target) {

        ClientRect targetRect = target.getBoundingClientRect();
        ClientRect actionsRect = actionsMenu.getBoundingClientRect();

        DomGlobal.console.info(mouseEvent.clientY + " : "+(mouseEvent.clientY - actionsRect.width));
        actionsMenu.style.setProperty("top", px.of(mouseEvent.clientY));
        actionsMenu.style.setProperty("left", px.of(mouseEvent.clientY - actionsRect.width));
    }
}
