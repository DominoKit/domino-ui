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
 * Component that can be validated should implement this interface
 *
 * @param <T> the type of the component implementing this interface
 */
public interface HasValidation<T> extends HasAutoValidation<T> {

  /**
   * validate the component and fail-fast with first error
   *
   * @return same implementing component
   * @param target a T object
   */
  @Editor.Ignore
  ValidationResult validate(T target);

  /**
   * getValidators.
   *
   * @return a {@link java.util.Set} object
   */
  Set<Validator<T>> getValidators();

  /**
   * Run all the validators and return all errors
   *
   * @return All {@link org.dominokit.domino.ui.forms.validations.ValidationResult}s, default to a
   *     single validation result
   * @param target a T object
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
   * addValidator.
   *
   * @param validator {@link org.dominokit.domino.ui.utils.HasValidation.Validator}
   * @return same implementing component
   */
  @Editor.Ignore
  default T addValidator(Validator<T> validator) {
    getValidators().add(validator);
    return (T) this;
  }

  /**
   * removeValidator.
   *
   * @param validator {@link org.dominokit.domino.ui.utils.HasValidation.Validator}
   * @return same implementing component
   */
  @Editor.Ignore
  default T removeValidator(Validator<T> validator) {
    getValidators().remove(validator);
    return (T) this;
  }

  /**
   * addOrRemoveValidator.
   *
   * @param validator a {@link org.dominokit.domino.ui.utils.HasValidation.Validator} object
   * @param state a boolean
   * @return a T object
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
   * hasValidator.
   *
   * @param validator {@link org.dominokit.domino.ui.utils.HasValidation.Validator}
   * @return same implementing component
   */
  @Editor.Ignore
  default boolean hasValidator(Validator<T> validator) {
    return getValidators().contains(validator);
  }

  /**
   * Mark the component as invalid with the specified error message
   *
   * @param errorMessage String
   * @return same implementing component
   */
  @Editor.Ignore
  T invalidate(String errorMessage);

  /**
   * Mark the component as invalid with a list of error messages
   *
   * @param errorMessages {@link java.util.List} of String error messages
   * @return same implementing component
   */
  @Editor.Ignore
  T invalidate(List<String> errorMessages);

  /** @return a List of String error messages */
  /**
   * getErrors.
   *
   * @return a {@link java.util.List} object
   */
  @Editor.Ignore
  List<String> getErrors();

  /**
   * Removes all error messages and mark the component as valid
   *
   * @return same implementing component
   */
  @Editor.Ignore
  T clearInvalid();

  /**
   * Disable validations
   *
   * @return same component instance
   */
  T pauseValidations();

  /**
   * Enables validations
   *
   * @return same component instance
   */
  T resumeValidations();

  /**
   * Disable/Enable validations
   *
   * @param toggle boolean, true to pause the changvalidations, false to enable them
   * @return same component instance
   */
  T togglePauseValidations(boolean toggle);

  /**
   * isValidationsPaused.
   *
   * @return a boolean
   */
  boolean isValidationsPaused();

  /**
   * Disable validations
   *
   * @return same component instance
   */
  T pauseFocusValidations();

  /**
   * Enables validations
   *
   * @return same component instance
   */
  T resumeFocusValidations();

  /**
   * Disable/Enable validations
   *
   * @param toggle boolean, true to pause the changvalidations, false to enable them
   * @return same component instance
   */
  T togglePauseFocusValidations(boolean toggle);

  /**
   * isFocusValidationsPaused.
   *
   * @return a boolean
   */
  boolean isFocusValidationsPaused();

  /**
   * Execute a handler while toggling the validations state, revert the state back to its original
   * value after executing the handler
   *
   * @param toggle boolean, true to pause thevalidations, false to enable them
   * @return same component instance
   * @param handler a {@link org.dominokit.domino.ui.utils.Handler} object
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
   * Execute a handler while toggling the validations state, revert the state back to its original
   * value after the AsyncHandler.onComplete is called
   *
   * @param toggle boolean, true to pause the validations, false to enable them
   * @return same component instance
   * @param handler a {@link org.dominokit.domino.ui.utils.AsyncHandler} object
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
   * Execute a handler while toggling the validations state, revert the state back to its original
   * value after executing the handler
   *
   * @param toggle boolean, true to pause thevalidations, false to enable them
   * @return same component instance
   * @param handler a {@link org.dominokit.domino.ui.utils.Handler} object
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
   * Execute a handler while toggling the validations state, revert the state back to its original
   * value after the AsyncHandler.onComplete is called
   *
   * @param toggle boolean, true to pause the validations, false to enable them
   * @return same component instance
   * @param handler a {@link org.dominokit.domino.ui.utils.AsyncHandler} object
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

  /** An interface to implement validators */
  @FunctionalInterface
  interface Validator<T> {
    /** @return a {@link ValidationResult} */
    ValidationResult isValid(T component);
  }
}
