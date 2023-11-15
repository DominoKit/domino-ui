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
 * The Radio class represents a radio button element in a Domino UI form.
 *
 * <p>Radio buttons are typically used to allow users to make a single selection from a list of
 * options. A radio button can have a label and optional helper text.
 *
 * <p>Usage Example:
 *
 * <pre> Radio&lt;String&gt; radio = Radio.create("option1", "Option 1");
 * radio.setHelperText("Select option 1"); radio.addValueChangeHandler(value -> {
 * Window.alert("Selected value: " + value); }); </pre>
 *
 * @param <T> The type of value associated with the radio button.
 * @see BaseDominoElement
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
   * Creates a new Radio instance with the specified value and label.
   *
   * @param value The value associated with the radio button.
   * @param label The label text for the radio button.
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
   * Creates a new Radio instance with the specified value and a label generated from the value.
   *
   * @param value The value associated with the radio button.
   */
  public Radio(T value) {
    this(value, String.valueOf(value));
  }

  /**
   * Creates a new Radio instance with the specified value and label.
   *
   * @param <E> The type of value associated with the radio button.
   * @param value The value associated with the radio button.
   * @param label The label text for the radio button.
   * @return A new Radio instance.
   */
  public static <E> Radio<E> create(E value, String label) {
    return new Radio<>(value, label);
  }

  /**
   * Creates a new Radio instance with the specified value and a label generated from the value.
   *
   * @param <E> The type of value associated with the radio button.
   * @param value The value associated with the radio button.
   * @return A new Radio instance.
   */
  public static <E> Radio<E> create(E value) {
    return new Radio<>(value);
  }

  /**
   * Gets the type of the radio button input, which is always "radio".
   *
   * @return The type of the radio button input, which is "radio".
   */
  @Override
  public String getType() {
    return "radio";
  }

  /**
   * Links the label of the radio button to its input field by setting the "for" attribute of the
   * label element to the "id" of the input element if not already set.
   */
  private void linkLabelToField() {
    DominoElement<HTMLInputElement> asDominoElement = elementOf(inputElement);
    if (!asDominoElement.hasAttribute("id")) {
      inputElement.setAttribute("id", asDominoElement.getDominoId());
    }
    labelElement.setAttribute("for", asDominoElement.getAttribute("id"));
  }

  /**
   * Checks the radio button, triggering change listeners if not in a paused state.
   *
   * @return This `Radio` instance.
   */
  @Override
  public Radio<T> check() {
    return check(isChangeListenersPaused());
  }

  /**
   * Unchecks the radio button, triggering change listeners if not in a paused state.
   *
   * @return This `Radio` instance.
   */
  @Override
  public Radio<T> uncheck() {
    return uncheck(isChangeListenersPaused());
  }

  /**
   * Checks the radio button, optionally suppressing change listener events if `silent` is true.
   *
   * @param silent If true, change listener events will not be triggered.
   * @return This `Radio` instance.
   */
  @Override
  public Radio<T> check(boolean silent) {
    return setChecked(true, silent);
  }

  /**
   * Unchecks the radio button, optionally suppressing change listener events if `silent` is true.
   *
   * @param silent If true, change listener events will not be triggered.
   * @return This `Radio` instance.
   */
  @Override
  public Radio<T> uncheck(boolean silent) {
    return setChecked(false, silent);
  }

  /**
   * Unchecks the radio button by setting its checked state to false internally.
   *
   * @return This `Radio` instance.
   */
  Radio<T> uncheckSelf() {
    inputElement.element().checked = false;
    return this;
  }

  /**
   * Toggles the checked state of the radio button, optionally suppressing change listener events if
   * `silent` is true.
   *
   * @param silent If true, change listener events will not be triggered.
   * @return This `Radio` instance.
   */
  @Override
  public Radio<T> toggleChecked(boolean silent) {
    return setChecked(!isChecked(), silent);
  }

  /**
   * Toggles the checked state of the radio button to the specified `checkedState`, optionally
   * suppressing change listener events if `silent` is true.
   *
   * @param checkedState The desired checked state.
   * @param silent If true, change listener events will not be triggered.
   * @return This `Radio` instance.
   */
  @Override
  public Radio<T> toggleChecked(boolean checkedState, boolean silent) {
    return setChecked(checkedState, silent);
  }

  /**
   * Toggles the checked state of the radio button, optionally suppressing change listener events if
   * not in a paused state.
   *
   * @return This `Radio` instance.
   */
  @Override
  public Radio<T> toggleChecked() {
    return setChecked(!isChecked(), isChangeListenersPaused());
  }

  /**
   * Sets the checked state of the radio button to the specified `value`, optionally suppressing
   * change listener events if `silent` is true.
   *
   * @param value The desired checked state.
   * @param silent If true, change listener events will not be triggered.
   * @return This `Radio` instance.
   */
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

  /**
   * Checks if the radio button is currently checked.
   *
   * @return True if the radio button is checked, false otherwise.
   */
  @Override
  public boolean isChecked() {
    return inputElement.element().checked;
  }

  /**
   * Gets the DOM element representing this radio button.
   *
   * @return The DOM element of this radio button.
   */
  @Override
  public HTMLDivElement element() {
    return radioElement.element();
  }

  /**
   * Gets the name of the radio button's input element.
   *
   * @return The name of the radio button's input element.
   */
  String getName() {
    return inputElement.element().name;
  }

  /**
   * Sets the name attribute of the radio button's input element.
   *
   * @param name The name to set.
   * @return This `Radio` instance.
   */
  Radio<T> setName(String name) {
    inputElement.element().name = name;
    return this;
  }

  /**
   * Sets the value of the radio button and optionally triggers change listeners.
   *
   * @param value The value to set.
   * @return This `Radio` instance.
   */
  @Override
  public Radio<T> withValue(T value) {
    return withValue(value, isChangeListenersPaused());
  }

  /**
   * Sets the value of the radio button and optionally triggers change listeners.
   *
   * @param value The value to set.
   * @param silent If `true`, change listeners won't be triggered.
   * @return This `Radio` instance.
   */
  @Override
  public Radio<T> withValue(T value, boolean silent) {
    setValue(value);
    return this;
  }

  /**
   * Sets the value of the radio button.
   *
   * @param value The value to set.
   */
  @Override
  public void setValue(T value) {
    this.value = value;
  }

  /**
   * Gets the current value of the radio button.
   *
   * @return The current value of the radio button.
   */
  @Override
  public T getValue() {
    return this.value;
  }

  /**
   * Sets the label of the radio button.
   *
   * @param label The label text to set.
   * @return This `Radio` instance.
   */
  @Override
  public Radio<T> setLabel(String label) {
    labelElement.textContent(label);
    return this;
  }

  /**
   * Sets the label of the radio button with HTML content provided as SafeHtml.
   *
   * @param safeHtml The SafeHtml content to set as the label.
   * @return This `Radio` instance.
   */
  public Radio<T> setLabel(SafeHtml safeHtml) {
    labelElement.clearElement().setInnerHtml(safeHtml.asString());
    return this;
  }

  /**
   * Sets the label of the radio button with a custom DOM Node element.
   *
   * @param node The DOM Node element to set as the label.
   * @return This `Radio` instance.
   */
  public Radio<T> setLabel(Node node) {
    elementOf(labelElement).clearElement().appendChild(node);
    return this;
  }

  /**
   * Sets the label of the radio button with an IsElement instance.
   *
   * @param element The IsElement instance whose element will be set as the label.
   * @return This `Radio` instance.
   */
  public Radio<T> setLabel(IsElement<?> element) {
    return setLabel(element.element());
  }

  /**
   * Gets the text content of the radio button's label.
   *
   * @return The text content of the radio button's label.
   */
  @Override
  public String getLabel() {
    return labelElement.element().textContent;
  }

  /**
   * Enables the radio button for user interaction.
   *
   * @return This `Radio` instance.
   */
  @Override
  public Radio<T> enable() {
    radioElement.enable();
    inputElement.enable();
    return this;
  }

  /**
   * Disables the radio button, preventing user interaction.
   *
   * @return This `Radio` instance.
   */
  @Override
  public Radio<T> disable() {
    radioElement.disable();
    inputElement.disable();
    return this;
  }

  /**
   * Retrieves the helper text associated with this radio button.
   *
   * @return The helper text.
   */
  @Override
  public String getHelperText() {
    return noteElement.get().getTextContent();
  }

  /**
   * Sets the helper text for this radio button.
   *
   * @param text The helper text to set.
   * @return This `Radio` instance.
   */
  @Override
  public Radio<T> setHelperText(String text) {
    noteElement.get().setTextContent(text);
    return this;
  }

  /**
   * Checks if the radio button is enabled for user interaction.
   *
   * @return `true` if the radio button is enabled, `false` otherwise.
   */
  @Override
  public boolean isEnabled() {
    return !(inputElement.isDisabled() || radioElement.isDisabled() || radioGroup.isDisabled());
  }

  /**
   * Associates a radio group with this radio button.
   *
   * @param radioGroup The radio group to associate.
   */
  void setGroup(RadioGroup<? super T> radioGroup) {
    this.radioGroup = radioGroup;
  }

  /**
   * Retrieves the input element associated with this radio button.
   *
   * @return The input element.
   */
  public DominoElement<HTMLInputElement> getInputElement() {
    return inputElement.toDominoElement();
  }

  /**
   * Retrieves the string representation of the current value of this radio button.
   *
   * @return The string representation of the value.
   */
  public String getStringValue() {
    return String.valueOf(getValue());
  }

  /**
   * Sets focus on the radio button element if it's not disabled.
   *
   * @return This `Radio` instance.
   */
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

  /**
   * Removes focus from the radio button element.
   *
   * @return This `Radio` instance.
   */
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

  /**
   * Checks if the radio button element is currently focused.
   *
   * @return `true` if the radio button is focused, `false` otherwise.
   */
  @Override
  public boolean isFocused() {
    if (nonNull(DomGlobal.document.activeElement)) {
      String dominoId =
          elementOf(Js.<HTMLElement>uncheckedCast(DomGlobal.document.activeElement)).getDominoId();
      return nonNull(radioElement.querySelector("[domino-uuid=\"" + dominoId + "\"]"));
    }
    return false;
  }

  /**
   * Associates the given `id` with the label element for accessibility purposes.
   *
   * @param id The `id` to associate with the label.
   * @return This `Radio` instance.
   */
  @Override
  public Radio<T> labelForId(String id) {
    DominoElement<HTMLInputElement> asDominoElement = elementOf(inputElement);
    if (!asDominoElement.hasAttribute("id")) {
      inputElement.setAttribute("id", asDominoElement.getDominoId());
    }
    labelElement.setAttribute("for", asDominoElement.getAttribute("id"));
    return this;
  }

  /**
   * Pauses change listeners for this radio button.
   *
   * @return This `Radio` instance.
   */
  @Override
  public Radio<T> pauseChangeListeners() {
    this.changeListenersPaused = true;
    return this;
  }

  /**
   * Resumes change listeners for this radio button.
   *
   * @return This `Radio` instance.
   */
  @Override
  public Radio<T> resumeChangeListeners() {
    this.changeListenersPaused = false;
    return this;
  }

  /**
   * Toggles the pause state of change listeners for this radio button.
   *
   * @param toggle `true` to pause change listeners, `false` to resume.
   * @return This `Radio` instance.
   */
  @Override
  public Radio<T> togglePauseChangeListeners(boolean toggle) {
    this.changeListenersPaused = toggle;
    return this;
  }

  /**
   * Retrieves the set of change listeners associated with this radio button.
   *
   * @return The set of change listeners.
   */
  @Override
  public Set<ChangeListener<? super Boolean>> getChangeListeners() {
    return changeListeners;
  }

  /**
   * Checks if change listeners for this radio button are currently paused.
   *
   * @return `true` if change listeners are paused, `false` otherwise.
   */
  @Override
  public boolean isChangeListenersPaused() {
    return this.changeListenersPaused;
  }

  /**
   * Triggers change listeners for this radio button with the given old and new values.
   *
   * @param oldValue The old value.
   * @param newValue The new value.
   * @return This `Radio` instance.
   */
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

  /**
   * Retrieves the field input element associated with this radio button.
   *
   * @return The field input element.
   */
  public DivElement getFieldInput() {
    return fieldInput;
  }

  /**
   * Retrieves the label element associated with this radio button.
   *
   * @return The label element.
   */
  public LabelElement getLabelElement() {
    return labelElement;
  }

  /**
   * Retrieves the note element associated with this radio button.
   *
   * @return The note element.
   */
  public SmallElement getNoteElement() {
    return noteElement.get();
  }

  /**
   * Retrieves the radio group to which this radio button belongs.
   *
   * @return The radio group.
   */
  public RadioGroup<? super T> getRadioGroup() {
    return radioGroup;
  }

  /**
   * Allows customization of the field input element associated with this radio button using a child
   * handler.
   *
   * @param handler The child handler for the field input element.
   * @return This `Radio` instance.
   */
  public T withFieldInput(ChildHandler<Radio<T>, DivElement> handler) {
    handler.apply(this, fieldInput);
    return (T) this;
  }

  /**
   * Allows customization of the label element associated with this radio button using a child
   * handler.
   *
   * @param handler The child handler for the label element.
   * @return This `Radio` instance.
   */
  public T withLabelElement(ChildHandler<Radio<T>, LabelElement> handler) {
    handler.apply(this, labelElement);
    return (T) this;
  }

  /**
   * Allows customization of the note element associated with this radio button using a child
   * handler.
   *
   * @param handler The child handler for the note element.
   * @return This `Radio` instance.
   */
  public T withNoteElement(ChildHandler<Radio<T>, SmallElement> handler) {
    handler.apply(this, noteElement.get());
    return (T) this;
  }

  /**
   * Allows customization of the radio group to which this radio button belongs using a child
   * handler.
   *
   * @param handler The child handler for the radio group.
   * @return This `Radio` instance.
   */
  public T withRadioGroup(ChildHandler<Radio<T>, RadioGroup<? super T>> handler) {
    handler.apply(this, radioGroup);
    return (T) this;
  }
}
