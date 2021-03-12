package org.dominokit.domino.ui.forms;

import org.dominokit.domino.ui.utils.ElementUtil;

/**
 * A component that has an input to take/provide Long value
 */
public class LongBox extends NumberBox<LongBox, Long> {

    /**
     *
     * @return a new instance without a label
     */
    public static LongBox create() {
        return new LongBox();
    }

    /**
     *
     * @param label String
     * @return new instance with a label
     */
    public static LongBox create(String label) {
        return new LongBox(label);
    }

    /**
     * Create instance without a label
     */
    public LongBox() {
        this("");
    }

    /**
     * Create an instance with a label
     * @param label String
     */
    public LongBox(String label) {
        super(label);
        ElementUtil.numbersOnly(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void clearValue() {
        value(0L);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Long parseValue(String value) {
        double dValue = getNumberFormat().parse(value);
        return new Double(dValue).longValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Long defaultMaxValue() {
        return Long.MAX_VALUE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Long defaultMinValue() {
        return Long.MIN_VALUE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean isExceedMaxValue(Long maxValue, Long value) {
        return value > maxValue;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean isLowerThanMinValue(Long minValue, Long value) {
        return value < minValue;
    }
}
