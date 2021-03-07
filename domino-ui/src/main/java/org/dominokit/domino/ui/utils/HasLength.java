package org.dominokit.domino.ui.utils;

/**
 * Components that has a requirement to have a min and max length can implement this interface
 * @param <T> The type of the class implementing this interface
 */
public interface HasLength<T> {
    /**
     *
     * @param maxLength int max allowed length
     * @return same implementation instance
     */
    T setMaxLength(int maxLength);

    /**
     *
     * @return int max allowed length
     */
    int getMaxLength();

    /**
     *
     * @param minLength int min allowed length
     * @return same implementation instance
     */
    T setMinLength(int minLength);

    /**
     *
     * @return int min allowed length
     */
    int getMinLength();
}
