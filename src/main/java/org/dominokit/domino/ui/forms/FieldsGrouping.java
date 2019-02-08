package org.dominokit.domino.ui.forms;

import jsinterop.base.Js;
import org.dominokit.domino.ui.forms.validations.ValidationResult;
import org.dominokit.domino.ui.utils.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FieldsGrouping implements HasValidation<FieldsGrouping> {

    private List<HasGrouping> formElements = new ArrayList<>();
    private List<Validator> validators = new ArrayList<>();

    public static FieldsGrouping create() {
        return new FieldsGrouping();
    }

    public FieldsGrouping addFormElement(HasGrouping formElement) {
        formElements.add(formElement);
        return this;
    }

    public ValidationResult validate() {
        boolean fieldsValid = validateFields();

        if (!fieldsValid) {
            return new ValidationResult(false, "Invalid fields");
        }

        for (Validator validator : validators) {
            ValidationResult result = validator.isValid();
            if (!result.isValid()) {
                return result;
            }
        }
        return ValidationResult.valid();
    }

    private boolean validateFields() {

        boolean valid = true;

        for (HasGrouping formElement : formElements) {
            ValidationResult result = formElement.validate();
            if (!result.isValid()) {
                valid = false;
            }
        }
        return valid;
    }

    public FieldsGrouping clear() {
        formElements.forEach(HasGrouping::clear);
        return this;
    }

    public FieldsGrouping clearInvalid() {
        formElements.forEach(HasGrouping::clearInvalid);
        return this;
    }

    public FieldsGrouping invalidate(String errorMessage) {

        return invalidate(Collections.singletonList(errorMessage));
    }

    @Override
    public FieldsGrouping invalidate(List<String> errorMessages) {
        formElements.forEach(formElement -> formElement.invalidate(errorMessages));
        return this;
    }

    public FieldsGrouping setReadOnly(boolean readOnly) {
        formElements.stream().filter(formElement -> formElement instanceof IsReadOnly)
                .map(Js::<IsReadOnly>cast)
                .forEach(isReadOnly -> isReadOnly.setReadOnly(readOnly));
        return this;
    }

    public FieldsGrouping disable() {
        formElements.forEach(Switchable::disable);
        return this;
    }

    public FieldsGrouping enable() {
        formElements.forEach(Switchable::enable);
        return this;
    }

    public boolean isEnabled() {
        return formElements.stream().allMatch(Switchable::isEnabled);
    }

    public FieldsGrouping setAutoValidation(boolean autoValidation) {
        formElements.forEach(formElement -> formElement.setAutoValidation(autoValidation));
        return this;
    }

    public boolean isAutoValidation() {
        return formElements.stream().allMatch(HasAutoValidation::isAutoValidation);
    }

    public FieldsGrouping setRequired(boolean required) {
        formElements.forEach(formElement -> formElement.setRequired(required));
        return this;
    }

    public FieldsGrouping setRequired(boolean required, String message) {
        formElements.forEach(formElement -> formElement.setRequired(required, message));
        return this;
    }

    public boolean isRequired() {
        return formElements.stream().allMatch(IsRequired::isRequired);
    }

    public List<HasGrouping> getFormElements() {
        return formElements;
    }

    public FieldsGrouping addValidator(Validator validator) {
        validators.add(validator);
        return this;
    }

    @Override
    public FieldsGrouping removeValidator(Validator validator) {
        validators.remove(validator);
        return this;
    }

    @Override
    public boolean hasValidator(Validator validator) {
        return validators.contains(validator);
    }
}
