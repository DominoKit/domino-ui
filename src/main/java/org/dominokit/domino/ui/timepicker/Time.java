package org.dominokit.domino.ui.timepicker;

import elemental2.core.JsDate;

import java.util.Objects;

import static org.dominokit.domino.ui.timepicker.DayPeriod.AM;
import static org.dominokit.domino.ui.timepicker.DayPeriod.NONE;
import static org.dominokit.domino.ui.timepicker.DayPeriod.PM;

public class Time {
    private int hour;
    private int minute;
    private DayPeriod dayPeriod;

    public Time() {
        Clock12 clock12=new Clock12(new JsDate());
        this.hour = clock12.getHour();
        this.minute = clock12.getMinute();
        this.dayPeriod = clock12.getDayPeriod();
    }

    public Time(int hour, int minute, DayPeriod dayPeriod) {
        JsDate jsDate=new JsDate();
        jsDate.setHours(hour);
        jsDate.setMinutes(minute);
        Clock clock;
        if(NONE.equals(dayPeriod)){
            clock=new Clock24(jsDate);
        }else{
            clock=new Clock12(jsDate);
        }
        this.hour = clock.getHour();
        this.minute = clock.getMinute();
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
