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
 * Represents the result of a validation operation, indicating whether the validation was successful
 * or not and, if not, providing an error message.
 */
public class ValidationResult {

  /** The error message associated with the validation result. */
  private String errorMessage;

  /** A boolean value indicating whether the validation was successful (true) or not (false). */
  private boolean valid;

  /**
   * Constructs a new {@code ValidationResult} with the specified validity status and an empty error
   * message.
   *
   * @param valid A boolean value indicating whether the validation was successful (true) or not
   *     (false).
   */
  public ValidationResult(boolean valid) {
    this(valid, "");
  }

  /**
   * Constructs a new {@code ValidationResult} with the specified validity status and error message.
   *
   * @param valid A boolean value indicating whether the validation was successful (true) or not
   *     (false).
   * @param errorMessage The error message associated with the validation result.
   */
  public ValidationResult(boolean valid, String errorMessage) {
    this.valid = valid;
    this.errorMessage = errorMessage;
  }

  /**
   * Creates a valid validation result with an empty error message.
   *
   * @return A valid validation result.
   */
  public static ValidationResult valid() {
    return new ValidationResult(true);
  }

  /**
   * Creates an invalid validation result with the specified error message.
   *
   * @param errorMessage The error message associated with the validation result.
   * @return An invalid validation result with the provided error message.
   */
  public static ValidationResult invalid(String errorMessage) {
    return new ValidationResult(false, errorMessage);
  }

  /**
   * Gets the error message associated with this validation result.
   *
   * @return The error message.
   */
  public String getErrorMessage() {
    return errorMessage;
  }

  /**
   * Checks whether the validation result indicates success (valid) or failure (invalid).
   *
   * @return {@code true} if the validation was successful, {@code false} otherwise.
   */
  public boolean isValid() {
    return valid;
  }
}
