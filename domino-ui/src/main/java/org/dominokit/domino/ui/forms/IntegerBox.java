package org.dominokit.domino.ui.forms;

import org.dominokit.domino.ui.utils.ElementUtil;

/**
 * A component that has an input to take/provide Integer value
 */
public class IntegerBox extends NumberBox<IntegerBox, Integer> {

    /**
     *
     * @return a new instance without a label
     */
    public static IntegerBox create() {
        return new IntegerBox();
    }

    /**
     *
     * @param label String
     * @return new instance with a label
     */
    public static IntegerBox create(String label) {
        return new IntegerBox(label);
    }

    /**
     * Create instance without a label
     */
    public IntegerBox() {
        this("");
    }

    /**
     * Create an instance with a label
     * @param label String
     */
    public IntegerBox(String label) {
        super(label);
        ElementUtil.numbersOnly(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void clearValue() {
        value(0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer parseValue(String value) {
        double dValue = getNumberFormat().parse(value);
        return new Double(dValue).intValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer defaultMaxValue() {
        return Integer.MAX_VALUE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer defaultMinValue() {
        return Integer.MIN_VALUE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean isExceedMaxValue(Integer maxValue, Integer value) {
        return value > maxValue;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean isLowerThanMinValue(Integer minValue, Integer value) {
        return value < minValue;
    }
}
