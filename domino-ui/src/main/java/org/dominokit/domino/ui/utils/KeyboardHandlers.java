package org.dominokit.domino.ui.utils;

/**
 * A component that should provide handlers for keyboard events should implement this interface
 */
public interface KeyboardHandlers {

    /**
     * a function to handle the Escape key
     */
    @FunctionalInterface
    interface EscapeHandler {
        void onEscape();
    }

    /**
     * a function to handle the Arrow down key
     */
    @FunctionalInterface
    interface ArrowDownHandler {
        void onArrowDown();
    }

    /**
     * a function to handle the Arrow up key
     */
    @FunctionalInterface
    interface ArrowUpHandler {
        void onArrowUp();
    }

    /**
     * a function to handle the Tab key
     */
    @FunctionalInterface
    interface TabHandler {
        void onTab();
    }
}
