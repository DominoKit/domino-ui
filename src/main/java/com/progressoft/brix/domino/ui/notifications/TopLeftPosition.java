package com.progressoft.brix.domino.ui.notifications;

import elemental2.dom.HTMLElement;

public class TopLeftPosition extends NotificationPosition{


    protected TopLeftPosition() {
        super("top-left", "top");
    }

    @Override
    public void onBeforePosition(HTMLElement element) {
        element.style.setProperty("top", "20px");
        element.style.setProperty("left", "20px");
    }

    @Override
    protected int getOffsetPosition(HTMLElement element) {
        return element.offsetTop;
    }
}
