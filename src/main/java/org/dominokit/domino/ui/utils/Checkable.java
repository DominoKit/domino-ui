package org.dominokit.domino.ui.utils;

public interface Checkable<T> {
    T check();

    T uncheck();

    T check(boolean silent);

    T uncheck(boolean silent);

    boolean isChecked();

    T addCheckHandler(CheckHandler checkHandler);

    T removeCheckHandler(CheckHandler checkHandler);

    @FunctionalInterface
    interface CheckHandler {
        void onCheck(boolean checked);
    }
}
