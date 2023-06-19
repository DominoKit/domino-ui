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

public class YearPicker extends BaseDominoElement<HTMLDivElement, YearPicker>
    implements CalendarStyles {

  private final DivElement root;
  private final int referenceYear;
  private final IsCalendar calendar;

  public YearPicker(IsCalendar calendar, int referenceYear) {
    this.referenceYear = referenceYear;
    this.calendar = calendar;
    this.root = div().addCss(dui_year_selector);
    int start = referenceYear - 7;
    int end = referenceYear + 7;

    int counter = start;
    while (counter <= end) {
      DivElement yearsRow = div().addCss(dui_years_row);
      this.root.appendChild(yearsRow);
      for (int i = 0; i < 5; i++) {
        final int year = counter;
        yearsRow.appendChild(
            div()
                .addCss(
                    dui_years_selector_year,
                    BooleanCssClass.of(dui_current_year, isCurrentYear(counter)),
                    BooleanCssClass.of(dui_selected_year, isSelectedYear(counter)))
                .textContent(String.valueOf(counter + 1900))
                .addClickListener(
                    evt -> {
                      Date date = new Date(calendar.getDate().getTime());
                      date.setYear(year);
                      dispatchEvent(CalendarCustomEvents.dateNavigationChanged(date.getTime()));
                    }));
        counter++;
      }
    }

    init(this);
  }

  public static YearPicker create(IsCalendar calendar, int referenceYear) {
    return new YearPicker(calendar, referenceYear);
  }

  private boolean isCurrentYear(int year) {
    return year == new Date().getYear();
  }

  private boolean isSelectedYear(int year) {
    return year == this.calendar.getDate().getYear();
  }

  public int getReferenceYear() {
    return referenceYear;
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
