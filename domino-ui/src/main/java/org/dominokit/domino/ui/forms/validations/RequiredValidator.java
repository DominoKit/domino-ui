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
package org.dominokit.domino.ui.forms.validations;

import org.dominokit.domino.ui.forms.FormElement;
import org.dominokit.domino.ui.utils.HasValidation;

/**
 * A validator for checking if a form element is required and not empty.
 *
 * @param <T> The type of the input value.
 */
public class RequiredValidator<T> implements HasValidation.Validator<T> {

  /** The form element to be validated. */
  private FormElement element;

  /**
   * Creates a new {@code RequiredValidator} with the provided form element.
   *
   * @param element The form element to be validated.
   */
  public RequiredValidator(FormElement element) {
    this.element = element;
  }

  /**
   * Validates the form element to ensure it is not empty if it is marked as required.
   *
   * @param target The input value to be validated (not used in this validator).
   * @return A {@code ValidationResult} indicating whether the form element is valid or not.
   */
  @Override
  public ValidationResult isValid(T target) {
    if (element.isEmpty()) {
      return ValidationResult.invalid(element.getRequiredErrorMessage());
    }
    return ValidationResult.valid();
  }
}
