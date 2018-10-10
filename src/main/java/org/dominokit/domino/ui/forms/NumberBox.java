package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.forms.validations.ValidationResult;
import org.jboss.gwt.elemento.core.Elements;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public abstract class NumberBox<T extends NumberBox<T, E>, E extends Number> extends AbstractValueBox<T, HTMLInputElement, E> {

    private String maxValueErrorMessage;
    private String minValueErrorMessage;

    public NumberBox(String label) {
        super("number", label);
        init((T) this);
        addValidator(() -> {
            E value = getValue();
            if (nonNull(value) && isExceedMaxValue(value)) {
                return ValidationResult.invalid(getMaxValueErrorMessage());
            }
            return ValidationResult.valid();
        });
        addValidator(() -> {
            E value = getValue();
            if (nonNull(value) && isLowerThanMixValue(value)) {
                return ValidationResult.invalid(getMinValueErrorMessage());
            }
            return ValidationResult.valid();
        });
        setAutoValidation(true);
    }

    @Override
    protected HTMLInputElement createInputElement(String type) {
        return Elements.input(type).css("form-control").asElement();
    }

    @Override
    protected void doSetValue(E value) {
        if (nonNull(value)) {
            getInputElement().asElement().value = String.valueOf(value);
        } else {
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
            E parsedValue = parseValue(value);
            clearInvalid();
            return parsedValue;
        } catch (NumberFormatException e) {
            invalidate(value.startsWith("-") ? getMinValueErrorMessage() : getMaxValueErrorMessage());
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

    public T setMinValue(E minValue) {
        getInputElement().asElement().min = minValue + "";
        return (T) this;
    }

    public T setMaxValue(E maxValue) {
        getInputElement().asElement().max = maxValue + "";
        return (T) this;
    }

    public T setStep(E step) {
        getInputElement().asElement().step = step + "";
        return (T) this;
    }

    public E getMaxValue() {
        String maxValue = getInputElement().asElement().max;
        if (isNull(maxValue) || maxValue.isEmpty()) {
            return defaultMaxValue();
        }
        return parseValue(maxValue);
    }

    public E getMinValue() {
        String minValue = getInputElement().asElement().min;
        if (isNull(minValue) || minValue.isEmpty()) {
            return defaultMinValue();
        }
        return parseValue(minValue);
    }

    public E getStep() {
        String step = getInputElement().asElement().step;
        if (isNull(step) || step.isEmpty()) {
            return null;
        }
        return parseValue(step);
    }

    public T setMaxValueErrorMessage(String maxValueErrorMessage) {
        this.maxValueErrorMessage = maxValueErrorMessage;
        return (T) this;
    }

    public T setMinValueErrorMessage(String minValueErrorMessage) {
        this.minValueErrorMessage = minValueErrorMessage;
        return (T) this;
    }

    public String getMaxValueErrorMessage() {
        return isNull(maxValueErrorMessage) ? "Maximum allowed value is [" + getMaxValue() + "]" : maxValueErrorMessage;
    }

    public String getMinValueErrorMessage() {
        return isNull(minValueErrorMessage) ? "Minimum allowed value is [" + getMinValue() + "]" : minValueErrorMessage;
    }

    private boolean isExceedMaxValue(E value) {
        E maxValue = getMaxValue();
        if (isNull(maxValue))
            return false;
        return isExceedMaxValue(maxValue, value);
    }

    private boolean isLowerThanMixValue(E value) {
        E minValue = getMinValue();
        if (isNull(minValue))
            return false;
        return isLowerThanMinValue(minValue, value);
    }

    protected abstract E parseValue(String value);

    protected abstract E defaultMaxValue();

    protected abstract E defaultMinValue();

    protected abstract boolean isExceedMaxValue(E maxValue, E value);

    protected abstract boolean isLowerThanMinValue(E minValue, E value);
}
