package org.dominokit.domino.ui.forms;

import com.google.gwt.editor.client.EditorError;
import com.google.gwt.editor.client.adapters.TakesValueEditor;
import elemental2.dom.Element;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLabelElement;
import org.dominokit.domino.ui.forms.validations.ElementValidations;
import org.dominokit.domino.ui.forms.validations.RequiredValidator;
import org.dominokit.domino.ui.forms.validations.ValidationResult;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.IsReadOnly;
import org.jboss.gwt.elemento.core.Elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public abstract class BasicFormElement<T extends BasicFormElement<T, V>, V> extends BaseDominoElement<HTMLElement, T> implements FormElement<T, V>, IsReadOnly<T>, HasInputElement {

    private static final String NAME = "name";
    private DominoElement<HTMLLabelElement> helperLabel = DominoElement.of(Elements.label().css("help-info"));
    private List<HTMLLabelElement> errorLabels = new ArrayList<>();
    private ElementValidations elementValidations = new ElementValidations(this);
    private RequiredValidator requiredValidator = new RequiredValidator(this);
    private String helperText;

    private String requiredErrorMessage;

    @Override
    public T setHelperText(String helperText) {
        this.helperText = helperText;
        if (!getFieldContainer().contains(helperLabel))
            getFieldContainer().appendChild(helperLabel);
        helperLabel.setTextContent(helperText);
        return (T) this;
    }

    @Override
    public String getHelperText() {
        return helperText;
    }

    @Override
    public T setName(String name) {
        getInputElement().setAttribute(NAME, name);
        return (T) this;
    }

    @Override
    public String getName() {
        return getInputElement().getAttribute(NAME);
    }

    @Override
    public T setLabel(String label) {
        getLabelElement().setTextContent(label);
        return (T) this;
    }

    @Override
    public String getLabel() {
        return getLabelElement().getTextContent();
    }

    @Override
    public T enable() {
        getInputElement().removeAttribute("disabled");
        return (T) this;
    }

    @Override
    public boolean isEnabled() {
        return !getInputElement().hasAttribute("disabled");
    }

    @Override
    public T disable() {
        getInputElement().setAttribute("disabled", "disabled");
        return (T) this;
    }

    @Override
    public ValidationResult validate() {
        return elementValidations.validate();
    }

    @Override
    public T removeValidator(Validator validator) {
        elementValidations.removeValidator(validator);
        return (T) this;
    }

    @Override
    public boolean hasValidator(Validator validator) {
        return elementValidations.hasValidator(validator);
    }

    @Override
    public T addValidator(Validator validator) {
        elementValidations.addValidator(validator);
        return (T) this;
    }

    @Override
    public T invalidate(String errorMessage) {
        invalidate(Collections.singletonList(errorMessage));
        return (T) this;
    }

    @Override
    public T invalidate(List<String> errorMessages) {
        helperLabel.toggleDisplay(errorMessages.isEmpty());
        removeErrors();

        errorMessages.forEach(message -> {
            HTMLLabelElement errorLabel = makeErrorLabel(message);
            errorLabels.add(errorLabel);
            getFieldContainer().appendChild(errorLabel);
        });

        return (T) this;
    }

    protected HTMLLabelElement makeErrorLabel(String message) {
        return Elements.label().css("error").textContent(message).asElement();
    }

    @Override
    public T clearInvalid() {
        helperLabel.show();
        removeErrors();
        return (T) this;
    }

    private void removeErrors() {
        errorLabels.forEach(Element::remove);
        errorLabels.clear();
    }

    @Override
    public T setRequired(boolean required) {
        if (required) {
            addValidator(requiredValidator);
        } else {
            removeValidator(requiredValidator);
        }
        return (T) this;
    }

    @Override
    public T setRequired(boolean required, String message) {
        setRequired(required);
        setRequiredErrorMessage(message);
        return (T) this;
    }

    @Override
    public boolean isRequired() {
        return hasValidator(requiredValidator);
    }

    @Override
    public T setRequiredErrorMessage(String requiredErrorMessage) {
        this.requiredErrorMessage = requiredErrorMessage;
        return (T) this;
    }

    @Override
    public String getRequiredErrorMessage() {
        return isNull(requiredErrorMessage) ? "* This field is required." : requiredErrorMessage;
    }

    @Override
    public T groupBy(FieldsGrouping fieldsGrouping) {
        fieldsGrouping.addFormElement(this);
        return (T) this;
    }

    @Override
    public void setValue(V value) {
        value(value);
    }

    protected abstract DominoElement<HTMLDivElement> getFieldContainer();

    protected abstract DominoElement<HTMLLabelElement> getLabelElement();


    @Override
    public void showErrors(List<EditorError> errors) {
        invalidate(errors.stream()
                .filter(e -> this.equals(e.getEditor()))
                .map(EditorError::getMessage)
                .collect(Collectors.toList()));

    }
}
