package org.dominokit.domino.ui.timepicker;

import elemental2.core.JsDate;
import org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo;

import java.util.Date;

import static org.dominokit.domino.ui.timepicker.DayPeriod.NONE;

class Clock24 implements Clock {

    private DayPeriod dayPeriod = NONE;
    private int hour;
    private int minute;
    private int second;
    private DateTimeFormatInfo dateTimeFormatInfo;
    private boolean showSecond = false;

    public Clock24(DateTimeFormatInfo dateTimeFormatInfo) {
        this.dateTimeFormatInfo = dateTimeFormatInfo;
        JsDate date = new JsDate();
        this.hour = date.getHours();
        this.minute = date.getMinutes();
        this.second = date.getSeconds();
    }

    Clock24(JsDate jsDate) {
        this.hour = jsDate.getHours();
        this.minute = jsDate.getMinutes();
        this.second = jsDate.getSeconds();
    }

    @Override
    public Clock getFor(JsDate jsDate) {
        return new Clock24(jsDate);
    }

    @Override
    public DayPeriod getDayPeriod() {
        return dayPeriod;
    }


    @Override
    public int getHour() {
        return this.hour;
    }

    @Override
    public int getMinute() {
        return this.minute;
    }
    
    @Override
    public int getSecond() {
        return this.second;
    }

    @Override
    public void setShowSeconds(boolean showSecond) {
        this.showSecond = showSecond;
    }
    
    @Override
    public String format() {
        String hourString = this.hour < 10 ? "0" + this.hour : this.hour + "";
        String minuteString = this.minute < 10 ? "0" + this.minute : this.minute + "";
        String secondString = this.second < 10 ? "0" + this.second : this.second + "";
        return hourString + ":" + minuteString + (showSecond ?  ":" + secondString : "");
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
    public void setSecond(int second) {
        this.second = second;
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
        jsDate.setSeconds(second);
        return new Date(new Double(jsDate.getTime()).longValue());
    }
}
