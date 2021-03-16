package org.dominokit.domino.ui.notifications;

import elemental2.dom.HTMLElement;

/**
 * Display notification in bottom center
 */
public class BottomCenterPosition extends NotificationPosition {

    public BottomCenterPosition() {
        super("bottom-center", "bottom");
    }

    @Override
    public void onBeforePosition(HTMLElement element) {
        element.style.setProperty("bottom", "20px");
        element.style.setProperty("right", "0px");
        element.style.setProperty("left", "50%");
        element.style.setProperty("transform", "translate(-50%)");
    }

    @Override
    protected int getOffsetPosition(HTMLElement element) {
        return 20;
    }
}
