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

import static java.util.Objects.nonNull;

import elemental2.dom.CustomEvent;
import elemental2.dom.HTMLDivElement;
import java.util.*;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.HasChangeListeners;
import org.dominokit.domino.ui.utils.LazyChild;
import org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo;
import org.gwtproject.i18n.shared.cldr.impl.DateTimeFormatInfo_factory;

/**
 * Calendar class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class Calendar extends BaseDominoElement<HTMLDivElement, Calendar>
    implements CalendarStyles, IsCalendar, HasChangeListeners<Calendar, Date> {

  private final DivElement root;
  private final Set<CalendarViewListener> calendarViewListeners = new HashSet<>();
  private final Set<ChangeListener<? super Date>> changeListeners = new HashSet<>();
  private final Set<DateSelectionListener> dateSelectionListeners = new HashSet<>();
  private final CalendarInitConfig config;
  private DateTimeFormatInfo dateTimeFormatInfo;
  private Date date;
  private DivElement calendarBody;
  private CalendarSelectors selectors;
  private CalendarMonth calendarMonth;
  private YearMonthPicker yearMonthPicker;
  private LazyChild<CalendarHeader> header;
  private LazyChild<DivElement> footer;
  private boolean changeListenersPaused;

  /** Constructor for Calendar. */
  public Calendar() {
    this(new Date(), new CalendarInitConfig());
  }

  /**
   * Constructor for Calendar.
   *
   * @param config a {@link org.dominokit.domino.ui.datepicker.CalendarInitConfig} object
   */
  public Calendar(CalendarInitConfig config) {
    this(new Date(), config);
  }

  /**
   * Constructor for Calendar.
   *
   * @param date a {@link java.util.Date} object
   */
  public Calendar(Date date) {
    this(date, DateTimeFormatInfo_factory.create(), new CalendarInitConfig());
  }

  /**
   * Constructor for Calendar.
   *
   * @param date a {@link java.util.Date} object
   * @param config a {@link org.dominokit.domino.ui.datepicker.CalendarInitConfig} object
   */
  public Calendar(Date date, CalendarInitConfig config) {
    this(date, DateTimeFormatInfo_factory.create(), config);
  }

  /**
   * Constructor for Calendar.
   *
   * @param date a {@link java.util.Date} object
   * @param dateTimeFormatInfo a {@link org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo} object
   */
  public Calendar(Date date, DateTimeFormatInfo dateTimeFormatInfo) {
    this(date, dateTimeFormatInfo, new CalendarInitConfig());
  }

  /**
   * Constructor for Calendar.
   *
   * @param date a {@link java.util.Date} object
   * @param dateTimeFormatInfo a {@link org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo} object
   * @param config a {@link org.dominokit.domino.ui.datepicker.CalendarInitConfig} object
   */
  public Calendar(Date date, DateTimeFormatInfo dateTimeFormatInfo, CalendarInitConfig config) {
    this.date = date;
    this.dateTimeFormatInfo = dateTimeFormatInfo;
    this.config = config;

    this.root =
        div()
            .addCss(dui_calendar)
            .apply(calendar -> header = LazyChild.of(CalendarHeader.create(this), calendar))
            .appendChild(selectors = CalendarSelectors.create(this))
            .appendChild(
                calendarBody =
                    div()
                        .addCss(dui_calendar_body)
                        .appendChild(calendarMonth = CalendarMonth.create(this))
                        .appendChild(yearMonthPicker = YearMonthPicker.create(this).hide()))
            .apply(
                calendar ->
                    this.footer = LazyChild.of(div().addCss(dui_calendar_footer), calendar));

    this.root.addEventListener(
        CalendarCustomEvents.DATE_NAVIGATION_CHANGED,
        evt -> {
          evt.stopPropagation();
          CalendarCustomEvents.UpdateDateEventData dateData =
              CalendarCustomEvents.UpdateDateEventData.of((CustomEvent<?>) evt);
          Date updatedDate = new Date(dateData.getTimestamp());
          onDateViewUpdate(updatedDate);
          calendarMonth.show();
          yearMonthPicker.hide();
        });

    this.root.addEventListener(
        CalendarCustomEvents.DUI_CALENDAR_DATE_SELECTION_CHANGED,
        evt -> {
          evt.stopPropagation();
          CalendarCustomEvents.UpdateDateEventData dateData =
              CalendarCustomEvents.UpdateDateEventData.of((CustomEvent<?>) evt);
          Date oldDate = this.date;
          Date updatedDate = new Date(dateData.getTimestamp());
          this.date = updatedDate;
          onDateSelectionChanged(updatedDate);
          calendarMonth.show();
          yearMonthPicker.hide();
          triggerChangeListeners(oldDate, this.date);
        });

    this.root.addEventListener(
        CalendarCustomEvents.SELECT_YEAR_MONTH,
        evt -> {
          evt.stopPropagation();
          if (calendarMonth.isVisible()) {
            calendarMonth.hide();
            yearMonthPicker.show();
            calendarBody.addCss(dui_p_x_1_5);
          } else {
            calendarMonth.show();
            yearMonthPicker.hide();
            calendarBody.removeCss(dui_p_x_1_5);
          }
        });
    init(this);
    onDateViewUpdate(this.date);
    onDateSelectionChanged(this.date);
    onDateTimeFormatChanged();
    getConfig().getPlugins().forEach(plugin -> plugin.onInit(this));
  }

  /**
   * create.
   *
   * @return a {@link org.dominokit.domino.ui.datepicker.Calendar} object
   */
  public static Calendar create() {
    return new Calendar(new Date(), new CalendarInitConfig());
  }

  /**
   * create.
   *
   * @param config a {@link org.dominokit.domino.ui.datepicker.CalendarInitConfig} object
   * @return a {@link org.dominokit.domino.ui.datepicker.Calendar} object
   */
  public static Calendar create(CalendarInitConfig config) {
    return new Calendar(new Date(), config);
  }

  /**
   * create.
   *
   * @param date a {@link java.util.Date} object
   * @return a {@link org.dominokit.domino.ui.datepicker.Calendar} object
   */
  public static Calendar create(Date date) {
    return new Calendar(date, DateTimeFormatInfo_factory.create(), new CalendarInitConfig());
  }

  /**
   * create.
   *
   * @param dateTimeFormatInfo a {@link org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo} object
   * @return a {@link org.dominokit.domino.ui.datepicker.Calendar} object
   */
  public static Calendar create(DateTimeFormatInfo dateTimeFormatInfo) {
    return new Calendar(new Date(), dateTimeFormatInfo, new CalendarInitConfig());
  }

  /**
   * create.
   *
   * @param date a {@link java.util.Date} object
   * @param config a {@link org.dominokit.domino.ui.datepicker.CalendarInitConfig} object
   * @return a {@link org.dominokit.domino.ui.datepicker.Calendar} object
   */
  public static Calendar create(Date date, CalendarInitConfig config) {
    return new Calendar(date, DateTimeFormatInfo_factory.create(), config);
  }

  /**
   * create.
   *
   * @param date a {@link java.util.Date} object
   * @param dateTimeFormatInfo a {@link org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo} object
   * @return a {@link org.dominokit.domino.ui.datepicker.Calendar} object
   */
  public static Calendar create(Date date, DateTimeFormatInfo dateTimeFormatInfo) {
    return new Calendar(date, dateTimeFormatInfo, new CalendarInitConfig());
  }

  /**
   * create.
   *
   * @param dateTimeFormatInfo a {@link org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo} object
   * @param config a {@link org.dominokit.domino.ui.datepicker.CalendarInitConfig} object
   * @return a {@link org.dominokit.domino.ui.datepicker.Calendar} object
   */
  public static Calendar create(DateTimeFormatInfo dateTimeFormatInfo, CalendarInitConfig config) {
    return new Calendar(new Date(), dateTimeFormatInfo, config);
  }

  /**
   * create.
   *
   * @param date a {@link java.util.Date} object
   * @param dateTimeFormatInfo a {@link org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo} object
   * @param config a {@link org.dominokit.domino.ui.datepicker.CalendarInitConfig} object
   * @return a {@link org.dominokit.domino.ui.datepicker.Calendar} object
   */
  public static Calendar create(
      Date date, DateTimeFormatInfo dateTimeFormatInfo, CalendarInitConfig config) {
    return new Calendar(date, dateTimeFormatInfo, config);
  }

  /** {@inheritDoc} */
  @Override
  public CalendarInitConfig getConfig() {
    return config;
  }

  private void onDateTimeFormatChanged() {
    new ArrayList<>(calendarViewListeners)
        .forEach(listener -> listener.onDateTimeFormatInfoChanged(getDateTimeFormatInfo()));
  }

  private void onDateViewUpdate(Date updatedDate) {
    new ArrayList<>(calendarViewListeners)
        .forEach(listener -> listener.onUpdateCalendarView(updatedDate));
  }

  private void onDateSelectionChanged(Date updatedDate) {
    new ArrayList<>(calendarViewListeners)
        .forEach(listener -> listener.onDateSelectionChanged(updatedDate));
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
   * @return a {@link org.dominokit.domino.ui.datepicker.Calendar} object
   */
  public Calendar setDate(Date date) {
    Date oldDate = this.date;
    this.date = date;
    onDateViewUpdate(this.date);
    onDateSelectionChanged(this.date);
    triggerChangeListeners(oldDate, this.date);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public DateTimeFormatInfo getDateTimeFormatInfo() {
    return dateTimeFormatInfo;
  }

  /**
   * Setter for the field <code>dateTimeFormatInfo</code>.
   *
   * @param dateTimeFormatInfo a {@link org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo} object
   * @return a {@link org.dominokit.domino.ui.datepicker.Calendar} object
   */
  public Calendar setDateTimeFormatInfo(DateTimeFormatInfo dateTimeFormatInfo) {
    this.dateTimeFormatInfo = dateTimeFormatInfo;
    onDateTimeFormatChanged();
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }

  /** {@inheritDoc} */
  @Override
  public void bindCalenderViewListener(CalendarViewListener listener) {
    if (nonNull(listener)) {
      calendarViewListeners.add(listener);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void unbindCalenderViewListener(CalendarViewListener listener) {
    if (nonNull(listener)) {
      calendarViewListeners.remove(listener);
    }
  }

  /**
   * withHeader.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.datepicker.Calendar} object
   */
  public Calendar withHeader(ChildHandler<Calendar, CalendarHeader> handler) {
    handler.apply(this, header.get());
    return this;
  }

  /**
   * withHeader.
   *
   * @return a {@link org.dominokit.domino.ui.datepicker.Calendar} object
   */
  public Calendar withHeader() {
    header.get();
    return this;
  }

  /**
   * withSelectors.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.datepicker.Calendar} object
   */
  public Calendar withSelectors(ChildHandler<Calendar, CalendarSelectors> handler) {
    handler.apply(this, selectors);
    return this;
  }

  /**
   * withBody.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.datepicker.Calendar} object
   */
  public Calendar withBody(ChildHandler<Calendar, DivElement> handler) {
    handler.apply(this, calendarBody);
    return this;
  }

  /**
   * withCalendarMonth.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.datepicker.Calendar} object
   */
  public Calendar withCalendarMonth(ChildHandler<Calendar, CalendarMonth> handler) {
    handler.apply(this, calendarMonth);
    return this;
  }

  /**
   * withYearMonthPicker.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.datepicker.Calendar} object
   */
  public Calendar withYearMonthPicker(ChildHandler<Calendar, YearMonthPicker> handler) {
    handler.apply(this, yearMonthPicker);
    return this;
  }

  /**
   * withFooter.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.datepicker.Calendar} object
   */
  public Calendar withFooter(ChildHandler<Calendar, DivElement> handler) {
    handler.apply(this, footer.get());
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Calendar pauseChangeListeners() {
    this.changeListenersPaused = true;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Calendar resumeChangeListeners() {
    this.changeListenersPaused = false;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Calendar togglePauseChangeListeners(boolean toggle) {
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
  public Calendar triggerChangeListeners(Date oldValue, Date newValue) {
    if (!this.changeListenersPaused) {
      this.changeListeners.forEach(
          changeListener -> changeListener.onValueChanged(oldValue, newValue));
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Set<DateSelectionListener> getDateSelectionListeners() {
    return this.dateSelectionListeners;
  }

  /**
   * addDateSelectionListener.
   *
   * @param listener a {@link org.dominokit.domino.ui.datepicker.DateSelectionListener} object
   * @return a {@link org.dominokit.domino.ui.datepicker.Calendar} object
   */
  public Calendar addDateSelectionListener(DateSelectionListener listener) {
    if (nonNull(listener)) {
      this.dateSelectionListeners.add(listener);
    }
    return this;
  }

  /**
   * removeDateSelectionListener.
   *
   * @param listener a {@link org.dominokit.domino.ui.datepicker.DateSelectionListener} object
   * @return a {@link org.dominokit.domino.ui.datepicker.Calendar} object
   */
  public Calendar removeDateSelectionListener(DateSelectionListener listener) {
    if (nonNull(listener)) {
      this.dateSelectionListeners.remove(listener);
    }
    return this;
  }
}
