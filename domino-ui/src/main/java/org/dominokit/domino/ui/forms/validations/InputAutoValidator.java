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

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.forms.AutoValidator;
import org.dominokit.domino.ui.utils.ApplyFunction;
import org.dominokit.domino.ui.utils.DominoElement;

/**
 * An auto validator for input elements, which triggers validation on the "blur" event.
 *
 * @param <E> The type of the HTML element associated with the input.
 */
public class InputAutoValidator<E extends HTMLElement> extends AutoValidator {

  /** The input element to validate. */
  private final DominoElement<E> inputElement;

  /** The event listener for the "blur" event that triggers validation. */
  private final EventListener eventListener;

  /**
   * Creates a new {@code InputAutoValidator} with the provided auto validation function and input
   * element.
   *
   * @param autoValidate The function to perform auto validation.
   * @param inputElement The input element to validate.
   */
  public InputAutoValidator(ApplyFunction autoValidate, DominoElement<E> inputElement) {
    super(autoValidate);
    this.inputElement = inputElement;
    eventListener = evt -> autoValidate.apply();
  }

  /** Attaches the auto validator by adding the "blur" event listener to the input element. */
  @Override
  public void attach() {
    inputElement.addEventListener("blur", eventListener);
  }

  /** Removes the auto validator by removing the "blur" event listener from the input element. */
  @Override
  public void remove() {
    inputElement.removeEventListener("blur", eventListener);
  }
}
