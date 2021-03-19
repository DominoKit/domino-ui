package org.dominokit.domino.ui.timepicker;

import elemental2.core.JsDate;
import org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo;

import java.util.Date;

import static org.dominokit.domino.ui.timepicker.DayPeriod.*;

/**
 * An implementation of {@link Clock} for 12h clock system
 */
class Clock12 extends AbstractClock {

    /**
     * 
     * @param dateTimeFormatInfo {@link DateTimeFormatInfo}
     * @see #setDateTimeFormatInfo(DateTimeFormatInfo)
     */
    public Clock12(DateTimeFormatInfo dateTimeFormatInfo) {
        this(new JsDate());
        this.dateTimeFormatInfo = dateTimeFormatInfo;
    }

    /**
     *
     * @param jsDate {@link JsDate} as initial time value
     */
    Clock12(JsDate jsDate) {
        this.dayPeriod = jsDate.getHours() > 11 ? PM : AM;
        this.minute = jsDate.getMinutes();
        this.second = jsDate.getSeconds();
        if (jsDate.getHours() > 12) {
            this.hour = jsDate.getHours() - 12;
        } else if (jsDate.getHours() == 0) {
            this.hour = 12;
        } else {
            this.hour = jsDate.getHours();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Clock getFor(JsDate jsDate) {
        return new Clock12(jsDate);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String format() {
        return formatNoPeriod() + " " + formatPeriod();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String formatNoPeriod() {
        String hourString = this.hour < 10 ? "0" + this.hour : this.hour + "";
        String minuteString = this.minute < 10 ? "0" + this.minute : this.minute + "";
        String secondString = this.second < 10 ? "0" + this.second : this.second + "";
        return hourString + ":" + minuteString + (showSecond ? ":" + secondString : "");
    }

    /**
     *
     * @return the String day period base on the clock DateTimeFormatInfo
     */
    @Override
    public String formatPeriod() {
        return AM.equals(dayPeriod) ? dateTimeFormatInfo.ampms()[0] : dateTimeFormatInfo.ampms()[1];
    }

    /**
     *
     * @return int, for this clock the value is constant 1
     */
    @Override
    public int getStartHour() {
        return 1;
    }

    /**
     *
     * @return int, for this clock the value is constant 12
     */
    @Override
    public int getEndHour() {
        return 12;
    }

    /**
     *
     * @param hour int, if the hour is in 24h system it will be changed to 12h system
     */
    @Override
    public void setHour(int hour) {
        this.hour = getCorrectHour(hour);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCorrectHour(int hour) {
        if (hour > 12) {
            return hour - 12;
        } else if (hour == 0) {
            return 12;
        } else {
            return hour;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date getTime() {
        JsDate jsDate = new JsDate();
        jsDate.setHours(DayPeriod.PM.equals(dayPeriod) ? hour + 12 : hour);
        jsDate.setMinutes(minute);
        jsDate.setSeconds(second);
        return new Date(new Double(jsDate.getTime()).longValue());
    }

}
