package org.dominokit.domino.ui.forms.validations;

import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.forms.ValueBox;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.EventType;

/**
 * this class attach an {@link org.dominokit.domino.ui.forms.ValueBox.AutoValidate} to a component and bind the validation the {@link EventType#blur}
 * @param <E> the type of the HTMLElement
 */
public class InputAutoValidator<E extends HTMLElement> extends ValueBox.AutoValidator {

    private final DominoElement<E> inputElement;
    private EventListener eventListener;

    /**
     *
     * @param inputElement {@link DominoElement}
     * @param autoValidate {@link org.dominokit.domino.ui.forms.ValueBox.AutoValidate}
     */
    public InputAutoValidator(DominoElement<E> inputElement, ValueBox.AutoValidate autoValidate) {
        super(autoValidate);
        this.inputElement = inputElement;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void attach() {
        eventListener = evt -> autoValidate.apply();
        inputElement.addEventListener(EventType.blur, eventListener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove() {
        inputElement.removeEventListener(EventType.blur, eventListener);
    }
}
