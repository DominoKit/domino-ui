package org.dominokit.domino.ui.forms;

import org.dominokit.domino.ui.utils.ElementUtil;

import java.math.BigDecimal;

import static java.util.Objects.isNull;

public class BigDecimalBox extends NumberBox<BigDecimalBox, BigDecimal> {

    private BigDecimal maxValue;

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
        return new BigDecimal(value);
    }

    @Override
    protected boolean isExceedMaxValue(BigDecimal value) {
        if (isNull(maxValue))
            return false;
        return value.compareTo(maxValue) > 0;
    }

    @Override
    protected BigDecimal getMaxValue() {
        return maxValue;
    }

    public BigDecimalBox setMaxValue(BigDecimal maxValue) {
        this.maxValue = maxValue;
        return this;
    }
}
