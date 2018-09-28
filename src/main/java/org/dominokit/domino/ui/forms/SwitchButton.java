package org.dominokit.domino.ui.forms;

import elemental2.dom.*;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.Checkable;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.gwt.elemento.core.Elements;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

public class SwitchButton extends BasicFormElement<SwitchButton, Boolean> implements Checkable<SwitchButton> {

    public static final String READONLY = "readonly";
    private HTMLDivElement container = Elements.div().css("switch", "form-group", Styles.no_wrap).asElement();
    private HTMLDivElement formLine = Elements.div().css("form-line").asElement();
    private HTMLDivElement formControl = Elements.div().css("form-control").asElement();
    private HTMLLabelElement onOffLabelElement = Elements.label().asElement();
    private HTMLLabelElement labelElement = Elements.label().css("form-label focused").asElement();
    private HTMLInputElement inputElement = Elements.input("checkbox").asElement();
    private HTMLElement lever = Elements.span().css("lever").asElement();
    private List<ChangeHandler<Boolean>> changeHandlers = new ArrayList<>();
    private Color color;
    private Text onTitleText = DomGlobal.document.createTextNode("");
    private Text offTitleText = DomGlobal.document.createTextNode("");
    private String checkedReadonlyLabel = "Yes";
    private String unCheckedReadonlyLabel = "No";
    private boolean autoValidation;
    private String offTitle;
    private String onTitle;

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
            evt.stopPropagation();
            onCheck();
            if (autoValidation)
                validate();
        });
        formLine.appendChild(formControl);
        formLine.appendChild(labelElement);
        container.appendChild(formLine);
        init(this);
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
    public SwitchButton value(Boolean value) {
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
        value(false);
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
            lever.classList.remove(this.color.getStyle());
        lever.classList.add(color.getStyle());
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
    public DominoElement<HTMLLabelElement> getLabelElement() {
        return DominoElement.of(labelElement);
    }

    public SwitchButton setOnTitle(String onTitle) {
        onTitleText.textContent = onTitle;
        this.onTitle = onTitle;
        return this;
    }

    public SwitchButton setOffTitle(String offTitle) {
        offTitleText.textContent = offTitle;
        this.offTitle = offTitle;
        return this;
    }

    public DominoElement<HTMLLabelElement> getOnOffLabelElement() {
        return DominoElement.of(onOffLabelElement);
    }

    @Override
    public DominoElement<HTMLInputElement> getInputElement() {
        return DominoElement.of(inputElement);
    }

    @Override
    public DominoElement<HTMLDivElement> getFieldContainer() {
        return DominoElement.of(formLine);
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

    public Style<HTMLElement, SwitchButton> style() {
        return Style.of(this);
    }

    @Override
    public SwitchButton setReadOnly(boolean readOnly) {
        if (readOnly) {
            setAttribute(READONLY, READONLY);
            if (isChecked()) {
                if (onTitleText.textContent.isEmpty()) {
                    offTitleText.textContent = offTitle + getCheckedReadonlyLabel();
                } else {
                    offTitleText.textContent = "";
                }
            } else {
                if (onTitleText.textContent.isEmpty()) {
                    offTitleText.textContent = offTitle + getUnCheckedReadonlyLabel();
                } else {
                    onTitleText.textContent = "";
                }
            }
        } else {
            removeAttribute(READONLY);
            setOffTitle(offTitle);
            setOnTitle(onTitle);
        }
        return this;
    }


    private String getCheckedReadonlyLabel() {
        return isNull(checkedReadonlyLabel) || checkedReadonlyLabel.isEmpty() ? "" : ": " + checkedReadonlyLabel;
    }

    private String getUnCheckedReadonlyLabel() {
        return isNull(unCheckedReadonlyLabel) || unCheckedReadonlyLabel.isEmpty() ? "" : ": " + unCheckedReadonlyLabel;
    }

    public SwitchButton setCheckedReadonlyLabel(String checkedReadonlyLabel) {
        this.checkedReadonlyLabel = checkedReadonlyLabel;
        return this;
    }

    public SwitchButton setUnCheckedReadonlyLabel(String unCheckedReadonlyLabel) {
        this.unCheckedReadonlyLabel = unCheckedReadonlyLabel;
        return this;
    }

    @Override
    public boolean isReadOnly() {
        return formControl.hasAttribute(READONLY);
    }

    @Override
    public String getStringValue() {
        return Boolean.toString(getValue());
    }
}
