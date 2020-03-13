package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;
import elemental2.dom.HTMLLabelElement;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.Checkable;
import org.dominokit.domino.ui.utils.DominoElement;

import static java.util.Objects.isNull;
import static org.jboss.elemento.Elements.*;

public class SwitchButton extends AbstractValueBox<SwitchButton, HTMLElement, Boolean> implements Checkable<SwitchButton> {

    private HTMLLabelElement onOffLabelElement;
    private DominoElement<HTMLInputElement> inputElement;
    private DominoElement<HTMLElement> lever = DominoElement.of(span().css("lever"));
    private Color color;
    private DominoElement<HTMLElement> onTitleTextRoot = DominoElement.of(span());
    private DominoElement<HTMLElement> offTitleTextRoot = DominoElement.of(span());
    private String checkedReadonlyLabel = "Yes";
    private String unCheckedReadonlyLabel = "No";
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
        super("switch", "");
        init(this);
        DominoElement.of(onOffLabelElement).css("switch-label");
        getInputContainer().appendChild(onOffLabelElement);
        onOffLabelElement.appendChild(offTitleTextRoot.element());
        onOffLabelElement.appendChild(getInputElement().element());
        onOffLabelElement.appendChild(lever.element());
        onOffLabelElement.appendChild(onTitleTextRoot.element());

        linkLabelToField();

        inputElement.addEventListener("change", evt -> {
            evt.stopPropagation();
            if (!isReadOnly()) {
                if (isAutoValidation()) {
                    validate();
                }
            }
        });
        css("switch");
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

    @Override
    protected void linkLabelToField() {
        if(!inputElement.hasAttribute("id")){
            inputElement.setAttribute("id", inputElement.getAttribute(BaseDominoElement.DOMINO_UUID));
        }

        getOnOffLabelElement().setAttribute("for", inputElement.getAttribute("id"));
    }

    public DominoElement<HTMLElement> getLever() {
        return lever;
    }

    @Override
    public SwitchButton value(Boolean value) {
        super.value(value);
        if (value != null && value) {
            check();
        } else {
            uncheck();
        }
        return this;
    }

    @Override
    public Boolean getValue() {
        return inputElement.element().checked;
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
        inputElement.element().checked = true;
        if (!silent) {
            callChangeHandlers();
            validate();
        }
        updateLabel();
        return this;
    }

    @Override
    public SwitchButton uncheck(boolean silent) {
        inputElement.element().checked = false;
        if (!silent) {
            callChangeHandlers();
            validate();
        }
        updateLabel();
        return this;
    }

    @Override
    public boolean isChecked() {
        return inputElement.element().checked;
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

    public SwitchButton setOnTitle(String onTitle) {
        onTitleTextRoot
                .clearElement()
                .appendChild(span().textContent(onTitle));
        this.onTitle = onTitle;
        return this;
    }

    public SwitchButton setOffTitle(String offTitle) {
        offTitleTextRoot
                .clearElement()
                .appendChild(span().textContent(offTitle));
        this.offTitle = offTitle;
        return this;
    }

    public DominoElement<HTMLLabelElement> getOnOffLabelElement() {
        return DominoElement.of(onOffLabelElement);
    }

    @Override
    public SwitchButton setReadOnly(boolean readOnly) {
        super.setReadOnly(readOnly);
        if (readOnly) {
            updateLabel();
        } else {
            setOffTitle(offTitle);
            setOnTitle(onTitle);
        }

        return this;
    }

    private void updateLabel() {
        setOffTitle(offTitle);
        setOnTitle(onTitle);
        if (isReadOnly()) {
            if (isChecked()) {
                if (isOnTitleEmpty()) {
                    offTitleTextRoot
                            .clearElement()
                            .appendChild(span().textContent(offTitle))
                            .appendChild(span().textContent(getCheckedReadonlyLabel()));
                } else {
                    offTitleTextRoot.clearElement();
                }
            } else {
                if (isOnTitleEmpty()) {
                    offTitleTextRoot
                            .clearElement()
                            .appendChild(span().textContent(offTitle))
                            .appendChild(span().textContent(getUnCheckedReadonlyLabel()));
                } else {
                    onTitleTextRoot.clearElement();
                }
            }
        }
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
    protected DominoElement<HTMLLabelElement> createLabelElement() {
        onOffLabelElement = label().element();
        return DominoElement.of(onOffLabelElement);
    }

    @Override
    protected HTMLElement createInputElement(String type) {
        inputElement = DominoElement.of(input("checkbox"));
        return inputElement.element();
    }

    @Override
    protected AutoValidator createAutoValidator(AutoValidate autoValidate) {
        return null;
    }

    @Override
    protected void clearValue() {
        value(false);
    }

    @Override
    protected void doSetValue(Boolean value) {

    }

    @Override
    public String getStringValue() {
        return Boolean.toString(getValue());
    }

    @Override
    protected boolean isAddFocusColor() {
        return false;
    }

    private static class SwitchButtonAutoValidator<T> extends AutoValidator{

        private SwitchButton switchButton;
        private ChangeHandler<Boolean> changeHandler;

        public SwitchButtonAutoValidator(SwitchButton switchButton, AutoValidate autoValidate) {
            super(autoValidate);
            this.switchButton = switchButton;
        }

        @Override
        public void attach() {
            changeHandler = value -> autoValidate.apply();
            switchButton.addChangeHandler(changeHandler);
        }

        @Override
        public void remove() {
            switchButton.removeChangeHandler(changeHandler);
        }
    }

}