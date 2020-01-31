package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLabelElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.grid.flex.FlexDirection;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.jboss.elemento.Elements;
import org.jboss.elemento.IsElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Objects.nonNull;

public class RadioGroup<T> extends AbstractValueBox<RadioGroup<T>, HTMLElement, T> {

    private List<Radio<? extends T>> radios = new ArrayList<>();
    private String name;
    private FlexLayout flexLayout;

    public RadioGroup(String name) {
        this(name, "");
    }

    public RadioGroup(String name, String label) {
        super("RadioGroup", label);
        init(this);
        css("radio-group");
        setLabel(label);
        setName(name);
        vertical();
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
        return appendChild(radio, content.element());
    }

    private void onCheck(Radio<? extends T> selectedRadio) {
        for (ChangeHandler<? super T> changeHandler : changeHandlers) {
            changeHandler.onValueChanged(selectedRadio.getValue());
        }
    }

    public RadioGroup<T> horizontal() {
        flexLayout.setDirection(FlexDirection.LEFT_TO_RIGHT);
        removeCss("horizontal");
        css("horizontal");
        return this;
    }

    public RadioGroup<T> vertical() {
        flexLayout.setDirection(FlexDirection.TOP_TO_BOTTOM);
        removeCss("horizontal");
        return this;
    }

    @Override
    public RadioGroup<T> invalidate(String errorMessage) {
        invalidate(Collections.singletonList(errorMessage));
        return this;
    }

    protected HTMLLabelElement makeErrorLabel(String message) {
        return Elements.label().css("error").textContent(message).element();
    }

    public List<Radio<? extends T>> getRadios() {
        return radios;
    }

    public boolean isSelected() {
        return getValue() != null;
    }

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


    public void setValue(Radio<T> value) {
        Radio radioToSelect = radios.stream().filter(radio -> radio.getValue().equals(value))
                .findFirst().orElse(null);
        if (nonNull(radioToSelect)) {
            radioToSelect.check();
        }
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

    @Override
    protected HTMLElement createInputElement(String type) {
        flexLayout = FlexLayout.create();
        return flexLayout.element();
    }

    @Override
    protected AutoValidator createAutoValidator(AutoValidate autoValidate) {
        return new RadioAutoValidator<>(this, autoValidate);
    }

    public RadioGroup<T> condense() {
        removeCss("condensed");
        css("condensed");
        return this;
    }

    public RadioGroup<T> spread() {
        removeCss("condensed");
        return this;
    }

    public RadioGroup<T> setCondensed(boolean condensed) {
        if (condensed) {
            return condense();
        } else {
            return spread();
        }
    }

    @Override
    protected void clearValue() {

    }

    @Override
    protected void doSetValue(T value) {

    }

    private static class RadioAutoValidator<T> extends AutoValidator {

        private RadioGroup<T> radioGroup;
        private ChangeHandler<Boolean> changeHandler;

        public RadioAutoValidator(RadioGroup<T> radioGroup, AutoValidate autoValidate) {
            super(autoValidate);
            this.radioGroup = radioGroup;
        }

        @Override
        public void attach() {
            changeHandler = value -> autoValidate.apply();
            radioGroup.getRadios()
                    .forEach(radio -> radio.addChangeHandler(changeHandler));
        }

        @Override
        public void remove() {
            radioGroup.getRadios()
                    .forEach(radio -> radio.removeChangeHandler(changeHandler));
        }
    }
}
