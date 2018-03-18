package com.progressoft.brix.domino.ui.utils;

import com.progressoft.brix.domino.ui.style.Background;

@FunctionalInterface
public interface HasBackground<T> {
    T setBackground(Background background);
}
