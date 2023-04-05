package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLFieldSetElement;

public class FieldSetElement extends BaseElement<HTMLFieldSetElement, FieldSetElement> {
    public static FieldSetElement of(HTMLFieldSetElement e) {
        return new FieldSetElement(e);
    }

    public FieldSetElement(HTMLFieldSetElement element) {
        super(element);
    }
}