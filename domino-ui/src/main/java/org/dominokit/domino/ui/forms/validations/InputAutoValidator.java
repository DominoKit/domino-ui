package org.dominokit.domino.ui.forms.validations;

import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.forms.ValueBox;
import org.dominokit.domino.ui.utils.DominoElement;

public class InputAutoValidator<E extends HTMLElement> extends ValueBox.AutoValidator {

    private final DominoElement<E> inputElement;
    private EventListener eventListener;

    public InputAutoValidator(DominoElement<E> inputElement, ValueBox.AutoValidate autoValidate) {
        super(autoValidate);
        this.inputElement = inputElement;
    }

    @Override
    public void attach() {
        eventListener = evt -> autoValidate.apply();
        inputElement.addEventListener("input", eventListener);
    }

    @Override
    public void remove() {
        inputElement.removeEventListener("input", eventListener);
    }
}
