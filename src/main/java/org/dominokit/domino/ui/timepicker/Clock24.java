package org.dominokit.domino.ui.timepicker;

import elemental2.core.JsDate;
import org.gwtproject.i18n.shared.DateTimeFormatInfo;

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
    public Time getTime() {
        return new Time(hour, minute, dayPeriod);
    }
}
