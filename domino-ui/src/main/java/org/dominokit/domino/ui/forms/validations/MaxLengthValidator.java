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

import org.dominokit.domino.ui.forms.HasInputElement;
import org.dominokit.domino.ui.i18n.FormsLabels;
import org.dominokit.domino.ui.utils.DominoUIConfig;
import org.dominokit.domino.ui.utils.HasMinMaxLength;
import org.dominokit.domino.ui.utils.HasValidation;

/** A predefined validator that validate the minimum value of a field */
public class MaxLengthValidator<T> implements HasValidation.Validator {

  private HasInputElement<T> inputElement;
  private final FormsLabels labels = DominoUIConfig.CONFIG.getDominoUILabels();

  /** @param inputElement the {@link HasInputElement} we are attaching this validator to */
  public MaxLengthValidator(HasInputElement<T> inputElement) {
    this.inputElement = inputElement;
  }

  /** {@inheritDoc} */
  @Override
  public ValidationResult isValid() {
    if (inputElement.getInputElement().element()
        .validity
        .tooLong ) {
      if(inputElement instanceof HasMinMaxLength) {
        HasMinMaxLength<T> hasLength = (HasMinMaxLength<T>) inputElement;
        return ValidationResult.invalid(labels.getMaxErrorMessage(hasLength.getMaxLength(), hasLength.getLength()));
      }
    }
    return ValidationResult.valid();
  }
}
