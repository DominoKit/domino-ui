package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLElement;

public class KBDElement extends BaseElement<HTMLElement, KBDElement> {
    public static KBDElement of(HTMLElement e) {
        return new KBDElement(e);
    }

    public KBDElement(HTMLElement element) {
        super(element);
    }
}