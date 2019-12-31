package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.forms.validations.MinLengthValidator;
import org.dominokit.domino.ui.utils.HasLength;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public abstract class AbstractValueBox<T extends AbstractValueBox<T, E, V>, E extends HTMLElement, V>
        extends ValueBox<T, E, V> implements HasLength<T> {

    private int maxLength;
    private int minLength;
    private String minLengthErrorMessage;
    private MinLengthValidator minLengthValidator = new MinLengthValidator(this);

    public AbstractValueBox(String type, String label) {
        super(type, label);
        addInputEvent();
    }

    private void addInputEvent() {
        getInputElement().addEventListener("input", evt -> updateCharacterCount());
    }

    @Override
    public T setMaxLength(int maxLength) {
        this.maxLength = maxLength;
        if (maxLength < 0) {
            getCountItem().hide();
            getInputElement().removeAttribute("maxlength");
        } else {
            getCountItem().show();
            getInputElement().setAttribute("maxlength", maxLength);
            updateCharacterCount();
        }
        return (T) this;
    }

    @Override
    public T value(V value) {
        super.value(value);
        updateCharacterCount();
        return (T) this;
    }

    protected void updateCharacterCount() {
        if (maxLength > 0 || minLength > 0) {
            getCountItem().show();
            String value = getStringValue();
            int length = 0;
            if (nonNull(value)) {
                length = value.length();
            }
            if (length < minLength) {
                length = minLength;
            }
            getCountItem().setTextContent(length + "/" + maxLength);
        }else{
            getCountItem().hide();
        }

    }

    @Override
    public int getMaxLength() {
        return this.maxLength;
    }

    @Override
    public T setMinLength(int minLength) {
        this.minLength = minLength;
        if (minLength < 0) {
            getCountItem().hide();
            getInputElement().removeAttribute("minlength");
            removeValidator(minLengthValidator);
        } else {
            getCountItem().show();
            getInputElement().setAttribute("minlength", minLength);
            updateCharacterCount();
            addValidator(minLengthValidator);
        }
        return (T) this;
    }

    @Override
    public int getMinLength() {
        return minLength;
    }

    @Override
    public T setReadOnly(boolean readOnly) {
        getCountItem()
                .toggleDisplay(!readOnly);
        return super.setReadOnly(readOnly);
    }

    @Override
    public boolean isEmpty() {
        String stringValue = getStringValue();
        return isNull(stringValue) || stringValue.isEmpty();
    }

    public T setMinLengthErrorMessage(String minLengthErrorMessage) {
        this.minLengthErrorMessage = minLengthErrorMessage;
        return (T) this;
    }

    public String getMinLengthErrorMessage() {
        return isNull(minLengthErrorMessage) ? "Minimum length is " + minLength : minLengthErrorMessage;
    }
}
