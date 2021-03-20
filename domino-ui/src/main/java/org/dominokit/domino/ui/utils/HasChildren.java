package org.dominokit.domino.ui.utils;

import elemental2.dom.Node;
import org.jboss.elemento.IsElement;

/**
 * A component that can have child elements should implement this interface
 * @param <T> the type of the component implementing this interface
 */
public interface HasChildren<T> {
    /**
     *
     * @param node {@link Node} to append to the component
     * @return same component instance
     */
    T appendChild(Node node);

    /**
     *
     * @param isElement {@link IsElement} to append to the component
     * @return same component instance
     */
    T appendChild(IsElement<?> isElement);
}
