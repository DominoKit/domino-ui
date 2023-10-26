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

import elemental2.dom.CustomEvent;
import elemental2.dom.HTMLDivElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.HasChangeListeners;
import org.dominokit.domino.ui.utils.LazyChild;
import org.gwtproject.i18n.shared.DateTimeFormat;
import org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo;
import org.gwtproject.i18n.shared.cldr.impl.DateTimeFormatInfo_factory;

/**
 * A time picker component that allows selecting and displaying time values.
 *
 * <p>The TimePicker can be configured to display time in either 12-hour or 24-hour format and
 * optionally show seconds.
 *
 * @see BaseDominoElement
 */
public class TimePicker extends BaseDominoElement<HTMLDivElement, TimePicker>
    implements IsTimePicker, TimePickerStyles, HasChangeListeners<TimePicker, Date> {

  private final Set<TimePickerViewListener> viewListeners = new HashSet<>();
  private final Set<TimeSelectionListener> timeSelectionListeners = new HashSet<>();
  private final Set<ChangeListener<? super Date>> changeListeners = new HashSet<>();
  private final DivElement root;
  private LazyChild<TimePickerHeader> header;
  private DivElement body;
  private LazyChild<DivElement> footer;
  private TimePickerSelectors selectors;
  private Date date;
  private DateTimeFormatInfo dateTimeFormatInfo;
  private boolean changeListenersPaused;
  private TimeStyle timeStyle = TimeStyle._12;
  private boolean showSeconds;

  /**
   * Constructs a new TimePicker instance with the current date and default date time format
   * information.
   */
  public TimePicker() {
    this(new Date(), DateTimeFormatInfo_factory.create());
  }

  /**
   * Constructs a new TimePicker instance with the specified date.
   *
   * @param date The initial date to be displayed in the time picker.
   */
  public TimePicker(Date date) {
    this(date, DateTimeFormatInfo_factory.create());
  }

  /**
   * Constructs a new TimePicker instance with the specified date time format information.
   *
   * @param dateTimeFormatInfo The DateTimeFormatInfo to be used for formatting time.
   */
  public TimePicker(DateTimeFormatInfo dateTimeFormatInfo) {
    this(new Date(), dateTimeFormatInfo);
  }

  /**
   * Constructs a new TimePicker instance with the specified date and date time format information.
   *
   * @param date The initial date to be displayed in the time picker.
   * @param dateTimeFormatInfo The DateTimeFormatInfo to be used for formatting time.
   */
  public TimePicker(Date date, DateTimeFormatInfo dateTimeFormatInfo) {
    this.date = date;
    this.dateTimeFormatInfo = dateTimeFormatInfo;
    this.root =
        div()
            .addCss(dui_time_picker)
            .apply(timePicker -> header = LazyChild.of(TimePickerHeader.create(this), timePicker))
            .appendChild(selectors = TimePickerSelectors.create(this, date))
            .appendChild(body = div().addCss(dui_timepicker_body))
            .apply(
                timePicker ->
                    footer = LazyChild.of(div().addCss(dui_timepicker_footer), timePicker));
    init(this);

    addEventListener(
        TimePickerCustomEvents.DUI_TIMEPICKER_TIME_SELECTION_CHANGED,
        evt -> {
          TimePickerCustomEvents.UpdateTimeEventData eventData =
              TimePickerCustomEvents.UpdateTimeEventData.of((CustomEvent<?>) evt);
          Date oldTime = this.date;
          Date updatedTime = new Date(eventData.getTimestamp());
          this.date = updatedTime;
          onTimeViewUpdate(updatedTime);
          triggerChangeListeners(oldTime, this.date);
          timeSelectionListeners.forEach(listener -> listener.onDaySelected(oldTime, this.date));
        });

    onTimeViewUpdate(this.date);
  }

  /**
   * Creates a new TimePicker instance with the specified date.
   *
   * @param date The initial date to be displayed in the time picker.
   * @return A new TimePicker instance.
   */
  public static TimePicker create(Date date) {
    return new TimePicker(date, DateTimeFormatInfo_factory.create());
  }

  /**
   * Creates a new TimePicker instance with the specified date time format information.
   *
   * @param dateTimeFormatInfo The DateTimeFormatInfo to be used for formatting time.
   * @return A new TimePicker instance.
   */
  public static TimePicker create(DateTimeFormatInfo dateTimeFormatInfo) {
    return new TimePicker(new Date(), dateTimeFormatInfo);
  }

  /**
   * Creates a new TimePicker instance with the specified date and date time format information.
   *
   * @param date The initial date to be displayed in the time picker.
   * @param dateTimeFormatInfo The DateTimeFormatInfo to be used for formatting time.
   * @return A new TimePicker instance.
   */
  public static TimePicker create(Date date, DateTimeFormatInfo dateTimeFormatInfo) {
    return new TimePicker(date, dateTimeFormatInfo);
  }

  /**
   * Creates a new TimePicker instance with the current date and default date time format
   * information.
   *
   * @return A new TimePicker instance.
   */
  public static TimePicker create() {
    return new TimePicker();
  }

  private void onTimeViewUpdate(Date updatedDate) {
    new ArrayList<>(viewListeners).forEach(listener -> listener.onUpdatePickerView(updatedDate));
  }

  /**
   * Gets the HTMLDivElement element representing the TimePicker.
   *
   * @return The root HTMLDivElement element.
   */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }

  /**
   * Gets the selected date and time.
   *
   * @return The selected date and time.
   */
  @Override
  public Date getDate() {
    return this.date;
  }

  /**
   * Sets the selected date and time.
   *
   * @param date The date and time to set.
   * @return This TimePicker instance.
   */
  public TimePicker setDate(Date date) {
    this.date = date;
    onTimeViewUpdate(this.date);
    return this;
  }

  /**
   * Gets the DateTimeFormatInfo used for formatting time.
   *
   * @return The DateTimeFormatInfo.
   */
  @Override
  public DateTimeFormatInfo getDateTimeFormatInfo() {
    return this.dateTimeFormatInfo;
  }

  /**
   * Sets the DateTimeFormatInfo used for formatting time.
   *
   * @param dateTimeFormatInfo The DateTimeFormatInfo to set.
   * @return This TimePicker instance.
   */
  public TimePicker setDateTimeFormatInfo(DateTimeFormatInfo dateTimeFormatInfo) {
    this.dateTimeFormatInfo = dateTimeFormatInfo;
    onTimeViewUpdate(this.date);
    return this;
  }

  /**
   * Binds a TimePickerViewListener to this TimePicker instance.
   *
   * @param listener The TimePickerViewListener to bind.
   */
  @Override
  public void bindTimePickerViewListener(TimePickerViewListener listener) {
    if (nonNull(listener)) {
      viewListeners.add(listener);
    }
  }

  /**
   * Unbinds a TimePickerViewListener from this TimePicker instance.
   *
   * @param listener The TimePickerViewListener to unbind.
   */
  @Override
  public void unbindTimePickerViewListener(TimePickerViewListener listener) {
    if (nonNull(listener)) {
      viewListeners.remove(listener);
    }
  }

  /**
   * Gets a set of TimeSelectionListeners.
   *
   * @return A set of TimeSelectionListeners.
   */
  @Override
  public Set<TimeSelectionListener> getTimeSelectionListeners() {
    return timeSelectionListeners;
  }

  /**
   * Adds a TimeSelectionListener to this TimePicker instance.
   *
   * @param listener The TimeSelectionListener to add.
   * @return This TimePicker instance.
   */
  public TimePicker addTimeSelectionListener(TimeSelectionListener listener) {
    if (nonNull(listener)) {
      this.timeSelectionListeners.add(listener);
    }
    return this;
  }

  /**
   * Removes a TimeSelectionListener from this TimePicker instance.
   *
   * @param listener The TimeSelectionListener to remove.
   * @return This TimePicker instance.
   */
  public TimePicker removeTimeSelectionListener(TimeSelectionListener listener) {
    if (nonNull(listener)) {
      this.timeSelectionListeners.remove(listener);
    }
    return this;
  }

  /**
   * Pauses change listeners to prevent triggering change events.
   *
   * @return This TimePicker instance.
   */
  @Override
  public TimePicker pauseChangeListeners() {
    this.changeListenersPaused = true;
    return this;
  }

  /**
   * Resumes change listeners to allow triggering change events.
   *
   * @return This TimePicker instance.
   */
  @Override
  public TimePicker resumeChangeListeners() {
    this.changeListenersPaused = false;
    return this;
  }

  /**
   * Toggles the state of change listeners.
   *
   * @param toggle True to pause change listeners, false to resume.
   * @return This TimePicker instance.
   */
  @Override
  public TimePicker togglePauseChangeListeners(boolean toggle) {
    this.changeListenersPaused = toggle;
    return this;
  }

  /**
   * Gets a set of ChangeListeners for monitoring value changes.
   *
   * @return A set of ChangeListeners.
   */
  @Override
  public Set<ChangeListener<? super Date>> getChangeListeners() {
    return changeListeners;
  }

  /**
   * Checks if change listeners are currently paused.
   *
   * @return True if change listeners are paused, false otherwise.
   */
  @Override
  public boolean isChangeListenersPaused() {
    return this.changeListenersPaused;
  }

  /**
   * Triggers change listeners when the selected date and time value changes.
   *
   * @param oldValue The old date and time value.
   * @param newValue The new date and time value.
   * @return This TimePicker instance.
   */
  @Override
  public TimePicker triggerChangeListeners(Date oldValue, Date newValue) {
    if (!this.changeListenersPaused) {
      this.changeListeners.forEach(
          changeListener -> changeListener.onValueChanged(oldValue, newValue));
    }
    return this;
  }

  /**
   * Gets the time style used for displaying time (12-hour or 24-hour format).
   *
   * @return The time style.
   */
  @Override
  public TimeStyle getTimeStyle() {
    return timeStyle;
  }

  /**
   * Sets the time style used for displaying time (12-hour or 24-hour format).
   *
   * @param timeStyle The time style to set.
   * @return This TimePicker instance.
   */
  public TimePicker setTimeStyle(TimeStyle timeStyle) {
    this.timeStyle = timeStyle;
    onTimeViewUpdate(this.date);
    return this;
  }

  /**
   * Checks if the selected time is in PM.
   *
   * @return True if the selected time is in PM, false if it's in AM.
   */
  @Override
  public boolean isPm() {
    return !is24Hours() && this.date.getHours() > 11;
  }

  /**
   * Checks if the time style is set to 24-hour format.
   *
   * @return True if the time style is set to 24-hour format, false for 12-hour format.
   */
  public boolean is24Hours() {
    return TimeStyle._24 == this.timeStyle;
  }

  /**
   * Checks if seconds are displayed in the time picker.
   *
   * @return True if seconds are displayed, false otherwise.
   */
  @Override
  public boolean isShowSeconds() {
    return this.showSeconds;
  }

  /**
   * Sets whether to display seconds in the time picker.
   *
   * @param showSeconds True to display seconds, false otherwise.
   * @return This TimePicker instance.
   */
  public TimePicker setShowSeconds(boolean showSeconds) {
    this.showSeconds = showSeconds;
    onTimeViewUpdate(this.date);
    return this;
  }

  /**
   * Formats the selected time according to the current settings.
   *
   * @return The formatted time as a string.
   */
  @Override
  public String formattedTime() {
    if (is24Hours()) {
      if (showSeconds) {
        return DateTimeFormat.getFormat(this.dateTimeFormatInfo.formatHour24MinuteSecond())
            .format(this.date);
      } else {
        return DateTimeFormat.getFormat(this.dateTimeFormatInfo.formatHour24Minute())
            .format(this.date);
      }
    } else {
      if (showSeconds) {
        return DateTimeFormat.getFormat(this.dateTimeFormatInfo.formatHour12MinuteSecond())
            .format(this.date);
      } else {
        return DateTimeFormat.getFormat(this.dateTimeFormatInfo.formatHour12Minute())
            .format(this.date);
      }
    }
  }

  /**
   * Retrieves the header element of the TimePicker.
   *
   * @return The header element.
   */
  public TimePicker withHeader() {
    header.get();
    return this;
  }

  /**
   * Configures the header element of the TimePicker using a ChildHandler.
   *
   * @param handler The ChildHandler to configure the header element.
   * @return This TimePicker instance.
   */
  public TimePicker withHeader(ChildHandler<TimePicker, TimePickerHeader> handler) {
    handler.apply(this, header.get());
    return this;
  }

  /**
   * Retrieves the footer element of the TimePicker.
   *
   * @return The footer element.
   */
  public TimePicker withFooter() {
    footer.get();
    return this;
  }

  /**
   * Configures the footer element of the TimePicker using a ChildHandler.
   *
   * @param handler The ChildHandler to configure the footer element.
   * @return This TimePicker instance.
   */
  public TimePicker withFooter(ChildHandler<TimePicker, DivElement> handler) {
    handler.apply(this, footer.get());
    return this;
  }

  /**
   * Configures the body of the TimePicker using a ChildHandler.
   *
   * @param handler The ChildHandler to configure the body.
   * @return This TimePicker instance.
   */
  public TimePicker withBody(ChildHandler<TimePicker, DivElement> handler) {
    handler.apply(this, body);
    return this;
  }

  /**
   * Configures the selectors of the TimePicker using a ChildHandler.
   *
   * @param handler The ChildHandler to configure the selectors.
   * @return This TimePicker instance.
   */
  public TimePicker withSelectors(ChildHandler<TimePicker, TimePickerSelectors> handler) {
    handler.apply(this, selectors);
    return this;
  }
}
