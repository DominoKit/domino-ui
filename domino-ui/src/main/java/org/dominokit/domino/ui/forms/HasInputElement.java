package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.DominoElement;

/**
 * Component that has input elements should implement this interface
 */
public interface HasInputElement {
    /**
     *
     * @param <E> the type if the input element
     * @return E the input element wrapped as {@link DominoElement}
     */
    <E extends HTMLElement> DominoElement<E> getInputElement();

    /**
     *
     * @return String value of the input element
     */
    String getStringValue();
}
