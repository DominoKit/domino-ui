package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLBRElement;

public class BRElement extends BaseElement<HTMLBRElement, BRElement> {
    public static BRElement of(HTMLBRElement e) {
        return new BRElement(e);
    }

    public BRElement(HTMLBRElement element) {
        super(element);
    }
}