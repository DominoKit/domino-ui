package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLElement;

public class SpanElement extends BaseElement<HTMLElement, SpanElement> {
    public static SpanElement of(HTMLElement e) {
        return new SpanElement(e);
    }

    public SpanElement(HTMLElement element) {
        super(element);
    }
}