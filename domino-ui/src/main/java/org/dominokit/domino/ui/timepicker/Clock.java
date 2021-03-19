package org.dominokit.domino.ui.timepicker;

import elemental2.core.JsDate;
import org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo;

import java.util.Date;

/**
 * An interface to implement different types of clock styles
 * @see Clock12
 * @see Clock24
 */
interface Clock {

    /**
     *
     * @param dayPeriod {@link DayPeriod}
     */
    void setDayPeriod(DayPeriod dayPeriod);

    /**
     *
     * @return int hour
     */
    int getHour();

    /**
     *
     * @return int minute
     */
    int getMinute();

    /**
     *
     * @return int second
     */
    int getSecond();

    /**
     *
     * @return String formatted time
     */
    String format();

    /**
     *
     * @return String formatted time without the {@link DayPeriod}
     */
    String formatNoPeriod();

    /**
     *
     * @return String formatted {@link DayPeriod}
     */
    String formatPeriod();

    /**
     *
     * @return int first hour in the clock
     */
    int getStartHour();

    /**
     *
     * @return int last hour in the clock
     */
    int getEndHour();

    /**
     *
     * @param hour int
     */
    void setHour(int hour);

    /**
     *
     * @param minute int
     */
    void setMinute(int minute);

    /**
     *
     * @param second int
     */
    void setSecond(int second);

    /**
     *
     * @param showSecond boolean, true to show the seconds picker in the clock
     */
    void setShowSeconds(boolean showSecond);

    /**
     * Fix the specified hour to match the clock style
     * @param hour int in 24h system
     * @return int hour that match the clock style
     */
    int getCorrectHour(int hour);

    /**
     *
     * @param dateTimeFormatInfo {@link DateTimeFormatInfo} to be used for time and day period formatting
     */
    void setDateTimeFormatInfo(DateTimeFormatInfo dateTimeFormatInfo);

    /**
     *
     * @return Date
     */
    Date getTime();

    /**
     *
     * @return the {@link DayPeriod}
     */
    DayPeriod getDayPeriod();

    /**
     *
     * @param jsDate {@link JsDate}
     * @return a new Clock instance for the specified JsDate
     */
    Clock getFor(JsDate jsDate);
}
