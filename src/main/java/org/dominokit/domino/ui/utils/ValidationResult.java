package org.dominokit.domino.ui.utils;

public class ValidationResult {

    private String errorMessage;
    private boolean valid;

    public ValidationResult(boolean valid) {
        this(valid, "");
    }

    public ValidationResult(boolean valid, String errorMessage) {
        this.valid = valid;
        this.errorMessage = errorMessage;
    }

    public static ValidationResult valid() {
        return new ValidationResult(true);
    }

    public static ValidationResult invalid(String errorMessage) {
        return new ValidationResult(false, errorMessage);
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean isValid() {
        return valid;
    }
}
