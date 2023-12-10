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
package org.dominokit.domino.ui.notifications;

import static org.dominokit.domino.ui.notifications.NotificationStyles.*;
import static org.dominokit.domino.ui.utils.Domino.*;
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import elemental2.dom.DOMRect;
import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import java.util.List;
import org.dominokit.domino.ui.style.CompositeCssClass;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.utils.DominoElement;

/**
 * Utility class for managing and updating the positions of notifications on the screen.
 *
 * <p>This class provides functionality to automatically adjust the position offsets of
 * notifications based on their designated positions (e.g., top left, bottom right) to ensure that
 * they do not overlap.
 *
 * <p>Usage Example:
 *
 * <pre>
 * CssClass newPosition = NotificationStyles.dui_ntf_top_left;
 * NotificationPosition.updatePositions(newPosition);
 * </pre>
 */
public class NotificationPosition {
  private static CompositeCssClass topPositions =
      CompositeCssClass.of(dui_ntf_top_left, dui_ntf_top_right, dui_ntf_top_middle);
  private static CompositeCssClass bottomPositions =
      CompositeCssClass.of(dui_ntf_bottom_left, dui_ntf_bottom_right, dui_ntf_bottom_middle);

  /**
   * Adjusts the position offsets of all notifications that share the same position.
   *
   * <p>The method iterates over all notifications having the same position and adjusts their
   * position offsets to prevent overlaps. Position offsets are adjusted differently based on
   * whether the notifications are positioned at the top or bottom of the screen.
   *
   * @param notificationPosition The CSS class representing the position of the notifications to
   *     adjust.
   */
  public static void updatePositions(CssClass notificationPosition) {
    List<Element> samePositionNotifications =
        DomGlobal.document.querySelectorAll("." + notificationPosition.getCssClass()).asList();

    double nextOffset = 0;
    if (topPositions.contains(notificationPosition)) {
      for (int i = samePositionNotifications.size() - 1; i > -1; i--) {
        DominoElement<Element> e =
            elements.elementOf(samePositionNotifications.get(i).firstElementChild);
        e.setCssProperty("--dui-ntf-position-offset", nextOffset + "px");
        DOMRect domRect = e.getBoundingClientRect();
        nextOffset += domRect.bottom - domRect.top + 16;
      }
    } else if (bottomPositions.contains(notificationPosition)) {
      for (int i = samePositionNotifications.size() - 1; i > -1; i--) {
        DominoElement<Element> wrapper = elements.elementOf(samePositionNotifications.get(i));
        DominoElement<Element> e =
            elements.elementOf(samePositionNotifications.get(i).firstElementChild);
        e.setCssProperty("--dui-ntf-position-offset", nextOffset + "px");
        DOMRect domRect = e.getBoundingClientRect();
        nextOffset += domRect.bottom - domRect.top + 16;
      }
    }
  }
}
