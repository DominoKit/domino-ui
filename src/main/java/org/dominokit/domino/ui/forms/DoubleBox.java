package org.dominokit.domino.ui.forms;

import org.dominokit.domino.ui.utils.ElementUtil;

import java.math.BigDecimal;

import static java.util.Objects.isNull;

public class DoubleBox extends NumberBox<DoubleBox, Double> {

    private Double maxValue;

    public static DoubleBox create() {
        return new DoubleBox();
    }

    public static DoubleBox create(String label) {
        return new DoubleBox(label);
    }

    public DoubleBox() {
        this("");
    }

    public DoubleBox(String label) {
        super(label);
        ElementUtil.decimalOnly(this);
    }

    @Override
    protected void clearValue() {
        value(0.0);
    }

    @Override
    protected Double parseValue(String value) {
        return Double.parseDouble(value);
    }

    @Override
    protected boolean isExceedMaxValue(Double value) {
        return value > getMaxValue();
    }

    @Override
    protected Double getMaxValue() {
        return isNull(maxValue) ? Double.MAX_VALUE : maxValue;
    }

    public DoubleBox setMaxValue(double maxValue) {
        this.maxValue = maxValue;
        return this;
    }

    @Override
    public DoubleBox setMinValue(Double minValue) {
        setAttribute("min", String.valueOf(minValue));
        return this;
    }

    @Override
    public DoubleBox setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
        setAttribute("max", String.valueOf(maxValue));
        return this;
    }

    @Override
    public DoubleBox setStep(Double step) {
        setAttribute("step", String.valueOf(step));
        return this;
    }
}
