package org.dominokit.domino.ui.utils;

public interface IsCollapsible<T> {

    T show();

    T hide();

    T toggleDisplay();

    T toggleDisplay(boolean state);

    boolean isHidden();
}
