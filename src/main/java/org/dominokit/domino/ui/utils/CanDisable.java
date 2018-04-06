package org.dominokit.domino.ui.utils;

@FunctionalInterface
public interface CanDisable<T> {
    T disable();
}
