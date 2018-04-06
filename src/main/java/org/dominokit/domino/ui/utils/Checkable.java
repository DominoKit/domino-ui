package org.dominokit.domino.ui.utils;

public interface Checkable<T> {
    T check();

    T uncheck();

    boolean isChecked();

    T addCheckHandler(CheckHandler checkHandler);

    @FunctionalInterface
    interface CheckHandler {
        void onCheck(boolean checked);
    }
}
