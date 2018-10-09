package org.dominokit.domino.ui.forms;

import org.dominokit.domino.ui.utils.ElementUtil;

import static java.util.Objects.isNull;

public class ShortBox extends NumberBox<ShortBox, Short> {

    private Short maxValue;

    public static ShortBox create() {
        return new ShortBox();
    }

    public static ShortBox create(String label) {
        return new ShortBox(label);
    }

    public ShortBox() {
        this("");
    }

    public ShortBox(String label) {
        super(label);
        ElementUtil.numbersOnly(this);
    }

    @Override
    protected void clearValue() {
        value((short) 0);
    }

    @Override
    protected Short parseValue(String value) {
        return Short.parseShort(value);
    }

    @Override
    protected boolean isExceedMaxValue(Short value) {
        return value > getMaxValue();
    }

    @Override
    protected Short getMaxValue() {
        return isNull(maxValue) ? Short.MAX_VALUE : maxValue;
    }

    public ShortBox setMaxValue(short maxValue) {
        this.maxValue = maxValue;
        return this;
    }

    @Override
    public ShortBox setMinValue(Short minValue) {
        setAttribute("min", String.valueOf(minValue));
        return this;
    }

    @Override
    public ShortBox setMaxValue(Short maxValue) {
        this.maxValue = maxValue;
        setAttribute("max", String.valueOf(maxValue));
        return this;
    }

    @Override
    public ShortBox setStep(Short step) {
        setAttribute("step", String.valueOf(step));
        return this;
    }
}
