package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.DominoElement;

public class Nav extends BaseElement<HTMLElement, Nav> {
    @Override
    protected HTMLElement createElement() {
        return nav().element();
    }
}
