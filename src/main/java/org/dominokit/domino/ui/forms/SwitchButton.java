package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;
import elemental2.dom.HTMLLabelElement;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.Checkable;
import org.dominokit.domino.ui.utils.DominoElement;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;
import static org.jboss.gwt.elemento.core.Elements.*;

public class SwitchButton extends BasicFormElement<SwitchButton, Boolean> implements Checkable<SwitchButton> {

    public static final String READONLY = "readonly";
    private HTMLDivElement container = div().css("switch").css("form-group").css(Styles.no_wrap).asElement();
    private HTMLDivElement formLine = div().css("form-line").asElement();
    private HTMLDivElement formControl = div().css("form-control").asElement();
    private HTMLLabelElement onOffLabelElement = label().asElement();
    private HTMLLabelElement labelElement = label().css("form-label", "focused").asElement();
    private HTMLInputElement inputElement = input("checkbox").asElement();
    private DominoElement<HTMLElement> lever = DominoElement.of(span().css("lever"));
    private List<ChangeHandler<? super Boolean>> changeHandlers = new ArrayList<>();
    private Color color;
    private HTMLElement onTitleTextRoot = span().asElement();
    private HTMLElement offTitleTextRoot = span().asElement();
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
        onOffLabelElement.appendChild(offTitleTextRoot);
        onOffLabelElement.appendChild(inputElement);
        onOffLabelElement.appendChild(lever.asElement());
        onOffLabelElement.appendChild(onTitleTextRoot);
        inputElement.addEventListener("change", evt -> {
            evt.stopPropagation();
            if (!isReadOnly()) {
                onCheck();
                if (autoValidation)
                    validate();
            }
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
        for (ChangeHandler<? super Boolean> checkHandler : changeHandlers) {
            checkHandler.onValueChanged(isChecked());
        }
    }

    public DominoElement<HTMLElement> getLever() {
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
        if (!isReadOnly()) {
            inputElement.checked = false;
            if (!silent) {
                onCheck();
                validate();
            }
        }
        return this;
    }

    @Override
    public boolean isChecked() {
        return inputElement.checked;
    }

    @Override
    public SwitchButton addChangeHandler(ChangeHandler<? super Boolean> changeHandler) {
        changeHandlers.add(changeHandler);
        return this;
    }

    @Override
    public SwitchButton removeChangeHandler(ChangeHandler<? super Boolean> changeHandler) {
        if (changeHandler != null)
            changeHandlers.remove(changeHandler);
        return this;
    }

    @Override
    public boolean hasChangeHandler(ChangeHandler<? super Boolean> changeHandler) {
        return changeHandlers.contains(changeHandler);
    }

    public SwitchButton setColor(Color color) {
        if (this.color != null)
            lever.style().remove(this.color.getStyle());
        lever.style().add(color.getStyle());
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
        DominoElement.of(onTitleTextRoot)
                .clearElement()
                .appendChild(span().textContent(onTitle));
        this.onTitle = onTitle;
        return this;
    }

    public SwitchButton setOffTitle(String offTitle) {
        DominoElement.of(offTitleTextRoot)
                .clearElement()
                .appendChild(span().textContent(offTitle));
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
            setOffTitle(offTitle);
            setOnTitle(onTitle);
            setAttribute(READONLY, READONLY);
            if (isChecked()) {
                if (isOnTitleEmpty()) {
                    DominoElement.of(offTitleTextRoot)
                            .clearElement()
                            .appendChild(span().textContent(offTitle))
                            .appendChild(span().textContent(getCheckedReadonlyLabel()));
                } else {
                    DominoElement.of(offTitleTextRoot)
                            .clearElement();
                }
            } else {
                if (isOnTitleEmpty()) {
                    DominoElement.of(offTitleTextRoot)
                            .clearElement()
                            .appendChild(span().textContent(offTitle))
                            .appendChild(span().textContent(getUnCheckedReadonlyLabel()));
                } else {
                    DominoElement.of(onTitleTextRoot)
                            .clearElement();
                }
            }
        } else {
            removeAttribute(READONLY);
            setOffTitle(offTitle);
            setOnTitle(onTitle);
        }
        inputElement.disabled = readOnly;
        return this;
    }

    private boolean isOnTitleEmpty() {
        return isNull(onTitle) || onTitle.isEmpty();
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
