package org.dominokit.domino.ui.splitpanel;

/**
 * An interface provides information about size in split panels
 */
public interface HasSize {
    /**
     * @return the current size
     */
    double getSize();

    /**
     * @return the splitter size
     */
    int getSplitterSize();
}
