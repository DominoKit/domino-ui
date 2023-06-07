package org.dominokit.domino.ui.datepicker;

import org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo;

import java.util.Date;
import java.util.Set;

public interface IsCalendar {
    Date getDate();
    DateTimeFormatInfo getDateTimeFormatInfo();
    void bindCalenderViewListener(CalendarViewListener listener);
    void unbindCalenderViewListener(CalendarViewListener listener);
    Set<DateSelectionListener> getDateSelectionListeners();

    CalendarInitConfig getConfig();
}
