package org.dominokit.domino.ui.scroll;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.jboss.elemento.Elements.div;

/**
 * A component that wraps the {@link HTMLDivElement} to make it auto horizontally scrollable when the content exceeds the component fixed width
 */
public class AutoHScrollPanel extends BaseDominoElement<HTMLDivElement, AutoHScrollPanel> {

    private HTMLDivElement element = div().css("auto-h-scroll-panel").element();

    /**
     *
     * @return new AutoHScrollPanel instance
     */
    public static AutoHScrollPanel create(){
        return new AutoHScrollPanel();
    }

    public AutoHScrollPanel() {
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
