package com.progressoft.brix.domino.ui.notifications;

import elemental2.dom.HTMLElement;

public class TopRightPosition extends NotificationPosition {

    TopRightPosition() {
        super("top-right", "top");
    }

    @Override
    public void onBeforePosition(HTMLElement element) {
        element.style.setProperty("top", "20px");
        element.style.setProperty("right", "20px");
    }

    @Override
    protected int getOffsetPosition(HTMLElement element) {
        return element.offsetTop;
    }
}
