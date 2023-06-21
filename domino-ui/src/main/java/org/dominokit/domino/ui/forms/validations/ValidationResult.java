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

/**
 * This class represent the result of a single validation logic
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class ValidationResult {

  private String errorMessage;
  private boolean valid;

  /**
   * Creates an instance of a validation result that indicate a <b>valid/invalid</b> state without
   * an error message
   *
   * @param valid boolean, if true the state is valid otherwise invalid
   */
  public ValidationResult(boolean valid) {
    this(valid, "");
  }

  /**
   * Creates an instance of a validation result that indicate a <b>valid/invalid</b> state with an
   * error message
   *
   * @param valid boolean, if true the state is valid otherwise invalid
   * @param errorMessage String error message
   */
  public ValidationResult(boolean valid, String errorMessage) {
    this.valid = valid;
    this.errorMessage = errorMessage;
  }

  /**
   * Creates an instance of a validation result that indicate a <b>valid</b> state
   *
   * @return a {@link org.dominokit.domino.ui.forms.validations.ValidationResult} object
   */
  public static ValidationResult valid() {
    return new ValidationResult(true);
  }

  /**
   * Creates an instance of a validation result that indicate an <b>invalid</b> state with an error
   * message
   *
   * @param errorMessage String error message
   * @return a {@link org.dominokit.domino.ui.forms.validations.ValidationResult} object
   */
  public static ValidationResult invalid(String errorMessage) {
    return new ValidationResult(false, errorMessage);
  }

  /** @return String error message, empty String for valid results */
  /**
   * Getter for the field <code>errorMessage</code>.
   *
   * @return a {@link java.lang.String} object
   */
  public String getErrorMessage() {
    return errorMessage;
  }

  /** @return boolean, true if there was no errors false if there was errors. */
  /**
   * isValid.
   *
   * @return a boolean
   */
  public boolean isValid() {
    return valid;
  }
}
