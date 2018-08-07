package org.dominokit.domino.ui.utils;

import org.dominokit.domino.ui.collapsible.Collapsible;
import org.dominokit.domino.ui.style.Style;
import org.jboss.gwt.elemento.core.IsElement;

public abstract class DominoElement<E extends IsElement> implements IsCollapsible<E> {

    private E element;
    private Collapsible collapsible;

    public void initCollapsible(E element) {
        this.element = element;
        this.collapsible = Collapsible.create(element.asElement());
    }

    @Override
    public E collapse() {
        collapsible.collapse();
        return element;
    }

    @Override
    public E expand() {
        collapsible.expand();
        return element;
    }

    @Override
    public E toggle() {
        collapsible.toggle();
        return element;
    }

    @Override
    public E collapse(int duration) {
        collapsible.collapse(duration);
        return element;
    }

    @Override
    public E expand(int duration) {
        collapsible.expand(duration);
        return element;
    }

    @Override
    public boolean isCollapsed() {
        return collapsible.isCollapsed();
    }
}
