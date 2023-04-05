package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLModElement;

public class DelElement extends BaseElement<HTMLModElement, DelElement> {

    public static DelElement of(HTMLModElement e) {
        return new DelElement(e);
    }

    public DelElement(HTMLModElement element) {
        super(element);
    }
}