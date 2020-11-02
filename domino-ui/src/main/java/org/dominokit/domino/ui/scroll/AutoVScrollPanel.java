package org.dominokit.domino.ui.scroll;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.jboss.elemento.Elements.div;

public class AutoVScrollPanel extends BaseDominoElement<HTMLDivElement, AutoVScrollPanel> {

    private HTMLDivElement element = div().css("auto-v-scroll-panel").element();

    public static AutoVScrollPanel create(){
        return new AutoVScrollPanel();
    }

    public AutoVScrollPanel() {
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return element;
    }
}
