package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLabelElement;
import org.jboss.gwt.elemento.core.Elements;

public abstract class ValueBox<T extends ValueBox, E extends HTMLElement, V> extends TextFormElement<T, V>{
    private static final String TEXT = "text";

    protected E inputElement;
    protected ValueBoxSize size;
    protected boolean floating;
    protected HTMLLabelElement label;

    public enum ValueBoxSize {
        LARGE("form-group-lg"),
        SMALL("form-group-sm"),
        DEFAULT("form-group");

        private String style;

        ValueBoxSize(String style) {
            this.style = style;
        }

    }

    public ValueBox() {
        this(TEXT, "");
    }

    public ValueBox(String placeholder) {
        this(TEXT, placeholder);
    }

    public ValueBox(String type, String placeholder) {
        inputElement=createElement(type, placeholder);
        inputContainer.appendChild(inputElement);
    }

    protected abstract E createElement(String type, String placeholder);

    @Override
    public E getInputElement() {
        return inputElement;
    }



    public T large() {
        return setSize(ValueBoxSize.LARGE);
    }

    public T small() {
        return setSize(ValueBoxSize.SMALL);
    }

    public T setSize(ValueBoxSize size) {
        if (this.size != null)
            formGroup.classList.remove(size.style);
        formGroup.classList.add(size.style);
        this.size = size;
        return (T) this;
    }

    public T floating() {
        if (!floating) {
            label = Elements.label().css("form-label").textContent(getPlaceholder()).asElement();
            label.addEventListener("click", evt -> {
                focus();
                inputElement.focus();
            });
            inputContainer.appendChild(label);
            inputElement.removeAttribute("placeholder");
            formGroup.classList.add("form-float");
        }
        this.floating = true;
        return (T) this;
    }

    public T nonfloating() {
        if (floating) {
            setPlaceholder(label.textContent);
            inputContainer.removeChild(label);
            formGroup.classList.remove("form-float");
        }
        floating = false;
        return (T) this;
    }

    public abstract boolean isEmpty();

    @Override
    public T unfocus() {
        if (!floating || isEmpty())
            super.unfocus();
        return (T) this;
    }

}
