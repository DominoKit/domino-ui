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

/**
 * Implementations of this interface can be used to configure defaults for {@link
 * org.dominokit.domino.ui.progress.ProgressBar} component
 */
public interface ProgressBarConfig extends ComponentConfig {

  /**
   * Use this method to define the default progress expression.
   *
   * <p>Defaults to : {@code {percent}%}
   *
   * <p>Can use the following variables in the expression <b>{percent}</b>, <b>{value}</b>,
   * <b>{maxValue}</b>
   *
   * @return Expression text.
   */
  default String getDefaultProgressExpression() {
    return "{percent}%";
  }

  /**
   * Use this method to define the default implementation to evaluate the progress expression with
   * the provided progress values.
   *
   * @param expression The text expression from {@code getDefaultProgressExpression()}
   * @param percent integer percent of the current progress state.
   * @param value double value of the current progress state.
   * @param maxValue the double maximum value the progress can reach.
   * @return an evaluated progress text representing the progress status.
   */
  default String evaluateProgressBarExpression(
      String expression, int percent, double value, double maxValue) {
    return expression
        .replace("{percent}", percent + "")
        .replace("{value}", value + "")
        .replace("{maxValue}", maxValue + "");
  }
}
