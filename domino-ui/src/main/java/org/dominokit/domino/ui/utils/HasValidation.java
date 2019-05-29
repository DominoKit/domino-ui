package org.dominokit.domino.ui.utils;

import com.google.gwt.editor.client.Editor;
import org.dominokit.domino.ui.forms.validations.ValidationResult;

import java.util.List;

public interface HasValidation<T> {

    @Editor.Ignore
    ValidationResult validate();

    @Editor.Ignore
    T addValidator(Validator validator);

    @Editor.Ignore
    T removeValidator(Validator validator);

    @Editor.Ignore
    boolean hasValidator(Validator validator);

    @Editor.Ignore
    T invalidate(String errorMessage);

    @Editor.Ignore
    T invalidate(List<String> errorMessages);

    @Editor.Ignore
    T clearInvalid();

    @FunctionalInterface
    interface Validator {
        ValidationResult isValid();
    }
}
