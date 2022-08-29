package org.dominokit.domino.ui.utils;

/**
 * a Generic function to apply some logic on a field without triggering validation
 *
 * @param <T> the field
 */
@FunctionalInterface
public interface Handler<T> {
    /**
     * @param field T the field we apply the logic on
     */
    void apply(T field);
}
