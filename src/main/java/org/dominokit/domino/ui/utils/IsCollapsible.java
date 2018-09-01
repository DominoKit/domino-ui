package org.dominokit.domino.ui.utils;

public interface IsCollapsible<T> {
    T collapse();

    T expand();

    T collapse(int duration);

    T expand(int duration);

    T toggleDisplay();

    boolean isCollapsed();
}
