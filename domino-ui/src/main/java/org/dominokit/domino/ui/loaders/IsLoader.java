package org.dominokit.domino.ui.loaders;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.utils.DominoElement;

/**
 * An interface represents loader effect implementation
 */
public interface IsLoader {

    /**
     * @param text the loading text to set
     */
    default void setLoadingText(String text) {
    }

    /**
     * @return The root loader element
     */
    HTMLDivElement getElement();

    /**
     * Sets the size of the loader
     *
     * @param width  the width css property
     * @param height the height css property
     */
    void setSize(String width, String height);

    /**
     * Removes the loading text
     */
    void removeLoadingText();

    /**
     * @return The content element
     */
    DominoElement<HTMLDivElement> getContentElement();
}
