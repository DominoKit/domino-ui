package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLPreElement;

public class PreElement extends BaseElement<HTMLPreElement, PreElement> {
    public static PreElement of(HTMLPreElement e) {
        return new PreElement(e);
    }

    public PreElement(HTMLPreElement element) {
        super(element);
    }
}
