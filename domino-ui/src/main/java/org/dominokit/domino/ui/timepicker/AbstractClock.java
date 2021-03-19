/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dominokit.domino.ui.timepicker;

import static org.dominokit.domino.ui.timepicker.DayPeriod.NONE;
import org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo;

/**
 * Base clock common implementation
 */
abstract class AbstractClock implements Clock {

    protected DayPeriod dayPeriod = NONE;

    protected int hour;

    protected int minute;

    protected int second;

    protected DateTimeFormatInfo dateTimeFormatInfo;

    protected boolean showSecond = false;

    /**
     * {@inheritDoc}
     * @return empty String
     */
    @Override
    public String formatPeriod() {
        return "";
    }

    /**
     * {@inheritDoc}
     * default to {@link DayPeriod#NONE}
     */
    @Override
    public DayPeriod getDayPeriod() {
        return dayPeriod;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDayPeriod(DayPeriod dayPeriod) {
        this.dayPeriod = dayPeriod;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getHour() {
        return hour;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setHour(int hour) {
        this.hour = hour;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getMinute() {
        return minute;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMinute(int minute) {
        this.minute = minute;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getSecond() {
        return second;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSecond(int second) {
        this.second = second;
    }

    /**
     *
     * @return the {@link DateTimeFormatInfo} for this clock
     */
    public DateTimeFormatInfo getDateTimeFormatInfo() {
        return dateTimeFormatInfo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDateTimeFormatInfo(DateTimeFormatInfo dateTimeFormatInfo) {
        this.dateTimeFormatInfo = dateTimeFormatInfo;
    }

    /**
     *
     * @return boolean, true if should show seconds
     */
    public boolean isShowSeconds() {
        return showSecond;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setShowSeconds(boolean showSecond) {
        this.showSecond = showSecond;
    }

}
