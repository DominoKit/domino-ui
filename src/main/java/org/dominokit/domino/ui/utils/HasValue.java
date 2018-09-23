package org.dominokit.domino.ui.utils;

public interface HasValue<T, V> {
    T withValue(V value);

    V value();
}
