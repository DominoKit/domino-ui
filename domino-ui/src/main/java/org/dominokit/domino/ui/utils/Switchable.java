package org.dominokit.domino.ui.utils;

import com.google.gwt.editor.client.Editor;

public interface Switchable<T> {

    @Editor.Ignore
    T enable();

    @Editor.Ignore
    T disable();

    @Editor.Ignore
    boolean isEnabled();
}
