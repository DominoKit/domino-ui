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

import static org.dominokit.domino.ui.stepper.StepStateCss.dui_step_state_error;

import org.dominokit.domino.ui.icons.lib.Icons;

/**
 * A concrete implementation of the {@link StepState} interface representing an error state in a
 * stepper component. Error steps are typically used to indicate steps that have encountered an
 * error or validation issue.
 */
public class ErrorStep implements StepState {

  /**
   * {@inheritDoc} This implementation applies visual styling and an error icon to the provided
   * {@link StepTracker} to indicate that the step has encountered an error.
   *
   * @param tracker The {@link StepTracker} to which the error step state is applied.
   */
  @Override
  public void apply(StepTracker tracker) {
    tracker
        .addCss(dui_step_state_error)
        .withTrackerNode(
            (parent1, node) ->
                node.appendChild(Icons.window_close().addCss(dui_tracker_node_icon)));
  }

  /**
   * {@inheritDoc} This implementation cleans up the visual styling and icon from the provided
   * {@link StepTracker} when the step is no longer in an error state.
   *
   * @param tracker The {@link StepTracker} from which the error step state is removed.
   */
  @Override
  public void cleanUp(StepTracker tracker) {
    tracker.removeCss(dui_step_state_error).withTrackerNode((parent1, node) -> node.clearElement());
  }

  /**
   * {@inheritDoc} Returns the key associated with the error step state, which is typically "ERROR."
   *
   * @return The key "ERROR."
   */
  @Override
  public String getKey() {
    return "ERROR";
  }
}
