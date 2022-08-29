package org.dominokit.domino.ui.utils;

public interface HasIndeterminateState<T> {

    /**
     * Change the component to its indeterminate state
     *
     * @return same component instance
     */
    T indeterminate();

    /**
     * Change the component to its indeterminate state
     *
     * @return same component instance
     */
    T determinate();

    /**
     *
     * @param indeterminate boolean, if true set the state to indeterminate otherwise determinate
     * @return same component instance
     */
    T toggleIndeterminate(boolean indeterminate);

    /**
     * Change the component to its unchecked/checked state
     *
     * @return same component instance
     */
    T toggleIndeterminate();

    /** @return boolean, true if the component is checked, otherwise false */
    boolean isChecked();
}
