package org.dominokit.domino.ui.layout;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.jboss.gwt.elemento.core.IsElement;

import static org.jboss.gwt.elemento.core.Elements.div;

public class Overlay extends BaseDominoElement<HTMLDivElement, Overlay> implements IsElement<HTMLDivElement> {

    private HTMLDivElement element;

    public Overlay() {
        element = div().css(LayoutStyles.OVERLAY)
                .element();
        init(this);
    }

    public static Overlay create(){
        return new Overlay();
    }

    @Override
    public HTMLDivElement element() {
        return element;
    }
}
