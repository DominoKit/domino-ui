package org.dominokit.domino.ui.utils;

@FunctionalInterface
public interface HasRemoveHandler<T> {

    T addRemoveHandler(RemoveHandler removeHandler);

    interface RemoveHandler {
        void onRemove();
    }
}
