package org.dominokit.domino.ui.forms;

import com.google.gwt.editor.client.adapters.TakesValueEditor;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLLabelElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.forms.validations.ElementValidations;
import org.dominokit.domino.ui.forms.validations.RequiredValidator;
import org.dominokit.domino.ui.forms.validations.ValidationResult;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasChangeHandlers;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.label;

public class RadioGroup extends BaseDominoElement<HTMLDivElement, RadioGroup> implements FormElement<RadioGroup, String>, HasChangeHandlers<RadioGroup, Radio> {

    private DominoElement<HTMLDivElement> container = DominoElement.of(div().css("form-group"));
    private DominoElement<HTMLDivElement> formLine = DominoElement.of(div().css("form-line"));
    private DominoElement<HTMLDivElement> formControl = DominoElement.of(div().css("form-control"));
    private DominoElement<HTMLLabelElement> helperLabel = DominoElement.of(label().css("help-info"));
    private DominoElement<HTMLLabelElement> errorLabel = DominoElement.of(label().css("error"));
    private DominoElement<HTMLDivElement> labelContainer = DominoElement.of(div().css("form-label focused"));
    private TakesValueEditor<String> editor;
    private ElementValidations elementValidations = new ElementValidations(this);
    private RequiredValidator requiredValidator = new RequiredValidator(this);
    private List<Radio> radios = new ArrayList<>();
    private String name;
    private ChangeHandler<Boolean> autoValidationHandler;
    private List<ChangeHandler<Radio>> changeHandlers = new ArrayList<>();
    private String requiredErrorMessage;

    public RadioGroup(String name) {
        formControl.style()
                .setProperty("border-bottom", "0px")
                .setHeight("auto");
        formControl.appendChild(labelContainer);
        formLine.appendChild(formControl);
        container.appendChild(formLine);
        setName(name);
        init(this);
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
        return appendChild(radio);
    }

    public RadioGroup appendChild(Radio radio) {
        radio.setName(name);
        radio.addChangeHandler(value -> onCheck(radio));
        radios.add(radio);
        formControl.appendChild(radio.asElement());
        return this;
    }

    /**
     * @deprecated use {@link #appendChild(Radio, Node)}
     */
    @Deprecated
    public RadioGroup addRadio(Radio radio, Node content) {
        return appendChild(radio, content);
    }

    public RadioGroup appendChild(Radio radio, Node content) {
        addRadio(radio);
        formControl.appendChild(content);
        return this;
    }

    /**
     * @deprecated use {@link #appendChild(Radio, Node)}
     */
    @Deprecated
    public RadioGroup addRadio(Radio radio, IsElement content) {
        return addRadio(radio, content.asElement());
    }

    public RadioGroup appendChild(Radio radio, IsElement content) {
        return appendChild(radio, content.asElement());
    }

    private void onCheck(Radio selectedRadio) {
        for (ChangeHandler<Radio> changeHandler : changeHandlers) {
            changeHandler.onValueChanged(selectedRadio);
        }
    }

    public RadioGroup horizontal() {
        for (Radio radio : radios)
            radio.style().add("horizontal-radio");
        return this;
    }

    public RadioGroup vertical() {
        for (Radio radio : radios)
            radio.style().remove("horizontal-radio");
        return this;
    }

    @Override
    public RadioGroup setHelperText(String text) {
        if (!formLine.contains(helperLabel))
            formLine.appendChild(helperLabel);
        helperLabel.setTextContent(text);
        return this;
    }

    @Override
    public String getHelperText() {
        return helperLabel.getTextContent();
    }

    @Override
    public RadioGroup setLabel(String label) {
        labelContainer.setTextContent(label);
        return this;
    }

    @Override
    public HTMLDivElement asElement() {
        return container.asElement();
    }

    @Override
    public String getLabel() {
        return labelContainer.asElement().textContent;
    }

    @Override
    public ValidationResult validate() {
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
        helperLabel.style().setDisplay("none");
        if (!formLine.contains(errorLabel))
            formLine.appendChild(errorLabel);
        errorLabel.style().setDisplay("block");
        errorLabel.setTextContent(errorMessage);
        return this;
    }

    @Override
    public RadioGroup clearInvalid() {
        helperLabel.style().setDisplay("block");
        errorLabel.style().setDisplay("none");
        errorLabel.setTextContent("");
        return this;
    }

    public List<Radio> getRadios() {
        return radios;
    }

    public boolean isSelected() {
        return getValue() != null;
    }

    @Override
    public RadioGroup value(String value) {
        setValue(value);
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
    public RadioGroup groupBy(FieldsGrouping fieldsGrouping) {
        fieldsGrouping.addFormElement(this);
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
                radios.forEach(radio -> radio.addChangeHandler(autoValidationHandler));
            }
        } else {
            radios.forEach(radio -> radio.addChangeHandler(autoValidationHandler));
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
        if (required) {
            addValidator(requiredValidator);
        } else {
            removeValidator(requiredValidator);
        }
        return this;
    }

    @Override
    public RadioGroup setRequired(boolean required, String message) {
        setRequired(required);
        setRequiredErrorMessage(message);
        return this;
    }

    @Override
    public boolean isRequired() {
        return hasValidator(requiredValidator);
    }

    @Override
    public RadioGroup setRequiredErrorMessage(String requiredErrorMessage) {
        this.requiredErrorMessage = requiredErrorMessage;
        return this;
    }

    @Override
    public String getRequiredErrorMessage() {
        return isNull(requiredErrorMessage) ? "* This field is required." : requiredErrorMessage;
    }

    @Override
    public RadioGroup addChangeHandler(ChangeHandler<Radio> changeHandler) {
        changeHandlers.add(changeHandler);
        return this;
    }

    @Override
    public RadioGroup removeChangeHandler(ChangeHandler<Radio> changeHandler) {
        if (nonNull(changeHandler))
            changeHandlers.remove(changeHandler);
        return this;
    }

    @Override
    public boolean hasChangeHandler(ChangeHandler<Radio> changeHandler) {
        return changeHandlers.contains(changeHandler);
    }

    @Override
    public TakesValueEditor<String> asEditor() {
        if (editor == null) {
            editor = TakesValueEditor.of(this);
        }
        return editor;
    }

    @Override
    public void setValue(String value) {
        Radio radioToSelect = radios.stream().filter(radio -> radio.getValue().equals(value))
                .findFirst().orElse(null);
        if (nonNull(radioToSelect)) {
            radioToSelect.check();
        }
    }

    public Radio getSelectedRadio() {
        return radios.stream().filter(Radio::isChecked).findFirst().orElse(null);
    }
}
