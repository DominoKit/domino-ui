package org.dominokit.domino.ui.datepicker;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo;

public class WeekDayHeader extends BaseDominoElement<HTMLDivElement, WeekDayHeader> implements CalendarStyles, CalendarViewListener {

    private final DivElement root;
    private final IsCalendar calendar;
    private final int dayIndex;
    private final SpanElement dayElement;

    public WeekDayHeader(IsCalendar calendar, int dayIndex) {
        this.calendar = calendar;
        this.calendar.bindCalenderViewListener(this);
        this.dayIndex = dayIndex;
        this.root = div()
                .addCss(dui_week_day_header)
                .appendChild(dayElement = span()
                        .addCss(dui_day_header_name)
                        .textContent(this.calendar.getDateTimeFormatInfo().weekdaysShort()[dayIndex])
                );
        init(this);
        onDetached(mutationRecord -> this.calendar.unbindCalenderViewListener(this));
    }

    public static WeekDayHeader create(IsCalendar calendar, int dayIndex) {
        return new WeekDayHeader(calendar, dayIndex);
    }

    @Override
    public void onDateTimeFormatInfoChanged(DateTimeFormatInfo dateTimeFormatInfo) {
        dayElement
                .textContent(dateTimeFormatInfo.weekdaysShort()[dayIndex]);
        root.setTooltip(dateTimeFormatInfo.weekdaysFull()[dayIndex], DropDirection.TOP_MIDDLE);
    }

    @Override
    public HTMLDivElement element() {
        return root.element();
    }
}
