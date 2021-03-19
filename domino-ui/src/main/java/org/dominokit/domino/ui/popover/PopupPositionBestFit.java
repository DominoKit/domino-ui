package org.dominokit.domino.ui.popover;

import elemental2.dom.DOMRect;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;

/**
 * Position the popover on the better position based on the target element location in the screen.
 * <p>
 * I.e. if the popover will exceed the window from the bottom, then it will be better to show it on the top
 */
public class PopupPositionBestFit implements PopupPosition {

    private String positionClass;

    /**
     * {@inheritDoc}
     */
    @Override
    public void position(HTMLElement popup, HTMLElement target) {
        DOMRect targetRect = target.getBoundingClientRect();
        double bottom = targetRect.bottom + popup.getBoundingClientRect().height;
        double right = targetRect.right + popup.getBoundingClientRect().height;

        int innerHeight = DomGlobal.window.innerHeight;

        if (bottom < innerHeight) {
            position(popup, target, BOTTOM);
        } else if (popup.getBoundingClientRect().height < targetRect.top) {
            position(popup, target, TOP);
        } else if (popup.getBoundingClientRect().width < targetRect.left) {
            position(popup, target, LEFT);
        } else if (right < DomGlobal.window.innerWidth) {
            position(popup, target, RIGHT);
        } else {
            position(popup, target, BOTTOM);
        }
    }

    protected void position(HTMLElement popup, HTMLElement target, PopupPosition popupPosition) {
        popupPosition.position(popup, target);
        this.positionClass = popupPosition.getDirectionClass();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDirectionClass() {
        return positionClass;
    }
}
