package org.dominokit.domino.ui.datepicker;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo;
import org.gwtproject.i18n.shared.cldr.impl.DateTimeFormatInfo_factory;

import java.util.Date;

import static java.util.Objects.isNull;

public class CalendarHeader extends BaseDominoElement<HTMLDivElement, CalendarHeader> implements CalendarStyles, CalendarViewListener {

    private final DivElement root;
    private final IsCalendar calendar;
    private SpanElement dateElement;
    private SpanElement dayElement;
    private SpanElement montAndYearElement;

    public CalendarHeader(IsCalendar calendar) {
        this.calendar = calendar;
        this.calendar.bindCalenderViewListener(this);
        this.root = div()
                .addCss(dui_calendar_header)
                .appendChild(div()
                        .addCss(dui_calendar_header_date)
                        .appendChild(
                                dateElement = span()
                                        .addCss(dui_calendar_header_date_number)
                        )
                        .appendChild(div()
                                .addCss(dui_calendar_header_date_day_month_year)
                                .appendChild(dayElement = span().addCss(dui_calendar_header_date_day).textContent("Wednesday"))
                                .appendChild(montAndYearElement = span().addCss(dui_calendar_header_date_month_year).textContent("May, 2023"))
                        )
                );
        init(this);
    }

    public static CalendarHeader create(IsCalendar calendar){
        return new CalendarHeader(calendar);
    }

    @Override
    public HTMLDivElement element() {
        return root.element();
    }

    @Override
    public void onDateSelectionChanged(Date date) {
        if(isNull(date)){
            updateView(new Date());
        }else {
            updateView(date);
        }
    }

    private void updateView(Date date) {
        int year = date.getYear();
        int month = date.getMonth();
        int dateDate = date.getDate();
        int day = date.getDay();
        this.dateElement.textContent(String.valueOf(dateDate));
        this.dayElement.textContent(this.calendar.getDateTimeFormatInfo().weekdaysFull()[day]);
        this.montAndYearElement.textContent(this.calendar.getDateTimeFormatInfo().monthsFull()[month]+", "+(year+1900));
    }
}