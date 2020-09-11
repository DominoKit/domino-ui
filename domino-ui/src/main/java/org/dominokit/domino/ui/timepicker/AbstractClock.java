/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dominokit.domino.ui.timepicker;

import static org.dominokit.domino.ui.timepicker.DayPeriod.NONE;
import org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo;

abstract class AbstractClock implements Clock {

    protected DayPeriod dayPeriod = NONE;

    protected int hour;

    protected int minute;

    protected int second;

    protected DateTimeFormatInfo dateTimeFormatInfo;

    protected boolean showSecond = false;

    @Override
    public String formatPeriod() {
        return "";
    }

    @Override
    public DayPeriod getDayPeriod() {
        return dayPeriod;
    }

    @Override
    public void setDayPeriod(DayPeriod dayPeriod) {
        this.dayPeriod = dayPeriod;
    }

    @Override
    public int getHour() {
        return hour;
    }

    @Override
    public void setHour(int hour) {
        this.hour = hour;
    }

    @Override
    public int getMinute() {
        return minute;
    }

    @Override
    public void setMinute(int minute) {
        this.minute = minute;
    }

    @Override
    public int getSecond() {
        return second;
    }

    @Override
    public void setSecond(int second) {
        this.second = second;
    }

    public DateTimeFormatInfo getDateTimeFormatInfo() {
        return dateTimeFormatInfo;
    }

    @Override
    public void setDateTimeFormatInfo(DateTimeFormatInfo dateTimeFormatInfo) {
        this.dateTimeFormatInfo = dateTimeFormatInfo;
    }

    public boolean isShowSeconds() {
        return showSecond;
    }

    @Override
    public void setShowSeconds(boolean showSecond) {
        this.showSecond = showSecond;
    }

}
