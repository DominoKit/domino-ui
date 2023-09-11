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

import elemental2.dom.HTMLDivElement;
import java.util.Date;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo;

/** MonthsPicker class. */
public class MonthsPicker extends BaseDominoElement<HTMLDivElement, MonthsPicker>
    implements CalendarStyles, CalendarViewListener {

  private final DivElement root;
  private final IsCalendar calendar;

  /**
   * Constructor for MonthsPicker.
   *
   * @param calendar a {@link org.dominokit.domino.ui.datepicker.IsCalendar} object
   */
  public MonthsPicker(IsCalendar calendar) {
    this.calendar = calendar;
    this.root = div().addCss(dui_month_selector);
    updateView();
    this.calendar.bindCalenderViewListener(this);
    init(this);
  }

  /**
   * create.
   *
   * @param isCalendar a {@link org.dominokit.domino.ui.datepicker.IsCalendar} object
   * @return a {@link org.dominokit.domino.ui.datepicker.MonthsPicker} object
   */
  public static MonthsPicker create(IsCalendar isCalendar) {
    return new MonthsPicker(isCalendar);
  }

  MonthsPicker updateView() {
    this.root.clearElement();
    String[] months = this.calendar.getDateTimeFormatInfo().monthsShort();

    int counter = 0;
    while (counter < 12) {
      DivElement monthsRow = div().addCss(dui_months_row);
      this.root.appendChild(monthsRow);
      for (int i = 0; i < 3; i++) {
        final int month = counter;
        monthsRow.appendChild(
            div()
                .addCss(
                    dui_month_selector_month,
                    BooleanCssClass.of(dui_current_month, isCurrentMonth(counter)),
                    BooleanCssClass.of(dui_selected_month, isSelectedMonth(counter)))
                .textContent(months[counter])
                .addClickListener(
                    evt -> {
                      Date calendarDate = calendar.getDate();
                      Date date = new Date(calendarDate.getTime());
                      date.setDate(1);
                      date.setMonth(month);
                      dispatchEvent(CalendarCustomEvents.dateNavigationChanged(date.getTime()));
                    }));
        counter++;
      }
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public void onDateTimeFormatInfoChanged(DateTimeFormatInfo dateTimeFormatInfo) {
    updateView();
  }

  private boolean isCurrentMonth(int counter) {
    return new Date().getMonth() == counter;
  }

  private boolean isSelectedMonth(int counter) {
    return counter == this.calendar.getDate().getMonth();
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
