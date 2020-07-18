package org.dominokit.domino.ui.datepicker;

import org.dominokit.domino.ui.grid.flex.FlexAlign;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexJustifyContent;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.gwtproject.editor.client.TakesValue;
import elemental2.core.JsDate;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.forms.Select;
import org.dominokit.domino.ui.forms.SelectOption;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.modals.ModalDialog;
import org.dominokit.domino.ui.pickers.PickerHandler;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.style.Elevation;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasValue;
import org.gwtproject.i18n.shared.DateTimeFormat;
import org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo;
import org.gwtproject.i18n.shared.cldr.impl.DateTimeFormatInfo_factory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.style.Unit.px;
import static org.jboss.elemento.Elements.div;

public class DatePicker extends BaseDominoElement<HTMLDivElement, DatePicker> implements HasValue<DatePicker, Date>,
        DatePickerMonth.InternalHandler, TakesValue<Date> {

    private final JsDate jsDate;
    private DominoElement<HTMLDivElement> element = DominoElement.of(div()
            .css(DatePickerStyles.CALENDAR))
            .elevate(Elevation.LEVEL_1);
    private DominoElement<HTMLDivElement> headerPanel = DominoElement.of(div().css(DatePickerStyles.DATE_PANEL));
    private DominoElement<HTMLDivElement> selectorsPanel = DominoElement.of(div().css(DatePickerStyles.SELECTOR_CONTAINER));
    private FlexLayout footerPanel = FlexLayout.create().css(DatePickerStyles.CAL_FOOTER);

    private DominoElement<HTMLDivElement> dayName = DominoElement.of(div().css(DatePickerStyles.DAY_NAME));
    private DominoElement<HTMLDivElement> monthName = DominoElement.of(div().css(DatePickerStyles.MONTH_NAME));
    private DominoElement<HTMLDivElement> dateNumber = DominoElement.of(div().css(DatePickerStyles.DAY_NUMBER));
    private DominoElement<HTMLDivElement> yearNumber = DominoElement.of(div().css(DatePickerStyles.YEAR_NUMBER));
    private Icon navigateBefore;
    private Icon navigateNext;

    private Select<Integer> yearSelect;
    private Select<Integer> monthSelect;
    private Button todayButton;
    private Button clearButton;
    private Button closeButton;
    private Button resetButton;

    private ColorScheme colorScheme = ColorScheme.LIGHT_BLUE;

    private final DatePickerMonth datePickerMonth;
    private DatePickerElement selectedPickerElement;

    private List<PickerHandler> closeHandlers = new ArrayList<>();
    private List<PickerHandler> resetHandlers = new ArrayList<>();
    private List<PickerHandler> clearHandlers = new ArrayList<>();
    private BackgroundHandler backgroundHandler = (oldBackground, newBackground) -> {
    };

    private JsDate minDate;
    private JsDate maxDate;

    private List<DateSelectionHandler> dateSelectionHandlers = new ArrayList<>();
    private List<DateDayClickedHandler> dateDayClickedHandlers = new ArrayList<>();
    private FlexItem clearButtonContainer;
    private FlexItem todayButtonContainer;
    private FlexItem resetButtonContainer;
    private FlexItem closeButtonContainer;


    public DatePicker(Date date, DateTimeFormatInfo dateTimeFormatInfo) {

        this.jsDate = new JsDate((double) date.getTime());

        this.minDate = new JsDate((double) date.getTime());
        minDate.setFullYear(minDate.getFullYear() - 50);

        this.maxDate = new JsDate((double) date.getTime());
        maxDate.setFullYear(maxDate.getFullYear() + 50);

        datePickerMonth = DatePickerMonth.create(this.jsDate, dateTimeFormatInfo, this);
        build();
    }

    public DatePicker(Date date, DateTimeFormatInfo dateTimeFormatInfo, Date minDate, Date maxDate) {
        this.jsDate = new JsDate((double) date.getTime());
        this.minDate = new JsDate((double) minDate.getTime());
        this.maxDate = new JsDate((double) maxDate.getTime());
        datePickerMonth = DatePickerMonth.create(this.jsDate, dateTimeFormatInfo, this);
        build();
    }

    private DatePicker(JsDate date, DateTimeFormatInfo dateTimeFormatInfo, JsDate minDate, JsDate maxDate) {
        this.jsDate = date;
        this.minDate = minDate;
        this.maxDate = maxDate;
        datePickerMonth = DatePickerMonth.create(this.jsDate, dateTimeFormatInfo, this);
        build();
    }

    private void build() {

        element.appendChild(headerPanel);
        headerPanel.style().add(colorScheme.color().getBackground());
        dayName.style().add(colorScheme.darker_2().getBackground());
        headerPanel.appendChild(dayName);
        headerPanel.appendChild(monthName);
        headerPanel.appendChild(dateNumber);
        headerPanel.appendChild(yearNumber);

        element.appendChild(selectorsPanel);
        initSelectors();
        element.appendChild(datePickerMonth);
        element.appendChild(footerPanel);
        initFooter();

        datePickerMonth.init();
    }


    private void initFooter() {

        clearButton = Button.create("CLEAR")
                .setColor(colorScheme.color())
                .css(DatePickerStyles.CAL_BUTTON);

        clearButton.addClickListener(evt -> {
            clearHandlers.forEach(PickerHandler::handle);
        });

        todayButton = Button.create("TODAY").setColor(colorScheme.color())
                .css(DatePickerStyles.CAL_BUTTON);
        todayButton.addClickListener(evt -> setDate(new Date()));

        closeButton = Button.create("CLOSE").setColor(colorScheme.color())
                .css(DatePickerStyles.CAL_BUTTON);

        closeButton.addClickListener(evt -> {
            closeHandlers.forEach(PickerHandler::handle);
        });

        resetButton = Button.create("RESET").setColor(colorScheme.color())
                .css(DatePickerStyles.CAL_BUTTON);

        resetButton.addClickListener(evt -> {
            resetHandlers.forEach(PickerHandler::handle);
        });

        clearButtonContainer = FlexItem.create();
        todayButtonContainer = FlexItem.create();
        resetButtonContainer = FlexItem.create();
        closeButtonContainer = FlexItem.create();
        footerPanel
                .setJustifyContent(FlexJustifyContent.SPACE_EVENLY)
                .setAlignItems(FlexAlign.CENTER)
                .appendChild(clearButtonContainer
                        .appendChild(clearButton.linkify())
                )
                .appendChild(todayButtonContainer
                        .appendChild(todayButton.linkify())
                )
                .appendChild(this.resetButtonContainer
                        .appendChild(resetButton.linkify())
                )
                .appendChild(closeButtonContainer
                        .appendChild(closeButton.linkify())
                );

        hideResetButton();

    }

    private void initSelectors() {

        int year = jsDate.getFullYear();
        yearSelect = Select.<Integer>create()
                .css(DatePickerStyles.SELECTOR);

        yearSelect.getLeftAddonContainer().remove();
        yearSelect.getMandatoryAddOn().css(Styles.m_l_40);
        yearSelect.setPopupWidth(150);

        for (int i = minDate.getFullYear(); i <= maxDate.getFullYear(); i++) {
            SelectOption<Integer> yearOption = SelectOption.create(i, i + "");
            yearSelect.appendChild(yearOption);

            if (i == year)
                yearSelect.select(yearOption);
        }
        yearSelect.addSelectionHandler(option -> {
            int selectedYear = option.getValue();
            jsDate.setYear(selectedYear);
            setDate(jsDate);
        });

        int month = jsDate.getMonth();
        monthSelect = Select.<Integer>create()
                .css(DatePickerStyles.SELECTOR);
        monthSelect.getLeftAddonContainer().remove();
        monthSelect.getMandatoryAddOn().css(Styles.m_l_40);
        monthSelect.setPopupWidth(150);

        String[] months = getDateTimeFormatInfo().monthsShort();
        for (int i = 0; i < months.length; i++) {
            SelectOption<Integer> monthOption = SelectOption.create(i, months[i]);
            monthSelect.appendChild(monthOption);
            if (i == month)
                monthSelect.select(monthOption);
        }
        monthSelect.addSelectionHandler(option -> {
            int selectedMonth = option.getValue();
            jsDate.setDate(DatePickerUtil.getValidMonthDate(jsDate.getFullYear(), selectedMonth, jsDate.getDate()));
            jsDate.setMonth(selectedMonth);
            setDate(jsDate);
        });

        Column yearColumn = Column.span5()
                .condenced()
                .appendChild(yearSelect.element());

        Column monthColumn = Column.span5()
                .condenced()
                .appendChild(monthSelect.element());

        Column backColumn = Column.span1()
                .condenced();

        Column forwardColumn = Column.span1()
                .condenced();

        Row row = Row.create()
                .setGap(px.of(5))
                .styler(style -> style
                        .add(DatePickerStyles.SELECTOR_ROW));
        navigateBefore = Icons.ALL.navigate_before()
                .clickable()
                .styler(style -> style.add(Styles.m_r_5))
                .addClickListener(evt -> {
                    JsDate jsDate = getJsDate();
                    int currentMonth = jsDate.getMonth();
                    if (currentMonth == 0) {
                        jsDate.setYear(jsDate.getFullYear() - 1);
                        jsDate.setMonth(11);
                    } else {
                        jsDate.setMonth(currentMonth - 1);
                    }

                    yearSelect.setValue(jsDate.getFullYear(), true);
                    monthSelect.selectAt(jsDate.getMonth(), true);
                    setDate(jsDate);
                });

        navigateNext = Icons.ALL.navigate_next()
                .clickable()
                .styler(style -> style.add(Styles.m_l_5))
                .addClickListener(evt -> {
                    JsDate jsDate = getJsDate();
                    int currentMonth = jsDate.getMonth();
                    if (currentMonth == 11) {
                        jsDate.setYear(jsDate.getFullYear() + 1);
                        jsDate.setMonth(0);
                    } else {
                        jsDate.setMonth(currentMonth + 1);
                    }

                    yearSelect.setValue(jsDate.getFullYear(), true);
                    monthSelect.selectAt(jsDate.getMonth(), true);
                    setDate(jsDate);
                });


        selectorsPanel.appendChild(row
                .appendChild(backColumn.appendChild(navigateBefore))
                .appendChild(yearColumn)
                .appendChild(monthColumn)
                .appendChild(forwardColumn.appendChild(navigateNext)));
    }


    public static DatePicker create() {
        DateTimeFormatInfo dateTimeFormatInfo = DateTimeFormatInfo_factory.create();

        return new DatePicker(new Date(), dateTimeFormatInfo);
    }

    public static DatePicker create(Date date) {
        DateTimeFormatInfo dateTimeFormatInfo = DateTimeFormatInfo_factory.create();
        return new DatePicker(date, dateTimeFormatInfo);
    }

    public static DatePicker create(Date date, Date minDate, Date maxDate) {
        DateTimeFormatInfo dateTimeFormatInfo = DateTimeFormatInfo_factory.create();
        return new DatePicker(date, dateTimeFormatInfo, minDate, maxDate);
    }

    public static DatePicker create(Date date, DateTimeFormatInfo dateTimeFormatInfo) {
        return new DatePicker(date, dateTimeFormatInfo);
    }

    public static DatePicker create(Date date, DateTimeFormatInfo dateTimeFormatInfo, Date minDate, Date maxDate) {
        return new DatePicker(date, dateTimeFormatInfo, minDate, maxDate);
    }

    @Override
    public HTMLDivElement element() {
        return element.element();
    }

    @Override
    public DatePicker value(Date value) {
        setValue(value);
        return this;
    }

    @Override
    public Date getValue() {
        return datePickerMonth.getValue();
    }

    @Override
    public void setValue(Date value) {
        datePickerMonth.value(value);
    }

    public DatePicker setDate(Date date) {
        this.value(date);
        return this;
    }

    public Date getDate() {
        return this.getValue();
    }

    public DatePicker setDate(JsDate jsDate) {
        this.value(new Date(new Double(jsDate.getTime()).longValue()));
        return this;
    }

    public JsDate getJsDate() {
        return new JsDate((double) getValue().getTime());
    }

    public DatePicker addDateSelectionHandler(DateSelectionHandler dateSelectionHandler) {
        this.dateSelectionHandlers.add(dateSelectionHandler);
        return this;
    }

    public DatePicker removeDateSelectionHandler(DateSelectionHandler dateSelectionHandler) {
        this.dateSelectionHandlers.remove(dateSelectionHandler);
        return this;
    }

    public List<DateSelectionHandler> getDateSelectionHandlers() {
        return this.dateSelectionHandlers;
    }

    public DatePicker clearDaySelectionHandlers() {
        this.dateSelectionHandlers.clear();
        return this;
    }


    public DatePicker addDateDayClickHandler(DateDayClickedHandler dateDayClickedHandler) {
        this.dateDayClickedHandlers.add(dateDayClickedHandler);
        return this;
    }

    public DatePicker removeDateDayClickedHandler(DateDayClickedHandler dateClickedHandler) {
        this.dateDayClickedHandlers.remove(dateClickedHandler);
        return this;
    }

    public List<DateDayClickedHandler> getDateDayClickedHandlers() {
        return this.dateDayClickedHandlers;
    }

    public DatePicker clearDateDayClickedHandlers() {
        this.dateDayClickedHandlers.clear();
        return this;
    }

    public DatePicker setDateTimeFormatInfo(DateTimeFormatInfo dateTimeFormatInfo) {
        this.datePickerMonth.setDateTimeFormatInfo(dateTimeFormatInfo);
        updatePicker();
        return this;
    }

    public DateTimeFormatInfo getDateTimeFormatInfo() {
        return datePickerMonth.getDateTimeFormatInfo();
    }

    public DatePicker showBorder() {
        element.style().setBorder("1px solid " + colorScheme.color().getHex());
        return this;
    }

    public DatePicker setColorScheme(ColorScheme colorScheme) {
        backgroundHandler.onBackgroundChanged(getColorScheme(), colorScheme);
        this.headerPanel.style().remove(this.colorScheme.color().getBackground());
        this.dayName.style().remove(this.colorScheme.darker_2().getBackground());
        this.colorScheme = colorScheme;
        this.headerPanel.style().add(this.colorScheme.color().getBackground());
        this.dayName.style().add(this.colorScheme.darker_2().getBackground());
        this.datePickerMonth.setBackground(colorScheme.color());
        this.todayButton.setColor(colorScheme.color());
        this.closeButton.setColor(colorScheme.color());
        this.clearButton.setColor(colorScheme.color());
        this.resetButton.setColor(colorScheme.color());
        return this;
    }

    public ColorScheme getColorScheme() {
        return colorScheme;
    }

    @Override
    public void onDaySelected(DatePickerElement datePickerElement) {
        this.selectedPickerElement = datePickerElement;
        this.jsDate.setTime(datePickerElement.getDate().getTime());
        updatePicker();
        publish();
    }

    @Override
    public void onDayClicked(DatePickerElement datePickerElement) {
        for (int i = 0; i < dateDayClickedHandlers.size(); i++) {
            dateDayClickedHandlers.get(i).onDateDayClicked(getDate(), getDateTimeFormatInfo());
        }
    }

    private void publish() {
        for (int i = 0; i < dateSelectionHandlers.size(); i++) {
            dateSelectionHandlers.get(i).onDateSelected(getDate(), getDateTimeFormatInfo());
        }
    }

    private void updatePicker() {
        int dayNameIndex = this.selectedPickerElement.getWeekDay() + getDateTimeFormatInfo().firstDayOfTheWeek();
        if (dayNameIndex > 6) {
            dayNameIndex = this.selectedPickerElement.getWeekDay() + getDateTimeFormatInfo().firstDayOfTheWeek() - 7;
        }
        this.dayName.setTextContent(getDateTimeFormatInfo().weekdaysFull()[dayNameIndex]);
        this.monthName.setTextContent(getDateTimeFormatInfo().monthsFull()[this.selectedPickerElement.getMonth()]);
        this.dateNumber.setTextContent(this.selectedPickerElement.getDay() + "");
        this.yearNumber.setTextContent(this.selectedPickerElement.getYear() + "");
        this.monthSelect.selectAt(this.selectedPickerElement.getMonth(), true);
        this.yearSelect.setValue(this.selectedPickerElement.getYear(), true);
    }

    public DatePicker showHeaderPanel() {
        headerPanel.show();
        return this;
    }

    public DatePicker hideHeaderPanel() {
        headerPanel.hide();
        return this;
    }

    public DatePicker showTodayButton() {
        this.todayButtonContainer.show();
        return this;
    }

    public DatePicker hideTodayButton() {
        this.todayButtonContainer.hide();
        return this;
    }

    public DatePicker showClearButton() {
        this.clearButtonContainer.show();
        return this;
    }

    public DatePicker hideClearButton() {
        this.clearButtonContainer.hide();
        return this;
    }

    public DatePicker showCloseButton() {
        this.closeButtonContainer.show();
        return this;
    }

    public DatePicker hideCloseButton() {
        this.closeButtonContainer.hide();
        return this;
    }

    public DatePicker showResetButton() {
        this.resetButtonContainer.show();
        return this;
    }

    public DatePicker hideResetButton() {
        this.resetButtonContainer.hide();
        return this;
    }

    public DatePicker addCloseHandler(PickerHandler closeHandler) {
        this.closeHandlers.add(closeHandler);
        return this;
    }

    public DatePicker removeCloseHandler(PickerHandler closeHandler) {
        this.closeHandlers.remove(closeHandler);
        return this;
    }

    public DatePicker addResetHandler(PickerHandler closeHandler) {
        this.resetHandlers.add(closeHandler);
        return this;
    }

    public DatePicker removeResetHandler(PickerHandler closeHandler) {
        this.resetHandlers.remove(closeHandler);
        return this;
    }

    public List<PickerHandler> getCloseHandlers() {
        return this.closeHandlers;
    }

    public List<PickerHandler> getResetHandlers() {
        return this.resetHandlers;
    }

    public DatePicker addClearHandler(PickerHandler clearHandler) {
        this.clearHandlers.add(clearHandler);
        return this;
    }

    public DatePicker removeClearHandler(PickerHandler clearHandler) {
        this.clearHandlers.remove(clearHandler);
        return this;
    }

    public List<PickerHandler> getClearHandlers() {
        return this.clearHandlers;
    }

    public DatePicker todayButtonText(String text) {
        this.todayButton.setContent(text);
        this.todayButton.element().title = text;
        return this;
    }

    public DatePicker clearButtonText(String text) {
        this.clearButton.setContent(text);
        this.clearButton.element().title = text;
        return this;
    }

    public DatePicker closeButtonText(String text) {
        this.closeButton.setContent(text);
        this.closeButton.element().title = text;
        return this;
    }

    public DatePicker resetButtonText(String text) {
        this.resetButton.setContent(text);
        this.resetButton.element().title = text;
        return this;
    }

    public DatePicker fixedWidth() {
        element.style().setWidth(px.of(300), true);
        return this;
    }

    public DatePicker fixedWidth(String width) {
        element.style().setWidth(width, true);
        return this;
    }

    public DominoElement<HTMLDivElement> getHeaderPanel() {
        return DominoElement.of(headerPanel);
    }

    public DominoElement<HTMLDivElement> getSelectorsPanel() {
        return DominoElement.of(selectorsPanel);
    }

    public DominoElement<HTMLDivElement> getFooterPanel() {
        return DominoElement.of(footerPanel);
    }

    public DominoElement<HTMLDivElement> getDayNamePanel() {
        return DominoElement.of(dayName);
    }

    public DominoElement<HTMLDivElement> getMonthNamePanel() {
        return DominoElement.of(monthName);
    }

    public DominoElement<HTMLDivElement> getDateNumberPanel() {
        return DominoElement.of(dateNumber);
    }

    public DominoElement<HTMLDivElement> getYearNumberPanel() {
        return DominoElement.of(yearNumber);
    }

    public Icon getNavigateBefore() {
        return navigateBefore;
    }

    public Icon getNavigateNext() {
        return navigateNext;
    }

    public Button getTodayButton() {
        return todayButton;
    }

    public Button getClearButton() {
        return clearButton;
    }

    public Button getCloseButton() {
        return closeButton;
    }

    public Button getResetButton() {
        return resetButton;
    }

    DatePicker setBackgroundHandler(BackgroundHandler backgroundHandler) {
        if (nonNull(backgroundHandler)) {
            this.backgroundHandler = backgroundHandler;
        }
        return this;
    }

    public ModalDialog createModal(String title) {
        return ModalDialog.createPickerModal(title, this.element());
    }

    @FunctionalInterface
    interface BackgroundHandler {
        void onBackgroundChanged(ColorScheme oldColorScheme, ColorScheme newColorScheme);
    }

    @FunctionalInterface
    public interface DateSelectionHandler {
        void onDateSelected(Date date, DateTimeFormatInfo dateTimeFormatInfo);
    }

    @FunctionalInterface
    public interface DateDayClickedHandler {
        void onDateDayClicked(Date date, DateTimeFormatInfo dateTimeFormatInfo);
    }

    public static class Formatter extends DateTimeFormat {

        protected Formatter(String pattern) {
            super(pattern);
        }

        protected Formatter(String pattern, DateTimeFormatInfo dtfi) {
            super(pattern, dtfi);
        }

        public static DateTimeFormat getFormat(String pattern, DateTimeFormatInfo dateTimeFormatInfo) {
            return DateTimeFormat.getFormat(pattern, dateTimeFormatInfo);
        }
    }
}
