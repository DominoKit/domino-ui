package com.progressoft.brix.domino.ui.notifications;

import elemental2.dom.HTMLElement;

public class BottomCenterPosition extends NotificationPosition {

    public BottomCenterPosition() {
        super("bottom-center", "bottom");
    }

    @Override
    public void onBeforePosition(HTMLElement element) {
        element.style.setProperty("bottom", "20px");
        element.style.setProperty("right", "0px");
        element.style.setProperty("left", "0px");
    }

    @Override
    protected int getOffsetPosition(HTMLElement element) {
        return 20;
    }
}
