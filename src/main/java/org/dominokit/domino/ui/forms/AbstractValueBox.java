package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.HasLength;
import org.jboss.gwt.elemento.core.Elements;

public abstract class AbstractValueBox<T extends AbstractValueBox<T, E, V>, E extends HTMLElement, V>
        extends ValueBox<T, E, V> implements HasLength<T> {

    private HTMLDivElement characterCountContainer = Elements.div().css("help-info pull-right").asElement();
    private int length;

    public AbstractValueBox(String type, String label) {
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

    @Override
    public void setValue(V value) {
        super.setValue(value);
        updateCharacterCount();
    }

    protected void updateCharacterCount() {
        characterCountContainer.textContent = getStringValue().length() + "/" + length;
    }

    @Override
    public int getLength() {
        return this.length;
    }

    @Override
    public boolean isEmpty() {
        return getStringValue().isEmpty();
    }

}
