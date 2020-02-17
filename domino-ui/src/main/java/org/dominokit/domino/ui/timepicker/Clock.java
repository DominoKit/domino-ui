package org.dominokit.domino.ui.timepicker;

import elemental2.core.JsDate;
import org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo;

import java.util.Date;

interface Clock {

    void setDayPeriod(DayPeriod dayPeriod);

    int getHour();

    int getMinute();

    String format();

    String formatNoPeriod();

    String formatPeriod();

    int getStartHour();

    int getEndHour();

    void setHour(int hour);

    void setMinute(int minute);

    int getCorrectHour(int hour);

    void setDateTimeFormatInfo(DateTimeFormatInfo dateTimeFormatInfo);

    Date getTime();

    DayPeriod getDayPeriod();

    Clock getFor(JsDate jsDate);
}
