package org.dominokit.domino.ui.dropdown;

import elemental2.dom.ClientRect;
import elemental2.dom.HTMLElement;
import elemental2.dom.MouseEvent;

import static org.dominokit.domino.ui.style.Unit.px;

public class PositionMouseTopRight implements DropDownPosition {

    private final MouseEvent mouseEvent;

    public PositionMouseTopRight(MouseEvent mouseEvent) {
        this.mouseEvent = mouseEvent;
    }

    @Override
    public void position(HTMLElement actionsMenu, HTMLElement target) {

        ClientRect actionsRect = actionsMenu.getBoundingClientRect();

        actionsMenu.style.setProperty("top", px.of(mouseEvent.clientY - actionsRect.height));
        actionsMenu.style.setProperty("left", px.of(mouseEvent.clientX ));
    }
}
