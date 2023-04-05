package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLOutputElement;

public class OutputElement extends BaseElement<HTMLOutputElement, OutputElement> {
    public static OutputElement of(HTMLOutputElement e) {
        return new OutputElement(e);
    }

    public OutputElement(HTMLOutputElement element) {
        super(element);
    }
}