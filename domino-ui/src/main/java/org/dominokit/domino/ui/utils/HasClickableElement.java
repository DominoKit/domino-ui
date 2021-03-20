package org.dominokit.domino.ui.utils;

import elemental2.dom.HTMLElement;
import org.jboss.elemento.IsElement;

/**
 * Component that can be clicked or has a child element that can be clicked should implement this interface
 */
@FunctionalInterface
public interface HasClickableElement {
    /**
     *
     * @return the {@link HTMLElement} that should receive and click listeners
     */
    HTMLElement getClickableElement();
}
