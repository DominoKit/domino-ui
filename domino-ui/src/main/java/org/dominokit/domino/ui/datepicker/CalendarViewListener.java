package org.dominokit.domino.ui.datepicker;

import org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo;

import java.util.Date;

public interface CalendarViewListener {
    default void onUpdateCalendarView(Date date){}
    default void onDateSelectionChanged(Date date){}
    default void onDateTimeFormatInfoChanged(DateTimeFormatInfo dateTimeFormatInfo){}
}
