package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLUListElement;

public class UListElement extends BaseElement<HTMLUListElement, UListElement> {
    public static UListElement of(HTMLUListElement e) {
        return new UListElement(e);
    }

    public UListElement(HTMLUListElement element) {
        super(element);
    }
}
