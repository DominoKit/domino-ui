package org.dominokit.domino.ui.utils;

import elemental2.dom.*;
import jsinterop.base.Js;

import java.util.Date;

import static org.dominokit.domino.ui.utils.SwipeUtil.SwipeDirection.*;

/**
 * A utility class to register swap events listeners on elements
 */
public class SwipeUtil {

    /**
     * Adds a swap listener on an element
     * @param direction {@link SwipeDirection}
     * @param element the target {@link HTMLElement}
     * @param listener {@link EventListener}
     */
    public static void addSwipeListener(SwipeDirection direction, HTMLElement element, EventListener listener) {
        HTMLElement touchsurface = element;

        SwipeData swipeData = new SwipeData();

        touchsurface.addEventListener("touchstart", evt -> {
            TouchEvent touchEvent = Js.uncheckedCast(evt);
            Touch touchobj = touchEvent.changedTouches.item(0);
            swipeData.swipedir = "none";
            swipeData.startX = touchobj.pageX;
            swipeData.startY = touchobj.pageY;
            swipeData.startTime = new Date().getTime(); // record time when finger first makes contact with surface
            evt.preventDefault();
        }, false);

        // prevent scrolling when inside DIV
        touchsurface.addEventListener("touchmove", Event::preventDefault, false);

        touchsurface.addEventListener("touchend", evt -> {
            TouchEvent touchEvent = Js.uncheckedCast(evt);
            Touch touchobj = touchEvent.changedTouches.item(0);
            swipeData.distX = touchobj.pageX - swipeData.startX; // get horizontal dist traveled by finger while in contact with surface
            swipeData.distY = touchobj.pageY - swipeData.startY; // get vertical dist traveled by finger while in contact with surface
            swipeData.elapsedTime = new Date().getTime() - swipeData.startTime; // get time elapsed
            if (swipeData.elapsedTime <= swipeData.allowedTime) { // first condition for awipe met
                if (Math.abs(swipeData.distX) >= swipeData.threshold && Math.abs(swipeData.distY) <= swipeData.restraint) { // 2nd condition for horizontal swipe met
                    swipeData.swipedir = (swipeData.distX < 0) ? LEFT.direction : RIGHT.direction; // if dist traveled is negative, it indicates left swipe
                } else if (Math.abs(swipeData.distY) >= swipeData.threshold && Math.abs(swipeData.distX) <= swipeData.restraint) { // 2nd condition for vertical swipe met
                    swipeData.swipedir = (swipeData.distY < 0) ? UP.direction : DOWN.direction; // if dist traveled is negative, it indicates up swipe
                }
            }
            if (swipeData.swipedir.equals(direction.direction)) {
                listener.handleEvent(evt);
            }
            evt.preventDefault();
        }, false);
    }

    private static class SwipeData {
        String swipedir;
        double startX;
        double startY;
        double distX;
        double distY;
        double threshold = 100; //required min distance traveled to be considered swipe
        double restraint = 100; // maximum distance allowed at the same time in perpendicular direction
        double allowedTime = 400; // maximum time allowed to travel that distance
        double elapsedTime;
        double startTime;
    }

    /**
     * Predefined swap directions
     */
    public enum SwipeDirection {
        /**
         * Swipe from right to left
         */
        LEFT("left"),
        /**
         * Swipe from left to right
         */
        RIGHT("RIGHT"),
        /**
         * Swipe from down to up
         */
        UP("UP"),
        /**
         * Swipe from up to down
         */
        DOWN("DOWN");

        String direction;

        /**
         *
         * @param direction String
         */
        SwipeDirection(String direction) {
            this.direction = direction;
        }
    }
}