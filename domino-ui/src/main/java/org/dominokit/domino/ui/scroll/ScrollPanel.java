package org.dominokit.domino.ui.scroll;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.jboss.elemento.Elements.div;

/**
 * A component that wraps the {@link HTMLDivElement} to make it scrollable by default
 */
public class ScrollPanel extends BaseDominoElement<HTMLDivElement, ScrollPanel> {

    private HTMLDivElement element = div().css("scroll-panel").element();

    /**
     *
     * @return new AutoHScrollPanel instance
     */
    public static ScrollPanel create(){
        return new ScrollPanel();
    }

    public ScrollPanel() {
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
