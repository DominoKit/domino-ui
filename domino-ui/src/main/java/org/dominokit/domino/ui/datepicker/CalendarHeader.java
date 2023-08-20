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

/** CalendarHeader class. */
public class CalendarHeader extends BaseDominoElement<HTMLDivElement, CalendarHeader>
    implements CalendarStyles, CalendarViewListener {

  private final DivElement root;
  private final IsCalendar calendar;
  private SpanElement dateElement;
  private SpanElement dayElement;
  private SpanElement montAndYearElement;

  /**
   * Constructor for CalendarHeader.
   *
   * @param calendar a {@link org.dominokit.domino.ui.datepicker.IsCalendar} object
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
   * create.
   *
   * @param calendar a {@link org.dominokit.domino.ui.datepicker.IsCalendar} object
   * @return a {@link org.dominokit.domino.ui.datepicker.CalendarHeader} object
   */
  public static CalendarHeader create(IsCalendar calendar) {
    return new CalendarHeader(calendar);
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }

  /** {@inheritDoc} */
  @Override
  public void onDateSelectionChanged(Date date) {
    if (isNull(date)) {
      updateView(new Date());
    } else {
      updateView(date);
    }
  }

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
