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
 * Represents a listener that gets notified when a day is selected in the calendar. The listener
 * will be provided with both the previously selected day and the newly selected day.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>
 * DateSelectionListener listener = new DateSelectionListener() {
 *     &#64;Override
 *     public void onDaySelected(CalendarDay oldDay, CalendarDay newDay) {
 *         System.out.println("Previous Day: " + oldDay + ", New Day: " + newDay);
 *     }
 * };
 * </pre>
 */
public interface DateSelectionListener {

  /**
   * Called when a new day is selected in the calendar.
   *
   * @param oldDay The previously selected day.
   * @param newDay The newly selected day.
   */
  void onDaySelected(CalendarDay oldDay, CalendarDay newDay);
}
