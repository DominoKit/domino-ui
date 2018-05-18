package org.dominokit.domino.ui.timepicker;

import elemental2.core.JsDate;
import org.gwtproject.i18n.shared.DateTimeFormatInfo;

import static org.dominokit.domino.ui.timepicker.DayPeriod.*;

class Clock12 implements Clock {
    private int hour;
    private int minute;

    private DayPeriod dayPeriod;
    private DateTimeFormatInfo dateTimeFormatInfo;

    public Clock12(DateTimeFormatInfo dateTimeFormatInfo) {
        this.dateTimeFormatInfo = dateTimeFormatInfo;
        JsDate jsDate = new JsDate();
        this.setDayPeriod(jsDate.getHours() > 11 ? PM : AM);
        this.minute = jsDate.getMinutes();
        if (jsDate.getHours() > 12) {
            this.hour = jsDate.getHours() - 12;
        } else if (jsDate.getHours() == 0) {
            this.hour = 12;
        } else {
            this.hour = jsDate.getHours();
        }
    }

    public DayPeriod getDayPeriod() {
        return this.dayPeriod;
    }

    @Override
    public void setDayPeriod(DayPeriod dayPeriod) {
        if (!NONE.equals(dayPeriod))
            this.dayPeriod = dayPeriod;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return this.minute;
    }

    @Override
    public String format() {
        return formatNoPeriod() + " " + formatPeriod();
    }

    @Override
    public String formatNoPeriod() {
        String hourString = this.hour < 10 ? "0" + this.hour : this.hour + "";
        String minuteString = this.minute < 10 ? "0" + this.minute : this.minute + "";
        return hourString + ":" + minuteString;
    }

    @Override
    public String formatPeriod() {
        return AM.equals(dayPeriod) ? dateTimeFormatInfo.ampms()[0] : dateTimeFormatInfo.ampms()[1];
    }

    @Override
    public int getStartHour() {
        return 1;
    }

    @Override
    public int getEndHour() {
        return 12;
    }

    @Override
    public void setHour(int hour) {
        if (hour > 12) {
            this.hour = hour - 12;
        } else {
            this.hour = hour;
        }
    }

    @Override
    public void setMinute(int minute) {
        this.minute = minute;
    }

    @Override
    public int getCorrectHour(int hour) {
        if (hour > 12) {
            return hour - 12;
        } else {
            return hour;
        }
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
