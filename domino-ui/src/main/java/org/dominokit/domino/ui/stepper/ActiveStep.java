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
 * A concrete implementation of the {@link StepState} interface representing an active step in a
 * stepper component. Active steps typically indicate the currently selected or in-progress step and
 * may have different behavior and appearance.
 */
public class ActiveStep implements StepState {

  /**
   * {@inheritDoc} This implementation does not make any specific changes to the provided {@link
   * StepTracker} for an active step.
   */
  @Override
  public void apply(StepTracker tracker) {}

  /**
   * {@inheritDoc} This implementation does not clean up any changes on the provided {@link
   * StepTracker} for an active step.
   */
  @Override
  public void cleanUp(StepTracker tracker) {}

  /**
   * {@inheritDoc} Returns the key associated with the active step state, which is typically
   * "ACTIVE."
   *
   * @return The key "ACTIVE."
   */
  @Override
  public String getKey() {
    return "ACTIVE";
  }
}
