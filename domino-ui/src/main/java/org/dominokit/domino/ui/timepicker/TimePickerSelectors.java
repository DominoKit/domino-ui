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
package org.dominokit.domino.ui.timepicker;

import static java.util.Objects.nonNull;

import elemental2.dom.HTMLDivElement;
import java.util.Date;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.suggest.Select;
import org.dominokit.domino.ui.forms.suggest.SelectOption;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;

/**
 * TimePickerSelectors class.
 *
 * @see BaseDominoElement
 */
public class TimePickerSelectors extends BaseDominoElement<HTMLDivElement, TimePickerSelectors>
    implements TimePickerStyles, TimePickerViewListener {

  private final DivElement root;
  private final IsTimePicker timePicker;
  private final Select<Integer> hoursSelect;
  private final Select<Integer> minutesSelect;
  private final Select<Integer> secondsSelect;
  private final Select<TimePeriod> ampmSelect;
  private Date date;

  /**
   * Constructor for TimePickerSelectors.
   *
   * @param timePicker a {@link org.dominokit.domino.ui.timepicker.IsTimePicker} object
   * @param date a {@link java.util.Date} object
   */
  public TimePickerSelectors(IsTimePicker timePicker, Date date) {
    this.timePicker = timePicker;
    this.date = date;
    this.timePicker.bindTimePickerViewListener(this);
    this.root =
        div()
            .addCss(dui_timepicker_selectors)
            .appendChild(
                this.hoursSelect =
                    Select.<Integer>create(this.timePicker.getLabels().hour())
                        .addCss(dui_timepicker_unit_selector))
            .appendChild(
                this.minutesSelect =
                    Select.<Integer>create(this.timePicker.getLabels().minute())
                        .addCss(dui_timepicker_unit_selector))
            .appendChild(
                this.secondsSelect =
                    Select.<Integer>create(this.timePicker.getLabels().seconds())
                        .addCss(dui_timepicker_unit_selector))
            .appendChild(
                this.ampmSelect =
                    Select.<TimePeriod>create(this.timePicker.getLabels().ampm())
                        .addCss(dui_timepicker_unit_selector)
                        .toggleDisplay(this.timePicker.isShowSeconds()));
    init(this);
    updateHours();
    updateMinutesSeconds();
    updateAmPm();

    this.hoursSelect.addChangeListener(
        (oldHour, hour) -> {
          Date pickerDate = timePicker.getDate();
          Date temp = new Date(pickerDate.getTime());
          if (timePicker.isPm() && hour < 12) {
            temp.setHours(12 + hour);
          } else {
            temp.setHours(hour);
          }
          dispatchEvent(TimePickerCustomEvents.timeSelectionChanged(temp.getTime()));
        });

    this.minutesSelect.addChangeListener(
        (oldValue, minute) -> {
          Date pickerDate = timePicker.getDate();
          Date temp = new Date(pickerDate.getTime());
          temp.setMinutes(minute);
          dispatchEvent(TimePickerCustomEvents.timeSelectionChanged(temp.getTime()));
        });

    this.secondsSelect.addChangeListener(
        (oldValue, second) -> {
          Date pickerDate = timePicker.getDate();
          Date temp = new Date(pickerDate.getTime());
          temp.setSeconds(second);
          dispatchEvent(TimePickerCustomEvents.timeSelectionChanged(temp.getTime()));
        });

    this.ampmSelect.addChangeListener(
        (oldValue, timePeriod) -> {
          if (!this.timePicker.is24Hours()) {
            Date pickerDate = timePicker.getDate();
            Date temp = new Date(pickerDate.getTime());
            if (timePeriod == TimePeriod.PM && hoursSelect.getValue() < 12) {
              temp.setHours(hoursSelect.getValue() + 12);
            } else {
              Integer value = hoursSelect.getValue();
              temp.setHours(value);
            }
            dispatchEvent(TimePickerCustomEvents.timeSelectionChanged(temp.getTime()));
          }
        });
  }

  /**
   * create.
   *
   * @param timePicker a {@link org.dominokit.domino.ui.timepicker.IsTimePicker} object
   * @param date a {@link java.util.Date} object
   * @return a {@link org.dominokit.domino.ui.timepicker.TimePickerSelectors} object
   */
  public static TimePickerSelectors create(IsTimePicker timePicker, Date date) {
    return new TimePickerSelectors(timePicker, date);
  }

  private void updateMinutesSeconds() {
    for (int i = 0; i < 60; i++) {
      this.minutesSelect.appendChild(SelectOption.create(String.valueOf(i), i, zeroPadded(i)));
      this.secondsSelect.appendChild(SelectOption.create(String.valueOf(i), i, zeroPadded(i)));
    }
  }

  private void updateAmPm() {
    this.ampmSelect
        .removeAllOptions()
        .appendChild(
            SelectOption.create(
                TimePeriod.AM.toString(),
                TimePeriod.AM,
                this.timePicker.getDateTimeFormatInfo().ampms()[0]))
        .appendChild(
            SelectOption.create(
                TimePeriod.PM.toString(),
                TimePeriod.PM,
                this.timePicker.getDateTimeFormatInfo().ampms()[1]));
  }

  private void updateHours() {
    this.hoursSelect.withPausedChangeListeners(
        field -> {
          field
              .clear(true)
              .removeAllOptions()
              .apply(
                  self -> {
                    if (this.timePicker.is24Hours()) {
                      for (int i = 0; i < 24; i++) {
                        self.appendChild(SelectOption.create(String.valueOf(i), i, zeroPadded(i)));
                      }
                    } else {
                      for (int i = 1; i <= 12; i++) {
                        self.appendChild(SelectOption.create(String.valueOf(i), i, zeroPadded(i)));
                      }
                    }
                  });
        });
  }

  private String zeroPadded(int hour) {
    if (hour < 10) {
      return "0" + hour;
    }
    return String.valueOf(hour);
  }

  /** {@inheritDoc} */
  @Override
  public void onUpdatePickerView(Date date) {
    this.date = date;
    this.ampmSelect.toggleDisplay(!this.timePicker.is24Hours());
    this.secondsSelect.toggleDisplay(this.timePicker.isShowSeconds());
    updateHours();
    if (this.timePicker.is24Hours()) {
      setHour(this.date.getHours());
    } else if (this.date.getHours() > 12) {
      setHour(this.date.getHours() - 12, TimePeriod.PM);
    } else {
      TimePeriod period = (this.date.getHours() - 12) >= 0 ? TimePeriod.PM : TimePeriod.AM;
      setHour(this.date.getHours(), period);
      this.ampmSelect.withValue(period);
    }
    this.minutesSelect.withPausedChangeListeners(
        field -> {
          field.selectByValue(this.date.getMinutes());
        });

    this.secondsSelect.withPausedChangeListeners(
        field -> {
          field.selectByValue(this.date.getSeconds());
        });
  }

  private void setHour(int hour) {
    setHour(hour, null);
  }

  private void setHour(int hour, TimePeriod timePeriod) {
    if (nonNull(timePeriod)) {
      ampmSelect.withPausedChangeListeners(field -> field.withValue(timePeriod));
    }
    this.hoursSelect.withPausedChangeListeners(
        field -> {
          field.clear(true);
          field.selectByValue(hour);
        });
  }

  /**
   * withHourSelect.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.timepicker.TimePickerSelectors} object
   */
  public TimePickerSelectors withHourSelect(
      ChildHandler<TimePickerSelectors, Select<Integer>> handler) {
    handler.apply(this, hoursSelect);
    return this;
  }

  /**
   * withMinuteSelect.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.timepicker.TimePickerSelectors} object
   */
  public TimePickerSelectors withMinuteSelect(
      ChildHandler<TimePickerSelectors, Select<Integer>> handler) {
    handler.apply(this, minutesSelect);
    return this;
  }

  /**
   * withSecondSelect.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.timepicker.TimePickerSelectors} object
   */
  public TimePickerSelectors withSecondSelect(
      ChildHandler<TimePickerSelectors, Select<Integer>> handler) {
    handler.apply(this, secondsSelect);
    return this;
  }

  /**
   * withAmPmSelect.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.timepicker.TimePickerSelectors} object
   */
  public TimePickerSelectors withAmPmSelect(
      ChildHandler<TimePickerSelectors, Select<TimePeriod>> handler) {
    handler.apply(this, ampmSelect);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
