package org.dominokit.domino.ui.utils;

/**
 * A component that has items to be selected/deselected should implement this interface
 * @param <T> the type of the component implementing this interface
 * @param <V> the type of the Value being selected
 */
public interface HasSelectionHandler<T, V> {
    /**
     * Adds a Selection handler to the component
     * @param selectionHandler {@link org.dominokit.domino.ui.utils.Selectable.SelectionHandler}
     * @return same implementing component instance
     */
    T addSelectionHandler(SelectionHandler<V> selectionHandler);
    T removeSelectionHandler(SelectionHandler<V> selectionHandler);

    /**
     * A function to implement logic to be executed when a component being selected
     * @param <V> the type of the selected value
     */
    interface SelectionHandler<V> {
        /**
         *
         * @param value the selected value
         */
        void onSelection(V value);
    }
}
