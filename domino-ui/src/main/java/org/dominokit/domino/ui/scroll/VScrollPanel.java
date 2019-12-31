package org.dominokit.domino.ui.scroll;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.jboss.gwt.elemento.core.Elements.div;

public class VScrollPanel extends BaseDominoElement<HTMLDivElement, VScrollPanel> {

    private HTMLDivElement element = div().css("v-scroll-panel").element();

    public static VScrollPanel create(){
        return new VScrollPanel();
    }

    public VScrollPanel() {
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return element;
    }
}
