package org.dominokit.domino.ui.scroll;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.jboss.elemento.Elements.div;

/**
 * A component that wraps the {@link HTMLDivElement} to make it horizontally scrollable by default
 */
public class HScrollPanel extends BaseDominoElement<HTMLDivElement, HScrollPanel> {

    private HTMLDivElement element = div().css("h-scroll-panel").element();

    /**
     *
     * @return new HScrollPanel instance
     */
    public static HScrollPanel create(){
        return new HScrollPanel();
    }

    public HScrollPanel() {
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
