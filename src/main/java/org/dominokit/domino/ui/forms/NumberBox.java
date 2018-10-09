package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.forms.validations.ValidationResult;
import org.jboss.gwt.elemento.core.Elements;

import static java.util.Objects.nonNull;

public abstract class NumberBox<T extends NumberBox<T, E>, E extends Number> extends AbstractValueBox<T, HTMLInputElement, E> {

    private static final String TEXT = "number";

    public NumberBox(String label) {
        super(TEXT, label);
        init((T) this);
        addValidator(() -> {
            E value = getValue();
            if (nonNull(value) && isExceedMaxValue(value)) {
                return ValidationResult.invalid("Maximum allowed value is [" + getMaxValue() + "]");
            }
            return ValidationResult.valid();
        });
        setAutoValidation(true);
        if (nonNull(getMaxValue())) {
            setMaxLength(getMaxValue().toString().length());
        }
    }

    @Override
    protected HTMLInputElement createInputElement(String type) {
        return Elements.input(type).css("form-control").asElement();
    }

    @Override
    protected void doSetValue(E value) {
        if(nonNull(value)){
            getInputElement().asElement().value = String.valueOf(value);
        }else{
            getInputElement().asElement().value = "";
        }

    }

    @Override
    public E getValue() {
        String value = getInputElement().asElement().value;
        try {
            if (value.isEmpty()) {
                clearInvalid();
                return null;
            }
            E eValue = parseValue(value);
            clearInvalid();
            return eValue;
        } catch (NumberFormatException e) {
            invalidate("Maximum allowed value is [" + getMaxValue() + "]");
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        return getInputElement().asElement().value.isEmpty();
    }

    @Override
    public String getStringValue() {
        return getInputElement().asElement().value;
    }

    protected abstract E parseValue(String value);

    protected abstract boolean isExceedMaxValue(E value);

    protected abstract E getMaxValue();

    public abstract T setMinValue(E minValue);
    public abstract T setMaxValue(E maxValue);
    public abstract T setStep(E step);

}
