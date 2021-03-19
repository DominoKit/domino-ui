package org.dominokit.domino.ui.tabs;

/**
 * Components that can have a single active item should implement this interface
 * @param <T> the type of the item that can be activated/deactivated
 */
public interface HasActiveItem<T> {
    T getActiveItem();
    void setActiveItem(T activeItem);
}
