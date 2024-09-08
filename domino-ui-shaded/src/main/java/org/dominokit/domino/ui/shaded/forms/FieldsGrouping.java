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
package org.dominokit.domino.ui.shaded.forms;

import static java.util.Objects.nonNull;

import elemental2.dom.HTMLElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jsinterop.base.Js;
import org.dominokit.domino.ui.shaded.forms.validations.ValidationResult;
import org.dominokit.domino.ui.shaded.keyboard.KeyboardEvents;
import org.dominokit.domino.ui.shaded.utils.*;

/**
 * This class can logically group a set of components that implements {@link HasGrouping} interface
 *
 * <p>The same component can be grouped using multiple FieldGrouping instances
 *
 * <p>The FieldsGrouping can be used to perform common logic to all grouped component with a single
 * call
 *
 * <p>example
 *
 * <pre>
 *     FieldsGrouping.create()
 *         .addFormElement(nameTextBox)
 *         .addFormElement(phoneTextBox)
 *         .addFormElement(emailBox)
 *         .setRequired(true)
 *         .setAutoValidation(true);
 * </pre>
 */
@Deprecated
public class FieldsGrouping implements HasValidation<FieldsGrouping> {

  private List<HasGrouping<?>> formElements = new ArrayList<>();
  private List<Validator> validators = new ArrayList<>();
  private List<String> errors = new ArrayList<>();

  /** @return a new instance */
  public static FieldsGrouping create() {
    return new FieldsGrouping();
  }

  /**
   * Adds a component that implements {@link HasGrouping}
   *
   * @param formElement {@link HasGrouping}
   * @return same FieldGrouping instance
   */
  public FieldsGrouping addFormElement(HasGrouping<?> formElement) {
    formElements.add(formElement);
    return this;
  }

  /**
   * Adds a component that implements {@link HasGrouping}
   *
   * @param formElements a vararg of {@link HasGrouping}
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

  /** {@inheritDoc} validate all components grouped by this FieldsGrouping in fail-fast mode */
  @Override
  public ValidationResult validate(boolean silent) {
    this.errors.clear();
    boolean fieldsValid = validateFields(silent);

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

  private boolean validateFields(boolean silent) {

    boolean valid = true;

    for (HasGrouping<?> formElement : formElements) {
      ValidationResult result = formElement.validate(silent);
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
   * change the readonly mode for all grouped components
   *
   * @param readOnly boolean, if true change all grouped components to readonly mode, otherwise
   *     switch them out of readonly mode
   * @return same FieldsGrouping instance
   */
  public FieldsGrouping setReadOnly(boolean readOnly) {
    formElements.stream()
        .filter(formElement -> formElement instanceof IsReadOnly)
        .map(Js::<IsReadOnly>cast)
        .forEach(isReadOnly -> isReadOnly.setReadOnly(readOnly));
    return this;
  }

  /**
   * Disable all grouped components
   *
   * @return same FieldsGrouping instance
   */
  public FieldsGrouping disable() {
    formElements.forEach(Switchable::disable);
    return this;
  }

  /**
   * Enable all grouped components
   *
   * @return same FieldsGrouping instance
   */
  public FieldsGrouping enable() {
    formElements.forEach(Switchable::enable);
    return this;
  }

  /** @return boolean, true if all grouped components are enabled, otherwise false */
  public boolean isEnabled() {
    return formElements.stream().allMatch(Switchable::isEnabled);
  }

  /**
   * @param autoValidation boolean, if true enables autoValidation for all grouped components,
   *     otherwise disable autoValidation
   * @return
   */
  public FieldsGrouping setAutoValidation(boolean autoValidation) {
    formElements.forEach(formElement -> formElement.setAutoValidation(autoValidation));
    return this;
  }

  /** @return boolean, true if all grouped components has autoValidation enabled */
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
  public boolean isRequired() {
    return formElements.stream().allMatch(IsRequired::isRequired);
  }

  /** @return the grouped components as a List of {@link HasGrouping} */
  public List<HasGrouping<?>> getFormElements() {
    return formElements;
  }

  /**
   * {@inheritDoc} Adds a validator to this FieldsGrouping, the validator will be applied to all
   * grouped elements when {@link #validate()} is called
   *
   * @param validator {@link Validator}
   * @return same FieldsGrouping instance
   */
  public FieldsGrouping addValidator(Validator validator) {
    validators.add(validator);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public FieldsGrouping removeValidator(Validator validator) {
    validators.remove(validator);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean hasValidator(Validator validator) {
    return validators.contains(validator);
  }

  /**
   * Removes a grouped component from this FieldsGrouping
   *
   * @param hasGrouping {@link HasGrouping}
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

  public FieldsGrouping onKeyDown(KeyboardEventsHandler handler) {
    HTMLElement[] elements = getInputElements();
    handler.accept(KeyboardEvents.listenOnKeyDown(elements));
    return this;
  }

  public FieldsGrouping onKeyUp(KeyboardEventsHandler handler) {
    HTMLElement[] elements = getInputElements();
    handler.accept(KeyboardEvents.listenOnKeyUp(elements));
    return this;
  }

  public FieldsGrouping onKeyPress(KeyboardEventsHandler handler) {
    HTMLElement[] elements = getInputElements();
    handler.accept(KeyboardEvents.listenOnKeyPress(elements));
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

  @Deprecated
  public interface KeyboardEventsHandler {
    void accept(KeyboardEvents<? extends HTMLElement> keyboardEvents);
  }
}
