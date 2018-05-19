package org.dominokit.domino.ui.timepicker;

import elemental2.core.JsDate;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Text;
import elemental2.svg.SVGCircleElement;
import elemental2.svg.SVGElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.CircleSize;
import org.dominokit.domino.ui.modals.ModalDialog;
import org.dominokit.domino.ui.pickers.PickerHandler;
import org.dominokit.domino.ui.style.ColorScheme;
import org.gwtproject.i18n.shared.DateTimeFormatInfo;
import org.gwtproject.i18n.shared.impl.cldr.DateTimeFormatInfo_factory;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.EventType;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static elemental2.dom.DomGlobal.document;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.timepicker.ClockStyle._12;
import static org.dominokit.domino.ui.timepicker.DayPeriod.AM;
import static org.dominokit.domino.ui.timepicker.DayPeriod.PM;
import static org.dominokit.domino.ui.utils.ElementUtil.builderFor;
import static org.dominokit.domino.ui.utils.ElementUtil.clear;
import static org.jboss.gwt.elemento.core.Elements.div;

public class TimePicker implements IsElement<HTMLDivElement> {


    private HTMLDivElement picker;
    private Clock clock;

    double centerX = 150;
    double centerY = 137;

    private final Map<Integer, ClockElement> hourElements = new HashMap<>();
    private final Map<Integer, ClockElement> minutesElements = new HashMap<>();

    private SVGElement hoursRootSvg;
    private SVGCircleElement hoursCircle;
    private SVGCircleElement hoursCenterCircle;
    private HTMLDivElement hoursPanel;

    private SVGElement minutesRootSvg;
    private SVGCircleElement minutesCircle;
    private SVGCircleElement minutesCenterCircle;
    private HTMLDivElement minutesPanel;

    private HTMLDivElement element = div().css("time-picker").asElement();
    private HTMLDivElement headerPanel = div().css("time-panel").asElement();
    private Text timeText = new Text();
    private Text timeTextSmall = new Text();
    private HTMLElement amPmSpan = Elements.span().css("am-pm-text").asElement();
    private HTMLDivElement timePanel = div().css("time-display-small").asElement();

    private HTMLDivElement clockPanel = div().css("time-display-large").asElement();
    private HTMLDivElement footerPanel = div().css("footer").asElement();

    private ColorScheme colorScheme = ColorScheme.BLUE;

    private HTMLDivElement hoveredElement;

    private ClockStyle clockStyle = _12;

    private DateTimeFormatInfo dateTimeFormatInfo;

    private boolean minutesVisible = false;
    private Button amButton;
    private Button pmButton;

    private Button nowButton;
    private Button clearButton;
    private Button closeButton;

    private List<PickerHandler> closeHandlers = new ArrayList<>();
    private List<PickerHandler> clearHandlers = new ArrayList<>();
    private List<TimeSelectionHandler> timeSelectionHandlers = new ArrayList<>();

    private ColorSchemeHandler colorSchemeHandler = (oldColorScheme, newColorScheme) -> {
    };
    private Button hoursButton;
    private Button minutesButton;

    public static TimePicker create() {
        return new TimePicker();
    }

    public static TimePicker create(DateTimeFormatInfo dateTimeFormatInfo) {
        return new TimePicker(dateTimeFormatInfo);
    }

    public TimePicker() {
        this(DateTimeFormatInfo_factory.create());
    }

    public TimePicker(DateTimeFormatInfo dateTimeFormatInfo) {

        this.dateTimeFormatInfo = dateTimeFormatInfo;
        this.clock = createTime(dateTimeFormatInfo);

        createCenterCircles(colorScheme);
        initRootSvg();
        initPickerElements();
        clearHoverStyle();
        reDraw();
        initAmPmElements(dateTimeFormatInfo);
        initHourMinuteElements();
        initFooter();
        preventTextSelection();
    }

    private void initFooter() {
        element.appendChild(footerPanel);

        clearButton = Button.createDefault("CLEAR").linkify().setColor(colorScheme.color());
        clearButton.asElement().classList.add("clear-button");

        clearButton.addClickListener(evt -> {
            for (int i = 0; i < clearHandlers.size(); i++) {
                clearHandlers.get(i).handle();
            }
        });

        nowButton = Button.createDefault("NOW").linkify().setColor(colorScheme.color());
        nowButton.asElement().classList.add("now-button");
        nowButton.addClickListener(evt -> {
            JsDate date = new JsDate();
            Time time = new Time(date.getHours(), date.getMinutes(), date.getHours() > 11 ? PM : AM);
            setTime(time);
        });

        closeButton = Button.createDefault("CLOSE").linkify().setColor(colorScheme.color());
        closeButton.asElement().classList.add("close-button");

        closeButton.addClickListener(evt -> {
            for (int i = 0; i < closeHandlers.size(); i++) {
                closeHandlers.get(i).handle();
            }
        });

        footerPanel.appendChild(clearButton.asElement());
        footerPanel.appendChild(nowButton.asElement());
        footerPanel.appendChild(closeButton.asElement());
    }

    private void initAmPmElements(DateTimeFormatInfo dateTimeFormatInfo) {
        amButton = Button.createDefault(dateTimeFormatInfo.ampms()[0])
                .setBackground(colorScheme.lighten_1())
                .circle(CircleSize.LARGE)
                .addClickListener(evt -> {
                    evt.stopPropagation();
                    clock.setDayPeriod(AM);
                    formatTime();
                    onTimeChanged();
                });

        amButton.asElement().classList.add("left-button");
        amButton.asElement().style.top="342px";

        pmButton = Button.createDefault(dateTimeFormatInfo.ampms()[1])
                .setBackground(colorScheme.lighten_1())
                .circle(CircleSize.LARGE)
                .addClickListener(evt -> {
                    evt.stopPropagation();
                    clock.setDayPeriod(PM);
                    formatTime();
                    onTimeChanged();
                });
        pmButton.asElement().classList.add("right-button");
        pmButton.asElement().style.top="342px";

        HTMLElement span = Elements.span().css("time-text").add(timeTextSmall).asElement();

        timePanel.appendChild(amButton.asElement());
        timePanel.appendChild(span);
        timePanel.appendChild(pmButton.asElement());
    }

    private void initHourMinuteElements() {
        hoursButton = Button.createDefault("H")
                .circle(CircleSize.SMALL)
                .setBackground(colorScheme.lighten_1())
                .addClickListener(evt -> {
                    evt.stopPropagation();
                    if(minutesVisible) {
                        showHours();
                    }
                });

        hoursButton.asElement().classList.add("left-sm-button");

        minutesButton = Button.createDefault("M")
                .circle(CircleSize.SMALL)
                .setBackground(colorScheme.lighten_1())
                .addClickListener(evt -> {
                    evt.stopPropagation();
                    clock.setDayPeriod(PM);
                    if(!minutesVisible){
                        showMinutes();
                    }
                });
        minutesButton.asElement().classList.add("right-sm-button");

        timePanel.appendChild(hoursButton.asElement());
        timePanel.appendChild(minutesButton.asElement());
    }

    private void clearHoverStyle() {
        builderFor(picker)
                .on(EventType.mouseout, event -> {
                    if (nonNull(hoveredElement))
                        hoveredElement.classList.remove(colorScheme.lighten_4().getBackground());
                });
    }

    private void initPickerElements() {
        element.appendChild(headerPanel);

        headerPanel.classList.add(colorScheme.color().getBackground());
        timePanel.classList.add(colorScheme.darker_2().getBackground());
        headerPanel.appendChild(timePanel);
        headerPanel.appendChild(clockPanel);

        clockPanel.appendChild(timeText);
        clockPanel.appendChild(amPmSpan);

        picker = div().style("position: relative; text-align: center;").asElement();

        hoursPanel = div().css("clock-picker").asElement();
        minutesPanel = div().css("clock-picker").asElement();

        minutesPanel.style.display = "none";

        picker.appendChild(hoursPanel);
        picker.appendChild(minutesPanel);

        element.appendChild(picker);

        picker.appendChild(hoursRootSvg);
        picker.appendChild(minutesRootSvg);
    }

    private void preventTextSelection() {
        builderFor(timePanel)
                .on(EventType.click, event -> swapHoursMinutes())
                .on(EventType.mousedown, event -> {
                    event.stopPropagation();
                    event.preventDefault();
                });
        builderFor(clockPanel)
                .on(EventType.click, event -> swapHoursMinutes())
                .on(EventType.mousedown, event -> {
                    event.stopPropagation();
                    event.preventDefault();
                });
    }

    private void initRootSvg() {
        hoursRootSvg = (SVGElement) document.createElementNS(SVGUtil.SVGNS, "svg");
        hoursRootSvg.setAttributeNS(null, "style", "display: block; margin: auto;");
        minutesRootSvg = (SVGElement) document.createElementNS(SVGUtil.SVGNS, "svg");
        minutesRootSvg.setAttributeNS(null, "style", "display:none; margin: auto;");
    }

    private void createCenterCircles(ColorScheme colorScheme) {
        hoursCenterCircle = SVGUtil.createCircle(centerX, centerY, 2, colorScheme.color().getHex());
        minutesCenterCircle = SVGUtil.createCircle(centerX, centerY, 2, colorScheme.color().getHex());
    }

    private Clock createTime(DateTimeFormatInfo dateTimeFormatInfo) {
        if (_12.equals(this.clockStyle)) {
            return new Clock12(dateTimeFormatInfo);
        } else {
            return new Clock24(dateTimeFormatInfo);
        }
    }

    private void reDraw() {
        drawHoursCircle();
        drawMinutesCircle();

        drawHours();
        drawMinutes();

        selectHour(this.clock.getHour());
        selectMinute(this.clock.getMinute());
    }

    private void swapHoursMinutes() {
        if (minutesVisible)
            showHours();
        else
            showMinutes();
    }

    public void setTime(Time time) {
        this.clock.setHour(time.getHour());
        this.clock.setMinute(time.getMinute());
        this.clock.setDayPeriod(time.getDayPeriod());
        selectHour(this.clock.getHour(), true);
        selectMinute(this.clock.getMinute(), true);
        this.formatTime();
        onTimeChanged();
    }

    public TimePicker setColorScheme(ColorScheme colorScheme) {
        createCenterCircles(colorScheme);

        headerPanel.classList.remove(this.colorScheme.color().getBackground());
        timePanel.classList.remove(this.colorScheme.darker_2().getBackground());
        headerPanel.classList.add(colorScheme.color().getBackground());
        timePanel.classList.add(colorScheme.darker_2().getBackground());

        amButton.setBackground(colorScheme.lighten_1());
        pmButton.setBackground(colorScheme.lighten_1());

        hoursButton.setBackground(colorScheme.lighten_1());
        minutesButton.setBackground(colorScheme.lighten_1());
        clearButton.setColor(colorScheme.color());
        nowButton.setColor(colorScheme.color());
        closeButton.setColor(colorScheme.color());

        this.colorSchemeHandler.onColorSchemeChanged(this.colorScheme, colorScheme);
        this.colorScheme = colorScheme;

        reDraw();
        return this;
    }

    private void drawHoursCircle() {
        hoursCircle = SVGUtil.createCircle(centerX, centerY, 135, colorScheme.lighten_5().getHex());
        drawClockCircle(hoursRootSvg, hoursCircle);
    }

    private void drawMinutesCircle() {
        minutesCircle = SVGUtil.createCircle(centerX, centerY, 135, colorScheme.lighten_5().getHex());
        drawClockCircle(minutesRootSvg, minutesCircle);
    }

    private void drawClockCircle(SVGElement root, SVGCircleElement circleElement) {
        clear(root);
        root.setAttribute("width", "300");
        root.setAttribute("height", "274");

        root.appendChild(circleElement);
        picker.appendChild(root);
    }

    private void drawHours() {
        clear(hoursPanel);
        for (int hour = clock.getStartHour(); hour <= clock.getEndHour(); hour++) {
            ClockElement clockElement = makeHourElement(hour);
            hourElements.put(hour, clockElement);
            hoursPanel.appendChild(clockElement.getElement());
        }
    }

    private void drawMinutes() {
        clear(minutesPanel);
        for (int minute = 0; minute < 60; minute++) {
            ClockElement clockElement = makeMinuteElement(minute);
            minutesElements.put(minute, clockElement);
            minutesPanel.appendChild(clockElement.getElement());
        }
    }

    private ClockElement makeHourElement(int hour) {
        ClockElement clockElement = ClockElement.createHour(hour, clockStyle, colorScheme);
        builderFor(clockElement.getElement())
                .on(EventType.mouseenter, event -> markeElement(clockElement))
                .on(EventType.mousedown, event -> {
                    event.stopPropagation();
                    event.preventDefault();
                    markeElement(clockElement);
                })
                .on(EventType.click, event -> {
                    event.stopPropagation();
                    selectHour(clockElement.getValue());
                    showMinutes();
                });

        return clockElement;
    }

    private ClockElement makeMinuteElement(int minute) {
        ClockElement clockElement = ClockElement.createMinute(minute, colorScheme);
        builderFor(clockElement.getElement())
                .on(EventType.mouseenter, event -> {
                    markeElement(clockElement);
                })
                .on(EventType.mousedown, event -> {
                    event.stopPropagation();
                    event.preventDefault();
                    markeElement(clockElement);
                })
                .on(EventType.click, event -> {
                    event.stopPropagation();
                    selectMinute(clockElement.getValue());
                });

        return clockElement;
    }

    private void markeElement(ClockElement clockElement) {
        if (nonNull(hoveredElement)) {
            hoveredElement.classList.remove(colorScheme.lighten_4().getBackground());
        }
        clockElement.getElement().classList.add(colorScheme.lighten_4().getBackground());
        hoveredElement = clockElement.getElement();
    }

    private void selectMinute(int minute) {
        selectMinute(minute, false);
    }

    private void selectMinute(int minute, boolean silent) {
        ClockElement clockElement = minutesElements.get(minute);
        clear(minutesRootSvg);
        minutesRootSvg.appendChild(minutesCircle);
        minutesRootSvg.appendChild(clockElement.getCircle());
        minutesRootSvg.appendChild(clockElement.getLine());
        minutesRootSvg.appendChild(clockElement.getInnerCircle());
        minutesRootSvg.appendChild(minutesCenterCircle);
        updateMinute(minute);
        formatTime();
        if (!silent)
            onTimeChanged();
    }

    private void updateMinute(int minute) {
        this.clock.setMinute(minute);
    }

    private void showMinutes() {
        this.minutesPanel.style.display = "block";
        this.minutesRootSvg.setAttributeNS(null, "style", "display: block; margin: auto;");

        this.hoursPanel.style.display = "none";
        this.hoursRootSvg.setAttributeNS(null, "style", "display: none; margin: auto;");

        this.minutesVisible = true;
    }

    private void showHours() {
        this.hoursPanel.style.display = "block";
        this.hoursRootSvg.setAttributeNS(null, "style", "display: block; margin: auto;");

        this.minutesPanel.style.display = "none";
        this.minutesRootSvg.setAttributeNS(null, "style", "display: none; margin: auto;");
        this.minutesVisible = false;
    }

    private void selectHour(int hour) {
        selectHour(hour, false);
    }

    private void selectHour(int hour, boolean silent) {
        ClockElement clockElement = hourElements.get(this.clock.getCorrectHour(hour));
        clear(hoursRootSvg);
        hoursRootSvg.appendChild(hoursCircle);
        hoursRootSvg.appendChild(clockElement.getCircle());
        hoursRootSvg.appendChild(clockElement.getLine());
        hoursRootSvg.appendChild(clockElement.getInnerCircle());
        hoursRootSvg.appendChild(hoursCenterCircle);
        updateHour(hour);
        formatTime();
        if (!silent)
            onTimeChanged();
    }

    private void onTimeChanged() {
        for (int i = 0; i < timeSelectionHandlers.size(); i++) {
            timeSelectionHandlers.get(i).onTimeSelected(clock.getTime(), dateTimeFormatInfo, this);
        }
    }

    public void setHour(int hour) {
        selectHour(hour);
    }

    public void setminute(int minute) {
        selectMinute(minute);
    }

    private void updateHour(int hour) {
        this.clock.setHour(hour);
    }

    public TimePicker setHeaderPanelVisibility(boolean visible) {
        if (visible) {
            clockPanel.style.display = "block";
            amButton.asElement().style.top="342px";
            pmButton.asElement().style.top="342px";
        } else {
            clockPanel.style.display = "none";
            amButton.asElement().style.top="274px";
            pmButton.asElement().style.top="274px";
        }
        return this;
    }

    public TimePicker hideHeaderPanel() {
        setHeaderPanelVisibility(false);
        return this;
    }

    public TimePicker showHeaderPanel() {
        setHeaderPanelVisibility(true);
        return this;
    }

    public TimePicker showNowButton() {
        this.nowButton.asElement().style.display = "block";
        return this;
    }

    public TimePicker hideNowButton() {
        this.nowButton.asElement().style.display = "none";
        return this;
    }

    public TimePicker showClearButton() {
        this.clearButton.asElement().style.display = "block";
        return this;
    }

    public TimePicker hideClearButton() {
        this.clearButton.asElement().style.display = "none";
        return this;
    }


    public TimePicker showCloseButton() {
        this.closeButton.asElement().style.display = "block";
        return this;
    }

    public TimePicker hideCloseButton() {
        this.closeButton.asElement().style.display = "none";
        return this;
    }

    public TimePicker addCloseHandler(PickerHandler closeHandler) {
        this.closeHandlers.add(closeHandler);
        return this;
    }

    public TimePicker removeCloseHandler(PickerHandler closeHandler) {
        this.closeHandlers.remove(closeHandler);
        return this;
    }

    public List<PickerHandler> getCloseHandlers() {
        return this.closeHandlers;
    }

    public TimePicker addClearHandler(PickerHandler clearHandler) {
        this.clearHandlers.add(clearHandler);
        return this;
    }

    public TimePicker removeClearHandler(PickerHandler clearHandler) {
        this.clearHandlers.remove(clearHandler);
        return this;
    }

    public List<PickerHandler> getClearHandlers() {
        return this.clearHandlers;
    }

    public TimePicker addTimeSelectionHandler(TimeSelectionHandler timeSelectionHandler) {
        this.timeSelectionHandlers.add(timeSelectionHandler);
        return this;
    }

    public TimePicker removeTimeSelectionHandler(TimeSelectionHandler timeSelectionHandler) {
        this.timeSelectionHandlers.remove(timeSelectionHandler);
        return this;
    }

    public List<TimeSelectionHandler> getTimeSelectionHandlers() {
        return this.timeSelectionHandlers;
    }

    public TimePicker clearTimeSelectionHandlers() {
        this.timeSelectionHandlers.clear();
        return this;
    }

    public TimePicker todayButtonText(String text) {
        this.nowButton.setContent(text);
        return this;
    }

    public TimePicker clearButtonText(String text) {
        this.clearButton.setContent(text);
        return this;
    }

    public TimePicker closeButtonText(String text) {
        this.closeButton.setContent(text);
        return this;
    }

    public TimePicker fixedWidth() {
        asElement().style.setProperty("width", "300px", "important");
        return this;
    }

    public TimePicker fixedWidth(String width) {
        asElement().style.setProperty("width", width, "important");
        return this;
    }

    public TimePicker setClockStyle(ClockStyle clockStyle) {
        this.clockStyle = clockStyle;
        if (_12.equals(clockStyle)) {
            this.clock = new Clock12(dateTimeFormatInfo);
            amButton.asElement().style.display = "block";
            pmButton.asElement().style.display = "block";
            hoursButton.asElement().classList.remove("left-sm-button-24");
            minutesButton.asElement().classList.remove("right-sm-button-24");
        } else {
            this.clock = new Clock24(dateTimeFormatInfo);
            amButton.asElement().style.display = "none";
            pmButton.asElement().style.display = "none";
            hoursButton.asElement().classList.add("left-sm-button-24");
            minutesButton.asElement().classList.add("right-sm-button-24");
        }
        reDraw();
        formatTime();

        return this;
    }

    public DateTimeFormatInfo getDateTimeFormatInfo() {
        return dateTimeFormatInfo;
    }

    public void setDateTimeFormatInfo(DateTimeFormatInfo dateTimeFormatInfo) {
        this.dateTimeFormatInfo = dateTimeFormatInfo;
        this.clock.setDateTimeFormatInfo(dateTimeFormatInfo);
        this.formatTime();
    }

    private void formatTime() {
        timeTextSmall.textContent = clock.format();
        timeText.textContent = clock.formatNoPeriod();
        amPmSpan.textContent = clock.formatPeriod();
    }

    public ColorScheme getColorScheme() {
        return colorScheme;
    }

    public Time getTime() {
        return this.clock.getTime();
    }


    public String getFormattedTime() {
        return this.clock.format();
    }

    public ModalDialog createModal(String title){
        return ModalDialog.createPickerModal(title, this.getColorScheme(), this.asElement());
    }

    @Override
    public HTMLDivElement asElement() {
        return element;
    }

    TimePicker setColorSchemeHandler(ColorSchemeHandler colorSchemeHandler) {
        if (nonNull(colorSchemeHandler))
            this.colorSchemeHandler = colorSchemeHandler;

        return this;
    }

    @FunctionalInterface
    interface ColorSchemeHandler {
        void onColorSchemeChanged(ColorScheme oldColorScheme, ColorScheme newColorScheme);
    }

    @FunctionalInterface
    public interface TimeSelectionHandler {
        void onTimeSelected(Time time, DateTimeFormatInfo dateTimeFormatInfo, TimePicker picker);
    }
}
