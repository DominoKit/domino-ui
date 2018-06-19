package org.dominokit.domino.ui.loaders;

import elemental2.dom.HTMLDivElement;
import org.jboss.gwt.elemento.core.IsElement;

public interface IsLoader extends IsElement<HTMLDivElement> {
    default void setLoadingText(String text){};
}
