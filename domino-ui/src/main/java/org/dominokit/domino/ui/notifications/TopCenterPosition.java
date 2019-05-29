package org.dominokit.domino.ui.notifications;

import elemental2.dom.HTMLElement;

public class TopCenterPosition extends NotificationPosition {


    protected TopCenterPosition() {
        super("top-center", "top");
    }

    @Override
    protected void onBeforePosition(HTMLElement element) {
        element.style.setProperty("top", "20px");
        element.style.setProperty("right", "0px");
        element.style.setProperty("left", "50%");
        element.style.setProperty("transform", "translate(-50%)");
    }

    @Override
    protected int getOffsetPosition(HTMLElement element) {
        return element.offsetTop;
    }
}
