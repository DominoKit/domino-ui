package org.dominokit.domino.ui.utils;

public interface Selectable<T> {
    T select();
    T deselect();
    T select(boolean silent);
    T deselect(boolean silent);
    boolean isSelected();
}
