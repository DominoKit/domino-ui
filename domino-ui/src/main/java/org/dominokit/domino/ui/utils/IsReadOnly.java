package org.dominokit.domino.ui.utils;

/**
 * A component that can have a readonly mode should implement this interface
 * @param <T> the type of the class implementing this interface
 */
public interface IsReadOnly<T> {
    /**
     *
     * @param readOnly boolean, if true switch the component to readonly mode, otherwise switch out off readonly mode
     * @return same instance of the implementing class
     */
    T setReadOnly(boolean readOnly);

    /**
     *
     * @return boolean, if true then the component is in readonly mode, otherwise it is not.
     */
    boolean isReadOnly();
}
