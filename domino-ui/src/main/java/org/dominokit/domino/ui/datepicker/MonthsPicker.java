package org.dominokit.domino.ui.datepicker;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo;

import java.util.Date;

public class MonthsPicker extends BaseDominoElement<HTMLDivElement, MonthsPicker> implements CalendarStyles, CalendarViewListener {

    private final DivElement root;
    private final IsCalendar calendar;

    public MonthsPicker(IsCalendar calendar) {
        this.calendar = calendar;
        this.root = div()
                .addCss(dui_month_selector);
        updateView();
        this.calendar.bindCalenderViewListener(this);
        init(this);
    }

    public static MonthsPicker create(IsCalendar isCalendar){
        return new MonthsPicker(isCalendar);
    }

    MonthsPicker updateView(){
        this.root.clearElement();
        String[] months = this.calendar.getDateTimeFormatInfo().monthsShort();

        int counter = 0;
        while (counter < 12) {
            DivElement monthsRow = div().addCss(dui_months_row);
            this.root.appendChild(monthsRow);
            for (int i = 0; i < 3; i++) {
                final int month = counter;
                monthsRow.appendChild(div()
                        .addCss(dui_month_selector_month,
                                BooleanCssClass.of(dui_current_month, isCurrentMonth(counter)),
                                BooleanCssClass.of(dui_selected_month, isSelectedMonth(counter))
                        )
                        .textContent(months[counter])
                        .addClickListener(evt -> {
                            Date calendarDate = calendar.getDate();
                            Date date = new Date(calendarDate.getTime());
                            date.setDate(1);
                            date.setMonth(month);
                            dispatchEvent(CalendarCustomEvents.dateNavigationChanged(date.getTime()));
                        })
                );
                counter++;
            }
        }
        return this;
    }

    @Override
    public void onDateTimeFormatInfoChanged(DateTimeFormatInfo dateTimeFormatInfo) {
        updateView();
    }

    private boolean isCurrentMonth(int counter) {
        return new Date().getMonth() == counter;
    }

    private boolean isSelectedMonth(int counter) {
        return counter == this.calendar.getDate().getMonth();
    }

    @Override
    public HTMLDivElement element() {
        return root.element();
    }
}