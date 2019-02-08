package org.dominokit.domino.ui.utils;

public interface IsCollapsible<T> {
    T collapse();

    T expand();

    T show();

    T hide();

    T toggleDisplay();

    T toggleDisplay(boolean state);

    boolean isCollapsed();
}
