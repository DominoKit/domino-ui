package org.dominokit.domino.ui.utils;


import org.gwtproject.editor.client.Editor;

/**
 * Components that need to use the auto validation feature should implement this interface
 * @param <T> the type of the class implementing this interface
 */
public interface HasAutoValidation<T> {

    /**
     *
     * @param autoValidation boolean, true to enable auto validation, false to disable it
     * @return T the instance of the implementing class
     */
    @Editor.Ignore
    T setAutoValidation(boolean autoValidation);

    /**
     *
     * @return boolean, true if auto validation is enabled, otherwise false
     */
    @Editor.Ignore
    boolean isAutoValidation();
}
