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
//import static org.jboss.elemento.Elements.div;
//import static org.jboss.elemento.Elements.th;
//
//import elemental2.core.JsDate;
//import elemental2.dom.HTMLElement;
//import org.dominokit.domino.ui.style.Style;
//import org.dominokit.domino.ui.utils.DominoElement;
//import org.dominokit.domino.ui.utils.Selectable;
//import org.jboss.elemento.EventType;
//
///**
// * A component represents a day element on {@link DatePicker}
// *
// * @see Selectable
// * @see DatePicker
// */
//class DatePickerElement implements Selectable<DatePickerElement> {
//  private DominoElement<HTMLElement> element;
//  private int day;
//  private int month;
//  private int weekDay;
//  private int year;
//  private String text;
//  private boolean selected = false;
//
//  public DatePickerElement(HTMLElement element) {
//    this.element = DominoElement.of(element);
//  }
//
//  /**
//   * Creates a day header element at a specific {@code index}, the element will be added to the list
//   * of days of a month
//   *
//   * @param index the index of the day
//   * @param monthData the month days array
//   * @return new instance
//   */
//  public static DatePickerElement createDayHeader(int index, DatePickerElement[][] monthData) {
//    HTMLElement element = th().element();
//
//    DatePickerElement day = new DatePickerElement(element);
//    day.setDay(-1);
//    day.setMonth(-1);
//    day.setYear(-1);
//    day.setWeekDay(-1);
//    day.setText("");
//
//    monthData[0][index] = day;
//
//    return day;
//  }
//
//  /**
//   * Creates a day element at specific point {@code indexX} and {@code indexY}.
//   *
//   * <p>Each day element takes a handler to be called when it is selected
//   *
//   * @param indexX the x-axis of the point
//   * @param indexY the y-axis of the point
//   * @param monthData the month days array
//   * @param selectionHandler A {@link SelectionHandler} to be called when selecting the day
//   * @return new instance
//   */
//  public static DatePickerElement createDayElement(
//      int indexX, int indexY, DatePickerElement[][] monthData, SelectionHandler selectionHandler) {
//    HTMLElement element = div().element();
//    DatePickerElement day = new DatePickerElement(element);
//    day.setDay(-1);
//    day.setMonth(-1);
//    day.setYear(-1);
//    day.setWeekDay(-1);
//    day.setText("");
//
//    monthData[indexX][indexY] = day;
//
//    element.addEventListener(
//        EventType.click.getName(),
//        evt -> {
//          selectionHandler.selectElement(day);
//          selectionHandler.onElementClick(day);
//        });
//
//    return day;
//  }
//
//  /**
//   * Sets the text of the day
//   *
//   * @param text the text
//   */
//  public void setText(String text) {
//    this.text = text;
//    element.setTextContent(text);
//  }
//
//  /** @return The root day element */
//  public HTMLElement getElement() {
//    return element.element();
//  }
//
//  /** @return The day integer value */
//  public int getDay() {
//    return day;
//  }
//
//  /**
//   * Sets the day integer value
//   *
//   * @param day the integer value represents the day
//   */
//  public void setDay(int day) {
//    this.day = day;
//  }
//
//  /** @return The month that this day element belongs to */
//  public int getMonth() {
//    return month;
//  }
//
//  /**
//   * Sets the month that this day element belongs to
//   *
//   * @param month the integer value represents the month
//   */
//  public void setMonth(int month) {
//    this.month = month;
//  }
//
//  /** @return The week that this day element belongs to */
//  public int getWeekDay() {
//    return weekDay;
//  }
//
//  /**
//   * Sets the week that this day element belongs to
//   *
//   * @param weekDay the integer value represents the week
//   */
//  public void setWeekDay(int weekDay) {
//    this.weekDay = weekDay;
//  }
//
//  /** @return The year that this day element belongs to */
//  public int getYear() {
//    return year;
//  }
//
//  /**
//   * Sets the year that this day element belongs to
//   *
//   * @param year the integer value represents the year
//   */
//  public void setYear(int year) {
//    this.year = year;
//  }
//
//  /** @return The text of the element */
//  public String getText() {
//    return text;
//  }
//
//  /** {@inheritDoc} */
//  @Override
//  public DatePickerElement select() {
//    return select(true);
//  }
//
//  /** {@inheritDoc} */
//  @Override
//  public DatePickerElement deselect() {
//    return deselect(true);
//  }
//
//  /** {@inheritDoc} */
//  @Override
//  public DatePickerElement select(boolean silent) {
//    this.selected = true;
//    this.element.addCss(DatePickerStyles.SELECTED);
//    return this;
//  }
//
//  /** {@inheritDoc} */
//  @Override
//  public DatePickerElement deselect(boolean silent) {
//    this.selected = false;
//    this.element.removeCss(DatePickerStyles.SELECTED);
//    return this;
//  }
//
//  /** {@inheritDoc} */
//  @Override
//  public boolean isSelected() {
//    return selected;
//  }
//
//  /** @return The {@link JsDate} which represents this day element */
//  public JsDate getDate() {
//    JsDate tempDate = new JsDate();
//    return new JsDate(
//        year,
//        month,
//        DatePickerUtil.getValidMonthDate(year, month, day),
//        tempDate.getHours(),
//        tempDate.getMinutes(),
//        tempDate.getSeconds(),
//        tempDate.getMilliseconds());
//  }
//
//  /** @return The {@link Style} of this element */
//  public Style<HTMLElement, DominoElement<HTMLElement>> style() {
//    return element.style();
//  }
//
//  /** A handler which is called when selecting the element */
//  public interface SelectionHandler {
//    /**
//     * Will be called when selecting the item
//     *
//     * @param datePickerElement the selected {@link DatePickerElement}
//     */
//    void selectElement(DatePickerElement datePickerElement);
//
//    /**
//     * A method that will be called when the element is clicked
//     *
//     * @param datePickerElement the clicked {@link DatePickerElement}
//     */
//    void onElementClick(DatePickerElement datePickerElement);
//  }
//}
