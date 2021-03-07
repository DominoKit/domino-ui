package org.dominokit.domino.ui.utils;

/**
 * Components that can have a label should implement this interface
 * @param <T> the type of the implementing class
 */
public interface HasLabel<T> {

    /**
     *
     * @param label String component label
     * @return same implementing class instance
     */
    T setLabel(String label);

    /**
     *
     * @return String component label
     */
    String getLabel();
}
