package org.dominokit.domino.ui.forms;

import elemental2.dom.*;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.Focusable;
import org.dominokit.domino.ui.utils.HasPlaceHolder;
import org.jboss.gwt.elemento.core.Elements;

public abstract class ValueBox<T extends ValueBox, E extends HTMLElement, V> extends BasicFormElement<T, V> implements
        Focusable<T>, HasPlaceHolder<T> {

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
    private EventListener validateOnBlurListener;

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
        labelElement.classList.add("focused");
        showPlaceholder();
        this.floating = true;
        return (T) this;
    }

    public T nonfloating() {
        labelElement.classList.remove("focused");
        hidePlaceholder();
        this.floating = false;
        return (T) this;
    }

    public boolean isFloating() {
        return labelElement.classList.contains("focused");
    }

    @Override
    public T focus() {
        if (valid)
            inputElement.classList.add("fc-" + focusColor.getStyle());
        if (!floating) {
            labelElement.classList.add("focused");
        }
        if (valid) {
            setLabelColor(focusColor);
            setLeftAddonColor(focusColor);
        }
        showPlaceholder();
        return (T) this;
    }

    @Override
    public T unfocus() {
        inputElement.classList.remove("fc-" + focusColor.getStyle());
        if (!floating && isEmpty()) {
            labelElement.classList.remove("focused");
        }
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
        return inputElement.classList.contains("focused");
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

    public T setLeftAddon(Element leftAddon) {
        setAddon(leftAddonContainer, this.leftAddon, leftAddon);
        this.leftAddon = leftAddon;
        return (T) this;
    }

    public T setRightAddon(Element rightAddon) {
        setAddon(rightAddonContainer, this.rightAddon, rightAddon);
        this.rightAddon = rightAddon;
        return (T) this;
    }

    private void setAddon(HTMLElement container, Element oldAddon, Element addon) {
        if (oldAddon != null) {
            container.removeChild(oldAddon);
        }
        addon.classList.add("input-addon");
        container.appendChild(addon);
        setAddonSize(addon, size);
    }

    private void setAddonSize(Element addon, ValueBoxSize size) {
        if (addon != null && !size.sizeValue.isEmpty()) {
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
        inputElement.classList.remove("fc-" + Color.RED.getStyle());
        removeLabelColor(Color.RED);
        removeLeftAddonColor(Color.RED);
        setFocusColor(focusColor);
        return super.clearInvalid();
    }
}
