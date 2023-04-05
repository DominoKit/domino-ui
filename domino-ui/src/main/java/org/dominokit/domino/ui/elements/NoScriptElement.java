package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLElement;

public class NoScriptElement extends BaseElement<HTMLElement, NoScriptElement> {
    public static NoScriptElement of(HTMLElement e) {
        return new NoScriptElement(e);
    }

    public NoScriptElement(HTMLElement element) {
        super(element);
    }
}