package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLDivElement;
import org.jboss.elemento.Elements;

public class Div extends BaseElement<HTMLDivElement, Div> {
    @Override
    protected HTMLDivElement createElement() {
        return Elements.div().element();
    }
}
