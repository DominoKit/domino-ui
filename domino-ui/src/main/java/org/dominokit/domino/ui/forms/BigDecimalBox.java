package org.dominokit.domino.ui.forms;

import org.dominokit.domino.ui.utils.ElementUtil;

import java.math.BigDecimal;

import static java.util.Objects.nonNull;

/**
 * A component that has an input to take/provide BigDecimal value
 */
public class BigDecimalBox extends NumberBox<BigDecimalBox, BigDecimal> {

    /**
     *
     * @return a new instance without a label
     */
    public static BigDecimalBox create() {
        return new BigDecimalBox();
    }

    /**
     *
     * @param label String
     * @return new instance with a label
     */
    public static BigDecimalBox create(String label) {
        return new BigDecimalBox(label);
    }

    /**
     * Create instance without a label
     */
    public BigDecimalBox() {
        this("");
    }

    /**
     * Create an instance with a label
     * @param label String
     */
    public BigDecimalBox(String label) {
        super(label);
        ElementUtil.decimalOnly(this);
    }

    /**
     * {@inheritDoc}
     * clears the field and set the value to BigDecimal.ZERO
     */
    @Override
    protected void clearValue() {
        value(BigDecimal.ZERO);
    }

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    protected BigDecimal parseValue(String value) {
        double dValue = getNumberFormat().parse(value);
        if (nonNull(getMaxValue())) {
            double maxBd = getMaxValue().doubleValue();

            if (dValue > maxBd) {
                throw new NumberFormatException("Exceeded maximum value");
            }
        }
        return new BigDecimal(dValue);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean isExceedMaxValue(BigDecimal maxValue, BigDecimal value) {
        return value.compareTo(maxValue) > 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean isLowerThanMinValue(BigDecimal minValue, BigDecimal value) {
        return value.compareTo(minValue) < 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected BigDecimal defaultMaxValue() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected BigDecimal defaultMinValue() {
        return null;
    }
}
