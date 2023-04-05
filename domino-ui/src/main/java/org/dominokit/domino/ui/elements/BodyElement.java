package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLBodyElement;

public class BodyElement extends BaseElement<HTMLBodyElement, BodyElement> {
    public static BodyElement of(HTMLBodyElement e) {
        return new BodyElement(e);
    }

    public BodyElement(HTMLBodyElement element) {
        super(element);
    }
}
