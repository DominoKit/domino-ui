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

import elemental2.dom.HTMLElement;
import java.util.*;
import jsinterop.base.Js;
import org.dominokit.domino.ui.forms.validations.ValidationResult;
import org.dominokit.domino.ui.keyboard.KeyEventsConsumer;
import org.dominokit.domino.ui.utils.*;
import org.dominokit.domino.ui.utils.ApplyFunction;

/**
 * The FieldsGrouping class is responsible for grouping and managing a collection of form elements.
 * It provides various validation and manipulation functions for the grouped elements.
 *
 * <p>Usage Example:
 *
 * <pre>
 * FieldsGrouping group = FieldsGrouping.create();
 * TextInputElement usernameInput = TextInputElement.create("Username");
 * TextInputElement passwordInput = TextInputElement.create("Password");
 * group.group(usernameInput, passwordInput);
 * ValidationResult result = group.validate();
 * if (!result.isValid()) {
 *     // Handle validation errors
 *     List<String> errors = group.getErrors();
 *     // Display error messages to the user
 * }
 * </pre>
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

  /**
   * Constructs a new FieldsGrouping instance.
   *
   * @return A new FieldsGrouping instance.
   */
  public static FieldsGrouping create() {
    return new FieldsGrouping();
  }

  /**
   * Adds a form element to the group.
   *
   * @param formElement The form element to add to the group.
   * @return The current FieldsGrouping instance for method chaining.
   */
  public FieldsGrouping addFormElement(HasGrouping<?> formElement) {
    formElements.add(formElement);
    return this;
  }

  /**
   * Groups multiple form elements together.
   *
   * @param formElements The form elements to group together.
   * @return The current FieldsGrouping instance for method chaining.
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
   * Validates all the grouped form elements and returns the validation result.
   *
   * @return The validation result.
   */
  public ValidationResult validate() {
    return validate(this);
  }

  /**
   * Validates the form elements in the group.
   *
   * @param fieldsGrouping The `FieldsGrouping` instance to validate.
   * @return A `ValidationResult` indicating whether the form elements are valid.
   */
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

  /**
   * Validates all the form elements in the group.
   *
   * @return A boolean value indicating whether all form elements in the group are valid.
   */
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
   * Clears the values of all form elements in the group.
   *
   * @return The current `FieldsGrouping` instance for method chaining.
   */
  public FieldsGrouping clear() {
    formElements.forEach(HasGrouping::clear);
    return this;
  }

  /**
   * Clears the values of all form elements in the group, optionally suppressing events.
   *
   * @param silent If `true`, events will be suppressed; otherwise, events will be fired.
   * @return The current `FieldsGrouping` instance for method chaining.
   */
  public FieldsGrouping clear(boolean silent) {
    formElements.forEach(hasGrouping -> hasGrouping.clear(silent));
    return this;
  }

  /**
   * Clears invalid values from the form elements in the group.
   *
   * @return The current `FieldsGrouping` instance for method chaining.
   */
  @Override
  public FieldsGrouping clearInvalid() {
    formElements.forEach(HasGrouping::clearInvalid);
    this.errors.clear();
    return this;
  }

  /**
   * Invalidates the form elements in the group with a single error message.
   *
   * @param errorMessage The error message to associate with the invalid form elements.
   * @return The current `FieldsGrouping` instance for method chaining.
   */
  @Override
  public FieldsGrouping invalidate(String errorMessage) {
    return invalidate(Collections.singletonList(errorMessage));
  }

  /**
   * Invalidates the form elements in the group with a list of error messages.
   *
   * @param errorMessages The list of error messages to associate with the invalid form elements.
   * @return The current `FieldsGrouping` instance for method chaining.
   */
  @Override
  public FieldsGrouping invalidate(List<String> errorMessages) {
    formElements.forEach(formElement -> formElement.invalidate(errorMessages));
    this.errors.addAll(errorMessages);
    return this;
  }

  /**
   * Sets the read-only state of all form elements in the group.
   *
   * @param readOnly `true` to set form elements as read-only, `false` otherwise.
   * @return The current `FieldsGrouping` instance for method chaining.
   */
  @Override
  public FieldsGrouping setReadOnly(boolean readOnly) {
    formElements.stream()
        .filter(formElement -> formElement instanceof AcceptReadOnly)
        .map(Js::<AcceptReadOnly>cast)
        .forEach(acceptReadOnly -> acceptReadOnly.setReadOnly(readOnly));
    return this;
  }

  /**
   * Checks if all form elements in the group are in read-only state.
   *
   * @return `true` if all form elements are read-only, `false` otherwise.
   */
  @Override
  public boolean isReadOnly() {
    return formElements.stream().allMatch(AcceptReadOnly::isReadOnly);
  }

  /**
   * Disables all form elements in the group.
   *
   * @return The current `FieldsGrouping` instance for method chaining.
   */
  @Override
  public FieldsGrouping disable() {
    formElements.forEach(AcceptDisable::disable);
    return this;
  }

  /**
   * Enables all form elements in the group.
   *
   * @return The current `FieldsGrouping` instance for method chaining.
   */
  @Override
  public FieldsGrouping enable() {
    formElements.forEach(AcceptDisable::enable);
    return this;
  }

  /**
   * Checks if all form elements in the group are enabled.
   *
   * @return `true` if all form elements are enabled, `false` otherwise.
   */
  @Override
  public boolean isEnabled() {
    return formElements.stream().allMatch(AcceptDisable::isEnabled);
  }

  /**
   * Sets the auto-validation state for all form elements in the group.
   *
   * @param autoValidation `true` to enable auto-validation, `false` to disable it.
   * @return The current `FieldsGrouping` instance for method chaining.
   */
  public FieldsGrouping setAutoValidation(boolean autoValidation) {
    formElements.forEach(formElement -> formElement.setAutoValidation(autoValidation));
    return this;
  }

  /**
   * Checks if all form elements in the group are set to auto-validate.
   *
   * @return `true` if all form elements are set to auto-validate, `false` otherwise.
   */
  public boolean isAutoValidation() {
    return formElements.stream().allMatch(HasAutoValidation::isAutoValidation);
  }

  /**
   * Sets the required state for all form elements in the group.
   *
   * @param required `true` to set form elements as required, `false` otherwise.
   * @return The current `FieldsGrouping` instance for method chaining.
   */
  public FieldsGrouping setRequired(boolean required) {
    formElements.forEach(formElement -> formElement.setRequired(required));
    return this;
  }

  /**
   * Sets the required state for all form elements in the group with a custom error message.
   *
   * @param required `true` to set form elements as required, `false` otherwise.
   * @param message The custom error message to display for required form elements.
   * @return The current `FieldsGrouping` instance for method chaining.
   */
  public FieldsGrouping setRequired(boolean required, String message) {
    formElements.forEach(formElement -> formElement.setRequired(required, message));
    return this;
  }

  /**
   * Checks if all form elements in the group are set as required.
   *
   * @return `true` if all form elements are set as required, `false` otherwise.
   */
  public boolean isRequired() {
    return formElements.stream().allMatch(IsRequired::isRequired);
  }

  /**
   * Retrieves a list of all form elements within this `FieldsGrouping`.
   *
   * @return A list containing all form elements within this group.
   */
  public List<HasGrouping<?>> getFormElements() {
    return formElements;
  }

  /**
   * Adds a custom validator to this `FieldsGrouping`.
   *
   * @param validator The validator to add.
   * @return The current `FieldsGrouping` instance for method chaining.
   */
  public FieldsGrouping addValidator(Validator<FieldsGrouping> validator) {
    validators.add(validator);
    return this;
  }

  /**
   * Removes a custom validator from this `FieldsGrouping`.
   *
   * @param validator The validator to remove.
   * @return The current `FieldsGrouping` instance for method chaining.
   */
  @Override
  public FieldsGrouping removeValidator(Validator<FieldsGrouping> validator) {
    validators.remove(validator);
    return this;
  }

  /**
   * Checks if a specific validator is added to this `FieldsGrouping`.
   *
   * @param validator The validator to check.
   * @return `true` if the validator is added, `false` otherwise.
   */
  @Override
  public boolean hasValidator(Validator<FieldsGrouping> validator) {
    return validators.contains(validator);
  }

  /**
   * Retrieves a set of all custom validators added to this `FieldsGrouping`.
   *
   * @return A set containing all custom validators added to this group.
   */
  @Override
  public Set<Validator<FieldsGrouping>> getValidators() {
    return validators;
  }

  /**
   * Pauses all form element validations within this `FieldsGrouping`.
   *
   * @return The current `FieldsGrouping` instance for method chaining.
   */
  @Override
  public FieldsGrouping pauseValidations() {
    formElements.forEach(HasValidation::pauseValidations);
    this.validationsPaused = true;
    return this;
  }

  /**
   * Resumes all form element validations within this `FieldsGrouping`.
   *
   * @return The current `FieldsGrouping` instance for method chaining.
   */
  @Override
  public FieldsGrouping resumeValidations() {
    formElements.forEach(HasValidation::resumeValidations);
    this.validationsPaused = false;
    return this;
  }

  /**
   * Toggles the pause state of form element validations within this `FieldsGrouping`.
   *
   * @param toggle `true` to pause form element validations, `false` to resume them.
   * @return The current `FieldsGrouping` instance for method chaining.
   */
  @Override
  public FieldsGrouping togglePauseValidations(boolean toggle) {
    formElements.forEach(formElement -> formElement.togglePauseValidations(toggle));
    this.validationsPaused = toggle;
    return this;
  }

  /**
   * Pauses focus-related form element validations within this `FieldsGrouping`. Focus-related
   * validations are validations that occur when a form element receives or loses focus.
   *
   * @return The current `FieldsGrouping` instance for method chaining.
   */
  @Override
  public FieldsGrouping pauseFocusValidations() {
    this.focusValidationsPaused = true;
    formElements.forEach(HasValidation::pauseFocusValidations);
    return this;
  }

  /**
   * Resumes focus-related form element validations within this `FieldsGrouping`.
   *
   * @return The current `FieldsGrouping` instance for method chaining.
   */
  @Override
  public FieldsGrouping resumeFocusValidations() {
    this.focusValidationsPaused = false;
    formElements.forEach(HasValidation::resumeFocusValidations);
    return this;
  }

  /**
   * Toggles the pause state of focus-related form element validations within this `FieldsGrouping`.
   *
   * @param toggle `true` to pause focus-related validations, `false` to resume them.
   * @return The current `FieldsGrouping` instance for method chaining.
   */
  @Override
  public FieldsGrouping togglePauseFocusValidations(boolean toggle) {
    this.focusValidationsPaused = toggle;
    formElements.forEach(field -> field.togglePauseFocusValidations(toggle));
    return this;
  }

  /**
   * Checks if focus-related validations are paused within this `FieldsGrouping`.
   *
   * @return `true` if focus-related validations are paused, `false` otherwise.
   */
  @Override
  public boolean isFocusValidationsPaused() {
    return this.focusValidationsPaused;
  }

  /**
   * Checks if form element validations are paused within this `FieldsGrouping`.
   *
   * @return `true` if form element validations are paused, `false` otherwise.
   */
  @Override
  public boolean isValidationsPaused() {
    return validationsPaused;
  }

  /**
   * Creates and returns an `AutoValidator` with the specified auto-validation function for this
   * `FieldsGrouping`.
   *
   * @param autoValidate The auto-validation function to apply.
   * @return An `AutoValidator` instance with the provided auto-validation function.
   */
  @Override
  public AutoValidator createAutoValidator(ApplyFunction autoValidate) {
    formElements.forEach(formElement -> formElement.createAutoValidator(autoValidate));
    return new AutoValidator(autoValidate) {};
  }

  /**
   * Initiates auto-validation for this `FieldsGrouping`. Auto-validation automatically validates
   * the form elements within this group based on their current values.
   *
   * @return The current `FieldsGrouping` instance for method chaining.
   */
  @Override
  public FieldsGrouping autoValidate() {
    if (isAutoValidation()) {
      validate(this);
    }
    return this;
  }

  /**
   * Removes a specific form element from this `FieldsGrouping`.
   *
   * @param hasGrouping The form element to remove.
   * @return The current `FieldsGrouping` instance for method chaining.
   */
  public FieldsGrouping removeFormElement(HasGrouping hasGrouping) {
    formElements.remove(hasGrouping);
    return this;
  }

  /**
   * Removes all form elements from this `FieldsGrouping`.
   *
   * @return The current `FieldsGrouping` instance for method chaining.
   */
  public FieldsGrouping removeAllFormElements() {
    formElements.clear();
    return this;
  }

  /**
   * Retrieves a list of error messages generated during the validation of form elements within this
   * `FieldsGrouping`.
   *
   * @return A list of error messages as strings.
   */
  @Override
  public List<String> getErrors() {
    return errors;
  }

  /**
   * Registers a key down event listener for all input elements within this `FieldsGrouping`.
   *
   * @param handler The event handler to execute on key down events.
   * @return The current `FieldsGrouping` instance for method chaining.
   */
  public FieldsGrouping onKeyDown(KeyEventsConsumer handler) {
    HTMLElement[] elements = getInputElements();
    Arrays.stream(elements)
        .map(ElementsFactory.elements::elementOf)
        .forEach(element -> element.onKeyDown(handler));
    return this;
  }

  /**
   * Registers a key up event listener for all input elements within this `FieldsGrouping`.
   *
   * @param handler The event handler to execute on key up events.
   * @return The current `FieldsGrouping` instance for method chaining.
   */
  public FieldsGrouping onKeyUp(KeyEventsConsumer handler) {
    HTMLElement[] elements = getInputElements();
    Arrays.stream(elements)
        .map(ElementsFactory.elements::elementOf)
        .forEach(element -> element.onKeyUp(handler));
    return this;
  }

  /**
   * Registers a key press event listener for all input elements within this `FieldsGrouping`.
   *
   * @param handler The event handler to execute on key press events.
   * @return The current `FieldsGrouping` instance for method chaining.
   */
  public FieldsGrouping onKeyPress(KeyEventsConsumer handler) {
    HTMLElement[] elements = getInputElements();
    Arrays.stream(elements)
        .map(ElementsFactory.elements::elementOf)
        .forEach(element -> element.onKeyPress(handler));
    return this;
  }

  /**
   * Retrieves an array of HTML elements representing the input elements within this
   * `FieldsGrouping`.
   *
   * @return An array of `HTMLElement` objects.
   */
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
