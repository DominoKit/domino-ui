package org.dominokit.domino.ui.utils;

import elemental2.dom.HTMLLIElement;
import org.dominokit.domino.ui.elements.LIElement;

public class Separator extends BaseDominoElement<HTMLLIElement, Separator> {

    private LIElement element;

    public static Separator create(){
        return new Separator();
    }

    public Separator() {
        element = li().addCss(dui_separator);
        init(this);
    }

    @Override
    public HTMLLIElement element() {
        return element.element();
    }
}
