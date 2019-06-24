package org.dominokit.domino.ui.forms.validations;

import org.dominokit.domino.ui.forms.FormElement;
import org.dominokit.domino.ui.utils.HasValidation.Validator;

import java.util.LinkedHashSet;
import java.util.Set;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class ElementValidations {

    private FormElement element;
    private Set<Validator> validators = new LinkedHashSet<>();

    public ElementValidations(FormElement element) {
        this.element = element;
    }

    public ValidationResult validate() {
        element.clearInvalid();
        if (!element.isEnabled()) {
            return ValidationResult.valid();
        }
        for (Validator validator : validators) {
            ValidationResult result = validator.isValid();
            if (!result.isValid()) {
                element.invalidate(result.getErrorMessage());
                return result;
            }
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
}
