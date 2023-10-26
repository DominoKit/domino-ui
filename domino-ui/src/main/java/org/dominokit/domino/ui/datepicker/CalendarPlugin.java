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

/**
 * A plugin interface for customizing the behavior and appearance of a calendar.
 *
 * <p>Plugins can be added to a calendar to extend its functionality and respond to events.
 */
public interface CalendarPlugin {

  /**
   * Invoked when a calendar day is added to the calendar view.
   *
   * @param calendarDay The calendar day that was added
   */
  default void onCalendarDayAdded(CalendarDay calendarDay) {}

  /**
   * Invoked when the calendar is initialized.
   *
   * @param calendar The calendar that is being initialized
   */
  default void onInit(Calendar calendar) {}
}
