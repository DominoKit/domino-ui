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
import java.util.Date;

/**
 * Represents the data for a specific month, including the total number of days in the month, the
 * full year, and a reference date within the month. This class provides methods to navigate to
 * previous and next months, and also to retrieve details about the month.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>
 * MonthData currentMonth = new MonthData(new Date());
 * MonthData previousMonth = currentMonth.getMonthBefore();
 * System.out.println("Days in current month: " + currentMonth.getDaysCount());
 * </pre>
 */
public class MonthData {

  private final int daysCount;
  private final int fullYear;
  private final Date date;

  /**
   * Constructs a new MonthData instance based on the provided date.
   *
   * @param date A date within the month for which the data should be fetched.
   */
  public MonthData(Date date) {
    this.date = date;
    JsDate zeroDayDate = new JsDate(this.date.getYear() + 1900, this.date.getMonth() + 1, 0);
    this.daysCount = zeroDayDate.getDate();
    this.fullYear = zeroDayDate.getFullYear();
  }

  /**
   * Retrieves the data for the month immediately before the current month.
   *
   * @return The data for the previous month.
   */
  public MonthData getMonthBefore() {
    if (this.date.getMonth() == 0) {
      return new MonthData(new Date(this.date.getYear() - 1, 11, 1));
    } else {
      return new MonthData(new Date(this.date.getYear(), this.date.getMonth() - 1, 1));
    }
  }

  /**
   * Retrieves the data for the month immediately after the current month.
   *
   * @return The data for the next month.
   */
  public MonthData getMonthAfter() {
    if (this.date.getMonth() == 11) {
      return new MonthData(new Date(this.date.getYear() + 1, 0, 1));
    } else {
      return new MonthData(new Date(this.date.getYear(), this.date.getMonth() + 1, 1));
    }
  }

  /**
   * Retrieves the year part of the reference date.
   *
   * @return The year of the reference date.
   */
  public int getYear() {
    return this.date.getYear();
  }

  /**
   * Retrieves the month part (zero-based) of the reference date.
   *
   * @return The month of the reference date.
   */
  public int getMonth() {
    return this.date.getMonth();
  }

  /**
   * Retrieves the total number of days in the current month.
   *
   * @return The number of days in the month.
   */
  public int getDaysCount() {
    return daysCount;
  }

  /**
   * Retrieves the full year of the reference date (e.g., 2022).
   *
   * @return The full year of the reference date.
   */
  public int getFullYear() {
    return fullYear;
  }
}
