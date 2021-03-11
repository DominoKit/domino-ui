package org.dominokit.domino.ui.forms;

import org.dominokit.domino.ui.utils.ElementUtil;

/**
 * A component that has an input to take/provide Short value
 */
public class ShortBox extends NumberBox<ShortBox, Short> {

    /**
     *
     * @return a new instance without a label
     */
    public static ShortBox create() {
        return new ShortBox();
    }

    /**
     *
     * @param label String
     * @return new instance with a label
     */
    public static ShortBox create(String label) {
        return new ShortBox(label);
    }

    /**
     * Create instance without a label
     */
    public ShortBox() {
        this("");
    }

    /**
     * Create an instance with a label
     * @param label String
     */
    public ShortBox(String label) {
        super(label);
        ElementUtil.numbersOnly(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void clearValue() {
        value((short) 0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Short parseValue(String value) {
        double dValue = getNumberFormat().parse(value);
        double maxShort=new Double(getMaxValue());

        if(dValue > maxShort){
            throw new NumberFormatException("Exceeded maximum value");
        }
        return new Double(dValue).shortValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Short defaultMaxValue() {
        return Short.MAX_VALUE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Short defaultMinValue() {
        return Short.MIN_VALUE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean isExceedMaxValue(Short maxValue, Short value) {
        return value > maxValue;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean isLowerThanMinValue(Short minValue, Short value) {
        return value < minValue;
    }
}
