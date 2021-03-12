package org.dominokit.domino.ui.utils;


import org.dominokit.domino.ui.style.Color;

/**
 * Components that can have a background should implement this interface
 * @param <T> The type of the component that implements this interface
 */
@FunctionalInterface
public interface HasBackground<T> {
    /**
     *
     * @param background {@link Color}
     * @return same implementing component
     */
    T setBackground(Color background);
}
