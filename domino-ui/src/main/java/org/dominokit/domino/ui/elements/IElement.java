package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLElement;

public class IElement extends BaseElement<HTMLElement, IElement> {
    public static IElement of(HTMLElement e) {
        return new IElement(e);
    }

    public IElement(HTMLElement element) {
        super(element);
    }
}