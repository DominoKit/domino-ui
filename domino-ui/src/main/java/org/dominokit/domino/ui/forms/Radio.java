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

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.forms.FormsStyles.*;

import elemental2.dom.*;
import java.util.LinkedHashSet;
import java.util.Set;
import jsinterop.base.Js;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.InputElement;
import org.dominokit.domino.ui.elements.LabelElement;
import org.dominokit.domino.ui.elements.SmallElement;
import org.dominokit.domino.ui.utils.*;
import org.gwtproject.editor.client.TakesValue;
import org.gwtproject.safehtml.shared.SafeHtml;

/**
 * A component that represent a single option in a {@link RadioGroup}
 *
 * @param <T> The type fo the radio value
 */
public class Radio<T> extends BaseDominoElement<HTMLDivElement, Radio<T>>
    implements HasType,
        HasValue<Radio<T>, T>,
        HasLabel<Radio<T>>,
        HasHelperText<Radio<T>>,
        AcceptDisable<Radio<T>>,
        AcceptReadOnly<Radio<T>>,
        Checkable<Radio<T>>,
        TakesValue<T>,
        HasChangeListeners<Radio<T>, Boolean>,
        HasInputElement<Radio<T>, HTMLInputElement> {

  private DivElement radioElement;
  private InputElement inputElement;
  private DivElement fieldInput;
  private LabelElement labelElement;
  private LazyChild<SmallElement> noteElement;
  private RadioGroup<? super T> radioGroup;
  private T value;

  private Set<ChangeListener<? super Boolean>> changeListeners = new LinkedHashSet<>();
  private boolean changeListenersPaused = false;
  /**
   * Creates an instance for the specified value with a label
   *
   * @param value T
   * @param label String
   */
  public Radio(T value, String label) {

    radioElement =
        div()
            .addCss(dui_form_radio)
            .appendChild(inputElement = input(getType()).addCss(dui_hidden_input))
            .appendChild(
                fieldInput =
                    div()
                        .addCss(dui_field_input)
                        .appendChild(labelElement = label().addCss(dui_form_radio_label)));
    noteElement = LazyChild.of(small().addCss(dui_form_radio_note), radioElement);
    setLabel(label);
    labelForId(inputElement.getDominoId());
    withValue(value);
    EventListener listener =
        evt -> {
          if (isEnabled() && !isChecked()) {
            check();
          }
        };
    radioElement.addEventListener("click", listener);
    inputElement.addEventListener(
        "change",
        evt -> {
          if (isEnabled() && !isReadOnly()) {
            setChecked(isChecked(), isChangeListenersPaused());
          }
        });
    getInputElement().onKeyDown(keyEvents -> keyEvents.onEnter(listener));
    init(this);
  }

  /**
   * Creates an instance for the specified value without a label, the label will be the
   * String.valueOf(value)
   *
   * @param value T
   */
  public Radio(T value) {
    this(value, String.valueOf(value));
  }

  /**
   * Creates an instance for the specified value with a label
   *
   * @param value T
   * @param label String
   * @param <E> the type of the value
   * @return new Radio instance
   */
  public static <E> Radio<E> create(E value, String label) {
    return new Radio<>(value, label);
  }

  /**
   * Creates an instance for the specified value without a label, the label will be the
   * String.valueOf(value)
   *
   * @param value T
   * @param <E> the type of value
   * @return new Radio instance
   */
  public static <E> Radio<E> create(E value) {
    return new Radio<>(value);
  }

  @Override
  public String getType() {
    return "radio";
  }

  private void linkLabelToField() {
    DominoElement<HTMLInputElement> asDominoElement = elementOf(inputElement);
    if (!asDominoElement.hasAttribute("id")) {
      inputElement.setAttribute("id", asDominoElement.getDominoId());
    }
    labelElement.setAttribute("for", asDominoElement.getAttribute("id"));
  }

  /** {@inheritDoc} */
  @Override
  public Radio<T> check() {
    return check(isChangeListenersPaused());
  }

  /** {@inheritDoc} */
  @Override
  public Radio<T> uncheck() {
    return uncheck(isChangeListenersPaused());
  }

  /** {@inheritDoc} */
  @Override
  public Radio<T> check(boolean silent) {
    return setChecked(true, silent);
  }

  /** {@inheritDoc} */
  @Override
  public Radio<T> uncheck(boolean silent) {
    return setChecked(false, silent);
  }

  /** {@inheritDoc} */
  Radio<T> uncheckSelf() {
    inputElement.element().checked = false;
    return this;
  }

  @Override
  public Radio<T> toggleChecked(boolean silent) {
    return setChecked(!isChecked(), silent);
  }

  @Override
  public Radio<T> toggleChecked(boolean checkedState, boolean silent) {
    return setChecked(checkedState, silent);
  }

  @Override
  public Radio<T> toggleChecked() {
    return setChecked(!isChecked(), isChangeListenersPaused());
  }

  private Radio<T> setChecked(boolean value, boolean silent) {
    boolean oldState = isChecked();
    if (value == oldState) {
      return this;
    }
    if (nonNull(radioGroup)) {
      if (!(radioGroup.isReadOnly() || radioGroup.isDisabled())) {
        T oldValue = (T) radioGroup.getValue();
        radioGroup.getRadios().stream()
            .filter(Radio::isChecked)
            .findFirst()
            .ifPresent(radio -> radio.uncheckSelf());
        inputElement.element().checked = value;
        if (!silent) {
          triggerChangeListeners(oldState, isChecked());
        }
        radioGroup.onSelectionChanged(oldValue, this, silent);
      }
    } else {
      inputElement.element().checked = value;
      if (!silent) {
        triggerChangeListeners(oldState, isChecked());
      }
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isChecked() {
    return inputElement.element().checked;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return radioElement.element();
  }

  /** {@inheritDoc} */
  String getName() {
    return inputElement.element().name;
  }

  /** {@inheritDoc} */
  Radio<T> setName(String name) {
    inputElement.element().name = name;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Radio<T> withValue(T value) {
    return withValue(value, isChangeListenersPaused());
  }

  /** {@inheritDoc} */
  @Override
  public Radio<T> withValue(T value, boolean silent) {
    setValue(value);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public void setValue(T value) {
    this.value = value;
  }

  /** {@inheritDoc} */
  @Override
  public T getValue() {
    return this.value;
  }

  /** {@inheritDoc} */
  @Override
  public Radio<T> setLabel(String label) {
    labelElement.textContent(label);
    return this;
  }

  /** @param safeHtml {@link SafeHtml} to be used as a label */
  public Radio<T> setLabel(SafeHtml safeHtml) {
    labelElement.clearElement().setInnerHtml(safeHtml.asString());
    return this;
  }

  /** @param node {@link Node} to be used as a label */
  public Radio<T> setLabel(Node node) {
    elementOf(labelElement).clearElement().appendChild(node);
    return this;
  }

  /** @param element {@link IsElement} to be used as a label */
  public Radio<T> setLabel(IsElement<?> element) {
    return setLabel(element.element());
  }

  /** {@inheritDoc} */
  @Override
  public String getLabel() {
    return labelElement.element().textContent;
  }

  /** {@inheritDoc} */
  @Override
  public Radio<T> enable() {
    radioElement.enable();
    inputElement.enable();
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Radio<T> disable() {
    radioElement.disable();
    inputElement.disable();
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public String getHelperText() {
    return noteElement.get().getTextContent();
  }

  /** {@inheritDoc} */
  @Override
  public Radio<T> setHelperText(String text) {
    noteElement.get().setTextContent(text);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isEnabled() {
    return !(inputElement.isDisabled() || radioElement.isDisabled() || radioGroup.isDisabled());
  }

  /** @param radioGroup {@link RadioGroup} this radio belongs to */
  void setGroup(RadioGroup<? super T> radioGroup) {
    this.radioGroup = radioGroup;
  }

  /** {@inheritDoc} */
  public DominoElement<HTMLInputElement> getInputElement() {
    return inputElement.toDominoElement();
  }

  /** {@inheritDoc} */
  public String getStringValue() {
    return String.valueOf(getValue());
  }

  @Override
  public Radio<T> focus() {
    if (!isDisabled()) {
      if (!isAttached()) {
        ElementUtil.onAttach(
            getInputElement(), mutationRecord -> getInputElement().element().focus());
      } else {
        getInputElement().element().focus();
      }
    }
    return this;
  }

  @Override
  public Radio<T> unfocus() {
    if (!isAttached()) {
      ElementUtil.onAttach(
          getInputElement(),
          mutationRecord -> {
            getInputElement().element().blur();
          });
    } else {
      getInputElement().element().blur();
    }
    return this;
  }

  @Override
  public boolean isFocused() {
    if (nonNull(DomGlobal.document.activeElement)) {
      String dominoId =
          elementOf(Js.<HTMLElement>uncheckedCast(DomGlobal.document.activeElement)).getDominoId();
      return nonNull(radioElement.querySelector("[domino-uuid=\"" + dominoId + "\"]"));
    }
    return false;
  }

  @Override
  public Radio<T> labelForId(String id) {
    DominoElement<HTMLInputElement> asDominoElement = elementOf(inputElement);
    if (!asDominoElement.hasAttribute("id")) {
      inputElement.setAttribute("id", asDominoElement.getDominoId());
    }
    labelElement.setAttribute("for", asDominoElement.getAttribute("id"));
    return this;
  }

  @Override
  public Radio<T> pauseChangeListeners() {
    this.changeListenersPaused = true;
    return this;
  }

  @Override
  public Radio<T> resumeChangeListeners() {
    this.changeListenersPaused = false;
    return this;
  }

  @Override
  public Radio<T> togglePauseChangeListeners(boolean toggle) {
    this.changeListenersPaused = toggle;
    return this;
  }

  @Override
  public Set<ChangeListener<? super Boolean>> getChangeListeners() {
    return changeListeners;
  }

  @Override
  public boolean isChangeListenersPaused() {
    return this.changeListenersPaused;
  }

  @Override
  public Radio<T> triggerChangeListeners(Boolean oldValue, Boolean newValue) {
    changeListeners.forEach(listener -> listener.onValueChanged(oldValue, newValue));
    return this;
  }

  @Override
  public Radio<T> setReadOnly(boolean readOnly) {
    getInputElement().setReadOnly(readOnly);
    return super.setReadOnly(readOnly);
  }

  public DivElement getFieldInput() {
    return fieldInput;
  }

  public LabelElement getLabelElement() {
    return labelElement;
  }

  public SmallElement getNoteElement() {
    return noteElement.get();
  }

  public RadioGroup<? super T> getRadioGroup() {
    return radioGroup;
  }

  public T withFieldInput(ChildHandler<Radio<T>, DivElement> handler) {
    handler.apply(this, fieldInput);
    return (T) this;
  }

  public T withLabelElement(ChildHandler<Radio<T>, LabelElement> handler) {
    handler.apply(this, labelElement);
    return (T) this;
  }

  public T withNoteElement(ChildHandler<Radio<T>, SmallElement> handler) {
    handler.apply(this, noteElement.get());
    return (T) this;
  }

  public T withRadioGroup(ChildHandler<Radio<T>, RadioGroup<? super T>> handler) {
    handler.apply(this, radioGroup);
    return (T) this;
  }
}
