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
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo;

/**
 * Represents the header for each weekday in a calendar.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>
 * WeekDayHeader mondayHeader = WeekDayHeader.create(calendarInstance, 1);
 * </pre>
 *
 * @see BaseDominoElement
 */
public class WeekDayHeader extends BaseDominoElement<HTMLDivElement, WeekDayHeader>
    implements CalendarStyles, CalendarViewListener {

  private final DivElement root;
  private final IsCalendar calendar;
  private final int dayIndex;
  private final SpanElement dayElement;

  /**
   * Creates a new weekday header for the specified calendar and day index.
   *
   * @param calendar The {@link IsCalendar} instance that this header is associated with.
   * @param dayIndex The index of the day this header represents.
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
    onDetached((e, mutationRecord) -> this.calendar.unbindCalenderViewListener(this));
  }

  /**
   * Factory method to create a new weekday header.
   *
   * @param calendar The {@link IsCalendar} instance to associate with the header.
   * @param dayIndex The index of the day the header represents.
   * @return a new instance of {@link WeekDayHeader}.
   */
  public static WeekDayHeader create(IsCalendar calendar, int dayIndex) {
    return new WeekDayHeader(calendar, dayIndex);
  }

  /**
   * Callback method executed when the DateTimeFormatInfo of the associated calendar changes.
   *
   * @param dateTimeFormatInfo The updated DateTimeFormatInfo instance.
   */
  @Override
  public void onDateTimeFormatInfoChanged(DateTimeFormatInfo dateTimeFormatInfo) {
    dayElement.textContent(dateTimeFormatInfo.weekdaysShort()[dayIndex]);
    root.setTooltip(dateTimeFormatInfo.weekdaysFull()[dayIndex], DropDirection.TOP_MIDDLE);
  }

  /**
   * Returns the root {@link HTMLDivElement} of this weekday header.
   *
   * @return the root {@link HTMLDivElement}.
   */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
