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

package org.dominokit.domino.ui.utils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.dominokit.domino.ui.forms.validations.ValidationResult;
import org.gwtproject.editor.client.Editor;

/**
 * The {@code HasValidation} interface defines methods for performing validation on a target object.
 *
 * @param <T> The type of the target object to be validated.
 */
public interface HasValidation<T> extends HasAutoValidation<T> {

  /**
   * Validates the target object and returns the validation result.
   *
   * @param target The target object to be validated.
   * @return The validation result.
   */
  @Editor.Ignore
  ValidationResult validate(T target);

  /**
   * Gets the set of validators associated with this object.
   *
   * @return The set of validators.
   */
  Set<Validator<T>> getValidators();

  /**
   * Validates the target object using all associated validators and returns a list of validation
   * results. Clears any previous validation errors and invalidates the object if validation fails.
   *
   * @param target The target object to be validated.
   * @return A list of validation results.
   */
  @Editor.Ignore
  default List<ValidationResult> validateAll(T target) {
    clearInvalid();
    List<ValidationResult> validationResults =
        getValidators().stream()
            .map(validator -> validator.isValid(target))
            .collect(Collectors.toList());
    List<String> errorMessages =
        validationResults.stream()
            .filter(validationResult -> !validationResult.isValid())
            .map(ValidationResult::getErrorMessage)
            .collect(Collectors.toList());

    if (!errorMessages.isEmpty()) {
      invalidate(errorMessages);
    }
    return validationResults;
  }

  /**
   * Adds a validator to the set of associated validators.
   *
   * @param validator The validator to be added.
   * @return This object after adding the validator.
   */
  @Editor.Ignore
  default T addValidator(Validator<T> validator) {
    getValidators().add(validator);
    return (T) this;
  }

  /**
   * Removes a validator from the set of associated validators.
   *
   * @param validator The validator to be removed.
   * @return This object after removing the validator.
   */
  @Editor.Ignore
  default T removeValidator(Validator<T> validator) {
    getValidators().remove(validator);
    return (T) this;
  }

  /**
   * Adds or removes a validator based on the given state.
   *
   * @param validator The validator to be added or removed.
   * @param state A boolean value indicating whether to add or remove the validator.
   * @return This object after adding or removing the validator.
   */
  default T addOrRemoveValidator(Validator<T> validator, boolean state) {
    if (state) {
      addValidator(validator);
    } else {
      removeValidator(validator);
    }
    return (T) this;
  }

  /**
   * Checks if a validator is associated with this object.
   *
   * @param validator The validator to be checked.
   * @return {@code true} if the validator is associated; {@code false} otherwise.
   */
  @Editor.Ignore
  default boolean hasValidator(Validator<T> validator) {
    return getValidators().contains(validator);
  }

  /**
   * Marks the object as invalid with the specified error message.
   *
   * @param errorMessage The error message to be set.
   * @return This object after marking it as invalid.
   */
  @Editor.Ignore
  T invalidate(String errorMessage);

  /**
   * Marks the object as invalid with the specified list of error messages.
   *
   * @param errorMessages The list of error messages to be set.
   * @return This object after marking it as invalid.
   */
  @Editor.Ignore
  T invalidate(List<String> errorMessages);

  /**
   * Gets the list of validation errors associated with this object.
   *
   * @return The list of validation errors.
   */
  @Editor.Ignore
  List<String> getErrors();

  /**
   * Clears any previous validation errors on this object.
   *
   * @return This object after clearing validation errors.
   */
  @Editor.Ignore
  T clearInvalid();

  /**
   * Pauses all validation on this object.
   *
   * @return This object after pausing validation.
   */
  T pauseValidations();

  /**
   * Resumes validation on this object after pausing.
   *
   * @return This object after resuming validation.
   */
  T resumeValidations();

  /**
   * Toggles the pause state of validation on this object.
   *
   * @param toggle {@code true} to pause validation, {@code false} to resume.
   * @return This object after toggling the pause state of validation.
   */
  T togglePauseValidations(boolean toggle);

  /**
   * Checks if validation is currently paused on this object.
   *
   * @return {@code true} if validation is paused; {@code false} otherwise.
   */
  boolean isValidationsPaused();

  /**
   * Pauses focus-related validations on this object.
   *
   * @return This object after pausing focus-related validations.
   */
  T pauseFocusValidations();

  /**
   * Resumes focus-related validations on this object after pausing.
   *
   * @return This object after resuming focus-related validations.
   */
  T resumeFocusValidations();

  /**
   * Toggles the pause state of focus-related validations on this object.
   *
   * @param toggle {@code true} to pause focus-related validations, {@code false} to resume.
   * @return This object after toggling the pause state of focus-related validations.
   */
  T togglePauseFocusValidations(boolean toggle);

  /**
   * Checks if focus-related validations are currently paused on this object.
   *
   * @return {@code true} if focus-related validations are paused; {@code false} otherwise.
   */
  boolean isFocusValidationsPaused();

  /**
   * Executes a specified action with the option to pause validations before and resume after the
   * action.
   *
   * @param toggle {@code true} to pause validations, {@code false} to resume.
   * @param handler The handler to execute the action.
   * @return This object after executing the action.
   */
  default T withPauseValidationsToggle(boolean toggle, Handler<T> handler) {
    boolean oldState = isValidationsPaused();
    togglePauseValidations(toggle);
    try {
      handler.apply((T) this);
    } finally {
      this.togglePauseValidations(oldState);
    }
    return (T) this;
  }

  /**
   * Executes a specified action asynchronously with the option to pause validations before and
   * resume after the action.
   *
   * @param toggle {@code true} to pause validations, {@code false} to resume.
   * @param handler The asynchronous handler to execute the action.
   * @return This object after executing the action.
   */
  default T withPauseValidationsToggleAsync(boolean toggle, AsyncHandler<T> handler) {
    boolean oldState = isValidationsPaused();
    togglePauseValidations(toggle);
    try {
      handler.apply((T) this, () -> togglePauseValidations(oldState));
    } catch (Exception e) {
      togglePauseValidations(oldState);
      throw e;
    }
    return (T) this;
  }

  /**
   * Executes a specified action with the option to pause focus-related validations before and
   * resume after the action.
   *
   * @param toggle {@code true} to pause focus-related validations, {@code false} to resume.
   * @param handler The handler to execute the action.
   * @return This object after executing the action.
   */
  default T withPauseFocusValidationsToggle(boolean toggle, Handler<T> handler) {
    boolean oldState = isFocusValidationsPaused();
    togglePauseFocusValidations(toggle);
    try {
      handler.apply((T) this);
    } finally {
      this.togglePauseFocusValidations(oldState);
    }
    return (T) this;
  }

  /**
   * Executes a specified action asynchronously with the option to pause focus-related validations
   * before and resume after the action.
   *
   * @param toggle {@code true} to pause focus-related validations, {@code false} to resume.
   * @param handler The asynchronous handler to execute the action.
   * @return This object after executing the action.
   */
  default T withPauseFocusValidationsToggleAsync(boolean toggle, AsyncHandler<T> handler) {
    boolean oldState = isFocusValidationsPaused();
    togglePauseFocusValidations(toggle);
    try {
      handler.apply((T) this, () -> togglePauseFocusValidations(oldState));
    } catch (Exception e) {
      togglePauseFocusValidations(oldState);
      throw e;
    }
    return (T) this;
  }

  /**
   * The {@code Validator} interface defines a method for performing validation on a component and
   * returning a validation result.
   *
   * @param <T> The type of the component to be validated.
   */
  @FunctionalInterface
  interface Validator<T> {

    /**
     * Validates the component and returns the validation result.
     *
     * @param component The component to be validated.
     * @return The validation result.
     */
    ValidationResult isValid(T component);
  }
}
