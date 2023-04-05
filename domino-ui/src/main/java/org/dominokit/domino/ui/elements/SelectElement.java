package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLSelectElement;

public class SelectElement extends BaseElement<HTMLSelectElement, SelectElement> {
    public static SelectElement of(HTMLSelectElement e) {
        return new SelectElement(e);
    }

    public SelectElement(HTMLSelectElement element) {
        super(element);
    }
}