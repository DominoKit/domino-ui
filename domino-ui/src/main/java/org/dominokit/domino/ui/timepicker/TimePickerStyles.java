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
package org.dominokit.domino.ui.timepicker;

import org.dominokit.domino.ui.style.CssClass;

/** Constants class for time picker components css classes names */
public interface TimePickerStyles {
  CssClass dui_picker_width = ()-> "270px";
  CssClass dui_time_picker = ()-> "time-picker";
  CssClass dui_time_panel = ()-> "time-panel";
  CssClass dui_hour_text = ()-> "hour-text";
  CssClass dui_minute_text = ()-> "minute-text";
  CssClass dui_second_text = ()-> "second-text";
  CssClass dui_am_pm_container = ()-> "am-pm-container";
  CssClass dui_am_pm_text = ()-> "am-pm-text";
  CssClass dui_am_pm_top = ()-> "am-pm-top";
  CssClass dui_am_pm_bottom = ()-> "am-pm-bottom";
  CssClass dui_time_display_large = ()-> "time-display-large";
  CssClass du_time_footer = ()-> "time-footer";
  CssClass dui_clear_button = ()-> "clear-button";
  CssClass dui_now_button = ()-> "now-button";
  CssClass dui_close_button = ()-> "close-button";
  CssClass dui_navigate = ()-> "navigate";
  CssClass dui_navigate_left = ()-> "navigate-left";
  CssClass dui_navigate_right = ()-> "navigate-right";
  CssClass dui_picker_content = ()-> "picker-content";
  CssClass dui_clock_picker = ()-> "clock-picker";
  CssClass dui_hour = ()-> "hour";
  CssClass dui_small_hour = ()-> "small-hour";

  // ==============================
  CssClass dui_time_picker_center_circle = ()-> "dui-time-picker-center-circle";
  CssClass dui_time_picker_svg_root = ()-> "dui-time-picker-svg-root";
}
