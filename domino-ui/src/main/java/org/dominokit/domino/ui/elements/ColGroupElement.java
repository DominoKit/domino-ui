package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLTableColElement;

public class ColGroupElement extends BaseElement<HTMLTableColElement, ColGroupElement> {
    public static ColGroupElement of(HTMLTableColElement e) {
        return new ColGroupElement(e);
    }

    public ColGroupElement(HTMLTableColElement element) {
        super(element);
    }
}