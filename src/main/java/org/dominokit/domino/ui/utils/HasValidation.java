package org.dominokit.domino.ui.utils;

public interface HasValidation<T> {

    boolean validate();

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
