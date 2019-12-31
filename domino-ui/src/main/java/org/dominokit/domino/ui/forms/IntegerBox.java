package org.dominokit.domino.ui.forms;

import org.dominokit.domino.ui.utils.ElementUtil;

public class IntegerBox extends NumberBox<IntegerBox, Integer> {

    public static IntegerBox create() {
        return new IntegerBox();
    }

    public static IntegerBox create(String label) {
        return new IntegerBox(label);
    }

    public IntegerBox() {
        this("");
    }

    public IntegerBox(String label) {
        super(label);
        ElementUtil.numbersOnly(this);
    }

    @Override
    protected void clearValue() {
        value(0);
    }

    @Override
    protected Integer parseValue(String value) {
        double dValue = getNumberFormat().parse(value);
        return new Double(dValue).intValue();
    }

    @Override
    protected Integer defaultMaxValue() {
        return Integer.MAX_VALUE;
    }

    @Override
    protected Integer defaultMinValue() {
        return Integer.MIN_VALUE;
    }

    @Override
    protected boolean isExceedMaxValue(Integer maxValue, Integer value) {
        return value > maxValue;
    }

    @Override
    protected boolean isLowerThanMinValue(Integer minValue, Integer value) {
        return value < minValue;
    }
}
