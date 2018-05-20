package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;
import elemental2.dom.HTMLLabelElement;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.Checkable;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.List;


public class CheckBox extends BasicFormElement<CheckBox, Boolean> implements IsElement<HTMLElement>, Checkable<CheckBox> {

    private HTMLDivElement container = Elements.div().css("form-group").asElement();
    private HTMLInputElement inputElement = Elements.input("checkbox").asElement();
    private HTMLLabelElement labelElement = Elements.label().asElement();
    private List<CheckHandler> checkHandlers = new ArrayList<>();
    private Color color;

    public CheckBox() {
        this("");
    }

    public CheckBox(String label) {
        setLabel(label);
        container.appendChild(inputElement);
        container.appendChild(labelElement);
        inputElement.addEventListener("change", evt -> onCheck());
        labelElement.addEventListener("click", evt -> {
            if (isEnabled())
                inputElement.click();
        });
    }

    private void onCheck() {
        for (CheckHandler handler : checkHandlers)
            handler.onCheck(isChecked());
    }

    public static CheckBox create(String label) {
        return new CheckBox(label);
    }

    public static CheckBox create() {
        return new CheckBox();
    }

    @Override
    public CheckBox check() {
        return check(false);
    }

    @Override
    public CheckBox uncheck() {
        return uncheck(false);
    }

    @Override
    public CheckBox check(boolean silent) {
        inputElement.checked = true;
        if (!silent) {
            onCheck();
            validate();
        }
        return this;
    }

    @Override
    public CheckBox uncheck(boolean silent) {
        inputElement.checked = false;
        if (!silent) {
            onCheck();
            validate();
        }
        return this;
    }

    @Override
    public boolean isChecked() {
        return inputElement.checked;
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

    public CheckBox setColor(Color color) {
        if (this.color != null)
            inputElement.classList.remove("chk-" + this.color.getStyle());
        inputElement.classList.add("chk-" + color.getStyle());
        this.color = color;
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
    public CheckBox clear() {
        setValue(false);
        return this;
    }

    public CheckBox removeCheckHandler(CheckHandler checkHandler) {
        if (checkHandler != null)
            checkHandlers.remove(checkHandler);
        return this;
    }

    @Override
    public HTMLInputElement getInputElement() {
        return inputElement;
    }

    @Override
    protected HTMLDivElement getContainer() {
        return container;
    }

    @Override
    public HTMLLabelElement getLabelElement() {
        return labelElement;
    }
}
