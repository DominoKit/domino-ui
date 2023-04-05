package org.dominokit.domino.ui.utils;

/**
 * A function to apply generic logic to a component
 *
 * @param <T> the type of the component
 */
@FunctionalInterface
public interface ElementHandler<T> {
    /**
     * @param self the T component instance
     */
    void handleElement(T self);
}
