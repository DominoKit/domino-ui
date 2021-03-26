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

import elemental2.core.JsDate;

/** A utility class for {@link DatePicker} */
public class DatePickerUtil {

  /**
   * Returns a valid day of month
   *
   * @param year the year of the month
   * @param month the month
   * @param date the current date
   * @return the valid day of month
   */
  public static int getValidMonthDate(int year, int month, int date) {
    int days = getMonthDays(year, month);

    if (date > days) {
      return 1;
    } else {
      return date;
    }
  }

  /**
   * Returns the number of days for a month at specific year
   *
   * @param year the year
   * @param month the month
   * @return the number of days
   */
  public static int getMonthDays(int year, int month) {
    JsDate jsDateCalc = new JsDate(year, month, 32);
    return (32 - (jsDateCalc.getDate()));
  }
}
