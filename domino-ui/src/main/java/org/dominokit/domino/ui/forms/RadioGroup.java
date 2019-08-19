package org.dominokit.domino.ui.forms;

import com.google.gwt.editor.client.EditorError;
import com.google.gwt.editor.client.adapters.TakesValueEditor;
import elemental2.dom.Element;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLLabelElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.forms.validations.ElementValidations;
import org.dominokit.domino.ui.forms.validations.RequiredValidator;
import org.dominokit.domino.ui.forms.validations.ValidationResult;
import org.dominokit.domino.ui.grid.flex.FlexDirection;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasChangeHandlers;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.label;

public class RadioGroup<T> extends BaseDominoElement<HTMLDivElement, RadioGroup<T>> implements FormElement<RadioGroup<T>, T>, HasChangeHandlers<RadioGroup<T>, Radio<T>> {

    private DominoElement<HTMLDivElement> container = DominoElement.of(div().css("form-group"));
    private DominoElement<HTMLDivElement> formLine = DominoElement.of(div().css("form-line"));
    private DominoElement<HTMLDivElement> formControl = DominoElement.of(div().css("form-control"));
    private DominoElement<HTMLLabelElement> helperLabel = DominoElement.of(label().css("help-info"));
    private List<HTMLLabelElement> errorLabels = new ArrayList<>();
    private DominoElement<HTMLDivElement> labelContainer = DominoElement.of(div().css("form-label focused"));
    private ElementValidations elementValidations = new ElementValidations(this);
    private RequiredValidator requiredValidator = new RequiredValidator(this);
    private List<Radio<? extends T>> radios = new ArrayList<>();
    private String name;
    private ChangeHandler<? super Boolean> autoValidationHandler;
    private List<ChangeHandler<? super Radio<T>>> changeHandlers = new ArrayList<>();
    private String requiredErrorMessage;
    private FlexLayout flexLayout = FlexLayout.create();

    public RadioGroup(String name) {
        formControl.style()
                .setProperty("border-bottom", "0px")
                .setHeight("auto");
        formControl.appendChild(labelContainer);
        formControl.appendChild(flexLayout);
        formLine.appendChild(formControl);
        container.appendChild(formLine);
        setName(name);
        init(this);
        vertical();
    }

    public RadioGroup(String name, String label) {
        this(name);
        setLabel(label);
    }

    public static <T> RadioGroup<T> create(String name) {
        return new RadioGroup<>(name);
    }

    public static <T> RadioGroup<T> create(String name, String label) {
        return new RadioGroup<>(name, label);
    }

    public RadioGroup<T> appendChild(Radio<? extends T> radio) {
        return appendChild(radio, (Node) null);
    }

    public RadioGroup<T> appendChild(Radio<? extends T> radio, Node content) {
        radio.setName(name);
        radio.addChangeHandler(value -> onCheck(radio));
        radio.setGroup(this);
        if (radio.isChecked()) {
            radios.forEach(r -> r.uncheck(true));
        }
        radios.add(radio);
        if (nonNull(content)) {
            radio.appendChild(content);
        }
        flexLayout.appendChild(radio);
        return this;
    }

    public RadioGroup<T> appendChild(Radio<? extends T> radio, IsElement content) {
        return appendChild(radio, content.asElement());
    }

    private void onCheck(Radio<? extends T> selectedRadio) {
        for (ChangeHandler<? super Radio<T>> changeHandler : changeHandlers) {
            changeHandler.onValueChanged((Radio<T>) selectedRadio);
        }
    }

    public RadioGroup<T> horizontal() {
        flexLayout.setDirection(FlexDirection.LEFT_TO_RIGHT);
        for (Radio radio : radios) {
            radio.addCss("horizontal-radio");
        }
        return this;
    }

    public RadioGroup<T> vertical() {
        flexLayout.setDirection(FlexDirection.TOP_TO_BOTTOM);
        for (Radio<? extends T> radio : radios) {
            radio.removeCss("horizontal-radio");
        }
        return this;
    }

    @Override
    public RadioGroup<T> setHelperText(String text) {
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
    public RadioGroup<T> setLabel(String label) {
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
    public RadioGroup<T> addValidator(Validator validator) {
        elementValidations.addValidator(validator);
        return this;
    }

    @Override
    public RadioGroup<T> removeValidator(Validator validator) {
        elementValidations.removeValidator(validator);
        return this;
    }

    @Override
    public boolean hasValidator(Validator validator) {
        return elementValidations.hasValidator(validator);
    }


    @Override
    public RadioGroup<T> invalidate(String errorMessage) {
        invalidate(Collections.singletonList(errorMessage));
        return this;
    }

    @Override
    public RadioGroup<T> invalidate(List<String> errorMessages) {
        helperLabel.toggleDisplay(errorMessages.isEmpty());
        removeErrors();

        errorMessages.forEach(message -> {
            HTMLLabelElement errorLabel = makeErrorLabel(message);
            errorLabels.add(errorLabel);
            formLine.appendChild(errorLabel);
        });

        return this;
    }

    protected HTMLLabelElement makeErrorLabel(String message) {
        return Elements.label().css("error").textContent(message).asElement();
    }

    @Override
    public RadioGroup<T> clearInvalid() {
        helperLabel.show();
        removeErrors();
        return this;
    }

    private void removeErrors() {
        errorLabels.forEach(Element::remove);
        errorLabels.clear();
    }

    public List<Radio<? extends T>> getRadios() {
        return radios;
    }

    public boolean isSelected() {
        return getValue() != null;
    }

    @Override
    public RadioGroup<T> value(T value) {
        setValue(value);
        return this;
    }

    @Override
    public T getValue() {
        return radios.stream().filter(Radio::isChecked).map(Radio::getValue).findFirst().orElse(null);
    }

    @Override
    public boolean isEmpty() {
        return !isSelected();
    }

    @Override
    public RadioGroup<T> clear() {
        radios.forEach(Radio::uncheck);
        return this;
    }

    @Override
    public RadioGroup<T> groupBy(FieldsGrouping fieldsGrouping) {
        fieldsGrouping.addFormElement(this);
        return this;
    }

    @Override
    public RadioGroup<T> ungroup(FieldsGrouping fieldsGrouping) {
        fieldsGrouping.removeFormElement(this);
        return this;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public RadioGroup<T> setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public RadioGroup<T> enable() {
        radios.forEach(Radio::enable);
        return this;
    }

    @Override
    public RadioGroup<T> disable() {
        radios.forEach(Radio::disable);
        return this;
    }

    @Override
    public boolean isEnabled() {
        return radios.stream().allMatch(Radio::isEnabled);
    }

    @Override
    public RadioGroup<T> setAutoValidation(boolean autoValidation) {
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
    public RadioGroup<T> setRequired(boolean required) {
        if (required) {
            addValidator(requiredValidator);
        } else {
            removeValidator(requiredValidator);
        }
        return this;
    }

    @Override
    public RadioGroup<T> setRequired(boolean required, String message) {
        setRequired(required);
        setRequiredErrorMessage(message);
        return this;
    }

    @Override
    public boolean isRequired() {
        return hasValidator(requiredValidator);
    }

    @Override
    public RadioGroup<T> setRequiredErrorMessage(String requiredErrorMessage) {
        this.requiredErrorMessage = requiredErrorMessage;
        return this;
    }

    @Override
    public String getRequiredErrorMessage() {
        return isNull(requiredErrorMessage) ? "* This field is required." : requiredErrorMessage;
    }

    @Override
    public RadioGroup<T> addChangeHandler(ChangeHandler<? super Radio<T>> changeHandler) {
        changeHandlers.add(changeHandler);
        return this;
    }

    @Override
    public RadioGroup<T> removeChangeHandler(ChangeHandler<? super Radio<T>> changeHandler) {
        if (nonNull(changeHandler))
            changeHandlers.remove(changeHandler);
        return this;
    }

    @Override
    public boolean hasChangeHandler(ChangeHandler<? super Radio<T>> changeHandler) {
        return changeHandlers.contains(changeHandler);
    }

    @Override
    public RadioGroup<T> setReadOnly(boolean readonly) {
        if (readonly) {
            formControl.style().add("readonly");
        } else {
            formControl.style().remove("readonly");
        }
        return super.setReadOnly(readonly);
    }

    @Override
    public void showErrors(List<EditorError> errors) {
        invalidate(errors.stream()
                .filter(e -> this.equals(e.getEditor()))
                .map(EditorError::getMessage)
                .collect(Collectors.toList()));
    }

    @Override
    public void setValue(T value) {
        Radio radioToSelect = radios.stream().filter(radio -> radio.getValue().equals(value))
                .findFirst().orElse(null);
        if (nonNull(radioToSelect)) {
            radioToSelect.check();
        }
    }

    public Radio<T> getSelectedRadio() {
        return (Radio<T>) radios.stream()
                .filter(Radio::isChecked)
                .findFirst()
                .orElse(null);
    }
}
