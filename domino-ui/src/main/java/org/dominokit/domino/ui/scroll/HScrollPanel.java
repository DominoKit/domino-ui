package org.dominokit.domino.ui.scroll;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.jboss.elemento.Elements.div;

public class HScrollPanel extends BaseDominoElement<HTMLDivElement, HScrollPanel> {

    private HTMLDivElement element = div().css("h-scroll-panel").element();

    public static HScrollPanel create(){
        return new HScrollPanel();
    }

    public HScrollPanel() {
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return element;
    }
}
