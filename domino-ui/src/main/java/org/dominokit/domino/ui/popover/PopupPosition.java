package org.dominokit.domino.ui.popover;

import elemental2.dom.HTMLElement;

/**
 * An interface for the required API to implement new position classes for popover
 */
public interface PopupPosition {
    /**
     * Positions the popover based on the target element
     *
     * @param tooltip the popover element
     * @param target  the target element
     */
    void position(HTMLElement tooltip, HTMLElement target);

    /**
     * @return the CSS class for the position
     */
    String getDirectionClass();

    PopupPosition RIGHT = new PopupPositionRight();
    PopupPosition TOP = new PopupPositionTop();
    PopupPosition LEFT = new PopupPositionLeft();
    PopupPosition BOTTOM = new PopupPositionBottom();
    /**
     * use {@link PopupPosition#BEST_FIT}
     */
    @Deprecated
    PopupPosition TOP_DOWN = new PopupPositionTopDown();
    PopupPosition BEST_FIT = new PopupPositionBestFit();
    PopupPosition LEFT_RIGHT = new PopupPositionLeftRight();
}
