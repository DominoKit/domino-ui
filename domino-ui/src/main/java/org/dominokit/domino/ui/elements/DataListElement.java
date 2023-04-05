package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLDataListElement;

public class DataListElement extends BaseElement<HTMLDataListElement, DataListElement> {
    public static DataListElement of(HTMLDataListElement e) {
        return new DataListElement(e);
    }

    public DataListElement(HTMLDataListElement element) {
        super(element);
    }
}