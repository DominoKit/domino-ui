package com.progressoft.brix.domino.ui.utils;

public interface HasActiveItem<T> {
    T getActiveItem();
    void setActiveItem(T activeItem);
}
