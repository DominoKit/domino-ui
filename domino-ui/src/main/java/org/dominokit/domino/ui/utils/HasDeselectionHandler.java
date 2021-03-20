package org.dominokit.domino.ui.utils;

/**
 * a component that can be deselected should implement this interface
 * @param <T> the type of the component implementing this interface
 */
public interface HasDeselectionHandler<T> {
    /**
     *
     * @param deselectionHandler {@link DeselectionHandler}
     * @return same implementing component
     */
    T addDeselectionHandler(DeselectionHandler deselectionHandler);

    /**
     * A function to implement component deselection
     */
    interface DeselectionHandler {
        /**
         * called when the component being deselected
         */
        void onDeselection();
    }
}
