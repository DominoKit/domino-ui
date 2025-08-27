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
 * Represents an inactive step in a stepper component. Inactive steps are used to indicate steps
 * that are not currently active or selected. This step state does not apply any visual changes or
 * clean-up actions to the StepTracker.
 */
public class InactiveStep implements StepState {

  /**
   * Does not apply any visual changes to the StepTracker when in an inactive state.
   *
   * @param tracker The StepTracker to which the inactive step state is applied.
   */
  @Override
  public void apply(StepTracker tracker) {}

  /**
   * Does not perform any clean-up actions when the step is no longer in an inactive state.
   *
   * @param tracker The StepTracker from which the inactive step state is removed.
   */
  @Override
  public void cleanUp(StepTracker tracker) {}

  /**
   * Gets the key associated with the inactive step state, typically "INACTIVE."
   *
   * @return The key "INACTIVE."
   */
  @Override
  public String getKey() {
    return "INACTIVE";
  }
}
