package org.dominokit.domino.ui.forms;

import elemental2.dom.*;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.*;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.label;

public abstract class ValueBox<T extends ValueBox<T, E, V>, E extends HTMLElement, V> extends BasicFormElement<T, V> implements
        Focusable<T>, HasPlaceHolder<T>, IsReadOnly<T>, HasChangeHandlers<T, V> {

    public static final String FOCUSED = "focused";
    private DominoElement<HTMLDivElement> container = DominoElement.of(div().css("form-group"));
    private DominoElement<E> inputElement;
    private DominoElement<HTMLDivElement> inputContainer = DominoElement.of(div().css("form-line"));
    private DominoElement<HTMLLabelElement> labelElement = DominoElement.of(label().css("form-label"));
    private DominoElement<HTMLDivElement> leftAddonContainer = DominoElement.of(div().css("input-addon-container"));
    private DominoElement<HTMLDivElement> rightAddonContainer = DominoElement.of(div().css("input-addon-container"));
    private ValueBoxSize size = ValueBoxSize.DEFAULT;
    private boolean floating;
    private String placeholder;
    private Color focusColor = Color.BLUE;
    private Element leftAddon;
    private Element rightAddon;
    private boolean valid = true;
    private EventListener changeEventListener;
    private boolean readOnly;
    private List<ChangeHandler<? super V>> changeHandlers = new ArrayList<>();
    private boolean pauseChangeHandlers = false;

    public enum ValueBoxSize {
        LARGE("lg"),
        SMALL("sm"),
        DEFAULT("");

        private String sizeValue;

        ValueBoxSize(String sizeValue) {
            this.sizeValue = sizeValue;
        }

        public String getStyle() {
            return "form-group" + (sizeValue.isEmpty() ? "" : "-" + sizeValue);
        }
    }

    public ValueBox(String type, String label) {
        init((T) this);
        inputElement = DominoElement.of(createInputElement(type));
        inputElement.addEventListener("change", evt -> callChangeHandlers());
        container.appendChild(leftAddonContainer);
        inputContainer.appendChild(inputElement);
        inputContainer.appendChild(labelElement);
        container.appendChild(inputContainer);
        container.appendChild(rightAddonContainer);
        setFocusColor(focusColor);
        addFocusListeners();
        setLabel(label);
    }

    protected void callChangeHandlers() {
        if(!pauseChangeHandlers) {
            changeHandlers.forEach(changeHandler -> changeHandler.onValueChanged(getValue()));
        }
    }

    protected abstract E createInputElement(String type);

    private void addFocusListeners() {
        inputElement.addEventListener("focus", evt -> doFocus());
        inputElement.addEventListener("focusout", evt -> {
            doUnfocus();
            if (isAutoValidation()) {
                validate();
            }
        });
        labelElement.addEventListener("click", evt -> {
            DomGlobal.console.info("FOCUSING FIELD -------------");
            focus();
        });
    }

    public T large() {
        return setSize(ValueBoxSize.LARGE);
    }

    public T small() {
        return setSize(ValueBoxSize.SMALL);
    }

    public T setSize(ValueBoxSize size) {
        if (this.size != null)
            container.style().remove(size.getStyle());
        container.style().add(size.getStyle());
        setAddonsSize(size);
        this.size = size;
        return (T) this;
    }

    private void setAddonsSize(ValueBoxSize size) {
        setAddonSize(leftAddon, size);
        setAddonSize(rightAddon, size);
    }

    public T floating() {
        labelElement.style().add(FOCUSED);
        showPlaceholder();
        this.floating = true;
        return (T) this;
    }

    public T nonfloating() {
        labelElement.style().remove(FOCUSED);
        hidePlaceholder();
        this.floating = false;
        return (T) this;
    }

    public boolean isFloating() {
        return labelElement.style().contains(FOCUSED);
    }

    @Override
    public T focus() {
        if (!isAttached()) {
            DomGlobal.console.info("IS ATTACHED ---- 0");
            ElementUtil.onAttach(getInputElement(), mutationRecord -> {
                DomGlobal.console.info("IS ATTACHED ---- 1");
                getInputElement().asElement().focus();
            });
        } else {
            DomGlobal.console.info("IS ATTACHED ---- 2");
            getInputElement().asElement().focus();
        }
        return (T) this;
    }

    @Override
    public T unfocus() {
        if (!isAttached()) {
            ElementUtil.onAttach(getInputElement(), mutationRecord -> {
                getInputElement().asElement().blur();
            });
        } else {
            getInputElement().asElement().blur();
        }
        return (T) this;
    }

    private void doFocus() {
        inputElement.style().add(FOCUSED);
        floatLabel();
        if (valid) {
            inputElement.style().add("fc-" + focusColor.getStyle());
            setLabelColor(focusColor);
            setLeftAddonColor(focusColor);
        }
        showPlaceholder();
    }

    private void doUnfocus() {
        inputElement.style().remove("fc-" + focusColor.getStyle(), FOCUSED);
        unfloatLabel();
        removeLabelColor(focusColor);
        removeLeftAddonColor(focusColor);
        hidePlaceholder();
    }

    private void setLeftAddonColor(Color focusColor) {
        if (leftAddon != null)
            leftAddon.classList.add(focusColor.getStyle());
    }

    private void removeLeftAddonColor(Color focusColor) {
        if (leftAddon != null)
            leftAddon.classList.remove(focusColor.getStyle());
    }

    @Override
    public boolean isFocused() {
        return inputElement.style().contains(FOCUSED);
    }

    private void setLabelColor(Color color) {
        labelElement.style().add(color.getStyle());
    }

    private void removeLabelColor(Color color) {
        labelElement.style().remove(color.getStyle());
    }

    @Override
    public T enable() {
        super.enable();
        inputContainer.style().remove("disabled");
        return (T) this;
    }

    @Override
    public T disable() {
        super.disable();
        inputContainer.style().add("disabled");
        return (T) this;
    }

    @Override
    public T setLabel(String label) {
        super.setLabel(label);
        hidePlaceholder();
        return (T) this;
    }

    @Override
    public T setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
        showPlaceholder();
        return (T) this;
    }

    private void showPlaceholder() {
        if (placeholder != null && shouldShowPlaceholder()) {
            inputElement.setAttribute("placeholder", placeholder);
        }
    }

    private void hidePlaceholder() {
        if (placeholder != null && !shouldShowPlaceholder()) {
            inputElement.removeAttribute("placeholder");
        }
    }

    private boolean shouldShowPlaceholder() {
        return getLabel().isEmpty() || isFloating();
    }

    @Override
    public String getPlaceholder() {
        return this.placeholder;
    }

    @Override
    public T setFocusColor(Color focusColor) {
        removeLabelColor(this.focusColor);
        if (isFocused()) {
            setLabelColor(focusColor);
            setLeftAddonColor(focusColor);
        }
        this.focusColor = focusColor;
        return (T) this;
    }

    @Override
    public DominoElement<HTMLDivElement> getFieldContainer() {
        return DominoElement.of(inputContainer);
    }

    public T setIcon(BaseIcon<?> icon) {
        return setLeftAddon(icon.asElement());
    }

    public T setLeftAddon(IsElement leftAddon) {
        return setLeftAddon(leftAddon.asElement());
    }

    public T setLeftAddon(Element leftAddon) {
        setAddon(leftAddonContainer, this.leftAddon, leftAddon);
        this.leftAddon = leftAddon;
        return (T) this;
    }

    public T setRightAddon(IsElement rightAddon) {
        return setRightAddon(rightAddon.asElement());
    }

    public T setRightAddon(Element rightAddon) {
        setAddon(rightAddonContainer, this.rightAddon, rightAddon);
        this.rightAddon = rightAddon;
        return (T) this;
    }

    public T removeRightAddon() {
        if (nonNull(rightAddon)) {
            rightAddon.remove();
        }
        return (T) this;
    }

    public T removeLeftAddon() {
        if (nonNull(leftAddon)) {
            leftAddon.remove();
        }
        return (T) this;
    }

    private void setAddon(DominoElement<HTMLDivElement> container, Element oldAddon, Element addon) {
        if (nonNull(oldAddon)) {
            oldAddon.remove();
        }
        if (nonNull(addon)) {
            List<String> oldClasses = new ArrayList<>(addon.classList.asList());
            for (String oldClass : oldClasses) {
                addon.classList.remove(oldClass);
            }
            oldClasses.add(0, "input-addon");
            for (String oldClass : oldClasses) {
                addon.classList.add(oldClass);
            }
            container.appendChild(addon);
            setAddonSize(addon, size);
        }
    }

    private void setAddonSize(Element addon, ValueBoxSize size) {
        if (nonNull(addon) && !size.sizeValue.isEmpty()) {
            addon.classList.remove(this.size.getStyle());
            addon.classList.add(size.sizeValue);
        }
    }

    @Override
    public DominoElement<E> getInputElement() {
        return DominoElement.of(inputElement);
    }

    @Override
    public DominoElement<HTMLLabelElement> getLabelElement() {
        return DominoElement.of(labelElement);
    }

    @Override
    public HTMLElement asElement() {
        return container.asElement();
    }


    @Override
    public T invalidate(String errorMessage) {
        this.valid = false;
        inputElement.style().remove("fc-" + focusColor.getStyle());
        inputElement.style().add("fc-" + Color.RED.getStyle());
        removeLabelColor(focusColor);
        setLabelColor(Color.RED);
        removeLeftAddonColor(focusColor);
        setLeftAddonColor(Color.RED);
        changeLabelFloating();
        return super.invalidate(errorMessage);
    }

    @Override
    public T clearInvalid() {
        this.valid = true;
        inputElement.style().add("fc-" + focusColor.getStyle());
        inputElement.style().remove("fc-" + Color.RED.getStyle());
        removeLabelColor(Color.RED);
        removeLeftAddonColor(Color.RED);
        if (isFocused()) {
            doFocus();
        } else {
            doUnfocus();
        }
        changeLabelFloating();
        return super.clearInvalid();
    }

    @Override
    public T setAutoValidation(boolean autoValidation) {
        if (autoValidation) {
            if (changeEventListener == null) {
                changeEventListener = evt -> validate();
                getInputElement().addEventListener("input", changeEventListener);
            }
        } else {
            if (nonNull(changeEventListener)) {
                getInputElement().removeEventListener("input", changeEventListener);
            }
            changeEventListener = null;
        }
        return (T) this;
    }

    @Override
    public boolean isAutoValidation() {
        return nonNull(changeEventListener);
    }

    @Override
    public T clear() {
        clearValue();
        autoValidate();
        return (T) this;
    }

    @Override
    public T value(V value) {
        doSetValue(value);
        changeLabelFloating();
        autoValidate();
        callChangeHandlers();
        return (T) this;
    }

    @Override
    public T setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
        if (readOnly) {
            getInputElement().setAttribute("disabled", "true");
            getInputElement().setAttribute("readonly", "true");
            getInputElement().style().add("readonly");
            if (isFloating()) {
                getInputElement().setAttribute("floating", true);
            }
            floating();
        } else {
            getInputElement().removeAttribute("disabled");
            getInputElement().removeAttribute("readonly");
            getInputElement().style().remove("readonly");
            if (getInputElement().hasAttribute("floating")) {
                floating();
            } else {
                nonfloating();
            }
        }
        return (T) this;
    }

    @Override
    public boolean isReadOnly() {
        return readOnly;
    }

    protected void changeLabelFloating() {
        if (!isEmpty() || isFocused())
            floatLabel();
        else
            unfloatLabel();
    }

    protected void floatLabel() {
        if (!floating) {
            labelElement.style().add(FOCUSED);
        }
    }

    protected void unfloatLabel() {
        if (!floating && isEmpty()) {
            labelElement.style().remove(FOCUSED);
        }
    }

    protected void autoValidate() {
        if (isAutoValidation())
            validate();
    }

    @Override
    public T addChangeHandler(ChangeHandler<? super V> changeHandler) {
        changeHandlers.add(changeHandler);
        return (T) this;
    }

    @Override
    public T removeChangeHandler(ChangeHandler<? super V> changeHandler) {
        changeHandlers.remove(changeHandler);
        return (T) this;
    }

    public T setPauseChangeHandlers(boolean pauseChangeHandlers){
        this.pauseChangeHandlers = pauseChangeHandlers;
        return (T) this;
    }

    public T pauseChangeHandlers(){
        return setPauseChangeHandlers(true);
    }

    public T resumeChangeHandlers(){
        return setPauseChangeHandlers(false);
    }

    public DominoElement<HTMLDivElement> getLeftAddonContainer() {
        return leftAddonContainer;
    }

    public DominoElement<HTMLDivElement> getRightAddonContainer() {
        return rightAddonContainer;
    }

    @Override
    public boolean hasChangeHandler(ChangeHandler<? super V> changeHandler) {
        return changeHandlers.contains(changeHandler);
    }

    protected abstract void clearValue();

    protected abstract void doSetValue(V value);
}
