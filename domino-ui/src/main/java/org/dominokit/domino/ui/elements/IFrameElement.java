package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLIFrameElement;

public class IFrameElement extends BaseElement<HTMLIFrameElement, IFrameElement> {
    public static IFrameElement of(HTMLIFrameElement e) {
        return new IFrameElement(e);
    }

    public IFrameElement(HTMLIFrameElement element) {
        super(element);
    }
}