package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLSourceElement;

public class SourceElement extends BaseElement<HTMLSourceElement, SourceElement> {
    public static SourceElement of(HTMLSourceElement e) {
        return new SourceElement(e);
    }

    public SourceElement(HTMLSourceElement element) {
        super(element);
    }
}