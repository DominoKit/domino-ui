package org.dominokit.domino.ui.forms;

import org.dominokit.domino.ui.utils.ElementUtil;

import static java.util.Objects.isNull;

public class LongBox extends NumberBox<LongBox, Long> {

    private Long maxValue;

    public static LongBox create() {
        return new LongBox();
    }

    public static LongBox create(String label) {
        return new LongBox(label);
    }

    public LongBox() {
        this("");
    }

    public LongBox(String label) {
        super(label);
        ElementUtil.numbersOnly(this);
    }

    @Override
    protected void clearValue() {
        value(0L);
    }

    @Override
    protected Long parseValue(String value) {
        return Long.parseLong(value);
    }

    @Override
    protected boolean isExceedMaxValue(Long value) {
        return value > getMaxValue();
    }

    @Override
    protected Long getMaxValue() {
        return isNull(maxValue) ? Long.MAX_VALUE : maxValue;
    }

    public LongBox setMaxValue(long maxValue) {
        this.maxValue = maxValue;
        return this;
    }

    @Override
    public LongBox setMinValue(Long minValue) {
        setAttribute("min", String.valueOf(minValue));
        return this;
    }

    @Override
    public LongBox setMaxValue(Long maxValue) {
        this.maxValue = maxValue;
        setAttribute("max", String.valueOf(maxValue));
        return this;
    }

    @Override
    public LongBox setStep(Long step) {
        setAttribute("step", String.valueOf(step));
        return this;
    }
}
