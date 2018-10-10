package org.dominokit.domino.ui.forms;

import java.math.BigDecimal;

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
    }

    @Override
    protected void clearValue() {
        value(BigDecimal.ZERO);
    }

    @Override
    protected BigDecimal parseValue(String value) {
        return new BigDecimal(value);
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
