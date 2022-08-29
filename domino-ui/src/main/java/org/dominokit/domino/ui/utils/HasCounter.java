package org.dominokit.domino.ui.utils;

public interface HasCounter<T> {
    T updateCounter(int count, int maxCount);
    int getMaxCount();

    interface CountFormatter {
        String format(int count, int maxCount);
    }
}
