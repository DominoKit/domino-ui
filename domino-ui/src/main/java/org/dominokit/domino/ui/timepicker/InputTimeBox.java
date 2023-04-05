/*
 * Copyright © 2019 Dominokit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dominokit.domino.ui.timepicker;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.timepicker.ClockStyle._12;

import elemental2.core.JsDate;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLInputElement;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.AutoValidator;
import org.dominokit.domino.ui.forms.TextInputFormField;
import org.dominokit.domino.ui.forms.validations.InputAutoValidator;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.Mask;
import org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo;
import org.gwtproject.i18n.shared.cldr.impl.DateTimeFormatInfo_factory;

/**
 * A form element that takes and provide date value as time using user input
 */
public class InputTimeBox extends TextInputFormField<InputTimeBox, HTMLInputElement, Date> {
    private static final String CLOCK_12_REGEX = "^((0[1-9]|1[0-2]):[0-5][0-9]) ?([AaPp][Mm])$";
    private static final String CLOCK_12_WITH_SECONDS_REGEX =
            "^((0[1-9]|1[0-2]):[0-5][0-9]):(?:[0-5]\\d) ?([AaPp][Mm])$";
    private static final String CLOCK_24_REGEX = "^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$";
    private static final String CLOCK_24_WITH_SECONDS_REGEX =
            "(?:[01]\\d|2[0-3]):(?:[0-5]\\d):(?:[0-5]\\d)";
    private static final String CLOCK_12_PATTERN = "__:__ __";
    private static final String CLOCK_12_WITH_SECONDS_PATTERN = "__:__:__ __";
    private static final String CLOCK_24_PATTERN = "__:__";
    private static final String CLOCK_24_WITH_SECONDS_PATTERN = "__:__:__";
    private static final Map<String, String> PATTERNS_MESSAGE = new HashMap<>();
    private static final String DEFAULT_NOT_MATCHED_MESSAGE = "Value not matched pattern";

    static {
        PATTERNS_MESSAGE.put(CLOCK_12_PATTERN, "HH:MM AM/PM");
        PATTERNS_MESSAGE.put(CLOCK_12_WITH_SECONDS_PATTERN, "HH:MM:SS AM/PM");
        PATTERNS_MESSAGE.put(CLOCK_24_PATTERN, "HH:MM");
        PATTERNS_MESSAGE.put(CLOCK_24_WITH_SECONDS_PATTERN, "HH:MM:SS");
    }

    private final Mask mask;
    private Clock clock;
    private Date value;
    private DateTimeFormatInfo dateTimeFormatInfo;
    private boolean showSeconds;
    private MdiIcon timeIcon;
    private DivElement timeIconContainer;
    private ClockStyle clockStyle;
    private String notMatchedErrorMessage = DEFAULT_NOT_MATCHED_MESSAGE;

    public InputTimeBox() {
        this(null);
    }

    /**
     * @param time {@link Date} initial time
     */
    public InputTimeBox(Date time) {
        this(null, time);
    }

    /**
     * @param label String field label
     * @param time  {@link Date} initial time
     */
    public InputTimeBox(String label, Date time) {
        this(label, time, null);
    }

    /**
     * @param label              String field label
     * @param time               {@link Date} initial time
     * @param dateTimeFormatInfo {@link DateTimeFormatInfo} to be used to format the time value in
     *                           the
     *                           text input
     */
    public InputTimeBox(String label, Date time, DateTimeFormatInfo dateTimeFormatInfo) {
        super();
        setLabel(label);
        if (isNull(dateTimeFormatInfo)) {
            this.dateTimeFormatInfo = DateTimeFormatInfo_factory.create();
        } else {
            this.dateTimeFormatInfo = dateTimeFormatInfo;
        }
        mask =
                Mask.of(this)
                        .pattern(CLOCK_12_PATTERN)
                        .regex(CLOCK_12_REGEX)
                        .dataSlots("_")
                        .onPatternMatched(
                                value -> {
                                    Date oldValue = getValue();
                                    clearInvalid();
                                    setStringValue(value);
                                    autoValidate();
                                    Date newValue = getValue();
                                    triggerChangeListeners(oldValue, newValue);
                                })
                        .build();

        mask.onPatternNotMatched(
                value ->
                        invalidate(notMatchedErrorMessage + " " + PATTERNS_MESSAGE.get(mask.getPattern())));
        setClockStyle(_12);
        addPrimaryAddOn(Icons.ALL.clock_mdi());
        setValue(time);
    }

    @Override
    public String getType() {
        return "text";
    }

    @Override
    protected DominoElement<HTMLInputElement> createInputElement(String type) {
        return input(type).addCss(dui_field_input).toDominoElement();
    }

    private void setStringValue(String value) {
        String[] split = value.split(":");
        int hours = Integer.parseInt(split[0]);
        clock.setHour(hours);

        String minutesString = split[1];
        if (minutesString.contains(" ")) {
            String[] minutesAndPeriod = minutesString.split(" ");
            clock.setMinute(Integer.parseInt(minutesAndPeriod[0]));
            clock.setDayPeriod(DayPeriod.valueOf(minutesAndPeriod[1].toUpperCase()));
        } else {
            clock.setMinute(Integer.parseInt(minutesString));
        }
        if (showSeconds) {
            String secondsString = split[2];
            if (secondsString.contains(" ")) {
                String[] secondsAndPeriod = secondsString.split(" ");
                clock.setSecond(Integer.parseInt(secondsAndPeriod[0]));
                clock.setDayPeriod(DayPeriod.valueOf(secondsAndPeriod[1].toUpperCase()));
            } else {
                clock.setSecond(Integer.parseInt(secondsString));
            }
        }

        this.value = clock.getTime();
    }

    public static InputTimeBox create() {
        return new InputTimeBox();
    }

    /**
     * @param time {@link Date} initial time
     * @return new instance
     */
    public static InputTimeBox create(Date time) {
        return new InputTimeBox(time);
    }

    /**
     * @param label String field label
     * @param time  {@link Date} initial time
     * @return new instance
     */
    public static InputTimeBox create(String label, Date time) {
        return new InputTimeBox(label, time);
    }

    /**
     * @param label              String field label
     * @param time               {@link Date} initial time
     * @param dateTimeFormatInfo {@link DateTimeFormatInfo} to be used to format the time value in
     *                           the
     *                           text input
     */
    public static InputTimeBox create(
            String label, Date time, DateTimeFormatInfo dateTimeFormatInfo) {
        return new InputTimeBox(label, time, dateTimeFormatInfo);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        String stringValue = getStringValue();
        return isNull(stringValue) || stringValue.isEmpty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmptyIgnoreSpaces() {
        String stringValue = getStringValue();
        return isEmpty() || stringValue.trim().isEmpty();
    }

    @Override
    protected void doSetValue(Date value) {
        setStringValue(value);
        this.value = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date getValue() {
        return value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getStringValue() {
        if (nonNull(value)) {
            JsDate jsDate = new JsDate((double) value.getTime());
            return clockFor(jsDate).format();
        } else {
            return "";
        }
    }

    /**
     * @return the {@link MdiIcon} that opens the picker
     */
    public MdiIcon getTimeIcon() {
        return timeIcon;
    }

    /**
     * @param timeIcon the {@link MdiIcon} that opens the picker
     */
    public void setTimeIcon(MdiIcon timeIcon) {
        this.timeIcon = timeIcon;
    }

    /**
     * @param showSeconds boolean, true to show seconds in the time
     * @return same instance
     */
    public InputTimeBox setShowSeconds(boolean showSeconds) {
        this.showSeconds = showSeconds;
        setClockStyle(this.clockStyle);
        return this;
    }

    /**
     * @param clockStyle {@link ClockStyle}
     * @return same instance
     */
    public InputTimeBox setClockStyle(ClockStyle clockStyle) {
        this.clockStyle = clockStyle;
        if (_12.equals(clockStyle)) {
            this.clock = new Clock12(dateTimeFormatInfo);
            mask.setPattern(showSeconds ? CLOCK_12_WITH_SECONDS_PATTERN : CLOCK_12_PATTERN);
            mask.setRegex(showSeconds ? CLOCK_12_WITH_SECONDS_REGEX : CLOCK_12_REGEX);
        } else {
            this.clock = new Clock24(dateTimeFormatInfo);
            mask.setPattern(showSeconds ? CLOCK_24_WITH_SECONDS_PATTERN : CLOCK_24_PATTERN);
            mask.setRegex(showSeconds ? CLOCK_24_WITH_SECONDS_REGEX : CLOCK_24_REGEX);
        }
        this.clock.setShowSeconds(showSeconds);
        setStringValue(value);
        return this;
    }

    /**
     * Sets the error message that will be shown if the input does not match the time pattern
     *
     * @param notMatchedErrorMessage the message
     * @return same instance
     */
    public InputTimeBox setNotMatchedErrorMessage(String notMatchedErrorMessage) {
        if (isNull(notMatchedErrorMessage)) {
            this.notMatchedErrorMessage = DEFAULT_NOT_MATCHED_MESSAGE;
        } else {
            this.notMatchedErrorMessage = notMatchedErrorMessage;
        }
        return this;
    }

    private void setStringValue(Date time) {
        if (nonNull(time)) {
            JsDate jsDate = new JsDate((double) time.getTime());
            this.getInputElement().element().value = clockFor(jsDate).format();
        } else {
            this.getInputElement().element().value = mask.getPattern();
        }
        this.value = time;
    }

    private Clock clockFor(JsDate jsDate) {
        Clock clock = this.clock.getFor(jsDate);
        clock.setShowSeconds(showSeconds);
        return clock;
    }
}
