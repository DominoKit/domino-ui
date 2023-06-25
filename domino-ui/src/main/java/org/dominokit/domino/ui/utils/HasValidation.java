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

import java.util.Collections;
import java.util.List;
import org.dominokit.domino.ui.forms.validations.ValidationResult;
import org.gwtproject.editor.client.Editor;

/**
 * Component that can be validated should implement this interface
 *
 * @param <T> the type of the component implementing this interface
 */
public interface HasValidation<T> {

  /**
   * validate the component and fail-fast with first error
   *
   * @return same implementing component
   */
  @Editor.Ignore
  default ValidationResult validate() {
    return validate(false);
  }
  /**
   * validate the component and fail-fast with first error
   *
   * @return same implementing component
   */
  @Editor.Ignore
  ValidationResult validate(boolean silent);

  /**
   * Run all the validators and return all errors
   *
   * @return All {@link ValidationResult}s, default to a single validation result
   */
  @Editor.Ignore
  default List<ValidationResult> validateAll() {
    return Collections.singletonList(validate());
  }

  /**
   * @param validator {@link Validator}
   * @return same implementing component
   */
  @Editor.Ignore
  T addValidator(Validator validator);

  /**
   * @param validator {@link Validator}
   * @return same implementing component
   */
  @Editor.Ignore
  T removeValidator(Validator validator);

  /**
   * @param validator {@link Validator}
   * @return same implementing component
   */
  @Editor.Ignore
  boolean hasValidator(Validator validator);

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
   * @param errorMessages {@link List} of String error messages
   * @return same implementing component
   */
  @Editor.Ignore
  T invalidate(List<String> errorMessages);

  /** @return a List of String error messages */
  @Editor.Ignore
  List<String> getErrors();

  /**
   * Removes all error messages and mark the component as valid
   *
   * @return same implementing component
   */
  @Editor.Ignore
  T clearInvalid();

  /** An interface to implement validators */
  @FunctionalInterface
  interface Validator {
    /** @return a {@link ValidationResult} */
    ValidationResult isValid();
  }
}
