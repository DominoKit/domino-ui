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

/**
 * A component to group a set of {@link Radio} component as one field, only one Radio can be checked from the this radio group.
 * @param <T> The type of the RadioGroup value
 */
public class RadioGroup<T> extends AbstractValueBox<RadioGroup<T>, HTMLElement, T> {

    private List<Radio<? extends T>> radios = new ArrayList<>();
    private String name;
    private FlexLayout flexLayout;

    /**
     * Creates a new group with a name and empty label
     * @param name String
     */
    public RadioGroup(String name) {
        this(name, "");
    }

    /**
     * Creates a new group with a name and a label
     * @param name String
     * @param label String
     */
    public RadioGroup(String name, String label) {
        super("RadioGroup", label);
        init(this);
        css("radio-group");
        setLabel(label);
        setName(name);
        vertical();
    }

    /**
     *
     * Creates a new group with a name and empty label
     * @param name String
     * @param <T> type of the RadioGroup value
     * @return new RadioGroup instance
     */
    public static <T> RadioGroup<T> create(String name) {
        return new RadioGroup<>(name);
    }

    /**
     *
     * Creates a new group with a name and a label
     * @param name String
     * @param label String
     * @param <T> type of the RadioGroup value
     * @return new RadioGroup instance
     */
    public static <T> RadioGroup<T> create(String name, String label) {
        return new RadioGroup<>(name, label);
    }

    /**
     *
     * @param radio {@link Radio}
     * @return same RadioGroup instance
     */
    public RadioGroup<T> appendChild(Radio<? extends T> radio) {
        return appendChild(radio, (Node) null);
    }

    /**
     *
     * @param radio {@link Radio}
     * @param content {@link Node} to be appended to the Radio after it is appended to the RadioGroup
     * @return same RadioGroup instance
     */
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

    /**
     *
     * @param radio {@link Radio}
     * @param content {@link IsElement} to be appended to the Radio after it is appended to the RadioGroup
     * @return same RadioGroup instance
     */
    public RadioGroup<T> appendChild(Radio<? extends T> radio, IsElement<?> content) {
        return appendChild(radio, content.element());
    }

    private void onCheck(Radio<? extends T> selectedRadio) {
        for (ChangeHandler<? super T> changeHandler : changeHandlers) {
            changeHandler.onValueChanged(selectedRadio.getValue());
        }
    }

    /**
     * Aligns the radios in this group horizontally
     * @return same RadioGroup instance
     */
    public RadioGroup<T> horizontal() {
        flexLayout.setDirection(FlexDirection.LEFT_TO_RIGHT);
        removeCss("horizontal");
        css("horizontal");
        return this;
    }

    /**
     * Aligns the radios in this group vertically
     * @return same RadioGroup instance
     */
    public RadioGroup<T> vertical() {
        flexLayout.setDirection(FlexDirection.TOP_TO_BOTTOM);
        removeCss("horizontal");
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RadioGroup<T> invalidate(String errorMessage) {
        invalidate(Collections.singletonList(errorMessage));
        return this;
    }


    /**
     * {@inheritDoc}
     */
    protected HTMLLabelElement makeErrorLabel(String message) {
        return Elements.label().css("error").textContent(message).element();
    }

    /**
     *
     * @return List of {@link Radio} that belongs to this RadioGroup
     */
    public List<Radio<? extends T>> getRadios() {
        return radios;
    }

    /**
     *
     * @return boolean, true only if there is a checked radio in this RadioGroup
     */
    public boolean isSelected() {
        return getValue() != null;
    }

    /**
     *
     * @return T value of the first checked Radio in this RadioGroup
     */
    public T getValue() {
        return radios.stream().filter(Radio::isChecked).map(Radio::getValue).findFirst().orElse(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return !isSelected();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RadioGroup<T> clear() {
        radios.forEach(Radio::uncheck);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RadioGroup<T> groupBy(FieldsGrouping fieldsGrouping) {
        fieldsGrouping.addFormElement(this);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RadioGroup<T> ungroup(FieldsGrouping fieldsGrouping) {
        fieldsGrouping.removeFormElement(this);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RadioGroup<T> setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RadioGroup<T> enable() {
        radios.forEach(Radio::enable);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RadioGroup<T> disable() {
        radios.forEach(Radio::disable);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEnabled() {
        return radios.stream().allMatch(Radio::isEnabled);
    }

    /**
     * Sets the value from the specific Radio
     * @param value {@link Radio}
     */
    public void setValue(Radio<T> value) {
        Radio radioToSelect = radios.stream().filter(radio -> radio.getValue().equals(value))
                .findFirst().orElse(null);
        if (nonNull(radioToSelect)) {
            radioToSelect.check();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setValue(T value) {
        Radio radioToSelect = radios.stream().filter(radio -> radio.getValue().equals(value))
                .findFirst().orElse(null);
        if (nonNull(radioToSelect)) {
            radioToSelect.check();
        }
    }


    /**
     *
     * @return the checked {@link Radio}
     */
    @SuppressWarnings("unchecked")
    public Radio<T> getSelectedRadio() {
        return (Radio<T>) radios.stream()
                .filter(Radio::isChecked)
                .findFirst()
                .orElse(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected HTMLElement createInputElement(String type) {
        flexLayout = FlexLayout.create();
        return flexLayout.element();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected AutoValidator createAutoValidator(AutoValidate autoValidate) {
        return new RadioAutoValidator<>(this, autoValidate);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RadioGroup<T> condense() {
        removeCss("condensed");
        css("condensed");
        return this;
    }

    /**
     * {@inheritDoc}
     */
    public RadioGroup<T> spread() {
        removeCss("condensed");
        return this;
    }

    /**
     *
     * @param condensed boolean. if true delegate to {@link #condense()}, otherwise delegate to {@link #spread()}
     * @return same RadioGroup instance
     */
    public RadioGroup<T> setCondensed(boolean condensed) {
        if (condensed) {
            return condense();
        } else {
            return spread();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void clearValue() {

    }

    /**
     * {@inheritDoc}
     */
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
