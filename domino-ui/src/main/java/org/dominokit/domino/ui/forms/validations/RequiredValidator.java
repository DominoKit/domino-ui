package org.dominokit.domino.ui.forms.validations;

import org.dominokit.domino.ui.forms.FormElement;
import org.dominokit.domino.ui.utils.HasValidation;

/**
 * A predefined validator that validates a required field as not empty
 */
public class RequiredValidator implements HasValidation.Validator {

    private FormElement element;

    /**
     *
     * @param element the {@link FormElement} we are attaching this validator to
     */
    public RequiredValidator(FormElement element) {
        this.element = element;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public ValidationResult isValid() {
        if (element.isEmpty()) {
            return ValidationResult.invalid(element.getRequiredErrorMessage());
        }
        return ValidationResult.valid();
    }
}
