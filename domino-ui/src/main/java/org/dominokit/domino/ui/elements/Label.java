package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLabelElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.Elements;

public class Label extends BaseElement<HTMLLabelElement, Label> {
    @Override
    protected HTMLLabelElement createElement() {
        return Elements.label().element();
    }
}
