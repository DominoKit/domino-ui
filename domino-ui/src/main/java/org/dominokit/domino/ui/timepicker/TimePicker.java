package org.dominokit.domino.ui.timepicker;

import elemental2.core.JsDate;
import elemental2.dom.*;
import elemental2.svg.SVGCircleElement;
import elemental2.svg.SVGElement;
import jsinterop.base.Js;
import org.dominokit.domino.ui.animations.Animation;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.modals.ModalDialog;
import org.dominokit.domino.ui.pickers.PickerHandler;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.style.Elevation;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.dominokit.domino.ui.utils.TextNode;
import org.gwtproject.i18n.shared.DateTimeFormatInfo;
import org.gwtproject.i18n.shared.impl.cldr.DateTimeFormatInfo_factory;
import org.jboss.gwt.elemento.core.EventType;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.*;

import static elemental2.dom.DomGlobal.document;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.timepicker.ClockStyle._12;
import static org.dominokit.domino.ui.timepicker.DayPeriod.AM;
import static org.dominokit.domino.ui.timepicker.DayPeriod.PM;
import static org.dominokit.domino.ui.utils.ElementUtil.clear;
import static org.jboss.gwt.elemento.core.Elements.*;

public class TimePicker implements IsElement<HTMLDivElement> {

    private DominoElement<HTMLDivElement> pickerContentContainer;
    private Clock clock;

    double centerX = 135;
    double centerY = 127;

    private final Map<Integer, ClockElement> hourElements = new HashMap<>();
    private final Map<Integer, ClockElement> minutesElements = new HashMap<>();

    private SVGElement hoursRootSvg;
    private SVGCircleElement hoursCircle;
    private SVGCircleElement hoursCenterCircle;
    private DominoElement<HTMLDivElement> hoursPanel;

    private SVGElement minutesRootSvg;
    private SVGCircleElement minutesCircle;
    private SVGCircleElement minutesCenterCircle;
    private DominoElement<HTMLDivElement> minutesPanel;

    private DominoElement<HTMLDivElement> element = DominoElement.of(div()
            .css(TimePickerStyles.TIME_PICKER))
            .elevate(Elevation.LEVEL_1);

    private DominoElement<HTMLDivElement> headerPanel = DominoElement.of(div().css(TimePickerStyles.TIME_PANEL));
    private Text splitText = TextNode.of(":");
    private DominoElement<HTMLDivElement> hoursText = DominoElement.of(div().css(TimePickerStyles.HOUR_TEXT));
    private DominoElement<HTMLDivElement> minutesText = DominoElement.of(div().css(TimePickerStyles.MINUTE_TEXT));
    private DominoElement<HTMLDivElement> amPmContainer = DominoElement.of(div().css(TimePickerStyles.AM_PM_CONTAINER));
    private DominoElement<HTMLElement> amPmSpanTop = DominoElement.of(span()
            .css(TimePickerStyles.AM_PM_TEXT)
            .css(TimePickerStyles.AM_PM_TOP));
    private DominoElement<HTMLElement> amPmSpanBottom = DominoElement.of(span()
            .css(TimePickerStyles.AM_PM_TEXT)
            .css(TimePickerStyles.AM_PM_BOTTOM));

    private DominoElement<HTMLAnchorElement> backToHours;
    private DominoElement<HTMLAnchorElement> backToMinutes;

    private DominoElement<HTMLDivElement> clockPanel = DominoElement.of(div().css(TimePickerStyles.TIME_DISPLAY_LARGE));
    private DominoElement<HTMLDivElement> footerPanel = DominoElement.of(div().css(TimePickerStyles.TIME_FOOTER));

    private ColorScheme colorScheme = ColorScheme.BLUE;

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
    private boolean borderVisible = false;

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
        reDraw();
        initFooter();
        preventTextSelection();
    }


    private void initFooter() {
        element.appendChild(footerPanel);

        clearButton = Button.createDefault("CLEAR")
                .linkify()
                .setColor(colorScheme.color())
                .styler(style -> style.add(TimePickerStyles.CLEAR_BUTTON))
                .addClickListener(evt -> {
                    for (int i = 0; i < clearHandlers.size(); i++) {
                        clearHandlers.get(i).handle();
                    }
                });

        nowButton = Button.createDefault("NOW")
                .linkify()
                .setColor(colorScheme.color())
                .styler(style -> style.add(TimePickerStyles.NOW_BUTTON))
                .addClickListener(evt -> setTime(new Date()));

        closeButton = Button.createDefault("CLOSE")
                .linkify()
                .setColor(colorScheme.color())
                .styler(style -> style.add(TimePickerStyles.CLOSE_BUTTON))
                .addClickListener(evt -> {
                    for (int i = 0; i < closeHandlers.size(); i++) {
                        closeHandlers.get(i).handle();
                    }
                });

        footerPanel.appendChild(clearButton);
        footerPanel.appendChild(nowButton);
        footerPanel.appendChild(closeButton);
    }


    private void switchPeriod() {
        if (AM.equals(clock.getDayPeriod())) {
            clock.setDayPeriod(PM);
            amPmSpanTop.setTextContent(amPeriod());
            amPmSpanBottom.setTextContent(pmPeriod());
        } else {
            clock.setDayPeriod(AM);
            amPmSpanTop.setTextContent(pmPeriod());
            amPmSpanBottom.setTextContent(amPeriod());
        }

        Animation.create(amPmContainer)
                .transition(Transition.FLIP_IN_X)
                .duration(600)
                .animate();

        onTimeChanged();
    }

    public TimePicker showBorder() {
        this.borderVisible = true;
        element.style().setBorder("1px solid " + colorScheme.color().getHex());
        return this;
    }

    private void initPickerElements() {

        backToHours = DominoElement.of(a()
                .css(TimePickerStyles.NAVIGATE)
                .css(TimePickerStyles.NAVIGATE_LEFT)
                .on(EventType.click, event -> {
                    if (minutesVisible) {
                        showHours();
                    }
                })
                .add(Icons.ALL.navigate_before()))
                .hide();

        backToMinutes = DominoElement.of(a().css(TimePickerStyles.NAVIGATE)
                .css(TimePickerStyles.NAVIGATE_RIGHT)
                .on(EventType.click, event -> {
                    if (!minutesVisible) {
                        showMinutes();
                    }
                })
                .add(Icons.ALL.navigate_next()))
                .hide();

        element.appendChild(headerPanel);

        headerPanel.style().add(colorScheme.color().getBackground());
        headerPanel.appendChild(clockPanel);

        clockPanel.appendChild(backToHours);
        clockPanel.appendChild(hoursText);
        clockPanel.appendChild(splitText);
        clockPanel.appendChild(minutesText);
        clockPanel.appendChild(amPmContainer);
        clockPanel.appendChild(backToMinutes);
        amPmContainer.appendChild(amPmSpanTop);
        amPmContainer.appendChild(amPmSpanBottom);

        minutesText
                .styler(style -> style.add(colorScheme.lighten_4().getStyle()))
                .addClickListener(evt -> {
                    if (!minutesVisible)
                        showMinutes();
                });

        hoursText.addClickListener(evt -> {
            if (minutesVisible)
                showHours();
        });


        amPmContainer.addClickListener(evt -> switchPeriod());


        pickerContentContainer = DominoElement.of(div()
                .css(TimePickerStyles.PICKER_CONTENT));

        hoursPanel = DominoElement.of(div().css(TimePickerStyles.CLOCK_PICKER));
        minutesPanel = DominoElement.of(div().css(TimePickerStyles.CLOCK_PICKER));

        minutesPanel.hide();

        pickerContentContainer.appendChild(hoursPanel);
        pickerContentContainer.appendChild(minutesPanel);

        element.appendChild(pickerContentContainer);

        pickerContentContainer.appendChild(hoursRootSvg);
        pickerContentContainer.appendChild(minutesRootSvg);
    }

    private void preventTextSelection() {
        ElementUtil.contentBuilder(headerPanel)
                .on(EventType.mousedown, event -> {
                    event.stopPropagation();
                    event.preventDefault();
                });
        ElementUtil.contentBuilder(clockPanel)
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


    public void setTime(Date time) {
        JsDate jsDate = new JsDate((double) time.getTime());
        this.clock.setHour(jsDate.getHours());
        this.clock.setMinute(jsDate.getMinutes());
        this.clock.setDayPeriod(jsDate.getHours() >= 12 ? PM : AM);
        selectHour(this.clock.getHour(), true);
        selectMinute(this.clock.getMinute(), true);
        this.formatTime();
        onTimeChanged();
    }

    public TimePicker setColorScheme(ColorScheme colorScheme) {
        createCenterCircles(colorScheme);

        headerPanel.style().remove(this.colorScheme.color().getBackground());
        headerPanel.style().add(colorScheme.color().getBackground());

        clearButton.setColor(colorScheme.color());
        nowButton.setColor(colorScheme.color());
        closeButton.setColor(colorScheme.color());
        minutesText.style().remove(this.colorScheme.lighten_4().getStyle());
        hoursText.style().remove(this.colorScheme.lighten_4().getStyle());

        if (minutesVisible) {
            hoursText.style().add(colorScheme.lighten_4().getStyle());
        } else {
            minutesText.style().add(colorScheme.lighten_4().getStyle());
        }

        this.colorSchemeHandler.onColorSchemeChanged(this.colorScheme, colorScheme);
        this.colorScheme = colorScheme;

        reDraw();
        if (borderVisible) {
            showBorder();
        }
        return this;
    }

    private void drawHoursCircle() {
        hoursCircle = SVGUtil.createCircle(centerX, centerY, 115, colorScheme.lighten_5().getHex());
        drawClockCircle(hoursRootSvg, hoursCircle);
    }

    private void drawMinutesCircle() {
        minutesCircle = SVGUtil.createCircle(centerX, centerY, 115, colorScheme.lighten_5().getHex());
        drawClockCircle(minutesRootSvg, minutesCircle);
    }

    private void drawClockCircle(SVGElement root, SVGCircleElement circleElement) {
        clear(root);
        root.setAttribute("width", "270");
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
        for (int minute = 0; minute < 60; minute += 5) {
            ClockElement clockElement = makeMinuteElement(minute);
            minutesElements.put(minute, clockElement);
            minutesPanel.appendChild(clockElement.getElement());
        }
        for (int minute = 0; minute < 60; minute++) {
            if(minute % 5 != 0) {
                ClockElement clockElement = makeMinuteElement(minute);
                minutesElements.put(minute, clockElement);
                minutesPanel.appendChild(clockElement.getElement());
            }
        }
    }

    private ClockElement makeHourElement(int hour) {
        ClockElement clockElement = ClockElement.createHour(hour, clockStyle, colorScheme);
        ElementUtil.contentBuilder(clockElement.getElement())
                .on(EventType.mouseenter, event -> {
                    drawHourPointer(hourElements.get(clock.getHour()));
                    drawHourPointer(clockElement);
                })
                .on(EventType.mousedown, event -> {
                    event.stopPropagation();
                    event.preventDefault();
                    drawHourPointer(hourElements.get(clock.getHour()));
                    drawHourPointer(clockElement);
                })
                .on(EventType.mouseout, event -> {
                    if (clock.getHour() != clockElement.getValue())
                        removeHourPointer(clockElement);
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
        ElementUtil.contentBuilder(clockElement.getElement())
                .on(EventType.mouseenter, event -> {
                    drawMinutesPointer(minutesElements.get(clock.getMinute()));
                    drawMinutesPointer(clockElement);
                    MouseEvent mouseEvent = Js.cast(event);
                    if (mouseEvent.buttons == 1) {
                        setminute(clockElement.getValue());
                    }
                })
                .on(EventType.mouseout, event -> {
                    if (clock.getMinute() != clockElement.getValue())
                        removeMinutesPointer(clockElement);
                })
                .on(EventType.mousedown, event -> {
                    event.stopPropagation();
                    event.preventDefault();
                })
                .on(EventType.mouseup, event -> {
                    event.stopPropagation();
                    event.preventDefault();
                    setminute(clockElement.getValue());
                })
                .on(EventType.touchstart, event -> {
                    event.stopPropagation();
                    event.preventDefault();
                })
                .on(EventType.touchmove, event -> {
                    setminute(clockElement.getValue());
                });

        return clockElement;
    }

    private void selectMinute(int minute) {
        selectMinute(minute, false);
    }

    private void selectMinute(int minute, boolean silent) {
        ClockElement clockElement = minutesElements.get(minute);
        clear(minutesRootSvg);
        minutesRootSvg.appendChild(minutesCircle);
        drawMinutesPointer(clockElement);
        updateMinute(minute);
        formatTime();
        if (!silent)
            onTimeChanged();

        Animation.create(minutesText)
                .transition(Transition.FLIP_IN_X)
                .duration(600)
                .animate();
    }

    private void drawMinutesPointer(ClockElement clockElement) {
        minutesRootSvg.appendChild(minutesCenterCircle);
        minutesRootSvg.appendChild(clockElement.getCircle());
        minutesRootSvg.appendChild(clockElement.getLine());
        minutesRootSvg.appendChild(clockElement.getInnerCircle());
    }

    private void removeMinutesPointer(ClockElement clockElement) {
        clockElement.getCircle().remove();
        clockElement.getLine().remove();
        clockElement.getInnerCircle().remove();
    }

    private void drawHourPointer(ClockElement clockElement) {
        hoursRootSvg.appendChild(minutesCenterCircle);
        hoursRootSvg.appendChild(clockElement.getCircle());
        hoursRootSvg.appendChild(clockElement.getLine());
        hoursRootSvg.appendChild(clockElement.getInnerCircle());
    }

    private void removeHourPointer(ClockElement clockElement) {
        clockElement.getCircle().remove();
        clockElement.getLine().remove();
        clockElement.getInnerCircle().remove();
    }

    private void updateMinute(int minute) {
        this.clock.setMinute(minute);
    }

    private void showMinutes() {
        this.minutesPanel.show();
        this.minutesRootSvg.setAttributeNS(null, "style", "display: block; margin: auto;");

        this.hoursPanel.hide();
        this.hoursRootSvg.setAttributeNS(null, "style", "display: none; margin: auto;");

        this.minutesVisible = true;

        for (int i = 0; i < showHoursHandlers.size(); i++) {
            showMinutesHandlers.get(i).handle();
        }

        minutesText.style().remove(colorScheme.lighten_4().getStyle());
        hoursText.style().add(colorScheme.lighten_4().getStyle());
        animateClock();
    }

    private void animateClock() {
        Animation.create(getPickerContentContainer())
                .transition(Transition.PULSE)
                .duration(600)
                .animate();
    }

    private void showHours() {
        this.hoursPanel.show();
        this.hoursRootSvg.setAttributeNS(null, "style", "display: block; margin: auto;");

        this.minutesPanel.hide();
        this.minutesRootSvg.setAttributeNS(null, "style", "display: none; margin: auto;");
        this.minutesVisible = false;

        for (int i = 0; i < showHoursHandlers.size(); i++) {
            showHoursHandlers.get(i).handle();
        }

        hoursText.style().remove(colorScheme.lighten_4().getStyle());
        minutesText.style().add(colorScheme.lighten_4().getStyle());
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
                .duration(600)
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
        this.nowButton.show();
        return this;
    }

    public TimePicker hideNowButton() {
        this.nowButton.hide();
        return this;
    }

    public TimePicker showClearButton() {
        this.clearButton.show();
        return this;
    }

    public TimePicker hideClearButton() {
        this.clearButton.hide();
        return this;
    }


    public TimePicker showCloseButton() {
        this.closeButton.show();
        return this;
    }

    public TimePicker hideCloseButton() {
        this.closeButton.hide();
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
        this.nowButton.element().title = text;
        return this;
    }

    public TimePicker clearButtonText(String text) {
        this.clearButton.setContent(text);
        this.clearButton.element().title = text;
        return this;
    }

    public TimePicker closeButtonText(String text) {
        this.closeButton.setContent(text);
        this.closeButton.element().title = text;
        return this;
    }

    public TimePicker fixedWidth() {
        element.style().setWidth(TimePickerStyles.PICKER_WIDTH, true);
        return this;
    }

    public TimePicker fixedWidth(String width) {
        element.style().setWidth(width, true);
        return this;
    }

    public DominoElement<HTMLDivElement> getHoursPanel() {
        return hoursPanel;
    }

    public DominoElement<HTMLDivElement> getMinutesPanel() {
        return minutesPanel;
    }

    public DominoElement<HTMLDivElement> getPickerContentContainer() {
        return pickerContentContainer;
    }

    public DominoElement<HTMLDivElement> getClockPanel() {
        return clockPanel;
    }

    public boolean isShowSwitchers() {
        return showSwitchers;
    }

    public TimePicker setShowSwitchers(boolean showSwitchers) {
        if (showSwitchers) {
            backToHours.show();
            backToMinutes.show();
        } else {
            backToHours.hide();
            backToMinutes.hide();
        }
        this.showSwitchers = showSwitchers;

        return this;
    }

    public TimePicker setClockStyle(ClockStyle clockStyle) {
        this.clockStyle = clockStyle;
        if (_12.equals(clockStyle)) {
            this.clock = new Clock12(dateTimeFormatInfo);
            amPmContainer.show();
        } else {
            this.clock = new Clock24(dateTimeFormatInfo);
            amPmContainer.hide();
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
        hoursText.setTextContent(clock.getHour() < 10 ? ("0" + clock.getHour()) : clock.getHour() + "");
        minutesText.setTextContent(clock.getMinute() < 10 ? ("0" + clock.getMinute()) : clock.getMinute() + "");
        amPmSpanTop.setTextContent(AM.equals(clock.getDayPeriod()) ? pmPeriod() : amPeriod());
        amPmSpanBottom.setTextContent(clock.formatPeriod());
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

    public Date getTime() {
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
        return ModalDialog.createPickerModal(title, this.element());
    }

    @Override
    public HTMLDivElement element() {
        return element.element();
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
        void onTimeSelected(Date time, DateTimeFormatInfo dateTimeFormatInfo, TimePicker picker);
    }

}
