package org.dominokit.domino.ui.utils;

/**
 * Components that has a value that can be changed and need to define listeners for the changes should implement this interface
 * @param <T> the type of the class implementing this interface
 * @param <V> the type of the component value
 */
public interface HasChangeHandlers<T, V> {

    /**
     *
     * @param changeHandler {@link ChangeHandler}
     * @return same implementing class instance
     */
    T addChangeHandler(ChangeHandler<? super V> changeHandler);

    /**
     *
     * @param changeHandler {@link ChangeHandler}
     * @return same implementing class instance
     */
    T removeChangeHandler(ChangeHandler<? super V> changeHandler);

    /**
     * Checks if a component has the specified ChangeHandler
     * @param changeHandler {@link ChangeHandler}
     * @return same implementing class instance
     */
    boolean hasChangeHandler(ChangeHandler<? super V> changeHandler);

    /**
     *
     * @param <V> the type of the component value
     */
    @FunctionalInterface
    interface ChangeHandler<V> {
        /**
         * Will be called whenever the component value is changed
         * @param value V the new value of the component
         */
        void onValueChanged(V value);
    }
}
