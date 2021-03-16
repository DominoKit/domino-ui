package org.dominokit.domino.ui.scroll;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.jboss.elemento.Elements.div;

/**
 * A component that wraps the {@link HTMLDivElement} to make it auto vertically scrollable when the content exceeds the component fixed height
 */
public class AutoVScrollPanel extends BaseDominoElement<HTMLDivElement, AutoVScrollPanel> {

    private HTMLDivElement element = div().css("auto-v-scroll-panel").element();

    /**
     *
     * @return new AutoVScrollPanel instance
     */
    public static AutoVScrollPanel create(){
        return new AutoVScrollPanel();
    }

    public AutoVScrollPanel() {
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
