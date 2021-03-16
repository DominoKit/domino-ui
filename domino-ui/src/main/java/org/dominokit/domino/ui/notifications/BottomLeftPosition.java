package org.dominokit.domino.ui.notifications;

import elemental2.dom.HTMLElement;

/**
 * Display notification in bottom left
 */
public class BottomLeftPosition extends NotificationPosition {

    public BottomLeftPosition() {
        super("bottom-left", "bottom");
    }

    @Override
    public void onBeforePosition(HTMLElement element) {
        element.style.setProperty("bottom", "20px");
        element.style.setProperty("left", "20px");
    }

    @Override
    protected int getOffsetPosition(HTMLElement element) {
        return 20;
    }
}
