package org.dominokit.domino.ui.forms;

import org.gwtproject.editor.client.EditorError;
import elemental2.dom.*;
import org.dominokit.domino.ui.forms.validations.ElementValidations;
import org.dominokit.domino.ui.forms.validations.RequiredValidator;
import org.dominokit.domino.ui.forms.validations.ValidationResult;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.IsReadOnly;
import org.gwtproject.safehtml.shared.SafeHtml;
import org.jboss.elemento.IsElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static org.jboss.elemento.Elements.label;

public abstract class BasicFormElement<T extends BasicFormElement<T, V>, V> extends BaseDominoElement<HTMLElement, T> implements FormElement<T, V>, IsReadOnly<T>, HasInputElement {

    private static final String NAME = "name";
    private ElementValidations elementValidations = new ElementValidations(this);
    private RequiredValidator requiredValidator = new RequiredValidator(this);
    private String helperText;

    private String requiredErrorMessage;
    private List<HTMLElement> errorLabels = new ArrayList<>();

    @Override
    public T setHelperText(String helperText) {
        this.helperText = helperText;
        getHelperContainer().setTextContent(helperText);
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
        updateLabel(label);
        return (T) this;
    }

    protected void updateLabel(String label){
        getLabelTextElement().setTextContent(label);
    }

    public T setLabel(Node node) {
        getLabelTextElement()
                .clearElement()
                .appendChild(node);
        return (T) this;
    }

    public T setLabel(SafeHtml safeHtml) {
        getLabelTextElement()
                .setInnerHtml(safeHtml.asString());
        return (T) this;
    }

    public T setLabel(IsElement<?> element) {
        return setLabel(element.element());
    }

    @Override
    public String getLabel() {
        return getLabelTextElement().getTextContent();
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
        getHelperContainer().toggleDisplay(errorMessages.isEmpty());
        removeErrors();
        getErrorsContainer().toggleDisplay(!errorMessages.isEmpty());

        if (!errorMessages.isEmpty()) {
            css("error");
        } else {
            removeCss("error");
        }

        errorMessages.forEach(message -> {
            HTMLLabelElement errorLabel = makeErrorLabel(message);
            errorLabels.add(errorLabel);
            getErrorsContainer().appendChild(errorLabel);
        });

        return (T) this;
    }

    protected HTMLLabelElement makeErrorLabel(String message) {
        return label().css("error").textContent(message).element();
    }

    @Override
    public T clearInvalid() {
        getHelperContainer().show();
        removeErrors();
        getErrorsContainer().hide();
        return (T) this;
    }

    private void removeErrors() {
        errorLabels.clear();
        getErrorsContainer().clearElement();
        removeCss("error");
    }

    public List<HTMLElement> getErrorLabels() {
        return errorLabels;
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
    public T ungroup(FieldsGrouping fieldsGrouping) {
        fieldsGrouping.removeFormElement(this);
        return (T) this;
    }

    @Override
    public void setValue(V value) {
        value(value);
    }

    protected abstract DominoElement<HTMLDivElement> getFieldContainer();

    protected abstract DominoElement<HTMLElement> getHelperContainer();

    protected abstract DominoElement<HTMLElement> getErrorsContainer();

    protected abstract DominoElement<HTMLLabelElement> getLabelElement();

    public DominoElement<HTMLElement> getLabelTextElement() {
        return DominoElement.of(getLabelElement().element());
    }

    @Override
    public void showErrors(List<EditorError> errors) {
        List<String> editorErrors = errors.stream()
                .filter(e -> this.equals(e.getEditor()))
                .map(EditorError::getMessage)
                .collect(Collectors.toList());

        if (editorErrors.isEmpty()) {
            clearInvalid();
        } else {
            invalidate(editorErrors);
        }
    }

}
