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
package org.dominokit.domino.ui.config;

/** ProgressBarConfig interface. */
public interface ProgressBarConfig extends ComponentConfig {

  /**
   * getDefaultProgressExpression.
   *
   * @return a {@link java.lang.String} object
   */
  default String getDefaultProgressExpression() {
    return "{percent}%";
  }

  /**
   * evaluateProgressBarExpression.
   *
   * @param expression a {@link java.lang.String} object
   * @param percent a int
   * @param value a double
   * @param maxValue a double
   * @return a {@link java.lang.String} object
   */
  default String evaluateProgressBarExpression(
      String expression, int percent, double value, double maxValue) {
    return expression
        .replace("{percent}", percent + "")
        .replace("{value}", value + "")
        .replace("{maxValue}", maxValue + "");
  }
}
