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

import static org.dominokit.domino.ui.shaded.timepicker.DayPeriod.NONE;

import elemental2.core.JsDate;
import java.util.Objects;
import org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo;
import org.gwtproject.i18n.shared.cldr.impl.DateTimeFormatInfo_factory;

/** A class for time value in specific {@link DayPeriod} */
@Deprecated
public class Time {
  private int hour;
  private int minute;
  private DayPeriod dayPeriod;

  /**
   * create with default date time format information
   *
   * @see DateTimeFormatInfo_factory
   */
  public Time() {
    this(DateTimeFormatInfo_factory.create());
  }

  /**
   * create with date time format information
   *
   * @param dateTimeFormatInfo {@link DateTimeFormatInfo}
   */
  public Time(DateTimeFormatInfo dateTimeFormatInfo) {
    Clock12 clock12 = new Clock12(new JsDate(), dateTimeFormatInfo);
    this.hour = clock12.getHour();
    this.minute = clock12.getMinute();
    this.dayPeriod = clock12.getDayPeriod();
  }

  /**
   * @param hour int
   * @param minute int
   * @param dayPeriod {@link DayPeriod}
   */
  public Time(int hour, int minute, DayPeriod dayPeriod) {
    this(hour, minute, dayPeriod, DateTimeFormatInfo_factory.create());
  }

  /**
   * @param hour int
   * @param minute int
   * @param dayPeriod {@link DayPeriod}
   */
  public Time(int hour, int minute, DayPeriod dayPeriod, DateTimeFormatInfo dateTimeFormatInfo) {
    JsDate jsDate = new JsDate();
    jsDate.setHours(hour);
    jsDate.setMinutes(minute);
    Clock clock;
    if (NONE.equals(dayPeriod)) {
      clock = new Clock24(jsDate, dateTimeFormatInfo);
    } else {
      clock = new Clock12(jsDate, dateTimeFormatInfo);
    }
    this.hour = clock.getHour();
    this.minute = clock.getMinute();
    this.dayPeriod = dayPeriod;
  }

  /** @return int hour */
  public int getHour() {
    return hour;
  }

  /** @param hour int */
  public void setHour(int hour) {
    this.hour = hour;
  }
  /** @return int minute */
  public int getMinute() {
    return minute;
  }

  /** @param minute int */
  public void setMinute(int minute) {
    this.minute = minute;
  }

  /** @return the {@link DayPeriod} */
  public DayPeriod getDayPeriod() {
    return dayPeriod;
  }

  /** @param dayPeriod {@link DayPeriod} */
  public void setDayPeriod(DayPeriod dayPeriod) {
    this.dayPeriod = dayPeriod;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Time time = (Time) o;
    return hour == time.hour && minute == time.minute && dayPeriod == time.dayPeriod;
  }

  @Override
  public int hashCode() {
    return Objects.hash(hour, minute, dayPeriod);
  }
}
