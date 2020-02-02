package org.dominokit.domino.ui.utils;

public interface IsReadOnly<T> {
    T setReadOnly(boolean readOnly);

    boolean isReadOnly();
}
