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
package org.dominokit.domino.ui.forms;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.menu.direction.DropDirection.BEST_MIDDLE_DOWN_UP;
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLInputElement;
import java.util.Date;
import java.util.Objects;
import org.dominokit.domino.ui.datepicker.*;
import org.dominokit.domino.ui.forms.validations.ValidationResult;
import org.dominokit.domino.ui.i18n.HasLabels;
import org.dominokit.domino.ui.i18n.TimePickerLabels;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.popover.Popover;
import org.dominokit.domino.ui.timepicker.TimeFormatter;
import org.dominokit.domino.ui.timepicker.TimePicker;
import org.dominokit.domino.ui.timepicker.TimePickerViewListener;
import org.dominokit.domino.ui.utils.*;
import org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo;
import org.gwtproject.i18n.shared.cldr.impl.DateTimeFormatInfo_factory;

/**
 * Represents a time input form field with the capability to pick a time.
 *
 * <p>Usage example:
 *
 * <pre>
 * TimeBox defaultTimeBox = TimeBox.create();
 * TimeBox labeledTimeBox = TimeBox.create("Choose a time:");
 * </pre>
 *
 * @see TextInputFormField
 * @see TimePickerViewListener
 */
public class TimeBox extends TextInputFormField<TimeBox, HTMLInputElement, Date>
    implements HasLabels<TimePickerLabels>, TimePickerViewListener {

  private final Popover popover;
  private final TimePicker timePicker;
  private Date value;

  private TimeFormatter formatter = TimeFormatter.DEFAULT;
  private boolean openOnFocus = false;
  private boolean openOnClick = true;
  private boolean silentSelection = false;
  private String pattern;
  private boolean parseStrict;

  /** Constructs a TimeBox with the current date set. */
  public TimeBox() {
    this(new Date());
  }

  /**
   * Constructs a TimeBox with the given label and current date set.
   *
   * @param label the label for the time box
   */
  public TimeBox(String label) {
    this(label, new Date());
  }

  /**
   * Constructs a TimeBox with the specified date set.
   *
   * @param date the initial date to be set
   */
  public TimeBox(Date date) {
    this(date, DateTimeFormatInfo_factory.create());
  }

  /**
   * Constructs a TimeBox with the specified label and date.
   *
   * @param label the label for the time box
   * @param date the initial date to be set
   */
  public TimeBox(String label, Date date) {
    this(label, date, DateTimeFormatInfo_factory.create());
  }

  /**
   * Constructs a TimeBox with the specified label, date, and date format information.
   *
   * @param label the label for the time box
   * @param date the initial date to be set
   * @param dateTimeFormatInfo the date format information
   */
  public TimeBox(String label, Date date, DateTimeFormatInfo dateTimeFormatInfo) {
    this(date, dateTimeFormatInfo);
    setLabel(label);
  }

  /**
   * Constructs a TimeBox with the specified date and date format information.
   *
   * @param date the initial date to be set
   * @param dateTimeFormatInfo the date format information
   */
  public TimeBox(Date date, DateTimeFormatInfo dateTimeFormatInfo) {
    this.value = date;
    this.timePicker = TimePicker.create(date, dateTimeFormatInfo);
    this.pattern = dateTimeFormatInfo.timeFormatFull();
    this.popover =
        Popover.create(this.getWrapperElement())
            .setOpenCondition(() -> isEnabled() && !isReadOnly())
            .setOpenOnClick(this.openOnClick)
            .setPosition(BEST_MIDDLE_DOWN_UP)
            .appendChild(this.timePicker)
            .addOnRemoveListener(
                popover -> {
                  withOpenOnFocusToggleListeners(false, field -> focus());
                });
    onDetached(mutationRecord -> popover.close());

    getInputElement()
        .onKeyDown(keyEvents -> keyEvents.onEnter(evt -> doOpen()).onSpace(evt -> doOpen()));
    addValidator(
        component -> {
          try {
            if (isEmptyIgnoreSpaces()) {
              return ValidationResult.valid();
            }
            getFormattedValue(getStringValue());
            return ValidationResult.valid();
          } catch (IllegalArgumentException e) {
            return ValidationResult.invalid(getLabels().timePickerInvalidTimeFormat());
          }
        });

    getInputElement()
        .addEventListener(
            "change",
            evt -> {
              String value = getStringValue();
              if (value.isEmpty()) {
                clear();
              } else {
                try {
                  withValue(getFormattedValue(value));
                  clearInvalid();
                } catch (IllegalArgumentException ignored) {
                  if (parseStrict) {
                    invalidate(getLabels().timePickerInvalidTimeFormat(value));
                  }
                  DomGlobal.console.warn(
                      "Unable to parse date value " + value + ", for pattern : " + pattern);
                }
              }
            });

    appendChild(
        PrimaryAddOn.of(
            getConfig()
                .defaultDateBoxIcon()
                .get()
                .clickable()
                .addClickListener(
                    evt -> {
                      evt.stopPropagation();
                      doOpen();
                    })));

    getInputElement()
        .addEventListener(
            "focus",
            evt -> {
              if (openOnFocus) {
                doOpen();
              }
            })
        .addEventListener(
            "click",
            evt -> {
              if (openOnClick) {
                doOpen();
              }
            });
    this.timePicker.bindTimePickerViewListener(this);
    setStringValue(value, this.timePicker.getDateTimeFormatInfo());
  }

  /**
   * Factory method to create a new instance of {@link TimeBox} with the current date set.
   *
   * @return a new instance of TimeBox
   */
  public static TimeBox create() {
    return new TimeBox(new Date());
  }

  /**
   * Factory method to create a new instance of {@link TimeBox} with the specified label and current
   * date set.
   *
   * @param label the label for the time box
   * @return a new instance of TimeBox
   */
  public static TimeBox create(String label) {
    return new TimeBox(label, new Date());
  }

  /**
   * Factory method to create a new instance of {@link TimeBox} with the specified date.
   *
   * @param date the date to set
   * @return a new instance of TimeBox
   */
  public static TimeBox create(Date date) {
    return new TimeBox(date, DateTimeFormatInfo_factory.create());
  }

  /**
   * Factory method to create a new instance of {@link TimeBox} with the specified label and date.
   *
   * @param label the label for the time box
   * @param date the date to set
   * @return a new instance of TimeBox
   */
  public static TimeBox create(String label, Date date) {
    return new TimeBox(label, date, DateTimeFormatInfo_factory.create());
  }

  /**
   * Factory method to create a new instance of {@link TimeBox} with the specified date and date
   * format information.
   *
   * @param date the date to set
   * @param dateTimeFormatInfo the date format information
   * @return a new instance of TimeBox
   */
  public static TimeBox create(Date date, DateTimeFormatInfo dateTimeFormatInfo) {
    return new TimeBox(date, dateTimeFormatInfo);
  }

  /**
   * Factory method to create a new instance of {@link TimeBox} with the specified date format
   * information.
   *
   * @param dateTimeFormatInfo the date format information
   * @return a new instance of TimeBox
   */
  public static TimeBox create(DateTimeFormatInfo dateTimeFormatInfo) {
    return new TimeBox(new Date(), dateTimeFormatInfo);
  }

  /**
   * Factory method to create a new instance of {@link TimeBox} with the specified label and date
   * format information.
   *
   * @param label the label for the time box
   * @param dateTimeFormatInfo the date format information
   * @return a new instance of TimeBox
   */
  public static TimeBox create(String label, DateTimeFormatInfo dateTimeFormatInfo) {
    return new TimeBox(label, new Date(), dateTimeFormatInfo);
  }

  /**
   * Factory method to create a new instance of {@link TimeBox} with the specified label, date, and
   * date format information.
   *
   * @param label the label for the time box
   * @param date the date to set
   * @param dateTimeFormatInfo the date format information
   * @return a new instance of TimeBox
   */
  public static TimeBox create(String label, Date date, DateTimeFormatInfo dateTimeFormatInfo) {
    return new TimeBox(label, date, dateTimeFormatInfo);
  }

  private void doOpen() {
    if (isEnabled() && !isReadOnly()) {
      popover.open();
    }
  }

  /**
   * Closes the associated popover.
   *
   * @return the current instance of {@link TimeBox}
   */
  public TimeBox close() {
    popover.close();
    return this;
  }

  /**
   * Sets the pattern for time formatting.
   *
   * @param pattern the {@link Pattern} to set
   * @return the current instance of {@link TimeBox}
   */
  public TimeBox setPattern(Pattern pattern) {
    switch (pattern) {
      case FULL:
        return setPattern(this.timePicker.getDateTimeFormatInfo().timeFormatFull());
      case LONG:
        return setPattern(this.timePicker.getDateTimeFormatInfo().timeFormatLong());
      case MEDIUM:
        return setPattern(this.timePicker.getDateTimeFormatInfo().timeFormatMedium());
      case SHORT:
        return setPattern(this.timePicker.getDateTimeFormatInfo().timeFormatShort());
      default:
        return this;
    }
  }

  /**
   * Sets the custom pattern for time formatting.
   *
   * @param pattern the custom pattern string
   * @return the current instance of {@link TimeBox}
   */
  public TimeBox setPattern(String pattern) {
    if (!Objects.equals(this.pattern, pattern)) {
      this.pattern = pattern;
      setStringValue(value, this.timePicker.getDateTimeFormatInfo());
    }
    return this;
  }

  private void setStringValue(Date date, DateTimeFormatInfo dateTimeFormatInfo) {
    if (nonNull(date))
      this.getInputElement().element().value = getFormatted(date, dateTimeFormatInfo);
    else this.getInputElement().element().value = "";
  }

  private String getFormatted(Date date, DateTimeFormatInfo dateTimeFormatInfo) {
    return formatter.format(this.pattern, dateTimeFormatInfo, date);
  }

  @Override
  protected DominoElement<HTMLInputElement> createInputElement(String type) {
    return input(type).addCss(dui_field_input).toDominoElement();
  }

  private Date getFormattedValue(String value) throws IllegalArgumentException {
    DateTimeFormatInfo dateTimeFormatInfo = this.timePicker.getDateTimeFormatInfo();
    if (this.parseStrict) {
      return formatter.parseStrict(this.pattern, dateTimeFormatInfo, value);
    }
    return formatter.parse(this.pattern, dateTimeFormatInfo, value);
  }

  /**
   * Sets the position of the popover.
   *
   * @param position the {@link DropDirection} position
   * @return the current instance of {@link TimeBox}
   */
  public TimeBox setPopoverPosition(DropDirection position) {
    if (nonNull(position)) {
      this.popover.setPosition(position);
    }
    return this;
  }

  /**
   * Temporarily toggles the "open on focus" state and applies the given handler.
   *
   * @param toggle desired temporary state
   * @param handler the handler to be applied
   * @return the current instance of {@link TimeBox}
   */
  public TimeBox withOpenOnFocusToggleListeners(boolean toggle, Handler<TimeBox> handler) {
    boolean oldState = this.openOnFocus;
    this.openOnFocus = toggle;
    try {
      handler.apply(this);
    } finally {
      this.openOnFocus = oldState;
    }
    return this;
  }

  /**
   * Temporarily toggles the "open on focus" state, applies the asynchronous handler, and then
   * reverts to the original state once the handler has completed.
   *
   * @param toggle desired temporary state
   * @param handler the asynchronous handler to be applied
   * @return the current instance of {@link TimeBox}
   */
  public TimeBox withPausedOpenOnFocusListeners(boolean toggle, AsyncHandler<TimeBox> handler) {
    boolean oldState = this.openOnFocus;
    this.openOnFocus = toggle;
    try {
      handler.apply(this, () -> this.openOnFocus = oldState);
    } catch (Exception e) {
      this.openOnFocus = oldState;
      throw e;
    }
    return this;
  }

  /**
   * Temporarily toggles the silent time selection and applies the given handler.
   *
   * @param toggle desired temporary state
   * @param handler the handler to be applied
   * @return the current instance of {@link TimeBox}
   */
  private TimeBox withTimeSelectionToggleListeners(boolean toggle, Handler<TimeBox> handler) {
    boolean oldState = this.silentSelection;
    this.silentSelection = toggle;
    try {
      handler.apply(this);
    } finally {
      this.silentSelection = oldState;
    }
    return this;
  }

  /**
   * Sets the value of the TimeBox and updates the visual display accordingly.
   *
   * @param value the date value to be set
   */
  @Override
  protected void doSetValue(Date value) {
    this.value = value;
    if (nonNull(value)) {
      updateStringValue();
    } else {
      getInputElement().element().value = "";
    }
    withTimeSelectionToggleListeners(
        false,
        field -> {
          if (nonNull(this.value)) {
            this.timePicker.setDate(this.value);
          }
        });
  }

  /**
   * Gets the formatted string representation of the current time value.
   *
   * @return the formatted time string
   */
  private void updateStringValue() {
    getInputElement().element().value =
        getFormatted(this.value, this.timePicker.getDateTimeFormatInfo());
  }

  /**
   * Retrieves the string representation of the current value in the input field.
   *
   * @return the string value
   */
  @Override
  public String getStringValue() {
    return getInputElement().element().value;
  }

  /**
   * Retrieves the type of the input field.
   *
   * @return the string "text"
   */
  @Override
  public String getType() {
    return "text";
  }

  /**
   * Retrieves the current date value set in the TimeBox.
   *
   * @return the current date value
   */
  @Override
  public Date getValue() {
    return this.value;
  }

  /**
   * Handles changes in time selection.
   *
   * @param date the newly selected date
   */
  @Override
  public void onTimeSelectionChanged(Date date) {
    if (!isDisabled() && !isReadOnly()) {
      if (silentSelection == false) {
        clearInvalid();
        withValue(date);
      }
    }
  }

  /**
   * Retrieves the current date-time format information.
   *
   * @return the current {@link DateTimeFormatInfo}
   */
  public DateTimeFormatInfo getDateTimeFormat() {
    return this.timePicker.getDateTimeFormatInfo();
  }

  /**
   * Sets the date-time format information for the TimeBox.
   *
   * @param dateTimeFormatInfo the {@link DateTimeFormatInfo} to set
   * @return the current instance of {@link TimeBox}
   */
  public TimeBox setDateTimeFormat(DateTimeFormatInfo dateTimeFormatInfo) {
    this.timePicker.setDateTimeFormatInfo(dateTimeFormatInfo);
    return this;
  }

  /**
   * Handles changes in the date-time format information and updates the string value.
   *
   * @param dateTimeFormatInfo the updated {@link DateTimeFormatInfo}
   */
  @Override
  public void onDateTimeFormatInfoChanged(DateTimeFormatInfo dateTimeFormatInfo) {
    updateStringValue();
  }

  /**
   * Checks if the TimeBox is set to open on focus.
   *
   * @return true if set to open on focus, false otherwise.
   */
  public boolean isOpenOnFocus() {
    return openOnFocus;
  }

  /**
   * Configures the TimeBox to open on focus.
   *
   * @param openOnFocus true to open on focus, false otherwise.
   * @return the current instance of {@link TimeBox}
   */
  public TimeBox setOpenOnFocus(boolean openOnFocus) {
    this.openOnFocus = openOnFocus;
    return this;
  }

  /**
   * Checks if parsing is strict.
   *
   * @return true if strict parsing, false otherwise.
   */
  public boolean isParseStrict() {
    return parseStrict;
  }

  /**
   * Configures whether parsing should be strict.
   *
   * @param parseStrict true for strict parsing, false otherwise.
   * @return the current instance of {@link TimeBox}
   */
  public TimeBox setParseStrict(boolean parseStrict) {
    this.parseStrict = parseStrict;
    return this;
  }

  /**
   * Checks if the TimeBox is set to open on click.
   *
   * @return true if the TimeBox opens on click, false otherwise.
   */
  public boolean isOpenOnClick() {
    return openOnClick;
  }

  /**
   * Sets the behavior of the TimeBox to open on click or not.
   *
   * @param openOnClick true if the TimeBox should open on click, false otherwise.
   * @return the current instance of {@link TimeBox}
   */
  public TimeBox setOpenOnClick(boolean openOnClick) {
    this.openOnClick = openOnClick;
    this.popover.setOpenOnClick(this.openOnClick);
    return this;
  }

  /**
   * Applies a handler to the {@link TimePicker} associated with this TimeBox.
   *
   * @param handler the handler to be applied to the {@link TimePicker}
   * @return the current instance of {@link TimeBox}
   */
  public TimeBox withTimePicker(ChildHandler<TimeBox, TimePicker> handler) {
    handler.apply(this, this.timePicker);
    return this;
  }

  /**
   * Applies a handler to the {@link Popover} associated with this TimeBox.
   *
   * @param handler the handler to be applied to the {@link Popover}
   * @return the current instance of {@link TimeBox}
   */
  public TimeBox withPopover(ChildHandler<TimeBox, Popover> handler) {
    handler.apply(this, this.popover);
    return this;
  }
}
