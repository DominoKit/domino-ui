package org.dominokit.domino.ui.utils;

public interface KeyboardHandlers {

    @FunctionalInterface
    interface EscapeHandler {
        void onEscape();
    }

    @FunctionalInterface
    interface ArrowDownHandler {
        void onArrowDown();
    }

    @FunctionalInterface
    interface ArrowUpHandler {
        void onArrowUp();
    }

    @FunctionalInterface
    interface TabHandler {
        void onTab();
    }
}
