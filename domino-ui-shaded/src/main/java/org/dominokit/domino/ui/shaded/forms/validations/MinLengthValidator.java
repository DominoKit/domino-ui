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
package org.dominokit.domino.ui.shaded.forms.validations;

import elemental2.dom.HTMLInputElement;
import jsinterop.base.Js;
import org.dominokit.domino.ui.shaded.forms.AbstractValueBox;
import org.dominokit.domino.ui.shaded.utils.HasValidation;

/** A predefined validator that validate the minimum value of a field */
@Deprecated
public class MinLengthValidator implements HasValidation.Validator {

  private AbstractValueBox valueBox;

  /** @param valueBox the {@link AbstractValueBox} we are attaching this validator to */
  public MinLengthValidator(AbstractValueBox valueBox) {
    this.valueBox = valueBox;
  }

  /** {@inheritDoc} */
  @Override
  public ValidationResult isValid() {
    if (Js.<HTMLInputElement>uncheckedCast(valueBox.getInputElement().element())
        .validity
        .tooShort) {
      return ValidationResult.invalid(valueBox.getMinLengthErrorMessage());
    }
    return ValidationResult.valid();
  }
}
