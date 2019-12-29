package org.dominokit.domino.ui.forms;

import org.dominokit.domino.ui.utils.ElementUtil;

public class LongBox extends NumberBox<LongBox, Long> {

    public static LongBox create() {
        return new LongBox();
    }

    public static LongBox create(String label) {
        return new LongBox(label);
    }

    public LongBox() {
        this("");
    }

    public LongBox(String label) {
        super(label);
        ElementUtil.numbersOnly(this);
    }

    @Override
    protected void clearValue() {
        value(0L);
    }

    @Override
    protected Long parseValue(String value) {
        double dValue = getNumberFormat().parse(value);
        double maxLong=new Double(getMaxValue());

        if(dValue > maxLong){
            throw new NumberFormatException("Exceeded maximum value");
        }
        return new Double(dValue).longValue();
    }

    @Override
    protected Long defaultMaxValue() {
        return Long.MAX_VALUE;
    }

    @Override
    protected Long defaultMinValue() {
        return Long.MIN_VALUE;
    }

    @Override
    protected boolean isExceedMaxValue(Long maxValue, Long value) {
        return value > maxValue;
    }

    @Override
    protected boolean isLowerThanMinValue(Long minValue, Long value) {
        return value < minValue;
    }
}
