package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLTextAreaElement;

public class TextAreaElement extends BaseElement<HTMLTextAreaElement, TextAreaElement> {
    public static TextAreaElement of(HTMLTextAreaElement e) {
        return new TextAreaElement(e);
    }

    public TextAreaElement(HTMLTextAreaElement element) {
        super(element);
    }
}