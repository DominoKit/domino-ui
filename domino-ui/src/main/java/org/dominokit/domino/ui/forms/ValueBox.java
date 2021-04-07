/*
 * Copyright © 2019 Dominokit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dominokit.domino.ui.forms;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.label;
import static org.jboss.elemento.Elements.span;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLabelElement;
import elemental2.dom.Node;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.*;
import org.jboss.elemento.IsElement;

/**
 * A base implementation for form elements that can have a value with extra features like focus,
 * placeholders, change handlers
 *
 * @param <T> The type of the component extending form this class
 * @param <E> The type of the HTML element that represent the root element of the component
 * @param <V> The type of the component value
 */
public abstract class ValueBox<T extends ValueBox<T, E, V>, E extends HTMLElement, V>
    extends BasicFormElement<T, V>
    implements Focusable<T>, HasPlaceHolder<T>, IsReadOnly<T>, HasChangeHandlers<T, V> {

  /** Constant css class name for a focused component */
  public static final String FOCUSED = "focused";

  /** Constant css class name for a component that has its labels floating above it */
  public static final String FLOATING = "floating";

  /** Constant css class name for a focused component */
  public static final String DISABLED = "disabled";

  private DominoElement<E> inputElement;

  protected DominoElement<HTMLDivElement> fieldGroup = DominoElement.div();
  protected DominoElement<HTMLDivElement> fieldContainer = DominoElement.div();
  protected FlexItem<HTMLDivElement> inputContainer = FlexItem.create();
  private DominoElement<HTMLDivElement> notesContainer = DominoElement.div();

  private FlexLayout leftAddOnsContainer = FlexLayout.create();
  private FlexLayout rightAddOnsContainer = FlexLayout.create();

  private FlexItem<HTMLDivElement> helpItem;
  private FlexItem<HTMLDivElement> countItem;
  private FlexItem<HTMLDivElement> errorItem;

  private FlexItem<HTMLDivElement> prefixItem = FlexItem.create();
  private FlexItem<HTMLDivElement> postFixItem = FlexItem.create();

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
  private FlexItem<HTMLDivElement> mandatoryAddOn;
  private boolean validateOnFocusLost = true;
  private FieldStyle fieldStyle = DominoFields.INSTANCE.getDefaultFieldsStyle();
  private FlexLayout fieldInnerContainer;
  private boolean permaFloating = false;
  private FlexLayout additionalInfoContainer;

  /**
   * @param type String type of the field input element
   * @param label String
   */
  public ValueBox(String type, String label) {
    helpItem = FlexItem.create();
    countItem = FlexItem.create().hide();
    errorItem = FlexItem.create();
    labelElement = createLabelElement();

    init((T) this);
    inputElement = DominoElement.of(createInputElement(type));
    inputElement.addEventListener(
        "change",
        evt -> {
          callChangeHandlers();
        });
    inputElement.addEventListener(
        "input",
        evt -> {
          if (isEmpty()) {
            showPlaceholder();
          }
        });

    layout();
    setFocusColor(focusColor);
    addFocusListeners();
    setLabel(label);
    setSpellCheck(true);
    fieldStyle.apply(this);
    DominoFields.INSTANCE.getFixErrorsPosition().ifPresent(this::setFixErrorsPosition);
    DominoFields.INSTANCE.getFloatLabels().ifPresent(this::setFloating);
    DominoFields.INSTANCE
        .getCondensed()
        .ifPresent(
            shouldCondense -> {
              if (shouldCondense) {
                condense();
              }
            });
  }

  /** @return the {@link FieldStyle} */
  public FieldStyle getFieldStyle() {
    return fieldStyle;
  }

  /**
   * Change the style of the field
   *
   * @param fieldStyle {@link FieldStyle}
   * @return same implementing component
   */
  public T setFieldStyle(FieldStyle fieldStyle) {
    if (nonNull(fieldStyle)) {
      fieldStyle.apply(this);
      this.fieldStyle = fieldStyle;
    }

    return (T) this;
  }

  private void layout() {
    fieldGroup.css("field-group");
    fieldContainer.css("field-cntr");
    notesContainer.css("notes-cntr");

    leftAddOnsContainer.css("field-lft-addons");
    rightAddOnsContainer.css("field-rgt-addons");

    prefixItem.css("field-prefix");
    postFixItem.css("field-postfix");

    linkLabelToField();

    fieldInnerContainer = FlexLayout.create();
    additionalInfoContainer = FlexLayout.create();
    fieldGroup
        .appendChild(
            fieldContainer.appendChild(
                fieldInnerContainer
                    .appendChild(
                        inputContainer
                            .css("field-input-cntr")
                            .setFlexGrow(1)
                            .appendChild(labelElement)
                            .appendChild(inputElement))
                    .apply(
                        self -> {
                          mandatoryAddOn = createMandatoryAddOn();
                          if (nonNull(mandatoryAddOn)) {
                            self.appendChild(mandatoryAddOn.css("field-mandatory-addon"));
                          }
                        })))
        .appendChild(
            notesContainer
                .css("field-note")
                .appendChild(
                    additionalInfoContainer
                        .appendChild(helpItem.css("field-helper").setFlexGrow(1))
                        .appendChild(errorItem.hide().css("field-errors").setFlexGrow(1))
                        .appendChild(countItem.css("field-counter"))));
  }

  /** {@inheritDoc} */
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

  /** this will set the attribute <b>for</b> on the label with the field id as a value */
  protected void linkLabelToField() {
    if (!inputElement.hasAttribute("id")) {
      inputElement.setAttribute("id", inputElement.getAttribute(BaseDominoElement.DOMINO_UUID));
    }
    labelElement.setAttribute("for", inputElement.getAttribute("id"));
  }

  /** manually call the change handlers if they are not paused */
  protected void callChangeHandlers() {
    if (!pauseChangeHandlers) {
      changeHandlers.forEach(changeHandler -> changeHandler.onValueChanged(getValue()));
    }
  }

  /**
   * create the label element for this component
   *
   * @return an {@link HTMLLabelElement} wrapped as {@link DominoElement}
   */
  protected DominoElement<HTMLLabelElement> createLabelElement() {
    return DominoElement.of(label().css("field-label"));
  }

  /**
   * Creates an input element with the specified type
   *
   * @param type String the input element type
   * @return E the input html element
   */
  protected abstract E createInputElement(String type);

  private void addFocusListeners() {
    inputElement.addEventListener("focus", evt -> doFocus());
    inputElement.addEventListener(
        "focusout",
        evt -> {
          doUnfocus();
          if (isAutoValidation() && validateOnFocusLost) {
            validate();
          }
        });
    labelElement.addEventListener(
        "click",
        evt -> {
          if (!isDisabled()) {
            focus();
          } else {
            evt.stopPropagation();
            evt.preventDefault();
          }
        });
  }

  /**
   * @param floating boolean, if true delegate to {@link #floating()} otherwise delegate to {@link
   *     #nonfloating()}
   * @return same component instance
   */
  public T setFloating(boolean floating) {
    if (floating) {
      floating();
    } else {
      nonfloating();
    }
    return (T) this;
  }

  /**
   * Make the label always floating over the field even if the value is empty
   *
   * @return same component instance
   */
  public T floating() {
    floatLabel();
    this.permaFloating = true;
    showPlaceholder();
    return (T) this;
  }

  /**
   * Make the label floating over the field only when it has value
   *
   * @return same component instance
   */
  public T nonfloating() {
    unfloatLabel();
    this.permaFloating = false;
    hidePlaceholder();
    return (T) this;
  }

  /** @return boolean, the current status of floating label */
  public boolean isFloating() {
    return floating;
  }

  /** @return the {@link FlexItem} that is added as a mandatoryAddOn */
  public FlexItem getMandatoryAddOn() {
    return mandatoryAddOn;
  }

  /** {@inheritDoc} */
  @Override
  public T focus() {
    if (!isDisabled()) {
      if (!isAttached()) {
        ElementUtil.onAttach(
            getInputElement(),
            mutationRecord -> {
              tryFocus();
            });
      } else {
        tryFocus();
      }
    }
    return (T) this;
  }

  private void tryFocus() {
    getInputElement().element().focus();
    doFocus();
  }

  /** {@inheritDoc} */
  @Override
  public T unfocus() {
    if (!isAttached()) {
      ElementUtil.onAttach(
          getInputElement(),
          mutationRecord -> {
            getInputElement().element().blur();
            doUnfocus();
          });
    } else {
      getInputElement().element().blur();
      doUnfocus();
    }
    return (T) this;
  }

  /** Focus the element and apply focus styles */
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

  /** @return boolean, true if the field will add a focus color when focused, default to true */
  protected boolean isAddFocusColor() {
    return true;
  }

  /** un-focus the component and remove the focus styles */
  protected void doUnfocus() {
    fieldGroup.style().remove(FOCUSED);
    fieldContainer.style().remove("fc-" + focusColor.getStyle(), FOCUSED);
    unfloatLabel();
    removeLabelColor(focusColor);
    hidePlaceholder();
  }

  /** {@inheritDoc} */
  @Override
  protected void updateLabel(String label) {
    if (isNull(labelTextElement)) {
      labelTextElement = DominoElement.of(span());
    }
    labelTextElement.remove();
    labelTextElement.setTextContent(label);
    getLabelElement().appendChild(labelTextElement);
  }

  /** {@inheritDoc} */
  @Override
  public DominoElement<HTMLElement> getLabelTextElement() {
    return labelTextElement;
  }

  /** @return same component instance */
  public T hideLabelText() {
    this.labelTextElement.hide();
    return (T) this;
  }

  /** @return same component instance */
  public T showLabelText() {
    this.labelTextElement.show();
    return (T) this;
  }

  /**
   * Show/hide the label element text
   *
   * @param visible boolean
   * @return same component instance
   */
  public T setLabelTextVisible(boolean visible) {
    this.labelTextElement.toggleDisplay(visible);
    return (T) this;
  }

  /** {@inheritDoc} */
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

  /** {@inheritDoc} */
  @Override
  public T enable() {
    super.enable();
    fieldGroup.style().remove(DISABLED);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T disable() {
    super.disable();
    fieldGroup.style().add(DISABLED);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setLabel(String label) {
    super.setLabel(label);
    hidePlaceholder();
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setPlaceholder(String placeholder) {
    this.placeholder = placeholder;
    showPlaceholder();
    return (T) this;
  }

  protected void showPlaceholder() {
    if (placeholder != null && shouldShowPlaceholder()) {
      inputElement.setAttribute("placeholder", placeholder);
    }
  }

  protected void hidePlaceholder() {
    if (placeholder != null && !shouldShowPlaceholder()) {
      inputElement.removeAttribute("placeholder");
    }
  }

  protected boolean shouldShowPlaceholder() {
    return isEmpty() && floating;
  }

  /** {@inheritDoc} */
  @Override
  public String getPlaceholder() {
    return this.placeholder;
  }

  /** {@inheritDoc} */
  @Override
  public T setFocusColor(Color focusColor) {
    removeLabelColor(this.focusColor);
    if (isFocused()) {
      setLabelColor(focusColor);
    }
    this.focusColor = focusColor;
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public DominoElement<HTMLDivElement> getFieldInputContainer() {
    return DominoElement.of(inputContainer);
  }

  /** {@inheritDoc} */
  @Override
  public DominoElement<HTMLDivElement> getFieldContainer() {
    return DominoElement.of(fieldContainer);
  }

  /**
   * Adds an element as an add on to the component at left side
   *
   * @param addon {@link FlexItem} that contains the add on element
   * @return same component instance
   */
  public T addLeftAddOn(FlexItem<?> addon) {
    leftAddOnsContainer.appendChild(addon);
    if (!leftAddOnsContainer.isAttached()) {
      fieldInnerContainer.insertFirst(leftAddOnsContainer);
    }
    return (T) this;
  }

  /**
   * wrap the element in a {@link FlexItem} and delegate to {@link #addLeftAddOn(FlexItem)}
   *
   * @param addon {@link IsElement}
   * @return same component instance
   */
  public T addLeftAddOn(IsElement<?> addon) {
    return addLeftAddOn(FlexItem.create().appendChild(addon));
  }

  /**
   * wrap the node in a {@link FlexItem} and delegate to {@link #addLeftAddOn(FlexItem)}
   *
   * @param addon {@link IsElement}
   * @return same component instance
   */
  public T addLeftAddOn(Node addon) {
    return addLeftAddOn(FlexItem.create().appendChild(addon));
  }

  /**
   * Adds an element as an add on to the component at left side
   *
   * @param rightAddon {@link FlexItem} that contains the add on element
   * @return same component instance
   */
  public T addRightAddOn(FlexItem<?> rightAddon) {
    rightAddOnsContainer.appendChild(rightAddon);
    if (!rightAddOnsContainer.isAttached()) {
      fieldInnerContainer.appendChild(rightAddOnsContainer);
    }
    return (T) this;
  }

  /**
   * wrap the element in a {@link FlexItem} and delegate to {@link #addRightAddOn(FlexItem)}
   *
   * @param addon {@link IsElement}
   * @return same component instance
   */
  public T addRightAddOn(IsElement<?> addon) {
    addRightAddOn(FlexItem.create().appendChild(addon));
    return (T) this;
  }

  /**
   * wrap the node in a {@link FlexItem} and delegate to {@link #addRightAddOn(FlexItem)}
   *
   * @param addon {@link IsElement}
   * @return same component instance
   */
  public T addRightAddOn(Node addon) {
    addRightAddOn(FlexItem.create().appendChild(addon));
    return (T) this;
  }

  /**
   * @param addon {@link FlexItem}
   * @return same component instance
   */
  public T removeRightAddOn(FlexItem addon) {
    return removeRightAddOn(addon.element());
  }

  /**
   * @param addon {@link IsElement}
   * @return same component instance
   */
  public T removeRightAddOn(IsElement<?> addon) {
    return removeRightAddOn(addon.element());
  }

  /**
   * @param addon {@link Node}
   * @return same component instance
   */
  public T removeRightAddOn(Node addon) {
    return removeAddOn(rightAddOnsContainer, addon);
  }

  /**
   * @param index int index of the addon to remove
   * @return same component instance
   */
  public T removeRightAddOn(int index) {
    if (index >= 0 && index < rightAddOnsContainer.childNodes().length) {
      return removeAddOn(rightAddOnsContainer, rightAddOnsContainer.childNodes().getAt(index));
    }
    return (T) this;
  }

  /**
   * @param addon {@link FlexItem}
   * @return same component instance
   */
  public T removeLeftAddOn(FlexItem addon) {
    return removeLeftAddOn(addon.element());
  }

  /**
   * @param addon {@link IsElement}
   * @return same component instance
   */
  public T removeLeftAddOn(IsElement<?> addon) {
    return removeLeftAddOn(addon.element());
  }

  /**
   * @param addon {@link Node}
   * @return same component instance
   */
  public T removeLeftAddOn(Node addon) {
    return removeAddOn(leftAddOnsContainer, addon);
  }

  /**
   * @param index int index of the addon to remove
   * @return same component instance
   */
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

  /**
   * Remove all right addons
   *
   * @return same component instance
   */
  public T removeRightAddOns() {
    rightAddOnsContainer.clearElement();
    return (T) this;
  }

  /**
   * Remove all left addons
   *
   * @return same component instance
   */
  public T removeLeftAddOns() {
    leftAddOnsContainer.clearElement();
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public DominoElement<E> getInputElement() {
    return DominoElement.of(inputElement);
  }

  /** {@inheritDoc} */
  @Override
  protected DominoElement<HTMLElement> getHelperContainer() {
    return DominoElement.of(helpItem.element());
  }

  /** {@inheritDoc} */
  @Override
  protected DominoElement<HTMLElement> getErrorsContainer() {
    return DominoElement.of(errorItem.element());
  }

  /** {@inheritDoc} */
  @Override
  public V getValue() {
    return null;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isEmpty() {
    return false;
  }

  /** {@inheritDoc} */
  @Override
  public String getStringValue() {
    return null;
  }

  /** {@inheritDoc} */
  @Override
  public DominoElement<HTMLLabelElement> getLabelElement() {
    return DominoElement.of(labelElement);
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return fieldGroup.element();
  }

  /** {@inheritDoc} */
  @Override
  public T invalidate(String errorMessage) {
    this.valid = false;
    updateValidationStyles();
    DominoFields.INSTANCE
        .getGlobalValidationHandler()
        .onInvalidate(this, Collections.singletonList(errorMessage));
    return super.invalidate(errorMessage);
  }

  /**
   * flag the field to be used inside a table row
   *
   * @return same component instance
   */
  public T asTableField() {
    setTableField(true);
    return (T) this;
  }

  /**
   * based on the flag styles will be added or removed to make inside or outside of a table row
   *
   * @param asTableField boolean, if true adds the styles, otherwise removes them
   * @return same component instance
   */
  public T setTableField(boolean asTableField) {
    if (asTableField) {
      css("table-field");
    } else {
      removeCss("table-field");
    }
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T invalidate(List<String> errorMessages) {
    this.valid = false;
    updateValidationStyles();
    DominoFields.INSTANCE.getGlobalValidationHandler().onInvalidate(this, errorMessages);
    return super.invalidate(errorMessages);
  }

  private void updateValidationStyles() {
    fieldContainer.style().remove("fc-" + focusColor.getStyle());
    fieldContainer.style().add("fc-" + Color.RED.getStyle());
    removeLabelColor(focusColor);
    setLabelColor(Color.RED);
    changeLabelFloating();
  }

  /**
   * pauses the validation when the field loses focus so they wont trigger
   *
   * @return same component instance
   */
  public T pauseFocusValidation() {
    this.validateOnFocusLost = false;
    return (T) this;
  }

  /**
   * resume the validation when the field loses focus so they trigger
   *
   * @return same component instance
   */
  public T resumeFocusValidation() {
    this.validateOnFocusLost = true;
    return (T) this;
  }

  /** {@inheritDoc} */
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
    DominoFields.INSTANCE.getGlobalValidationHandler().onClearValidation(this);
    return super.clearInvalid();
  }

  /** {@inheritDoc} */
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

  /** {@inheritDoc} */
  @Override
  public boolean isAutoValidation() {
    return nonNull(autoValidator);
  }

  /**
   * Create an AutoValidator that will automatically validate the component when it loses focus
   *
   * @param autoValidate {@link AutoValidate}
   * @return same component instance
   */
  protected abstract AutoValidator createAutoValidator(AutoValidate autoValidate);

  /** {@inheritDoc} */
  @Override
  public T clear() {
    clearValue();
    autoValidate();
    onClearHandlers.forEach(handler -> handler.accept((T) ValueBox.this));
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T value(V value) {
    doSetValue(value);
    changeLabelFloating();
    autoValidate();
    callChangeHandlers();
    return (T) this;
  }

  /** {@inheritDoc} */
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

  /** {@inheritDoc} */
  @Override
  public boolean isReadOnly() {
    return readOnly;
  }

  /** Changes the label floating state when the field get focus or lose focus */
  protected void changeLabelFloating() {
    if (!isEmpty() || isFocused()) floatLabel();
    else unfloatLabel();
  }

  /** Make the label float over the component */
  protected void floatLabel() {
    if (!floating || permaFloating) {
      fieldGroup.style().add(FLOATING);
      this.floating = true;
    }
  }

  /** unfloat a floating label */
  protected void unfloatLabel() {
    if ((floating && !permaFloating) && isEmpty()) {
      fieldGroup.style().remove(FLOATING);
      this.floating = false;
    }
  }

  /** validate the component if auto validation is enabled */
  protected void autoValidate() {
    if (isAutoValidation()) validate();
  }

  /** {@inheritDoc} */
  @Override
  public T addChangeHandler(ChangeHandler<? super V> changeHandler) {
    changeHandlers.add(changeHandler);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T removeChangeHandler(ChangeHandler<? super V> changeHandler) {
    changeHandlers.remove(changeHandler);
    return (T) this;
  }

  /**
   * Disable/Enable change handlers
   *
   * @param pauseChangeHandlers boolean, true to pause the change handlers, false to enable them
   * @return same component instance
   */
  public T setPauseChangeHandlers(boolean pauseChangeHandlers) {
    this.pauseChangeHandlers = pauseChangeHandlers;
    return (T) this;
  }

  /**
   * Delagete to {@link #setPauseChangeHandlers(boolean)} with value true
   *
   * @return same component instance
   */
  public T pauseChangeHandlers() {
    return setPauseChangeHandlers(true);
  }

  /**
   * Delagete to {@link #setPauseChangeHandlers(boolean)} with value false
   *
   * @return same component instance
   */
  public T resumeChangeHandlers() {
    return setPauseChangeHandlers(false);
  }

  /** @return the {@link FlexLayout} element that contains all left addons */
  public FlexLayout getLeftAddonContainer() {
    return leftAddOnsContainer;
  }

  /** @return the {@link FlexLayout} element that contains all right addons */
  public FlexLayout getRightAddonContainer() {
    return rightAddOnsContainer;
  }

  /** {@inheritDoc} */
  @Override
  public boolean hasChangeHandler(ChangeHandler<? super V> changeHandler) {
    return changeHandlers.contains(changeHandler);
  }

  /**
   * Enable/Disable spellcheck for the component, sets the <b>spellcheck</b> attribute
   *
   * @param spellCheck boolean, true to enable spellcheck, false to diable it
   * @return same component instance
   */
  public T setSpellCheck(boolean spellCheck) {
    inputElement.setAttribute("spellcheck", spellCheck);
    return (T) this;
  }

  /**
   * Adds a handler that will be called when the field value is cleared
   *
   * @param onClearHandler {@link Consumer} of T
   * @return same component instance
   */
  public T addOnClearHandler(Consumer<T> onClearHandler) {
    this.onClearHandlers.add(onClearHandler);
    return (T) this;
  }

  /**
   * @param onClearHandler {@link Consumer} of T
   * @return same component instance
   */
  public T removeOnClearHandler(Consumer<T> onClearHandler) {
    this.onClearHandlers.remove(onClearHandler);
    return (T) this;
  }

  /** @return a List of the clear handler for this component */
  public List<Consumer<T>> getOnClearHandlers() {
    return new ArrayList<>(onClearHandlers);
  }

  /**
   * Adds a prefix text that will be a mandatory part of the field string value
   *
   * @param prefix String
   * @return same component instance
   */
  public T setPrefix(String prefix) {
    if (!prefixItem.isAttached()) {
      fieldInnerContainer.insertBefore(prefixItem, inputContainer);
    }
    this.prefixItem.setTextContent(prefix);
    this.prefix = prefix;
    return (T) this;
  }

  /** @return String */
  public String getPrefix() {
    return prefix;
  }

  /**
   * Adds a postfix text that will be a mandatory part of the field string value
   *
   * @param postfix String
   * @return same component instance
   */
  public T setPostFix(String postfix) {
    if (!postFixItem.isAttached()) {
      fieldInnerContainer.insertAfter(postFixItem, inputContainer);
    }
    this.postFixItem.setTextContent(postfix);
    this.postfix = postfix;

    return (T) this;
  }

  /** @return the {@link HTMLDivElement} that groups the different elements of this component */
  public DominoElement<HTMLDivElement> getFieldGroup() {
    return fieldGroup;
  }

  /** @return the {@link FlexItem} that contains the input element of this component */
  public FlexItem getInputContainer() {
    return inputContainer;
  }

  /** @return the {@link HTMLDivElement} that contains the notes of this component */
  public DominoElement<HTMLDivElement> getNotesContainer() {
    return notesContainer;
  }

  /** {@inheritDoc} */
  @Override
  public DominoElement<HTMLDivElement> getAdditionalInfoContainer() {
    return DominoElement.of(additionalInfoContainer);
  }

  /** @return the {@link FlexLayout} that contains all the left addons */
  public FlexLayout getLeftAddOnsContainer() {
    return leftAddOnsContainer;
  }

  /** @return the {@link FlexLayout} that contains all the right addons */
  public FlexLayout getRightAddOnsContainer() {
    return rightAddOnsContainer;
  }

  /** @return the {@link FlexItem} that contains the helper text of this component */
  public FlexItem getHelpItem() {
    return helpItem;
  }

  /** @return the {@link FlexItem} that contains the character count for this component */
  public FlexItem getCountItem() {
    return countItem;
  }

  /** @return the {@link FlexItem} that contains the error messages for this component */
  public FlexItem getErrorItem() {
    return errorItem;
  }

  /** @return the {@link FlexItem} that contains the prefix text for this component */
  public FlexItem getPrefixItem() {
    return prefixItem;
  }

  /** @return the {@link FlexItem} that contains the postfix for this component */
  public FlexItem getPostFixItem() {
    return postFixItem;
  }

  /** @return the {@link Color} used to indicate focus of this field */
  public Color getFocusColor() {
    return focusColor;
  }

  /** @return String */
  public String getPostfix() {
    return postfix;
  }

  /** clear the field value */
  protected abstract void clearValue();

  /** @param value V the value to set for this field */
  protected abstract void doSetValue(V value);

  /**
   * Reduces the vertical spaces for this component to reduce its height
   *
   * @return same component instance
   */
  public T condense() {
    removeCss("condensed");
    css("condensed");
    return (T) this;
  }

  /**
   * Increase the vertical spaces for this component to increase its height
   *
   * @return same component instance
   */
  public T spread() {
    removeCss("condensed");
    return (T) this;
  }

  /** @return the {@link FlexItem} that contains the mandatory addons */
  protected FlexItem createMandatoryAddOn() {
    return null;
  }

  /** Implementations of this interface will apply the validations for a component */
  public interface AutoValidate {
    /** Applies the validations */
    void apply();
  }

  /**
   * A class to wrap an {@link AutoValidate} and provide the ability to attach/remove it from a
   * component
   */
  public abstract static class AutoValidator {
    protected AutoValidate autoValidate;

    /** @param autoValidate {@link AutoValidate} */
    public AutoValidator(AutoValidate autoValidate) {
      this.autoValidate = autoValidate;
    }

    /** Attach the {@link AutoValidate} to the component */
    public abstract void attach();

    /** Remove the {@link AutoValidate} from the component */
    public abstract void remove();
  }
}
