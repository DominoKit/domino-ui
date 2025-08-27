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

import org.dominokit.domino.ui.style.CssClass;

public interface StepperStyles {

  CssClass dui_stepper = () -> "dui-stepper";
  CssClass dui_stepper_track = () -> "dui-stepper-track";
  CssClass dui_step_track = () -> "dui-step-track";
  CssClass dui_stepper_content = () -> "dui-stepper-content";
  CssClass dui_stepper_step = () -> "dui-stepper-step";

  CssClass dui_step_header = () -> "dui-step-header";
  CssClass dui_step_content = () -> "dui-step-content";
  CssClass dui_step_footer = () -> "dui-step-footer";
  CssClass dui_tracker_node = () -> "dui-tracker-node";
  CssClass dui_tracker_node_icon = () -> "dui-tracker-node-icon";
  CssClass dui_tracker_line = () -> "dui-tracker-line";
  CssClass dui_tracker_chain = () -> "dui-tracker-chain";
  CssClass dui_tracker_content = () -> "dui-tracker-content";
  CssClass dui_stepper_active_content = () -> "dui-stepper-active-content";
  CssClass dui_step_prefix = () -> "dui-step-prefix";
  CssClass dui_step_last = () -> "dui-step-last";
  CssClass dui_hide_stepper_tail = () -> "dui-stepper-hide-tail";
}
