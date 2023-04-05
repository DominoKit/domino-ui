package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLElement;

public class TimeElement extends BaseElement<HTMLElement, TimeElement> {
    public static TimeElement of(HTMLElement e) {
        return new TimeElement(e);
    }

    public TimeElement(HTMLElement element) {
        super(element);
    }
}