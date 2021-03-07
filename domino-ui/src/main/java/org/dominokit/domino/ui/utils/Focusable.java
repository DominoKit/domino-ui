package org.dominokit.domino.ui.utils;

import org.dominokit.domino.ui.style.Color;

/**
 * Components that can be focused should implement this interface
 * @param <T> the type of the class implementing this interface
 */
public interface Focusable<T> {
    /**
     * focus the component
     * @return same implementing class
     */
    T focus();

    /**
     * remove the focus from the component
     * @return same implementing class
     */
    T unfocus();

    /**
     *
     * @return boolean, true if the component is focused
     */
    boolean isFocused();

    /**
     * Set a color to use for focus indicators
     * @param focusColor {@link Color}
     * @return same implementing class
     */
    T setFocusColor(Color focusColor);
}
