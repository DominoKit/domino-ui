package org.dominokit.domino.ui.forms;

import elemental2.dom.*;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.Checkable;
import org.jboss.gwt.elemento.core.Elements;

import java.util.ArrayList;
import java.util.List;

public class SwitchButton extends BasicFormElement<SwitchButton, Boolean> implements Checkable<SwitchButton> {

    private HTMLDivElement container = Elements.div().css("switch form-group").asElement();
    private HTMLLabelElement labelElement = Elements.label().asElement();
    private HTMLInputElement inputElement = Elements.input("checkbox").asElement();
    private HTMLElement lever = Elements.span().css("lever").asElement();
    private List<CheckHandler> checkHandlers = new ArrayList<>();
    private Color color;
    private String label;
    private Text labelText;
    private CheckHandler validationHandler;

    public SwitchButton(String title, String onTitle) {
        this(title);
        labelElement.appendChild(new Text(onTitle));
    }

    public SwitchButton(String title) {
        this();
        setLabel(title);
    }

    public SwitchButton() {
        labelElement.appendChild(inputElement);
        labelElement.appendChild(lever);
        container.appendChild(labelElement);
        inputElement.addEventListener("change", evt -> onCheck());
    }

    public static SwitchButton create(String offTitle, String onTitle) {
        return new SwitchButton(offTitle, onTitle);
    }

    public static SwitchButton create(String label) {
        return new SwitchButton(label);
    }

    public static SwitchButton create() {
        return new SwitchButton();
    }

    private void onCheck() {
        for (CheckHandler checkHandler : checkHandlers)
            checkHandler.onCheck(isChecked());
    }

    public HTMLElement getLever() {
        return lever;
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
        return inputElement.checked;
    }

    @Override
    public boolean isEmpty() {
        return !isChecked();
    }

    @Override
    public SwitchButton clear() {
        setValue(false);
        return this;
    }

    @Override
    public SwitchButton check() {
        return check(false);
    }

    @Override
    public SwitchButton uncheck() {
        return uncheck(false);
    }

    @Override
    public SwitchButton check(boolean silent) {
        inputElement.checked = true;
        if (!silent) {
            onCheck();
            validate();
        }
        return this;
    }

    @Override
    public SwitchButton uncheck(boolean silent) {
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
    public SwitchButton addCheckHandler(CheckHandler checkHandler) {
        checkHandlers.add(checkHandler);
        return this;
    }

    public SwitchButton setColor(Color color) {
        if (this.color != null)
            lever.classList.remove("switch-" + this.color.getStyle());
        lever.classList.add("switch-" + color.getStyle());
        this.color = color;
        return this;

    }

    @Override
    public SwitchButton setLabel(String label) {
        this.label = label;
        if (labelText != null) {
            labelElement.removeChild(labelText);
        }
        labelText = new Text(label);
        labelElement.insertBefore(labelText, inputElement);
        return this;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public HTMLLabelElement getLabelElement() {
        return labelElement;
    }

    @Override
    public HTMLInputElement getInputElement() {
        return inputElement;
    }

    @Override
    public HTMLDivElement getContainer() {
        return container;
    }

    public SwitchButton removeCheckHandler(CheckHandler handler) {
        if (handler != null)
            checkHandlers.remove(handler);
        return this;
    }
}
