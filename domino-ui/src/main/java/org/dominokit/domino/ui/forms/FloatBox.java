package org.dominokit.domino.ui.forms;

import elemental2.core.JsNumber;
import org.dominokit.domino.ui.utils.ElementUtil;

public class FloatBox extends NumberBox<FloatBox, Float> {

    public static FloatBox create() {
        return new FloatBox();
    }

    public static FloatBox create(String label) {
        return new FloatBox(label);
    }

    public FloatBox() {
        this("");
    }

    public FloatBox(String label) {
        super(label);
        ElementUtil.decimalOnly(this);
    }

    @Override
    protected void clearValue() {
        value(0.0F);
    }

    @Override
    protected Float parseValue(String value) {
        return Float.parseFloat(value);
    }

    @Override
    protected boolean isExceedMaxValue(Float maxValue, Float value) {
        return value > maxValue;
    }

    @Override
    protected boolean isLowerThanMinValue(Float minValue, Float value) {
        return value < minValue;
    }

    @Override
    protected Float defaultMaxValue() {
        return (float) JsNumber.POSITIVE_INFINITY;
    }

    @Override
    protected Float defaultMinValue() {
        return (float) JsNumber.NEGATIVE_INFINITY;
    }
}
