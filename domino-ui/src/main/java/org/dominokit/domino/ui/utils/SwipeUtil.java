/*
 * Copyright © 2019 Dominokit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.dominokit.domino.ui.utils;

import static org.dominokit.domino.ui.utils.Domino.*;
import static org.dominokit.domino.ui.utils.SwipeUtil.SwipeDirection.*;

import elemental2.dom.*;
import java.util.Date;
import jsinterop.base.Js;

/**
 * The {@code SwipeUtil} class provides utility methods for adding swipe event listeners to HTML
 * elements. It allows you to detect swipe gestures in different directions (left, right, up, and
 * down) on touch-enabled devices.
 *
 * <p>Swipe gestures are a common interaction pattern on mobile devices, and this utility simplifies
 * the process of adding swipe event listeners to handle such gestures.
 *
 * @see HTMLElement
 * @see EventListener
 * @see SwipeDirection
 */
public class SwipeUtil {

  /**
   * Adds a swipe event listener to the specified HTML element.
   *
   * @param direction The desired swipe direction (e.g., {@link SwipeDirection#LEFT}).
   * @param element The HTML element to attach the swipe listener to.
   * @param listener The event listener to invoke when the swipe gesture occurs.
   */
  public static void addSwipeListener(
      SwipeDirection direction, HTMLElement element, EventListener listener) {
    HTMLElement touchsurface = element;

    SwipeData swipeData = new SwipeData();

    touchsurface.addEventListener(
        "touchstart",
        evt -> {
          TouchEvent touchEvent = Js.uncheckedCast(evt);
          Touch touchobj = touchEvent.changedTouches.item(0);
          swipeData.swipedir = "none";
          swipeData.startX = touchobj.pageX;
          swipeData.startY = touchobj.pageY;
          swipeData.startTime =
              new Date().getTime(); // record time when finger first makes contact with surface
          evt.preventDefault();
        },
        false);

    // prevent scrolling when inside DIV
    touchsurface.addEventListener("touchmove", Event::preventDefault, false);

    touchsurface.addEventListener(
        "touchend",
        evt -> {
          TouchEvent touchEvent = Js.uncheckedCast(evt);
          Touch touchobj = touchEvent.changedTouches.item(0);
          swipeData.distX =
              touchobj.pageX
                  - swipeData
                      .startX; // get horizontal dist traveled by finger while in contact with
          // surface
          swipeData.distY =
              touchobj.pageY
                  - swipeData
                      .startY; // get vertical dist traveled by finger while in contact with surface
          swipeData.elapsedTime = new Date().getTime() - swipeData.startTime; // get time elapsed
          if (swipeData.elapsedTime <= swipeData.allowedTime) { // first condition for awipe met
            if (Math.abs(swipeData.distX) >= swipeData.threshold
                && Math.abs(swipeData.distY)
                    <= swipeData.restraint) { // 2nd condition for horizontal swipe met
              swipeData.swipedir =
                  (swipeData.distX < 0)
                      ? LEFT.direction
                      : RIGHT.direction; // if dist traveled is negative, it indicates left swipe
            } else if (Math.abs(swipeData.distY) >= swipeData.threshold
                && Math.abs(swipeData.distX)
                    <= swipeData.restraint) { // 2nd condition for vertical swipe met
              swipeData.swipedir =
                  (swipeData.distY < 0)
                      ? UP.direction
                      : DOWN.direction; // if dist traveled is negative, it indicates up swipe
            }
          }
          if (swipeData.swipedir.equals(direction.direction)) {
            listener.handleEvent(evt);
          }
          evt.preventDefault();
        },
        false);
  }

  private static class SwipeData {
    String swipedir;
    double startX;
    double startY;
    double distX;
    double distY;
    double threshold = 100; // required min distance traveled to be considered swipe
    double restraint = 100; // maximum distance allowed at the same time in perpendicular direction
    double allowedTime = 400; // maximum time allowed to travel that distance
    double elapsedTime;
    double startTime;
  }

  /** An enumeration of swipe directions. */
  public enum SwipeDirection {
    /** Represents a left swipe gesture. */
    LEFT("left"),
    /** Represents a right swipe gesture. */
    RIGHT("right"),
    /** Represents an up swipe gesture. */
    UP("up"),
    /** Represents a down swipe gesture. */
    DOWN("down");

    String direction;

    /**
     * Creates a new {@code SwipeDirection} enum constant with the specified direction string.
     *
     * @param direction The direction string (e.g., "left").
     */
    SwipeDirection(String direction) {
      this.direction = direction;
    }
  }
}
