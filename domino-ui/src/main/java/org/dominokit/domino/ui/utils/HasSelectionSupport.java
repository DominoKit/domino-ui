package org.dominokit.domino.ui.utils;

import java.util.List;

/**
 * Components that needs to support selection of items can implement this interface
 * @param <T> the type of items being selected
 */
public interface HasSelectionSupport<T> {

    /**
     *
     * @return a List of all currently selected items
     */
    List<T> getSelectedItems();

    /**
     *
     * @return a List of all selected and not selected items
     */
    List<T> getItems();

    /**
     * Called when an item selection is changed, implementation can delegate to a list listeners
     * @param source T item that has its selection changed
     */
    void onSelectionChange(T source);

    /**
     *
     * @return boolean, true if the component allows selection otherwise false.
     */
    boolean isSelectable();

    /**
     * Select all not selected items
     */
    default void selectAll() {
    }

    /**
     * Deselect all currently selected items
     */
    default void deselectAll() {
    }
}
