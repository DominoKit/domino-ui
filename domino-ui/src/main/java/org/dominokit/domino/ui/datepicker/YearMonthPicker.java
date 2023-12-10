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
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.spin.HSpinSelect;
import org.dominokit.domino.ui.spin.SpinItem;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * Represents the picker for selecting a specific year and month.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>
 * YearMonthPicker picker = YearMonthPicker.create(calendarInstance);
 * </pre>
 *
 * @see BaseDominoElement
 */
public class YearMonthPicker extends BaseDominoElement<HTMLDivElement, YearMonthPicker>
    implements CalendarStyles, CalendarViewListener {

  private final DivElement root;
  private final MonthsPicker monthsPicker;
  private final HSpinSelect<YearPicker> yearPickerSpin;
  private final IsCalendar calendar;

  /**
   * Creates a new year-month picker for the specified calendar.
   *
   * @param calendar The {@link IsCalendar} instance that this picker is associated with.
   */
  public YearMonthPicker(IsCalendar calendar) {
    this.calendar = calendar;
    this.calendar.bindCalenderViewListener(this);

    this.root =
        div()
            .addCss(dui_calendar_months_years_selector)
            .appendChild(this.monthsPicker = MonthsPicker.create(this.calendar))
            .appendChild(
                this.yearPickerSpin =
                    HSpinSelect.<YearPicker>create().addCss(dui_calender_years_spin));

    init(this);
  }

  /**
   * Factory method to create a new year-month picker.
   *
   * @param calendar The {@link IsCalendar} instance to associate with the picker.
   * @return a new instance of {@link YearMonthPicker}.
   */
  public static YearMonthPicker create(IsCalendar calendar) {
    return new YearMonthPicker(calendar);
  }

  private void updateView() {
    monthsPicker.updateView();
    YearPicker referenceCard = YearPicker.create(this.calendar, this.calendar.getDate().getYear());
    YearPicker previousCard =
        YearPicker.create(this.calendar, this.calendar.getDate().getYear() - 12);
    YearPicker nextCard = YearPicker.create(this.calendar, this.calendar.getDate().getYear() + 12);

    this.yearPickerSpin
        .reset()
        .appendChild(SpinItem.create(referenceCard).appendChild(previousCard))
        .appendChild(SpinItem.create(referenceCard).appendChild(referenceCard))
        .appendChild(SpinItem.create(referenceCard).appendChild(nextCard))
        .moveToIndex(1)
        .apply(
            spin -> {
              spin.addChangeListener(
                  (oldValue, yearsCard) -> {
                    int activeIndex = spin.indexOf(spin.getActiveItem());
                    if (activeIndex == spin.itemsCount() - 1) {
                      SpinItem<YearPicker> lastYearCard =
                          spin.getItems().get(spin.itemsCount() - 1);
                      int refYear = lastYearCard.getValue().getReferenceYear() + 14;
                      YearPicker newCard = YearPicker.create(this.calendar, refYear);
                      spin.appendChild(SpinItem.create(newCard).appendChild(newCard));
                    } else if (activeIndex == 0) {
                      int refYear = yearsCard.getReferenceYear() - 14;
                      YearPicker newCard = YearPicker.create(this.calendar, refYear);
                      spin.prependChild(SpinItem.create(newCard).appendChild(newCard));
                    }
                  });
            });
  }

  /**
   * Displays the year-month picker and updates its view.
   *
   * @return the current instance of {@link YearMonthPicker}.
   */
  @Override
  public YearMonthPicker show() {
    if (!isVisible()) {
      updateView();
    }
    return super.show();
  }

  /**
   * Returns the root {@link HTMLDivElement} of this year-month picker.
   *
   * @return the root {@link HTMLDivElement}.
   */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
