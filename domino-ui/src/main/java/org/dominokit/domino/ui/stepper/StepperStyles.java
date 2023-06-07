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

/** A constants class for Steppers css classes names */
public interface StepperStyles {

  CssClass dui_stepper = ()-> "dui-stepper";
  CssClass dui_stepper_track = ()-> "dui-stepper-track";
  CssClass dui_step_track = ()-> "dui-step-track";
  CssClass dui_stepper_content = ()-> "dui-stepper-content";
  CssClass dui_stepper_step = ()-> "dui-stepper-step";
  CssClass dui_step_header = ()-> "dui-step-header";
  CssClass dui_step_content = ()-> "dui-step-content";
  CssClass dui_step_footer = ()-> "dui-step-footer";
  CssClass dui_tracker_node = ()-> "dui-tracker-node";
  CssClass dui_tracker_node_icon = ()-> "dui-tracker-node-icon";
  CssClass dui_tracker_line = ()-> "dui-tracker-line";
  CssClass dui_tracker_chain = ()-> "dui-tracker-chain";
  CssClass dui_tracker_content = ()-> "dui-tracker-content";

  CssClass dui_stepper_active_content = ()-> "dui-stepper-active-content";
  CssClass dui_step_prefix = ()-> "dui-step-prefix";
  CssClass dui_step_last = ()-> "dui-step-last";
  String D_STEPPER = "d-stepper";
  String STEP_CONTENT = "step-content";
  String LAST_STEP = "last-step";
  String HORIZONTAL_STEPPER = "horizontal-stepper";
  String VERTICAL_STEPPER = "vertical-stepper";
  String STEP_ACTIVE = "step-active";
  String STEP_INACTIVE = "step-inactive";
  String STEP_ERROR = "step-error";
  String STEP_COMPLETED = "step-completed";
  String STEP_DISABLED = "step-disabled";
  String STEP_HEADER = "step-header";
  String STEP_NUMBER_CNTR = "step-number-cntr";
  String STEP_NUMBER = "step-number";
  String STEP_VERTICAL_BAR = "step-vertical-bar";
  String STEP_TITLE_CNTR = "step-title-cntr";
  String STEP_MAIN_TITLE_CNTR = "step-main-title-cntr";
  String STEP_TITLE = "step-title";
  String STEP_HORIZONTAL_BAR = "step-horizontal-bar";
  String STEP_DESCRIPTION = "step-description";
  String STEP_ERRORS = "step-errors";
  String STEP_INVALID = "step-invalid";
}
