package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.*;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;

abstract class TextFormElement<T extends TextFormElement, V> implements IsElement<HTMLDivElement>,
        HasName<T>, Focusable<T>, CanEnable<T>, CanDisable<T>, HasPlaceHolder<T>, HasValue<V> {
    protected HTMLDivElement formGroup = Elements.div().css("form-group").asElement();
    protected HTMLDivElement inputContainer = Elements.div().css("form-line").asElement();

    public TextFormElement() {
        formGroup.appendChild(inputContainer);
        addFocusListeners();
    }

    private void addFocusListeners() {
        formGroup.addEventListener("focusin", evt -> focus());
        formGroup.addEventListener("focusout", evt -> unfocus());
    }

    @Override
    public HTMLDivElement asElement() {
        return formGroup;
    }

    @Override
    public T disable() {
        getInputElement().setAttribute("disabled", "disabled");
        inputContainer.classList.add("disabled");
        return (T) this;
    }

    @Override
    public T enable() {
        getInputElement().removeAttribute("disabled");
        inputContainer.classList.remove("disabled");
        return (T) this;
    }

    @Override
    public String getName() {
        return getInputElement().getAttribute("name");
    }

    @Override
    public T setName(String name) {
        getInputElement().setAttribute("name", name);
        return (T) this;
    }

    @Override
    public T focus() {
        inputContainer.classList.add("focused");
        return (T) this;
    }

    @Override
    public T unfocus() {
        inputContainer.classList.remove("focused");
        return (T) this;
    }

    protected HTMLDivElement getInputContainer() {
        return inputContainer;
    }

    protected abstract HTMLElement getInputElement();
}
