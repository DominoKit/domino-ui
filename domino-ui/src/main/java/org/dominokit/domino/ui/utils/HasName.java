package org.dominokit.domino.ui.utils;

/**
 * A component that can have a name should implement this interface
 * @param <T>
 */
public interface HasName<T> {
    /**
     *
     * @return String component name
     */
    String getName();

    /**
     *
     * @param name String component name
     * @return same implementing class
     */
    T setName(String name);
}
