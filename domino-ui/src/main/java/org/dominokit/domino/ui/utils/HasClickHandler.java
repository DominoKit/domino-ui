package org.dominokit.domino.ui.utils;

/**
 * A component that can receive click interactions should implement this interface
 * @param <T> the type of the component implementing this interface
 */
public interface HasClickHandler<T> {

    /**
     *
     * @param clickHandler {@link ClickHandler}
     * @return same implementing component
     */
    T addClickHandler(ClickHandler clickHandler);

    /**
     * A function to handle click events
     */
    @FunctionalInterface
    interface ClickHandler {
        /**
         * called when the component is clicked
         */
        void onClick();
    }
}
