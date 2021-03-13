package org.dominokit.domino.ui.loaders;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.jboss.elemento.IsElement;

import static org.jboss.elemento.Elements.div;

/**
 * Base loader implementation
 *
 * @param <T> the type of the loader
 * @see BaseDominoElement
 * @see IsLoader
 */
public abstract class BaseLoader<T extends BaseLoader<T>> extends BaseDominoElement<HTMLDivElement, T> implements IsLoader, IsElement<HTMLDivElement> {

    protected HTMLDivElement loadingText = div()
            .css(LoaderStyles.WAIT_ME_TEXT)
            .style("color:#555")
            .textContent("Loading...")
            .element();

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLDivElement getElement() {
        return element();
    }
}
