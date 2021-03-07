package org.dominokit.domino.ui.utils;

import org.gwtproject.editor.client.Editor;

/**
 * Components that need to have required value validation should implement this interface
 * @param <T> the type of the component implementing this interface
 */
public interface IsRequired<T> {

    /**
     *
     * @param required boolean, true to make the component value as required
     * @return same implementing component instance
     */
    @Editor.Ignore
    T setRequired(boolean required);

    /**
     *
     * @param required boolean, true to make the component value required
     * @param message String to show as error message when the value is missing
     * @return same implementing component instance
     */
    @Editor.Ignore
    T setRequired(boolean required, String message);

    /**
     *
     * @return boolean, true if the component value is required
     */
    @Editor.Ignore
    boolean isRequired();

    /**
     *
     * @param requiredErrorMessage String error message to show when the value is missing
     * @return same implementing component instance
     */
    @Editor.Ignore
    T setRequiredErrorMessage(String requiredErrorMessage);

    /**
     *
     * @return String required error message
     */
    @Editor.Ignore
    String getRequiredErrorMessage();
}
