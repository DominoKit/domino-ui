package org.dominokit.domino.ui.datepicker;

import com.google.gwt.user.client.TakesValue;
import elemental2.core.JsDate;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLTableElement;
import elemental2.dom.HTMLTableSectionElement;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.HasSelectSupport;
import org.dominokit.domino.ui.utils.HasValue;
import org.dominokit.domino.ui.utils.TextUtil;
import org.gwtproject.i18n.shared.DateTimeFormatInfo;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.core.builder.HtmlContentBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.datepicker.DatePickerElement.createDayElement;
import static org.dominokit.domino.ui.datepicker.DatePickerElement.createDayHeader;
import static org.jboss.gwt.elemento.core.Elements.*;

public class DatePickerMonth implements IsElement<HTMLDivElement>, HasSelectSupport<DatePickerElement>,
        HasValue<DatePickerMonth, Date>, DatePickerElement.SelectionHandler, TakesValue<Date> {

    private InternalHandler internalHandler;
    private JsDate date;
    private DateTimeFormatInfo dateTimeFormatInfo;
    private DatePickerElement[][] monthData = new DatePickerElement[7][7];
    private List<DaySelectionHandler> daySelectionHandlers = new ArrayList<>();
    private List<DayClickHandler> dayClickHandlers = new ArrayList<>();
    private DatePickerElement selectedElement;
    private Color background = Color.LIGHT_BLUE;

    private HTMLDivElement element = div().css(DatePickerStyles.DATE_PICKER_CONTAINER).asElement();

    public DatePickerMonth(JsDate date, DateTimeFormatInfo dateTimeFormatInfo, InternalHandler daySelectionHandler) {
        this.date = date;
        this.dateTimeFormatInfo = dateTimeFormatInfo;
        this.internalHandler = daySelectionHandler;
    }

    public void init() {
        createMarkup();
        update();
    }

    public static DatePickerMonth create(JsDate date, DateTimeFormatInfo dateTimeFormatInfo, InternalHandler daySelectionHandler) {
        return new DatePickerMonth(date, dateTimeFormatInfo, daySelectionHandler);
    }

    private void createMarkup() {
        HtmlContentBuilder<HTMLTableElement> table = table().css(DatePickerStyles.DATE_PICKER);

        HtmlContentBuilder<HTMLTableSectionElement> thead = thead()
                .add(tr()
                        .add(createDayHeader(0, monthData).getElement())
                        .add(createDayHeader(1, monthData).getElement())
                        .add(createDayHeader(2, monthData).getElement())
                        .add(createDayHeader(3, monthData).getElement())
                        .add(createDayHeader(4, monthData).getElement())
                        .add(createDayHeader(5, monthData).getElement())
                        .add(createDayHeader(6, monthData).getElement())
                );
        table.add(thead
        ).add(tbody()
                .add(tr()
                        .add(td().add(createDayElement(1, 0, monthData, this).getElement()))
                        .add(td().add(createDayElement(1, 1, monthData, this).getElement()))
                        .add(td().add(createDayElement(1, 2, monthData, this).getElement()))
                        .add(td().add(createDayElement(1, 3, monthData, this).getElement()))
                        .add(td().add(createDayElement(1, 4, monthData, this).getElement()))
                        .add(td().add(createDayElement(1, 5, monthData, this).getElement()))
                        .add(td().add(createDayElement(1, 6, monthData, this).getElement()))
                )
                .add(tr()
                        .add(td().add(createDayElement(2, 0, monthData, this).getElement()))
                        .add(td().add(createDayElement(2, 1, monthData, this).getElement()))
                        .add(td().add(createDayElement(2, 2, monthData, this).getElement()))
                        .add(td().add(createDayElement(2, 3, monthData, this).getElement()))
                        .add(td().add(createDayElement(2, 4, monthData, this).getElement()))
                        .add(td().add(createDayElement(2, 5, monthData, this).getElement()))
                        .add(td().add(createDayElement(2, 6, monthData, this).getElement()))
                )
                .add(tr()
                        .add(td().add(createDayElement(3, 0, monthData, this).getElement()))
                        .add(td().add(createDayElement(3, 1, monthData, this).getElement()))
                        .add(td().add(createDayElement(3, 2, monthData, this).getElement()))
                        .add(td().add(createDayElement(3, 3, monthData, this).getElement()))
                        .add(td().add(createDayElement(3, 4, monthData, this).getElement()))
                        .add(td().add(createDayElement(3, 5, monthData, this).getElement()))
                        .add(td().add(createDayElement(3, 6, monthData, this).getElement()))
                )
                .add(tr()
                        .add(td().add(createDayElement(4, 0, monthData, this).getElement()))
                        .add(td().add(createDayElement(4, 1, monthData, this).getElement()))
                        .add(td().add(createDayElement(4, 2, monthData, this).getElement()))
                        .add(td().add(createDayElement(4, 3, monthData, this).getElement()))
                        .add(td().add(createDayElement(4, 4, monthData, this).getElement()))
                        .add(td().add(createDayElement(4, 5, monthData, this).getElement()))
                        .add(td().add(createDayElement(4, 6, monthData, this).getElement()))
                )
                .add(tr()
                        .add(td().add(createDayElement(5, 0, monthData, this).getElement()))
                        .add(td().add(createDayElement(5, 1, monthData, this).getElement()))
                        .add(td().add(createDayElement(5, 2, monthData, this).getElement()))
                        .add(td().add(createDayElement(5, 3, monthData, this).getElement()))
                        .add(td().add(createDayElement(5, 4, monthData, this).getElement()))
                        .add(td().add(createDayElement(5, 5, monthData, this).getElement()))
                        .add(td().add(createDayElement(5, 6, monthData, this).getElement()))
                )
                .add(tr()
                        .add(td().add(createDayElement(6, 0, monthData, this).getElement()))
                        .add(td().add(createDayElement(6, 1, monthData, this).getElement()))
                        .add(td().add(createDayElement(6, 2, monthData, this).getElement()))
                        .add(td().add(createDayElement(6, 3, monthData, this).getElement()))
                        .add(td().add(createDayElement(6, 4, monthData, this).getElement()))
                        .add(td().add(createDayElement(6, 5, monthData, this).getElement()))
                        .add(td().add(createDayElement(6, 6, monthData, this).getElement()))
                )

        );

        element.appendChild(table.asElement());
    }

    private void update(JsDate jsDate) {
        this.date = jsDate;
        update();
    }

    private void update() {
        MonthContext monthContext = new MonthContext(date.getFullYear(), date.getMonth());
        fillWeekHeader();
        fillCurrentAndNextMonth(monthContext);
        fillPreviousMonth(monthContext);
    }

    private void fillPreviousMonth(MonthContext monthContext) {

        int columnIndex = monthContext.getFirstDay() - dateTimeFormatInfo.firstDayOfTheWeek();
        if (columnIndex < 0) {
            columnIndex = 7 + columnIndex;
        }

        int fillEnd = columnIndex == 0 ? 7 : columnIndex;
        MonthContext monthBefore = monthContext.getMonthBefore();
        int monthBeforeDay = monthBefore.getDays();

        for (int i = fillEnd - 1; i >= 0; i--) {
            DatePickerElement datePickerElement = monthData[1][i];
            fillPreviousMonthDay(monthContext, monthBeforeDay, i, datePickerElement);
            monthBeforeDay--;
        }
    }

    private void fillCurrentAndNextMonth(MonthContext monthContext) {


        int columnIndex = monthContext.getFirstDay() - dateTimeFormatInfo.firstDayOfTheWeek();
        if (columnIndex < 0) {
            columnIndex = 7 + columnIndex;
        }
        int startRow = 1;
        if (columnIndex == 0)
            startRow = 2;

        int dayNumber = 1;
        int row = startRow;
        int column;
        int nextMonthDay = 1;

        for (; dayNumber <= monthContext.getDays() || row < 7; row++) {
            for (column = columnIndex; column < 7; column++) {
                DatePickerElement datePickerElement = monthData[row][column];
                if (dayNumber <= monthContext.getDays()) {
                    fillMonthDay(monthContext, dayNumber, column, datePickerElement);
                    dayNumber++;
                } else {
                    fillNextMonthDay(monthContext, column, nextMonthDay, datePickerElement);
                    nextMonthDay++;
                }
            }

            columnIndex = 0;
        }
    }

    private void fillWeekHeader() {
        String[] days = dateTimeFormatInfo.weekdaysShort();
        String[] daysFull = dateTimeFormatInfo.weekdaysFull();
        int startIndex = dateTimeFormatInfo.firstDayOfTheWeek();

        for (int y = 0; y < 7; y++) {
            monthData[0][y].setText(days[startIndex]);
            monthData[0][y].getElement().setAttribute("title", TextUtil.firstLetterToUpper(daysFull[startIndex]));
            startIndex++;
            if (startIndex >= 7)
                startIndex = 0;
        }
    }

    private void fillPreviousMonthDay(MonthContext monthContext, int monthBeforeDay, int i, DatePickerElement datePickerElement) {
        datePickerElement.setText(monthBeforeDay + "");
        datePickerElement.setWeekDay(i);
        datePickerElement.setYear(monthContext.getMonth() > 0 ? monthContext.getYear() : monthContext.getYear() - 1);
        datePickerElement.setMonth(monthContext.getMonth() > 0 ? monthContext.getMonth() - 1 : 11);
        datePickerElement.setDay(monthBeforeDay);
        styleOtherMonth(datePickerElement);
    }

    private void fillNextMonthDay(MonthContext monthContext, int column, int nextMonthDay, DatePickerElement datePickerElement) {
        datePickerElement.setText(nextMonthDay + "");
        datePickerElement.setWeekDay(column);
        datePickerElement.setYear(monthContext.getMonth() < 11 ? monthContext.getYear() : monthContext.getYear() + 1);
        datePickerElement.setMonth(monthContext.getMonth() < 11 ? monthContext.getMonth() + 1 : 0);
        datePickerElement.setDay(nextMonthDay);
        styleOtherMonth(datePickerElement);
    }

    private void fillMonthDay(MonthContext monthContext, int dayNumber, int column, DatePickerElement datePickerElement) {
        datePickerElement.setText(dayNumber + "");
        styleCurrentMonth(datePickerElement);
        datePickerElement.setWeekDay(column);
        datePickerElement.setYear(monthContext.getYear());
        datePickerElement.setMonth(monthContext.getMonth());
        datePickerElement.setDay(dayNumber);
        if (dayNumber == date.getDate())
            selectElement(datePickerElement);
    }

    private void styleOtherMonth(DatePickerElement datePickerElement) {
        Style.of(datePickerElement.getElement())
                .remove(DatePickerStyles.OTHER_MONTH, DatePickerStyles.CURRENT_MONTH)
                .add(DatePickerStyles.OTHER_MONTH);
    }

    private void styleCurrentMonth(DatePickerElement datePickerElement) {
        Style.of(datePickerElement.getElement())
                .remove(DatePickerStyles.OTHER_MONTH, DatePickerStyles.CURRENT_MONTH)
                .add(DatePickerStyles.CURRENT_MONTH);
    }

    public void addDaySelectionHandler(DaySelectionHandler daySelectionHandler) {
        this.daySelectionHandlers.add(daySelectionHandler);
    }

    public void removeDaySelectionHandler(DaySelectionHandler daySelectionHandler) {
        this.daySelectionHandlers.remove(daySelectionHandler);
    }

    public List<DaySelectionHandler> getDaySelectionHandlers() {
        return this.daySelectionHandlers;
    }

    public void clearDaySelectionHandlers() {
        this.daySelectionHandlers.clear();
    }


    public void addDayClickHandler(DayClickHandler dayClickHandler) {
        this.dayClickHandlers.add(dayClickHandler);
    }

    public void removeDayClickHandler(DayClickHandler dayClickHandler) {
        this.dayClickHandlers.remove(dayClickHandler);
    }

    public List<DayClickHandler> getDayClickHandlers() {
        return this.dayClickHandlers;
    }

    public void clearDayClickHandlers() {
        this.dayClickHandlers.clear();
    }

    @Override
    public HTMLDivElement asElement() {
        return element;
    }

    @Override
    public DatePickerElement getSelectedItem() {
        return selectedElement;
    }

    @Override
    public DatePickerMonth value(Date value) {
        setValue(value);
        return this;
    }

    @Override
    public Date getValue() {
        return new Date(new Double(getSelectedItem().getDate().getTime()).longValue());
    }

    @Override
    public void setValue(Date value) {
        JsDate jsDate = new JsDate((double)value.getTime());
        JsDate currentDate=new JsDate();
        jsDate.setHours(currentDate.getHours(), currentDate.getMinutes(), currentDate.getSeconds(), currentDate.getMilliseconds());
        update(jsDate);
    }

    @Override
    public void selectElement(DatePickerElement datePickerElement) {
        if (date.getFullYear() == datePickerElement.getDate().getFullYear() && date.getMonth() == datePickerElement.getDate().getMonth()) {
            deselect();
            select(datePickerElement);
        } else {
            update(datePickerElement.getDate());
        }
    }

    @Override
    public void onElementClick(DatePickerElement datePickerElement) {
        if (nonNull(internalHandler)) {
            internalHandler.onDayClicked(datePickerElement);
        }
        informClickHandlers(datePickerElement);
    }



    private void select(DatePickerElement datePickerElement) {
        datePickerElement.select();
        datePickerElement.style().add(this.background.getBackground());
        this.selectedElement = datePickerElement;
        if (nonNull(internalHandler))
            internalHandler.onDaySelected(datePickerElement);
        informSelectionHandlers(datePickerElement);
    }

    private void deselect() {
        if (nonNull(selectedElement)) {
            selectedElement.deselect();
            selectedElement.style().remove(this.background.getBackground());
        }
    }

    private void informSelectionHandlers(DatePickerElement datePickerElement) {
        getDaySelectionHandlers().forEach(daySelectionHandler -> {
            daySelectionHandler.onDaySelected(datePickerElement);
        });
    }

    private void informClickHandlers(DatePickerElement datePickerElement) {
        getDayClickHandlers().forEach(dayClickHandler -> {
            dayClickHandler.onDayClicked(datePickerElement);
        });
    }

    public void setDateTimeFormatInfo(DateTimeFormatInfo dateTimeFormatInfo) {
        this.dateTimeFormatInfo = dateTimeFormatInfo;
        update();
    }

    public DateTimeFormatInfo getDateTimeFormatInfo() {
        return dateTimeFormatInfo;
    }

    public void setBackground(Color background) {
        getSelectedItem().style().remove(this.background.getBackground());
        this.background = background;
        getSelectedItem().style().add(this.background.getBackground());
    }

    @FunctionalInterface
    interface DaySelectionHandler {
        void onDaySelected(DatePickerElement datePickerElement);
    }

    @FunctionalInterface
    interface DayClickHandler {
        void onDayClicked(DatePickerElement datePickerElement);
    }

    protected interface InternalHandler extends DaySelectionHandler, DayClickHandler{

    }
}
