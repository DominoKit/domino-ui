package org.dominokit.domino.ui.forms;

import elemental2.dom.*;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.Checkable;
import org.jboss.gwt.elemento.core.Elements;

import java.util.ArrayList;
import java.util.List;

public class SwitchButton extends BasicFormElement<SwitchButton, Boolean> implements Checkable<SwitchButton> {

    private HTMLDivElement container = Elements.div().css("switch form-group").asElement();
    private HTMLDivElement formLine = Elements.div().css("form-line").asElement();
    private HTMLDivElement formControl = Elements.div().css("form-control").asElement();
    private HTMLLabelElement onOffLabelElement = Elements.label().asElement();
    private HTMLLabelElement labelElement = Elements.label().css("form-label focused").asElement();
    private HTMLInputElement inputElement = Elements.input("checkbox").asElement();
    private HTMLElement lever = Elements.span().css("lever").asElement();
    private List<ChangeHandler<Boolean>> changeHandlers = new ArrayList<>();
    private Color color;
    private Text onTitleText = new Text();
    private Text offTitleText = new Text();
    private boolean autoValidation;

    public SwitchButton(String label, String offTitle, String onTitle) {
        this(label);
        setOffTitle(offTitle);
        setOnTitle(onTitle);
    }

    public SwitchButton(String label, String onOffTitle) {
        this(label);
        setOffTitle(onOffTitle);
    }

    public SwitchButton(String label) {
        this();
        setLabel(label);
    }

    public SwitchButton() {
        Style.of(formControl).setProperty("border-bottom", "0px");
        formControl.appendChild(onOffLabelElement);
        onOffLabelElement.appendChild(offTitleText);
        onOffLabelElement.appendChild(inputElement);
        onOffLabelElement.appendChild(lever);
        onOffLabelElement.appendChild(onTitleText);
        inputElement.addEventListener("change", evt -> {
            onCheck();
            if (autoValidation)
                validate();
        });
        formLine.appendChild(formControl);
        formLine.appendChild(labelElement);
        container.appendChild(formLine);
    }

    public static SwitchButton create(String label, String offTitle, String onTitle) {
        return new SwitchButton(label, offTitle, onTitle);
    }

    public static SwitchButton create(String label, String onOffTitle) {
        return new SwitchButton(label, onOffTitle);
    }

    public static SwitchButton create() {
        return new SwitchButton();
    }

    private void onCheck() {
        for (ChangeHandler<Boolean> checkHandler : changeHandlers) {
            checkHandler.onValueChanged(isChecked());
        }
    }

    public HTMLElement getLever() {
        return lever;
    }

    @Override
    public SwitchButton setValue(Boolean value) {
        if (value != null && value) {
            check();
        } else {
            uncheck();
        }
        return this;
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
    public SwitchButton addChangeHandler(ChangeHandler<Boolean> changeHandler) {
        changeHandlers.add(changeHandler);
        return this;
    }

    @Override
    public SwitchButton removeChangeHandler(ChangeHandler<Boolean> changeHandler) {
        if (changeHandler != null)
            changeHandlers.remove(changeHandler);
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
        this.labelElement.textContent = label;
        return this;
    }

    @Override
    public String getLabel() {
        return labelElement.textContent;
    }

    @Override
    protected void doSetReadOnly(boolean readOnly) {
        // TODO: implement read only
    }

    @Override
    public HTMLLabelElement getLabelElement() {
        return labelElement;
    }

    public SwitchButton setOnTitle(String onTitle) {
        onTitleText.textContent = onTitle;
        return this;
    }

    public SwitchButton setOffTitle(String offTitle) {
        offTitleText.textContent = offTitle;
        return this;
    }

    public HTMLLabelElement getOnOffLabelElement() {
        return onOffLabelElement;
    }

    @Override
    public HTMLInputElement getInputElement() {
        return inputElement;
    }

    @Override
    public HTMLDivElement getFieldContainer() {
        return formLine;
    }

    @Override
    public SwitchButton setAutoValidation(boolean autoValidation) {
        this.autoValidation = autoValidation;
        return this;
    }

    @Override
    public boolean isAutoValidation() {
        return autoValidation;
    }

    @Override
    public HTMLElement asElement() {
        return container;
    }
}
