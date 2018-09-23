package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.dominokit.domino.ui.utils.ValidationResult;
import org.jboss.gwt.elemento.core.Elements;

public class IntegerBox extends AbstractValueBox<IntegerBox, HTMLInputElement, Integer> {

    private static final String TEXT = "text";
    private int maxValue = Integer.MAX_VALUE;

    public IntegerBox() {
        this(TEXT, "");
    }

    public IntegerBox(String label) {
        this(TEXT, label);
    }

    public IntegerBox(String type, String label) {
        super(type, label);
        init(this);
        ElementUtil.numbersOnly(this);
        addValidator(() -> {
            if (value() > maxValue) {
                return ValidationResult.invalid("Maximum allowed value is [" + maxValue + "]");
            }
            return ValidationResult.valid();
        });
        setAutoValidation(true);
    }

    public static IntegerBox create() {
        return new IntegerBox();
    }

    public static IntegerBox create(String label) {
        return new IntegerBox(label);
    }

    @Override
    protected HTMLInputElement createInputElement(String type) {
        return Elements.input(type).css("form-control").asElement();
    }

    @Override
    protected void clearValue() {
        withValue(0);
    }

    @Override
    protected void doSetValue(Integer value) {
        getInputElement().asElement().value = Integer.toString(value);
    }

    @Override
    public Integer value() {
        try {
            String value = getInputElement().asElement().value;
            if (value.isEmpty()) {
                return 0;
            }
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
//            invalidate("Maximum allowed value is [" + maxValue + "]");
            throw new IllegalStateException("invalid integer value", e);
        }
    }

    public IntegerBox setType(String type) {
        getInputElement().asElement().type = type;
        return this;
    }

    @Override
    public String getStringValue() {
        return Integer.toString(value());
    }

    public IntegerBox setMaxValue(int maxValue) {
        this.maxValue = maxValue;
        return this;
    }
}
