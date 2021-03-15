package org.dominokit.domino.ui.layout;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.jboss.elemento.IsElement;

import static org.jboss.elemento.Elements.div;

/**
 * The component that masks the content panel when the left panel of the {@link Layout} is open
 */
public class Overlay extends BaseDominoElement<HTMLDivElement, Overlay> implements IsElement<HTMLDivElement> {

    private HTMLDivElement element;

    /**
     *
     */
    public Overlay() {
        element = div().css(LayoutStyles.OVERLAY)
                .element();
        init(this);
    }

    /**
     *
     * @return new Overlay instance
     */
    public static Overlay create(){
        return new Overlay();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLDivElement element() {
        return element;
    }
}
