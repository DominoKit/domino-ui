package org.dominokit.domino.ui.forms;

import elemental2.dom.Element;
import elemental2.dom.HTMLDataListElement;
import elemental2.dom.HTMLInputElement;
import elemental2.dom.HTMLOptionElement;
import jsinterop.base.Js;
import org.dominokit.domino.ui.forms.validations.ValidationResult;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.*;

public class EmailBox extends AbstractValueBox<EmailBox, HTMLInputElement, String> {

    private static final String EMAIL = "email";
    private HTMLDataListElement suggestionsDataList = datalist().asElement();
    private String invalidEmailErrorMessage;
    private Map<String, HTMLOptionElement> suggestedValues = new HashMap<>();
    private String invalidPatternErrorMessage;

    public EmailBox() {
        this(EMAIL, "");
    }

    public EmailBox(String label) {
        this(EMAIL, label);
    }

    public EmailBox(String type, String label) {
        super(type, label);
        init(this);
        suggestionsDataList.id = getDominoId();
        getInputElement().setAttribute("list", getDominoId());
        getInputElement().asElement().parentNode.appendChild(suggestionsDataList);
        addInvalidEmailValidator();
        addInvalidPatternValidator();
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

    private void addInvalidEmailValidator() {
        addValidator(() -> {
            HTMLInputElement inputElement = Js.uncheckedCast(getInputElement().asElement());
            if (inputElement.validity.typeMismatch) {
                return ValidationResult.invalid(getInvalidEmailErrorMessage());
            }
            return ValidationResult.valid();
        });
    }

    public static EmailBox create() {
        return new EmailBox();
    }

    public static EmailBox create(String label) {
        return new EmailBox(label);
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

    public EmailBox setType(String type) {
        getInputElement().asElement().type = type;
        return this;
    }

    @Override
    public String getStringValue() {
        return getValue();
    }

    public EmailBox setInvalidEmailErrorMessage(String invalidEmailErrorMessage) {
        this.invalidEmailErrorMessage = invalidEmailErrorMessage;
        return this;
    }

    private String getInvalidEmailErrorMessage() {
        return isNull(invalidEmailErrorMessage) ? "Invalid email" : invalidEmailErrorMessage;
    }

    public EmailBox setMultiple(boolean multiple) {
        if (multiple) {
            getInputElement().setAttribute("multiple", multiple);
        } else {
            getInputElement().removeAttribute("multiple");
        }
        return this;
    }

    public EmailBox addSuggestedValue(String suggestedValue) {
        HTMLOptionElement optionElement = option().attr("value", suggestedValue).asElement();
        suggestionsDataList.appendChild(optionElement);
        suggestedValues.put(suggestedValue, optionElement);
        return this;
    }

    public EmailBox setSuggestedValues(List<String> suggestedValues) {
        clearSuggestions();
        suggestedValues.forEach(this::addSuggestedValue);
        return this;
    }

    public EmailBox removeSuggestedValue(String suggestedValue) {
        if (this.suggestedValues.containsKey(suggestedValue)) {
            this.suggestedValues.get(suggestedValue).remove();
            suggestedValues.remove(suggestedValue);
        }
        return this;
    }

    public Collection<String> getSuggestedValues() {
        return suggestedValues.keySet();
    }

    public EmailBox clearSuggestions() {
        suggestedValues.values().forEach(Element::remove);
        suggestedValues.clear();
        return this;
    }

    public EmailBox setPattern(String pattern) {
        getInputElement().setAttribute("pattern", pattern);
        return this;
    }

    public EmailBox setPattern(String pattern, String errorMessage) {
        setPattern(pattern);
        setInvalidPatternErrorMessage(errorMessage);
        return this;
    }

    public String getPattern() {
        return getInputElement().getAttribute("pattern");
    }

    public EmailBox setInvalidPatternErrorMessage(String invalidPatternErrorMessage) {
        this.invalidPatternErrorMessage = invalidPatternErrorMessage;
        return this;
    }

    public String getInvalidPatternErrorMessage() {
        return isNull(invalidPatternErrorMessage) ? "Value mismatch pattern [" + getPattern() + "]" : invalidPatternErrorMessage;
    }
}
