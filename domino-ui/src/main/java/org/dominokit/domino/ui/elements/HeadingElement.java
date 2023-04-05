package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLHeadingElement;

public class HeadingElement extends BaseElement<HTMLHeadingElement, HeadingElement> {
    public static HeadingElement of(HTMLHeadingElement e) {
        return new HeadingElement(e);
    }

    public HeadingElement(HTMLHeadingElement element) {
        super(element);
    }
}
