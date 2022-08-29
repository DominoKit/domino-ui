package org.dominokit.domino.ui.utils;

import org.gwtproject.editor.client.Editor;

public interface Clearable<T> {

    /**
     * Clears the field value and trigger the change handlers
     *
     * @return same implementing component instance
     */
    @Editor.Ignore
    T clear();

    /**
     * Clears the field value and only triggers the change handlers if silent flag is true
     *
     * @param silent boolean, if false clear the value without triggering the change handlers
     * @return same implementing component instance
     */
    @Editor.Ignore
    T clear(boolean silent);
}
