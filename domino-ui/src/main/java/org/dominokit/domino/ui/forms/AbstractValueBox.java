package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.forms.validations.MinLengthValidator;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasLength;
import org.jboss.gwt.elemento.core.Elements;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public abstract class AbstractValueBox<T extends AbstractValueBox<T, E, V>, E extends HTMLElement, V>
        extends ValueBox<T, E, V> implements HasLength<T> {

    private HTMLDivElement characterCountContainer = Elements.div().css("help-info pull-right").asElement();
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
        if (maxLength < 0 && getFieldContainer().contains(characterCountContainer)) {
            getFieldContainer().removeChild(characterCountContainer);
            getInputElement().removeAttribute("maxlength");
        } else {
            getFieldContainer().appendChild(characterCountContainer);
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
        int length = getStringValue().length();
        if (length < minLength) {
            length = minLength;
        }
        characterCountContainer.textContent = length + "/" + maxLength;

    }

    @Override
    public int getMaxLength() {
        return this.maxLength;
    }

    @Override
    public T setMinLength(int minLength) {
        this.minLength = minLength;
        if (minLength < 0 && getFieldContainer().contains(characterCountContainer)) {
            getFieldContainer().removeChild(characterCountContainer);
            getInputElement().removeAttribute("minlength");
            removeValidator(minLengthValidator);
        } else {
            getFieldContainer().appendChild(characterCountContainer);
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
        if(nonNull(characterCountContainer)){
            DominoElement.of(characterCountContainer)
                    .toggleDisplay(!readOnly);
        }
        return super.setReadOnly(readOnly);
    }

    @Override
    public boolean isEmpty() {
        return getStringValue().isEmpty();
    }

    public T setMinLengthErrorMessage(String minLengthErrorMessage) {
        this.minLengthErrorMessage = minLengthErrorMessage;
        return (T) this;
    }

    public String getMinLengthErrorMessage() {
        return isNull(minLengthErrorMessage) ? "Minimum length is " + minLength : minLengthErrorMessage;
    }

    public HTMLDivElement getCharacterCountContainer() {
        return characterCountContainer;
    }
}
