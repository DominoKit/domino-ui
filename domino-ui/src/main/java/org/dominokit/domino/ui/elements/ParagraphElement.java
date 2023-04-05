package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLParagraphElement;

public class ParagraphElement extends BaseElement<HTMLParagraphElement, ParagraphElement> {
    public static ParagraphElement of(HTMLParagraphElement e) {
        return new ParagraphElement(e);
    }

    public ParagraphElement(HTMLParagraphElement element) {
        super(element);
    }
}
