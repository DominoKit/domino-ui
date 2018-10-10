package org.dominokit.domino.ui.forms;

import elemental2.dom.*;
import jsinterop.base.Js;
import org.dominokit.domino.ui.forms.validations.ValidationResult;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.*;

public class InputValueBox<T extends InputValueBox<T>> extends AbstractValueBox<T, HTMLInputElement, String> {
    private HTMLElement suggestionsDataList = datalist().asElement();
    private String typeMismatchErrorMessage;
    private Map<String, HTMLOptionElement> suggestedValues = new HashMap<>();
    private String invalidPatternErrorMessage;

    public InputValueBox(String type, String label) {
        super(type, label);
        init((T) this);
        suggestionsDataList.id = getDominoId();
        getInputElement().setAttribute("list", getDominoId());
        getInputElement().asElement().parentNode.appendChild(suggestionsDataList);
        addTypeMismatchValidator();
        addInvalidPatternValidator();
        setAutoValidation(true);
    }

    private void addInvalidPatternValidator() {
        addValidator(() -> {
            HTMLInputElement inputElement = Js.uncheckedCast(getInputElement().asElement());
            if (inputElement.validity.patternMismatch) {
                return ValidationResult.invalid(getInvalidPatternErrorMessage());
            }
            return ValidationResult.valid();
        });
    }

    private void addTypeMismatchValidator() {
        addValidator(() -> {
            HTMLInputElement inputElement = Js.uncheckedCast(getInputElement().asElement());
            if (inputElement.validity.typeMismatch) {
                return ValidationResult.invalid(getTypeMismatchErrorMessage());
            }
            return ValidationResult.valid();
        });
    }

    @Override
    protected HTMLInputElement createInputElement(String type) {
        return input(type).css("form-control").asElement();
    }

    @Override
    protected void clearValue() {
        value("");
    }

    @Override
    protected void doSetValue(String value) {
        if (nonNull(value)) {
            getInputElement().asElement().value = value;
        } else {
            getInputElement().asElement().value = "";
        }
    }

    @Override
    public String getValue() {
        return getInputElement().asElement().value;
    }

    public T setType(String type) {
        getInputElement().asElement().type = type;
        return (T) this;
    }

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

    public T addSuggestedValue(String suggestedValue) {
        HTMLOptionElement optionElement = option().attr("value", suggestedValue).asElement();
        suggestionsDataList.appendChild(optionElement);
        suggestedValues.put(suggestedValue, optionElement);
        return (T) this;
    }

    public T setSuggestedValues(List<String> suggestedValues) {
        clearSuggestions();
        suggestedValues.forEach(this::addSuggestedValue);
        return (T) this;
    }

    public T removeSuggestedValue(String suggestedValue) {
        if (this.suggestedValues.containsKey(suggestedValue)) {
            this.suggestedValues.get(suggestedValue).remove();
            suggestedValues.remove(suggestedValue);
        }
        return (T) this;
    }

    public Collection<String> getSuggestedValues() {
        return suggestedValues.keySet();
    }

    public T clearSuggestions() {
        suggestedValues.values().forEach(Element::remove);
        suggestedValues.clear();
        return (T) this;
    }

    public T setPattern(String pattern) {
        getInputElement().setAttribute("pattern", pattern);
        return (T) this;
    }

    public T setPattern(String pattern, String errorMessage) {
        setPattern(pattern);
        setInvalidPatternErrorMessage(errorMessage);
        return (T) this;
    }

    public String getPattern() {
        return getInputElement().getAttribute("pattern");
    }

    public T setInvalidPatternErrorMessage(String invalidPatternErrorMessage) {
        this.invalidPatternErrorMessage = invalidPatternErrorMessage;
        return (T) this;
    }

    public String getInvalidPatternErrorMessage() {
        return isNull(invalidPatternErrorMessage) ? "Value mismatch pattern [" + getPattern() + "]" : invalidPatternErrorMessage;
    }

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
}
