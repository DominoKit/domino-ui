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

package org.dominokit.domino.ui.utils;

/**
 * The {@code TextUtil} class provides utility methods for working with text and strings. It
 * includes methods for manipulating text, such as capitalizing the first letter of a string.
 */
public class TextUtil {

  /**
   * Capitalizes the first letter of a given input string.
   *
   * @param input The input string to capitalize the first letter of.
   * @return A new string with the first letter capitalized.
   */
  public static String firstLetterToUpper(String input) {
    return input.substring(0, 1).toUpperCase() + input.substring(1);
  }
}
