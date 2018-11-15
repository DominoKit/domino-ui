package org.dominokit.domino.ui.utils;


import org.gwtproject.editor.client.Editor;

public interface IsRequired<T> {

    @Editor.Ignore
    T setRequired(boolean required);

    @Editor.Ignore
    T setRequired(boolean required, String message);

    @Editor.Ignore
    boolean isRequired();

    @Editor.Ignore
    T setRequiredErrorMessage(String requiredErrorMessage);

    @Editor.Ignore
    String getRequiredErrorMessage();
}
