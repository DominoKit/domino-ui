package org.dominokit.domino.ui.datepicker;

import elemental2.core.JsDate;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.Selectable;
import org.jboss.gwt.elemento.core.EventType;

import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.th;

class DatePickerElement implements Selectable<DatePickerElement> {
    private HTMLElement element;
    private int day;
    private int month;
    private int weekDay;
    private int year;
    private String text;
    private boolean selected=false;

    public DatePickerElement(HTMLElement element) {
        this.element = element;
    }

    public static DatePickerElement createDayHeader(int index, DatePickerElement[][] monthData) {
        HTMLElement element = th().asElement();

        DatePickerElement day = new DatePickerElement(element);
        day.setDay(-1);
        day.setMonth(-1);
        day.setYear(-1);
        day.setWeekDay(-1);
        day.setText("");

        monthData[0][index] = day;

        return day;
    }

    public static DatePickerElement createDayElement(int indexX, int indexY, DatePickerElement[][] monthData, SelectionHandler selectionHandler) {
        HTMLElement element = div().asElement();
        DatePickerElement day = new DatePickerElement(element);
        day.setDay(-1);
        day.setMonth(-1);
        day.setYear(-1);
        day.setWeekDay(-1);
        day.setText("");

        monthData[indexX][indexY] = day;

        element.addEventListener(EventType.click.getName(), evt -> selectionHandler.selectElement(day));

        return day;
    }

    public void setText(String text){
        this.text=text;
        element.textContent=text;
    }

    public HTMLElement getElement() {
        return element;
    }

    public void setElement(HTMLElement element) {
        this.element = element;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(int weekDay) {
        this.weekDay = weekDay;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getText() {
        return text;
    }

    @Override
    public DatePickerElement select() {
       return select(true);
    }

    @Override
    public DatePickerElement deselect() {
        return deselect(true);
    }

    @Override
    public DatePickerElement select(boolean silent) {
        this.selected=true;
        this.element.classList.add("selected");
        return this;
    }

    @Override
    public DatePickerElement deselect(boolean silent) {
        this.selected=false;
        this.element.classList.remove("selected");
        return this;
    }

    @Override
    public boolean isSelected() {
        return selected;
    }

    public JsDate getDate(){
        return new JsDate(year, month, day);
    }

    @FunctionalInterface
    public interface SelectionHandler{
        void selectElement(DatePickerElement datePickerElement);
    }
}
