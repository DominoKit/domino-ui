package org.dominokit.domino.ui.loaders;

import elemental2.dom.HTMLDivElement;

public interface IsLoader {

    default void setLoadingText(String text){};
    HTMLDivElement getElement();
}
