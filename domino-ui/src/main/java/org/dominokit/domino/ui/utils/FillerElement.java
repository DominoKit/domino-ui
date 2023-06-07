package org.dominokit.domino.ui.utils;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.elements.SpanElement;

public class FillerElement extends BaseDominoElement<HTMLElement, FillerElement> {

    private SpanElement element;

    public static FillerElement create(){
        return new FillerElement();
    }

    public FillerElement() {
        element = span().addCss(dui_grow_1);
        init(this);
    }

    @Override
    public HTMLElement element() {
        return element.element();
    }
}
