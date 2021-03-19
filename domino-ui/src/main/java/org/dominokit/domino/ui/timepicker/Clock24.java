package org.dominokit.domino.ui.timepicker;

import elemental2.core.JsDate;
import org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo;

import java.util.Date;
/**
 * An implementation of {@link Clock} for 24h clock system
 */
class Clock24 extends AbstractClock {

    /**
     *
     * @param dateTimeFormatInfo {@link DateTimeFormatInfo}
     * @see #setDateTimeFormatInfo(DateTimeFormatInfo)
     */
    public Clock24(DateTimeFormatInfo dateTimeFormatInfo) {
        this(new JsDate());
        this.dateTimeFormatInfo = dateTimeFormatInfo;
    }

    /**
     *
     * @param jsDate {@link JsDate} as initial time value
     */
    Clock24(JsDate jsDate) {
        this.hour = jsDate.getHours();
        this.minute = jsDate.getMinutes();
        this.second = jsDate.getSeconds();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Clock getFor(JsDate jsDate) {
        return new Clock24(jsDate);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String format() {
        String hourString = this.hour < 10 ? "0" + this.hour : this.hour + "";
        String minuteString = this.minute < 10 ? "0" + this.minute : this.minute + "";
        String secondString = this.second < 10 ? "0" + this.second : this.second + "";
        return hourString + ":" + minuteString + (showSecond ? ":" + secondString : "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String formatNoPeriod() {
        return format();
    }

    /**
     *
     * @return int, for this clock the value is constant 0
     */
    @Override
    public int getStartHour() {
        return 0;
    }

    /**
     *
     * @return int, for this clock the value is constant 23
     */
    @Override
    public int getEndHour() {
        return 23;
    }
    /**
     * {@inheritDoc}
     * for this clock return sam hour
     */
    @Override
    public int getCorrectHour(int hour) {
        return hour;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date getTime() {
        JsDate jsDate = new JsDate();
        jsDate.setHours(hour);
        jsDate.setMinutes(minute);
        jsDate.setSeconds(second);
        return new Date(new Double(jsDate.getTime()).longValue());
    }

}
