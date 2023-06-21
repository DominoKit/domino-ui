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

/**
 * TimePickerStyles interface.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public interface TimePickerStyles {
  /** Constant <code>dui_time_picker</code> */
  CssClass dui_time_picker = () -> "dui-time-picker";
  /** Constant <code>dui_timepicker_body</code> */
  CssClass dui_timepicker_body = () -> "dui-timepicker-body";
  /** Constant <code>dui_timepicker_footer</code> */
  CssClass dui_timepicker_footer = () -> "dui-timepicker-footer";
  /** Constant <code>dui_timepicker_selectors</code> */
  CssClass dui_timepicker_selectors = () -> "dui-timepicker-selectors";
  /** Constant <code>dui_timepicker_unit_selector</code> */
  CssClass dui_timepicker_unit_selector = () -> "dui-timepicker-unit-selector";
  /** Constant <code>dui_time_header</code> */
  CssClass dui_time_header = () -> "dui-time-header";
  /** Constant <code>dui_time_header_text</code> */
  CssClass dui_time_header_text = () -> "dui-time-header-text";
}
