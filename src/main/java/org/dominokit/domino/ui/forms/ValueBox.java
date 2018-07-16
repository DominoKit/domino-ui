package org.dominokit.domino.ui.forms;

import elemental2.dom.*;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.Focusable;
import org.dominokit.domino.ui.utils.HasPlaceHolder;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.nonNull;

public abstract class ValueBox<T extends ValueBox, E extends HTMLElement, V> extends BasicFormElement<T, V> implements
        Focusable<T>, HasPlaceHolder<T> {

    public static final String FOCUSED = "focused";
    private HTMLDivElement container = Elements.div().css("form-group").asElement();
    private E inputElement;
    private HTMLDivElement inputContainer = Elements.div().css("form-line").asElement();
    private HTMLLabelElement labelElement = Elements.label().css("form-label").asElement();
    private HTMLElement leftAddonContainer = Elements.span().css("input-addon-container").asElement();
    private HTMLElement rightAddonContainer = Elements.span().css("input-addon-container").asElement();
    private ValueBoxSize size = ValueBoxSize.DEFAULT;
    private boolean floating;
    private String placeholder;
    private Color focusColor = Color.BLUE;
    private Element leftAddon;
    private Element rightAddon;
    private boolean valid = true;
    private EventListener changeEventListener;
    private boolean readOnly;

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
        inputElement = createInputElement(type);
        container.appendChild(leftAddonContainer);
        inputContainer.appendChild(inputElement);
        inputContainer.appendChild(labelElement);
        container.appendChild(inputContainer);
        container.appendChild(rightAddonContainer);
        setFocusColor(focusColor);
        addFocusListeners();
        setLabel(label);
    }

    protected abstract E createInputElement(String type);

    private void addFocusListeners() {
        inputElement.addEventListener("focusin", evt -> focus());
        inputElement.addEventListener("focusout", evt -> unfocus());
        labelElement.addEventListener("click", evt -> inputElement.focus());
    }

    public T large() {
        return setSize(ValueBoxSize.LARGE);
    }

    public T small() {
        return setSize(ValueBoxSize.SMALL);
    }

    public T setSize(ValueBoxSize size) {
        if (this.size != null)
            container.classList.remove(size.getStyle());
        container.classList.add(size.getStyle());
        setAddonsSize(size);
        this.size = size;
        return (T) this;
    }

    private void setAddonsSize(ValueBoxSize size) {
        setAddonSize(leftAddon, size);
        setAddonSize(rightAddon, size);
    }

    public T floating() {
        labelElement.classList.add(FOCUSED);
        showPlaceholder();
        this.floating = true;
        return (T) this;
    }

    public T nonfloating() {
        labelElement.classList.remove(FOCUSED);
        hidePlaceholder();
        this.floating = false;
        return (T) this;
    }

    public boolean isFloating() {
        return labelElement.classList.contains(FOCUSED);
    }

    @Override
    public T focus() {
        inputElement.classList.add(FOCUSED);
        floatLabel();
        if (valid) {
            inputElement.classList.add("fc-" + focusColor.getStyle());
            setLabelColor(focusColor);
            setLeftAddonColor(focusColor);
        }
        showPlaceholder();
        return (T) this;
    }

    @Override
    public T unfocus() {
        inputElement.classList.remove("fc-" + focusColor.getStyle());
        inputElement.classList.remove(FOCUSED);
        unfloatLabel();
        removeLabelColor(focusColor);
        removeLeftAddonColor(focusColor);
        hidePlaceholder();
        return (T) this;
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
        return inputElement.classList.contains(FOCUSED);
    }

    private void setLabelColor(Color color) {
        labelElement.classList.add(color.getStyle());
    }

    private void removeLabelColor(Color color) {
        labelElement.classList.remove(color.getStyle());
    }

    @Override
    public T enable() {
        super.enable();
        inputContainer.classList.remove("disabled");
        return (T) this;
    }

    @Override
    public T disable() {
        super.disable();
        inputContainer.classList.add("disabled");
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
    public HTMLDivElement getContainer() {
        return inputContainer;
    }

    public T setIcon(Icon icon) {
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
            rightAddonContainer.removeChild(rightAddon);
        }
        return (T) this;
    }

    public T removeLeftAddon() {
        if (nonNull(leftAddon)) {
            leftAddonContainer.removeChild(leftAddon);
        }
        return (T) this;
    }

    private void setAddon(HTMLElement container, Element oldAddon, Element addon) {
        if (nonNull(oldAddon)) {
            container.removeChild(oldAddon);
        }
        if (nonNull(addon)) {
            addon.classList.add("input-addon");
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
    public E getInputElement() {
        return inputElement;
    }

    @Override
    public HTMLLabelElement getLabelElement() {
        return labelElement;
    }

    @Override
    public HTMLElement asElement() {
        return container;
    }

    @Override
    public T invalidate(String errorMessage) {
        this.valid = false;
        inputElement.classList.remove("fc-" + focusColor.getStyle());
        inputElement.classList.add("fc-" + Color.RED.getStyle());
        removeLabelColor(focusColor);
        setLabelColor(Color.RED);
        removeLeftAddonColor(focusColor);
        setLeftAddonColor(Color.RED);
        return super.invalidate(errorMessage);
    }

    @Override
    public T clearInvalid() {
        this.valid = true;
        inputElement.classList.add("fc-" + focusColor.getStyle());
        inputElement.classList.remove("fc-" + Color.RED.getStyle());
        removeLabelColor(Color.RED);
        removeLeftAddonColor(Color.RED);
        if (isFocused()) {
            focus();
        } else {
            unfocus();
        }
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
            if (nonNull(changeEventListener))
                getInputElement().removeEventListener("input", changeEventListener);
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
    public T setValue(V value) {
        doSetValue(value);
        changeLabelFloating();
        autoValidate();
        return (T) this;
    }

    @Override
    protected void doSetReadOnly(boolean readOnly) {
        if (readOnly) {
            getInputElement().setAttribute("disabled", "true");
            getInputElement().setAttribute("readonly", "true");
            getInputElement().classList.add("readonly");
            if (isFloating()) {
                getInputElement().setAttribute("floating", true);
            }
            floating();
        } else {
            getInputElement().removeAttribute("disabled");
            getInputElement().removeAttribute("readonly");
            getInputElement().classList.remove("readonly");
            if (getInputElement().hasAttribute("floating")) {
                floating();
            } else {
                nonfloating();
            }
        }
    }

    protected void changeLabelFloating() {
        if (!isEmpty())
            floatLabel();
        else
            unfloatLabel();
    }

    protected void floatLabel() {
        if (!floating) {
            labelElement.classList.add(FOCUSED);
        }
    }

    protected void unfloatLabel() {
        if (!floating && isEmpty()) {
            labelElement.classList.remove(FOCUSED);
        }
    }

    protected void autoValidate() {
        if (isAutoValidation())
            validate();
    }


    protected abstract void clearValue();

    protected abstract void doSetValue(V value);
}
