package org.dominokit.domino.ui.utils;

import com.google.gwt.editor.client.Editor;

public interface HasAutoValidation<T> {

    @Editor.Ignore
    T setAutoValidation(boolean autoValidation);

    @Editor.Ignore
    boolean isAutoValidation();
}
