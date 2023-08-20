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

/** TimePicker class. */
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

  /** Constructor for TimePicker. */
  public TimePicker() {
    this(new Date(), DateTimeFormatInfo_factory.create());
  }

  /**
   * Constructor for TimePicker.
   *
   * @param date a {@link java.util.Date} object
   */
  public TimePicker(Date date) {
    this(date, DateTimeFormatInfo_factory.create());
  }

  /**
   * Constructor for TimePicker.
   *
   * @param dateTimeFormatInfo a {@link org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo} object
   */
  public TimePicker(DateTimeFormatInfo dateTimeFormatInfo) {
    this(new Date(), dateTimeFormatInfo);
  }

  /**
   * Constructor for TimePicker.
   *
   * @param date a {@link java.util.Date} object
   * @param dateTimeFormatInfo a {@link org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo} object
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
   * create.
   *
   * @param date a {@link java.util.Date} object
   * @return a {@link org.dominokit.domino.ui.timepicker.TimePicker} object
   */
  public static TimePicker create(Date date) {
    return new TimePicker(date, DateTimeFormatInfo_factory.create());
  }

  /**
   * create.
   *
   * @param dateTimeFormatInfo a {@link org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo} object
   * @return a {@link org.dominokit.domino.ui.timepicker.TimePicker} object
   */
  public static TimePicker create(DateTimeFormatInfo dateTimeFormatInfo) {
    return new TimePicker(new Date(), dateTimeFormatInfo);
  }

  /**
   * create.
   *
   * @param date a {@link java.util.Date} object
   * @param dateTimeFormatInfo a {@link org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo} object
   * @return a {@link org.dominokit.domino.ui.timepicker.TimePicker} object
   */
  public static TimePicker create(Date date, DateTimeFormatInfo dateTimeFormatInfo) {
    return new TimePicker(date, dateTimeFormatInfo);
  }

  /**
   * create.
   *
   * @return a {@link org.dominokit.domino.ui.timepicker.TimePicker} object
   */
  public static TimePicker create() {
    return new TimePicker();
  }

  private void onTimeViewUpdate(Date updatedDate) {
    new ArrayList<>(viewListeners).forEach(listener -> listener.onUpdatePickerView(updatedDate));
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }

  /** {@inheritDoc} */
  @Override
  public Date getDate() {
    return this.date;
  }

  /**
   * Setter for the field <code>date</code>.
   *
   * @param date a {@link java.util.Date} object
   * @return a {@link org.dominokit.domino.ui.timepicker.TimePicker} object
   */
  public TimePicker setDate(Date date) {
    this.date = date;
    onTimeViewUpdate(this.date);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public DateTimeFormatInfo getDateTimeFormatInfo() {
    return this.dateTimeFormatInfo;
  }

  /**
   * Setter for the field <code>dateTimeFormatInfo</code>.
   *
   * @param dateTimeFormatInfo a {@link org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo} object
   * @return a {@link org.dominokit.domino.ui.timepicker.TimePicker} object
   */
  public TimePicker setDateTimeFormatInfo(DateTimeFormatInfo dateTimeFormatInfo) {
    this.dateTimeFormatInfo = dateTimeFormatInfo;
    onTimeViewUpdate(this.date);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public void bindTimePickerViewListener(TimePickerViewListener listener) {
    if (nonNull(listener)) {
      viewListeners.add(listener);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void unbindTimePickerViewListener(TimePickerViewListener listener) {
    if (nonNull(listener)) {
      viewListeners.remove(listener);
    }
  }

  /** {@inheritDoc} */
  @Override
  public Set<TimeSelectionListener> getTimeSelectionListeners() {
    return timeSelectionListeners;
  }

  /**
   * addTimeSelectionListener.
   *
   * @param listener a {@link org.dominokit.domino.ui.timepicker.TimeSelectionListener} object
   * @return a {@link org.dominokit.domino.ui.timepicker.TimePicker} object
   */
  public TimePicker addTimeSelectionListener(TimeSelectionListener listener) {
    if (nonNull(listener)) {
      this.timeSelectionListeners.add(listener);
    }
    return this;
  }

  /**
   * removeTimeSelectionListener.
   *
   * @param listener a {@link org.dominokit.domino.ui.timepicker.TimeSelectionListener} object
   * @return a {@link org.dominokit.domino.ui.timepicker.TimePicker} object
   */
  public TimePicker removeTimeSelectionListener(TimeSelectionListener listener) {
    if (nonNull(listener)) {
      this.timeSelectionListeners.remove(listener);
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public TimePicker pauseChangeListeners() {
    this.changeListenersPaused = true;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public TimePicker resumeChangeListeners() {
    this.changeListenersPaused = false;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public TimePicker togglePauseChangeListeners(boolean toggle) {
    this.changeListenersPaused = toggle;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Set<ChangeListener<? super Date>> getChangeListeners() {
    return changeListeners;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isChangeListenersPaused() {
    return this.changeListenersPaused;
  }

  /** {@inheritDoc} */
  @Override
  public TimePicker triggerChangeListeners(Date oldValue, Date newValue) {
    if (!this.changeListenersPaused) {
      this.changeListeners.forEach(
          changeListener -> changeListener.onValueChanged(oldValue, newValue));
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public TimeStyle getTimeStyle() {
    return timeStyle;
  }

  /**
   * Setter for the field <code>timeStyle</code>.
   *
   * @param timeStyle a {@link org.dominokit.domino.ui.timepicker.TimeStyle} object
   * @return a {@link org.dominokit.domino.ui.timepicker.TimePicker} object
   */
  public TimePicker setTimeStyle(TimeStyle timeStyle) {
    this.timeStyle = timeStyle;
    onTimeViewUpdate(this.date);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isPm() {
    return !is24Hours() && this.date.getHours() > 11;
  }

  /**
   * is24Hours.
   *
   * @return a boolean
   */
  public boolean is24Hours() {
    return TimeStyle._24 == this.timeStyle;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isShowSeconds() {
    return this.showSeconds;
  }

  /**
   * Setter for the field <code>showSeconds</code>.
   *
   * @param showSeconds a boolean
   * @return a {@link org.dominokit.domino.ui.timepicker.TimePicker} object
   */
  public TimePicker setShowSeconds(boolean showSeconds) {
    this.showSeconds = showSeconds;
    onTimeViewUpdate(this.date);
    return this;
  }

  /** {@inheritDoc} */
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
   * withHeader.
   *
   * @return a {@link org.dominokit.domino.ui.timepicker.TimePicker} object
   */
  public TimePicker withHeader() {
    header.get();
    return this;
  }

  /**
   * withHeader.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.timepicker.TimePicker} object
   */
  public TimePicker withHeader(ChildHandler<TimePicker, TimePickerHeader> handler) {
    handler.apply(this, header.get());
    return this;
  }

  /**
   * withFooter.
   *
   * @return a {@link org.dominokit.domino.ui.timepicker.TimePicker} object
   */
  public TimePicker withFooter() {
    footer.get();
    return this;
  }

  /**
   * withFooter.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.timepicker.TimePicker} object
   */
  public TimePicker withFooter(ChildHandler<TimePicker, DivElement> handler) {
    handler.apply(this, footer.get());
    return this;
  }

  /**
   * withBody.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.timepicker.TimePicker} object
   */
  public TimePicker withBody(ChildHandler<TimePicker, DivElement> handler) {
    handler.apply(this, body);
    return this;
  }

  /**
   * withSelectors.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.timepicker.TimePicker} object
   */
  public TimePicker withSelectors(ChildHandler<TimePicker, TimePickerSelectors> handler) {
    handler.apply(this, selectors);
    return this;
  }
}
