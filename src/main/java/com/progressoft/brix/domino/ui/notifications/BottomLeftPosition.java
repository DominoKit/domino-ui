package com.progressoft.brix.domino.ui.notifications;

import elemental2.dom.Element;
import elemental2.dom.HTMLElement;
import jsinterop.base.Js;

import java.util.List;

import static elemental2.dom.DomGlobal.document;

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
