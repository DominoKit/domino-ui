package org.dominokit.domino.ui.utils;

import org.dominokit.domino.ui.style.Color;

public interface Focusable<T> {
    T focus();

    T unfocus();

    boolean isFocused();

    T setFocusColor(Color focusColor);
}
