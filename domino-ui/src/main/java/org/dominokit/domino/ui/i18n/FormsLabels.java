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
package org.dominokit.domino.ui.i18n;

/**
 * The {@code FormsLabels} interface provides labels and messages related to form validation and
 * input fields. It extends the {@link Labels} interface, which provides common labels.
 */
public interface FormsLabels extends Labels {

  /**
   * Gets the error message to display when a required field is not filled.
   *
   * @return The error message for a required field.
   */
  default String requiredErrorMessage() {
    return "* This field is required.";
  }

  /**
   * Gets the error message to display when the input length is less than the specified minimum
   * length.
   *
   * @param minLength The minimum allowed length.
   * @param length The current length of the input.
   * @return The error message for input length less than the minimum.
   */
  default String getMinErrorMessage(int minLength, int length) {
    return "Minimum length is " + minLength + " , current length is : " + length;
  }

  /**
   * Gets the error message to display when the input length is greater than the specified maximum
   * length.
   *
   * @param maxLength The maximum allowed length.
   * @param length The current length of the input.
   * @return The error message for input length greater than the maximum.
   */
  default String getMaxErrorMessage(int maxLength, int length) {
    return "Maximum length is " + maxLength + " , current length is : " + length;
  }
}
