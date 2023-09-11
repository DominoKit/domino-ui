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
package org.dominokit.domino.ui.stepper;

import java.util.Optional;
import org.dominokit.domino.ui.utils.ComponentMeta;
import org.dominokit.domino.ui.utils.HasMeta;

/** StepMeta class. */
public class StepMeta implements ComponentMeta {
  /** Constant <code>DUI_STEP_META="dui-step-meta"</code> */
  public static final String DUI_STEP_META = "dui-step-meta";

  private final Step step;

  /**
   * Constructor for StepMeta.
   *
   * @param step a {@link org.dominokit.domino.ui.stepper.Step} object
   */
  public StepMeta(Step step) {
    this.step = step;
  }

  /**
   * of.
   *
   * @param step a {@link org.dominokit.domino.ui.stepper.Step} object
   * @return a {@link org.dominokit.domino.ui.stepper.StepMeta} object
   */
  public static StepMeta of(Step step) {
    return new StepMeta(step);
  }

  /**
   * get.
   *
   * @param component a {@link org.dominokit.domino.ui.utils.HasMeta} object
   * @return a {@link java.util.Optional} object
   */
  public static Optional<StepMeta> get(HasMeta<?> component) {
    return component.getMeta(DUI_STEP_META);
  }

  /**
   * Getter for the field <code>step</code>.
   *
   * @return a {@link org.dominokit.domino.ui.stepper.Step} object
   */
  public Step getStep() {
    return step;
  }

  /** {@inheritDoc} */
  @Override
  public String getKey() {
    return DUI_STEP_META;
  }
}
