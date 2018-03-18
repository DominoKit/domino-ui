package com.progressoft.brix.domino.ui.utils;

public interface IsCollapsible<T> {
    T collapse();

    T expand();

    T toggle();

    boolean isCollapsed();
}
