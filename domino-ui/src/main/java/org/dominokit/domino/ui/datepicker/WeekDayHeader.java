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
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo;

/**
 * WeekDayHeader class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class WeekDayHeader extends BaseDominoElement<HTMLDivElement, WeekDayHeader>
    implements CalendarStyles, CalendarViewListener {

  private final DivElement root;
  private final IsCalendar calendar;
  private final int dayIndex;
  private final SpanElement dayElement;

  /**
   * Constructor for WeekDayHeader.
   *
   * @param calendar a {@link org.dominokit.domino.ui.datepicker.IsCalendar} object
   * @param dayIndex a int
   */
  public WeekDayHeader(IsCalendar calendar, int dayIndex) {
    this.calendar = calendar;
    this.calendar.bindCalenderViewListener(this);
    this.dayIndex = dayIndex;
    this.root =
        div()
            .addCss(dui_week_day_header)
            .appendChild(
                dayElement =
                    span()
                        .addCss(dui_day_header_name)
                        .textContent(
                            this.calendar.getDateTimeFormatInfo().weekdaysShort()[dayIndex]));
    init(this);
    onDetached(mutationRecord -> this.calendar.unbindCalenderViewListener(this));
  }

  /**
   * create.
   *
   * @param calendar a {@link org.dominokit.domino.ui.datepicker.IsCalendar} object
   * @param dayIndex a int
   * @return a {@link org.dominokit.domino.ui.datepicker.WeekDayHeader} object
   */
  public static WeekDayHeader create(IsCalendar calendar, int dayIndex) {
    return new WeekDayHeader(calendar, dayIndex);
  }

  /** {@inheritDoc} */
  @Override
  public void onDateTimeFormatInfoChanged(DateTimeFormatInfo dateTimeFormatInfo) {
    dayElement.textContent(dateTimeFormatInfo.weekdaysShort()[dayIndex]);
    root.setTooltip(dateTimeFormatInfo.weekdaysFull()[dayIndex], DropDirection.TOP_MIDDLE);
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
