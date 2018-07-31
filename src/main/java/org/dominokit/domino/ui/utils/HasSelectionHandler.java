package org.dominokit.domino.ui.utils;

public interface HasSelectionHandler<T> {
    T addSelectionHandler(SelectionHandler selectionHandler);

    interface SelectionHandler {
        void onSelection();
    }
}
