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

import static org.dominokit.domino.ui.style.GenericCss.dui_success;

import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.style.ColorsCss;
import org.dominokit.domino.ui.style.SpacingCss;

/** CompletedStep class. */
public class CompletedStep implements StepState {
  /** {@inheritDoc} */
  @Override
  public void apply(StepTracker tracker) {
    tracker
        .addCss(ColorsCss.dui_accent_success)
        .withTrackerNode(
            (parent1, node) ->
                node.appendChild(
                        Icons.check().addCss(SpacingCss.dui_font_size_4, dui_tracker_node_icon))
                    .addCss(dui_success));
  }

  /** {@inheritDoc} */
  @Override
  public void cleanUp(StepTracker tracker) {
    tracker
        .removeCss(ColorsCss.dui_accent_success)
        .withTrackerNode((parent1, node) -> node.clearElement().removeCss(dui_success));
  }

  /** {@inheritDoc} */
  @Override
  public String getKey() {
    return "COMPLETED";
  }
}
