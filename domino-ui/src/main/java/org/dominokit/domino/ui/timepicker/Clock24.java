package org.dominokit.domino.ui.timepicker;

import elemental2.core.JsDate;
import org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo;

import java.util.Date;

class Clock24 extends AbstractClock {

    public Clock24(DateTimeFormatInfo dateTimeFormatInfo) {
        this(new JsDate());
        this.dateTimeFormatInfo = dateTimeFormatInfo;
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
    public String format() {
        String hourString = this.hour < 10 ? "0" + this.hour : this.hour + "";
        String minuteString = this.minute < 10 ? "0" + this.minute : this.minute + "";
        String secondString = this.second < 10 ? "0" + this.second : this.second + "";
        return hourString + ":" + minuteString + (showSecond ? ":" + secondString : "");
    }

    @Override
    public String formatNoPeriod() {
        return format();
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
    public int getCorrectHour(int hour) {
        return hour;
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
