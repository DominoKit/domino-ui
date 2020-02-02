package org.dominokit.domino.ui.forms.validations;

import org.dominokit.domino.ui.forms.FormElement;
import org.dominokit.domino.ui.utils.HasValidation;

public class RequiredValidator implements HasValidation.Validator {

    private FormElement element;

    public RequiredValidator(FormElement element) {
        this.element = element;
    }

    @Override
    public ValidationResult isValid() {
        if (element.isEmpty()) {
            return ValidationResult.invalid(element.getRequiredErrorMessage());
        }
        return ValidationResult.valid();
    }
}
