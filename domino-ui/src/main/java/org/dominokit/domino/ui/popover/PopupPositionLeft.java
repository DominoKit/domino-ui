package org.dominokit.domino.ui.popover;

import elemental2.dom.DOMRect;
import elemental2.dom.HTMLElement;

import static elemental2.dom.DomGlobal.window;

/**
 * Position the popover on the left
 */
public class PopupPositionLeft implements PopupPosition {
    /**
     * {@inheritDoc}
     */
    @Override
    public void position(HTMLElement tooltip, HTMLElement target) {
        DOMRect targetRect = target.getBoundingClientRect();
        DOMRect tooltipRect = tooltip.getBoundingClientRect();
        tooltip.style.setProperty("top", (targetRect.top + window.pageYOffset) + ((targetRect.height - tooltipRect.height) / 2) + "px");
        tooltip.style.setProperty("left", targetRect.left - window.pageXOffset - tooltipRect.width + "px");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDirectionClass() {
        return "left";
    }
}
