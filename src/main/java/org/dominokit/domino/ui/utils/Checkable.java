package org.dominokit.domino.ui.utils;

public interface Checkable<T> extends HasChangeHandlers<T, Boolean> {
    T check();

    T uncheck();

    T check(boolean silent);

    T uncheck(boolean silent);

    boolean isChecked();
}
