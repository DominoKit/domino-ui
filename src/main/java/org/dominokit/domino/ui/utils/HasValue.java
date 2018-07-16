package org.dominokit.domino.ui.utils;

public interface HasValue<T, V> {
    T setValue(V value);

    V getValue();
}
