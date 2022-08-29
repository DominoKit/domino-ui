package org.dominokit.domino.ui.utils;

public interface HasDefaultValue<T,V> {

    /**
     *
     * @return V the default value to be set when the instance is cleared
     */
    V getDefaultValue();

    /**
     *
     * @param defaultValue The default value to be used when the instance is created or cleared
     * @return same instance
     */
    T setDefaultValue(V defaultValue);
}
