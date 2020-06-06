package org.dominokit.domino.ui.forms;

import elemental2.dom.*;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.*;
import org.jboss.elemento.IsElement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.*;

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

    private FlexItem helpItem;
    private FlexItem countItem;
    private FlexItem errorItem;

    private FlexItem prefixItem = FlexItem.create();
    private FlexItem postFixItem = FlexItem.create();

    private DominoElement<HTMLLabelElement> labelElement;
    private DominoElement<HTMLElement> labelTextElement = DominoElement.of(span());

    private Color focusColor = Color.BLUE;
    private String placeholder;
    private AutoValidator autoValidator;
    protected List<ChangeHandler<? super V>> changeHandlers = new ArrayList<>();
    private final List<Consumer<T>> onClearHandlers = new ArrayList<>();

    private boolean pauseChangeHandlers = false;
    private boolean valid = true;
    private boolean floating;
    private boolean readOnly;
    private String prefix;
    private String postfix;
    private FlexItem mandatoryAddOn;
    private boolean validateOnFocusLost = true;
    private FieldStyle fieldStyle = DominoFields.INSTANCE.getDefaultFieldsStyle();
    private FlexLayout fieldInnerContainer;

    public ValueBox(String type, String label) {
        helpItem = FlexItem.create();
        countItem = FlexItem.create().hide();
        errorItem = FlexItem.create();
        labelElement = createLabelElement();

        init((T) this);
        inputElement = DominoElement.of(createInputElement(type));
        inputElement.addEventListener("change", evt -> callChangeHandlers());

        layout();
        setFocusColor(focusColor);
        addFocusListeners();
        setLabel(label);
        setSpellCheck(true);
        fieldStyle.apply(this);
    }

    public FieldStyle getFieldStyle() {
        return fieldStyle;
    }

    public T setFieldStyle(FieldStyle fieldStyle) {
        if (nonNull(fieldStyle)) {
            fieldStyle.apply(this);
            this.fieldStyle = fieldStyle;
        }

        return (T) this;
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

        prefixItem.css("field-prefix");
        postFixItem.css("field-postfix");

        linkLabelToField();

        fieldInnerContainer = FlexLayout.create();
        fieldGroup
                .appendChild(fieldContainer
                        .appendChild(fieldInnerContainer
                                .appendChild(inputContainer
                                        .css("field-input-cntr")
                                        .setFlexGrow(1)
                                        .appendChild(labelElement)
                                        .appendChild(inputElement)
                                )
                                .apply(self -> {
                                    mandatoryAddOn = createMandatoryAddOn();
                                    if (nonNull(mandatoryAddOn)) {
                                        self.appendChild(mandatoryAddOn.css("field-mandatory-addon"));
                                    }
                                })
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

    @Override
    public T setFixErrorsPosition(boolean fixPosition) {
        if (fixPosition) {
            errorItem.show();
            errorItem.style().setMinHeight("25px");
        } else {
            errorItem.style().setMinHeight("0px");
        }
        return super.setFixErrorsPosition(fixPosition);
    }

    protected void linkLabelToField() {
        if (!inputElement.hasAttribute("id")) {
            inputElement.setAttribute("id", inputElement.getAttribute(BaseDominoElement.DOMINO_UUID));
        }
        labelElement.setAttribute("for", inputElement.getAttribute("id"));
    }

    protected void callChangeHandlers() {
        if (!pauseChangeHandlers) {
            changeHandlers.forEach(changeHandler -> changeHandler.onValueChanged(getValue()));
        }
    }

    protected DominoElement<HTMLLabelElement> createLabelElement() {
        return DominoElement.of(label().css("field-label"));
    }

    protected abstract E createInputElement(String type);

    private void addFocusListeners() {
        inputElement.addEventListener("focus", evt -> doFocus());
        inputElement.addEventListener("focusout", evt -> {
            doUnfocus();
            if (isAutoValidation() && validateOnFocusLost) {
                validate();
            }
        });
        labelElement.addEventListener("click", evt -> {
            if (!isDisabled()) {
                focus();
            } else {
                evt.stopPropagation();
                evt.preventDefault();
            }
        });
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

    public FlexItem getMandatoryAddOn() {
        return mandatoryAddOn;
    }

    @Override
    public T focus() {
        if (!isDisabled()) {
            if (!isAttached()) {
                ElementUtil.onAttach(getInputElement(), mutationRecord -> {
                    getInputElement().element().focus();
                    doFocus();
                });
            } else {
                getInputElement().element().focus();
                doFocus();
            }
        }
        return (T) this;
    }

    @Override
    public T unfocus() {
        if (!isAttached()) {
            ElementUtil.onAttach(getInputElement(), mutationRecord -> {
                getInputElement().element().blur();
                doUnfocus();
            });
        } else {
            getInputElement().element().blur();
            doUnfocus();
        }
        return (T) this;
    }

    protected void doFocus() {
        if (!isDisabled()) {
            fieldGroup.style().add(FOCUSED);
            floatLabel();
            if (valid) {
                if (isAddFocusColor()) {
                    fieldContainer.style().add("fc-" + focusColor.getStyle());
                }
                setLabelColor(focusColor);
            }
            showPlaceholder();
        }
    }

    protected boolean isAddFocusColor() {
        return true;
    }

    protected void doUnfocus() {
        fieldGroup.style().remove(FOCUSED);
        fieldContainer.style().remove("fc-" + focusColor.getStyle(), FOCUSED);
        unfloatLabel();
        removeLabelColor(focusColor);
        hidePlaceholder();
    }

    @Override
    protected void updateLabel(String label) {
        if (isNull(labelTextElement)) {
            labelTextElement = DominoElement.of(span());
        }
        labelTextElement.remove();
        labelTextElement.setTextContent(label);
        getLabelElement().appendChild(labelTextElement);
    }

    @Override
    public DominoElement<HTMLElement> getLabelTextElement() {
        return labelTextElement;
    }

    public T hideLabelText() {
        this.labelTextElement.hide();
        return (T) this;
    }

    public T showLabelText() {
        this.labelTextElement.show();
        return (T) this;
    }

    public T setLabelTextVisible(boolean visible) {
        this.labelTextElement.toggleDisplay(visible);
        return (T) this;
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
    public DominoElement<HTMLDivElement> getFieldInputContainer() {
        return DominoElement.of(inputContainer);
    }

    @Override
    public DominoElement<HTMLDivElement> getFieldContainer() {
        return DominoElement.of(fieldContainer);
    }

    /**
     * @param icon
     * @return
     * @deprecated use {@link #addLeftAddOn(FlexItem)}
     */
    @Deprecated
    public T setIcon(BaseIcon<?> icon) {
        return setLeftAddon(icon.element());
    }

    /**
     * @param leftAddon
     * @return
     * @deprecated use {@link #addLeftAddOn(FlexItem)}
     */
    @Deprecated
    public T setLeftAddon(IsElement leftAddon) {
        return addLeftAddOn(FlexItem.create().appendChild(leftAddon.element()));
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
        if (!leftAddOnsContainer.isAttached()) {
            fieldInnerContainer.insertFirst(leftAddOnsContainer);
        }
        return (T) this;
    }

    public T addLeftAddOn(IsElement<?> addon) {
        return addLeftAddOn(FlexItem.create().appendChild(addon));
    }

    public T addLeftAddOn(Node addon) {
        return addLeftAddOn(FlexItem.create().appendChild(addon));
    }

    /**
     * @param rightAddon
     * @return
     * @deprecated use {@link #addRightAddOn(FlexItem)}
     */
    @Deprecated
    public T setRightAddon(IsElement rightAddon) {
        return addRightAddOn(FlexItem.create().appendChild(rightAddon.element()));
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

    public T addRightAddOn(FlexItem rightAddon) {
        rightAddOnsContainer.appendChild(rightAddon);
        if (!rightAddOnsContainer.isAttached()) {
            fieldInnerContainer.appendChild(rightAddOnsContainer);
        }
        return (T) this;
    }

    public T addRightAddOn(IsElement<?> addon) {
        addRightAddOn(FlexItem.create().appendChild(addon));
        return (T) this;
    }

    public T addRightAddOn(Node addon) {
        addRightAddOn(FlexItem.create().appendChild(addon));
        return (T) this;
    }

    public T removeRightAddOn(FlexItem addon) {
        return removeRightAddOn(addon.element());
    }

    public T removeRightAddOn(IsElement<?> addon) {
        return removeRightAddOn(addon.element());
    }

    public T removeRightAddOn(Node addon) {
        return removeAddOn(rightAddOnsContainer, addon);
    }

    public T removeRightAddOn(int index) {
        if (index >= 0 && index < rightAddOnsContainer.childNodes().length) {
            return removeAddOn(rightAddOnsContainer, rightAddOnsContainer.childNodes().getAt(index));
        }
        return (T) this;
    }

    public T removeLeftAddOn(FlexItem addon) {
        return removeLeftAddOn(addon.element());
    }

    public T removeLeftAddOn(IsElement<?> addon) {
        return removeLeftAddOn(addon.element());
    }

    public T removeLeftAddOn(Node addon) {
        return removeAddOn(leftAddOnsContainer, addon);
    }

    public T removeLeftAddOn(int index) {
        if (index >= 0 && index < leftAddOnsContainer.childNodes().length) {
            return removeAddOn(leftAddOnsContainer, leftAddOnsContainer.childNodes().getAt(index));
        }
        return (T) this;
    }

    private T removeAddOn(FlexLayout container, Node addon) {
        if (container.isAttached() && container.contains(addon)) {
            if (container.hasDirectChild(addon)) {
                container.removeChild(addon);
            } else {
                return removeAddOn(container, addon.parentNode);
            }
        }
        return (T) this;
    }

    public T removeRightAddOns() {
        rightAddOnsContainer.clearElement();
        return (T) this;
    }

    public T removeLeftAddOns() {
        leftAddOnsContainer.clearElement();
        return (T) this;
    }

    @Override
    public DominoElement<E> getInputElement() {
        return DominoElement.of(inputElement);
    }

    @Override
    protected DominoElement<HTMLElement> getHelperContainer() {
        return DominoElement.of(helpItem.element());
    }

    @Override
    protected DominoElement<HTMLElement> getErrorsContainer() {
        return DominoElement.of(errorItem.element());
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
    public HTMLElement element() {
        return fieldGroup.element();
    }

    @Override
    public T invalidate(String errorMessage) {
        this.valid = false;
        updateValidationStyles();
        return super.invalidate(errorMessage);
    }

    public T asTableField() {
        setTableField(true);
        return (T) this;
    }

    public T setTableField(boolean asTableField) {
        if (asTableField) {
            css("table-field");
        } else {
            removeCss("table-field");
        }
        return (T) this;
    }

    @Override
    public T invalidate(List<String> errorMessages) {
        this.valid = false;
        updateValidationStyles();
        return super.invalidate(errorMessages);
    }

    private void updateValidationStyles() {
        fieldContainer.style().remove("fc-" + focusColor.getStyle());
        fieldContainer.style().add("fc-" + Color.RED.getStyle());
        removeLabelColor(focusColor);
        setLabelColor(Color.RED);
        changeLabelFloating();
    }

    public T pauseFocusValidation() {
        this.validateOnFocusLost = false;
        return (T) this;
    }

    public T resumeFocusValidation() {
        this.validateOnFocusLost = true;
        return (T) this;
    }

    @Override
    public T clearInvalid() {
        this.valid = true;
        fieldContainer.style().add("fc-" + focusColor.getStyle());
        fieldContainer.style().remove("fc-" + Color.RED.getStyle());
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
            if (autoValidator == null) {
                autoValidator = createAutoValidator(this::validate);
            }
            autoValidator.attach();
        } else {
            if (nonNull(autoValidator)) {
                autoValidator.remove();
            }
            autoValidator = null;
        }
        return (T) this;
    }

    @Override
    public boolean isAutoValidation() {
        return nonNull(autoValidator);
    }

    protected abstract AutoValidator createAutoValidator(AutoValidate autoValidate);

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
        if (!prefixItem.isAttached()) {
            fieldInnerContainer.insertBefore(prefixItem, inputContainer);
        }
        this.prefixItem.setTextContent(prefix);
        this.prefix = prefix;
        return (T) this;
    }

    public String getPrefix() {
        return prefix;
    }

    public T setPostFix(String postfix) {
        if (!postFixItem.isAttached()) {
            fieldInnerContainer.insertAfter(postFixItem, inputContainer);
        }
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


    public T condense() {
        removeCss("condensed");
        css("condensed");
        return (T) this;
    }

    public T spread() {
        removeCss("condensed");
        return (T) this;
    }

    protected FlexItem createMandatoryAddOn() {
        return null;
    }

    public interface AutoValidate {
        void apply();
    }

    public abstract static class AutoValidator {
        protected AutoValidate autoValidate;

        public AutoValidator(AutoValidate autoValidate) {
            this.autoValidate = autoValidate;
        }

        public abstract void attach();

        public abstract void remove();
    }
}
