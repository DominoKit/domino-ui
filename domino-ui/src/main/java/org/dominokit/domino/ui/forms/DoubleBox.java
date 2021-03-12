package org.dominokit.domino.ui.forms;

import org.dominokit.domino.ui.utils.ElementUtil;

/**
 * A component that has an input to take/provide Double value
 */
public class DoubleBox extends NumberBox<DoubleBox, Double> {

    /**
     *
     * @return a new instance without a label
     */
    public static DoubleBox create() {
        return new DoubleBox();
    }

    /**
     *
     * @return a new instance with a label
     */
    public static DoubleBox create(String label) {
        return new DoubleBox(label);
    }

    /**
     * Creates a DoubleBox with empty label
     */
    public DoubleBox() {
        this("");
    }

    /**
     * Creates a DoubleBox with a label
     * @param label String
     */
    public DoubleBox(String label) {
        super(label);
        ElementUtil.decimalOnly(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void clearValue() {
        value(0.0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Double parseValue(String value) {
        return getNumberFormat().parse(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean isExceedMaxValue(Double maxValue, Double value) {
        return value.compareTo(maxValue) > 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean isLowerThanMinValue(Double minValue, Double value) {
        return value.compareTo(minValue) < 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Double defaultMaxValue() {
        return Double.MAX_VALUE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Double defaultMinValue() {
        return Double.NEGATIVE_INFINITY;
    }
}
