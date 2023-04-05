package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLQuoteElement;

public class QuoteElement extends BaseElement<HTMLQuoteElement, QuoteElement> {
    public static QuoteElement of(HTMLQuoteElement e) {
        return new QuoteElement(e);
    }

    public QuoteElement(HTMLQuoteElement element) {
        super(element);
    }
}