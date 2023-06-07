package org.dominokit.domino.ui.datepicker;

public interface CalendarPlugin {
    default void onCalendarDayAdded(CalendarDay calendarDay){}
    default void onInit(Calendar calendar){}

}
