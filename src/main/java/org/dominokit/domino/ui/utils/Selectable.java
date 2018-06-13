package org.dominokit.domino.ui.utils;

public interface Selectable<T> {
    T select();
    T deselect();
    T select(boolean silent);
    T deselect(boolean silent);
    boolean isSelected();
    default void addSelectionHandler(SelectionHandler<T> selectionHandler){}

    @FunctionalInterface
    interface SelectionHandler<T>{
        void onSelectionChanged(Selectable<T> selectable);
    }
}
