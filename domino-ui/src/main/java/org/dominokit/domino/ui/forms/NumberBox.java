package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.forms.validations.InputAutoValidator;
import org.dominokit.domino.ui.forms.validations.ValidationResult;
import org.gwtproject.i18n.client.NumberFormat;
import org.jboss.elemento.Elements;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * A Base implementation for form inputs that takes/provide numeric values
 * @param <T> The type of the class extending from this base class
 * @param <E> The Numeric type of the component value
 */
public abstract class NumberBox<T extends NumberBox<T, E>, E extends Number> extends AbstractValueBox<T, HTMLInputElement, E> {

    private final ChangeHandler<E> formatValueChangeHandler = value -> formatValue();
    private String maxValueErrorMessage;
    private String minValueErrorMessage;
    private String invalidFormatMessage;
    private boolean formattingEnabled;
    private String pattern = null;

    /**
     * Create an instance with a label
     * @param label String
     */
    public NumberBox(String label) {
        super("tel", label);
        addInputStringValidator();
        addMaxValueValidator();
        addMinValueValidator();
        setAutoValidation(true);
        enableFormatting();
    }

    private void addInputStringValidator() {
        addValidator(() -> {
            String inputValue = getInputElement().element().value;
            if (nonNull(inputValue) && !inputValue.isEmpty()) {
                try {
                    getNumberFormat().parse(inputValue);
                } catch (NumberFormatException e) {
                    return ValidationResult.invalid(getInvalidFormatMessage());
                }
            }
            return ValidationResult.valid();
        });
    }

    private void addMaxValueValidator() {
        addValidator(() -> {
            E value = getValue();
            if (nonNull(getMaxValue())) {
                String inputValue = getInputElement().element().value;
                if (nonNull(inputValue) && !inputValue.isEmpty()) {
                    try {
                        double parsed = getNumberFormat().parse(inputValue);
                        if (nonNull(value) && isExceedMaxValue(getMaxDoubleValue(), parsed)) {
                            return ValidationResult.invalid(getMaxValueErrorMessage());
                        }
                    } catch (NumberFormatException e) {
                        return ValidationResult.invalid(getInvalidFormatMessage());
                    }
                }
            }
            return ValidationResult.valid();
        });
    }

    /**
     *
     * @return the max value of the field as double if exists or else null
     */
    protected Double getMaxDoubleValue() {
        if (nonNull(getMaxValue())) {
            return getMaxValue().doubleValue();
        }
        return null;
    }

    private void addMinValueValidator() {
        addValidator(() -> {
            E value = getValue();
            if (nonNull(value) && isLowerThanMinValue(value)) {
                return ValidationResult.invalid(getMinValueErrorMessage());
            }
            return ValidationResult.valid();
        });
    }

    private void formatValue() {
        String stringValue = getStringValue();
        if (nonNull(stringValue) && !stringValue.isEmpty()) {
            try {
                double parsedValue = getNumberFormat().parse(stringValue);
                getInputElement().element().value = getNumberFormat().format(parsedValue);
            } catch (NumberFormatException e) {
                // nothing to format, so we do nothing!
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected HTMLInputElement createInputElement(String type) {
        return Elements.input(type).element();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void doSetValue(E value) {
        if (nonNull(value)) {
            getInputElement().element().value = getNumberFormat().format(value);
        } else {
            getInputElement().element().value = "";
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E getValue() {
        String value = getInputElement().element().value;
        try {
            if (value.isEmpty()) {
                return null;
            }
            E parsedValue = parseValue(value);
            return parsedValue;
        } catch (NumberFormatException e) {
            invalidate(value.startsWith("-") ? getMinValueErrorMessage() : getMaxValueErrorMessage());
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return getInputElement().element().value.isEmpty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getStringValue() {
        return getInputElement().element().value;
    }

    /**
     * Sets the minimum allowed value for the field
     * @param minValue E minimum value
     * @return same component instance
     */
    public T setMinValue(E minValue) {
        getInputElement().element().min = getNumberFormat().format(minValue);
        return (T) this;
    }

    /**
     * Sets the maximum allowed value for the field
     * @param maxValue E maximum value
     * @return same component instance
     */
    public T setMaxValue(E maxValue) {
        getInputElement().element().max = getNumberFormat().format(maxValue);
        return (T) this;
    }

    /**
     * Sets the increment step attribute for the field
     * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/step">HTML attribute: step</a>
     * @param step E numeric value
     * @return same field instance
     */
    public T setStep(E step) {
        getInputElement().element().step = getNumberFormat().format(step);
        return (T) this;
    }

    /**
     * @returnthe maximum allowed value for the field if exists or else return {@link #defaultMaxValue()}
     */
    public E getMaxValue() {
        String maxValue = getInputElement().element().max;
        if (isNull(maxValue) || maxValue.isEmpty()) {
            return defaultMaxValue();
        }
        return parseValue(maxValue);
    }

    /**
     * @returnthe minimum allowed value for the field if exists or else return {@link #defaultMinValue()}
     */
    public E getMinValue() {
        String minValue = getInputElement().element().min;
        if (isNull(minValue) || minValue.isEmpty()) {
            return defaultMinValue();
        }
        return parseValue(minValue);
    }

    /**
     *
     * @return the step value for the field if exists or else return null
     * @see #setStep(Number)
     */
    public E getStep() {
        String step = getInputElement().element().step;
        if (isNull(step) || step.isEmpty()) {
            return null;
        }
        return parseValue(step);
    }

    /**
     *
     * @param maxValueErrorMessage String error message to display when the field value is greater than the maximum value
     * @return same field instance
     */
    public T setMaxValueErrorMessage(String maxValueErrorMessage) {
        this.maxValueErrorMessage = maxValueErrorMessage;
        return (T) this;
    }

    /**
     *
     * @param minValueErrorMessage String error message to display when the field value is less than the minimum value
     * @return same field instance
     */
    public T setMinValueErrorMessage(String minValueErrorMessage) {
        this.minValueErrorMessage = minValueErrorMessage;
        return (T) this;
    }

    /**
     *
     * @param invalidFormatMessage String error message to display when the field value does not match the field format
     * @return same field instance
     */
    public T setInvalidFormatMessage(String invalidFormatMessage) {
        this.invalidFormatMessage = invalidFormatMessage;
        return (T) this;
    }

    /**
     *
     * @return String error message to display when the field value is greater than the maximum value
     */
    public String getMaxValueErrorMessage() {
        return isNull(maxValueErrorMessage) ? "Maximum allowed value is [" + getMaxValue() + "]" : maxValueErrorMessage;
    }

    /**
     *
     * @return String error message to display when the field value is less than the minimum value
     */
    public String getMinValueErrorMessage() {
        return isNull(minValueErrorMessage) ? "Minimum allowed value is [" + getMinValue() + "]" : minValueErrorMessage;
    }

    /**
     *
     * @return String error message to display when the field value format does not match the field format
     */
    public String getInvalidFormatMessage() {
        return isNull(invalidFormatMessage) ? "Invalid number format" : invalidFormatMessage;
    }

    private boolean isExceedMaxValue(E value) {
        E maxValue = getMaxValue();
        if (isNull(maxValue))
            return false;
        return isExceedMaxValue(maxValue, value);
    }

    private boolean isExceedMaxValue(double maxAsDouble, double valueAsDouble) {
        return valueAsDouble > maxAsDouble;
    }

    private boolean isLowerThanMinValue(E value) {
        E minValue = getMinValue();
        if (isNull(minValue))
            return false;
        return isLowerThanMinValue(minValue, value);
    }

    /**
     * Enables auto formatting the field value to match the pattern specified by {@link #setPattern(String)}
     * @return same field instance
     */
    public T enableFormatting() {
        return setFormattingEnabled(true);
    }

    /**
     * Disable auto formatting the field value to match the pattern specified by {@link #setPattern(String)}
     * @return same field instance
     */
    public T disableFormatting() {
        return setFormattingEnabled(false);
    }

    private T setFormattingEnabled(boolean formattingEnabled) {
        this.formattingEnabled = formattingEnabled;
        if (formattingEnabled) {
            if (!hasChangeHandler(formatValueChangeHandler)) {
                addChangeHandler(formatValueChangeHandler);
            }
        } else {
            removeChangeHandler(formatValueChangeHandler);
        }
        return (T) this;
    }

    /**
     *
     * @return a {@link NumberFormat} instance that should be used to format this field
     */
    protected NumberFormat getNumberFormat() {
        if (nonNull(getPattern())) {
            return NumberFormat.getFormat(getPattern());
        } else {
            return NumberFormat.getDecimalFormat();
        }
    }

    /**
     *
     * @return String pattern used to format the field value
     */
    public String getPattern() {
        return pattern;
    }

    /**
     *
     * @param pattern String pattern to format the field value
     * @return same field instance
     */
    public T setPattern(String pattern) {
        this.pattern = pattern;
        return (T) this;
    }

    /**
     * Reads a String value and convert it to the field number type
     * @param value String numeric value
     * @return E the Numeric value from the input String
     */
    protected abstract E parseValue(String value);

    /**
     *
     * @return E numeric max value as a default in case {@link #setMaxValue(Number)} is not called
     */
    protected abstract E defaultMaxValue();

    /**
     *
     * @return E numeric min value as a default in case {@link #setMinValue(Number)} is not called
     */
    protected abstract E defaultMinValue();

    /**
     * Checks if a a given value is actually greater than the maximum allowed value
     * @param maxValue E numeric value
     * @param value E numeric value
     * @return boolean, true if the value is greater than maxValue
     */
    protected abstract boolean isExceedMaxValue(E maxValue, E value);

    /**
     * Checks if a a given value is actually less than the minimum allowed value
     * @param minValue E numeric value
     * @param value E numeric value
     * @return boolean, true if the value is less than minValue
     */
    protected abstract boolean isLowerThanMinValue(E minValue, E value);

    /**
     * {@inheritDoc}
     */
    @Override
    protected AutoValidator createAutoValidator(AutoValidate autoValidate) {
        return new InputAutoValidator<>(getInputElement(), autoValidate);
    }
}
