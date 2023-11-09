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

/**
 * Represents the metadata associated with a {@link Step} component.
 *
 * <p>This metadata can be used to store and retrieve additional information or properties about a
 * step component.
 *
 * <p>Usage example:
 *
 * <pre>
 * Step step = new Step("Sample");
 * StepMeta meta = StepMeta.of(step);
 * </pre>
 */
public class StepMeta implements ComponentMeta {

  public static final String DUI_STEP_META = "dui-step-meta";

  private final Step step;

  /**
   * Creates a new StepMeta instance for a given step.
   *
   * @param step the step associated with this metadata
   */
  public StepMeta(Step step) {
    this.step = step;
  }

  /**
   * Factory method to create a new StepMeta instance for a given step.
   *
   * @param step the step for which metadata needs to be created
   * @return a new StepMeta instance
   */
  public static StepMeta of(Step step) {
    return new StepMeta(step);
  }

  /**
   * Retrieves the StepMeta associated with a given component if present.
   *
   * @param component the component to retrieve metadata for
   * @return an Optional containing the associated StepMeta, or empty if not present
   */
  public static Optional<StepMeta> get(HasMeta<?> component) {
    return component.getMeta(DUI_STEP_META);
  }

  /**
   * Retrieves the {@link Step} associated with this metadata.
   *
   * @return the associated step
   */
  public Step getStep() {
    return step;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Returns the key used to identify this specific step metadata.
   *
   * <p>This key is unique for the StepMeta class and is used to store and retrieve the metadata
   * associated with a {@link Step}.
   *
   * @return the unique key for the step metadata
   */
  @Override
  public String getKey() {
    return DUI_STEP_META;
  }
}
