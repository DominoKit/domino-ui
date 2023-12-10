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
import org.dominokit.domino.ui.i18n.CalendarLabels;
import org.dominokit.domino.ui.i18n.HasLabels;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.popover.Popover;
import org.dominokit.domino.ui.utils.*;
import org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo;
import org.gwtproject.i18n.shared.cldr.impl.DateTimeFormatInfo_factory;

/**
 * DateBox is a custom form field for date input with various configuration options. It utilizes a
 * popover with a calendar picker for selecting dates.
 *
 * <p>Usage example:
 *
 * <pre>
 * DateBox dateBox = DateBox.create("Birth date);
 * </pre>
 */
public class DateBox extends TextInputFormField<DateBox, HTMLInputElement, Date>
    implements HasLabels<CalendarLabels>, CalendarViewListener {

  private final Popover popover;
  private final Calendar calendar;
  private Date value;

  private DateFormatter formatter = DateFormatter.DEFAULT;
  private boolean openOnFocus = false;
  private boolean openOnClick = true;
  private boolean silentSelection = false;
  private String pattern;
  private boolean parseStrict;

  /** Creates a new DateBox with the current date and default configuration. */
  public DateBox() {
    this(new Date(), new CalendarInitConfig());
  }

  /**
   * Creates a new DateBox with a label and the current date using default configuration.
   *
   * @param label The label for the DateBox
   */
  public DateBox(String label) {
    this(label, new Date(), new CalendarInitConfig());
  }

  /**
   * Creates a new DateBox with the specified date using default configuration.
   *
   * @param date The initial date value for the DateBox
   */
  public DateBox(Date date) {
    this(date, new CalendarInitConfig());
  }

  /**
   * Creates a new DateBox with a label and the specified date using default configuration.
   *
   * @param label The label for the DateBox
   * @param date The initial date value for the DateBox
   */
  public DateBox(String label, Date date) {
    this(label, date, new CalendarInitConfig());
  }

  /**
   * Creates a new DateBox with the specified date and calendar initialization configuration.
   *
   * @param date The initial date value for the DateBox
   * @param calendarInitConfig The calendar initialization configuration
   */
  public DateBox(Date date, CalendarInitConfig calendarInitConfig) {
    this(date, DateTimeFormatInfo_factory.create(), calendarInitConfig);
  }

  /**
   * Creates a new DateBox with a label, the specified date, and calendar initialization
   * configuration.
   *
   * @param label The label for the DateBox
   * @param date The initial date value for the DateBox
   * @param calendarInitConfig The calendar initialization configuration
   */
  public DateBox(String label, Date date, CalendarInitConfig calendarInitConfig) {
    this(label, date, DateTimeFormatInfo_factory.create(), calendarInitConfig);
  }

  /**
   * Creates a new DateBox with a label, the specified date, date-time format information, and
   * calendar initialization configuration.
   *
   * @param label The label for the DateBox
   * @param date The initial date value for the DateBox
   * @param dateTimeFormatInfo The date-time format information
   * @param calendarInitConfig The calendar initialization configuration
   */
  public DateBox(
      String label,
      Date date,
      DateTimeFormatInfo dateTimeFormatInfo,
      CalendarInitConfig calendarInitConfig) {
    this(date, dateTimeFormatInfo, calendarInitConfig);
    setLabel(label);
  }

  /**
   * Creates a new DateBox with the specified date, date-time format information, and calendar
   * initialization configuration.
   *
   * @param date The initial date value for the DateBox
   * @param dateTimeFormatInfo The date-time format information
   * @param calendarInitConfig The calendar initialization configuration
   */
  public DateBox(
      Date date, DateTimeFormatInfo dateTimeFormatInfo, CalendarInitConfig calendarInitConfig) {
    this.value = date;
    this.calendar = Calendar.create(date, dateTimeFormatInfo, calendarInitConfig);
    this.pattern = dateTimeFormatInfo.dateFormatFull();
    this.popover =
        Popover.create(this.getWrapperElement())
            .setOpenCondition(() -> isEnabled() && !isReadOnly())
            .setOpenOnClick(this.openOnClick)
            .setPosition(BEST_MIDDLE_DOWN_UP)
            .appendChild(this.calendar)
            .addOnRemoveListener(
                popover -> {
                  withOpenOnFocusToggleListeners(false, field -> focus());
                });
    onDetached(mutationRecord -> popover.close());

    getInputElement()
        .onKeyPress(keyEvents -> keyEvents.onEnter(evt -> doOpen()).onSpace(evt -> doOpen()));
    addValidator(
        component -> {
          try {
            if (isEmptyIgnoreSpaces()) {
              return ValidationResult.valid();
            }
            getFormattedValue(getStringValue());
            return ValidationResult.valid();
          } catch (IllegalArgumentException e) {
            return ValidationResult.invalid(getLabels().calendarInvalidDateFormat());
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
                    invalidate("Unable to parse date value " + value);
                  }
                  DomGlobal.console.warn("Unable to parse date value " + value);
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
    this.calendar.bindCalenderViewListener(this);
    setStringValue(value, this.calendar.getDateTimeFormatInfo());
  }

  /**
   * Creates a new DateBox with the current date and default configuration.
   *
   * @return A new DateBox instance
   */
  public static DateBox create() {
    return new DateBox(new Date(), new CalendarInitConfig());
  }

  /**
   * Creates a new DateBox with a label and the current date using default configuration.
   *
   * @param label The label for the DateBox
   * @return A new DateBox instance
   */
  public static DateBox create(String label) {
    return new DateBox(label, new Date(), new CalendarInitConfig());
  }

  /**
   * Creates a new DateBox with the specified date using default configuration.
   *
   * @param date The initial date value for the DateBox
   * @return A new DateBox instance
   */
  public static DateBox create(Date date) {
    return new DateBox(date, new CalendarInitConfig());
  }

  /**
   * Creates a new DateBox with a label and the specified date using default configuration.
   *
   * @param label The label for the DateBox
   * @param date The initial date value for the DateBox
   * @return A new DateBox instance
   */
  public static DateBox create(String label, Date date) {
    return new DateBox(label, date, new CalendarInitConfig());
  }

  /**
   * Creates a new DateBox with the specified date and calendar initialization configuration.
   *
   * @param date The initial date value for the DateBox
   * @param calendarInitConfig The calendar initialization configuration
   * @return A new DateBox instance
   */
  public static DateBox create(Date date, CalendarInitConfig calendarInitConfig) {
    return new DateBox(date, DateTimeFormatInfo_factory.create(), calendarInitConfig);
  }

  /**
   * Creates a new DateBox with a label, the specified date, and calendar initialization
   * configuration.
   *
   * @param label The label for the DateBox
   * @param date The initial date value for the DateBox
   * @param calendarInitConfig The calendar initialization configuration
   * @return A new DateBox instance
   */
  public static DateBox create(String label, Date date, CalendarInitConfig calendarInitConfig) {
    return new DateBox(label, date, DateTimeFormatInfo_factory.create(), calendarInitConfig);
  }

  /**
   * Creates a new DateBox with a specified date, date-time format information, and calendar
   * initialization configuration.
   *
   * @param date The initial date value for the DateBox
   * @param dateTimeFormatInfo The date-time format information
   * @param calendarInitConfig The calendar initialization configuration
   * @return A new DateBox instance
   */
  public static DateBox create(
      Date date, DateTimeFormatInfo dateTimeFormatInfo, CalendarInitConfig calendarInitConfig) {
    return new DateBox(date, dateTimeFormatInfo, calendarInitConfig);
  }

  /**
   * Creates a new DateBox with default date-time format information and the current date.
   *
   * @param dateTimeFormatInfo The date-time format information
   * @return A new DateBox instance
   */
  public static DateBox create(DateTimeFormatInfo dateTimeFormatInfo) {
    return new DateBox(new Date(), dateTimeFormatInfo, new CalendarInitConfig());
  }

  /**
   * Creates a new DateBox with a label, default date-time format information, and the current date.
   *
   * @param label The label for the DateBox
   * @param dateTimeFormatInfo The date-time format information
   * @return A new DateBox instance
   */
  public static DateBox create(String label, DateTimeFormatInfo dateTimeFormatInfo) {
    return new DateBox(label, new Date(), dateTimeFormatInfo, new CalendarInitConfig());
  }

  /**
   * Creates a new DateBox with a label, specified date, date-time format information, and calendar
   * initialization configuration.
   *
   * @param label The label for the DateBox
   * @param date The initial date value for the DateBox
   * @param dateTimeFormatInfo The date-time format information
   * @param calendarInitConfig The calendar initialization configuration
   * @return A new DateBox instance
   */
  public static DateBox create(
      String label,
      Date date,
      DateTimeFormatInfo dateTimeFormatInfo,
      CalendarInitConfig calendarInitConfig) {
    return new DateBox(label, date, dateTimeFormatInfo, calendarInitConfig);
  }

  /** Opens the popover associated with this DateBox if it is enabled and not read-only. */
  private void doOpen() {
    if (isEnabled() && !isReadOnly()) {
      popover.open();
    }
  }

  /**
   * Closes the popover associated with this DateBox.
   *
   * @return This DateBox instance with the popover closed
   */
  public DateBox close() {
    popover.close();
    return this;
  }

  /**
   * Sets the date pattern for formatting the displayed date value based on a predefined pattern.
   *
   * <p>The predefined patterns are:
   *
   * <ul>
   *   <li>FULL: Full date pattern
   *   <li>LONG: Long date pattern
   *   <li>MEDIUM: Medium date pattern
   *   <li>SHORT: Short date pattern
   * </ul>
   *
   * @param pattern The predefined pattern for formatting the date value
   * @return This DateBox instance with the new date pattern applied
   */
  public DateBox setPattern(Pattern pattern) {
    switch (pattern) {
      case FULL:
        return setPattern(this.calendar.getDateTimeFormatInfo().dateFormatFull());
      case LONG:
        return setPattern(this.calendar.getDateTimeFormatInfo().dateFormatLong());
      case MEDIUM:
        return setPattern(this.calendar.getDateTimeFormatInfo().dateFormatMedium());
      case SHORT:
        return setPattern(this.calendar.getDateTimeFormatInfo().dateFormatShort());
      default:
        return this;
    }
  }

  /**
   * Sets the custom date pattern for formatting the displayed date value.
   *
   * <p>The date pattern should follow the conventions of the date format used in the {@link
   * DateTimeFormatInfo} associated with this DateBox.
   *
   * @param pattern The custom date pattern (e.g., "MM/dd/yyyy")
   * @return This DateBox instance with the new custom date pattern applied
   */
  @Override
  public DateBox setPattern(String pattern) {
    if (!Objects.equals(this.pattern, pattern)) {
      this.pattern = pattern;
      setStringValue(value, this.calendar.getDateTimeFormatInfo());
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
    DateTimeFormatInfo dateTimeFormatInfo = this.calendar.getDateTimeFormatInfo();
    if (this.parseStrict) {
      return formatter.parseStrict(this.pattern, dateTimeFormatInfo, value);
    }
    return formatter.parse(this.pattern, dateTimeFormatInfo, value);
  }

  /**
   * Sets the position of the popover when it opens.
   *
   * @param position The desired position of the popover
   * @return This DateBox instance with the popover position set
   */
  public DateBox setPopoverPosition(DropDirection position) {
    if (nonNull(position)) {
      this.popover.setPosition(position);
    }
    return this;
  }

  /**
   * Adds a listener to toggle the "openOnFocus" behavior of this DateBox when it receives focus.
   *
   * @param toggle If true, the "openOnFocus" behavior will be enabled; if false, it will be
   *     disabled.
   * @param handler A handler that will be invoked when the toggle state changes.
   * @return This DateBox instance with the listener added.
   */
  public DateBox withOpenOnFocusToggleListeners(boolean toggle, Handler<DateBox> handler) {
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
   * Adds a listener to toggle the "openOnFocus" behavior of this DateBox when it receives focus,
   * with the option to pause the toggle state temporarily.
   *
   * @param toggle If true, the "openOnFocus" behavior will be enabled; if false, it will be
   *     disabled.
   * @param handler An asynchronous handler that will be invoked when the toggle state changes.
   * @return This DateBox instance with the listener added.
   * @throws Exception If an exception occurs during the asynchronous handler execution.
   */
  public DateBox withPausedOpenOnFocusListeners(boolean toggle, AsyncHandler<DateBox> handler) {
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

  private DateBox withDateSelectionToggleListeners(boolean toggle, Handler<DateBox> handler) {
    boolean oldState = this.silentSelection;
    this.silentSelection = toggle;
    try {
      handler.apply(this);
    } finally {
      this.silentSelection = oldState;
    }
    return this;
  }

  @Override
  protected void doSetValue(Date value) {
    this.value = value;
    if (nonNull(value)) {
      updateStringValue();
    } else {
      getInputElement().element().value = "";
    }
    withDateSelectionToggleListeners(
        false,
        field -> {
          if (nonNull(this.value)) {
            this.calendar.setDate(this.value);
          }
        });
  }

  private void updateStringValue() {
    getInputElement().element().value =
        getFormatted(this.value, this.calendar.getDateTimeFormatInfo());
  }

  /**
   * {@inheritDoc} Returns the string value of the underlying input element.
   *
   * @return The string value of the input element.
   */
  @Override
  public String getStringValue() {
    return getInputElement().element().value;
  }

  /**
   * {@inheritDoc} Returns the type of the input element, which is always "text" for a DateBox.
   *
   * @return The string "text."
   */
  @Override
  public String getType() {
    return "text";
  }

  /**
   * {@inheritDoc} Returns the selected date value of this DateBox.
   *
   * @return The selected date value.
   */
  @Override
  public Date getValue() {
    return this.value;
  }

  /**
   * {@inheritDoc} Called when the date selection in the calendar view changes. It clears any
   * validation errors, sets the selected date value, and closes the popover.
   *
   * @param date The selected date.
   */
  @Override
  public void onDateSelectionChanged(Date date) {
    if (!isDisabled() && !isReadOnly()) {
      if (silentSelection == false) {
        clearInvalid();
        withValue(date);
      }
      this.popover.close();
    }
  }

  /**
   * Retrieves the date-time format information associated with this DateBox.
   *
   * @return The date-time format information
   */
  public DateTimeFormatInfo getDateTimeFormat() {
    return this.calendar.getDateTimeFormatInfo();
  }

  /**
   * Sets the date-time format information for this DateBox.
   *
   * @param dateTimeFormatInfo The date-time format information to set
   * @return This DateBox instance with the new date-time format information
   */
  public DateBox setDateTimeFormat(DateTimeFormatInfo dateTimeFormatInfo) {
    this.calendar.setDateTimeFormatInfo(dateTimeFormatInfo);
    return this;
  }

  /**
   * {@inheritDoc} Called when the date-time format information is changed. It updates the string
   * value of the input element according to the new date-time format information.
   *
   * @param dateTimeFormatInfo The new date-time format information.
   */
  @Override
  public void onDateTimeFormatInfoChanged(DateTimeFormatInfo dateTimeFormatInfo) {
    updateStringValue();
  }

  /**
   * Checks if the DateBox is set to open the popover on focus.
   *
   * @return True if the popover opens on focus, false otherwise
   */
  public boolean isOpenOnFocus() {
    return openOnFocus;
  }

  /**
   * Sets whether the DateBox should open the popover on focus.
   *
   * @param openOnFocus True to open the popover on focus, false to disable
   * @return This DateBox instance with the updated setting
   */
  public DateBox setOpenOnFocus(boolean openOnFocus) {
    this.openOnFocus = openOnFocus;
    return this;
  }

  /**
   * Checks if the DateBox is set to parse date values strictly.
   *
   * @return True if strict date parsing is enabled, false otherwise
   */
  public boolean isParseStrict() {
    return parseStrict;
  }

  /**
   * Sets whether the DateBox should parse date values strictly.
   *
   * @param parseStrict True to enable strict date parsing, false to disable
   * @return This DateBox instance with the updated setting
   */
  public DateBox setParseStrict(boolean parseStrict) {
    this.parseStrict = parseStrict;
    return this;
  }

  /**
   * Checks if the DateBox is set to open the popover on click.
   *
   * @return True if the popover opens on click, false otherwise
   */
  public boolean isOpenOnClick() {
    return openOnClick;
  }

  /**
   * Sets whether the DateBox should open the popover on click.
   *
   * @param openOnClick True to open the popover on click, false to disable
   * @return This DateBox instance with the updated setting
   */
  public DateBox setOpenOnClick(boolean openOnClick) {
    this.openOnClick = openOnClick;
    this.popover.setOpenOnClick(this.openOnClick);
    return this;
  }

  /**
   * Provides access to the DateBox's calendar for additional customization.
   *
   * @param handler The handler to apply to the calendar
   * @return This DateBox instance with the calendar configured
   */
  public DateBox withCalendar(ChildHandler<DateBox, Calendar> handler) {
    handler.apply(this, this.calendar);
    return this;
  }

  /**
   * Provides access to the DateBox's popover for additional customization.
   *
   * @param handler The handler to apply to the popover
   * @return This DateBox instance with the popover configured
   */
  public DateBox withPopover(ChildHandler<DateBox, Popover> handler) {
    handler.apply(this, this.popover);
    return this;
  }
}
