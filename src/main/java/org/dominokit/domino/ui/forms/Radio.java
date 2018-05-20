package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;
import elemental2.dom.HTMLLabelElement;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.Checkable;
import org.jboss.gwt.elemento.core.Elements;

import java.util.ArrayList;
import java.util.List;

public class Radio extends BasicFormElement<Radio, Boolean> implements Checkable<Radio> {

    private HTMLDivElement container = Elements.div().css("form-group").asElement();
    private HTMLLabelElement labelElement = Elements.label().asElement();
    private List<CheckHandler> checkHandlers = new ArrayList<>();
    private Color color;
    private HTMLInputElement inputElement = Elements.input("radio").asElement();
    private CheckHandler validationHandler;

    public Radio(String label) {
        container.appendChild(inputElement);
        container.appendChild(labelElement);
        inputElement.addEventListener("change", evt -> onCheck());
        container.addEventListener("click", evt -> {
            if (isEnabled()) {
                if (isChecked())
                    uncheck();
                else
                    check();
            }
        });
        setLabel(label);
    }

    public static Radio create(String label) {
        return new Radio(label);
    }

    @Override
    public Radio check() {
        return check(false);
    }

    @Override
    public Radio uncheck() {
        return uncheck(false);
    }

    @Override
    public Radio check(boolean silent) {
        inputElement.checked = true;
        if (!silent) {
            onCheck();
            validate();
        }
        return this;
    }

    @Override
    public Radio uncheck(boolean silent) {
        inputElement.checked = false;
        if (!silent) {
            onCheck();
            validate();
        }
        return this;
    }

    private void onCheck() {
        for (CheckHandler checkHandler : checkHandlers)
            checkHandler.onCheck(isChecked());
    }

    @Override
    public Radio addCheckHandler(CheckHandler checkHandler) {
        checkHandlers.add(checkHandler);
        return this;
    }

    @Override
    public Radio removeCheckHandler(CheckHandler checkHandler) {
        if (checkHandler != null && checkHandlers.contains(checkHandler))
            checkHandlers.remove(checkHandlers);
        return this;
    }

    @Override
    public boolean isChecked() {
        return inputElement.checked;
    }

    public Radio withGap() {
        inputElement.classList.add("with-gap");
        return this;
    }

    public Radio withoutGap() {
        inputElement.classList.remove("with-gap");
        return this;
    }

    @Override
    public void setValue(Boolean value) {
        if (value != null && value)
            check();
        else
            uncheck();
    }

    @Override
    public Boolean getValue() {
        return isChecked();
    }

    @Override
    public boolean isEmpty() {
        return !isChecked();
    }

    @Override
    public Radio clear() {
        setValue(false);
        return this;
    }

    public Radio setColor(Color color) {
        if (this.color != null)
            inputElement.classList.remove("radio-" + this.color.getStyle());
        inputElement.classList.add("radio-" + color.getStyle());
        this.color = color;
        return this;
    }

    @Override
    protected HTMLElement getContainer() {
        return container;
    }

    @Override
    public HTMLInputElement getInputElement() {
        return inputElement;
    }

    @Override
    public HTMLLabelElement getLabelElement() {
        return labelElement;
    }
}
