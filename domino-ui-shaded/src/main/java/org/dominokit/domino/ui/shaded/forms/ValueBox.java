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
package org.dominokit.domino.ui.shaded.forms;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.shaded.keyboard.KeyboardEvents.*;
import static org.jboss.elemento.Elements.label;
import static org.jboss.elemento.Elements.span;

import elemental2.dom.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import jsinterop.base.Js;
import org.dominokit.domino.ui.shaded.grid.flex.FlexAlign;
import org.dominokit.domino.ui.shaded.grid.flex.FlexItem;
import org.dominokit.domino.ui.shaded.grid.flex.FlexLayout;
import org.dominokit.domino.ui.shaded.style.Color;
import org.dominokit.domino.ui.shaded.utils.DominoElement;
import org.dominokit.domino.ui.shaded.utils.DominoUIConfig;
import org.dominokit.domino.ui.shaded.utils.Focusable;
import org.dominokit.domino.ui.shaded.utils.HasChangeHandlers;
import org.dominokit.domino.ui.shaded.utils.HasPlaceHolder;
import org.dominokit.domino.ui.shaded.utils.IsReadOnly;
import org.dominokit.domino.ui.shaded.utils.LambdaFunction;
import org.gwtproject.safehtml.shared.SafeHtml;
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

  protected final EventListener changeListener;
  protected final EventListener inputListener;

  private DominoElement<E> inputElement;

  protected DominoElement<HTMLDivElement> fieldGroup = DominoElement.div().css("field-group");
  protected DominoElement<HTMLDivElement> fieldContainer = DominoElement.div().css("field-cntr");
  protected FlexItem<HTMLDivElement> inputContainer = FlexItem.create();
  private DominoElement<HTMLDivElement> notesContainer = DominoElement.div();

  private FlexLayout leftAddOnsContainer = FlexLayout.create().css("field-lft-addons");
  private FlexLayout rightAddOnsContainer = FlexLayout.create().css("field-rgt-addons");

  private FlexItem<HTMLDivElement> helpItem;
  private FlexItem<HTMLDivElement> countItem;
  private FlexItem<HTMLDivElement> errorItem;

  private FlexItem<HTMLDivElement> prefixItem = FlexItem.create().css("field-prefix");
  private FlexItem<HTMLDivElement> postFixItem = FlexItem.create().css("field-postfix");

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
  private DominoElement<HTMLDivElement> mandatoryAddOn;
  private boolean validateOnFocusLost = true;
  private FieldStyle fieldStyle = DominoUIConfig.INSTANCE.getDefaultFieldsStyle();
  private FlexLayout fieldInnerContainer;
  private boolean permaFloating = false;
  private FlexLayout additionalInfoContainer;

  private LambdaFunction noteInitializer;
  private LambdaFunction labelInitializer;

  /**
   * @param type String type of the field input element
   * @param label String
   */
  public ValueBox(String type, String label) {
    init((T) this);
    noteInitializer =
        () -> {
          initNotesContainer();
          noteInitializer = () -> {};
        };

    labelInitializer =
        () -> {
          labelElement = createLabelElement();
          DominoElement.of(Js.<HTMLElement>uncheckedCast(getInputElement().element().parentElement))
              .insertBefore(labelElement, inputElement);
          linkLabelToField();
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
          labelInitializer = () -> {};
        };
    inputElement = DominoElement.of(createInputElement(type));
    changeListener =
        evt -> {
          callChangeHandlers();
        };
    inputElement.addEventListener("change", changeListener);
    inputElement.addEventListener("change", evt -> changeLabelFloating());
    inputListener =
        evt -> {
          if (isEmpty()) {
            showPlaceholder();
          }
        };
    inputElement.addEventListener("input", inputListener);
    onEnterKey();

    layout();
    setFocusColor(focusColor);
    addFocusListeners();
    setLabel(label);
    setSpellCheck(true);
    fieldStyle.apply(this);
    DominoUIConfig.INSTANCE.getFixErrorsPosition().ifPresent(this::setFixErrorsPosition);
    DominoUIConfig.INSTANCE.getFloatLabels().ifPresent(this::setFloating);
    DominoUIConfig.INSTANCE
        .getCondensed()
        .ifPresent(
            shouldCondense -> {
              if (shouldCondense) {
                condense();
              }
            });
  }

  protected void onEnterKey() {
    listenOnKeyPress(getInputElement().element())
        .onEnter(
            evt -> {
              if (DominoUIConfig.INSTANCE.isFocusNextFieldOnEnter()) {
                getInputElement().blur();
                List<Element> elements =
                    DominoElement.body().element().querySelectorAll(".field-group").asList();
                int i = elements.indexOf(this.element());
                if (i < elements.size() - 1) {
                  Element element = elements.get(i + 1);
                  Element input = element.querySelector("input");
                  Js.<HTMLInputElement>uncheckedCast(input).focus();
                }
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

    fieldInnerContainer = FlexLayout.create().css("field-inner-cntr");
    fieldInnerContainer.appendChild(
        inputContainer.css("field-input-cntr").setFlexGrow(1).appendChild(inputElement));

    fieldGroup.appendChild(
        fieldContainer.appendChild(
            fieldInnerContainer.apply(
                self -> {
                  self.setAlignItems(FlexAlign.STRETCH);
                  mandatoryAddOn = createMandatoryAddOn();
                  if (nonNull(mandatoryAddOn)) {
                    self.appendChild(DominoElement.of(mandatoryAddOn).css("field-mandatory-addon"));
                  }
                })));
  }

  private void initNotesContainer() {
    helpItem = FlexItem.create().css("field-helper");
    errorItem = FlexItem.create().hide().css("field-errors").setFlexGrow(1);
    countItem = FlexItem.create().hide().css("field-counter");
    additionalInfoContainer = FlexLayout.create();
    notesContainer.css("notes-cntr");
    fieldGroup.appendChild(
        notesContainer
            .css("field-note")
            .appendChild(
                additionalInfoContainer
                    .appendChild(helpItem.setFlexGrow(1))
                    .appendChild(errorItem)
                    .appendChild(countItem)));
  }

  /** {@inheritDoc} */
  @Override
  public T setFixErrorsPosition(boolean fixPosition) {
    if (fixPosition) {
      getErrorItem().show();
      getErrorItem().style().setMinHeight("25px");
    } else {
      getErrorItem().style().setMinHeight("0px");
    }
    return super.setFixErrorsPosition(fixPosition);
  }

  /** this will set the attribute <b>for</b> on the label with the field id as a value */
  protected void linkLabelToField() {
    getLabelElement()
        .ifPresent(
            labelElement ->
                labelElement.setAttribute("for", DominoElement.of(getInputElement()).getId()));
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
    return DominoElement.of(label()).css("field-label");
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
    this.permaFloating = false;
    unfloatLabel();
    hidePlaceholder();
    return (T) this;
  }

  /** @return boolean, the current status of floating label */
  public boolean isFloating() {
    return floating;
  }

  /** @return the {@link FlexItem} that is added as a mandatoryAddOn */
  public DominoElement<HTMLDivElement> getMandatoryAddOn() {
    return mandatoryAddOn;
  }

  /** {@inheritDoc} */
  @Override
  public T focus() {
    if (!isDisabled()) {
      if (!isAttached()) {
        getInputElement()
            .onAttached(
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
      getInputElement()
          .onAttached(
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
      fieldGroup.addCss(FOCUSED);
      floatLabel();
      if (valid) {
        if (isAddFocusColor()) {
          fieldContainer.addCss("fc-" + focusColor.getStyle());
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
    fieldGroup.removeCss(FOCUSED);
    fieldContainer.removeCss("fc-" + focusColor.getStyle(), FOCUSED);
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
    getLabelElement().ifPresent(labelElement -> labelElement.appendChild(labelTextElement));
  }

  /** {@inheritDoc} */
  @Override
  public Optional<DominoElement<HTMLElement>> getLabelTextElement() {
    return Optional.of(labelTextElement);
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
    return fieldGroup.style().containsCss(FOCUSED);
  }

  private void setLabelColor(Color color) {
    if (nonNull(labelElement)) {
      labelElement.addCss(color.getStyle());
    }
  }

  private void removeLabelColor(Color color) {
    if (nonNull(labelElement)) {
      labelElement.removeCss(color.getStyle());
    }
  }

  /** {@inheritDoc} */
  @Override
  public T enable() {
    super.enable();
    fieldGroup.removeCss(DISABLED);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T disable() {
    super.disable();
    fieldGroup.addCss(DISABLED);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setLabel(String label) {
    if (nonNull(label) && !label.isEmpty() || allowEmptyLabel()) {
      labelInitializer.apply();
      super.setLabel(label);
      if ((getLabelTextElement().isPresent() && !getLabelTextElement().get().isEmptyElement())) {
        hidePlaceholder();
      }
    }
    return (T) this;
  }

  protected boolean allowEmptyLabel() {
    return false;
  }

  /**
   * Sets the label as a custom element
   *
   * @param node {@link Node} label element
   * @return same form element class
   */
  public T setLabel(Node node) {
    if (nonNull(node)) {
      labelInitializer.apply();
      super.setLabel(node);
    }
    return (T) this;
  }

  /**
   * Sets the label from html
   *
   * @param safeHtml {@link SafeHtml}
   * @return same form element class
   */
  public T setLabel(SafeHtml safeHtml) {
    if (nonNull(safeHtml)) {
      labelInitializer.apply();
      super.setLabel(safeHtml);
    }
    return (T) this;
  }

  /**
   * Sets the label from an element
   *
   * @param element {@link IsElement}
   * @return same form element class
   */
  public T setLabel(IsElement<?> element) {
    return setLabel(element.element());
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
    return isEmpty()
        && (floating
            || (getLabelTextElement().isPresent() && getLabelTextElement().get().isEmptyElement()));
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
    noteInitializer.apply();
    return DominoElement.of(helpItem.element());
  }

  /** {@inheritDoc} */
  @Override
  protected DominoElement<HTMLElement> getErrorsContainer() {
    noteInitializer.apply();
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
  public boolean isEmptyIgnoreSpaces() {
    return isEmpty();
  }

  /** {@inheritDoc} */
  @Override
  public String getStringValue() {
    return null;
  }

  /** {@inheritDoc} */
  @Override
  public Optional<DominoElement<HTMLLabelElement>> getLabelElement() {
    if (nonNull(labelElement)) {
      return Optional.of(DominoElement.of(labelElement));
    }
    return Optional.empty();
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
    DominoUIConfig.INSTANCE
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
    DominoUIConfig.INSTANCE.getGlobalValidationHandler().onInvalidate(this, errorMessages);
    return super.invalidate(errorMessages);
  }

  private void updateValidationStyles() {
    fieldContainer.removeCss("fc-" + focusColor.getStyle());
    fieldContainer.addCss("fc-" + Color.RED.getStyle());
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
    fieldContainer.addCss("fc-" + focusColor.getStyle());
    fieldContainer.removeCss("fc-" + Color.RED.getStyle());
    removeLabelColor(Color.RED);
    if (isFocused()) {
      doFocus();
    } else {
      doUnfocus();
    }
    changeLabelFloating();
    DominoUIConfig.INSTANCE.getGlobalValidationHandler().onClearValidation(this);
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
    return clear(false);
  }

  /** {@inheritDoc} */
  @Override
  public T clear(boolean silent) {
    clearValue(silent);
    autoValidate();
    onClearHandlers.forEach(handler -> handler.accept((T) ValueBox.this));
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T value(V value) {
    return value(value, false);
  }

  /** {@inheritDoc} */
  @Override
  public T value(V value, boolean silent) {
    doSetValue(value);
    changeLabelFloating();
    autoValidate();
    if (!silent) {
      callChangeHandlers();
    }
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T setReadOnly(boolean readOnly) {
    this.readOnly = readOnly;
    if (readOnly) {
      getInputElement().setAttribute("readonly", "true");
      getInputElement().setAttribute(FLOATING, permaFloating);
      css("readonly");
      floating();
    } else {
      getInputElement().removeAttribute("readonly");
      removeCss("readonly");
      boolean floating;
      if (getInputElement().hasAttribute(FLOATING)) {
        floating = Boolean.parseBoolean(getInputElement().getAttribute(FLOATING));
      } else {
        floating = permaFloating;
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
      if (!fieldGroup.containsCss(FLOATING)) {
        fieldGroup.addCss(FLOATING);
      }
      this.floating = true;
    }
  }

  /** unfloat a floating label */
  protected void unfloatLabel() {
    if ((floating && !permaFloating) && isEmpty()) {
      fieldGroup.removeCss(FLOATING);
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
    noteInitializer.apply();
    return notesContainer;
  }

  /** {@inheritDoc} */
  @Override
  public DominoElement<HTMLDivElement> getAdditionalInfoContainer() {
    noteInitializer.apply();
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
    noteInitializer.apply();
    return helpItem;
  }

  /** @return the {@link FlexItem} that contains the character count for this component */
  public FlexItem getCountItem() {
    noteInitializer.apply();
    return countItem;
  }

  /** @return the {@link FlexItem} that contains the error messages for this component */
  public FlexItem getErrorItem() {
    noteInitializer.apply();
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
  protected void clearValue() {
    clearValue(false);
  };

  /** clear the field value */
  protected abstract void clearValue(boolean silent);

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
  protected DominoElement<HTMLDivElement> createMandatoryAddOn() {
    return null;
  }

  /** Implementations of this interface will apply the validations for a component */
  @Deprecated
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
