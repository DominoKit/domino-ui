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
import static org.dominokit.domino.ui.datepicker.CalendarStyles.dui_date_in_range;
import static org.dominokit.domino.ui.menu.direction.DropDirection.BEST_MIDDLE_DOWN_UP;
import static org.dominokit.domino.ui.style.DisplayCss.dui_flex;
import static org.dominokit.domino.ui.style.SpacingCss.dui_gap_4;
import static org.dominokit.domino.ui.style.SpacingCss.dui_items_center;
import static org.dominokit.domino.ui.style.SpacingCss.dui_justify_center;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.input;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLInputElement;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.dominokit.domino.ui.datepicker.Calendar;
import org.dominokit.domino.ui.datepicker.CalendarDay;
import org.dominokit.domino.ui.datepicker.CalendarInitConfig;
import org.dominokit.domino.ui.datepicker.CalendarMonth;
import org.dominokit.domino.ui.datepicker.CalendarViewListener;
import org.dominokit.domino.ui.datepicker.DateFormatter;
import org.dominokit.domino.ui.datepicker.Pattern;
import org.dominokit.domino.ui.forms.validations.ValidationResult;
import org.dominokit.domino.ui.i18n.CalendarLabels;
import org.dominokit.domino.ui.i18n.HasLabels;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.popover.Popover;
import org.dominokit.domino.ui.utils.AsyncHandler;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.DelayedExecution;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.Handler;
import org.dominokit.domino.ui.utils.PrimaryAddOn;
import org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo;
import org.gwtproject.i18n.shared.cldr.impl.DateTimeFormatInfo_factory;

public class DateRangeBox extends TextInputFormField<DateRangeBox, HTMLInputElement, DateRange>
    implements HasLabels<CalendarLabels>, CalendarViewListener {

  private final Popover popover;
  private final Calendar fromCalendar;
  private final Calendar toCalendar;
  private DateRange value;

  private DateFormatter formatter = DateFormatter.DEFAULT;
  private boolean openOnFocus = false;
  private boolean openOnClick = true;
  private boolean silentSelection = false;
  private String pattern;
  private boolean parseStrict;

  /** Creates a new DateRangeBox with the current date and default configuration. */
  public DateRangeBox() {
    this(new DateRange(), new CalendarInitConfig());
  }

  /**
   * Creates a new DateRangeBox with a label and the current date using default configuration.
   *
   * @param label The label for the DateRangeBox
   */
  public DateRangeBox(String label) {
    this(label, new DateRange(), new CalendarInitConfig());
  }

  /**
   * Creates a new DateRangeBox with the specified date using default configuration.
   *
   * @param dateRange The initial date values for the DateRangeBox
   */
  public DateRangeBox(DateRange dateRange) {
    this(dateRange, new CalendarInitConfig());
  }

  /**
   * Creates a new DateRangeBox with a label and the specified date using default configuration.
   *
   * @param label The label for the DateRangeBox
   * @param dateRange The initial date values for the DateRangeBox
   */
  public DateRangeBox(String label, DateRange dateRange) {
    this(label, dateRange, new CalendarInitConfig());
  }

  /**
   * Creates a new DateRangeBox with the specified date and calendar initialization configuration.
   *
   * @param dateRange The initial date values for the DateRangeBox
   * @param calendarInitConfig The calendar initialization configuration
   */
  public DateRangeBox(DateRange dateRange, CalendarInitConfig calendarInitConfig) {
    this(dateRange, DateTimeFormatInfo_factory.create(), calendarInitConfig);
  }

  /**
   * Creates a new DateRangeBox with a label, the specified date, and calendar initialization
   * configuration.
   *
   * @param label The label for the DateRangeBox
   * @param dateRange The initial date values for the DateRangeBox
   * @param calendarInitConfig The calendar initialization configuration
   */
  public DateRangeBox(String label, DateRange dateRange, CalendarInitConfig calendarInitConfig) {
    this(label, dateRange, DateTimeFormatInfo_factory.create(), calendarInitConfig);
  }

  /**
   * Creates a new DateRangeBox with a label, the specified date, date-time format information, and
   * calendar initialization configuration.
   *
   * @param label The label for the DateRangeBox
   * @param dateRange The initial date values for the DateRangeBox
   * @param dateTimeFormatInfo The date-time format information
   * @param calendarInitConfig The calendar initialization configuration
   */
  public DateRangeBox(
      String label,
      DateRange dateRange,
      DateTimeFormatInfo dateTimeFormatInfo,
      CalendarInitConfig calendarInitConfig) {
    this(dateRange, dateTimeFormatInfo, calendarInitConfig);
    setLabel(label);
  }

  /**
   * Creates a new DateRangeBox with the specified date, date-time format information, and calendar
   * initialization configuration.
   *
   * @param dateRange The initial date values for the DateRangeBox
   * @param dateTimeFormatInfo The date-time format information
   * @param calendarInitConfig The calendar initialization configuration
   */
  public DateRangeBox(
      DateRange dateRange,
      DateTimeFormatInfo dateTimeFormatInfo,
      CalendarInitConfig calendarInitConfig) {
    this.value = dateRange;
    this.fromCalendar =
        Calendar.create(dateRange.getFrom(), dateTimeFormatInfo, calendarInitConfig);
    this.toCalendar = Calendar.create(dateRange.getTo(), dateTimeFormatInfo, calendarInitConfig);
    this.pattern = dateTimeFormatInfo.dateFormatFull();
    this.popover =
        Popover.create(this.getWrapperElement())
            .setOpenCondition(() -> isEnabled() && !isReadOnly())
            .setOpenOnClick(this.openOnClick)
            .setPosition(BEST_MIDDLE_DOWN_UP)
            .appendChild(
                div()
                    .addCss(dui_flex, dui_gap_4, dui_items_center, dui_justify_center)
                    .appendChild(this.fromCalendar)
                    .appendChild(this.toCalendar))
            .addCloseListener(
                component -> {
                  this.fromCalendar.resetView();
                  this.toCalendar.resetView();
                })
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
                    invalidate(getLabels().calendarInvalidDateFormat(value));
                  }
                  DomGlobal.console.warn("Unable to parse date value " + value);
                }
              }
            });

    getInputElement()
        .addEventListener(
            "input",
            evt -> {
              DelayedExecution.execute(
                  () -> {
                    String value = getStringValue();
                    if (value.isEmpty()) {
                      clear();
                    } else {
                      try {
                        withValue(getFormattedValue(value));
                        clearInvalid();
                      } catch (IllegalArgumentException ignored) {
                        if (parseStrict) {
                          invalidate(getLabels().calendarInvalidDateFormat(value));
                        }
                        DomGlobal.console.warn("Unable to parse date value " + value);
                      }
                    }
                  },
                  config().getUIConfig().getDateBoxDefaultInputParseDelay());
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
            });
    this.fromCalendar.bindCalenderViewListener(this);
    this.toCalendar.bindCalenderViewListener(this);
    setStringValue(
        value, this.fromCalendar.getDateTimeFormatInfo(), this.toCalendar.getDateTimeFormatInfo());
    markRange();
  }

  /**
   * Creates a new DateRangeBox with the current date and default configuration.
   *
   * @return A new DateRangeBox instance
   */
  public static DateRangeBox create() {
    return new DateRangeBox(new DateRange(), new CalendarInitConfig());
  }

  /**
   * Creates a new DateRangeBox with a label and the current date using default configuration.
   *
   * @param label The label for the DateRangeBox
   * @return A new DateRangeBox instance
   */
  public static DateRangeBox create(String label) {
    return new DateRangeBox(label, new DateRange(), new CalendarInitConfig());
  }

  /**
   * Creates a new DateRangeBox with the specified date using default configuration.
   *
   * @param dateRange The initial date values for the DateRangeBox
   * @return A new DateRangeBox instance
   */
  public static DateRangeBox create(DateRange dateRange) {
    return new DateRangeBox(dateRange, new CalendarInitConfig());
  }

  /**
   * Creates a new DateRangeBox with a label and the specified date using default configuration.
   *
   * @param label The label for the DateRangeBox
   * @param dateRange The initial date values for the DateRangeBox
   * @return A new DateRangeBox instance
   */
  public static DateRangeBox create(String label, DateRange dateRange) {
    return new DateRangeBox(label, dateRange, new CalendarInitConfig());
  }

  /**
   * Creates a new DateRangeBox with the specified date and calendar initialization configuration.
   *
   * @param dateRange The initial date values for the DateRangeBox
   * @param calendarInitConfig The calendar initialization configuration
   * @return A new DateRangeBox instance
   */
  public static DateRangeBox create(DateRange dateRange, CalendarInitConfig calendarInitConfig) {
    return new DateRangeBox(dateRange, DateTimeFormatInfo_factory.create(), calendarInitConfig);
  }

  /**
   * Creates a new DateRangeBox with a label, the specified date, and calendar initialization
   * configuration.
   *
   * @param label The label for the DateRangeBox
   * @param dateRange The initial date values for the DateRangeBox
   * @param calendarInitConfig The calendar initialization configuration
   * @return A new DateRangeBox instance
   */
  public static DateRangeBox create(
      String label, DateRange dateRange, CalendarInitConfig calendarInitConfig) {
    return new DateRangeBox(
        label, dateRange, DateTimeFormatInfo_factory.create(), calendarInitConfig);
  }

  /**
   * Creates a new DateRangeBox with a specified date, date-time format information, and calendar
   * initialization configuration.
   *
   * @param dateRange The initial date values for the DateRangeBox
   * @param dateTimeFormatInfo The date-time format information
   * @param calendarInitConfig The calendar initialization configuration
   * @return A new DateRangeBox instance
   */
  public static DateRangeBox create(
      DateRange dateRange,
      DateTimeFormatInfo dateTimeFormatInfo,
      CalendarInitConfig calendarInitConfig) {
    return new DateRangeBox(dateRange, dateTimeFormatInfo, calendarInitConfig);
  }

  /**
   * Creates a new DateRangeBox with default date-time format information and the current date.
   *
   * @param dateTimeFormatInfo The date-time format information
   * @return A new DateRangeBox instance
   */
  public static DateRangeBox create(DateTimeFormatInfo dateTimeFormatInfo) {
    return new DateRangeBox(new DateRange(), dateTimeFormatInfo, new CalendarInitConfig());
  }

  /**
   * Creates a new DateRangeBox with a label, default date-time format information, and the current
   * date.
   *
   * @param label The label for the DateRangeBox
   * @param dateTimeFormatInfo The date-time format information
   * @return A new DateRangeBox instance
   */
  public static DateRangeBox create(String label, DateTimeFormatInfo dateTimeFormatInfo) {
    return new DateRangeBox(label, new DateRange(), dateTimeFormatInfo, new CalendarInitConfig());
  }

  /**
   * Creates a new DateRangeBox with a label, specified date, date-time format information, and
   * calendar initialization configuration.
   *
   * @param label The label for the DateRangeBox
   * @param dateRange The initial date values for the DateRangeBox
   * @param dateTimeFormatInfo The date-time format information
   * @param calendarInitConfig The calendar initialization configuration
   * @return A new DateRangeBox instance
   */
  public static DateRangeBox create(
      String label,
      DateRange dateRange,
      DateTimeFormatInfo dateTimeFormatInfo,
      CalendarInitConfig calendarInitConfig) {
    return new DateRangeBox(label, dateRange, dateTimeFormatInfo, calendarInitConfig);
  }

  /** Opens the popover associated with this DateRangeBox if it is enabled and not read-only. */
  private void doOpen() {
    if (isEnabled() && !isReadOnly()) {
      popover.open();
    }
  }

  /**
   * Closes the popover associated with this DateRangeBox.
   *
   * @return This DateRangeBox instance with the popover closed
   */
  public DateRangeBox close() {
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
   * @return This DateRangeBox instance with the new date pattern applied
   */
  public DateRangeBox setPattern(Pattern pattern) {
    switch (pattern) {
      case FULL:
        return setPattern(this.fromCalendar.getDateTimeFormatInfo().dateFormatFull());
      case LONG:
        return setPattern(this.fromCalendar.getDateTimeFormatInfo().dateFormatLong());
      case MEDIUM:
        return setPattern(this.fromCalendar.getDateTimeFormatInfo().dateFormatMedium());
      case SHORT:
        return setPattern(this.fromCalendar.getDateTimeFormatInfo().dateFormatShort());
      default:
        return this;
    }
  }

  /**
   * Sets the custom date pattern for formatting the displayed date value.
   *
   * <p>The date pattern should follow the conventions of the date format used in the {@link
   * DateTimeFormatInfo} associated with this DateRangeBox.
   *
   * @param pattern The custom date pattern (e.g., "MM/dd/yyyy")
   * @return This DateRangeBox instance with the new custom date pattern applied
   */
  @Override
  public DateRangeBox setPattern(String pattern) {
    if (!Objects.equals(this.pattern, pattern)) {
      this.pattern = pattern;
      setStringValue(
          value,
          this.fromCalendar.getDateTimeFormatInfo(),
          this.toCalendar.getDateTimeFormatInfo());
    }
    return this;
  }

  private void setStringValue(
      DateRange dateRange, DateTimeFormatInfo fromFormat, DateTimeFormatInfo toFormat) {
    if (nonNull(dateRange)) {
      this.getInputElement().element().value = getFormatted(dateRange, fromFormat, toFormat);
    } else this.getInputElement().element().value = "";
  }

  private String getFormatted(
      DateRange dateRange, DateTimeFormatInfo fromFormat, DateTimeFormatInfo toFormat) {
    String fromFormatted = formatter.format(this.pattern, fromFormat, dateRange.getFrom());
    String toFormatted = formatter.format(this.pattern, toFormat, dateRange.getTo());
    return fromFormatted + " - " + toFormatted;
  }

  @Override
  protected DominoElement<HTMLInputElement> createInputElement(String type) {
    return input(type).addCss(dui_field_input).toDominoElement();
  }

  private DateRange getFormattedValue(String value) throws IllegalArgumentException {
    DateTimeFormatInfo fromInfo = this.fromCalendar.getDateTimeFormatInfo();
    DateTimeFormatInfo toInfo = this.toCalendar.getDateTimeFormatInfo();

    if (nonNull(value) && value.contains(" - ")) {
      String valueFrom = value.substring(0, value.indexOf(" - "));
      String valueTo = value.substring(value.indexOf(" - ") + 2);

      if (this.parseStrict) {
        Date fromDate = formatter.parseStrict(this.pattern, fromInfo, valueFrom);
        Date toDate = formatter.parseStrict(this.pattern, toInfo, valueTo);
        return new DateRange(fromDate, toDate);
      } else {
        Date fromDate = formatter.parse(this.pattern, fromInfo, valueFrom);
        Date toDate = formatter.parse(this.pattern, toInfo, valueTo);
        return new DateRange(fromDate, toDate);
      }
    } else {
      throw new IllegalArgumentException("Date range should be split with [ - ].");
    }
  }

  /**
   * Sets the position of the popover when it opens.
   *
   * @param position The desired position of the popover
   * @return This DateRangeBox instance with the popover position set
   */
  public DateRangeBox setPopoverPosition(DropDirection position) {
    if (nonNull(position)) {
      this.popover.setPosition(position);
    }
    return this;
  }

  /**
   * Adds a listener to toggle the "openOnFocus" behavior of this DateRangeBox when it receives
   * focus.
   *
   * @param toggle If true, the "openOnFocus" behavior will be enabled; if false, it will be
   *     disabled.
   * @param handler A handler that will be invoked when the toggle state changes.
   * @return This DateRangeBox instance with the listener added.
   */
  public DateRangeBox withOpenOnFocusToggleListeners(
      boolean toggle, Handler<DateRangeBox> handler) {
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
   * Adds a listener to toggle the "openOnFocus" behavior of this DateRangeBox when it receives
   * focus, with the option to pause the toggle state temporarily.
   *
   * @param toggle If true, the "openOnFocus" behavior will be enabled; if false, it will be
   *     disabled.
   * @param handler An asynchronous handler that will be invoked when the toggle state changes.
   * @return This DateRangeBox instance with the listener added.
   * @throws Exception If an exception occurs during the asynchronous handler execution.
   */
  public DateRangeBox withPausedOpenOnFocusListeners(
      boolean toggle, AsyncHandler<DateRangeBox> handler) {
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

  private DateRangeBox withDateSelectionToggleListeners(
      boolean toggle, Handler<DateRangeBox> handler) {
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
  protected void doSetValue(DateRange value) {
    DateRange oldValue = this.value;
    this.value = value;
    if (nonNull(value)) {
      updateStringValue();
    } else {
      getInputElement().element().value = "";
      close();
    }
    withDateSelectionToggleListeners(
        false,
        field -> {
          if (nonNull(this.value)) {
            if (!Objects.equals(this.fromCalendar.getDate(), this.value.getFrom())) {
              this.fromCalendar.setDate(this.value.getFrom(), true);
            }
            if (!Objects.equals(this.toCalendar.getDate(), this.value.getTo())) {
              this.toCalendar.setDate(this.value.getTo(), true);
            }

            this.fromCalendar.informListeners(
                false, Optional.ofNullable(oldValue).map(DateRange::getFrom).orElse(new Date()));
            this.toCalendar.informListeners(
                false, Optional.ofNullable(oldValue).map(DateRange::getTo).orElse(new Date()));
          }
        });
    markRange();
  }

  private void updateStringValue() {
    getInputElement().element().value =
        getFormatted(
            this.value,
            this.fromCalendar.getDateTimeFormatInfo(),
            this.toCalendar.getDateTimeFormatInfo());
  }

  @Override
  public DateRangeBox clear(boolean silent) {
    close();
    return super.clear(silent);
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
   * {@inheritDoc} Returns the type of the input element, which is always "text" for a DateRangeBox.
   *
   * @return The string "text."
   */
  @Override
  public String getType() {
    return "text";
  }

  /**
   * {@inheritDoc} Returns the selected date value of this DateRangeBox.
   *
   * @return The selected date value.
   */
  @Override
  public DateRange getValue() {
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
      if (!silentSelection) {
        clearInvalid();
        withValue(new DateRange(this.fromCalendar.getDate(), this.toCalendar.getDate()));
      }
      markRange();
    }
  }

  @Override
  public void onUpdateCalendarView(Date date) {
    markRange();
  }

  private void markRange() {
    fromCalendar.withCalendarMonth(
        (parent, month) -> {
          markInRangeDays(month);
        });
    toCalendar.withCalendarMonth(
        (parent, month) -> {
          markInRangeDays(month);
        });
  }

  private void markInRangeDays(CalendarMonth month) {
    if (nonNull(this.value)) {
      List<CalendarDay> days = month.getMonthViewDays();
      for (int index = 0; index < days.size(); index++) {
        CalendarDay day = days.get(index);
        if (day.isInRange(this.value.getFrom(), this.value.getTo())) {
          days.get(index).addCss(dui_date_in_range);
        } else {
          dui_date_in_range.remove(days.get(index));
        }
      }
    }
  }

  /**
   * Retrieves the date-time format information associated with this DateRangeBox.
   *
   * @return The date-time format information
   */
  public DateTimeFormatInfo getDateTimeFormat() {
    return this.fromCalendar.getDateTimeFormatInfo();
  }

  /**
   * Retrieves the date-time format information associated with this DateRangeBox from calendar.
   *
   * @return The date-time format information
   */
  public DateTimeFormatInfo getFromDateTimeFormat() {
    return this.fromCalendar.getDateTimeFormatInfo();
  }

  /**
   * Retrieves the date-time format information associated with this DateRangeBox to calendar.
   *
   * @return The date-time format information
   */
  public DateTimeFormatInfo getToDateTimeFormat() {
    return this.toCalendar.getDateTimeFormatInfo();
  }

  /**
   * Sets the date-time format information for this DateRangeBox.
   *
   * @param dateTimeFormatInfo The date-time format information to set
   * @return This DateRangeBox instance with the new date-time format information
   */
  public DateRangeBox setDateTimeFormat(DateTimeFormatInfo dateTimeFormatInfo) {
    this.fromCalendar.setDateTimeFormatInfo(dateTimeFormatInfo);
    return this;
  }

  /**
   * Sets the date-time format information for this DateRangeBox from calendar.
   *
   * @param dateTimeFormatInfo The date-time format information to set
   * @return This DateRangeBox instance with the new date-time format information
   */
  public DateRangeBox setFromDateTimeFormat(DateTimeFormatInfo dateTimeFormatInfo) {
    this.fromCalendar.setDateTimeFormatInfo(dateTimeFormatInfo);
    return this;
  }

  /**
   * Sets the date-time format information for this DateRangeBox to calendar.
   *
   * @param dateTimeFormatInfo The date-time format information to set
   * @return This DateRangeBox instance with the new date-time format information
   */
  public DateRangeBox setToDateTimeFormat(DateTimeFormatInfo dateTimeFormatInfo) {
    this.toCalendar.setDateTimeFormatInfo(dateTimeFormatInfo);
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
   * Checks if the DateRangeBox is set to open the popover on focus.
   *
   * @return True if the popover opens on focus, false otherwise
   */
  public boolean isOpenOnFocus() {
    return openOnFocus;
  }

  /**
   * Sets whether the DateRangeBox should open the popover on focus.
   *
   * @param openOnFocus True to open the popover on focus, false to disable
   * @return This DateRangeBox instance with the updated setting
   */
  public DateRangeBox setOpenOnFocus(boolean openOnFocus) {
    this.openOnFocus = openOnFocus;
    return this;
  }

  /**
   * Checks if the DateRangeBox is set to parse date values strictly.
   *
   * @return True if strict date parsing is enabled, false otherwise
   */
  public boolean isParseStrict() {
    return parseStrict;
  }

  /**
   * Sets whether the DateRangeBox should parse date values strictly.
   *
   * @param parseStrict True to enable strict date parsing, false to disable
   * @return This DateRangeBox instance with the updated setting
   */
  public DateRangeBox setParseStrict(boolean parseStrict) {
    this.parseStrict = parseStrict;
    return this;
  }

  /**
   * Checks if the DateRangeBox is set to open the popover on click.
   *
   * @return True if the popover opens on click, false otherwise
   */
  public boolean isOpenOnClick() {
    return openOnClick;
  }

  /**
   * Sets whether the DateRangeBox should open the popover on click.
   *
   * @param openOnClick True to open the popover on click, false to disable
   * @return This DateRangeBox instance with the updated setting
   */
  public DateRangeBox setOpenOnClick(boolean openOnClick) {
    this.openOnClick = openOnClick;
    this.popover.setOpenOnClick(this.openOnClick);
    return this;
  }

  /**
   * Provides access to the DateRangeBox's calendar for additional customization.
   *
   * @param handler The handler to apply to the calendar
   * @return This DateRangeBox instance with the calendar configured
   */
  public DateRangeBox withFromCalendar(ChildHandler<DateRangeBox, Calendar> handler) {
    handler.apply(this, this.fromCalendar);
    return this;
  }

  /**
   * Provides access to the DateRangeBox's calendar for additional customization.
   *
   * @param handler The handler to apply to the calendar
   * @return This DateRangeBox instance with the calendar configured
   */
  public DateRangeBox withToCalendar(ChildHandler<DateRangeBox, Calendar> handler) {
    handler.apply(this, this.toCalendar);
    return this;
  }

  /**
   * Provides access to the DateRangeBox's popover for additional customization.
   *
   * @param handler The handler to apply to the popover
   * @return This DateRangeBox instance with the popover configured
   */
  public DateRangeBox withPopover(ChildHandler<DateRangeBox, Popover> handler) {
    handler.apply(this, this.popover);
    return this;
  }
}
