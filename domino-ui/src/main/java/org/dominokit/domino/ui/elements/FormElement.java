package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLFormElement;

public class FormElement extends BaseElement<HTMLFormElement, FormElement> {
    public static FormElement of(HTMLFormElement e) {
        return new FormElement(e);
    }

    public FormElement(HTMLFormElement element) {
        super(element);
    }
}