///*
// * Copyright © 2019 Dominokit
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *     http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//package org.dominokit.domino.ui.datepicker;
//
//import static java.util.Objects.nonNull;
//import static org.dominokit.domino.ui.style.Unit.px;
//import static org.jboss.elemento.Elements.div;
//
//import elemental2.core.JsDate;
//import elemental2.dom.HTMLDivElement;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import org.dominokit.domino.ui.button.Button;
//import org.dominokit.domino.ui.forms.Select;
//import org.dominokit.domino.ui.forms.SelectOption;
//import org.dominokit.domino.ui.grid.Column;
//import org.dominokit.domino.ui.grid.Row;
//import org.dominokit.domino.ui.grid.Row_12;
//import org.dominokit.domino.ui.grid.flex.FlexAlign;
//import org.dominokit.domino.ui.grid.flex.FlexItem;
//import org.dominokit.domino.ui.grid.flex.FlexJustifyContent;
//import org.dominokit.domino.ui.grid.flex.FlexLayout;
//import org.dominokit.domino.ui.icons.Icons;
//import org.dominokit.domino.ui.icons.MdiIcon;
//import org.dominokit.domino.ui.modals.ModalDialog;
//import org.dominokit.domino.ui.pickers.PickerHandler;
//import org.dominokit.domino.ui.style.ColorScheme;
//import org.dominokit.domino.ui.style.Elevation;
//import org.dominokit.domino.ui.style.Styles;
//import org.dominokit.domino.ui.utils.BaseDominoElement;
//import org.dominokit.domino.ui.utils.DominoElement;
//import org.dominokit.domino.ui.utils.HasValue;
//import org.gwtproject.editor.client.TakesValue;
//import org.gwtproject.i18n.shared.DateTimeFormat;
//import org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo;
//import org.gwtproject.i18n.shared.cldr.impl.DateTimeFormatInfo_factory;
//
///**
// * A component to pick a date
// *
// * <p>Customize the component can be done by overwriting classes provided by {@link
// * DatePickerStyles}
// *
// * <p>For example:
// *
// * <pre>
// *     DatePicker.create()
// *               .hideClearButton()
// *               .hideCloseButton()
// *               .fixedWidth("265px")
// *               .showBorder()
// *               .addDateSelectionHandler((date, dateTimeFormatInfo) -> {})
// * </pre>
// *
// * @see BaseDominoElement
// * @see HasValue
// * @see DatePickerMonth.InternalHandler
// * @see TakesValue
// */
//public class DatePicker extends BaseDominoElement<HTMLDivElement, DatePicker>
//    implements HasValue<DatePicker, Date>, DatePickerMonth.InternalHandler, TakesValue<Date> {
//
//  private final JsDate jsDate;
//  private final DominoElement<HTMLDivElement> element =
//      DominoElement.of(div()).css(DatePickerStyles.CALENDAR).elevate(Elevation.LEVEL_1);
//  private final DominoElement<HTMLDivElement> headerPanel =
//      DominoElement.of(div()).css(DatePickerStyles.DATE_PANEL);
//  private final DominoElement<HTMLDivElement> selectorsPanel =
//      DominoElement.of(div()).css(DatePickerStyles.SELECTOR_CONTAINER);
//  private final FlexLayout footerPanel = FlexLayout.create().css(DatePickerStyles.CAL_FOOTER);
//
//  private final DominoElement<HTMLDivElement> dayName =
//      DominoElement.of(div()).css(DatePickerStyles.DAY_NAME);
//  private final DominoElement<HTMLDivElement> monthName =
//      DominoElement.of(div()).css(DatePickerStyles.MONTH_NAME);
//  private final DominoElement<HTMLDivElement> dateNumber =
//      DominoElement.of(div()).css(DatePickerStyles.DAY_NUMBER);
//  private final DominoElement<HTMLDivElement> yearNumber =
//      DominoElement.of(div()).css(DatePickerStyles.YEAR_NUMBER);
//  private MdiIcon navigateBefore;
//  private MdiIcon navigateNext;
//
//  private Select<Integer> yearSelect;
//  private Select<Integer> monthSelect;
//  private Button todayButton;
//  private Button clearButton;
//  private Button closeButton;
//  private Button resetButton;
//
//  private ColorScheme colorScheme = ColorScheme.LIGHT_BLUE;
//
//  private final DatePickerMonth datePickerMonth;
//  private DatePickerElement selectedPickerElement;
//
//  private final List<PickerHandler> closeHandlers = new ArrayList<>();
//  private final List<PickerHandler> resetHandlers = new ArrayList<>();
//  private final List<PickerHandler> clearHandlers = new ArrayList<>();
//  private BackgroundHandler backgroundHandler = (oldBackground, newBackground) -> {};
//
//  private final JsDate minDate;
//  private final JsDate maxDate;
//
//  private final List<DateSelectionHandler> dateSelectionHandlers = new ArrayList<>();
//  private final List<DateDayClickedHandler> dateDayClickedHandlers = new ArrayList<>();
//  private FlexItem clearButtonContainer;
//  private FlexItem todayButtonContainer;
//  private FlexItem resetButtonContainer;
//  private FlexItem closeButtonContainer;
//
//  public DatePicker(Date date, DateTimeFormatInfo dateTimeFormatInfo) {
//    this.jsDate = new JsDate((double) date.getTime());
//    this.minDate = new JsDate((double) date.getTime());
//    this.maxDate = new JsDate((double) date.getTime());
//
//    minDate.setFullYear(minDate.getFullYear() - 50);
//    maxDate.setFullYear(maxDate.getFullYear() + 50);
//
//    datePickerMonth = DatePickerMonth.create(this.jsDate, dateTimeFormatInfo, this);
//    build();
//  }
//
//  public DatePicker(Date date, DateTimeFormatInfo dateTimeFormatInfo, Date minDate, Date maxDate) {
//    this.jsDate = new JsDate((double) date.getTime());
//    this.minDate = new JsDate((double) minDate.getTime());
//    this.maxDate = new JsDate((double) maxDate.getTime());
//    datePickerMonth = DatePickerMonth.create(this.jsDate, dateTimeFormatInfo, this);
//    build();
//  }
//
//  private DatePicker(
//      JsDate date, DateTimeFormatInfo dateTimeFormatInfo, JsDate minDate, JsDate maxDate) {
//    this.jsDate = date;
//    this.minDate = minDate;
//    this.maxDate = maxDate;
//    datePickerMonth = DatePickerMonth.create(this.jsDate, dateTimeFormatInfo, this);
//    build();
//  }
//
//  private void build() {
//    element.appendChild(headerPanel);
//    headerPanel.addCss(colorScheme.color().getBackground());
//    dayName.addCss(colorScheme.darker_2().getBackground());
//    headerPanel.appendChild(dayName);
//    headerPanel.appendChild(monthName);
//    headerPanel.appendChild(dateNumber);
//    headerPanel.appendChild(yearNumber);
//
//    element.appendChild(selectorsPanel);
//    initSelectors();
//    element.appendChild(datePickerMonth);
//    element.appendChild(footerPanel);
//    initFooter();
//
//    datePickerMonth.init();
//  }
//
//  private void initFooter() {
//    clearButton =
//        Button.create("CLEAR").setColor(colorScheme.color()).css(DatePickerStyles.CAL_BUTTON);
//
//    clearButton.addClickListener(
//        evt -> {
//          clearHandlers.forEach(PickerHandler::handle);
//        });
//
//    todayButton =
//        Button.create("TODAY").setColor(colorScheme.color()).css(DatePickerStyles.CAL_BUTTON);
//    todayButton.addClickListener(evt -> setDate(new Date()));
//
//    closeButton =
//        Button.create("CLOSE").setColor(colorScheme.color()).css(DatePickerStyles.CAL_BUTTON);
//
//    closeButton.addClickListener(
//        evt -> {
//          closeHandlers.forEach(PickerHandler::handle);
//        });
//
//    resetButton =
//        Button.create("RESET").setColor(colorScheme.color()).css(DatePickerStyles.CAL_BUTTON);
//
//    resetButton.addClickListener(
//        evt -> {
//          resetHandlers.forEach(PickerHandler::handle);
//        });
//
//    clearButtonContainer = FlexItem.create();
//    todayButtonContainer = FlexItem.create();
//    resetButtonContainer = FlexItem.create();
//    closeButtonContainer = FlexItem.create();
//    footerPanel
//        .setJustifyContent(FlexJustifyContent.SPACE_EVENLY)
//        .setAlignItems(FlexAlign.CENTER)
//        .appendChild(clearButtonContainer.appendChild(clearButton.linkify()))
//        .appendChild(todayButtonContainer.appendChild(todayButton.linkify()))
//        .appendChild(this.resetButtonContainer.appendChild(resetButton.linkify()))
//        .appendChild(closeButtonContainer.appendChild(closeButton.linkify()));
//
//    hideResetButton();
//  }
//
//  private void initSelectors() {
//    int year = jsDate.getFullYear();
//    yearSelect = Select.<Integer>create().css(DatePickerStyles.SELECTOR);
////
////    yearSelect.getLeftAddonContainer().remove();
////    yearSelect.getMandatoryAddOn();
////    yearSelect.setPopupWidth(150);
//
//    for (int i = minDate.getFullYear(); i <= maxDate.getFullYear(); i++) {
//      SelectOption<Integer> yearOption = SelectOption.create(i, i + "");
//      yearSelect.appendChild(yearOption);
//
//      if (i == year) yearSelect.select(yearOption);
//    }
//    yearSelect.addSelectionHandler(
//        option -> {
//          int selectedYear = option.getValue();
//          jsDate.setYear(selectedYear);
//          setDate(jsDate);
//        });
//
//    int month = jsDate.getMonth();
//    monthSelect = Select.<Integer>create().css(DatePickerStyles.SELECTOR);
////    monthSelect.getLeftAddonContainer().remove();
////    monthSelect.getMandatoryAddOn();
////    monthSelect.setPopupWidth(150);
//
//    String[] months = getDateTimeFormatInfo().monthsShort();
//    for (int i = 0; i < months.length; i++) {
//      SelectOption<Integer> monthOption = SelectOption.create(i, months[i]);
//      monthSelect.appendChild(monthOption);
//      if (i == month) monthSelect.select(monthOption);
//    }
//    monthSelect.addSelectionHandler(
//        option -> {
//          int selectedMonth = option.getValue();
//          jsDate.setDate(
//              DatePickerUtil.getValidMonthDate(
//                  jsDate.getFullYear(), selectedMonth, jsDate.getDate()));
//          jsDate.setMonth(selectedMonth);
//          setDate(jsDate);
//        });
//
//    Column yearColumn = Column.span5().condense().appendChild(yearSelect.element());
//
//    Column monthColumn = Column.span5().condense().appendChild(monthSelect.element());
//
//    Column backColumn = Column.span1().condense();
//
//    Column forwardColumn = Column.span1().condense();
//
//    Row_12 row = Row.create().setGap(px.of(5)).addCss(DatePickerStyles.SELECTOR_ROW);
//    navigateBefore =
//        Icons.ALL
//            .menu_left_mdi()
//            .clickable()
//            .addCss(Styles.m_r_5)
//            .addClickListener(
//                evt -> {
//                  JsDate jsDate = getJsDate();
//                  int currentMonth = jsDate.getMonth();
//                  if (currentMonth == 0) {
//                    jsDate.setYear(jsDate.getFullYear() - 1);
//                    jsDate.setMonth(11);
//                  } else {
//                    jsDate.setMonth(currentMonth - 1);
//                  }
//
//                  yearSelect.setValue(jsDate.getFullYear(), true);
//                  monthSelect.selectAt(jsDate.getMonth(), true);
//                  setDate(jsDate);
//                });
//
//    navigateNext =
//        Icons.ALL
//            .menu_right_mdi()
//            .clickable()
//            .addCss(Styles.m_l_5)
//            .addClickListener(
//                evt -> {
//                  JsDate jsDate = getJsDate();
//                  int currentMonth = jsDate.getMonth();
//                  if (currentMonth == 11) {
//                    jsDate.setYear(jsDate.getFullYear() + 1);
//                    jsDate.setMonth(0);
//                  } else {
//                    jsDate.setMonth(currentMonth + 1);
//                  }
//
//                  yearSelect.setValue(jsDate.getFullYear(), true);
//                  monthSelect.selectAt(jsDate.getMonth(), true);
//                  setDate(jsDate);
//                });
//
//    selectorsPanel.appendChild(
//        row.appendChild(backColumn.appendChild(navigateBefore))
//            .appendChild(yearColumn)
//            .appendChild(monthColumn)
//            .appendChild(forwardColumn.appendChild(navigateNext)));
//  }
//
//  /**
//   * Creates new date picker with {@link DateTimeFormatInfo} based on the defined system property
//   * locale and {@code now} date
//   *
//   * @return new instance
//   */
//  public static DatePicker create() {
//    DateTimeFormatInfo dateTimeFormatInfo = DateTimeFormatInfo_factory.create();
//
//    return new DatePicker(new Date(), dateTimeFormatInfo);
//  }
//
//  /**
//   * Creates new date picker with {@link DateTimeFormatInfo} based on the defined system property
//   * locale and a {@code date}
//   *
//   * @param date the date
//   * @return new instance
//   */
//  public static DatePicker create(Date date) {
//    DateTimeFormatInfo dateTimeFormatInfo = DateTimeFormatInfo_factory.create();
//    return new DatePicker(date, dateTimeFormatInfo);
//  }
//
//  /**
//   * Creates new date picker with {@link DateTimeFormatInfo} based on the defined system property
//   * locale, {@code now} date and min/max dates to show in the component
//   *
//   * @param date the date
//   * @param maxDate the maximum date
//   * @param minDate the minimum date
//   * @return new instance
//   */
//  public static DatePicker create(Date date, Date minDate, Date maxDate) {
//    DateTimeFormatInfo dateTimeFormatInfo = DateTimeFormatInfo_factory.create();
//    return new DatePicker(date, dateTimeFormatInfo, minDate, maxDate);
//  }
//
//  /**
//   * Creates new date picker with {@code dateTimeFormatInfo} and a {@code date}
//   *
//   * @param date the date
//   * @param dateTimeFormatInfo the date time format
//   * @return new instance
//   */
//  public static DatePicker create(Date date, DateTimeFormatInfo dateTimeFormatInfo) {
//    return new DatePicker(date, dateTimeFormatInfo);
//  }
//
//  /**
//   * Creates new date picker with {@code dateTimeFormatInfo}, a {@code date} and min/max dates to
//   * show in the component
//   *
//   * @param date the date
//   * @param dateTimeFormatInfo the date time format
//   * @param minDate the minimum date
//   * @param maxDate the maximum date
//   * @return new instance
//   */
//  public static DatePicker create(
//      Date date, DateTimeFormatInfo dateTimeFormatInfo, Date minDate, Date maxDate) {
//    return new DatePicker(date, dateTimeFormatInfo, minDate, maxDate);
//  }
//
//  /** {@inheritDoc} */
//  @Override
//  public HTMLDivElement element() {
//    return element.element();
//  }
//
//  /** {@inheritDoc} */
//  @Override
//  public DatePicker value(Date value) {
//    return value(value, false);
//  }
//
//  /** {@inheritDoc} */
//  @Override
//  public DatePicker value(Date value, boolean silent) {
//    setValue(value);
//    return this;
//  }
//
//  /** {@inheritDoc} */
//  @Override
//  public Date getValue() {
//    return datePickerMonth.getValue();
//  }
//
//  /** {@inheritDoc} */
//  @Override
//  public void setValue(Date value) {
//    datePickerMonth.value(value);
//  }
//
//  /**
//   * Sets the date for the picker
//   *
//   * @param date the value
//   * @return same instance
//   */
//  public DatePicker setDate(Date date) {
//    this.value(date);
//    return this;
//  }
//
//  /** @return The current date value */
//  public Date getDate() {
//    return this.getValue();
//  }
//
//  /**
//   * Same as {@link DatePicker#setDate(Date)} but with {@link JsDate}
//   *
//   * @param jsDate the js date value
//   * @return same instance
//   */
//  public DatePicker setDate(JsDate jsDate) {
//    this.value(new Date(new Double(jsDate.getTime()).longValue()));
//    return this;
//  }
//
//  /** @return The value as {@link JsDate} */
//  public JsDate getJsDate() {
//    return new JsDate((double) getValue().getTime());
//  }
//
//  /**
//   * Adds a selection handler for date.
//   *
//   * <p>The handler will be called when selecting any date
//   *
//   * @param dateSelectionHandler the {@link DateSelectionHandler}
//   * @return same instance
//   */
//  public DatePicker addDateSelectionHandler(DateSelectionHandler dateSelectionHandler) {
//    this.dateSelectionHandlers.add(dateSelectionHandler);
//    return this;
//  }
//
//  /**
//   * Removes a selection handler
//   *
//   * @param dateSelectionHandler a {@link DateSelectionHandler} to be removed
//   * @return same instance
//   */
//  public DatePicker removeDateSelectionHandler(DateSelectionHandler dateSelectionHandler) {
//    this.dateSelectionHandlers.remove(dateSelectionHandler);
//    return this;
//  }
//
//  /** @return All the selection handlers added */
//  public List<DateSelectionHandler> getDateSelectionHandlers() {
//    return this.dateSelectionHandlers;
//  }
//
//  /**
//   * Removes all the selection handlers added
//   *
//   * @return same instance
//   */
//  public DatePicker clearDaySelectionHandlers() {
//    this.dateSelectionHandlers.clear();
//    return this;
//  }
//
//  /**
//   * Adds a new {@link DateDayClickedHandler}
//   *
//   * @param dateDayClickedHandler The new {@link DateDayClickedHandler} to add
//   * @return same instance
//   */
//  public DatePicker addDateDayClickHandler(DateDayClickedHandler dateDayClickedHandler) {
//    this.dateDayClickedHandlers.add(dateDayClickedHandler);
//    return this;
//  }
//
//  /**
//   * Removes a {@link DateDayClickedHandler}
//   *
//   * @param dateClickedHandler The {@link DateDayClickedHandler} to remove
//   * @return same instance
//   */
//  public DatePicker removeDateDayClickedHandler(DateDayClickedHandler dateClickedHandler) {
//    this.dateDayClickedHandlers.remove(dateClickedHandler);
//    return this;
//  }
//
//  /** @return All the {@link DateDayClickedHandler} defined */
//  public List<DateDayClickedHandler> getDateDayClickedHandlers() {
//    return this.dateDayClickedHandlers;
//  }
//
//  /**
//   * Removes all the {@link DateDayClickedHandler} defined
//   *
//   * @return same instance
//   */
//  public DatePicker clearDateDayClickedHandlers() {
//    this.dateDayClickedHandlers.clear();
//    return this;
//  }
//
//  /**
//   * Sets a new {@link DateTimeFormatInfo}
//   *
//   * @param dateTimeFormatInfo the new {@link DateTimeFormatInfo}
//   * @return same instance
//   */
//  public DatePicker setDateTimeFormatInfo(DateTimeFormatInfo dateTimeFormatInfo) {
//    this.datePickerMonth.setDateTimeFormatInfo(dateTimeFormatInfo);
//    updatePicker();
//    return this;
//  }
//
//  /** @return The {@link DateTimeFormatInfo} defined */
//  public DateTimeFormatInfo getDateTimeFormatInfo() {
//    return datePickerMonth.getDateTimeFormatInfo();
//  }
//
//  /**
//   * Adds border to the picker with a color defined in {@link ColorScheme} set for this picker
//   *
//   * @return same instance
//   */
//  public DatePicker showBorder() {
//    element.style().setBorder("1px solid " + colorScheme.color().getHex());
//    return this;
//  }
//
//  /**
//   * Sets the {@link ColorScheme}, the color scheme will be used to set the colors for header, body,
//   * and buttons defined in this picker
//   *
//   * @param colorScheme the new {@link ColorScheme}
//   * @return same instance
//   */
//  public DatePicker setColorScheme(ColorScheme colorScheme) {
//    backgroundHandler.onBackgroundChanged(getColorScheme(), colorScheme);
//    this.headerPanel.removeCss(this.colorScheme.color().getBackground());
//    this.dayName.removeCss(this.colorScheme.darker_2().getBackground());
//    this.colorScheme = colorScheme;
//    this.headerPanel.addCss(this.colorScheme.color().getBackground());
//    this.dayName.addCss(this.colorScheme.darker_2().getBackground());
//    this.datePickerMonth.setBackground(colorScheme.color());
//    this.todayButton.setColor(colorScheme.color());
//    this.closeButton.setColor(colorScheme.color());
//    this.clearButton.setColor(colorScheme.color());
//    this.resetButton.setColor(colorScheme.color());
//    return this;
//  }
//
//  /** @return The {@link ColorScheme} defined */
//  public ColorScheme getColorScheme() {
//    return colorScheme;
//  }
//
//  /** {@inheritDoc} */
//  @Override
//  public void onDaySelected(DatePickerElement datePickerElement) {
//    this.selectedPickerElement = datePickerElement;
//    this.jsDate.setTime(datePickerElement.getDate().getTime());
//    updatePicker();
//    publish();
//  }
//
//  /** {@inheritDoc} */
//  @Override
//  public void onDayClicked(DatePickerElement datePickerElement) {
//    for (DateDayClickedHandler dateDayClickedHandler : dateDayClickedHandlers) {
//      dateDayClickedHandler.onDateDayClicked(getDate(), getDateTimeFormatInfo());
//    }
//  }
//
//  private void publish() {
//    for (DateSelectionHandler dateSelectionHandler : dateSelectionHandlers) {
//      dateSelectionHandler.onDateSelected(getDate(), getDateTimeFormatInfo());
//    }
//  }
//
//  private void updatePicker() {
//    int dayNameIndex =
//        this.selectedPickerElement.getWeekDay() + getDateTimeFormatInfo().firstDayOfTheWeek();
//    if (dayNameIndex > 6) {
//      dayNameIndex =
//          this.selectedPickerElement.getWeekDay() + getDateTimeFormatInfo().firstDayOfTheWeek() - 7;
//    }
//    this.dayName.setTextContent(getDateTimeFormatInfo().weekdaysFull()[dayNameIndex]);
//    this.monthName.setTextContent(
//        getDateTimeFormatInfo().monthsFull()[this.selectedPickerElement.getMonth()]);
//    this.dateNumber.setTextContent(this.selectedPickerElement.getDay() + "");
//    this.yearNumber.setTextContent(this.selectedPickerElement.getYear() + "");
//    this.monthSelect.selectAt(this.selectedPickerElement.getMonth(), true);
//    this.yearSelect.setValue(this.selectedPickerElement.getYear(), true);
//  }
//
//  /**
//   * Shows the header of the picker
//   *
//   * @return same instance
//   */
//  public DatePicker showHeaderPanel() {
//    headerPanel.show();
//    return this;
//  }
//
//  /**
//   * Hides the header of the picker
//   *
//   * @return same instance
//   */
//  public DatePicker hideHeaderPanel() {
//    headerPanel.hide();
//    return this;
//  }
//
//  /**
//   * Shows {@code today} button which selects the current date
//   *
//   * @return same instance
//   */
//  public DatePicker showTodayButton() {
//    this.todayButtonContainer.show();
//    return this;
//  }
//
//  /**
//   * Hides the {@code today} button
//   *
//   * @return same instance
//   */
//  public DatePicker hideTodayButton() {
//    this.todayButtonContainer.hide();
//    return this;
//  }
//
//  /**
//   * Shows the {@code clear} button which clears the selected value of the picker
//   *
//   * @return same instance
//   */
//  public DatePicker showClearButton() {
//    this.clearButtonContainer.show();
//    return this;
//  }
//
//  /**
//   * Hides the {@code clear} button
//   *
//   * @return same instance
//   */
//  public DatePicker hideClearButton() {
//    this.clearButtonContainer.hide();
//    return this;
//  }
//
//  /**
//   * Shows the {@code close} button which closes the picker
//   *
//   * @return same instance
//   */
//  public DatePicker showCloseButton() {
//    this.closeButtonContainer.show();
//    return this;
//  }
//
//  /**
//   * Hides the {@code close} button
//   *
//   * @return same instance
//   */
//  public DatePicker hideCloseButton() {
//    this.closeButtonContainer.hide();
//    return this;
//  }
//
//  /**
//   * Shows the {@code reset} button which calls {@link DatePicker#resetHandlers} for resetting the
//   * value
//   *
//   * @return same instance
//   */
//  public DatePicker showResetButton() {
//    this.resetButtonContainer.show();
//    return this;
//  }
//
//  /**
//   * Hides the {@code reset} button
//   *
//   * @return same instance
//   */
//  public DatePicker hideResetButton() {
//    this.resetButtonContainer.hide();
//    return this;
//  }
//
//  /**
//   * Adds a close handler which will be called when the picker is closed
//   *
//   * @param closeHandler the new close {@link PickerHandler} to add
//   * @return same instance
//   */
//  public DatePicker addCloseHandler(PickerHandler closeHandler) {
//    this.closeHandlers.add(closeHandler);
//    return this;
//  }
//
//  /**
//   * Removes a close handler
//   *
//   * @param closeHandler the close {@link PickerHandler} to remove
//   * @return
//   */
//  public DatePicker removeCloseHandler(PickerHandler closeHandler) {
//    this.closeHandlers.remove(closeHandler);
//    return this;
//  }
//
//  /**
//   * Adds new reset handler to be called when reset button is clicked
//   *
//   * @param closeHandler the new reset {@link PickerHandler} to add
//   * @return same instance
//   */
//  public DatePicker addResetHandler(PickerHandler closeHandler) {
//    this.resetHandlers.add(closeHandler);
//    return this;
//  }
//
//  /**
//   * Removes a reset handler
//   *
//   * @param closeHandler the reset {@link PickerHandler} to remove
//   * @return same instance
//   */
//  public DatePicker removeResetHandler(PickerHandler closeHandler) {
//    this.resetHandlers.remove(closeHandler);
//    return this;
//  }
//
//  /** @return All the close handlers */
//  public List<PickerHandler> getCloseHandlers() {
//    return this.closeHandlers;
//  }
//
//  /** @return All the reset handlers */
//  public List<PickerHandler> getResetHandlers() {
//    return this.resetHandlers;
//  }
//
//  /**
//   * Adds clear handler to be called when clearing the picker value
//   *
//   * @param clearHandler the new clear {@link PickerHandler} to add
//   * @return same instance
//   */
//  public DatePicker addClearHandler(PickerHandler clearHandler) {
//    this.clearHandlers.add(clearHandler);
//    return this;
//  }
//
//  /**
//   * Removes a clear handler
//   *
//   * @param clearHandler the clear {@link PickerHandler} to remove
//   * @return same instance
//   */
//  public DatePicker removeClearHandler(PickerHandler clearHandler) {
//    this.clearHandlers.remove(clearHandler);
//    return this;
//  }
//
//  /** @return All the clear handlers */
//  public List<PickerHandler> getClearHandlers() {
//    return this.clearHandlers;
//  }
//
//  /**
//   * Sets the text for {@code today} button
//   *
//   * @param text the new text
//   * @return same instance
//   */
//  public DatePicker todayButtonText(String text) {
//    this.todayButton.setContent(text);
//    this.todayButton.element().title = text;
//    return this;
//  }
//
//  /**
//   * Sets the text for {@code clear} button
//   *
//   * @param text the new text
//   * @return same instance
//   */
//  public DatePicker clearButtonText(String text) {
//    this.clearButton.setContent(text);
//    this.clearButton.element().title = text;
//    return this;
//  }
//
//  /**
//   * Sets the text for {@code close} button
//   *
//   * @param text the new text
//   * @return same instance
//   */
//  public DatePicker closeButtonText(String text) {
//    this.closeButton.setContent(text);
//    this.closeButton.element().title = text;
//    return this;
//  }
//
//  /**
//   * Sets the text for {@code reset} button
//   *
//   * @param text the new text
//   * @return same instance
//   */
//  public DatePicker resetButtonText(String text) {
//    this.resetButton.setContent(text);
//    this.resetButton.element().title = text;
//    return this;
//  }
//
//  /**
//   * Sets the width of the picker as fixed and equals to the default value {@code 300px}
//   *
//   * @return same instance
//   */
//  public DatePicker fixedWidth() {
//    element.style().setWidth(px.of(300), true);
//    return this;
//  }
//
//  /**
//   * Sets the width of the picker as fixed and equals to {@code width}
//   *
//   * @param width the new width
//   * @return same instance
//   */
//  public DatePicker fixedWidth(String width) {
//    element.style().setWidth(width, true);
//    return this;
//  }
//
//  /** @return The header panel */
//  public DominoElement<HTMLDivElement> getHeaderPanel() {
//    return DominoElement.of(headerPanel);
//  }
//
//  /** @return The selectors panel */
//  public DominoElement<HTMLDivElement> getSelectorsPanel() {
//    return DominoElement.of(selectorsPanel);
//  }
//
//  /** @return The footer panel */
//  public DominoElement<HTMLDivElement> getFooterPanel() {
//    return DominoElement.of(footerPanel);
//  }
//
//  /** @return the day name panel */
//  public DominoElement<HTMLDivElement> getDayNamePanel() {
//    return DominoElement.of(dayName);
//  }
//
//  /** @return The month name panel */
//  public DominoElement<HTMLDivElement> getMonthNamePanel() {
//    return DominoElement.of(monthName);
//  }
//
//  /** @return The date number panel */
//  public DominoElement<HTMLDivElement> getDateNumberPanel() {
//    return DominoElement.of(dateNumber);
//  }
//
//  /** @return The year number panel */
//  public DominoElement<HTMLDivElement> getYearNumberPanel() {
//    return DominoElement.of(yearNumber);
//  }
//
//  /** @return The navigate before icon */
//  public MdiIcon getNavigateBefore() {
//    return navigateBefore;
//  }
//
//  /** @return The navigate next icon */
//  public MdiIcon getNavigateNext() {
//    return navigateNext;
//  }
//
//  /** @return The today button */
//  public Button getTodayButton() {
//    return todayButton;
//  }
//
//  /** @return The clear button */
//  public Button getClearButton() {
//    return clearButton;
//  }
//
//  /** @return The close button */
//  public Button getCloseButton() {
//    return closeButton;
//  }
//
//  /** @return The reset button */
//  public Button getResetButton() {
//    return resetButton;
//  }
//
//  DatePicker setBackgroundHandler(BackgroundHandler backgroundHandler) {
//    if (nonNull(backgroundHandler)) {
//      this.backgroundHandler = backgroundHandler;
//    }
//    return this;
//  }
//
//  /**
//   * Creates a modal from this picker.
//   *
//   * @param title the title of the modal
//   * @return A new {@link ModalDialog} with date picker inside
//   */
//  public ModalDialog createModal(String title) {
//    return ModalDialog.createPickerModal(title, this.element());
//  }
//
//  @FunctionalInterface
//  interface BackgroundHandler {
//    void onBackgroundChanged(ColorScheme oldColorScheme, ColorScheme newColorScheme);
//  }
//
//  /** A handler which will be called when date is selected */
//  @FunctionalInterface
//  public interface DateSelectionHandler {
//    /**
//     * This method will be called when the date is selected passing the selected date and the format
//     * used in the picker
//     *
//     * @param date the selected date
//     * @param dateTimeFormatInfo the format
//     */
//    void onDateSelected(Date date, DateTimeFormatInfo dateTimeFormatInfo);
//  }
//
//  /** A handler which will be called when the day is clicked */
//  @FunctionalInterface
//  public interface DateDayClickedHandler {
//    /**
//     * This method will be called when the day is clicked passing the selected date and the format
//     * used in the picker
//     *
//     * @param date the selected date
//     * @param dateTimeFormatInfo the format
//     */
//    void onDateDayClicked(Date date, DateTimeFormatInfo dateTimeFormatInfo);
//  }
//
//  /** A Wrapper class which creates {@link DateTimeFormat} */
//  public static class Formatter extends DateTimeFormat {
//
//    protected Formatter(String pattern) {
//      super(pattern);
//    }
//
//    protected Formatter(String pattern, DateTimeFormatInfo dtfi) {
//      super(pattern, dtfi);
//    }
//
//    /**
//     * Creates {@link DateTimeFormat} based on the patter and the format information
//     *
//     * @param pattern the pattern
//     * @param dateTimeFormatInfo the {@link DateTimeFormatInfo}
//     * @return new {@link DateTimeFormat} instance
//     */
//    public static DateTimeFormat getFormat(String pattern, DateTimeFormatInfo dateTimeFormatInfo) {
//      return DateTimeFormat.getFormat(pattern, dateTimeFormatInfo);
//    }
//  }
//}
