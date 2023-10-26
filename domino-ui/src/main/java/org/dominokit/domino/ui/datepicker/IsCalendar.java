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
import java.util.Set;
import org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo;

/**
 * Represents an interface for calendar components. This provides methods to get and set various
 * properties of the calendar, as well as bind or unbind listeners to calendar events.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>
 * IsCalendar myCalendar = ...; // Implementation of IsCalendar
 * Date currentDate = myCalendar.getDate();
 * myCalendar.bindCalenderViewListener(new CalendarViewListener() {
 *     &#64;Override
 *     public void onDateSelectionChanged(Date date) {
 *         System.out.println("Date changed to: " + date);
 *     }
 * });
 * </pre>
 */
public interface IsCalendar {

  /**
   * Retrieves the current selected date of the calendar.
   *
   * @return The currently selected date.
   */
  Date getDate();

  /**
   * Retrieves the date-time format information for the calendar.
   *
   * @return The date-time format information.
   */
  DateTimeFormatInfo getDateTimeFormatInfo();

  /**
   * Binds a calendar view listener to the calendar, allowing it to be notified of events like view
   * updates and date changes.
   *
   * @param listener The calendar view listener to bind.
   */
  void bindCalenderViewListener(CalendarViewListener listener);

  /**
   * Unbinds a previously bound calendar view listener, removing its association with the calendar.
   *
   * @param listener The calendar view listener to unbind.
   */
  void unbindCalenderViewListener(CalendarViewListener listener);

  /**
   * Retrieves all date selection listeners currently associated with the calendar. These listeners
   * are notified when a day is selected or deselected in the calendar.
   *
   * @return A set of all date selection listeners.
   */
  Set<DateSelectionListener> getDateSelectionListeners();

  /**
   * Retrieves the configuration object that holds initialization settings for the calendar.
   *
   * @return The calendar initialization configuration.
   */
  CalendarInitConfig getConfig();
}
