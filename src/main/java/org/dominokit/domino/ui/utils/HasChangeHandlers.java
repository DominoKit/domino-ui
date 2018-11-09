package org.dominokit.domino.ui.utils;

public interface HasChangeHandlers<T, V> {

    T addChangeHandler(ChangeHandler<? super V> changeHandler);

    T removeChangeHandler(ChangeHandler<? super V> changeHandler);

    boolean hasChangeHandler(ChangeHandler<? super V> changeHandler);

    @FunctionalInterface
    interface ChangeHandler<V> {
        void onValueChanged(V value);
    }
}
