package org.dominokit.domino.ui.forms;

import elemental2.core.JsNumber;
import org.dominokit.domino.ui.utils.ElementUtil;

/**
 * A component that has an input to take/provide float value
 */
public class FloatBox extends NumberBox<FloatBox, Float> {

    /**
     *
     * @return a new instance without a label
     */
    public static FloatBox create() {
        return new FloatBox();
    }

    /**
     *
     * @return a new instance with a label
     */
    public static FloatBox create(String label) {
        return new FloatBox(label);
    }

    /**
     * Create instance without a label
     */
    public FloatBox() {
        this("");
    }

    /**
     * Create an instance with a label
     * @param label String
     */
    public FloatBox(String label) {
        super(label);
        ElementUtil.decimalOnly(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void clearValue() {
        value(0.0F);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Float parseValue(String value) {
        double dValue = getNumberFormat().parse(value);
        double maxFloat=new Double(getMaxValue());

        if(dValue > maxFloat){
            throw new NumberFormatException("Exceeded maximum value");
        }
        return new Double(dValue).floatValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean isExceedMaxValue(Float maxValue, Float value) {
        return value > maxValue;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean isLowerThanMinValue(Float minValue, Float value) {
        return value < minValue;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Float defaultMaxValue() {
        return (float) JsNumber.POSITIVE_INFINITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Float defaultMinValue() {
        return (float) JsNumber.NEGATIVE_INFINITY;
    }
}
