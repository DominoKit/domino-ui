package org.dominokit.domino.ui.button;

import elemental2.dom.HTMLElement;

public interface DropDownPosition {
    void position(HTMLElement actionsMenu, HTMLElement target);

    DropDownPosition TOP_RIGHT = new DropDownPositionTopRight();
    DropDownPosition TOP_LEFT = new DropDownPositionTopLeft();
    DropDownPosition BOTTOM_LEFT = new DropDownPositionBottomLeft();
    DropDownPosition BOTTOM_RIGHT = new DropDownPositionBottomRight();
}
