package org.dominokit.domino.ui.utils;

import elemental2.dom.HTMLElement;
import org.jboss.elemento.IsElement;

/**
 * A component that can be wrapped in an {@link HtmlComponentBuilder} should implement this interface
 * @param <E> the the type of the component root element
 * @param <C> the type of the component implementing this interface
 */
public interface IsHtmlComponent<E extends HTMLElement, C extends IsElement<E>>{
    /**
     *
     * @return the {@link HtmlComponentBuilder} wrapping the component
     */
    HtmlComponentBuilder<E,C> htmlBuilder();
}
