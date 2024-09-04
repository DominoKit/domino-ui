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

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.util.LinkedHashSet;
import java.util.Set;
import org.dominokit.domino.ui.forms.FormElement;
import org.dominokit.domino.ui.utils.HasValidation.Validator;

/**
 * This class associate a list of {@link Validator} with a {@link FormElement} and allow running all
 * of the validators and return the result in fail-fast style.
 */
@Deprecated
public class ElementValidations {

  private FormElement element;
  private Set<Validator> validators = new LinkedHashSet<>();

  /** @param element The {@link FormElement} to be validated */
  public ElementValidations(FormElement element) {
    this.element = element;
  }

  /**
   * Runs all the validated over the FormElement if it is enabled and fail-fast
   *
   * @return the {@link ValidationResult}
   */
  public ValidationResult validate(boolean silent) {
    element.clearInvalid();
    if (!element.isEnabled()) {
      return ValidationResult.valid();
    }
    for (Validator validator : validators) {
      ValidationResult result = validator.isValid();
      if (!result.isValid()) {
        if (!silent) {
          element.invalidate(result.getErrorMessage());
        }
        return result;
      }
    }
    return ValidationResult.valid();
  }

  /** @param validator {@link Validator} */
  public void addValidator(Validator validator) {
    validators.add(validator);
  }

  /** @param validator {@link Validator} */
  public void removeValidator(Validator validator) {
    if (nonNull(validator)) validators.remove(validator);
  }

  /**
   * Checks if the current list of validators contains the specified validator
   *
   * @param validator {@link Validator}
   * @return boolean, true if the validator in the list otherwise false
   */
  public boolean hasValidator(Validator validator) {
    return !isNull(validator) && validators.contains(validator);
  }
}
