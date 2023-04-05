package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLLabelElement;

public class LabelElement extends BaseElement<HTMLLabelElement, LabelElement> {
    public static LabelElement of(HTMLLabelElement e) {
        return new LabelElement(e);
    }

    public LabelElement(HTMLLabelElement element) {
        super(element);
    }
}