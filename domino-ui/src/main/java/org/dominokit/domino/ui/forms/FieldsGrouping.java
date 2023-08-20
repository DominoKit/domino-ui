/*
 * Copyright © 2019 Dominokit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dominokit.domino.ui.forms;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import elemental2.dom.HTMLElement;
import java.util.*;
import jsinterop.base.Js;
import org.dominokit.domino.ui.forms.validations.ValidationResult;
import org.dominokit.domino.ui.keyboard.KeyEventsConsumer;
import org.dominokit.domino.ui.utils.*;
import org.dominokit.domino.ui.utils.ApplyFunction;

/**
 * This class can logically group a set of components that implements {@link
 * org.dominokit.domino.ui.forms.HasGrouping} interface
 *
 * <p>The same component can be grouped using multiple FieldGrouping instances
 *
 * <p>The FieldsGrouping can be used to perform common logic to all grouped component with a single
 * call
 */
public class FieldsGrouping
    implements HasValidation<FieldsGrouping>,
        AcceptReadOnly<FieldsGrouping>,
        AcceptDisable<FieldsGrouping> {

  private final List<HasGrouping<?>> formElements = new ArrayList<>();
  private final Set<Validator<FieldsGrouping>> validators = new LinkedHashSet<>();
  private final List<String> errors = new ArrayList<>();

  private boolean validationsPaused = false;
  private boolean focusValidationsPaused = false;

  /** @return a new instance */
  /**
   * create.
   *
   * @return a {@link org.dominokit.domino.ui.forms.FieldsGrouping} object
   */
  public static FieldsGrouping create() {
    return new FieldsGrouping();
  }

  /**
   * Adds a component that implements {@link org.dominokit.domino.ui.forms.HasGrouping}
   *
   * @param formElement {@link org.dominokit.domino.ui.forms.HasGrouping}
   * @return same FieldGrouping instance
   */
  public FieldsGrouping addFormElement(HasGrouping<?> formElement) {
    formElements.add(formElement);
    return this;
  }

  /**
   * Adds a component that implements {@link org.dominokit.domino.ui.forms.HasGrouping}
   *
   * @param formElements a vararg of {@link org.dominokit.domino.ui.forms.HasGrouping}
   * @return same FieldGrouping instance
   */
  public FieldsGrouping group(HasGrouping<?>... formElements) {
    if (nonNull(formElements) && formElements.length > 0) {
      for (HasGrouping<?> formElement : formElements) {
        addFormElement(formElement);
      }
    }
    return this;
  }

  /**
   * validate.
   *
   * @return a {@link org.dominokit.domino.ui.forms.validations.ValidationResult} object
   */
  public ValidationResult validate() {
    return validate(this);
  }

  /** {@inheritDoc} validate all components grouped by this FieldsGrouping in fail-fast mode */
  @Override
  public ValidationResult validate(FieldsGrouping fieldsGrouping) {
    if (!validationsPaused) {
      this.errors.clear();
      boolean fieldsValid = validateFields();

      if (!fieldsValid) {
        return new ValidationResult(false, "Invalid fields");
      }

      for (Validator validator : validators) {
        ValidationResult result = validator.isValid(fieldsGrouping);
        if (!result.isValid()) {
          return result;
        }
      }
    }
    return ValidationResult.valid();
  }

  private boolean validateFields() {

    boolean valid = true;

    for (HasGrouping<?> formElement : formElements) {
      ValidationResult result = formElement.validate();
      if (!result.isValid()) {
        valid = false;
        this.errors.addAll(formElement.getErrors());
      }
    }
    return valid;
  }

  /**
   * Clears all the grouped components
   *
   * @return same FieldsGrouping instance
   */
  public FieldsGrouping clear() {
    formElements.forEach(HasGrouping::clear);
    return this;
  }

  /**
   * Clears all the grouped components
   *
   * @param silent if true clear the fields without triggering the change handlers
   * @return same FieldsGrouping instance
   */
  public FieldsGrouping clear(boolean silent) {
    formElements.forEach(hasGrouping -> hasGrouping.clear(silent));
    return this;
  }

  /** {@inheritDoc} Remove all validation messages from all grouped components */
  @Override
  public FieldsGrouping clearInvalid() {
    formElements.forEach(HasGrouping::clearInvalid);
    this.errors.clear();
    return this;
  }

  /** {@inheritDoc} Invalidate all the grouped components using the provided errorMessage */
  @Override
  public FieldsGrouping invalidate(String errorMessage) {
    return invalidate(Collections.singletonList(errorMessage));
  }

  /**
   * {@inheritDoc} Invalidate all the grouped components using the provided list of errorMessages
   */
  @Override
  public FieldsGrouping invalidate(List<String> errorMessages) {
    formElements.forEach(formElement -> formElement.invalidate(errorMessages));
    this.errors.addAll(errorMessages);
    return this;
  }

  /**
   * {@inheritDoc}
   *
   * <p>change the readonly mode for all grouped components
   */
  @Override
  public FieldsGrouping setReadOnly(boolean readOnly) {
    formElements.stream()
        .filter(formElement -> formElement instanceof AcceptReadOnly)
        .map(Js::<AcceptReadOnly>cast)
        .forEach(acceptReadOnly -> acceptReadOnly.setReadOnly(readOnly));
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isReadOnly() {
    return formElements.stream().allMatch(AcceptReadOnly::isReadOnly);
  }

  /**
   * {@inheritDoc}
   *
   * <p>Disable all grouped components
   */
  @Override
  public FieldsGrouping disable() {
    formElements.forEach(AcceptDisable::disable);
    return this;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Enable all grouped components
   */
  @Override
  public FieldsGrouping enable() {
    formElements.forEach(AcceptDisable::enable);
    return this;
  }

  /** @return boolean, true if all grouped components are enabled, otherwise false */
  /** {@inheritDoc} */
  @Override
  public boolean isEnabled() {
    return formElements.stream().allMatch(AcceptDisable::isEnabled);
  }

  /** {@inheritDoc} */
  public FieldsGrouping setAutoValidation(boolean autoValidation) {
    formElements.forEach(formElement -> formElement.setAutoValidation(autoValidation));
    return this;
  }

  /** @return boolean, true if all grouped components has autoValidation enabled */
  /**
   * isAutoValidation.
   *
   * @return a boolean
   */
  public boolean isAutoValidation() {
    return formElements.stream().allMatch(HasAutoValidation::isAutoValidation);
  }

  /**
   * Disable/Enable required for all grouped components
   *
   * @param required boolean, if true set all grouped components to required, otherwise to not
   *     required
   * @return same FieldsGrouping instance
   */
  public FieldsGrouping setRequired(boolean required) {
    formElements.forEach(formElement -> formElement.setRequired(required));
    return this;
  }

  /**
   * Disable/Enable required for all grouped components with a custom required message
   *
   * @param required boolean, if true set all grouped components to required, otherwise to not
   *     required
   * @param message String required validation message
   * @return same FieldsGrouping instance
   */
  public FieldsGrouping setRequired(boolean required, String message) {
    formElements.forEach(formElement -> formElement.setRequired(required, message));
    return this;
  }

  /** @return boolean, true if all grouped components are required */
  /**
   * isRequired.
   *
   * @return a boolean
   */
  public boolean isRequired() {
    return formElements.stream().allMatch(IsRequired::isRequired);
  }

  /** @return the grouped components as a List of {@link HasGrouping} */
  /**
   * Getter for the field <code>formElements</code>.
   *
   * @return a {@link java.util.List} object
   */
  public List<HasGrouping<?>> getFormElements() {
    return formElements;
  }

  /**
   * {@inheritDoc} Adds a validator to this FieldsGrouping, the validator will be applied to all
   * grouped elements when {@link #validate(FieldsGrouping)} is called
   *
   * @param validator {@link Validator}
   * @return same FieldsGrouping instance
   */
  public FieldsGrouping addValidator(Validator<FieldsGrouping> validator) {
    validators.add(validator);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public FieldsGrouping removeValidator(Validator<FieldsGrouping> validator) {
    validators.remove(validator);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean hasValidator(Validator<FieldsGrouping> validator) {
    return validators.contains(validator);
  }

  /** {@inheritDoc} */
  @Override
  public Set<Validator<FieldsGrouping>> getValidators() {
    return validators;
  }

  /** {@inheritDoc} */
  @Override
  public FieldsGrouping pauseValidations() {
    formElements.forEach(HasValidation::pauseValidations);
    this.validationsPaused = true;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public FieldsGrouping resumeValidations() {
    formElements.forEach(HasValidation::resumeValidations);
    this.validationsPaused = false;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public FieldsGrouping togglePauseValidations(boolean toggle) {
    formElements.forEach(formElement -> formElement.togglePauseValidations(toggle));
    this.validationsPaused = toggle;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public FieldsGrouping pauseFocusValidations() {
    this.focusValidationsPaused = true;
    formElements.forEach(HasValidation::pauseFocusValidations);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public FieldsGrouping resumeFocusValidations() {
    this.focusValidationsPaused = false;
    formElements.forEach(HasValidation::resumeFocusValidations);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public FieldsGrouping togglePauseFocusValidations(boolean toggle) {
    this.focusValidationsPaused = toggle;
    formElements.forEach(field -> field.togglePauseFocusValidations(toggle));
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isFocusValidationsPaused() {
    return this.focusValidationsPaused;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isValidationsPaused() {
    return validationsPaused;
  }

  /** {@inheritDoc} */
  @Override
  public AutoValidator createAutoValidator(ApplyFunction autoValidate) {
    formElements.forEach(formElement -> formElement.createAutoValidator(autoValidate));
    return new AutoValidator(autoValidate) {};
  }

  /** {@inheritDoc} */
  @Override
  public FieldsGrouping autoValidate() {
    if (isAutoValidation()) {
      validate(this);
    }
    return this;
  }

  /**
   * Removes a grouped component from this FieldsGrouping
   *
   * @param hasGrouping {@link org.dominokit.domino.ui.forms.HasGrouping}
   * @return same FieldsGrouping instance
   */
  public FieldsGrouping removeFormElement(HasGrouping hasGrouping) {
    formElements.remove(hasGrouping);
    return this;
  }

  /**
   * Removes all grouped components from this FieldsGrouping
   *
   * @return same FieldsGrouping insatnce
   */
  public FieldsGrouping removeAllFormElements() {
    formElements.clear();
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public List<String> getErrors() {
    return errors;
  }

  /**
   * onKeyDown.
   *
   * @param handler a {@link org.dominokit.domino.ui.keyboard.KeyEventsConsumer} object
   * @return a {@link org.dominokit.domino.ui.forms.FieldsGrouping} object
   */
  public FieldsGrouping onKeyDown(KeyEventsConsumer handler) {
    HTMLElement[] elements = getInputElements();
    Arrays.stream(elements)
        .map(ElementsFactory.elements::elementOf)
        .forEach(element -> element.onKeyDown(handler));
    return this;
  }

  /**
   * onKeyUp.
   *
   * @param handler a {@link org.dominokit.domino.ui.keyboard.KeyEventsConsumer} object
   * @return a {@link org.dominokit.domino.ui.forms.FieldsGrouping} object
   */
  public FieldsGrouping onKeyUp(KeyEventsConsumer handler) {
    HTMLElement[] elements = getInputElements();
    Arrays.stream(elements)
        .map(ElementsFactory.elements::elementOf)
        .forEach(element -> element.onKeyUp(handler));
    return this;
  }

  /**
   * onKeyPress.
   *
   * @param handler a {@link org.dominokit.domino.ui.keyboard.KeyEventsConsumer} object
   * @return a {@link org.dominokit.domino.ui.forms.FieldsGrouping} object
   */
  public FieldsGrouping onKeyPress(KeyEventsConsumer handler) {
    HTMLElement[] elements = getInputElements();
    Arrays.stream(elements)
        .map(ElementsFactory.elements::elementOf)
        .forEach(element -> element.onKeyPress(handler));
    return this;
  }

  private HTMLElement[] getInputElements() {
    HTMLElement[] elements =
        formElements.stream()
            .filter(hasGrouping -> hasGrouping instanceof HasInputElement)
            .map(hasGrouping -> (HasInputElement) hasGrouping)
            .map(hasInputElement -> hasInputElement.getInputElement().element())
            .toArray(HTMLElement[]::new);
    return elements;
  }
}
