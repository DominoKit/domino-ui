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

public interface TimePickerStyles {
  CssClass dui_time_picker = () -> "dui-time-picker";
  CssClass dui_timepicker_body = () -> "dui-timepicker-body";
  CssClass dui_timepicker_footer = () -> "dui-timepicker-footer";
  CssClass dui_timepicker_selectors = () -> "dui-timepicker-selectors";
  CssClass dui_timepicker_unit_selector = () -> "dui-timepicker-unit-selector";
  CssClass dui_time_header = () -> "dui-time-header";
  CssClass dui_time_header_text = () -> "dui-time-header-text";
}
