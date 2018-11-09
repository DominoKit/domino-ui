package org.dominokit.domino.ui.loaders;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.jboss.gwt.elemento.core.IsElement;

public abstract class BaseLoader<T extends BaseLoader<T>> extends BaseDominoElement<HTMLDivElement, T> implements IsLoader, IsElement<HTMLDivElement> {

    @Override
    public HTMLDivElement getElement() {
        return asElement();
    }
}
