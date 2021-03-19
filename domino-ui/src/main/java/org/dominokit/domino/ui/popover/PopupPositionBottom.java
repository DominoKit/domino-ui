package org.dominokit.domino.ui.popover;

import elemental2.dom.DOMRect;
import elemental2.dom.HTMLElement;

import static elemental2.dom.DomGlobal.window;

/**
 * Position the popover on the bottom
 */
public class PopupPositionBottom implements PopupPosition {
    /**
     * {@inheritDoc}
     */
    @Override
    public void position(HTMLElement tooltip, HTMLElement target) {
        DOMRect targetRect = target.getBoundingClientRect();
        DOMRect tooltipRect = tooltip.getBoundingClientRect();
        tooltip.style.setProperty("top", (targetRect.top + window.pageYOffset + targetRect.height) + "px");
        tooltip.style.setProperty("left", targetRect.left + ((targetRect.width - tooltipRect.width) / 2) + "px");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDirectionClass() {
        return "bottom";
    }
}
