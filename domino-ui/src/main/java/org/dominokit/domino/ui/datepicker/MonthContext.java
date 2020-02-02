package org.dominokit.domino.ui.datepicker;

import elemental2.core.JsDate;

public class MonthContext {

    private final int year;
    private final int month;
    private final int date;
    private final int day;
    private final int days;
    private final int firstDay;

    public MonthContext(int year, int month) {
        this(year, month, new JsDate().getDate());
    }
    public MonthContext(int year, int month, int date) {

        JsDate jsDate = new JsDate(year, month, DatePickerUtil.getValidMonthDate(year, month, date));

        this.year = jsDate.getFullYear();
        this.month = jsDate.getMonth();
        this.date = jsDate.getDate();
        this.day = jsDate.getDay();
        this.days = DatePickerUtil.getMonthDays(year, month);

        this.firstDay = new JsDate(year, month, 1).getDay();
    }

    public static MonthContext current() {
        JsDate date = new JsDate();
        return new MonthContext(date.getFullYear(), date.getMonth());
    }

    public static MonthContext offset(int offset) {
        JsDate date = new JsDate();
        return new MonthContext(date.getFullYear(), date.getMonth());
    }

    public MonthContext getMonthBefore() {
        return new MonthContext(month == 0 ? year - 1 : year, month == 0 ? 11 : (month - 1));
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDate() {
        return date;
    }

    public int getDay() {
        return day;
    }

    public int getDays() {
        return days;
    }

    public int getFirstDay() {
        return firstDay;
    }
}
