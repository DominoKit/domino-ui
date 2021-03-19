package org.dominokit.domino.ui.popover;

import elemental2.dom.DOMRect;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;

/**
 * Position the popover on the right
 */
public class PopupPositionRight implements PopupPosition {
    /**
     * {@inheritDoc}
     */
    @Override
    public void position(HTMLElement tooltip, HTMLElement target) {
        DOMRect targetRect = target.getBoundingClientRect();
        DOMRect tooltipRect = tooltip.getBoundingClientRect();
        tooltip.style.setProperty("top", (targetRect.top + DomGlobal.window.pageYOffset) + ((targetRect.height - tooltipRect.height) / 2) + "px");
        tooltip.style.setProperty("left", targetRect.left + DomGlobal.window.pageXOffset + targetRect.width + "px");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDirectionClass() {
        return "right";
    }
}
