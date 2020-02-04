package org.dominokit.domino.ui.utils;

import elemental2.dom.HTMLElement;
import org.jboss.elemento.IsElement;

public interface IsHtmlComponent<E extends HTMLElement, C extends IsElement<E>>{

    HtmlComponentBuilder<E,C> htmlBuilder();
}
