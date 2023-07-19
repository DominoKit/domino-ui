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
 * DateBox class.
 *
 * @author vegegoku
 * @version $Id: $Id
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

  /** Constructor for DateBox. */
  public DateBox() {
    this(new Date(), new CalendarInitConfig());
  }

  /**
   * Constructor for DateBox.
   *
   * @param label a {@link java.lang.String} object
   */
  public DateBox(String label) {
    this(label, new Date(), new CalendarInitConfig());
  }

  /**
   * Constructor for DateBox.
   *
   * @param date a {@link java.util.Date} object
   */
  public DateBox(Date date) {
    this(date, new CalendarInitConfig());
  }

  /**
   * Constructor for DateBox.
   *
   * @param label a {@link java.lang.String} object
   * @param date a {@link java.util.Date} object
   */
  public DateBox(String label, Date date) {
    this(label, date, new CalendarInitConfig());
  }

  /**
   * Constructor for DateBox.
   *
   * @param date a {@link java.util.Date} object
   * @param calendarInitConfig a {@link org.dominokit.domino.ui.datepicker.CalendarInitConfig}
   *     object
   */
  public DateBox(Date date, CalendarInitConfig calendarInitConfig) {
    this(date, DateTimeFormatInfo_factory.create(), calendarInitConfig);
  }

  /**
   * Constructor for DateBox.
   *
   * @param label a {@link java.lang.String} object
   * @param date a {@link java.util.Date} object
   * @param calendarInitConfig a {@link org.dominokit.domino.ui.datepicker.CalendarInitConfig}
   *     object
   */
  public DateBox(String label, Date date, CalendarInitConfig calendarInitConfig) {
    this(label, date, DateTimeFormatInfo_factory.create(), calendarInitConfig);
  }

  /**
   * Constructor for DateBox.
   *
   * @param label a {@link java.lang.String} object
   * @param date a {@link java.util.Date} object
   * @param dateTimeFormatInfo a {@link org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo} object
   * @param calendarInitConfig a {@link org.dominokit.domino.ui.datepicker.CalendarInitConfig}
   *     object
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
   * Constructor for DateBox.
   *
   * @param date a {@link java.util.Date} object
   * @param dateTimeFormatInfo a {@link org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo} object
   * @param calendarInitConfig a {@link org.dominokit.domino.ui.datepicker.CalendarInitConfig}
   *     object
   */
  public DateBox(
      Date date, DateTimeFormatInfo dateTimeFormatInfo, CalendarInitConfig calendarInitConfig) {
    this.value = date;
    this.calendar = Calendar.create(date, dateTimeFormatInfo, calendarInitConfig);
    this.pattern = dateTimeFormatInfo.dateFormatFull();
    this.popover =
        Popover.create(this.getWrapperElement())
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
   * create.
   *
   * @return a {@link org.dominokit.domino.ui.forms.DateBox} object
   */
  public static DateBox create() {
    return new DateBox(new Date(), new CalendarInitConfig());
  }

  /**
   * create.
   *
   * @param label a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.forms.DateBox} object
   */
  public static DateBox create(String label) {
    return new DateBox(label, new Date(), new CalendarInitConfig());
  }

  /**
   * create.
   *
   * @param date a {@link java.util.Date} object
   * @return a {@link org.dominokit.domino.ui.forms.DateBox} object
   */
  public static DateBox create(Date date) {
    return new DateBox(date, new CalendarInitConfig());
  }

  /**
   * create.
   *
   * @param label a {@link java.lang.String} object
   * @param date a {@link java.util.Date} object
   * @return a {@link org.dominokit.domino.ui.forms.DateBox} object
   */
  public static DateBox create(String label, Date date) {
    return new DateBox(label, date, new CalendarInitConfig());
  }

  /**
   * create.
   *
   * @param date a {@link java.util.Date} object
   * @param calendarInitConfig a {@link org.dominokit.domino.ui.datepicker.CalendarInitConfig}
   *     object
   * @return a {@link org.dominokit.domino.ui.forms.DateBox} object
   */
  public static DateBox create(Date date, CalendarInitConfig calendarInitConfig) {
    return new DateBox(date, DateTimeFormatInfo_factory.create(), calendarInitConfig);
  }

  /**
   * create.
   *
   * @param label a {@link java.lang.String} object
   * @param date a {@link java.util.Date} object
   * @param calendarInitConfig a {@link org.dominokit.domino.ui.datepicker.CalendarInitConfig}
   *     object
   * @return a {@link org.dominokit.domino.ui.forms.DateBox} object
   */
  public static DateBox create(String label, Date date, CalendarInitConfig calendarInitConfig) {
    return new DateBox(label, date, DateTimeFormatInfo_factory.create(), calendarInitConfig);
  }

  /**
   * create.
   *
   * @param date a {@link java.util.Date} object
   * @param dateTimeFormatInfo a {@link org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo} object
   * @param calendarInitConfig a {@link org.dominokit.domino.ui.datepicker.CalendarInitConfig}
   *     object
   * @return a {@link org.dominokit.domino.ui.forms.DateBox} object
   */
  public static DateBox create(
      Date date, DateTimeFormatInfo dateTimeFormatInfo, CalendarInitConfig calendarInitConfig) {
    return new DateBox(date, dateTimeFormatInfo, calendarInitConfig);
  }

  /**
   * create.
   *
   * @param dateTimeFormatInfo a {@link org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo} object
   * @return a {@link org.dominokit.domino.ui.forms.DateBox} object
   */
  public static DateBox create(DateTimeFormatInfo dateTimeFormatInfo) {
    return new DateBox(new Date(), dateTimeFormatInfo, new CalendarInitConfig());
  }

  /**
   * create.
   *
   * @param label a {@link java.lang.String} object
   * @param dateTimeFormatInfo a {@link org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo} object
   * @return a {@link org.dominokit.domino.ui.forms.DateBox} object
   */
  public static DateBox create(String label, DateTimeFormatInfo dateTimeFormatInfo) {
    return new DateBox(label, new Date(), dateTimeFormatInfo, new CalendarInitConfig());
  }

  /**
   * create.
   *
   * @param label a {@link java.lang.String} object
   * @param date a {@link java.util.Date} object
   * @param dateTimeFormatInfo a {@link org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo} object
   * @param calendarInitConfig a {@link org.dominokit.domino.ui.datepicker.CalendarInitConfig}
   *     object
   * @return a {@link org.dominokit.domino.ui.forms.DateBox} object
   */
  public static DateBox create(
      String label,
      Date date,
      DateTimeFormatInfo dateTimeFormatInfo,
      CalendarInitConfig calendarInitConfig) {
    return new DateBox(label, date, dateTimeFormatInfo, calendarInitConfig);
  }

  private void doOpen() {
    if (isEnabled()) {
      popover.open();
    }
  }

  /**
   * close.
   *
   * @return a {@link org.dominokit.domino.ui.forms.DateBox} object
   */
  public DateBox close() {
    popover.close();
    return this;
  }

  /**
   * Sets the {@link org.dominokit.domino.ui.datepicker.Pattern} of the field
   *
   * @param pattern the new {@link org.dominokit.domino.ui.datepicker.Pattern}
   * @return same instance
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
   * {@inheritDoc}
   *
   * <p>Sets a custom pattern.
   *
   * <p>More information of defining the pattern can be found under <a
   *
   * <p>href="http://www.gwtproject.org/javadoc/latest/com/google/gwt/i18n/client/DateTimeFormat.html">GWT
   * DateTimeFormat</a>
   */
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

  /** {@inheritDoc} */
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
   * setPopoverPosition.
   *
   * @param position a {@link org.dominokit.domino.ui.menu.direction.DropDirection} object
   * @return a {@link org.dominokit.domino.ui.forms.DateBox} object
   */
  public DateBox setPopoverPosition(DropDirection position) {
    if (nonNull(position)) {
      this.popover.setPosition(position);
    }
    return this;
  }

  /**
   * withOpenOnFocusToggleListeners.
   *
   * @param toggle a boolean
   * @param handler a {@link org.dominokit.domino.ui.utils.Handler} object
   * @return a {@link org.dominokit.domino.ui.forms.DateBox} object
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
   * withPausedOpenOnFocusListeners.
   *
   * @param toggle a boolean
   * @param handler a {@link org.dominokit.domino.ui.utils.AsyncHandler} object
   * @return a {@link org.dominokit.domino.ui.forms.DateBox} object
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

  /** {@inheritDoc} */
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
          this.calendar.setDate(this.value);
        });
  }

  private void updateStringValue() {
    getInputElement().element().value =
        getFormatted(this.value, this.calendar.getDateTimeFormatInfo());
  }

  /** {@inheritDoc} */
  @Override
  public String getStringValue() {
    return getInputElement().element().value;
  }

  /** {@inheritDoc} */
  @Override
  public String getType() {
    return "text";
  }

  /** {@inheritDoc} */
  @Override
  public Date getValue() {
    return this.value;
  }

  /** {@inheritDoc} */
  @Override
  public void onDateSelectionChanged(Date date) {
    if (silentSelection == false) {
      clearInvalid();
      withValue(date);
    }
    this.popover.close();
  }

  /**
   * getDateTimeFormat.
   *
   * @return a {@link org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo} object
   */
  public DateTimeFormatInfo getDateTimeFormat() {
    return this.calendar.getDateTimeFormatInfo();
  }

  /**
   * setDateTimeFormat.
   *
   * @param dateTimeFormatInfo a {@link org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo} object
   * @return a {@link org.dominokit.domino.ui.forms.DateBox} object
   */
  public DateBox setDateTimeFormat(DateTimeFormatInfo dateTimeFormatInfo) {
    this.calendar.setDateTimeFormatInfo(dateTimeFormatInfo);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public void onDateTimeFormatInfoChanged(DateTimeFormatInfo dateTimeFormatInfo) {
    updateStringValue();
  }

  /**
   * isOpenOnFocus.
   *
   * @return a boolean
   */
  public boolean isOpenOnFocus() {
    return openOnFocus;
  }

  /**
   * Setter for the field <code>openOnFocus</code>.
   *
   * @param openOnFocus a boolean
   * @return a {@link org.dominokit.domino.ui.forms.DateBox} object
   */
  public DateBox setOpenOnFocus(boolean openOnFocus) {
    this.openOnFocus = openOnFocus;
    return this;
  }

  /**
   * isParseStrict.
   *
   * @return a boolean
   */
  public boolean isParseStrict() {
    return parseStrict;
  }

  /**
   * Setter for the field <code>parseStrict</code>.
   *
   * @param parseStrict a boolean
   * @return a {@link org.dominokit.domino.ui.forms.DateBox} object
   */
  public DateBox setParseStrict(boolean parseStrict) {
    this.parseStrict = parseStrict;
    return this;
  }

  /**
   * isOpenOnClick.
   *
   * @return a boolean
   */
  public boolean isOpenOnClick() {
    return openOnClick;
  }

  /**
   * Setter for the field <code>openOnClick</code>.
   *
   * @param openOnClick a boolean
   * @return a {@link org.dominokit.domino.ui.forms.DateBox} object
   */
  public DateBox setOpenOnClick(boolean openOnClick) {
    this.openOnClick = openOnClick;
    this.popover.setOpenOnClick(this.openOnClick);
    return this;
  }

  /**
   * withCalendar.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.forms.DateBox} object
   */
  public DateBox withCalendar(ChildHandler<DateBox, Calendar> handler) {
    handler.apply(this, this.calendar);
    return this;
  }

  /**
   * withPopover.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.forms.DateBox} object
   */
  public DateBox withPopover(ChildHandler<DateBox, Popover> handler) {
    handler.apply(this, this.popover);
    return this;
  }
}
