package org.dominokit.domino.ui.utils;

/**
 * A component that can have text content should implement this interface
 * @param <T> the type of the component implementing this interface
 */
@FunctionalInterface
public interface HasContent<T> {
    /**
     *
     * @param content String text content
     * @return same implementing component
     */
    T setContent(String content);
}
