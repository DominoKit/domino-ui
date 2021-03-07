package org.dominokit.domino.ui.forms.validations;

import org.dominokit.domino.ui.forms.FormElement;
import org.dominokit.domino.ui.utils.HasValidation.Validator;

import java.util.LinkedHashSet;
import java.util.Set;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * This class associate a list of {@link Validator} with a {@link FormElement} and allow running all of the validators
 * and return the result in fail-fast style.
 */
public class ElementValidations {

    private FormElement element;
    private Set<Validator> validators = new LinkedHashSet<>();

    /**
     *
     * @param element The {@link FormElement} to be validated
     */
    public ElementValidations(FormElement element) {
        this.element = element;
    }

    /**
     * Runs all the validated over the FormElement if it is enabled and fail-fast
     * @return the {@link ValidationResult}
     */
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

    /**
     * @param validator {@link Validator}
     */
    public void addValidator(Validator validator) {
        validators.add(validator);
    }

    /**
     *
     * @param validator {@link Validator}
     */
    public void removeValidator(Validator validator) {
        if (nonNull(validator))
            validators.remove(validator);
    }

    /**
     * Checks if the current list of validators contains the specified validator
     * @param validator {@link Validator}
     * @return boolean, true if the validator in the list otherwise false
     */
    public boolean hasValidator(Validator validator) {
        return !isNull(validator) && validators.contains(validator);
    }
}
