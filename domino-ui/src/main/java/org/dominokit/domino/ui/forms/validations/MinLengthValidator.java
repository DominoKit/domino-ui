package org.dominokit.domino.ui.forms.validations;

import elemental2.dom.HTMLInputElement;
import jsinterop.base.Js;
import org.dominokit.domino.ui.forms.AbstractValueBox;
import org.dominokit.domino.ui.utils.HasValidation;

/**
 * A predefined validator that validate the minimum value of a field
 */
public class MinLengthValidator implements HasValidation.Validator {

    private AbstractValueBox valueBox;

    /**
     *
     * @param valueBox the {@link AbstractValueBox} we are attaching this validator to
     */
    public MinLengthValidator(AbstractValueBox valueBox) {
        this.valueBox = valueBox;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ValidationResult isValid() {
        if (Js.<HTMLInputElement>uncheckedCast(valueBox.getInputElement().element()).validity.tooShort) {
            return ValidationResult.invalid(valueBox.getMinLengthErrorMessage());
        }
        return ValidationResult.valid();
    }
}
