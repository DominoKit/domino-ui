package org.dominokit.domino.ui.utils;

public interface HasLength<T> {
    T setMaxLength(int maxLength);

    int getMaxLength();

    T setMinLength(int minLength);

    int getMinLength();
}
