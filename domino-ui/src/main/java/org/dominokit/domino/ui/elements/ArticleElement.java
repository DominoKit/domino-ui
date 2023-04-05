package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLElement;

public class ArticleElement extends BaseElement<HTMLElement, ArticleElement> {
    public static ArticleElement of(HTMLElement e) {
        return new ArticleElement(e);
    }

    public ArticleElement(HTMLElement element) {
        super(element);
    }
}
