package com.progressoft.brix.domino.ui.notifications;

import elemental2.dom.HTMLElement;

public class BottomRightPosition extends NotificationPosition {

    public BottomRightPosition() {
        super("bottom-right", "bottom");
    }

    @Override
    public void onBeforePosition(HTMLElement element) {
        element.style.setProperty("bottom", "20px");
        element.style.setProperty("right", "20px");
    }

    @Override
    protected int getOffsetPosition(HTMLElement element) {
        return 20;
    }
}
