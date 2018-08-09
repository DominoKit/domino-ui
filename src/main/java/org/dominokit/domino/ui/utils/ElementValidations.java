package org.dominokit.domino.ui.utils;

import elemental2.dom.DomGlobal;
import org.dominokit.domino.ui.forms.FormElement;
import org.dominokit.domino.ui.utils.HasValidation.Validator;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class ElementValidations {

    private FormElement element;
    private Set<Validator> validators = new LinkedHashSet<>();
    private String requiredMessage = "* This field is required.";
    private Validator requiredValidator =  () -> {
        if (element.isEmpty())
            return ValidationResult.invalid(requiredMessage);
        return ValidationResult.valid();
    };;
    private boolean invalidated;

    public ElementValidations(FormElement element) {
        this.element = element;
    }

    public ValidationResult validate() {
        if (!element.isEnabled()) {
            element.clearInvalid();
            return ValidationResult.valid();
        }
        for (Validator validator : validators) {
            ValidationResult result = validator.isValid();
            if (!result.isValid()) {
                element.invalidate(result.getErrorMessage());
                this.invalidated = true;
                return result;
            }
        }
        if (invalidated) {
            element.clearInvalid();
            invalidated = false;
        }
        return ValidationResult.valid();
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
        this.requiredMessage = message;
        if (required) {
            addValidator(requiredValidator);
        } else {
            removeValidator(requiredValidator);
        }
    }

    public boolean isRequired() {
        return hasValidator(requiredValidator);
    }
}
