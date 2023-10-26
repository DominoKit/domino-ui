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

import static java.util.Objects.isNull;

import elemental2.dom.HTMLDivElement;
import java.util.Date;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * Represents the header of a calendar which displays the currently selected date.
 *
 * <p>Usage example:
 *
 * <pre>
 * IsCalendar calendar = ... // create or obtain an instance of IsCalendar
 * CalendarHeader header = new CalendarHeader(calendar);
 * </pre>
 *
 * @see BaseDominoElement
 */
public class CalendarHeader extends BaseDominoElement<HTMLDivElement, CalendarHeader>
    implements CalendarStyles, CalendarViewListener {

  private final DivElement root;
  private final IsCalendar calendar;
  private SpanElement dateElement;
  private SpanElement dayElement;
  private SpanElement montAndYearElement;

  /**
   * Constructs a CalendarHeader associated with the provided calendar.
   *
   * @param calendar the calendar for which this header is being created
   */
  public CalendarHeader(IsCalendar calendar) {
    this.calendar = calendar;
    this.calendar.bindCalenderViewListener(this);
    this.root =
        div()
            .addCss(dui_calendar_header)
            .appendChild(
                div()
                    .addCss(dui_calendar_header_date)
                    .appendChild(dateElement = span().addCss(dui_calendar_header_date_number))
                    .appendChild(
                        div()
                            .addCss(dui_calendar_header_date_day_month_year)
                            .appendChild(
                                dayElement =
                                    span()
                                        .addCss(dui_calendar_header_date_day)
                                        .textContent("Wednesday"))
                            .appendChild(
                                montAndYearElement =
                                    span()
                                        .addCss(dui_calendar_header_date_month_year)
                                        .textContent("May, 2023"))));
    init(this);
  }

  /**
   * Factory method to create a new instance of CalendarHeader.
   *
   * @param calendar the associated calendar
   * @return a new instance of CalendarHeader
   */
  public static CalendarHeader create(IsCalendar calendar) {
    return new CalendarHeader(calendar);
  }

  /**
   * {@inheritDoc}
   *
   * <p>Returns the root element representing the entire calendar header.
   */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }

  /**
   * Updates the displayed date when a date selection changes.
   *
   * @param date the new selected date
   */
  @Override
  public void onDateSelectionChanged(Date date) {
    if (isNull(date)) {
      updateView(new Date());
    } else {
      updateView(date);
    }
  }

  /**
   * Updates the header view to display the provided date details.
   *
   * @param date the date to be displayed in the header
   */
  private void updateView(Date date) {
    int year = date.getYear();
    int month = date.getMonth();
    int dateDate = date.getDate();
    int day = date.getDay();
    this.dateElement.textContent(String.valueOf(dateDate));
    this.dayElement.textContent(this.calendar.getDateTimeFormatInfo().weekdaysFull()[day]);
    this.montAndYearElement.textContent(
        this.calendar.getDateTimeFormatInfo().monthsFull()[month] + ", " + (year + 1900));
  }
}
