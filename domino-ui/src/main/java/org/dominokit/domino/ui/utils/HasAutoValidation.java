package org.dominokit.domino.ui.utils;

import org.gwtproject.editor.client.Editor;

public interface HasAutoValidation<T> {

    @Editor.Ignore
    T setAutoValidation(boolean autoValidation);

    @Editor.Ignore
    boolean isAutoValidation();
}
