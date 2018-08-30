package org.dominokit.domino.ui.utils;

import elemental2.dom.HTMLElement;
import org.jboss.gwt.elemento.core.IsElement;

@FunctionalInterface
public interface HasClickableElement {
    <E extends HTMLElement, T extends IsElement<E>> DominoElement<E,T> getClickableElement();
}
