package org.dominokit.domino.ui.utils;

/**
 * Component that can have a helper text should implement this interface
 * @param <T> the type of the class implementing this interface
 */
public interface HasHelperText<T> {
    /**
     *
     * @param helperText String
     * @return same implementing class instance
     */
    T setHelperText(String helperText);

    /**
     *
     * @return String helper text of the component
     */
    String getHelperText();
}
