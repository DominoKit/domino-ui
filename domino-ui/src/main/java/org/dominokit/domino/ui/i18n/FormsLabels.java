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

/** FormsLabels interface. */
public interface FormsLabels extends Labels {

  /**
   * requiredErrorMessage.
   *
   * @return a {@link java.lang.String} object
   */
  default String requiredErrorMessage() {
    return "* This field is required.";
  }

  /**
   * getMinErrorMessage.
   *
   * @param minLength a int
   * @param length a int
   * @return a {@link java.lang.String} object
   */
  default String getMinErrorMessage(int minLength, int length) {
    return "Minimum length is " + minLength + " , current length is : " + length;
  }

  /**
   * getMaxErrorMessage.
   *
   * @param maxLength a int
   * @param length a int
   * @return a {@link java.lang.String} object
   */
  default String getMaxErrorMessage(int maxLength, int length) {
    return "Maximum length is " + maxLength + " , current length is : " + length;
  }
}
