package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLInputElement;
import elemental2.dom.HTMLLabelElement;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.CanDisable;
import org.dominokit.domino.ui.utils.CanEnable;
import org.dominokit.domino.ui.utils.HasName;
import org.dominokit.domino.ui.utils.HasValue;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.List;

public class Radio implements IsElement<HTMLDivElement>, HasValue<Boolean>,
        CanDisable<Radio>, CanEnable<Radio>, HasName<Radio> {

    private HTMLDivElement container = Elements.div().asElement();
    private HTMLInputElement inputElement = Elements.input("radio").asElement();
    private HTMLLabelElement labelElement = Elements.label().asElement();
    private List<CheckHandler> checkHandlers = new ArrayList<>();
    private Color color;

    public Radio(String title) {
        container.appendChild(inputElement);
        container.appendChild(labelElement);
        container.addEventListener("click", evt -> {
            if (!isDisabled()) {
                if (!isChecked())
                    check();
            }
        });
        setTitle(title);
    }

    public static Radio create(String title) {
        return new Radio(title);
    }

    public Radio setTitle(String title) {
        labelElement.textContent = title;
        return this;
    }

    @Override
    public HTMLDivElement asElement() {
        return container;
    }

    public Radio check() {
        inputElement.checked = true;
        onCheck();
        return this;
    }

    public Radio uncheck() {
        inputElement.checked = false;
        onCheck();
        return this;
    }

    private void onCheck() {
        for (CheckHandler checkHandler : checkHandlers)
            checkHandler.onChecked(isChecked());
    }

    public Radio addCheckHandler(CheckHandler checkHandler) {
        checkHandlers.add(checkHandler);
        return this;
    }

    public boolean isChecked() {
        return inputElement.checked;
    }

    public HTMLInputElement getInputElement() {
        return inputElement;
    }

    public HTMLLabelElement getLabelElement() {
        return labelElement;
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
    public Radio disable() {
        inputElement.disabled = true;
        return this;
    }

    @Override
    public Radio enable() {
        inputElement.disabled = false;
        return this;
    }

    public boolean isDisabled() {
        return inputElement.disabled;
    }

    public Radio setColor(Color color) {
        if (this.color != null)
            inputElement.classList.remove("radio-" + this.color.getStyle());
        inputElement.classList.add("radio-" + color.getStyle());
        this.color = color;
        return this;
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

    @FunctionalInterface
    public interface CheckHandler {
        void onChecked(boolean checked);
    }
}
