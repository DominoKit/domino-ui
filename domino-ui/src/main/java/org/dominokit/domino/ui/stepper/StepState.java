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

/**
 * Represents the state of a step within a stepper component. Implementations of this interface
 * define the behavior and appearance of steps in different states.
 */
public interface StepState extends StepperStyles {

  /** A predefined step state representing an active step. */
  StepState ACTIVE = new ActiveStep();

  /** A predefined step state representing an inactive step. */
  StepState INACTIVE = new InactiveStep();

  /** A predefined step state representing a completed step. */
  StepState COMPLETED = new CompletedStep();

  /** A predefined step state representing a disabled step. */
  StepState DISABLED = new DisabledStep();

  /** A predefined step state representing a step with an error. */
  StepState ERROR = new ErrorStep();

  /** A predefined step state representing a step with a warning. */
  StepState WARNING = new WarningStep();

  /** A predefined step state representing a skipped step. */
  StepState SKIPPED = new SkippedStep();

  /**
   * Applies the behavior and appearance of this step state to the specified step tracker.
   *
   * @param tracker The step tracker to apply the state to.
   */
  void apply(StepTracker tracker);

  /**
   * Cleans up any changes made by this step state on the specified step tracker.
   *
   * @param tracker The step tracker to clean up.
   */
  void cleanUp(StepTracker tracker);

  /**
   * Retrieves a key associated with this step state, which can be used for identification or
   * comparison purposes.
   *
   * @return The key associated with this step state.
   */
  String getKey();
}
