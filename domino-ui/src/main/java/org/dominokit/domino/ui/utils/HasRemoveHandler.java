package org.dominokit.domino.ui.utils;

/**
 * A component that can be removed should implement this interface
 * @param <T> the type of the component implementing this interface
 */
@FunctionalInterface
public interface HasRemoveHandler<T> {

    /**
     * adds a remove handler to the component
     * @param removeHandler {@link RemoveHandler}
     * @return same implementing component
     */
    T addRemoveHandler(RemoveHandler removeHandler);

    /**
     * a function to handle removing of the component
     */
    interface RemoveHandler {
        /**
         * Will be called when the component is being removed
         */
        void onRemove();
    }
}
