package org.dominokit.domino.ui.utils;

public interface HasChangeHandlers<T, V> {

    T addChangeHandler(ChangeHandler<V> changeHandler);

    T removeChangeHandler(ChangeHandler<V> changeHandler);

    @FunctionalInterface
    interface ChangeHandler<V> {
        void onValueChanged(V value);
    }
}
