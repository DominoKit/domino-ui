package org.dominokit.domino.ui.timepicker;

import elemental2.core.JsDate;

import java.util.Objects;

import static org.dominokit.domino.ui.timepicker.DayPeriod.AM;
import static org.dominokit.domino.ui.timepicker.DayPeriod.PM;

public class Time {
    private int hour;
    private int minute;
    private DayPeriod dayPeriod;

    public Time() {
        JsDate jsDate = new JsDate();
        this.hour = jsDate.getHours();
        this.minute = jsDate.getMinutes();
        this.dayPeriod = this.hour > 11 ? PM : AM;
    }

    public Time(int hour, int minute, DayPeriod dayPeriod) {
        this.hour = hour;
        this.minute = minute;
        this.dayPeriod = dayPeriod;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public DayPeriod getDayPeriod() {
        return dayPeriod;
    }

    public void setDayPeriod(DayPeriod dayPeriod) {
        this.dayPeriod = dayPeriod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return hour == time.hour &&
                minute == time.minute &&
                dayPeriod == time.dayPeriod;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hour, minute, dayPeriod);
    }
}
