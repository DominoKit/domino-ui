package org.dominokit.domino.ui.forms.validations;

import elemental2.dom.HTMLInputElement;
import jsinterop.base.Js;
import org.dominokit.domino.ui.forms.AbstractValueBox;
import org.dominokit.domino.ui.utils.HasValidation;

public class MinLengthValidator implements HasValidation.Validator {

    private AbstractValueBox valueBox;

    public MinLengthValidator(AbstractValueBox valueBox) {
        this.valueBox = valueBox;
    }

    @Override
    public ValidationResult isValid() {
        if (Js.<HTMLInputElement>uncheckedCast(valueBox.getInputElement().element()).validity.tooShort) {
            return ValidationResult.invalid(valueBox.getMinLengthErrorMessage());
        }
        return ValidationResult.valid();
    }
}
