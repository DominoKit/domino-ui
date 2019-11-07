package org.dominokit.domino.ui.forms;

import elemental2.dom.*;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.Checkable;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.*;

public class CheckBox extends AbstractValueBox<CheckBox, HTMLElement, Boolean> implements Checkable<CheckBox> {

    public static final String READONLY = "readonly";
    private DominoElement<HTMLInputElement> inputElement;
    private List<ChangeHandler<? super Boolean>> changeHandlers = new ArrayList<>();
    private Color color;
    private ChangeHandler<? super Boolean> autoValidationHandler;
    private String checkedReadonlyLabel = "Yes";
    private String unCheckedReadonlyLabel = "No";
    private String label;

    public CheckBox() {
        this("");
    }

    public CheckBox(String label) {
        super("checkbox", label);
        this.label = label;
        css("d-checkbox");
        setLabel(label);
        inputElement.addEventListener("change", evt -> {
            onCheck();
        });
        getLabelElement().addEventListener("click", evt -> {
            if (isEnabled() && !isReadOnly())
                toggle();
        });

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

    public static CheckBox create(IsElement<HTMLAnchorElement> link) {
        return create(DominoElement.of(link));
    }

    public static CheckBox create(HTMLAnchorElement link) {
        return create(DominoElement.of(link));
    }

    public static CheckBox create(DominoElement<HTMLAnchorElement> link) {
        CheckBox checkBox = new CheckBox();
        checkBox.getLabelTextElement().appendChild(link);
        link.addClickListener(Event::stopPropagation);
        return checkBox;
    }

    public CheckBox toggle() {
        if (isChecked()) {
            uncheck();
        } else {
            check();
        }
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
        inputElement.asElement().checked = true;
        if (!silent)
            onCheck();
        return this;
    }

    @Override
    public CheckBox uncheck(boolean silent) {
        inputElement.asElement().checked = false;
        if (!silent)
            onCheck();
        return this;
    }

    @Override
    public boolean isChecked() {
        return inputElement.asElement().checked;
    }

    @Override
    public CheckBox addChangeHandler(ChangeHandler<? super Boolean> changeHandler) {
        changeHandlers.add(changeHandler);
        return this;
    }

    @Override
    public CheckBox removeChangeHandler(ChangeHandler<? super Boolean> changeHandler) {
        if (changeHandler != null)
            changeHandlers.remove(changeHandler);
        return this;
    }

    @Override
    public boolean hasChangeHandler(ChangeHandler<? super Boolean> changeHandler) {
        return changeHandlers.contains(changeHandler);
    }

    public CheckBox filledIn() {
        inputElement.style().add("filled-in");
        return this;
    }

    public CheckBox filledOut() {
        inputElement.style().remove("filled-in");
        return this;
    }

    public CheckBox setColor(Color color) {
        if (this.color != null) {
            inputElement.style().remove(this.color.getStyle());
        }
        inputElement.style().add(color.getStyle());
        this.color = color;
        return this;
    }

    @Override
    public CheckBox value(Boolean value) {
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
        super.clear();
        return this;
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
    public CheckBox setReadOnly(boolean readOnly) {
        super.setReadOnly(readOnly);
        if (readOnly) {
            getInputElement().setReadOnly(true);
            css(READONLY);
            if (isChecked()) {
                getLabelTextElement().setTextContent(label + getCheckedReadonlyLabel());
            } else {
                getLabelTextElement().setTextContent(label + getUnCheckedReadonlyLabel());
            }
        } else {
            getInputElement().setReadOnly(false);
            removeCss(READONLY);
            getLabelTextElement().setTextContent(label);
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
    public String getStringValue() {
        return Boolean.toString(getValue());
    }

    @Override
    protected HTMLElement createInputElement(String type) {
        inputElement = DominoElement.of(input("checkbox"));
        return inputElement.asElement();
    }

    @Override
    protected void clearValue() {
        value(false);
    }

    @Override
    protected void doSetValue(Boolean value) {

    }
}