package org.dominokit.domino.ui.forms;

import org.dominokit.domino.ui.utils.ElementUtil;

import static java.util.Objects.isNull;

public class FloatBox extends NumberBox<FloatBox, Float> {

    private Float maxValue;

    public static FloatBox create() {
        return new FloatBox();
    }

    public static FloatBox create(String label) {
        return new FloatBox(label);
    }

    public FloatBox() {
        this("");
    }

    public FloatBox(String label) {
        super(label);
        ElementUtil.decimalOnly(this);
    }

    @Override
    protected void clearValue() {
        value(0.0F);
    }

    @Override
    protected Float parseValue(String value) {
        return Float.parseFloat(value);
    }

    @Override
    protected boolean isExceedMaxValue(Float value) {
        return value > getMaxValue();
    }

    @Override
    protected Float getMaxValue() {
        return isNull(maxValue) ? Float.MAX_VALUE : maxValue;
    }

    public FloatBox setMaxValue(float maxValue) {
        this.maxValue = maxValue;
        return this;
    }

    @Override
    public FloatBox setMinValue(Float minValue) {
        setAttribute("min", String.valueOf(minValue));
        return this;
    }

    @Override
    public FloatBox setMaxValue(Float maxValue) {
        this.maxValue = maxValue;
        setAttribute("max", String.valueOf(maxValue));
        return this;
    }

    @Override
    public FloatBox setStep(Float step) {
        setAttribute("step", String.valueOf(step));
        return this;
    }
}
