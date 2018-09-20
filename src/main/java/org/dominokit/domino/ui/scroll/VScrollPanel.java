package org.dominokit.domino.ui.scroll;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.jboss.gwt.elemento.core.Elements.div;

public class VScrollPanel extends BaseDominoElement<HTMLDivElement, VScrollPanel> {

    private HTMLDivElement element = div().css("v-scroll-panel").asElement();

    @Override
    public HTMLDivElement asElement() {
        return element;
    }
}
