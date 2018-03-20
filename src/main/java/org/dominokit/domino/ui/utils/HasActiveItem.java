package org.dominokit.domino.ui.utils;

public interface HasActiveItem<T> {
    T getActiveItem();
    void setActiveItem(T activeItem);
}
