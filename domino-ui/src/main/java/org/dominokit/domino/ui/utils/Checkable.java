package org.dominokit.domino.ui.utils;

/**
 * A Component that needs to have a toggle state (checked/unchecked) should implement this interface
 * @param <T> The type of the component implementing this interface
 */
public interface Checkable<T> extends HasChangeHandlers<T, Boolean> {
    /**
     * Change the component to its checked state
     * @return same component instance
     */
    T check();

    /**
     * Change the component to its unchecked state
     * @return same component instance
     */
    T uncheck();

    /**
     * Change the component to its checked state without triggering change handlers
     * @param silent boolean, if true dont trigger change handlers
     * @return same component instance
     */
    T check(boolean silent);

    /**
     * Change the component to its unchecked state without triggering change handlers
     * @param silent boolean, if true dont trigger change handlers
     * @return same component instance
     */
    T uncheck(boolean silent);

    /**
     *
     * @return boolean, true if the component is checked, otherwise false
     */
    boolean isChecked();
}
