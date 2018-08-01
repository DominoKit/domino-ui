package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLabelElement;
import org.dominokit.domino.ui.utils.ElementValidations;
import org.dominokit.domino.ui.utils.ValidationResult;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;

public abstract class BasicFormElement<T extends BasicFormElement, V> implements FormElement<T, V>,
        IsElement<HTMLElement> {

    private static final String NAME = "name";
    private HTMLLabelElement helperLabel = Elements.label().css("help-info").asElement();
    private HTMLLabelElement errorLabel = Elements.label().css("error").asElement();
    private ElementValidations elementValidations = new ElementValidations(this);
    private String helperText;
    private boolean readOnly;

    @Override
    public T setHelperText(String helperText) {
        this.helperText = helperText;
        if (!getFieldContainer().contains(helperLabel))
            getFieldContainer().appendChild(helperLabel);
        helperLabel.textContent = helperText;
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
        getLabelElement().textContent = label;
        return (T) this;
    }

    @Override
    public String getLabel() {
        return getLabelElement().textContent;
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
        helperLabel.style.display = "none";
        if (!getFieldContainer().contains(errorLabel))
            getFieldContainer().appendChild(errorLabel);
        errorLabel.style.display = "block";
        errorLabel.textContent = errorMessage;
        return (T) this;
    }

    @Override
    public T clearInvalid() {
        helperLabel.style.display = "block";
        errorLabel.textContent = "";
        errorLabel.style.display = "none";
        return (T) this;
    }

    @Override
    public T setRequired(boolean required) {
        elementValidations.setRequired(required);
        return (T) this;
    }

    @Override
    public T setRequired(boolean required, String message) {
        elementValidations.setRequired(required, message);
        return (T) this;
    }

    @Override
    public boolean isRequired() {
        return elementValidations.isRequired();
    }

    @Override
    public T groupBy(FieldsGrouping fieldsGrouping) {
        fieldsGrouping.addFormElement(this);
        return (T) this;
    }

    protected abstract HTMLElement getFieldContainer();

    protected abstract HTMLElement getLabelElement();

    protected abstract HTMLElement getInputElement();
}
