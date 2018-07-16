package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLLabelElement;
import org.dominokit.domino.ui.utils.Checkable;
import org.dominokit.domino.ui.utils.ElementValidations;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class RadioGroup implements IsElement<HTMLDivElement>, FormElement<RadioGroup, String> {

    private HTMLDivElement container = Elements.div().css("form-group").asElement();
    private HTMLLabelElement helperLabel = Elements.label().css("help-info").asElement();
    private HTMLLabelElement errorLabel = Elements.label().css("error").asElement();
    private HTMLDivElement labelContainer = Elements.div().css("form-label").asElement();
    private ElementValidations elementValidations = new ElementValidations(this);
    private List<Radio> radios = new ArrayList<>();
    private String name;
    private Checkable.CheckHandler autoValidationHandler;

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
    public RadioGroup setValue(String value) {
        Radio radioToSelect = radios.stream().filter(radio -> radio.getValue().equals(value))
                .findFirst().orElse(null);
        if (nonNull(radioToSelect)) {
            radioToSelect.check();
        }
        return this;
    }

    @Override
    public String getValue() {
        return radios.stream().filter(Radio::isChecked).map(Radio::getValue).findFirst().orElse(null);
    }

    @Override
    public boolean isEmpty() {
        return !isSelected();
    }

    @Override
    public RadioGroup clear() {
        radios.forEach(Radio::uncheck);
        return this;
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
        radios.forEach(Radio::enable);
        return this;
    }

    @Override
    public RadioGroup disable() {
        radios.forEach(Radio::disable);
        return this;
    }

    @Override
    public boolean isEnabled() {
        return radios.stream().allMatch(Radio::isEnabled);
    }

    @Override
    public RadioGroup setAutoValidation(boolean autoValidation) {
        if (autoValidation) {
            if (isNull(autoValidationHandler)) {
                autoValidationHandler = checked -> validate();
                radios.forEach(radio -> radio.addCheckHandler(autoValidationHandler));
            }
        } else {
            radios.forEach(radio -> radio.removeCheckHandler(autoValidationHandler));
            autoValidationHandler = null;
        }
        return this;
    }

    @Override
    public boolean isAutoValidation() {
        return nonNull(autoValidationHandler);
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

    @Override
    public RadioGroup setReadOnly(boolean readOnly) {
        return null;
    }

    @Override
    public boolean isReadOnly() {
        return false;
    }
}
