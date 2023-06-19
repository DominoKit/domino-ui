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

import elemental2.dom.Element;
import elemental2.dom.HTMLDivElement;
import java.util.Date;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo;

public class CalendarDay extends BaseDominoElement<HTMLDivElement, CalendarDay>
    implements CalendarStyles {

  private final int day;
  private final boolean inRange;
  private final DivElement root;
  private final IsCalendar calendar;
  private final Date date;
  private final SpanElement dayNumber;

  public CalendarDay(IsCalendar calendar, Date date, int day, boolean inRange) {
    this.calendar = calendar;
    this.date = date;
    this.day = day;
    this.inRange = inRange;

    root =
        div()
            .addClickListener(
                evt -> {
                  this.dispatchEvent(
                      CalendarCustomEvents.dateSelectionChanged(
                          new Date(this.date.getYear(), this.date.getMonth(), this.date.getDate())
                              .getTime()));
                })
            .addCss(
                dui_calendar_day,
                BooleanCssClass.of(dui_month_day_in_range, inRange),
                BooleanCssClass.of(dui_month_day_out_of_range, !inRange),
                BooleanCssClass.of(dui_selected_date, isSelectedDate()),
                BooleanCssClass.of(dui_today_date, isTodayDate()))
            .appendChild(
                this.dayNumber =
                    span()
                        .addCss(dui_calendar_day_number)
                        .textContent(String.valueOf(date.getDate())));
    init(this);
  }

  public static CalendarDay create(IsCalendar isCalendar, Date date, int day, boolean inRange) {
    return new CalendarDay(isCalendar, date, day, inRange);
  }

  @Override
  public Element getClickableElement() {
    return dayNumber.element();
  }

  public boolean isTodayDate() {
    Date date = new Date();
    return date.getYear() == this.date.getYear()
        && date.getMonth() == this.date.getMonth()
        && date.getDate() == this.date.getDate();
  }

  public boolean isSelectedDate() {
    Date selectedDate = this.calendar.getDate();
    return selectedDate.getYear() == this.date.getYear()
        && selectedDate.getMonth() == this.date.getMonth()
        && selectedDate.getDate() == this.date.getDate();
  }

  public boolean isInMonthRange() {
    return inRange;
  }

  public int getDay() {
    return day;
  }

  public boolean isInRange() {
    return inRange;
  }

  public IsCalendar getCalendar() {
    return calendar;
  }

  public Date getDate() {
    return date;
  }

  public SpanElement getDayNumber() {
    return dayNumber;
  }

  public boolean isWeekend() {
    DateTimeFormatInfo dateInfo = this.calendar.getDateTimeFormatInfo();
    int start = dateInfo.weekendStart();
    int end = dateInfo.weekendEnd();
    if (start > end) {
      return !(this.day > end && this.day < start);
    } else {
      return (this.day >= start && this.day <= end);
    }
  }

  @Override
  public HTMLDivElement element() {
    return this.root.element();
  }
}
