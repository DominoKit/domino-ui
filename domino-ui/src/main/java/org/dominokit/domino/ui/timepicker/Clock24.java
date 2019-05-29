package org.dominokit.domino.ui.timepicker;

import elemental2.core.JsDate;
import org.gwtproject.i18n.shared.DateTimeFormatInfo;

import java.util.Date;

import static org.dominokit.domino.ui.timepicker.DayPeriod.NONE;

class Clock24 implements Clock {

    private DayPeriod dayPeriod = NONE;
    private int hour;
    private int minute;
    private DateTimeFormatInfo dateTimeFormatInfo;

    public Clock24(DateTimeFormatInfo dateTimeFormatInfo) {
        this.dateTimeFormatInfo = dateTimeFormatInfo;
        JsDate date = new JsDate();
        this.hour = date.getHours();
        this.minute = date.getMinutes();
    }

    Clock24(JsDate jsDate) {
        this.hour = jsDate.getHours();
        this.minute = jsDate.getMinutes();
    }

    @Override
    public Clock getFor(JsDate jsDate) {
        return new Clock24(jsDate);
    }

    @Override
    public DayPeriod getDayPeriod() {
        return dayPeriod;
    }


    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    @Override
    public String format() {
        String hourString = this.hour < 10 ? "0" + this.hour : this.hour + "";
        String minuteString = this.minute < 10 ? "0" + this.minute : this.minute + "";
        return hourString + ":" + minuteString;
    }

    @Override
    public String formatNoPeriod() {
        return format();
    }

    @Override
    public String formatPeriod() {
        return "";
    }

    @Override
    public int getStartHour() {
        return 0;
    }

    @Override
    public int getEndHour() {
        return 23;
    }

    @Override
    public void setDayPeriod(DayPeriod dayPeriod) {
        this.dayPeriod = NONE;
    }

    @Override
    public void setHour(int hour) {
        this.hour = hour;
    }

    @Override
    public void setMinute(int minute) {
        this.minute = minute;
    }

    @Override
    public int getCorrectHour(int hour) {
        return hour;
    }

    @Override
    public void setDateTimeFormatInfo(DateTimeFormatInfo dateTimeFormatInfo) {
        this.dateTimeFormatInfo = dateTimeFormatInfo;
    }

    @Override
    public Date getTime() {
        JsDate jsDate = new JsDate();
        jsDate.setHours(hour);
        jsDate.setMinutes(minute);
        return new Date(new Double(jsDate.getTime()).longValue());
    }
}
