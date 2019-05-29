package org.dominokit.domino.ui.tabs;

public interface HasActiveItem<T> {
    T getActiveItem();
    void setActiveItem(T activeItem);
}
