package org.dominokit.domino.ui.utils;

/**
 * A component that can be shown/hidden should implement this interface
 * @see org.dominokit.domino.ui.collapsible.Collapsible
 * @param <T> the type of the component implementing this interface
 */
public interface IsCollapsible<T> {

    /**
     * Show the component
     * @return same component instance
     */
    T show();

    /**
     * Hides the component
     * @return same component instance
     */
    T hide();

    /**
     * if the component is visible then hide it, otherwise show it
     * @return same component instance
     */
    T toggleDisplay();

    /**
     * Show/hides the component based on the provided flag
     * @param state boolean, if true show the component, if false hide it
     * @return same component instance
     */
    T toggleDisplay(boolean state);

    /**
     * @return boolean, true if the component is hidden
     */
    boolean isHidden();
}
