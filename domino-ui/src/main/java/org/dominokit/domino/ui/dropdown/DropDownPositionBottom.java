package org.dominokit.domino.ui.dropdown;

import elemental2.dom.ClientRect;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.style.Unit;

import static elemental2.dom.DomGlobal.window;
import static org.dominokit.domino.ui.style.Unit.*;

public class DropDownPositionBottom implements DropDownPosition {
    @Override
    public void position(HTMLElement actionsMenu, HTMLElement target) {
        ClientRect targetRect = target.getBoundingClientRect();
        actionsMenu.style.setProperty("top", px.of((targetRect.top + window.pageYOffset + targetRect.height)));
        actionsMenu.style.setProperty("left", px.of(targetRect.left + window.pageXOffset));
    }
}
