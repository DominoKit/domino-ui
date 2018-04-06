package org.dominokit.domino.ui.forms;

import elemental2.dom.*;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.*;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.List;

public class SwitchButton implements IsElement<HTMLDivElement>,
        HasName<SwitchButton>, CanDisable<SwitchButton>, CanEnable<SwitchButton>, HasValue<Boolean>,
        Checkable<SwitchButton> {

    private HTMLDivElement container = Elements.div().css("switch").asElement();
    private HTMLLabelElement labelElement = Elements.label().asElement();
    private HTMLInputElement inputElement = Elements.input("checkbox").asElement();
    private final HTMLElement lever = Elements.span().css("lever").asElement();
    private List<CheckHandler> checkHandlers = new ArrayList<>();
    private Color color;

    public SwitchButton(String title, String onTitle) {
        this(title);
        labelElement.appendChild(new Text(onTitle));
    }

    public SwitchButton(String title) {
        this();
        labelElement.insertBefore(new Text(title), inputElement);
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

    public static SwitchButton create(String title) {
        return new SwitchButton(title);
    }

    public static SwitchButton create() {
        return new SwitchButton();
    }

    private void onCheck() {
        for (CheckHandler checkHandler : checkHandlers)
            checkHandler.onCheck(isChecked());
    }

    @Override
    public HTMLDivElement asElement() {
        return container;
    }

    public HTMLDivElement getContainer() {
        return container;
    }

    public HTMLLabelElement getLabelElement() {
        return labelElement;
    }

    public HTMLInputElement getInputElement() {
        return inputElement;
    }

    public HTMLElement getLever() {
        return lever;
    }

    @Override
    public String getName() {
        return inputElement.name;
    }

    @Override
    public SwitchButton setName(String name) {
        inputElement.name = name;
        return this;
    }

    @Override
    public SwitchButton disable() {
        inputElement.disabled = true;
        return this;
    }

    @Override
    public SwitchButton enable() {
        inputElement.disabled = false;
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
        return inputElement.checked;
    }

    @Override
    public SwitchButton check() {
        inputElement.checked = true;
        onCheck();
        return this;
    }

    @Override
    public SwitchButton uncheck() {
        inputElement.checked = false;
        onCheck();
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
}
