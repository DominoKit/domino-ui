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
 * CalendarViewListener interface.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public interface CalendarViewListener {
  /**
   * onUpdateCalendarView.
   *
   * @param date a {@link java.util.Date} object
   */
  default void onUpdateCalendarView(Date date) {}

  /**
   * onDateSelectionChanged.
   *
   * @param date a {@link java.util.Date} object
   */
  default void onDateSelectionChanged(Date date) {}

  /**
   * onDateTimeFormatInfoChanged.
   *
   * @param dateTimeFormatInfo a {@link org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo} object
   */
  default void onDateTimeFormatInfoChanged(DateTimeFormatInfo dateTimeFormatInfo) {}
}
