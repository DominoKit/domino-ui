package org.dominokit.domino.ui.timepicker;

import elemental2.core.JsDate;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.MouseEvent;
import elemental2.svg.SVGCircleElement;
import elemental2.svg.SVGElement;
import jsinterop.base.Js;
import org.dominokit.domino.ui.animations.Animation;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.button.LinkButton;
import org.dominokit.domino.ui.elements.AnchorElement;
import org.dominokit.domino.ui.elements.CircleElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.elements.SvgElement;
import org.dominokit.domino.ui.i18n.HasLabels;
import org.dominokit.domino.ui.i18n.PickersLabels;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.pickers.PickerHandler;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo;
import org.gwtproject.i18n.shared.cldr.impl.DateTimeFormatInfo_factory;
import org.dominokit.domino.ui.events.EventType;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.dominokit.domino.ui.timepicker.ClockStyle._12;
import static org.dominokit.domino.ui.timepicker.DayPeriod.AM;
import static org.dominokit.domino.ui.timepicker.DayPeriod.PM;
import static org.dominokit.domino.ui.utils.ElementUtil.clear;

/**
 * A component that allows the user to pick time from a clock like element
 */
public class TimePicker extends BaseDominoElement<HTMLDivElement, TimePicker> implements TimePickerStyles, HasLabels<PickersLabels> {

    private DivElement pickerContentContainer;
    private Clock clock;

    double centerX = 135;
    double centerY = 127;

    private final Map<Integer, ClockElement> hourElements = new HashMap<>();
    private final Map<Integer, ClockElement> minutesElements = new HashMap<>();
    private final Map<Integer, ClockElement> secondsElements = new HashMap<>();
    private SvgElement hoursRootSvg;
    private CircleElement hoursCircle;
    private CircleElement hoursCenterCircle;
    private DivElement hoursPanel;
    private SvgElement minutesRootSvg;
    private CircleElement minutesCircle;
    private CircleElement minutesCenterCircle;
    private DivElement minutesPanel;

    private SvgElement secondsRootSvg;
    private CircleElement secondsCircle;
    private CircleElement secondsCenterCircle;
    private DivElement secondsPanel;

    private final DivElement element;

    private DivElement headerPanel;
    private DivElement minuteSecondDelimiter;
    private DivElement hoursText;
    private DivElement minutesText;
    private DivElement secondsText;
    private DivElement amPmContainer;
    private SpanElement amPmSpanTop;
    private SpanElement amPmSpanBottom;
    private AnchorElement backToHours;
    private AnchorElement backToMinutes;

    private DivElement clockPanel;
    private DivElement footerPanel;

    private ColorScheme colorScheme = ColorScheme.BLUE;

    private ClockStyle clockStyle = _12;

    private DateTimeFormatInfo dateTimeFormatInfo;

    private boolean minutesVisible = false;
    private boolean secondsVisible = false;
    private boolean autoSwitchMinutes = true;
    private boolean autoSwitchSeconds = true;
    private boolean showSwitchers = false;
    private boolean showSeconds = false;

    private LinkButton nowButton;
    private LinkButton clearButton;
    private LinkButton closeButton;

    private List<PickerHandler> closeHandlers = new ArrayList<>();
    private List<PickerHandler> clearHandlers = new ArrayList<>();
    private List<PickerHandler> showMinutesHandlers = new ArrayList<>();
    private List<PickerHandler> showHoursHandlers = new ArrayList<>();
    private List<PickerHandler> showSecondsHandlers = new ArrayList<>();
    private List<TimeSelectionHandler> timeSelectionHandlers = new ArrayList<>();

    private boolean borderVisible = false;

    /**
     * @return new instance
     */
    public static TimePicker create() {
        return new TimePicker();
    }

    /**
     * @param dateTimeFormatInfo {@link DateTimeFormatInfo} to format the time
     * @return new instance
     */
    public static TimePicker create(DateTimeFormatInfo dateTimeFormatInfo) {
        return new TimePicker(dateTimeFormatInfo);
    }

    public TimePicker() {
        this(DateTimeFormatInfo_factory.create());
    }

    /**
     * @param dateTimeFormatInfo {@link DateTimeFormatInfo} to format the time
     */
    public TimePicker(DateTimeFormatInfo dateTimeFormatInfo) {

        this.dateTimeFormatInfo = dateTimeFormatInfo;
        this.clock = createTime(dateTimeFormatInfo);
        element = div()
                .addCss(dui_time_picker)
                .appendChild(headerPanel = div().addCss(dui_time_panel)
                        .appendChild(clockPanel = div().addCss(dui_time_display_large)
                                .appendChild(backToHours =
                                        a()
                                                .addCss(dui_navigate, dui_navigate_left)
                                                .addClickListener(
                                                        event -> {
                                                            if (minutesVisible) {
                                                                showHours();
                                                            } else if (secondsVisible) {
                                                                showMinutes();
                                                            }
                                                        })
                                                .appendChild(Icons.chevron_left())
                                                .hide()
                                )
                                .appendChild(hoursText = div()
                                        .addCss(dui_hour_text)
                                        .addClickListener(
                                                evt -> {
                                                    if (minutesVisible || secondsVisible) showHours();
                                                })
                                )
                                .appendChild(text(":"))
                                .appendChild(minutesText = div()
                                        .addCss(dui_minute_text)
                                        .addClickListener(
                                                evt -> {
                                                    if (!minutesVisible) showMinutes();
                                                })
                                )
                                .appendChild(minuteSecondDelimiter = div().textContent(":").hide())
                                .appendChild(secondsText = div()
                                        .addCss(dui_second_text)
                                        .hide()
                                        .addClickListener(
                                                evt -> {
                                                    if (!secondsVisible) showSeconds();
                                                })
                                )
                                .appendChild(amPmContainer = div()
                                        .addCss(dui_am_pm_container)
                                        .addClickListener(evt -> switchPeriod())
                                )
                                .appendChild(backToMinutes =
                                        a()
                                                .addCss(dui_navigate, dui_navigate_right)
                                                .addClickListener(
                                                        event -> {
                                                            if (!minutesVisible && !secondsVisible) {
                                                                showMinutes();
                                                            } else if (!secondsVisible && showSeconds) {
                                                                showSeconds();
                                                            }
                                                        })
                                                .appendChild(Icons.chevron_right())
                                                .hide()
                                )
                                .appendChild(amPmSpanTop = span().addCss(dui_am_pm_text, dui_am_pm_top))
                                .appendChild(amPmSpanBottom = span().addCss(dui_am_pm_text, dui_am_pm_bottom))
                        )
                )
                .appendChild(pickerContentContainer = div()
                        .addCss(dui_picker_content)
                        .appendChild(hoursPanel = div().addCss(dui_clock_picker))
                        .appendChild(minutesPanel = div().addCss(dui_clock_picker).hide())
                        .appendChild(secondsPanel = div().addCss(dui_clock_picker).hide())
                        .appendChild(hoursRootSvg = svg()
                                .addCss(dui_time_picker_svg_root, dui_hidden, dui_m_auto)
                                .appendChild(hoursCircle = circle(centerX, centerY, 115))
                        )
                        .appendChild(minutesRootSvg = svg()
                                .addCss(dui_time_picker_svg_root, dui_hidden, dui_m_auto)
                                .appendChild(minutesCircle = circle(centerX, centerY, 115))
                        )
                        .appendChild(secondsRootSvg = svg()
                                .addCss(dui_time_picker_svg_root, dui_hidden, dui_m_auto)
                                .appendChild(secondsCircle = circle(centerX, centerY, 115))
                        )
                );

        init(this);

        hoursCenterCircle = circle(centerX, centerY, 2).addCss(dui_time_picker_center_circle);
        minutesCenterCircle = circle(centerX, centerY, 2).addCss(dui_time_picker_center_circle);
        secondsCenterCircle = circle(centerX, centerY, 2).addCss(dui_time_picker_center_circle);


        drawHours();
        drawMinutes();
        drawSeconds();

        selectHour(this.clock.getHour());
        selectMinute(this.clock.getMinute());
        selectSecond(this.clock.getSecond());

        element
                .appendChild(footerPanel = div()
                        .addCss(du_time_footer)
                        .appendChild(clearButton =
                                LinkButton.create(getLabels().clear())
                                        .addCss(dui_clear_button)
                                        .addClickListener(
                                                evt -> {
                                                    for (int i = 0; i < clearHandlers.size(); i++) {
                                                        clearHandlers.get(i).handle();
                                                    }
                                                })
                        )
                        .appendChild(nowButton =
                                LinkButton.create(getLabels().now())
                                        .addCss(dui_now_button)
                                        .addClickListener(evt -> setTime(new Date()))
                        )
                        .appendChild(closeButton =
                                LinkButton.create(getLabels().close())
                                        .addCss(dui_close_button)
                                        .addClickListener(
                                                evt -> {
                                                    for (int i = 0; i < closeHandlers.size(); i++) {
                                                        closeHandlers.get(i).handle();
                                                    }
                                                })
                        )
                );


        addCss(dui_disable_text_select);
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

        Animation.create(amPmContainer).transition(Transition.FLIP_IN_X).duration(600).animate();

        onTimeChanged();
    }

    /**
     * Show a border for the clock picker element
     *
     * @return same instance
     */
    public TimePicker showBorder() {
        this.borderVisible = true;
//        element.style().setBorder("1px solid " + colorScheme.color().getHex());
        return this;
    }

    /**
     * @param showSeconds boolean, true to show second picker and show seconds in the time
     * @return same instance
     */
    public TimePicker setShowSeconds(boolean showSeconds) {
        if (showSeconds) {
            secondsText.show();
            minuteSecondDelimiter.show();
        } else {
            secondsText.hide();
            minuteSecondDelimiter.hide();
        }

        this.showSeconds = showSeconds;
        this.clock.setShowSeconds(showSeconds);

        return this;
    }

    /**
     * @return boolean, true if this picker shows seconds
     */
    public boolean isShowSeconds() {
        return showSeconds;
    }

//    private void preventTextSelection() {
//        ElementUtil.contentBuilder(headerPanel)
//                .on(
//                        EventType.mousedown,
//                        event -> {
//                            event.stopPropagation();
//                            event.preventDefault();
//                        });
//        ElementUtil.contentBuilder(clockPanel)
//                .on(
//                        EventType.mousedown,
//                        event -> {
//                            event.stopPropagation();
//                            event.preventDefault();
//                        });
//    }


    private Clock createTime(DateTimeFormatInfo dateTimeFormatInfo) {
        if (_12.equals(this.clockStyle)) {
            return new Clock12(dateTimeFormatInfo);
        } else {
            return new Clock24(dateTimeFormatInfo);
        }
    }

    private void reDraw() {
        drawHours();
        drawMinutes();
        drawSeconds();

        selectHour(this.clock.getHour());
        selectMinute(this.clock.getMinute());
        selectSecond(this.clock.getSecond());
    }

    /**
     * @param time {@link Date} time value
     */
    public void setTime(Date time) {
        JsDate jsDate = new JsDate((double) time.getTime());
        this.clock.setHour(jsDate.getHours());
        this.clock.setMinute(jsDate.getMinutes());
        this.clock.setSecond(jsDate.getSeconds());
        this.clock.setDayPeriod(jsDate.getHours() >= 12 ? PM : AM);
        selectHour(this.clock.getHour(), true);
        selectMinute(this.clock.getMinute(), true);
        selectSecond(this.clock.getSecond(), true);
        this.formatTime();
        onTimeChanged();
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
            hoursPanel.appendChild(clockElement);
        }
    }

    private void drawMinutes() {
        clear(minutesPanel);
        for (int minute = 0; minute < 60; minute += 5) {
            ClockElement clockElement = makeMinuteElement(minute);
            minutesElements.put(minute, clockElement);
            minutesPanel.appendChild(clockElement);
        }
        for (int minute = 0; minute < 60; minute++) {
            if (minute % 5 != 0) {
                ClockElement clockElement = makeMinuteElement(minute);
                minutesElements.put(minute, clockElement);
                minutesPanel.appendChild(clockElement);
            }
        }
    }

    private void drawSeconds() {
        clear(secondsPanel);
        for (int second = 0; second < 60; second += 5) {
            ClockElement clockElement = makeSecondElement(second);
            secondsElements.put(second, clockElement);
            secondsPanel.appendChild(clockElement);
        }
        for (int second = 0; second < 60; second++) {
            if (second % 5 != 0) {
                ClockElement clockElement = makeSecondElement(second);
                secondsElements.put(second, clockElement);
                secondsPanel.appendChild(clockElement);
            }
        }
    }

    private ClockElement makeHourElement(int hour) {
        ClockElement clockElement = ClockElement.createHour(hour, clockStyle);
        clockElement
                .addEventListener(
                        EventType.mouseenter,
                        event -> {
                            drawHourPointer(hourElements.get(clock.getHour()));
                            drawHourPointer(clockElement);
                        })
                .addEventListener(
                        EventType.mousedown,
                        event -> {
                            event.stopPropagation();
                            event.preventDefault();
                            drawHourPointer(hourElements.get(clock.getHour()));
                            drawHourPointer(clockElement);
                        })
                .addEventListener(
                        EventType.mouseout,
                        event -> {
                            if (clock.getHour() != clockElement.getValue()) removeHourPointer(clockElement);
                        })
                .addClickListener(
                        event -> {
                            event.stopPropagation();
                            selectHour(clockElement.getValue());
                            if (autoSwitchMinutes) {
                                showMinutes();
                            }
                        });

        return clockElement;
    }

    private ClockElement makeMinuteElement(int minute) {
        ClockElement clockElement = ClockElement.createMinute(minute);
        clockElement
                .addEventListener(
                        EventType.mouseenter,
                        event -> {
                            drawMinutesPointer(minutesElements.get(clock.getMinute()));
                            drawMinutesPointer(clockElement);
                            MouseEvent mouseEvent = Js.cast(event);
                            if (mouseEvent.buttons == 1) {
                                setminute(clockElement.getValue());
                            }
                        })
                .addEventListener(
                        EventType.mouseout,
                        event -> {
                            if (clock.getMinute() != clockElement.getValue())
                                removeMinutesPointer(clockElement);
                        })
                .addEventListener(
                        EventType.mousedown,
                        event -> {
                            event.stopPropagation();
                            event.preventDefault();
                        })
                .addEventListener(
                        EventType.mouseup,
                        event -> {
                            event.stopPropagation();
                            event.preventDefault();
                            setminute(clockElement.getValue());
                        })
                .addEventListener(
                        EventType.touchstart,
                        event -> {
                            event.stopPropagation();
                            event.preventDefault();
                        })
                .addEventListener(
                        EventType.touchmove,
                        event -> setminute(clockElement.getValue()))
                .addClickListener(
                        event -> {
                            event.stopPropagation();
                            selectMinute(clockElement.getValue());
                            if (autoSwitchSeconds && showSeconds) {
                                showSeconds();
                            }
                        });

        return clockElement;
    }

    private ClockElement makeSecondElement(int second) {
        ClockElement clockElement = ClockElement.createSecond(second);
        clockElement
                .addEventListener(
                        EventType.mouseenter,
                        event -> {
                            drawSecondsPointer(secondsElements.get(clock.getSecond()));
                            drawSecondsPointer(clockElement);
                            MouseEvent mouseEvent = Js.cast(event);
                            if (mouseEvent.buttons == 1) {
                                setSecond(clockElement.getValue());
                            }
                        })
                .addEventListener(
                        EventType.mouseout,
                        event -> {
                            if (clock.getSecond() != clockElement.getValue())
                                removeSecondsPointer(clockElement);
                        })
                .addEventListener(
                        EventType.mousedown,
                        event -> {
                            event.stopPropagation();
                            event.preventDefault();
                        })
                .addEventListener(
                        EventType.mouseup,
                        event -> {
                            event.stopPropagation();
                            event.preventDefault();
                            setSecond(clockElement.getValue());
                        })
                .addEventListener(
                        EventType.touchstart,
                        event -> {
                            event.stopPropagation();
                            event.preventDefault();
                        })
                .addEventListener(
                        EventType.touchmove,
                        event -> {
                            setSecond(clockElement.getValue());
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
        if (!silent) onTimeChanged();

        Animation.create(minutesText).transition(Transition.FLIP_IN_X).duration(600).animate();
    }

    private void selectSecond(int second) {
        selectSecond(second, false);
    }

    private void selectSecond(int second, boolean silent) {
        ClockElement clockElement = secondsElements.get(second);
        clear(secondsRootSvg);
        secondsRootSvg.appendChild(secondsCircle);
        drawSecondsPointer(clockElement);
        updateSecond(second);
        formatTime();
        if (!silent) onTimeChanged();

        Animation.create(secondsText).transition(Transition.FLIP_IN_X).duration(600).animate();
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

    private void drawSecondsPointer(ClockElement clockElement) {
        secondsRootSvg.appendChild(secondsCenterCircle);
        secondsRootSvg.appendChild(clockElement.getCircle());
        secondsRootSvg.appendChild(clockElement.getLine());
        secondsRootSvg.appendChild(clockElement.getInnerCircle());
    }

    private void removeSecondsPointer(ClockElement clockElement) {
        clockElement.getCircle().remove();
        clockElement.getLine().remove();
        clockElement.getInnerCircle().remove();
    }

    private void drawHourPointer(ClockElement clockElement) {
        hoursRootSvg.appendChild(hoursCenterCircle);
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

    private void updateSecond(int second) {
        this.clock.setSecond(second);
    }

    private void showMinutes() {
        this.minutesPanel.show();
        this.minutesRootSvg.show();

        this.hoursPanel.hide();
        this.hoursRootSvg.hide();

        this.secondsPanel.hide();
        this.secondsRootSvg.hide();

        this.minutesVisible = true;
        this.secondsVisible = false;

        for (int i = 0; i < showMinutesHandlers.size(); i++) {
            showMinutesHandlers.get(i).handle();
        }

        minutesText.addCss(dui_active);
        dui_active.remove(hoursText, secondsText);
        animateClock();
    }

    private void showSeconds() {
        this.secondsPanel.show();
        this.secondsRootSvg.show();

        this.hoursPanel.hide();
        this.hoursRootSvg.hide();

        this.minutesPanel.hide();
        this.minutesRootSvg.hide();

        this.secondsVisible = true;
        this.minutesVisible = false;

        for (int i = 0; i < showSecondsHandlers.size(); i++) {
            showSecondsHandlers.get(i).handle();
        }

        secondsText.addCss(dui_active);
        dui_active.remove(hoursText, minutesText);
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
        this.hoursRootSvg.show();

        this.minutesPanel.hide();
        this.minutesRootSvg.hide();
        this.minutesVisible = false;

        this.secondsPanel.hide();
        this.secondsRootSvg.hide();
        this.secondsVisible = false;

        for (int i = 0; i < showHoursHandlers.size(); i++) {
            showHoursHandlers.get(i).handle();
        }

        hoursText.addCss(dui_active);
        dui_active.remove(minutesText, secondsText);
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
        if (!silent) onTimeChanged();

        Animation.create(hoursText).transition(Transition.FLIP_IN_X).duration(600).animate();
    }

    private void onTimeChanged() {
        for (int i = 0; i < timeSelectionHandlers.size(); i++) {
            timeSelectionHandlers.get(i).onTimeSelected(clock.getTime(), dateTimeFormatInfo, this);
        }
    }

    /**
     * @param hour int
     */
    public void setHour(int hour) {
        selectHour(hour);
    }

    /**
     * @deprecated use {@link #setMinute(int)}
     */
    @Deprecated
    public void setminute(int minute) {
        setMinute(minute);
    }

    /**
     * @param minute int
     */
    public void setMinute(int minute) {
        selectMinute(minute);
    }

    /**
     * @param second int
     */
    public void setSecond(int second) {
        selectSecond(second);
    }

    private void updateHour(int hour) {
        this.clock.setHour(hour);
    }

    /**
     * Shows a button to set the time to the current time
     *
     * @return same instance
     */
    public TimePicker showNowButton() {
        this.nowButton.show();
        return this;
    }

    /**
     * hides the button to set the time to the current time
     *
     * @return same instance
     */
    public TimePicker hideNowButton() {
        this.nowButton.hide();
        return this;
    }

    /**
     * Shows a button that clears the picker value
     *
     * @return same instance
     */
    public TimePicker showClearButton() {
        this.clearButton.show();
        return this;
    }

    /**
     * hides the button that clears the picker value
     *
     * @return same instance
     */
    public TimePicker hideClearButton() {
        this.clearButton.hide();
        return this;
    }

    /**
     * Shows a button that close the picker
     *
     * @return same instance
     */
    public TimePicker showCloseButton() {
        this.closeButton.show();
        return this;
    }

    /**
     * Shows the button that close the picker
     *
     * @return same instance
     */
    public TimePicker hideCloseButton() {
        this.closeButton.hide();
        return this;
    }

    /**
     * @param closeHandler {@link PickerHandler} to be called when the picker is closed
     * @return same instance
     */
    public TimePicker addCloseHandler(PickerHandler closeHandler) {
        this.closeHandlers.add(closeHandler);
        return this;
    }

    /**
     * @param closeHandler {@link PickerHandler} to be removed
     * @return same instance
     */
    public TimePicker removeCloseHandler(PickerHandler closeHandler) {
        this.closeHandlers.remove(closeHandler);
        return this;
    }

    /**
     * @return List of {@link PickerHandler}s that handles the close of the picker
     */
    public List<PickerHandler> getCloseHandlers() {
        return this.closeHandlers;
    }

    /**
     * @param showMinutesHandler {@link PickerHandler} to be called when the picker shows the
     *                           minutes
     *                           panel
     * @return same instance
     */
    public TimePicker addShowMinutesHandler(PickerHandler showMinutesHandler) {
        this.showMinutesHandlers.add(showMinutesHandler);
        return this;
    }

    /**
     * @param showMinutesHandler {@link PickerHandler} to be removed
     * @return same instance
     */
    public TimePicker removeShowMinutesHandler(PickerHandler showMinutesHandler) {
        this.showMinutesHandlers.remove(showMinutesHandler);
        return this;
    }

    /**
     * @return List of {@link PickerHandler}s that handles the picker shows the minutes panel
     */
    public List<PickerHandler> getShowMinutesHandlers() {
        return this.showMinutesHandlers;
    }

    /**
     * @param showHoursHandler {@link PickerHandler} to be called when the picker shows the hours
     *                         panel
     * @return same instance
     */
    public TimePicker addShowHoursHandler(PickerHandler showHoursHandler) {
        this.showHoursHandlers.add(showHoursHandler);
        return this;
    }

    /**
     * @param showHoursHandler {@link PickerHandler} to be removed
     * @return same instance
     */
    public TimePicker removeShowHoursHandler(PickerHandler showHoursHandler) {
        this.showHoursHandlers.remove(showHoursHandler);
        return this;
    }

    /**
     * @return List of {@link PickerHandler}s that handles the picker shows the hours panel
     */
    public List<PickerHandler> getShowHoursHandlers() {
        return this.showHoursHandlers;
    }

    public TimePicker addClearHandler(PickerHandler clearHandler) {
        this.clearHandlers.add(clearHandler);
        return this;
    }

    /**
     * @param clearHandler {@link PickerHandler} to be removed
     * @return same instance
     */
    public TimePicker removeClearHandler(PickerHandler clearHandler) {
        this.clearHandlers.remove(clearHandler);
        return this;
    }

    /**
     * @return List of {@link PickerHandler}s that should be called when the picker is cleared
     */
    public List<PickerHandler> getClearHandlers() {
        return this.clearHandlers;
    }

    /**
     * @param timeSelectionHandler {@link TimeSelectionHandler}
     * @return same instance
     */
    public TimePicker addTimeSelectionHandler(TimeSelectionHandler timeSelectionHandler) {
        this.timeSelectionHandlers.add(timeSelectionHandler);
        return this;
    }

    /**
     * @param timeSelectionHandler {@link TimeSelectionHandler}
     * @return same instance
     */
    public TimePicker removeTimeSelectionHandler(TimeSelectionHandler timeSelectionHandler) {
        this.timeSelectionHandlers.remove(timeSelectionHandler);
        return this;
    }

    /**
     * @return List of {@link TimeSelectionHandler}s
     */
    public List<TimeSelectionHandler> getTimeSelectionHandlers() {
        return this.timeSelectionHandlers;
    }

    /**
     * remove all {@link TimeSelectionHandler}s
     *
     * @return same instance
     */
    public TimePicker clearTimeSelectionHandlers() {
        this.timeSelectionHandlers.clear();
        return this;
    }

    /**
     * @param text String text of the today button
     * @return same instance
     */
    public TimePicker todayButtonText(String text) {
        this.nowButton.setText(text);
        this.nowButton.element().title = text;
        return this;
    }

    /**
     * @param text String text of the clear button
     * @return same instance
     */
    public TimePicker clearButtonText(String text) {
        this.clearButton.setText(text);
        this.clearButton.element().title = text;
        return this;
    }

    /**
     * @param text String text of the close button
     * @return same instance
     */
    public TimePicker closeButtonText(String text) {
        this.closeButton.setText(text);
        this.closeButton.element().title = text;
        return this;
    }


    /**
     * @return the {@link HTMLDivElement} that contains the hours selection elements
     */
    public DivElement getHoursPanel() {
        return hoursPanel;
    }

    /**
     * @return the {@link HTMLDivElement} that contains the minutes selection elements
     */
    public DivElement getMinutesPanel() {
        return minutesPanel;
    }

    /**
     * @return the {@link HTMLDivElement} main content container
     */
    public DivElement getPickerContentContainer() {
        return pickerContentContainer;
    }

    /**
     * @return the {@link HTMLDivElement} that contains the current selected time values
     */
    public DivElement getClockPanel() {
        return clockPanel;
    }

    /**
     * @return boolean, true if the elements to switch between hour/minutes selection are visible
     */
    public boolean isShowSwitchers() {
        return showSwitchers;
    }

    /**
     * @param showSwitchers boolean, true to show elements to switch between hour/minutes selection
     * @return same instance
     */
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

    /**
     * @param clockStyle {@link ClockStyle}
     * @return same instance
     */
    public TimePicker setClockStyle(ClockStyle clockStyle) {
        this.clockStyle = clockStyle;
        if (_12.equals(clockStyle)) {
            this.clock = new Clock12(dateTimeFormatInfo);
            amPmContainer.show();
        } else {
            this.clock = new Clock24(dateTimeFormatInfo);
            amPmContainer.hide();
        }

        drawHours();
        drawMinutes();
        drawSeconds();

        selectHour(this.clock.getHour());
        selectMinute(this.clock.getMinute());
        selectSecond(this.clock.getSecond());
        formatTime();

        return this;
    }

    /**
     * @return the {@link DateTimeFormatInfo} used to format the time
     */
    public DateTimeFormatInfo getDateTimeFormatInfo() {
        return dateTimeFormatInfo;
    }

    /**
     * @param dateTimeFormatInfo {@link DateTimeFormatInfo} to format the time
     */
    public void setDateTimeFormatInfo(DateTimeFormatInfo dateTimeFormatInfo) {
        this.dateTimeFormatInfo = dateTimeFormatInfo;
        this.clock.setDateTimeFormatInfo(dateTimeFormatInfo);
        this.formatTime();
    }

    private void formatTime() {
        hoursText.setTextContent(clock.getHour() < 10 ? ("0" + clock.getHour()) : clock.getHour() +
                "");
        minutesText.setTextContent(
                clock.getMinute() < 10 ? ("0" + clock.getMinute()) : clock.getMinute() + "");
        secondsText.setTextContent(
                clock.getSecond() < 10 ? ("0" + clock.getSecond()) : clock.getSecond() + "");
        amPmSpanTop.setTextContent(AM.equals(clock.getDayPeriod()) ? pmPeriod() : amPeriod());
        amPmSpanBottom.setTextContent(clock.formatPeriod());
    }

    private String amPeriod() {
        return dateTimeFormatInfo.ampms()[0];
    }

    private String pmPeriod() {
        return dateTimeFormatInfo.ampms()[1];
    }

    /**
     * @return the picker {@link ColorScheme}
     */
    public ColorScheme getColorScheme() {
        return colorScheme;
    }

    /**
     * @return the {@link Date} value
     */
    public Date getTime() {
        return this.clock.getTime();
    }

    /**
     * @return String formatted time with the DateTimeFormatInfo
     */
    public String getFormattedTime() {
        return this.clock.format();
    }

    /**
     * @return boolean, true if selecting an hour will automatically switch to minutes selection
     */
    public boolean isAutoSwitchMinutes() {
        return autoSwitchMinutes;
    }

    /**
     * @param autoSwitchMinutes boolean, true to make selecting an hour automatically switch to
     *                          minutes selection
     */
    public void setAutoSwitchMinutes(boolean autoSwitchMinutes) {
        this.autoSwitchMinutes = autoSwitchMinutes;
    }

    /**
     * @return boolean, true if selecting a minute will automatically switch to seconds selection
     */
    public boolean isAutoSwitchSeconds() {
        return autoSwitchSeconds;
    }

    /**
     * @param autoSwitchSeconds boolean, true to make selecting a minute automatically switch to
     *                          seconds selection
     */
    public void setAutoSwitchSeconds(boolean autoSwitchSeconds) {
        this.autoSwitchSeconds = autoSwitchSeconds;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLDivElement element() {
        return element.element();
    }


    /**
     * A function to implement handlers for time selection changes
     */
    @FunctionalInterface
    public interface TimeSelectionHandler {
        /**
         * @param time               {@link Date} new picker value
         * @param dateTimeFormatInfo {@link DateTimeFormatInfo} from the picker
         * @param picker             {@link TimePicker} instance
         */
        void onTimeSelected(Date time, DateTimeFormatInfo dateTimeFormatInfo, TimePicker picker);
    }
}
