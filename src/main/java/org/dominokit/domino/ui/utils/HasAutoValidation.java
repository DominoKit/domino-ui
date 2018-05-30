package org.dominokit.domino.ui.utils;

public interface HasAutoValidation<T> {
    T setAutoValidation(boolean autoValidation);

    boolean isAutoValidation();
}
