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

import static org.dominokit.domino.ui.notifications.NotificationStyles.dui_ntf_bottom_left;
import static org.dominokit.domino.ui.notifications.NotificationStyles.dui_ntf_bottom_middle;
import static org.dominokit.domino.ui.notifications.NotificationStyles.dui_ntf_bottom_right;
import static org.dominokit.domino.ui.notifications.NotificationStyles.dui_ntf_top_left;
import static org.dominokit.domino.ui.notifications.NotificationStyles.dui_ntf_top_middle;
import static org.dominokit.domino.ui.notifications.NotificationStyles.dui_ntf_top_right;
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import elemental2.dom.DOMRect;
import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import java.util.List;
import org.dominokit.domino.ui.style.CompositeCssClass;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.utils.DominoElement;

/** NotificationPosition class. */
public class NotificationPosition {
  private static CompositeCssClass topPositions =
      CompositeCssClass.of(dui_ntf_top_left, dui_ntf_top_right, dui_ntf_top_middle);
  private static CompositeCssClass bottomPositions =
      CompositeCssClass.of(dui_ntf_bottom_left, dui_ntf_bottom_right, dui_ntf_bottom_middle);

  /**
   * updatePositions.
   *
   * @param notificationPosition a {@link org.dominokit.domino.ui.style.CssClass} object
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
        DomGlobal.console.info("ORDER : " + wrapper.getAttribute("order"));
        e.setCssProperty("--dui-ntf-position-offset", nextOffset + "px");
        DOMRect domRect = e.getBoundingClientRect();
        nextOffset += domRect.bottom - domRect.top + 16;
      }
    }
  }
}
