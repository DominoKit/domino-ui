package org.dominokit.domino.ui.utils;

/**
 * A Component that can have a value should implement this interface
 * @param <T> the type of the class implementing this interface
 * @param <V> the type of the component value
 */
public interface HasValue<T, V> {
    /**
     *
     * @param value V to set as a value of the component
     * @return same implementing component instance
     */
    T value(V value);
}
