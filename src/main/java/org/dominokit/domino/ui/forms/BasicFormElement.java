package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.HasValue;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;

public abstract class BasicFormElement<T extends BasicFormElement> implements IsElement<HTMLDivElement>, HasValue<String> {
    protected HTMLDivElement formGroup = Elements.div().css("form-group").asElement();
    protected HTMLDivElement inputContainer = Elements.div().css("form-line").asElement();

    public BasicFormElement() {
        formGroup.appendChild(inputContainer);
        addFocusListeners();
    }

    private void addFocusListeners() {
        formGroup.addEventListener("focusin", evt -> focus());
        formGroup.addEventListener("focusout", evt -> unfocus());
    }

    public T unfocus() {
        inputContainer.classList.remove("focused");
        return (T) this;
    }

    public T focus() {
        inputContainer.classList.add("focused");
        return (T) this;
    }

    @Override
    public HTMLDivElement asElement() {
        return formGroup;
    }

    public T disable() {
        getInputElement().setAttribute("disabled", "disabled");
        inputContainer.classList.add("disabled");
        return (T) this;
    }

    public T enable() {
        getInputElement().removeAttribute("disabled");
        inputContainer.classList.remove("disabled");
        return (T) this;
    }

    public HTMLDivElement getInputContainer() {
        return inputContainer;
    }

    public abstract T setPlaceholder(String placeholder);

    protected abstract HTMLElement getInputElement();
}
