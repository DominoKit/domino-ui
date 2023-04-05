package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLElement;

public class HGroupElement extends BaseElement<HTMLElement, HGroupElement> {
    public static HGroupElement of(HTMLElement e) {
        return new HGroupElement(e);
    }

    public HGroupElement(HTMLElement element) {
        super(element);
    }
}
