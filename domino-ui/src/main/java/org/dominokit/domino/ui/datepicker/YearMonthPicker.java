package org.dominokit.domino.ui.datepicker;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.spin.HSpinSelect;
import org.dominokit.domino.ui.spin.SpinItem;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo;

public class YearMonthPicker extends BaseDominoElement<HTMLDivElement, YearMonthPicker> implements CalendarStyles, CalendarViewListener {

    private final DivElement root;
    private final MonthsPicker monthsPicker;
    private final HSpinSelect<YearPicker> yearPickerSpin;
    private final IsCalendar calendar;

    public YearMonthPicker(IsCalendar calendar) {
        this.calendar = calendar;
        this.calendar.bindCalenderViewListener(this);

        this.root = div()
                .addCss(dui_calendar_months_years_selector)
                .appendChild(this.monthsPicker = MonthsPicker.create(this.calendar))
                .appendChild(
                        this.yearPickerSpin = HSpinSelect.<YearPicker>create()
                                .addCss(dui_calender_years_spin)

                );
        init(this);
    }

    public static YearMonthPicker create(IsCalendar calendar){
        return new YearMonthPicker(calendar);
    }

    private void updateView() {
        monthsPicker.updateView();
        YearPicker referenceCard = YearPicker.create(this.calendar, this.calendar.getDate().getYear());
        YearPicker previousCard = YearPicker.create(this.calendar, this.calendar.getDate().getYear() - 12);
        YearPicker nextCard = YearPicker.create(this.calendar, this.calendar.getDate().getYear() + 12);

        this.yearPickerSpin
                .reset()
                .appendChild(SpinItem.create(referenceCard)
                        .appendChild(previousCard)
                )
                .appendChild(SpinItem.create(referenceCard)
                        .appendChild(referenceCard)
                )
                .appendChild(SpinItem.create(referenceCard)
                        .appendChild(nextCard)
                )
                .moveToIndex(1)
                .apply(spin -> {
                    spin.addChangeListener((oldValue, yearsCard) -> {
                        int activeIndex = spin.indexOf(spin.getActiveItem());
                        if (activeIndex == spin.itemsCount() - 1) {
                            SpinItem<YearPicker> lastYearCard = spin.getItems().get(spin.itemsCount() - 1);
                            int refYear = lastYearCard.getValue().getReferenceYear() + 14;
                            YearPicker newCard = YearPicker.create(this.calendar, refYear);
                            spin.appendChild(SpinItem.create(newCard)
                                    .appendChild(newCard)
                            );
                        } else if (activeIndex == 0) {
                            int refYear = yearsCard.getReferenceYear() - 14;
                            YearPicker newCard = YearPicker.create(this.calendar, refYear);
                            spin.prependChild(SpinItem.create(newCard)
                                    .appendChild(newCard)
                            );
                        }
                    });
                });
    }

    @Override
    public YearMonthPicker show() {
        if (!isVisible()) {
            updateView();
        }
        return super.show();
    }

    @Override
    public HTMLDivElement element() {
        return root.element();
    }
}