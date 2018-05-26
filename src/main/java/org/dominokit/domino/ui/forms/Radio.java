package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLInputElement;
import elemental2.dom.HTMLLabelElement;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.*;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.List;

public class Radio implements IsElement<HTMLDivElement>, HasName<Radio>, HasValue<String>, HasLabel<Radio>,
        Switchable<Radio>, Checkable<Radio> {

    private HTMLDivElement container = Elements.div().css("form-group").asElement();
    private HTMLLabelElement labelElement = Elements.label().asElement();
    private HTMLInputElement inputElement = Elements.input("radio").asElement();
    private List<CheckHandler> checkHandlers = new ArrayList<>();
    private Color color;

    public Radio(String value, String label) {
        container.appendChild(inputElement);
        container.appendChild(labelElement);
        setLabel(label);
        setValue(value);
        container.addEventListener("click", evt -> {
            if (isEnabled() && !isChecked())
                check();
        });
        inputElement.addEventListener("change", evt -> onCheck());
    }

    public Radio(String value) {
        this(value, value);
    }

    public static Radio create(String value, String label) {
        return new Radio(value, label);
    }

    public static Radio create(String value) {
        return new Radio(value);
    }

    @Override
    public Radio check() {
        return check(false);
    }

    public Radio uncheck() {
        return uncheck(false);
    }

    @Override
    public Radio check(boolean silent) {
        inputElement.checked = true;
        if (!silent)
            onCheck();
        return this;
    }

    @Override
    public Radio uncheck(boolean silent) {
        inputElement.checked = false;
        if (!silent)
            onCheck();
        return this;
    }

    private void onCheck() {
        for (CheckHandler checkHandler : checkHandlers)
            checkHandler.onCheck(isChecked());
    }

    @Override
    public Radio addCheckHandler(Checkable.CheckHandler checkHandler) {
        checkHandlers.add(checkHandler);
        return this;
    }

    @Override
    public Radio removeCheckHandler(CheckHandler checkHandler) {
        if (checkHandler != null)
            checkHandlers.remove(checkHandler);
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

    public Radio setColor(Color color) {
        if (this.color != null)
            inputElement.classList.remove("radio-" + this.color.getStyle());
        inputElement.classList.add("radio-" + color.getStyle());
        this.color = color;
        return this;
    }

    @Override
    public HTMLDivElement asElement() {
        return container;
    }

    @Override
    public String getName() {
        return inputElement.name;
    }

    @Override
    public Radio setName(String name) {
        inputElement.name = name;
        return this;
    }

    @Override
    public void setValue(String value) {
        inputElement.value = value;
    }

    @Override
    public String getValue() {
        return inputElement.value;
    }

    @Override
    public Radio setLabel(String label) {
        labelElement.textContent = label;
        return this;
    }

    @Override
    public String getLabel() {
        return labelElement.textContent;
    }

    @Override
    public Radio enable() {
        inputElement.disabled = true;
        return this;
    }

    @Override
    public Radio disable() {
        inputElement.disabled = true;
        return this;
    }

    @Override
    public boolean isEnabled() {
        return !inputElement.disabled;
    }
}
