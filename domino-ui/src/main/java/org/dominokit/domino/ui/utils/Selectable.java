package org.dominokit.domino.ui.utils;

/**
 * A component that can be selected/deselected should implement this interface
 * @param <T> the type of the component implementing this interface
 */
public interface Selectable<T> {
    /**
     * make the component selected
     * @return same implementing component instance
     */
    T select();

    /**
     * Deselect the component if it is already selected
     * @return same implementing component instance
     */
    T deselect();

    /**
     * make the component selected without triggering the selection/change handlers
     * @return same implementing component instance
     */
    T select(boolean silent);

    /**
     * deselecy\t the component without triggering the selection/change handlers
     * @return same implementing component instance
     */
    T deselect(boolean silent);

    /**
     *
     * @return boolean, true if the component is currently selected
     */
    boolean isSelected();

    /**
     * Adds a selection handler to this component, the handler will be called whenever the component selected/deselected
     * @param selectionHandler {@link SelectionHandler}
     */
    default void addSelectionHandler(SelectionHandler<T> selectionHandler){}

    /**
     * A fucntion to implement logic to be executed when a {@link Selectable} component selection changed
     * @param <T> The type of the component implementing {@link Selectable}
     */
    @FunctionalInterface
    interface SelectionHandler<T>{
        /**
         *
         * @param selectable {@link Selectable} component which has its selection changed
         */
        void onSelectionChanged(Selectable<T> selectable);
    }
}
