package org.dominokit.domino.ui.utils;

/**
 * A component that can have a selected item should implement this interface
 * @param <T> the type of the item
 */
public interface HasSelectSupport<T> {
    /**
     *
     * @return the T item that is currently selected
     */
    T getSelectedItem();
}
