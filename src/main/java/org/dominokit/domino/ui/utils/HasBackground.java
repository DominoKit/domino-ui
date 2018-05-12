package org.dominokit.domino.ui.utils;


import org.dominokit.domino.ui.style.Color;

@FunctionalInterface
public interface HasBackground<T> {
    T setBackground(Color background);
}
