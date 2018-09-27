package org.dominokit.domino.ui.forms;

import org.dominokit.domino.ui.utils.ElementUtil;

import static java.util.Objects.isNull;

public class IntegerBox extends NumberBox<IntegerBox, Integer> {

    private Integer maxValue;

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
        return Integer.parseInt(value);
    }

    @Override
    protected boolean isExceedMaxValue(Integer value) {
        return value > getMaxValue();
    }

    @Override
    protected Integer getMaxValue() {
        return isNull(maxValue) ? Integer.MAX_VALUE : maxValue;
    }

    public IntegerBox setMaxValue(int maxValue) {
        this.maxValue = maxValue;
        return this;
    }
}
