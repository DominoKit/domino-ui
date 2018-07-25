package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.HasLength;
import org.jboss.gwt.elemento.core.Elements;

public abstract class AbstractTextBox<T extends AbstractTextBox, E extends HTMLElement>
        extends ValueBox<T, E, String> implements HasLength<T> {

    private HTMLDivElement characterCountContainer = Elements.div().css("help-info pull-right").asElement();
    private int length;

    public AbstractTextBox(String type, String label) {
        super(type, label);
        addInputEvent();
    }

    private void addInputEvent() {
        getInputElement().addEventListener("input", evt -> updateCharacterCount());
    }

    @Override
    public T setLength(int length) {
        this.length = length;
        if (length < 0 && getFieldContainer().contains(characterCountContainer)) {
            getFieldContainer().removeChild(characterCountContainer);
            getInputElement().removeAttribute("maxlength");
        } else {
            getFieldContainer().appendChild(characterCountContainer);
            getInputElement().setAttribute("maxlength", length);
            updateCharacterCount();
        }
        return (T) this;
    }

    private void updateCharacterCount() {
        characterCountContainer.textContent = getValue().length() + "/" + length;
    }

    @Override
    public int getLength() {
        return this.length;
    }

    @Override
    public boolean isEmpty() {
        return getValue().isEmpty();
    }
}
