package org.dominokit.domino.ui.utils;

@FunctionalInterface
public interface HasAutoValidation<T> {
    T setAutoValidation(boolean autoValidation);
}
