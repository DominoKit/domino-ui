package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLElement;

public class ABBRElement extends BaseElement<HTMLElement, ABBRElement> {
    public static ABBRElement of(HTMLElement e){
        return new ABBRElement(e);
    }

    public ABBRElement(HTMLElement element) {
        super(element);
    }
}
