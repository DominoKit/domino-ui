package org.dominokit.domino.ui.forms;

import com.google.gwt.editor.client.adapters.TakesValueEditor;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLabelElement;
import org.dominokit.domino.ui.utils.*;
import org.jboss.gwt.elemento.core.Elements;

public abstract class BasicFormElement<T extends BasicFormElement<T, V>, V> extends BaseDominoElement<HTMLElement, T> implements FormElement<T, V>, IsReadOnly<T> , HasInputElement{

    private static final String NAME = "name";
    private HTMLLabelElement helperLabel = Elements.label().css("help-info").asElement();
    private HTMLLabelElement errorLabel = Elements.label().css("error").asElement();
    private ElementValidations elementValidations = new ElementValidations(this);
    private String helperText;

    private TakesValueEditor<V> editor;

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

    @Override
    public void setValue(V value) {
        value(value);
    }

    protected abstract DominoElement<HTMLDivElement> getFieldContainer();

    protected abstract DominoElement<HTMLLabelElement> getLabelElement();

    @Override
    public TakesValueEditor<V> asEditor() {
        if (editor == null) {
            editor = TakesValueEditor.of(this);
        }
        return editor;
    }

}
