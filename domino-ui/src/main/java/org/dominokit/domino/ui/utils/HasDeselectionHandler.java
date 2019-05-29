package org.dominokit.domino.ui.utils;

public interface HasDeselectionHandler<T> {
    T addDeselectionHandler(DeselectionHandler deselectionHandler);

    interface DeselectionHandler {
        void onDeselection();
    }
}
