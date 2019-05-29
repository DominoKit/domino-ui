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
        JsDate jsDate = new JsDate(year, month);
        this.year = jsDate.getFullYear();
        this.month = jsDate.getMonth();
        this.date = jsDate.getDate();
        this.day = jsDate.getDay();
        JsDate jsDateCalc = new JsDate(year, month, 32);
        this.days = (32 - (jsDateCalc.getDate()));
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
        return new MonthContext(month==0?year-1:year, month==0?11:(month-1));
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
