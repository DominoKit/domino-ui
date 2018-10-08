package org.dominokit.domino.ui.utils;

import org.dominokit.domino.ui.forms.validations.ValidationResult;

public interface HasValidation<T> {

    ValidationResult validate();

    T addValidator(Validator validator);

    T removeValidator(Validator validator);

    boolean hasValidator(Validator validator);

    T invalidate(String errorMessage);

    T clearInvalid();

    @FunctionalInterface
    interface Validator {
        ValidationResult isValid();
    }
}
