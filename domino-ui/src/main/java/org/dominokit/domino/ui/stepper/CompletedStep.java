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

import static org.dominokit.domino.ui.stepper.StepStateCss.dui_step_state_completed;

import org.dominokit.domino.ui.icons.lib.Icons;

/**
 * A concrete implementation of the {@link StepState} interface representing a completed step in a
 * stepper component. Completed steps are typically used to indicate steps that have been
 * successfully finished or validated.
 */
public class CompletedStep implements StepState {

  /**
   * {@inheritDoc} This implementation applies visual styling and an icon to the provided {@link
   * StepTracker} to indicate the completion of the step.
   *
   * @param tracker The {@link StepTracker} to which the completed step state is applied.
   */
  @Override
  public void apply(StepTracker tracker) {
    tracker
        .addCss(dui_step_state_completed)
        .withTrackerNode(
            (parent1, node) -> node.appendChild(Icons.check().addCss(dui_tracker_node_icon)));
  }

  /**
   * {@inheritDoc} This implementation cleans up the visual styling and icon from the provided
   * {@link StepTracker} when the step is no longer completed.
   *
   * @param tracker The {@link StepTracker} from which the completed step state is removed.
   */
  @Override
  public void cleanUp(StepTracker tracker) {
    tracker
        .removeCss(dui_step_state_completed)
        .withTrackerNode((parent1, node) -> node.clearElement());
  }

  /**
   * {@inheritDoc} Returns the key associated with the completed step state, which is typically
   * "COMPLETED."
   *
   * @return The key "COMPLETED."
   */
  @Override
  public String getKey() {
    return "COMPLETED";
  }
}
