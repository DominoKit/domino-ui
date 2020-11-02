package org.dominokit.domino.ui.scroll;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.jboss.elemento.Elements.div;

public class AutoScrollPanel extends BaseDominoElement<HTMLDivElement, AutoScrollPanel> {

    private HTMLDivElement element = div().css("auto-scroll-panel").element();

    public static AutoScrollPanel create(){
        return new AutoScrollPanel();
    }

    public AutoScrollPanel() {
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return element;
    }
}
