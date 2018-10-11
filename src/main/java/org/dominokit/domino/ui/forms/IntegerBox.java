package org.dominokit.domino.ui.forms;

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
