package org.dominokit.domino.ui.utils;

public interface Switchable<T> {
    T enable();

    T disable();

    boolean isEnabled();
}
