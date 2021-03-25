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

/** A context which holds a month information */
public class MonthContext {

  private final int year;
  private final int month;
  private final int date;
  private final int day;
  private final int days;
  private final int firstDay;

  public MonthContext(int year, int month) {
    this(year, month, new JsDate().getDate());
  }

  public MonthContext(int year, int month, int date) {

    JsDate jsDate = new JsDate(year, month, DatePickerUtil.getValidMonthDate(year, month, date));

    this.year = jsDate.getFullYear();
    this.month = jsDate.getMonth();
    this.date = jsDate.getDate();
    this.day = jsDate.getDay();
    this.days = DatePickerUtil.getMonthDays(year, month);

    this.firstDay = new JsDate(year, month, 1).getDay();
  }

  /** @return A current month information */
  public static MonthContext current() {
    JsDate date = new JsDate();
    return new MonthContext(date.getFullYear(), date.getMonth());
  }

  /** @return The month before this one */
  public MonthContext getMonthBefore() {
    return new MonthContext(month == 0 ? year - 1 : year, month == 0 ? 11 : (month - 1));
  }

  /** @return The year of this month */
  public int getYear() {
    return year;
  }

  /** @return The month */
  public int getMonth() {
    return month;
  }

  /** @return The day of this month */
  public int getDate() {
    return date;
  }

  /** @return The current day */
  public int getDay() {
    return day;
  }

  /** @return The number of days */
  public int getDays() {
    return days;
  }

  /** @return The first day of the month */
  public int getFirstDay() {
    return firstDay;
  }
}
