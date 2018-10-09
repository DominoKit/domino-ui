package org.dominokit.domino.ui.utils;

public interface HasSelectionHandler<T, V> {
    T addSelectionHandler(SelectionHandler<V> selectionHandler);
    T removeSelectionHandler(SelectionHandler<V> selectionHandler);

    interface SelectionHandler<V> {
        void onSelection(V value);
    }
}
