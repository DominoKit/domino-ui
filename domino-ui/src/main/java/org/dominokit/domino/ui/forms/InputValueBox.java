package org.dominokit.domino.ui.forms;

import elemental2.dom.Element;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;
import elemental2.dom.HTMLOptionElement;
import jsinterop.base.Js;
import org.dominokit.domino.ui.forms.validations.InputAutoValidator;
import org.dominokit.domino.ui.forms.validations.ValidationResult;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.*;

/**
 * A Base implementation for special type components with text input
 * @param <T> The type of the component extending from this class
 * @see TelephoneBox
 * @see EmailBox
 */
public class InputValueBox<T extends InputValueBox<T>> extends AbstractValueBox<T, HTMLInputElement, String> {
    private HTMLElement suggestionsDataList = datalist().element();
    private String typeMismatchErrorMessage;
    private Map<String, HTMLOptionElement> suggestedValues = new HashMap<>();
    private String invalidPatternErrorMessage;
    private boolean emptyAsNull;

    /**
     * Creates an instance of the specified type with a label
     * @param type String HTMLInputElement type
     * @param label String
     */
    public InputValueBox(String type, String label) {
        super(type, label);
        suggestionsDataList.id = getDominoId();
        getInputElement().setAttribute("list", getDominoId());
        getInputElement().element().parentNode.appendChild(suggestionsDataList);
        addTypeMismatchValidator();
        addInvalidPatternValidator();
        setAutoValidation(true);
    }

    private void addInvalidPatternValidator() {
        addValidator(() -> {
            HTMLInputElement inputElement = Js.uncheckedCast(getInputElement().element());
            if (inputElement.validity.patternMismatch) {
                return ValidationResult.invalid(getInvalidPatternErrorMessage());
            }
            return ValidationResult.valid();
        });
    }

    private void addTypeMismatchValidator() {
        addValidator(() -> {
            HTMLInputElement inputElement = Js.uncheckedCast(getInputElement().element());
            if (inputElement.validity.typeMismatch) {
                return ValidationResult.invalid(getTypeMismatchErrorMessage());
            }
            return ValidationResult.valid();
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected HTMLInputElement createInputElement(String type) {
        return input(type).element();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void clearValue() {
        value("");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void doSetValue(String value) {
        if (nonNull(value)) {
            getInputElement().element().value = value;
        } else {
            getInputElement().element().value = "";
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getValue() {
        String value = getInputElement().element().value;
        if (value.isEmpty() && isEmptyAsNull()) {
            return null;
        }
        return value;
    }

    /**
     * Sets the type for the HTMLInputElement of this component
     * @param type String
     * @return same implementing component instance
     */
    public T setType(String type) {
        getInputElement().element().type = type;
        return (T) this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getStringValue() {
        return getValue();
    }

    public T setTypeMismatchErrorMessage(String typeMismatchErrorMessage) {
        this.typeMismatchErrorMessage = typeMismatchErrorMessage;
        return (T) this;
    }

    private String getTypeMismatchErrorMessage() {
        return isNull(typeMismatchErrorMessage) ? "Invalid value" : typeMismatchErrorMessage;
    }

    /**
     * Adds a String value as a suggested value {@link HTMLOptionElement} for this input
     * @param suggestedValue
     * @return same implementing component instance
     */
    public T addSuggestedValue(String suggestedValue) {
        HTMLOptionElement optionElement = option().attr("value", suggestedValue).element();
        suggestionsDataList.appendChild(optionElement);
        suggestedValues.put(suggestedValue, optionElement);
        return (T) this;
    }

    /**
     * Adds a List of String values as a suggested values {@link HTMLOptionElement} for this input
     * @param suggestedValues List of String
     * @return same implementing component instance
     */
    public T setSuggestedValues(List<String> suggestedValues) {
        clearSuggestions();
        suggestedValues.forEach(this::addSuggestedValue);
        return (T) this;
    }

    /**
     * Removes a suggested value {@link HTMLOptionElement} from this input
     * @param suggestedValue String
     * @return same implementing component instance
     */
    public T removeSuggestedValue(String suggestedValue) {
        if (this.suggestedValues.containsKey(suggestedValue)) {
            this.suggestedValues.get(suggestedValue).remove();
            suggestedValues.remove(suggestedValue);
        }
        return (T) this;
    }

    /**
     *
     * @return a List of all suggested values of this component
     */
    public Collection<String> getSuggestedValues() {
        return suggestedValues.keySet();
    }

    /**
     * removes all suggested values
     * @return same implementing component
     */
    public T clearSuggestions() {
        suggestedValues.values().forEach(Element::remove);
        suggestedValues.clear();
        return (T) this;
    }

    /**
     * Sets a pattern to be used for formatting this component value, this is the <b>pattern</b> html attribute
     * @param pattern String
     * @return same implementing component
     */
    public T setPattern(String pattern) {
        getInputElement().setAttribute("pattern", pattern);
        return (T) this;
    }

    /**
     * Sets a pattern to be used for formatting this component value, this is the <b>pattern</b> html attribute
     * @param pattern String
     * @param errorMessage String error message to be used when the field value does not match the provided pattern
     * @return same implementing component
     */
    public T setPattern(String pattern, String errorMessage) {
        setPattern(pattern);
        setInvalidPatternErrorMessage(errorMessage);
        return (T) this;
    }

    /**
     *
     * @return the value of the <b>pattern</b> attribute of this component input element
     */
    public String getPattern() {
        return getInputElement().getAttribute("pattern");
    }

    /**
     *
     * @param invalidPatternErrorMessage String error message to be used when the field value does not match the provided pattern
     * @return same implementing component instance
     */
    public T setInvalidPatternErrorMessage(String invalidPatternErrorMessage) {
        this.invalidPatternErrorMessage = invalidPatternErrorMessage;
        return (T) this;
    }

    /**
     *
     * @return the String error message to be used when the field value does not match the provided pattern
     */
    public String getInvalidPatternErrorMessage() {
        return isNull(invalidPatternErrorMessage) ? "Value mismatch pattern [" + getPattern() + "]" : invalidPatternErrorMessage;
    }

    /**
     *
     * @param enableSuggestions boolean, if true the component will show suggested values, otherwise it will not.
     * @return same implementing component instance
     */
    public T setEnableSuggestions(boolean enableSuggestions) {
        if (enableSuggestions) {
            getInputElement().setAttribute("list", getDominoId());
            getInputElement().style().remove("disabled-suggestions");
        } else {
            getInputElement().removeAttribute("list");
            getInputElement().style().add("disabled-suggestions");
        }
        return (T) this;
    }

    /**
     *
     * @param emptyAsNull boolean, if true empty value will be treated as null otherwise it is empty string
     * @return same implementing component instance
     */
    public T setEmptyAsNull(boolean emptyAsNull) {
        this.emptyAsNull = emptyAsNull;
        return (T) this;
    }

    /**
     *
     * @return boolean, if true empty value will be treated as null otherwise it is empty string
     */
    public boolean isEmptyAsNull() {
        return emptyAsNull;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected AutoValidator createAutoValidator(AutoValidate autoValidate) {
        return new InputAutoValidator<>(getInputElement(), autoValidate);
    }
}
