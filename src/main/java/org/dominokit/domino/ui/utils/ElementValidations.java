package org.dominokit.domino.ui.utils;

import org.dominokit.domino.ui.forms.FormElement;
import org.dominokit.domino.ui.utils.HasValidation.Validator;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class ElementValidations {

    private FormElement element;
    private List<Validator> validators = new ArrayList<>();
    private Validator requiredValidator;

    public ElementValidations(FormElement element) {
        this.element = element;
    }

    public boolean validate() {
        for (Validator validator : validators) {
            ValidationResult result = validator.isValid();
            if (!result.isValid()) {
                element.invalidate(result.getErrorMessage());
                return false;
            }
        }
        element.clearInvalid();
        return true;
    }

    public void addValidator(Validator validator) {
        validators.add(validator);
    }

    public void removeValidator(Validator validator) {
        if (nonNull(validator))
            validators.remove(validator);
    }

    public boolean hasValidator(Validator validator) {
        return !isNull(validator) && validators.contains(validator);
    }

    public void setRequired(boolean required) {
        setRequired(required, "* This field is required.");
    }

    public void setRequired(boolean required, String message) {
        if (required) {
            if (isNull(requiredValidator)) {
                requiredValidator = () -> {
                    if (element.isEmpty())
                        return ValidationResult.invalid(message);
                    return ValidationResult.valid();
                };
                addValidator(requiredValidator);
            }
        } else {
            removeValidator(requiredValidator);
        }
    }

    public boolean isRequired() {
        return hasValidator(requiredValidator);
    }
}
