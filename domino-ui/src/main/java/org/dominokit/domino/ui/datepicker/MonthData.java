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

/** MonthData class. */
public class MonthData {

  private final int daysCount;
  private final int fullYear;
  private final Date date;

  /**
   * Constructor for MonthData.
   *
   * @param date a {@link java.util.Date} object
   */
  public MonthData(Date date) {
    this.date = date;
    JsDate zeroDayDate = new JsDate(this.date.getYear() + 1900, this.date.getMonth() + 1, 0);
    this.daysCount = zeroDayDate.getDate();
    this.fullYear = zeroDayDate.getFullYear();
  }

  /**
   * getMonthBefore.
   *
   * @return a {@link org.dominokit.domino.ui.datepicker.MonthData} object
   */
  public MonthData getMonthBefore() {
    if (this.date.getMonth() == 0) {
      return new MonthData(new Date(this.date.getYear() - 1, 11, 1));
    } else {
      return new MonthData(new Date(this.date.getYear(), this.date.getMonth() - 1, 1));
    }
  }

  /**
   * getMonthAfter.
   *
   * @return a {@link org.dominokit.domino.ui.datepicker.MonthData} object
   */
  public MonthData getMonthAfter() {
    if (this.date.getMonth() == 11) {
      return new MonthData(new Date(this.date.getYear() + 1, 0, 1));
    } else {
      return new MonthData(new Date(this.date.getYear(), this.date.getMonth() + 1, 1));
    }
  }

  /**
   * getYear.
   *
   * @return a int
   */
  public int getYear() {
    return this.date.getYear();
  }

  /**
   * getMonth.
   *
   * @return a int
   */
  public int getMonth() {
    return this.date.getMonth();
  }

  /**
   * Getter for the field <code>daysCount</code>.
   *
   * @return a int
   */
  public int getDaysCount() {
    return daysCount;
  }

  /**
   * Getter for the field <code>fullYear</code>.
   *
   * @return a int
   */
  public int getFullYear() {
    return fullYear;
  }
}
