package org.dominokit.domino.ui.popover;

import elemental2.dom.ClientRect;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;

import static elemental2.dom.DomGlobal.*;

public class PopupPositionBottom implements PopupPosition {
    @Override
    public void position(HTMLElement tooltip, HTMLElement target) {
        ClientRect targetRect = target.getBoundingClientRect();
        ClientRect tooltipRect = tooltip.getBoundingClientRect();
        tooltip.style.setProperty("top", (targetRect.top+ window.scrollY+targetRect.height)+"px");
        tooltip.style.setProperty("left", targetRect.left+((targetRect.width-tooltipRect.width)/2)+"px");
    }

    @Override
    public String getDirectionClass() {
        return "bottom";
    }
}
