package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLQuoteElement;

public class BlockquoteElement  extends BaseElement<HTMLQuoteElement, BlockquoteElement> {
    public static BlockquoteElement of(HTMLQuoteElement e) {
        return new BlockquoteElement(e);
    }

    public BlockquoteElement(HTMLQuoteElement element) {
        super(element);
    }
}
