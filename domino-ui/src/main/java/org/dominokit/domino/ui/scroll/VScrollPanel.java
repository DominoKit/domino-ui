package org.dominokit.domino.ui.scroll;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.jboss.elemento.Elements.div;

/**
 * A component that wraps the {@link HTMLDivElement} to make it vertically scrollable by default
 */
public class VScrollPanel extends BaseDominoElement<HTMLDivElement, VScrollPanel> {

    private HTMLDivElement element = div().css("v-scroll-panel").element();

    /**
     *
     * @return new AutoHScrollPanel instance
     */
    public static VScrollPanel create(){
        return new VScrollPanel();
    }

    public VScrollPanel() {
        init(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLDivElement element() {
        return element;
    }
}
