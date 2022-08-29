package org.dominokit.domino.ui.utils;

import elemental2.dom.HTMLElement;
import org.jboss.elemento.IsElement;

public interface HasAddOns<T> {
    <E extends HTMLElement, C extends IsElement<E>> T addLeftAddOn(C addon);
    <E extends HTMLElement, C extends IsElement<E>> T addRightAddOn(C addon);
    <E extends HTMLElement, C extends IsElement<E>> T addPrimaryAddOn(C addon);

}
