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

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.span;

import elemental2.dom.Element;
import elemental2.dom.HTMLDivElement;
import java.util.Date;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo;

/**
 * Represents a single day in a calendar view.
 *
 * <p>Usage example:
 *
 * <pre>
 * CalendarDay day = CalendarDay.create(calendarInstance, new Date(), 5, true);
 * </pre>
 *
 * @see BaseDominoElement
 */
public class CalendarDay extends BaseDominoElement<HTMLDivElement, CalendarDay>
    implements CalendarStyles {

  private final int day;
  private final boolean inRange;
  private final DivElement root;
  private final IsCalendar calendar;
  private final Date date;
  private final SpanElement dayNumber;

  /**
   * Constructs a calendar day with the specified attributes.
   *
   * @param calendar The parent calendar of this day.
   * @param date The date this day represents.
   * @param day The day of the week (1-7).
   * @param inRange Indicates if the day is within the current month.
   */
  public CalendarDay(IsCalendar calendar, Date date, int day, boolean inRange) {
    this.calendar = calendar;
    this.date = date;
    this.day = day;
    this.inRange = inRange;

    root =
        div()
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
    addClickListener(
        evt -> {
          this.dispatchEvent(
              CalendarCustomEvents.dateSelectionChanged(
                  new Date(this.date.getYear(), this.date.getMonth(), this.date.getDate())
                      .getTime()));
        });
  }

  /**
   * Factory method to create a new CalendarDay instance.
   *
   * @param isCalendar The parent calendar of this day.
   * @param date The date this day represents.
   * @param day The day of the week (1-7).
   * @param inRange Indicates if the day is within the current month.
   * @return A new CalendarDay instance.
   */
  public static CalendarDay create(IsCalendar isCalendar, Date date, int day, boolean inRange) {
    return new CalendarDay(isCalendar, date, day, inRange);
  }

  /**
   * {@inheritDoc}
   *
   * <p>Returns the element representing the clickable part of the day, which is the day's number.
   */
  @Override
  public Element getClickableElement() {
    return dayNumber.element();
  }

  /**
   * Checks if the day represents the current date.
   *
   * @return true if the day is today's date, false otherwise.
   */
  public boolean isTodayDate() {
    Date date = new Date();
    return date.getYear() == this.date.getYear()
        && date.getMonth() == this.date.getMonth()
        && date.getDate() == this.date.getDate();
  }

  /**
   * Checks if the day represents the currently selected date in the calendar.
   *
   * @return true if the day is the selected date, false otherwise.
   */
  public boolean isSelectedDate() {
    Date selectedDate = this.calendar.getDate();
    return selectedDate.getYear() == this.date.getYear()
        && selectedDate.getMonth() == this.date.getMonth()
        && selectedDate.getDate() == this.date.getDate();
  }

  /**
   * Checks if the day is within the current month.
   *
   * @return true if the day is in the current month, false otherwise.
   */
  public boolean isInMonthRange() {
    return inRange;
  }

  /**
   * Retrieves the day of the week (1-7) that this day represents.
   *
   * @return The day of the week.
   */
  public int getDay() {
    return day;
  }

  /**
   * Checks if the day is within the range of valid days for the current month.
   *
   * @return true if the day is in range, false otherwise.
   */
  public boolean isInRange() {
    return inRange;
  }

  /**
   * Retrieves the parent calendar of this day.
   *
   * @return The parent calendar.
   */
  public IsCalendar getCalendar() {
    return calendar;
  }

  /**
   * Retrieves the date this day represents.
   *
   * @return The date.
   */
  public Date getDate() {
    return date;
  }

  /**
   * Retrieves the span element displaying the day's number.
   *
   * @return The span element for day number.
   */
  public SpanElement getDayNumber() {
    return dayNumber;
  }

  /**
   * Checks if the day is a weekend.
   *
   * @return true if the day is a weekend, false otherwise.
   */
  public boolean isWeekend() {
    DateTimeFormatInfo dateInfo = this.calendar.getDateTimeFormatInfo();
    int start = dateInfo.weekendStart();
    int end = dateInfo.weekendEnd();
    int dayNumber = this.day + 1;
    if (start > end) {
      return !(dayNumber > end && dayNumber < start);
    } else {
      return (dayNumber >= start && dayNumber <= end);
    }
  }

  /**
   * {@inheritDoc}
   *
   * <p>Returns the root element representing the entire calendar day.
   */
  @Override
  public HTMLDivElement element() {
    return this.root.element();
  }
}
