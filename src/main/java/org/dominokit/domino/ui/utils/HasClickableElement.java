package org.dominokit.domino.ui.utils;

import elemental2.dom.HTMLElement;
import org.jboss.gwt.elemento.core.IsElement;

@FunctionalInterface
public interface HasClickableElement {
    HTMLElement getClickableElement();
}
