package org.dominokit.domino.ui.forms;

import elemental2.dom.*;
import org.dominokit.domino.ui.grid.flex.FlexDirection;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.*;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.label;

public abstract class ValueBox<T extends ValueBox<T, E, V>, E extends HTMLElement, V> extends BasicFormElement<T, V> implements
        Focusable<T>, HasPlaceHolder<T>, IsReadOnly<T>, HasChangeHandlers<T, V> {

    public static final String FOCUSED = "focused";
    public static final String FLOATING = "floating";
    public static final String DISABLED = "disabled";

    private DominoElement<E> inputElement;

    protected DominoElement<HTMLDivElement> fieldGroup = DominoElement.div();
    protected DominoElement<HTMLDivElement> fieldContainer = DominoElement.div();
    protected FlexItem inputContainer = FlexItem.create();
    private DominoElement<HTMLDivElement> notesContainer = DominoElement.div();

    private FlexLayout leftAddOnsContainer = FlexLayout.create();
    private FlexLayout rightAddOnsContainer = FlexLayout.create();

    private FlexItem helpItem = FlexItem.create();
    private FlexItem countItem = FlexItem.create();
    private FlexItem errorItem = FlexItem.create();

    private FlexItem prefixItem = FlexItem.create();
    private FlexItem postFixItem = FlexItem.create();

    private DominoElement<HTMLLabelElement> labelElement = DominoElement.of(label().css("field-label"));

    private Color focusColor = Color.BLUE;
    private String placeholder;
    private EventListener changeEventListener;
    private List<ChangeHandler<? super V>> changeHandlers = new ArrayList<>();
    private final List<Consumer<T>> onClearHandlers = new ArrayList<>();

    private boolean pauseChangeHandlers = false;
    private boolean valid = true;
    private boolean floating;
    private boolean readOnly;
    private boolean focused;
    private String prefix;
    private String postfix;

    public ValueBox(String type, String label) {
        init((T) this);
        inputElement = DominoElement.of(createInputElement(type));
        inputElement.addEventListener("change", evt -> callChangeHandlers());
        labelElement.setTextContent(label);
        layout();
        setFocusColor(focusColor);
        addFocusListeners();
        setLabel(label);
        setSpellCheck(true);
    }

    private void layout() {
        fieldGroup.css("field-group");
        fieldContainer
                .css("field-cntr");
        notesContainer
                .css("notes-cntr");

        leftAddOnsContainer
                .css("field-lft-addons");
        rightAddOnsContainer
                .css("field-rgt-addons");

        fieldGroup
                .appendChild(fieldContainer
                        .appendChild(FlexLayout.create()
                                .appendChild(leftAddOnsContainer)
                                .appendChild(prefixItem
                                        .css("field-prefix")
                                )
                                .appendChild(inputContainer
                                        .css("field-input-cntr")
                                        .setFlexGrow(1)
                                        .appendChild(inputElement)
                                        .appendChild(labelElement)
                                )
                                .appendChild(postFixItem
                                        .css("field-postfix")
                                )
                                .apply(self -> {
                                    FlexItem mandatoryAddOn = createMandatoryAddOn();
                                    if (nonNull(mandatoryAddOn)) {
                                        self.appendChild(mandatoryAddOn);
                                    }
                                })
                                .appendChild(rightAddOnsContainer)
                        )
                )
                .appendChild(notesContainer
                        .css("field-note")
                        .appendChild(FlexLayout.create()
                                .appendChild(helpItem
                                        .css("field-helper")
                                        .setFlexGrow(1)
                                )
                                .appendChild(errorItem
                                        .hide()
                                        .css("field-errors")
                                        .setFlexGrow(1)
                                )
                                .appendChild(countItem
                                        .css("field-counter")
                                )
                        )
                );
    }

    protected void callChangeHandlers() {
        if (!pauseChangeHandlers) {
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
        labelElement.addEventListener("click", evt -> focus());
    }

    public T setFloating(boolean floating) {
        if (floating) {
            floating();
        } else {
            nonfloating();
        }
        return (T) this;
    }

    public T floating() {
        fieldGroup.style().add(FLOATING);
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
        return floating;
    }

    @Override
    public T focus() {
        if (!isAttached()) {
            ElementUtil.onAttach(getInputElement(), mutationRecord -> {
                getInputElement().asElement().focus();
                doFocus();
            });
        } else {
            getInputElement().asElement().focus();
            doFocus();
        }
        return (T) this;
    }

    @Override
    public T unfocus() {
        if (!isAttached()) {
            ElementUtil.onAttach(getInputElement(), mutationRecord -> {
                getInputElement().asElement().blur();
                doUnfocus();
            });
        } else {
            getInputElement().asElement().blur();
            doUnfocus();
        }
        return (T) this;
    }

    protected void doFocus() {
        fieldGroup.style().add(FOCUSED);
        floatLabel();
        if (valid) {
            fieldContainer.style().add("fc-" + focusColor.getStyle());
            setLabelColor(focusColor);
        }
        showPlaceholder();
    }

    protected void doUnfocus() {
        fieldGroup.style().remove(FOCUSED);
        fieldContainer.style().remove("fc-" + focusColor.getStyle(), FOCUSED);
        unfloatLabel();
        removeLabelColor(focusColor);
        hidePlaceholder();
    }

    @Override
    public boolean isFocused() {
        return fieldGroup.style().contains(FOCUSED);
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
        fieldGroup.style().remove(DISABLED);
        return (T) this;
    }

    @Override
    public T disable() {
        super.disable();
        fieldGroup.style().add(DISABLED);
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
        }
        this.focusColor = focusColor;
        return (T) this;
    }

    @Override
    public DominoElement<HTMLDivElement> getFieldContainer() {
        return DominoElement.of(inputContainer);
    }

    /**
     * @param icon
     * @return
     * @deprecated use {@link #addLeftAddOn(FlexItem)}
     */
    @Deprecated
    public T setIcon(BaseIcon<?> icon) {
        return setLeftAddon(icon.asElement());
    }

    /**
     * @param leftAddon
     * @return
     * @deprecated use {@link #addLeftAddOn(FlexItem)}
     */
    @Deprecated
    public T setLeftAddon(IsElement leftAddon) {
        return addLeftAddOn(FlexItem.create().appendChild(leftAddon.asElement()));
    }

    /**
     * @param leftAddon
     * @return
     * @deprecated use {@link #addLeftAddOn(FlexItem)}
     */
    @Deprecated
    public T setLeftAddon(Element leftAddon) {
        return addLeftAddOn(FlexItem.create().appendChild(leftAddon));
    }

    public T addLeftAddOn(FlexItem addon) {
        leftAddOnsContainer.appendChild(addon);
        return (T) this;
    }

    public T addLeftAddOn(IsElement<?> addon) {
        leftAddOnsContainer.appendChild(FlexItem.create().appendChild(addon));
        return (T) this;
    }

    public T addLeftAddOn(Node addon) {
        leftAddOnsContainer.appendChild(FlexItem.create().appendChild(addon));
        return (T) this;
    }

    /**
     * @param rightAddon
     * @return
     * @deprecated use {@link #addRightAddOn(FlexItem)}
     */
    @Deprecated
    public T setRightAddon(IsElement rightAddon) {
        return addRightAddOn(FlexItem.create().appendChild(rightAddon.asElement()));
    }

    /**
     * @param rightAddon
     * @return
     * @deprecated use {@link #addRightAddOn(FlexItem)}
     */
    @Deprecated
    public T setRightAddon(Element rightAddon) {
        return addRightAddOn(FlexItem.create().appendChild(rightAddon));
    }

    public T addRightAddOn(FlexItem addon) {
        rightAddOnsContainer.appendChild(addon);
        return (T) this;
    }

    public T addRightAddOn(IsElement<?> addon) {
        rightAddOnsContainer.appendChild(FlexItem.create().appendChild(addon));
        return (T) this;
    }

    public T addRightAddOn(Node addon) {
        rightAddOnsContainer.appendChild(FlexItem.create().appendChild(addon));
        return (T) this;
    }

    @Override
    public DominoElement<E> getInputElement() {
        return DominoElement.of(inputElement);
    }

    @Override
    protected DominoElement<HTMLElement> getHelperContainer() {
        return DominoElement.of(helpItem.asElement());
    }

    @Override
    public V getValue() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public String getStringValue() {
        return null;
    }

    @Override
    public DominoElement<HTMLLabelElement> getLabelElement() {
        return DominoElement.of(labelElement);
    }

    @Override
    public HTMLElement asElement() {
        return fieldGroup.asElement();
    }

    @Override
    public T invalidate(String errorMessage) {
        this.valid = false;
        updateValidationStyles();
        return super.invalidate(errorMessage);
    }

    @Override
    public T invalidate(List<String> errorMessages) {
        this.valid = false;
        updateValidationStyles();
        return super.invalidate(errorMessages);
    }

    private void updateValidationStyles() {
        inputElement.style().remove("fc-" + focusColor.getStyle());
        inputElement.style().add("fc-" + Color.RED.getStyle());
        removeLabelColor(focusColor);
        setLabelColor(Color.RED);
        changeLabelFloating();
    }

    @Override
    public T clearInvalid() {
        this.valid = true;
        inputElement.style().add("fc-" + focusColor.getStyle());
        inputElement.style().remove("fc-" + Color.RED.getStyle());
        removeLabelColor(Color.RED);
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
        onClearHandlers.forEach(handler -> handler.accept((T) ValueBox.this));
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
            getInputElement().setAttribute(DISABLED, "true");
            getInputElement().setAttribute("readonly", "true");
            getInputElement().setAttribute(FLOATING, isFloating());
            css("readonly");
            floating();
        } else {
            getInputElement().removeAttribute(DISABLED);
            getInputElement().removeAttribute("readonly");
            removeCss("readonly");
            boolean floating;
            if (getInputElement().hasAttribute(FLOATING)) {
                floating = Boolean.parseBoolean(getInputElement().getAttribute(FLOATING));
            } else {
                floating = isFloating();
            }
            setFloating(floating);
            changeLabelFloating();
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
            fieldGroup.style().add(FLOATING);
        }
    }

    protected void unfloatLabel() {
        if (!floating && isEmpty()) {
            fieldGroup.style().remove(FLOATING);
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

    public T setPauseChangeHandlers(boolean pauseChangeHandlers) {
        this.pauseChangeHandlers = pauseChangeHandlers;
        return (T) this;
    }

    public T pauseChangeHandlers() {
        return setPauseChangeHandlers(true);
    }

    public T resumeChangeHandlers() {
        return setPauseChangeHandlers(false);
    }

    public FlexLayout getLeftAddonContainer() {
        return leftAddOnsContainer;
    }

    public FlexLayout getRightAddonContainer() {
        return rightAddOnsContainer;
    }

    @Override
    public boolean hasChangeHandler(ChangeHandler<? super V> changeHandler) {
        return changeHandlers.contains(changeHandler);
    }

    public T setSpellCheck(boolean spellCheck) {
        inputElement.setAttribute("spellcheck", spellCheck);
        return (T) this;
    }

    public T addOnClearHandler(Consumer<T> onClearHandler) {
        this.onClearHandlers.add(onClearHandler);
        return (T) this;
    }

    public T removeOnClearHandler(Consumer<T> onClearHandler) {
        this.onClearHandlers.remove(onClearHandler);
        return (T) this;
    }

    public List<Consumer<T>> getOnClearHandlers() {
        return new ArrayList<>(onClearHandlers);
    }

    public T setPrefix(String prefix) {
        this.prefixItem.setTextContent(prefix);
        this.prefix = prefix;
        return (T) this;
    }

    public String getPrefix() {
        return prefix;
    }

    public T setPostFix(String postfix) {
        this.postFixItem.setTextContent(postfix);
        this.postfix = postfix;
        return (T) this;
    }

    public DominoElement<HTMLDivElement> getFieldGroup() {
        return fieldGroup;
    }

    public FlexItem getInputContainer() {
        return inputContainer;
    }

    public DominoElement<HTMLDivElement> getNotesContainer() {
        return notesContainer;
    }

    public FlexLayout getLeftAddOnsContainer() {
        return leftAddOnsContainer;
    }

    public FlexLayout getRightAddOnsContainer() {
        return rightAddOnsContainer;
    }

    public FlexItem getHelpItem() {
        return helpItem;
    }

    public FlexItem getCountItem() {
        return countItem;
    }

    public FlexItem getErrorItem() {
        return errorItem;
    }

    public FlexItem getPrefixItem() {
        return prefixItem;
    }

    public FlexItem getPostFixItem() {
        return postFixItem;
    }

    public Color getFocusColor() {
        return focusColor;
    }

    public String getPostfix() {
        return postfix;
    }

    protected abstract void clearValue();

    protected abstract void doSetValue(V value);

    protected FlexItem createMandatoryAddOn() {
        return null;
    }
}
