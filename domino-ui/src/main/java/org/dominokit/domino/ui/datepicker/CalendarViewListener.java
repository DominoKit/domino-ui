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

package org.dominokit.domino.ui.datepicker;

import java.util.Date;
import org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo;

/**
 * Represents a listener for the calendar view. The listener is notified about various events
 * related to the calendar view such as date selection change, calendar view updates, and changes in
 * date-time format info.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>
 * CalendarViewListener listener = new CalendarViewListener() {
 *     &#64;Override
 *     public void onDateSelectionChanged(Date date) {
 *         System.out.println("Selected date changed: " + date);
 *     }
 * };
 * </pre>
 */
public interface CalendarViewListener {

  /**
   * Called whenever the calendar view is updated.
   *
   * @param date The current date being viewed/selected in the calendar.
   */
  default void onUpdateCalendarView(Date date) {}

  /**
   * Called whenever the date selection in the calendar changes.
   *
   * @param date The newly selected date.
   */
  default void onDateSelectionChanged(Date date) {}

  /**
   * Called whenever the date-time format information changes.
   *
   * @param dateTimeFormatInfo The new date-time format information.
   */
  default void onDateTimeFormatInfoChanged(DateTimeFormatInfo dateTimeFormatInfo) {}
}
