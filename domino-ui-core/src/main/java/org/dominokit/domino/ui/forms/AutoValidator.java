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
package org.dominokit.domino.ui.forms;

import org.dominokit.domino.ui.utils.ApplyFunction;

/**
 * The base class for auto-validation functionality in form elements. AutoValidators are used to
 * automatically trigger validation when certain events occur in a form field.
 */
public abstract class AutoValidator {

  /** The function to be executed for auto-validation. */
  protected ApplyFunction autoValidate;

  /**
   * Constructs a new {@code AutoValidator} with the specified auto-validation function.
   *
   * @param autoValidate The function to be executed for auto-validation.
   */
  public AutoValidator(ApplyFunction autoValidate) {
    this.autoValidate = autoValidate;
  }

  /**
   * Attaches the auto-validation behavior to the form element. This method should be implemented by
   * subclasses to specify when and how auto-validation is triggered.
   */
  public void attach() {}

  /**
   * Removes the auto-validation behavior from the form element. This method should be implemented
   * by subclasses to remove any event listeners or resources associated with auto-validation.
   */
  public void remove() {}
}
