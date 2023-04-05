package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLElement;

public class CodeElement extends BaseElement<HTMLElement, CodeElement> {
    public static CodeElement of(HTMLElement e) {
        return new CodeElement(e);
    }

    public CodeElement(HTMLElement element) {
        super(element);
    }
}