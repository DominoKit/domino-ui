package org.dominokit.domino.ui.dropdown;

import elemental2.dom.HTMLElement;

/**
 * The dropdown position
 * <p>
 * An interface to position the dropdown relative to its target element
 */
public interface DropDownPosition {

    /**
     * Positions the menu on the top of its target element
     */
    DropDownPosition TOP = new DropDownPositionTop();
    /**
     * Positions the menu on the top right of its target element
     */
    DropDownPosition TOP_RIGHT = new DropDownPositionTopRight();
    /**
     * Positions the menu on the top left of its target element
     */
    DropDownPosition TOP_LEFT = new DropDownPositionTopLeft();
    /**
     * Positions the menu on the bottom of its target element
     */
    DropDownPosition BOTTOM = new DropDownPositionBottom();
    /**
     * Positions the menu on the bottom left of its target element
     */
    DropDownPosition BOTTOM_LEFT = new DropDownPositionBottomLeft();
    /**
     * Positions the menu on the bottom right of its target element
     */
    DropDownPosition BOTTOM_RIGHT = new DropDownPositionBottomRight();

    /**
     * Positions the menu based on its target
     *
     * @param actionsMenu the menu
     * @param target      the target element
     */
    void position(HTMLElement actionsMenu, HTMLElement target);
}
