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

import elemental2.core.JsRegExp;
import elemental2.core.RegExpResult;

public class CssParser {

  /**
   * Extracts the numeric part from a CSS unit string (e.g., "26px" -> 26.0). Compatible with GWT /
   * Elemental2 (no use of String.replaceFirst).
   *
   * @param cssValue the CSS unit string
   * @return the numeric part as a double, or NaN if parsing fails
   */
  public static double parseCssNumber(String cssValue) {
    final int DEFAULT_LINE_HEIGHT = 26;
    if (cssValue == null || cssValue.isEmpty()) {
      return DEFAULT_LINE_HEIGHT;
    }

    // Use JavaScript-style RegExp via Elemental2
    JsRegExp regex = new JsRegExp("^[0-9]*\\.?[0-9]+");
    RegExpResult result = regex.exec(cssValue.trim());

    if (result != null && result.length > 0) {
      try {
        return Double.parseDouble(result.getAt(0));
      } catch (NumberFormatException e) {
        return DEFAULT_LINE_HEIGHT;
      }
    }

    return DEFAULT_LINE_HEIGHT;
  }
}
