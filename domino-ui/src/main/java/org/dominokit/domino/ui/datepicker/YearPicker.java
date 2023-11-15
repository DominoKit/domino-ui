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

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLDivElement;
import java.util.Date;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * Represents a picker for selecting a specific year.
 *
 * <p>The year picker provides a grid of years centered around a reference year, allowing the user
 * to pick a year either by clicking on it or by navigating using the associated calendar.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>
 * YearPicker picker = YearPicker.create(calendarInstance, 2023);
 * </pre>
 *
 * @see BaseDominoElement
 */
public class YearPicker extends BaseDominoElement<HTMLDivElement, YearPicker>
    implements CalendarStyles {

  private final DivElement root;
  private final int referenceYear;
  private final IsCalendar calendar;

  /**
   * Creates a new year picker centered around the specified reference year.
   *
   * @param calendar The {@link IsCalendar} instance that this picker is associated with.
   * @param referenceYear The year around which the picker will center its display.
   */
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

  /**
   * Factory method to create a new year picker.
   *
   * @param calendar The {@link IsCalendar} instance to associate with the picker.
   * @param referenceYear The year around which the picker will center its display.
   * @return a new instance of {@link YearPicker}.
   */
  public static YearPicker create(IsCalendar calendar, int referenceYear) {
    return new YearPicker(calendar, referenceYear);
  }

  private boolean isCurrentYear(int year) {
    return year == new Date().getYear();
  }

  private boolean isSelectedYear(int year) {
    return year == this.calendar.getDate().getYear();
  }

  /**
   * Returns the reference year around which this picker centers its display.
   *
   * @return the reference year.
   */
  public int getReferenceYear() {
    return referenceYear;
  }

  /**
   * Returns the root {@link HTMLDivElement} of this year picker.
   *
   * @return the root {@link HTMLDivElement}.
   */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
