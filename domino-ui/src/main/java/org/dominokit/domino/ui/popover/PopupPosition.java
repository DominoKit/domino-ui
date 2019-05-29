package org.dominokit.domino.ui.popover;

import elemental2.dom.HTMLElement;

public interface PopupPosition {
    void position(HTMLElement tooltip, HTMLElement target);
    String getDirectionClass();

    PopupPosition RIGHT= new PopupPositionRight();
    PopupPosition TOP= new PopupPositionTop();
    PopupPosition LEFT= new PopupPositionLeft();
    PopupPosition BOTTOM= new PopupPositionBottom();
    PopupPosition TOP_DOWN = new PopupPositionTopDown();
    PopupPosition LEFT_RIGHT = new PopupPositionLeftRight();
}
