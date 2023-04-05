package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLTableCaptionElement;

public class TableCaptionElement extends BaseElement<HTMLTableCaptionElement, TableCaptionElement> {
    public static TableCaptionElement of(HTMLTableCaptionElement e) {
        return new TableCaptionElement(e);
    }

    public TableCaptionElement(HTMLTableCaptionElement element) {
        super(element);
    }
}