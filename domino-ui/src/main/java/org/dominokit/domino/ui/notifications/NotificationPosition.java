package org.dominokit.domino.ui.notifications;

import elemental2.dom.DOMRect;
import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import org.dominokit.domino.ui.style.CompositeCssClass;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.utils.DominoElement;

import java.util.List;

import static org.dominokit.domino.ui.notifications.NotificationStyles.dui_ntf_bottom_left;
import static org.dominokit.domino.ui.notifications.NotificationStyles.dui_ntf_bottom_middle;
import static org.dominokit.domino.ui.notifications.NotificationStyles.dui_ntf_bottom_right;
import static org.dominokit.domino.ui.notifications.NotificationStyles.dui_ntf_top_left;
import static org.dominokit.domino.ui.notifications.NotificationStyles.dui_ntf_top_middle;
import static org.dominokit.domino.ui.notifications.NotificationStyles.dui_ntf_top_right;
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

public class NotificationPosition {
    private static CompositeCssClass topPositions = CompositeCssClass.of(dui_ntf_top_left, dui_ntf_top_right, dui_ntf_top_middle);
    private static CompositeCssClass bottomPositions = CompositeCssClass.of(dui_ntf_bottom_left, dui_ntf_bottom_right, dui_ntf_bottom_middle);

    public static void updatePositions(CssClass notificationPosition) {
        List<Element> samePositionNotifications = DomGlobal.document.querySelectorAll("." + notificationPosition.getCssClass())
                .asList();

        double nextOffset = 0;
        if (topPositions.contains(notificationPosition)) {
            for (int i = samePositionNotifications.size() - 1; i > -1; i--) {
                DominoElement<Element> e = elements.elementOf(samePositionNotifications.get(i).firstElementChild);
                e.setCssProperty("--dui-ntf-position-offset", nextOffset+"px");
                DOMRect domRect = e.getBoundingClientRect();
                nextOffset += domRect.bottom - domRect.top + 16;
            }
        } else if (bottomPositions.contains(notificationPosition)) {
            for (int i = samePositionNotifications.size() - 1; i > -1; i--) {
                DominoElement<Element> wrapper = elements.elementOf(samePositionNotifications.get(i));
                DominoElement<Element> e = elements.elementOf(samePositionNotifications.get(i).firstElementChild);
                DomGlobal.console.info("ORDER : " + wrapper.getAttribute("order"));
                e.setCssProperty("--dui-ntf-position-offset", nextOffset + "px");
                DOMRect domRect = e.getBoundingClientRect();
                nextOffset += domRect.bottom - domRect.top +16;
            }
        }
    }
}
