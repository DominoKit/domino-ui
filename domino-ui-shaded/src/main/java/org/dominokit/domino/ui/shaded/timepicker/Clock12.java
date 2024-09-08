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
package org.dominokit.domino.ui.shaded.timepicker;

import static org.dominokit.domino.ui.shaded.timepicker.DayPeriod.*;

import elemental2.core.JsDate;
import java.util.Date;
import org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo;

/** An implementation of {@link Clock} for 12h clock system */
class Clock12 extends AbstractClock {

  /**
   * @param dateTimeFormatInfo {@link DateTimeFormatInfo}
   * @see #setDateTimeFormatInfo(DateTimeFormatInfo)
   */
  public Clock12(DateTimeFormatInfo dateTimeFormatInfo) {
    this(new JsDate(), dateTimeFormatInfo);
    this.dateTimeFormatInfo = dateTimeFormatInfo;
  }

  /**
   * @param jsDate {@link JsDate} as initial time value
   * @param dateTimeFormatInfo {@link DateTimeFormatInfo}
   */
  Clock12(JsDate jsDate, DateTimeFormatInfo dateTimeFormatInfo) {
    this.dateTimeFormatInfo = dateTimeFormatInfo;
    this.dayPeriod = jsDate.getHours() > 11 ? PM : AM;
    this.minute = jsDate.getMinutes();
    this.second = jsDate.getSeconds();
    if (jsDate.getHours() > 12) {
      this.hour = jsDate.getHours() - 12;
    } else if (jsDate.getHours() == 0) {
      this.hour = 12;
    } else {
      this.hour = jsDate.getHours();
    }
  }

  /** {@inheritDoc} */
  @Override
  public Clock getFor(JsDate jsDate) {
    return new Clock12(jsDate, dateTimeFormatInfo);
  }

  /** {@inheritDoc} */
  @Override
  public String format() {
    return formatNoPeriod() + " " + formatPeriod();
  }

  /** {@inheritDoc} */
  @Override
  public String formatNoPeriod() {
    String hourString = this.hour < 10 ? "0" + this.hour : this.hour + "";
    String minuteString = this.minute < 10 ? "0" + this.minute : this.minute + "";
    String secondString = this.second < 10 ? "0" + this.second : this.second + "";
    return hourString + ":" + minuteString + (showSecond ? ":" + secondString : "");
  }

  /** @return the String day period base on the clock DateTimeFormatInfo */
  @Override
  public String formatPeriod() {
    return AM.equals(dayPeriod) ? dateTimeFormatInfo.ampms()[0] : dateTimeFormatInfo.ampms()[1];
  }

  /** @return int, for this clock the value is constant 1 */
  @Override
  public int getStartHour() {
    return 1;
  }

  /** @return int, for this clock the value is constant 12 */
  @Override
  public int getEndHour() {
    return 12;
  }

  /** @param hour int, if the hour is in 24h system it will be changed to 12h system */
  @Override
  public void setHour(int hour) {
    this.hour = getCorrectHour(hour);
  }

  /** {@inheritDoc} */
  @Override
  public int getCorrectHour(int hour) {
    if (hour > 12) {
      return hour - 12;
    } else if (hour == 0) {
      return 12;
    } else {
      return hour;
    }
  }

  /** {@inheritDoc} */
  @Override
  public Date getTime() {
    JsDate jsDate = new JsDate();
    if (DayPeriod.PM.equals(dayPeriod) && hour < 12) {
      jsDate.setHours(hour + 12);
    } else if (DayPeriod.AM.equals(dayPeriod) && hour == 12) {
      jsDate.setHours(0);
    } else {
      jsDate.setHours(hour);
    }
    jsDate.setMinutes(minute);
    jsDate.setSeconds(second);
    return new Date(new Double(jsDate.getTime()).longValue());
  }
}
