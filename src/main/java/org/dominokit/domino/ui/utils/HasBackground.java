package org.dominokit.domino.ui.utils;


import org.dominokit.domino.ui.style.Background;

@FunctionalInterface
public interface HasBackground<T> {
    T setBackground(Background background);
}
