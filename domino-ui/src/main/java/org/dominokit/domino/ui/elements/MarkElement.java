package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLElement;

public class MarkElement extends BaseElement<HTMLElement, MarkElement> {
    public static MarkElement of(HTMLElement e) {
        return new MarkElement(e);
    }

    public MarkElement(HTMLElement element) {
        super(element);
    }
}