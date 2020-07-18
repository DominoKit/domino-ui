package org.dominokit.domino.ui.utils;

import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import org.jboss.elemento.IsElement;

public interface HasChildren<T> {
    T appendChild(Node node);
    T appendChild(IsElement<?> isElement);
}
