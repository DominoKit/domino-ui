package org.dominokit.domino.ui.forms;

import org.dominokit.domino.ui.utils.ElementUtil;

import java.math.BigDecimal;

import static java.util.Objects.nonNull;

public class BigDecimalBox extends NumberBox<BigDecimalBox, BigDecimal> {

    public static BigDecimalBox create() {
        return new BigDecimalBox();
    }

    public static BigDecimalBox create(String label) {
        return new BigDecimalBox(label);
    }

    public BigDecimalBox() {
        this("");
    }

    public BigDecimalBox(String label) {
        super(label);
        ElementUtil.decimalOnly(this);
    }

    @Override
    protected void clearValue() {
        value(BigDecimal.ZERO);
    }

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

    @Override
    protected boolean isExceedMaxValue(BigDecimal maxValue, BigDecimal value) {
        return value.compareTo(maxValue) > 0;
    }

    @Override
    protected boolean isLowerThanMinValue(BigDecimal minValue, BigDecimal value) {
        return value.compareTo(minValue) < 0;
    }

    @Override
    protected BigDecimal defaultMaxValue() {
        return null;
    }

    @Override
    protected BigDecimal defaultMinValue() {
        return null;
    }
}
