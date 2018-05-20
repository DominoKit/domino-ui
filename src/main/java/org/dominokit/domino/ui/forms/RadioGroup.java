package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLabelElement;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.Checkable;
import org.dominokit.domino.ui.utils.ElementValidations;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

public class RadioGroup implements IsElement<HTMLDivElement>, FormElement<RadioGroup, Radio> {

    private HTMLDivElement container = Elements.div().css("form-group").asElement();
    private HTMLLabelElement helperLabel = Elements.label().css("help-info").asElement();
    private HTMLLabelElement errorLabel = Elements.label().css("error").asElement();
    private HTMLDivElement labelContainer = Elements.div().css("form-label").asElement();
    private ElementValidations elementValidations = new ElementValidations(this);
    private List<Radio> radios = new ArrayList<>();
    private String name;
    private Checkable.CheckHandler checkHandler;

    public RadioGroup(String name) {
        container.appendChild(labelContainer);
        setName(name);
    }

    public RadioGroup(String name, String label) {
        this(name);
        setLabel(label);
    }

    public static RadioGroup create(String name) {
        return new RadioGroup(name);
    }

    public static RadioGroup create(String name, String label) {
        return new RadioGroup(name, label);
    }

    public RadioGroup addRadio(Radio radio) {
        radio.setName(name);
        radios.add(radio);
        asElement().appendChild(radio.asElement());
        return this;
    }

    public RadioGroup horizontal() {
        for (Radio radio : radios)
            radio.asElement().classList.add("horizontal-radio");
        return this;
    }

    public RadioGroup vertical() {
        for (Radio radio : radios)
            radio.asElement().classList.remove("horizontal-radio");
        return this;
    }

    @Override
    public RadioGroup setHelperText(String text) {
        if (!container.contains(helperLabel))
            container.appendChild(helperLabel);
        helperLabel.textContent = text;
        return this;
    }

    @Override
    public String getHelperText() {
        return helperLabel.textContent;
    }

    @Override
    public RadioGroup setLabel(String label) {
        labelContainer.textContent = label;
        return this;
    }

    @Override
    public HTMLDivElement asElement() {
        return container;
    }

    @Override
    public String getLabel() {
        return labelContainer.textContent;
    }

    @Override
    public boolean validate() {
        return elementValidations.validate();
    }

    @Override
    public RadioGroup addValidator(Validator validator) {
        elementValidations.addValidator(validator);
        return this;
    }

    @Override
    public RadioGroup removeValidator(Validator validator) {
        elementValidations.removeValidator(validator);
        return this;
    }

    @Override
    public boolean hasValidator(Validator validator) {
        return elementValidations.hasValidator(validator);
    }

    @Override
    public RadioGroup invalidate(String errorMessage) {
        helperLabel.style.display = "none";
        if (!container.contains(errorLabel))
            container.appendChild(errorLabel);
        errorLabel.style.display = "block";
        errorLabel.textContent = errorMessage;
        return this;
    }

    @Override
    public RadioGroup clearInvalid() {
        helperLabel.style.display = "block";
        errorLabel.textContent = "";
        errorLabel.style.display = "none";
        return this;
    }

    public List<Radio> getRadios() {
        return radios;
    }

    public boolean isSelected() {
        return getValue() != null;
    }

    @Override
    public void setValue(Radio value) {
        if (radios.contains(value))
            value.check();
    }

    @Override
    public Radio getValue() {
        return radios.stream().filter(Radio::isChecked).findFirst().orElse(null);
    }

    @Override
    public boolean isEmpty() {
        return !isSelected();
    }

    @Override
    public RadioGroup clear() {
        radios.forEach(Radio::clear);
        return this;
    }

    public HTMLElement getLabelElement() {
        return labelContainer;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public RadioGroup setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public RadioGroup enable() {
        radios.forEach(BasicFormElement::enable);
        return this;
    }

    @Override
    public RadioGroup disable() {
        radios.forEach(BasicFormElement::disable);
        return this;
    }

    @Override
    public boolean isEnabled() {
        return radios.stream().allMatch(BasicFormElement::isEnabled);
    }

    @Override
    public RadioGroup setAutoValidation(boolean autoValidation) {
        if (autoValidation) {
            if (isNull(checkHandler)) {
                checkHandler = checked -> validate();
                radios.forEach(radio -> radio.addCheckHandler(checkHandler));
            }
        } else {
            radios.forEach(radio -> radio.removeCheckHandler(checkHandler));
        }
        return this;
    }

    @Override
    public RadioGroup setRequired(boolean required) {
        elementValidations.setRequired(required);
        return this;
    }

    @Override
    public RadioGroup setRequired(boolean required, String message) {
        elementValidations.setRequired(required, message);
        return this;
    }

    @Override
    public boolean isRequired() {
        return elementValidations.isRequired();
    }
}
