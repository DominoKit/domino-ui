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
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.utils.DominoUIConfig.CONFIG;

import elemental2.core.JsDate;
import elemental2.dom.HTMLDivElement;
import java.util.Date;
import org.dominokit.domino.ui.config.CalendarConfig;
import org.dominokit.domino.ui.config.HasComponentConfig;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo;

public class CalendarSelectors extends BaseDominoElement<HTMLDivElement, CalendarSelectors>
    implements CalendarStyles, HasComponentConfig<CalendarConfig>, CalendarViewListener {

  private final DivElement root;
  private final IsCalendar calendar;
  private DivElement yearElement;
  private DivElement monthElement;
  private Date date = new Date();

  public CalendarSelectors(IsCalendar calendar) {
    this(
        calendar,
        CONFIG.getUIConfig().defaultCalendarPreviousIcon().get(),
        CONFIG.getUIConfig().defaultCalendarNextIcon().get());
  }

  public CalendarSelectors(IsCalendar calendar, Icon<?> previousIcon, Icon<?> nextIcon) {
    this.calendar = calendar;
    this.calendar.bindCalenderViewListener(this);
    this.root =
        div()
            .addCss(dui_calendar_selectors)
            .appendChild(
                previousIcon
                    .addCss(dui_calendar_selectors_previous)
                    .clickable()
                    .addClickListener(
                        evt -> {
                          toPreviousMonth();
                        }))
            .appendChild(
                yearElement =
                    div()
                        .addCss(dui_calendar_selectors_year)
                        .addClickListener(
                            evt -> dispatchEvent(CalendarCustomEvents.selectYearMonth())))
            .appendChild(
                monthElement =
                    div()
                        .addCss(dui_calendar_selectors_month)
                        .addClickListener(
                            evt -> dispatchEvent(CalendarCustomEvents.selectYearMonth())))
            .appendChild(
                nextIcon
                    .addCss(dui_calendar_selectors_next)
                    .clickable()
                    .addClickListener(
                        evt -> {
                          toNextMonth();
                        }));
    init(this);
  }

  public static CalendarSelectors create(IsCalendar calendar) {
    return new CalendarSelectors(calendar);
  }

  public static CalendarSelectors create(
      IsCalendar calendar, Icon<?> previousIcon, Icon<?> nextIcon) {
    return new CalendarSelectors(calendar, previousIcon, nextIcon);
  }

  private void toNextMonth() {
    JsDate jsDate = new JsDate();
    MonthData nextMonthData = new MonthData(this.date).getMonthAfter();

    jsDate.setFullYear(
        this.date.getYear() + 1900,
        this.date.getMonth(),
        this.date.getDate() > nextMonthData.getDaysCount() ? 1 : this.date.getDate());
    jsDate.setMonth(jsDate.getMonth() + 1);
    Date updatedDate = new Date(new Double(jsDate.getTime()).longValue());
    this.dispatchEvent(CalendarCustomEvents.dateNavigationChanged(updatedDate.getTime()));
  }

  private void toPreviousMonth() {
    JsDate jsDate = new JsDate();
    MonthData monthBefore = new MonthData(this.date).getMonthBefore();

    jsDate.setFullYear(
        this.date.getYear() + 1900,
        this.date.getMonth(),
        this.date.getDate() > monthBefore.getDaysCount() ? 1 : this.date.getDate());
    jsDate.setMonth(jsDate.getMonth() - 1);
    Date updatedDate = new Date(new Double(jsDate.getTime()).longValue());
    this.dispatchEvent(CalendarCustomEvents.dateNavigationChanged(updatedDate.getTime()));
  }

  private CalendarSelectors setYear(int year) {
    this.yearElement.textContent(String.valueOf(year));
    return this;
  }

  private CalendarSelectors setMonth(int month) {
    if (month < 0 || month > 11) {
      throw new IllegalArgumentException("Moths are 0 based from 0-11 got [" + month + "]");
    }
    this.monthElement.textContent(this.calendar.getDateTimeFormatInfo().monthsFull()[month]);
    return this;
  }

  @Override
  public void onDateTimeFormatInfoChanged(DateTimeFormatInfo dateTimeFormatInfo) {
    if (nonNull(dateTimeFormatInfo)) {
      if (nonNull(this.date)) {
        setYear(this.date.getYear() + 1900);
        setMonth(this.date.getMonth());
      }
    }
  }

  @Override
  public void onDateSelectionChanged(Date date) {
    if (nonNull(date)) {
      setDate(date);
    }
  }

  public CalendarSelectors setDate(Date date) {
    if (isNull(date)) {
      this.date = new Date();
    } else {
      this.date = date;
    }
    setYear(this.date.getYear() + 1900);
    setMonth(this.date.getMonth());
    return this;
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }

  @Override
  public void onUpdateCalendarView(Date date) {
    setDate(date);
  }
}
