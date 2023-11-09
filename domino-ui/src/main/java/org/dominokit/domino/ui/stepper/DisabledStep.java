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

import static org.dominokit.domino.ui.style.GenericCss.dui_grey;

import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.style.ColorsCss;
import org.dominokit.domino.ui.style.SpacingCss;

/**
 * A concrete implementation of the {@link StepState} interface representing a disabled step in a
 * stepper component. Disabled steps are typically used to indicate steps that cannot be interacted
 * with or completed.
 */
public class DisabledStep implements StepState {

  /**
   * {@inheritDoc} This implementation applies visual styling and an icon to the provided {@link
   * StepTracker} to indicate that the step is disabled.
   *
   * @param tracker The {@link StepTracker} to which the disabled step state is applied.
   */
  @Override
  public void apply(StepTracker tracker) {
    tracker
        .addCss(ColorsCss.dui_accent_grey)
        .withTrackerNode(
            (parent1, node) ->
                node.appendChild(
                        Icons.cancel().addCss(SpacingCss.dui_font_size_4, dui_tracker_node_icon))
                    .addCss(dui_grey));
  }

  /**
   * {@inheritDoc} This implementation cleans up the visual styling and icon from the provided
   * {@link StepTracker} when the step is no longer disabled.
   *
   * @param tracker The {@link StepTracker} from which the disabled step state is removed.
   */
  @Override
  public void cleanUp(StepTracker tracker) {
    tracker
        .removeCss(ColorsCss.dui_accent_grey)
        .withTrackerNode((parent1, node) -> node.clearElement().removeCss(dui_grey));
  }

  /**
   * {@inheritDoc} Returns the key associated with the disabled step state, which is typically
   * "DISABLED."
   *
   * @return The key "DISABLED."
   */
  @Override
  public String getKey() {
    return "DISABLED";
  }
}
