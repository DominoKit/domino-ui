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

import java.util.Date;
import org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo;

/** A listener interface for events related to the TimePicker view. */
public interface TimePickerViewListener {

  /**
   * Called when the TimePicker view is updated with a new date.
   *
   * @param date The updated date.
   */
  default void onUpdatePickerView(Date date) {}

  /**
   * Called when the time selection is changed in the TimePicker view.
   *
   * @param date The selected date.
   */
  default void onTimeSelectionChanged(Date date) {}

  /**
   * Called when the DateTimeFormatInfo in the TimePicker view is changed.
   *
   * @param dateTimeFormatInfo The new DateTimeFormatInfo.
   */
  default void onDateTimeFormatInfoChanged(DateTimeFormatInfo dateTimeFormatInfo) {}
}
