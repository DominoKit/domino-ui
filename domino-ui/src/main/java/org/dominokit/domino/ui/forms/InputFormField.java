package org.dominokit.domino.ui.forms;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;
import jsinterop.base.Js;
import org.dominokit.domino.ui.forms.validations.InputAutoValidator;
import org.dominokit.domino.ui.utils.Function;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.ElementUtil;

import java.util.Objects;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public abstract class InputFormField<T extends InputFormField<T, E, V>, E extends HTMLInputElement, V>
        extends AbstractFormElement<T, V> implements HasInputElement<T> {

    private DominoElement<HTMLInputElement> inputElement;

    public InputFormField() {
        inputElement = createInputElement(getType());
        wrapperElement.appendChild(inputElement);
        InputFieldInitializer.create((T) this)
                .init(this);
    }

    protected abstract DominoElement<HTMLInputElement> createInputElement(String type);

    @Override
    public DominoElement<HTMLInputElement> getInputElement() {
        return inputElement;
    }

    @Override
    public boolean isEmpty() {
        String stringValue = getStringValue();
        return isNull(stringValue) || stringValue.isEmpty();
    }

    @Override
    public boolean isEmptyIgnoreSpaces() {
        String stringValue = getStringValue();
        return isEmpty() || stringValue.trim().isEmpty();
    }

    @Override
    public T clear() {
        return clear(isClearListenersPaused() || isChangeListenersPaused());
    }

    @Override
    public T clear(boolean silent) {
        V oldValue = getValue();
        withValue(getDefaultValue(), silent);
        V newValue = getValue();
        if(!silent && !Objects.equals(oldValue, newValue)) {
            triggerClearListeners(oldValue);
        }
        autoValidate();
        return (T) this;
    }

    @Override
    public AutoValidator createAutoValidator(Function autoValidate) {
        return new InputAutoValidator(autoValidate);
    }

    @Override
    public T triggerChangeListeners(V oldValue, V newValue) {
        getChangeListeners()
                .forEach(changeListener -> changeListener.onValueChanged(oldValue, newValue));
        return (T) this;
    }

    @Override
    public T triggerClearListeners(V oldValue) {
        getClearListeners()
                .forEach(clearListener -> clearListener.onValueCleared(oldValue));
        return (T) this;
    }


    @Override
    public String getName() {
        return getInputElement().element().name;
    }

    @Override
    public T setName(String name) {
        getInputElement().element().name = name;
        return (T) this;
    }

    @Override
    public T withValue(V value) {
        return withValue(value, isChangeListenersPaused());
    }

    @Override
    public T withValue(V value, boolean silent) {
        V oldValue = getValue();
        if(!Objects.equals(value, oldValue)) {
            doSetValue(value);
            if (!silent) {
                triggerChangeListeners(oldValue, getValue());
            }
        }
        autoValidate();
        return (T) this;
    }

    protected abstract void doSetValue(V value);

    @Override
    public boolean isEnabled() {
        return !isDisabled();
    }

    @Override
    public boolean isDisabled() {
        return this.isDisabled() || getInputElement().isDisabled();
    }

    @Override
    public T enable() {
        getInputElement().enable();
        return super.enable();
    }

    @Override
    public T disable() {
        getInputElement().disable();
        return super.disable();
    }

    @Override
    public T setReadOnly(boolean readOnly) {
        getInputElement().setReadOnly(readOnly);
        return super.setReadOnly(readOnly);
    }

    @Override
    public boolean isReadOnly() {
        return super.isReadOnly() || getInputElement().isReadOnly();
    }

    @Override
    public void setValue(V value) {
        withValue(value);
    }

    @Override
    public T focus() {
        if (!isDisabled()) {
            if (!isAttached()) {
                ElementUtil.onAttach(
                        getInputElement(),
                        mutationRecord -> getInputElement().element().focus());
            } else {
                getInputElement().element().focus();
            }
        }
        return (T) this;
    }

    @Override
    public T unfocus() {
        if (!isAttached()) {
            ElementUtil.onAttach(
                    getInputElement(),
                    mutationRecord -> {
                        getInputElement().element().blur();
                    });
        } else {
            getInputElement().element().blur();
        }
        return (T) this;
    }

    @Override
    public boolean isFocused() {
        if (nonNull(DomGlobal.document.activeElement)) {
            String dominoId =
                    DominoElement.of(Js.<HTMLElement>uncheckedCast(DomGlobal.document.activeElement))
                            .getDominoId();
            return nonNull(formElement.querySelector("[domino-uuid=\"" + dominoId + "\"]"));
        }
        return false;
    }

}
