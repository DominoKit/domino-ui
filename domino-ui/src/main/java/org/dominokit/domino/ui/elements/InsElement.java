package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLModElement;

public class InsElement extends BaseElement<HTMLModElement, InsElement> {
    public static InsElement of(HTMLModElement e) {
        return new InsElement(e);
    }

    public InsElement(HTMLModElement element) {
        super(element);
    }
}