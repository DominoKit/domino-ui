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

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.forms.HasInputElement;
import org.dominokit.domino.ui.i18n.FormsLabels;
import org.dominokit.domino.ui.utils.DominoUIConfig;
import org.dominokit.domino.ui.utils.HasMinMaxLength;
import org.dominokit.domino.ui.utils.HasValidation;

/**
 * A validator for checking the maximum length of input values in various HTML input elements.
 *
 * @param <T> The type of the input value.
 * @param <E> The type of the HTML element associated with the input.
 */
public class MaxLengthValidator<T, E extends HTMLElement> implements HasValidation.Validator<T> {

  /** The input element to be validated. */
  private HasInputElement<T, E> inputElement;

  /** The labels for form validation messages. */
  private final FormsLabels labels = DominoUIConfig.CONFIG.getDominoUILabels();

  /**
   * Creates a new {@code MaxLengthValidator} with the provided input element.
   *
   * @param inputElement The input element to be validated.
   */
  public MaxLengthValidator(HasInputElement<T, E> inputElement) {
    this.inputElement = inputElement;
  }

  /**
   * Validates the input value against the maximum length.
   *
   * @param input The input value to be validated.
   * @return A {@code ValidationResult} indicating whether the input value is valid or not.
   */
  @Override
  public ValidationResult isValid(T input) {
    if (inputElement.getInputElement().element() instanceof HTMLInputElement) {
      return validateHTMLInput();
    } else {
      return validateHTMLElement();
    }
  }

  /**
   * Validates the input value for HTML input elements.
   *
   * @return A {@code ValidationResult} indicating whether the input value is valid or not.
   */
  private ValidationResult validateHTMLInput() {
    if (((HTMLInputElement) this.inputElement.getInputElement().element()).validity.tooLong) {
      if (this.inputElement instanceof HasMinMaxLength) {
        HasMinMaxLength<T> hasLength = (HasMinMaxLength<T>) this.inputElement;
        return ValidationResult.invalid(
            labels.getMaxErrorMessage(hasLength.getMaxLength(), hasLength.getLength()));
      }
    }
    return ValidationResult.valid();
  }

  /**
   * Validates the input value for non-HTML input elements.
   *
   * @return A {@code ValidationResult} indicating whether the input value is valid or not.
   */
  private ValidationResult validateHTMLElement() {
    if (this.inputElement instanceof HasMinMaxLength) {
      HasMinMaxLength<T> hasLength = (HasMinMaxLength<T>) this.inputElement;
      int length = hasLength.getLength();
      if (length > hasLength.getMaxLength()) {
        return ValidationResult.invalid(
            labels.getMaxErrorMessage(hasLength.getMaxLength(), length));
      }
    }
    return ValidationResult.valid();
  }
}
