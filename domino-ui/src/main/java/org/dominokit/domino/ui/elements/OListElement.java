package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLOListElement;

public class OListElement extends BaseElement<HTMLOListElement, OListElement> {
    public static OListElement of(HTMLOListElement e) {
        return new OListElement(e);
    }

    public OListElement(HTMLOListElement element) {
        super(element);
    }
}
