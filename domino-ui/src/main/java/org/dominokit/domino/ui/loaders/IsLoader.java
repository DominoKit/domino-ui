package org.dominokit.domino.ui.loaders;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.utils.DominoElement;

public interface IsLoader {

    default void setLoadingText(String text) {
    }

    HTMLDivElement getElement();

    void setSize(String width, String height);

    void removeLoadingText();

    DominoElement<HTMLDivElement> getContentElement();
}
