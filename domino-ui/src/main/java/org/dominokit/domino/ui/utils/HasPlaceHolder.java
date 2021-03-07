package org.dominokit.domino.ui.utils;

/**
 * Components that can have a placeholder should implement this interface
 * @param <T> the type of the class implementing this interface
 */
public interface HasPlaceHolder<T> {
    /**
     *
     * @return String placeholder of the component
     */
    String getPlaceholder();

    /**
     *
     * @param placeholder String placeholder
     * @return same implementing class instance
     */
    T setPlaceholder(String placeholder);
}
