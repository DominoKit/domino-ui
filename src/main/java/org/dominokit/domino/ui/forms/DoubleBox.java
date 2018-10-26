package org.dominokit.domino.ui.forms;

import org.dominokit.domino.ui.utils.ElementUtil;

public class DoubleBox extends NumberBox<DoubleBox, Double> {

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
    protected boolean isExceedMaxValue(Double maxValue, Double value) {
        return value.compareTo(maxValue) > 0;
    }

    @Override
    protected boolean isLowerThanMinValue(Double minValue, Double value) {
        return value.compareTo(minValue) < 0;
    }

    @Override
    protected Double defaultMaxValue() {
        return Double.MAX_VALUE;
    }

    @Override
    protected Double defaultMinValue() {
        return Double.NEGATIVE_INFINITY;
    }
}
