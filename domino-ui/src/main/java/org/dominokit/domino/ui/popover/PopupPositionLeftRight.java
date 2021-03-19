package org.dominokit.domino.ui.popover;

import elemental2.dom.DOMRect;
import elemental2.dom.HTMLElement;

import static elemental2.dom.DomGlobal.window;

/**
 * Position the popover on the right or the left based on the location of the target element in the screen.
 * <p>
 * I.e. if showing the popover on the left will exceed the window, then it will be better to show it on the right
 */
public class PopupPositionLeftRight implements PopupPosition {

    private String positionClass;

    /**
     * {@inheritDoc}
     */
    @Override
    public void position(HTMLElement popup, HTMLElement target) {
        DOMRect targetRect = target.getBoundingClientRect();

        double distanceToCenter = (targetRect.left) - (targetRect.width / 2);
        double windowCenter = window.innerWidth >> 1;

        if (distanceToCenter >= windowCenter) {
            PopupPosition.LEFT.position(popup, target);
            this.positionClass = PopupPosition.LEFT.getDirectionClass();
        } else {
            PopupPosition.RIGHT.position(popup, target);
            this.positionClass = PopupPosition.RIGHT.getDirectionClass();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDirectionClass() {
        return positionClass;
    }
}
