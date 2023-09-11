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

/** IsCalendar interface. */
public interface IsCalendar {
  /**
   * getDate.
   *
   * @return a {@link java.util.Date} object
   */
  Date getDate();

  /**
   * getDateTimeFormatInfo.
   *
   * @return a {@link org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo} object
   */
  DateTimeFormatInfo getDateTimeFormatInfo();

  /**
   * bindCalenderViewListener.
   *
   * @param listener a {@link org.dominokit.domino.ui.datepicker.CalendarViewListener} object
   */
  void bindCalenderViewListener(CalendarViewListener listener);

  /**
   * unbindCalenderViewListener.
   *
   * @param listener a {@link org.dominokit.domino.ui.datepicker.CalendarViewListener} object
   */
  void unbindCalenderViewListener(CalendarViewListener listener);

  /**
   * getDateSelectionListeners.
   *
   * @return a {@link java.util.Set} object
   */
  Set<DateSelectionListener> getDateSelectionListeners();

  /**
   * getConfig.
   *
   * @return a {@link org.dominokit.domino.ui.datepicker.CalendarInitConfig} object
   */
  CalendarInitConfig getConfig();
}
