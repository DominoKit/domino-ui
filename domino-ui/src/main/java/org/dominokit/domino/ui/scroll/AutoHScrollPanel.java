package org.dominokit.domino.ui.scroll;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.jboss.elemento.Elements.div;

public class AutoHScrollPanel extends BaseDominoElement<HTMLDivElement, AutoHScrollPanel> {

    private HTMLDivElement element = div().css("auto-h-scroll-panel").element();

    public static AutoHScrollPanel create(){
        return new AutoHScrollPanel();
    }

    public AutoHScrollPanel() {
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return element;
    }
}
