package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;
import elemental2.dom.HTMLLabelElement;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.Checkable;
import org.dominokit.domino.ui.utils.DominoElement;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.*;


public class CheckBox extends BasicFormElement<CheckBox, Boolean> implements Checkable<CheckBox> {

    public static final String READONLY = "readonly";
    private HTMLDivElement container = div().css("form-group").asElement();
    private HTMLDivElement formLine = div().css("form-line").asElement();
    private HTMLDivElement formControl = div().css("form-control").asElement();
    private HTMLInputElement inputElement = input("checkbox").asElement();
    private HTMLLabelElement labelElement = label().asElement();
    private List<ChangeHandler<Boolean>> changeHandlers = new ArrayList<>();
    private Color color;
    private ChangeHandler<Boolean> autoValidationHandler;
    private String checkedReadonlyLabel = "Yes";
    private String unCheckedReadonlyLabel = "No";
    private String label;

    public CheckBox() {
        this("");
    }

    public CheckBox(String label) {
        this.label = label;
        setLabel(label);
        Style.of(formControl).setProperty("border-bottom", "0px");
        formControl.appendChild(inputElement);
        formControl.appendChild(labelElement);
        inputElement.addEventListener("change", evt -> {
            onCheck();
        });
        labelElement.addEventListener("click", evt -> {
            if (isEnabled() && !isReadOnly())
                toggle();
        });
        formLine.appendChild(formControl);
        container.appendChild(formLine);
        init(this);
    }

    private void onCheck() {
        changeHandlers.forEach(handler -> handler.onValueChanged(isChecked()));
    }

    public static CheckBox create(String label) {
        return new CheckBox(label);
    }

    public static CheckBox create() {
        return new CheckBox();
    }

    public CheckBox toggle() {
        if (isChecked())
            uncheck();
        else
            check();
        return this;
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
        if (!silent)
            onCheck();
        return this;
    }

    @Override
    public CheckBox uncheck(boolean silent) {
        inputElement.checked = false;
        if (!silent)
            onCheck();
        return this;
    }

    @Override
    public boolean isChecked() {
        return inputElement.checked;
    }

    @Override
    public CheckBox addChangeHandler(ChangeHandler<Boolean> changeHandler) {
        changeHandlers.add(changeHandler);
        return this;
    }

    @Override
    public CheckBox removeChangeHandler(ChangeHandler<Boolean> changeHandler) {
        if (changeHandler != null)
            changeHandlers.remove(changeHandler);
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
        if (this.color != null) {
            inputElement.classList.remove(this.color.getStyle());
        }
        inputElement.classList.add(color.getStyle());
        this.color = color;
        return this;
    }

    @Override
    public CheckBox setValue(Boolean value) {
        if (value != null && value) {
            check();
        } else {
            uncheck();
        }
        return this;
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

    @Override
    public DominoElement<HTMLInputElement> getInputElement() {
        return DominoElement.of(inputElement);
    }

    @Override
    protected DominoElement<HTMLDivElement> getFieldContainer() {
        return DominoElement.of(formLine);
    }

    @Override
    public DominoElement<HTMLLabelElement> getLabelElement() {
        return DominoElement.of(labelElement);
    }

    @Override
    public CheckBox setAutoValidation(boolean autoValidation) {
        if (autoValidation) {
            if (isNull(autoValidationHandler)) {
                autoValidationHandler = checked -> validate();
                addChangeHandler(autoValidationHandler);
            }
        } else {
            removeChangeHandler(autoValidationHandler);
            autoValidationHandler = null;
        }
        return this;
    }

    @Override
    public boolean isAutoValidation() {
        return nonNull(autoValidationHandler);
    }

    @Override
    public HTMLElement asElement() {
        return container;
    }


    @Override
    public CheckBox setReadOnly(boolean readOnly) {
        if (readOnly) {
            DominoElement.of(formControl).setAttribute(READONLY, READONLY);
            if (isChecked()) {
                labelElement.textContent = label + getCheckedReadonlyLabel();
            } else {
                labelElement.textContent = label + getUnCheckedReadonlyLabel();
            }
        } else {
            DominoElement.of(formControl).removeAttribute(READONLY);
            labelElement.textContent = label;
        }
        return this;
    }

    private String getCheckedReadonlyLabel() {
        return isNull(checkedReadonlyLabel) || checkedReadonlyLabel.isEmpty() ? "" : ": " + checkedReadonlyLabel;
    }

    private String getUnCheckedReadonlyLabel() {
        return isNull(unCheckedReadonlyLabel) || unCheckedReadonlyLabel.isEmpty() ? "" : ": " + unCheckedReadonlyLabel;
    }

    public CheckBox setCheckedReadonlyLabel(String checkedReadonlyLabel) {
        this.checkedReadonlyLabel = checkedReadonlyLabel;
        return this;
    }

    public CheckBox setUnCheckedReadonlyLabel(String unCheckedReadonlyLabel) {
        this.unCheckedReadonlyLabel = unCheckedReadonlyLabel;
        return this;
    }

    @Override
    public boolean isReadOnly() {
        return DominoElement.of(formControl).hasAttribute(READONLY);
    }
}
