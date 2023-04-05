package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLObjectElement;

public class ObjectElement extends BaseElement<HTMLObjectElement, ObjectElement> {
    public static ObjectElement of(HTMLObjectElement e) {
        return new ObjectElement(e);
    }

    public ObjectElement(HTMLObjectElement element) {
        super(element);
    }
}