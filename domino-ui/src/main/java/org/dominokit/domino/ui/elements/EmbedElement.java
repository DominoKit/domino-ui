package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLEmbedElement;

public class EmbedElement extends BaseElement<HTMLEmbedElement, EmbedElement> {
    public static EmbedElement of(HTMLEmbedElement e) {
        return new EmbedElement(e);
    }

    public EmbedElement(HTMLEmbedElement element) {
        super(element);
    }
}