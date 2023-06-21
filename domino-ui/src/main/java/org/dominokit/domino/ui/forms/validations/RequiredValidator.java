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
 * A predefined validator that validates a required field as not empty
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class RequiredValidator<T> implements HasValidation.Validator<T> {

  private FormElement element;

  /** @param element the {@link FormElement} we are attaching this validator to */
  /**
   * Constructor for RequiredValidator.
   *
   * @param element a {@link org.dominokit.domino.ui.forms.FormElement} object
   */
  public RequiredValidator(FormElement element) {
    this.element = element;
  }

  /** {@inheritDoc} */
  @Override
  public ValidationResult isValid(T target) {
    if (element.isEmpty()) {
      return ValidationResult.invalid(element.getRequiredErrorMessage());
    }
    return ValidationResult.valid();
  }
}
