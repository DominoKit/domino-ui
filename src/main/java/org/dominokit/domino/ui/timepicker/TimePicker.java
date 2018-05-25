package org.dominokit.domino.ui.timepicker;

import elemental2.core.JsDate;
import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Text;
import elemental2.svg.SVGCircleElement;
import elemental2.svg.SVGElement;
import org.dominokit.domino.ui.animations.Animation;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.CircleSize;
import org.dominokit.domino.ui.icons.Icons;
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
import static org.jboss.gwt.elemento.core.Elements.a;
import static org.jboss.gwt.elemento.core.Elements.div;

public class TimePicker implements IsElement<HTMLDivElement> {


    private HTMLDivElement pickerContentContainer;
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
    private Text splitText = new Text(":");
    private HTMLDivElement hoursText = div().css("hour-text").asElement();
    private HTMLDivElement minutesText = div().css("minute-text").asElement();
    private HTMLDivElement amPmContainer = div().css("am-pm-container").asElement();
    private HTMLElement amPmSpanTop = Elements.span().css("am-pm-text").css("am-pm-top").asElement();
    private HTMLElement amPmSpanBottom = Elements.span().css("am-pm-text").css("am-pm-bottom").asElement();

    private HTMLAnchorElement backToHours;
    private HTMLAnchorElement backToMinutes;

    private HTMLDivElement clockPanel = div().css("time-display-large").asElement();
    private HTMLDivElement footerPanel = div().css("footer").asElement();

    private ColorScheme colorScheme = ColorScheme.BLUE;

    private HTMLDivElement hoveredElement;

    private ClockStyle clockStyle = _12;

    private DateTimeFormatInfo dateTimeFormatInfo;

    private boolean minutesVisible = false;
    private boolean autoSwitchMinutes = true;
    private boolean showSwitchers = false;

    private Button nowButton;
    private Button clearButton;
    private Button closeButton;

    private List<PickerHandler> closeHandlers = new ArrayList<>();
    private List<PickerHandler> clearHandlers = new ArrayList<>();
    private List<PickerHandler> showMinutesHandlers = new ArrayList<>();
    private List<PickerHandler> showHoursHandlers = new ArrayList<>();
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


    private void switchPeriod() {
        if (AM.equals(clock.getDayPeriod())) {
            clock.setDayPeriod(PM);
            amPmSpanTop.textContent = amPeriod();
            amPmSpanBottom.textContent = pmPeriod();
        } else {
            clock.setDayPeriod(AM);
            amPmSpanTop.textContent = pmPeriod();
            amPmSpanBottom.textContent = amPeriod();
        }

        Animation.create(amPmContainer)
                .transition(Transition.FLIP_IN_X)
                .duration(600)
                .animate();
    }

    private void initHourMinuteElements() {
        hoursButton = Button.createDefault("H")
                .linkify()
                .circle(CircleSize.SMALL)
                .setBackground(colorScheme.lighten_1())
                .addClickListener(evt -> {
                    evt.stopPropagation();
                    if (minutesVisible) {
                        showHours();
                    }
                });

        hoursButton.asElement().classList.add("left-sm-button");

        minutesButton = Button.createDefault("M")
                .linkify()
                .circle(CircleSize.SMALL)
                .setBackground(colorScheme.lighten_1())
                .addClickListener(evt -> {
                    evt.stopPropagation();
                    clock.setDayPeriod(PM);
                    if (!minutesVisible) {
                        showMinutes();
                    }
                });
        minutesButton.asElement().classList.add("right-sm-button");

    }

    private void clearHoverStyle() {
        builderFor(pickerContentContainer)
                .on(EventType.mouseout, event -> {
                    if (nonNull(hoveredElement))
                        hoveredElement.classList.remove(colorScheme.lighten_4().getBackground());
                });
    }

    private void initPickerElements() {

        backToHours = a().css("navigate").css("navigate-left")
                .style("display: none;")
                .on(EventType.click, event -> {
                    if (minutesVisible) {
                        showHours();
                    }
                })
                .add(Icons.ALL.navigate_before().asElement()).asElement();
        backToMinutes = a().css("navigate").css("navigate-right")
                .style("display: none;")
                .on(EventType.click, event -> {
                    if (!minutesVisible) {
                        showMinutes();
                    }
                })
                .add(Icons.ALL.navigate_next().asElement()).asElement();

        element.appendChild(headerPanel);

        headerPanel.classList.add(colorScheme.color().getBackground());
        headerPanel.appendChild(clockPanel);

        clockPanel.appendChild(backToHours);
        clockPanel.appendChild(hoursText);
        clockPanel.appendChild(splitText);
        clockPanel.appendChild(minutesText);
        clockPanel.appendChild(amPmContainer);
        clockPanel.appendChild(backToMinutes);
        amPmContainer.appendChild(amPmSpanTop);
        amPmContainer.appendChild(amPmSpanBottom);

        minutesText.classList.add(colorScheme.lighten_4().getStyle());

        hoursText.addEventListener(EventType.click.getName(), evt -> {
            if (minutesVisible)
                showHours();
        });

        minutesText.addEventListener(EventType.click.getName(), evt -> {
            if (!minutesVisible)
                showMinutes();
        });

        amPmContainer.addEventListener(EventType.click.getName(), evt -> switchPeriod());


        pickerContentContainer = div().css("picker-content").style("position: relative; text-align: center;").asElement();

        hoursPanel = div().css("clock-picker").asElement();
        minutesPanel = div().css("clock-picker").asElement();

        minutesPanel.style.display = "none";

        pickerContentContainer.appendChild(hoursPanel);
        pickerContentContainer.appendChild(minutesPanel);

        element.appendChild(pickerContentContainer);

        pickerContentContainer.appendChild(hoursRootSvg);
        pickerContentContainer.appendChild(minutesRootSvg);
    }

    private void preventTextSelection() {
        builderFor(headerPanel)
                .on(EventType.mousedown, event -> {
                    event.stopPropagation();
                    event.preventDefault();
                });
        builderFor(clockPanel)
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
        headerPanel.classList.add(colorScheme.color().getBackground());

        hoursButton.setBackground(colorScheme.lighten_1());
        minutesButton.setBackground(colorScheme.lighten_1());
        clearButton.setColor(colorScheme.color());
        nowButton.setColor(colorScheme.color());
        closeButton.setColor(colorScheme.color());
        minutesText.classList.remove(this.colorScheme.lighten_4().getStyle());
        hoursText.classList.remove(this.colorScheme.lighten_4().getStyle());

        if (minutesVisible) {
            hoursText.classList.add(colorScheme.lighten_4().getStyle());
        } else {
            minutesText.classList.add(colorScheme.lighten_4().getStyle());
        }

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
        pickerContentContainer.appendChild(root);
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
                .on(EventType.mouseenter, event -> markElement(clockElement))
                .on(EventType.mousedown, event -> {
                    event.stopPropagation();
                    event.preventDefault();
                    markElement(clockElement);
                })
                .on(EventType.click, event -> {
                    event.stopPropagation();
                    selectHour(clockElement.getValue());
                    if (autoSwitchMinutes) {
                        showMinutes();
                    }
                });

        return clockElement;
    }

    private ClockElement makeMinuteElement(int minute) {
        ClockElement clockElement = ClockElement.createMinute(minute, colorScheme);
        builderFor(clockElement.getElement())
                .on(EventType.mouseenter, event -> {
                    markElement(clockElement);
                })
                .on(EventType.mousedown, event -> {
                    event.stopPropagation();
                    event.preventDefault();
                    markElement(clockElement);
                })
                .on(EventType.mouseup, event -> {
                    event.stopPropagation();
                    event.preventDefault();
                    setminute(clockElement.getValue());
                })
                .on(EventType.touchstart, event -> {
                    event.preventDefault();
                })
                .on(EventType.touchmove, event -> {
                    setminute(clockElement.getValue());
                });

        return clockElement;
    }

    private void markElement(ClockElement clockElement) {
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

        Animation.create(minutesText)
                .transition(Transition.FLIP_IN_X)
                .duration(300)
                .animate();
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

        for (int i = 0; i < showHoursHandlers.size(); i++) {
            showMinutesHandlers.get(i).handle();
        }

        minutesText.classList.remove(colorScheme.lighten_4().getStyle());
        hoursText.classList.add(colorScheme.lighten_4().getStyle());
        animateClock();
    }

    private void animateClock() {
        Animation.create(getPickerContentContainer())
                .transition(Transition.ZOOM_IN)
                .duration(300)
                .animate();
    }

    private void showHours() {
        this.hoursPanel.style.display = "block";
        this.hoursRootSvg.setAttributeNS(null, "style", "display: block; margin: auto;");

        this.minutesPanel.style.display = "none";
        this.minutesRootSvg.setAttributeNS(null, "style", "display: none; margin: auto;");
        this.minutesVisible = false;

        for (int i = 0; i < showHoursHandlers.size(); i++) {
            showHoursHandlers.get(i).handle();
        }

        hoursText.classList.remove(colorScheme.lighten_4().getStyle());
        minutesText.classList.add(colorScheme.lighten_4().getStyle());
        animateClock();
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

        Animation.create(hoursText)
                .transition(Transition.FLIP_IN_X)
                .duration(300)
                .animate();
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

    public TimePicker addShowMinutesHandler(PickerHandler showMinutesHandler) {
        this.showMinutesHandlers.add(showMinutesHandler);
        return this;
    }

    public TimePicker removeShowMinutesHandler(PickerHandler showMinutesHandler) {
        this.showMinutesHandlers.remove(showMinutesHandler);
        return this;
    }

    public List<PickerHandler> getShowMinutesHandlers() {
        return this.showMinutesHandlers;
    }

    public TimePicker addShowHoursHandler(PickerHandler showHoursHandler) {
        this.showHoursHandlers.add(showHoursHandler);
        return this;
    }

    public TimePicker removeShowHoursHandler(PickerHandler showHoursHandler) {
        this.showHoursHandlers.remove(showHoursHandler);
        return this;
    }

    public List<PickerHandler> getShowHoursHandlers() {
        return this.showHoursHandlers;
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

    public HTMLDivElement getHoursPanel() {
        return hoursPanel;
    }

    public HTMLDivElement getMinutesPanel() {
        return minutesPanel;
    }

    public HTMLDivElement getPickerContentContainer() {
        return pickerContentContainer;
    }

    public HTMLDivElement getClockPanel() {
        return clockPanel;
    }

    public boolean isShowSwitchers() {
        return showSwitchers;
    }

    public TimePicker setShowSwitchers(boolean showSwitchers) {
        if (showSwitchers) {
            backToHours.style.display = "block";
            backToMinutes.style.display = "block";
        } else {
            backToHours.style.display = "none";
            backToMinutes.style.display = "none";
        }
        this.showSwitchers = showSwitchers;

        return this;
    }

    public TimePicker setClockStyle(ClockStyle clockStyle) {
        this.clockStyle = clockStyle;
        if (_12.equals(clockStyle)) {
            this.clock = new Clock12(dateTimeFormatInfo);
            hoursButton.asElement().classList.remove("left-sm-button-24");
            minutesButton.asElement().classList.remove("right-sm-button-24");
            amPmContainer.style.display = "block";
        } else {
            this.clock = new Clock24(dateTimeFormatInfo);
            hoursButton.asElement().classList.add("left-sm-button-24");
            minutesButton.asElement().classList.add("right-sm-button-24");
            amPmContainer.style.display = "none";
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
        hoursText.textContent = clock.getHour() < 10 ? ("0" + clock.getHour()) : clock.getHour() + "";
        minutesText.textContent = clock.getMinute() < 10 ? ("0" + clock.getMinute()) : clock.getMinute() + "";
        amPmSpanTop.textContent = AM.equals(clock.getDayPeriod()) ? pmPeriod() : amPeriod();
        amPmSpanBottom.textContent = clock.formatPeriod();
    }

    private String amPeriod() {
        return dateTimeFormatInfo.ampms()[0];
    }

    private String pmPeriod() {
        return dateTimeFormatInfo.ampms()[1];
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

    public boolean isAutoSwitchMinutes() {
        return autoSwitchMinutes;
    }

    public void setAutoSwitchMinutes(boolean autoSwitchMinutes) {
        this.autoSwitchMinutes = autoSwitchMinutes;
    }

    public ModalDialog createModal(String title) {
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
