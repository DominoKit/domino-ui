package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLTableColElement;

public class ColElement extends BaseElement<HTMLTableColElement, ColElement> {
    public static ColElement of(HTMLTableColElement e) {
        return new ColElement(e);
    }

    public ColElement(HTMLTableColElement element) {
        super(element);
    }
}