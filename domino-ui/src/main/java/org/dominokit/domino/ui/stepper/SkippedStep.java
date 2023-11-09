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

import static org.dominokit.domino.ui.style.GenericCss.dui_info;

import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.style.ColorsCss;
import org.dominokit.domino.ui.style.SpacingCss;

/**
 * Represents a "Skipped" step in a stepper component. Skipped steps indicate that they have been
 * skipped in the progression of the stepper. This step state applies visual changes to the
 * StepTracker when it is in the "Skipped" state. It displays a specific icon and styling to
 * indicate that the step has been skipped.
 */
public class SkippedStep implements StepState {

  /**
   * Applies visual changes to the StepTracker when it is in the "Skipped" state.
   *
   * @param tracker The StepTracker to which the "Skipped" step state is applied.
   */
  @Override
  public void apply(StepTracker tracker) {
    tracker
        .addCss(ColorsCss.dui_accent_info)
        .withTrackerNode(
            (parent1, node) ->
                node.appendChild(
                        Icons.share().addCss(SpacingCss.dui_font_size_4, dui_tracker_node_icon))
                    .addCss(dui_info));
  }

  /**
   * Cleans up any applied visual changes when the step is no longer in the "Skipped" state.
   *
   * @param tracker The StepTracker from which the "Skipped" step state is removed.
   */
  @Override
  public void cleanUp(StepTracker tracker) {
    tracker
        .removeCss(ColorsCss.dui_accent_info)
        .withTrackerNode((parent1, node) -> node.clearElement().removeCss(dui_info));
  }

  /**
   * Gets the key associated with the "Skipped" step state, typically "SKIPPED."
   *
   * @return The key "SKIPPED."
   */
  @Override
  public String getKey() {
    return "SKIPPED";
  }
}
