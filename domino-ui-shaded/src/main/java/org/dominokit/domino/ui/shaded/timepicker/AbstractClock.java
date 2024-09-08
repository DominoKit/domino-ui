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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dominokit.domino.ui.shaded.timepicker;

import static org.dominokit.domino.ui.shaded.timepicker.DayPeriod.NONE;

import org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo;

/** Base clock common implementation */
abstract class AbstractClock implements Clock {

  protected DayPeriod dayPeriod = NONE;

  protected int hour;

  protected int minute;

  protected int second;

  protected DateTimeFormatInfo dateTimeFormatInfo;

  protected boolean showSecond = false;

  /**
   * {@inheritDoc}
   *
   * @return empty String
   */
  @Override
  public String formatPeriod() {
    return "";
  }

  /** {@inheritDoc} default to {@link DayPeriod#NONE} */
  @Override
  public DayPeriod getDayPeriod() {
    return dayPeriod;
  }

  /** {@inheritDoc} */
  @Override
  public void setDayPeriod(DayPeriod dayPeriod) {
    this.dayPeriod = dayPeriod;
  }

  /** {@inheritDoc} */
  @Override
  public int getHour() {
    return hour;
  }

  /** {@inheritDoc} */
  @Override
  public void setHour(int hour) {
    this.hour = hour;
  }

  /** {@inheritDoc} */
  @Override
  public int getMinute() {
    return minute;
  }

  /** {@inheritDoc} */
  @Override
  public void setMinute(int minute) {
    this.minute = minute;
  }

  /** {@inheritDoc} */
  @Override
  public int getSecond() {
    return second;
  }

  /** {@inheritDoc} */
  @Override
  public void setSecond(int second) {
    this.second = second;
  }

  /** @return the {@link DateTimeFormatInfo} for this clock */
  public DateTimeFormatInfo getDateTimeFormatInfo() {
    return dateTimeFormatInfo;
  }

  /** {@inheritDoc} */
  @Override
  public void setDateTimeFormatInfo(DateTimeFormatInfo dateTimeFormatInfo) {
    this.dateTimeFormatInfo = dateTimeFormatInfo;
  }

  /** {@inheritDoc} */
  @Override
  public void setShowSeconds(boolean showSecond) {
    this.showSecond = showSecond;
  }
}
