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

import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.forms.AutoValidator;
import org.dominokit.domino.ui.utils.ApplyFunction;
import org.dominokit.domino.ui.utils.DominoElement;

/**
 * this class attach an {@link org.dominokit.domino.ui.forms.FormElement#autoValidate()} } to a
 * component and bind the validation the {@link org.dominokit.domino.ui.events.EventType#blur}
 */
public class InputAutoValidator<E extends HTMLElement> extends AutoValidator {

  private final DominoElement<E> inputElement;
  private final EventListener eventListener;

  /**
   * Constructor for InputAutoValidator.
   *
   * @param autoValidate {@link org.dominokit.domino.ui.utils.ApplyFunction}
   * @param inputElement a {@link org.dominokit.domino.ui.utils.DominoElement} object
   */
  public InputAutoValidator(ApplyFunction autoValidate, DominoElement<E> inputElement) {
    super(autoValidate);
    this.inputElement = inputElement;
    eventListener = evt -> autoValidate.apply();
  }

  /** {@inheritDoc} */
  @Override
  public void attach() {
    inputElement.addEventListener("blur", eventListener);
  }

  /** {@inheritDoc} */
  @Override
  public void remove() {
    inputElement.removeEventListener("blur", eventListener);
  }
}
