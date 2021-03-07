package org.dominokit.domino.ui.utils;

import org.gwtproject.editor.client.Editor;

/**
 * Components that can be enabled/disabled should implement this interface
 * @param <T> the type of the component implementing this interface
 */
public interface Switchable<T> {

    /**
     * Set the component as enabled
     * @return same implementing component
     */
    @Editor.Ignore
    T enable();

    /**
     * Set the component as disabled
     * @return same implementing component
     */
    @Editor.Ignore
    T disable();

    /**
     *
     * @return boolean, true if component is enabled else false
     */
    @Editor.Ignore
    boolean isEnabled();
}
