package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLAnchorElement;

public class AnchorElement extends BaseElement<HTMLAnchorElement, AnchorElement> {
    public static AnchorElement of(HTMLAnchorElement e) {
        return new AnchorElement(e);
    }

    public AnchorElement(HTMLAnchorElement element) {
        super(element);
    }
}
