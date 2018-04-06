package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;
import elemental2.dom.HTMLLabelElement;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.*;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.List;


public class CheckBox implements IsElement<HTMLElement>, HasValue<Boolean>,
        CanEnable<CheckBox>, CanDisable<CheckBox>, HasName<CheckBox>, Checkable<CheckBox> {

    private HTMLDivElement container = Elements.div().asElement();
    private HTMLInputElement inputElement = Elements.input("checkbox").asElement();
    private HTMLLabelElement labelElement = Elements.label().asElement();
    private List<CheckHandler> checkHandlers = new ArrayList<>();
    private Color color;

    public CheckBox(String title) {
        container.appendChild(inputElement);
        container.appendChild(labelElement);
        setTitle(title);
        container.addEventListener("click", evt -> {
            if (!isDisbaled()) {
                if (isChecked())
                    uncheck();
                else
                    check();
            }
        });
    }

    private void onCheck() {
        for (CheckHandler handler : checkHandlers)
            handler.onCheck(isChecked());
    }

    public static CheckBox create(String title) {
        return new CheckBox(title);
    }

    @Override
    public HTMLElement asElement() {
        return container;
    }

    @Override
    public CheckBox check() {
        inputElement.checked = true;
        onCheck();
        return this;
    }

    @Override
    public CheckBox uncheck() {
        inputElement.checked = false;
        onCheck();
        return this;
    }

    @Override
    public boolean isChecked() {
        return inputElement.checked;
    }

    public CheckBox setTitle(String title) {
        labelElement.textContent = title;
        return this;
    }

    @Override
    public CheckBox addCheckHandler(CheckHandler handler) {
        this.checkHandlers.add(handler);
        return this;
    }

    public CheckBox filledIn() {
        inputElement.classList.add("filled-in");
        return this;
    }

    public CheckBox filledOut() {
        inputElement.classList.remove("filled-in");
        return this;
    }

    @Override
    public CheckBox enable() {
        inputElement.disabled = false;
        return this;
    }

    @Override
    public CheckBox disable() {
        inputElement.disabled = true;
        return this;
    }

    public boolean isDisbaled() {
        return inputElement.disabled;
    }

    public CheckBox setColor(Color color) {
        if (this.color != null)
            inputElement.classList.remove("chk-" + this.color.getStyle());
        inputElement.classList.add("chk-" + color.getStyle());
        this.color = color;
        return this;
    }

    public HTMLInputElement getInputElement() {
        return inputElement;
    }

    public HTMLLabelElement getLabelElement() {
        return labelElement;
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
    public String getName() {
        return inputElement.name;
    }

    @Override
    public CheckBox setName(String name) {
        inputElement.name = name;
        return this;
    }
}
