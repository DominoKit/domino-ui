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

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;
import java.util.Objects;
import jsinterop.base.Js;
import org.dominokit.domino.ui.forms.validations.InputAutoValidator;
import org.dominokit.domino.ui.utils.ApplyFunction;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.ElementUtil;

/**
 * An abstract base class for input form fields in Domino UI. InputFormField represents form fields
 * that accept user input through an HTML input element.
 *
 * @param <T> The concrete type of the InputFormField.
 * @param <E> The type of the HTML input element.
 * @param <V> The type of the input field's value.
 * @see AbstractFormElement
 * @see HasInputElement
 */
public abstract class InputFormField<T extends InputFormField<T, E, V>, E extends HTMLElement, V>
    extends AbstractFormElement<T, V> implements HasInputElement<T, E> {

  private DominoElement<E> inputElement;

  /**
   * Constructs a new InputFormField instance. Initializes and configures the HTML input element for
   * user input.
   */
  public InputFormField() {
    inputElement = createInputElement(getType());
    inputElement.setAttribute("spellcheck", getConfig().isSpellCheckEnabled());
    labelForId(inputElement.getDominoId());
    wrapperElement.appendChild(inputElement);
    InputFieldInitializer.create((T) this).init((HasInputElement<T, HTMLElement>) this);
  }

  /**
   * Creates and returns a DominoElement representing the HTML input element.
   *
   * @param type The type of the input element, such as "text" or "password".
   * @return A DominoElement representing the HTML input element.
   */
  protected abstract DominoElement<E> createInputElement(String type);

  /**
   * Retrieves the HTML input element associated with this form field.
   *
   * @return The HTML input element.
   */
  @Override
  public DominoElement<E> getInputElement() {
    return inputElement;
  }

  /**
   * Checks if the input field is empty (has no value).
   *
   * @return {@code true} if the input field is empty, {@code false} otherwise.
   */
  @Override
  public boolean isEmpty() {
    String stringValue = getStringValue();
    return isNull(stringValue) || stringValue.isEmpty();
  }

  /**
   * Checks if the input field is empty when ignoring leading and trailing spaces.
   *
   * @return {@code true} if the input field is empty, {@code false} otherwise.
   */
  @Override
  public boolean isEmptyIgnoreSpaces() {
    String stringValue = getStringValue();
    return isEmpty() || stringValue.trim().isEmpty();
  }

  /**
   * Clears the input field's value.
   *
   * @return This InputFormField instance.
   */
  @Override
  public T clear() {
    return clear(isClearListenersPaused() || isChangeListenersPaused());
  }

  /**
   * Clears the input field's value.
   *
   * @param silent {@code true} to clear the field silently without triggering listeners, {@code
   *     false} otherwise.
   * @return This InputFormField instance.
   */
  @Override
  public T clear(boolean silent) {
    V oldValue = getValue();
    withValue(getDefaultValue(), silent);
    V newValue = getValue();
    if (!silent && !Objects.equals(oldValue, newValue)) {
      triggerClearListeners(oldValue);
    }
    autoValidate();
    return (T) this;
  }

  /**
   * Creates and returns an InputAutoValidator for automatic input validation.
   *
   * @param autoValidate The function to apply for auto-validation.
   * @return An InputAutoValidator instance.
   */
  @Override
  public AutoValidator createAutoValidator(ApplyFunction autoValidate) {
    return new InputAutoValidator<>(autoValidate, getInputElement());
  }

  /**
   * Triggers change listeners when the input field's value changes.
   *
   * @param oldValue The old value before the change.
   * @param newValue The new value after the change.
   * @return This InputFormField instance.
   */
  @Override
  public T triggerChangeListeners(V oldValue, V newValue) {
    getChangeListeners()
        .forEach(changeListener -> changeListener.onValueChanged(oldValue, newValue));
    return (T) this;
  }

  /**
   * Triggers clear listeners when the input field's value is cleared.
   *
   * @param oldValue The old value before clearing.
   * @return This InputFormField instance.
   */
  @Override
  public T triggerClearListeners(V oldValue) {
    getClearListeners().forEach(clearListener -> clearListener.onValueCleared(oldValue));
    return (T) this;
  }

  /**
   * Sets the value of the input field.
   *
   * @param value The value to set.
   * @return This InputFormField instance.
   */
  @Override
  public T withValue(V value) {
    return withValue(value, isChangeListenersPaused());
  }

  /**
   * Sets the value of the input field and optionally triggers change listeners.
   *
   * @param value The value to set.
   * @param silent {@code true} to set the value silently without triggering change listeners,
   *     {@code false} otherwise.
   * @return This InputFormField instance.
   */
  @Override
  public T withValue(V value, boolean silent) {
    V oldValue = getValue();
    if (!Objects.equals(value, oldValue)) {
      doSetValue(value);
      if (!silent) {
        triggerChangeListeners(oldValue, getValue());
      }
    }
    autoValidate();
    return (T) this;
  }

  /**
   * Sets the value of the input field.
   *
   * @param value The value to set.
   */
  protected abstract void doSetValue(V value);

  /**
   * Checks if the input field is enabled.
   *
   * @return {@code true} if the input field is enabled, {@code false} if disabled.
   */
  @Override
  public boolean isEnabled() {
    return !isDisabled();
  }

  /**
   * Checks if the input field is disabled.
   *
   * @return {@code true} if the input field is disabled, {@code false} if enabled.
   */
  @Override
  public boolean isDisabled() {
    return super.isDisabled() || getInputElement().isDisabled();
  }

  /**
   * Enables the input field.
   *
   * @return This InputFormField instance.
   */
  @Override
  public T enable() {
    getInputElement().enable();
    return super.enable();
  }

  /**
   * Disables the input field.
   *
   * @return This InputFormField instance.
   */
  @Override
  public T disable() {
    getInputElement().disable();
    return super.disable();
  }

  /**
   * Sets the input field to read-only mode.
   *
   * @param readOnly {@code true} to set the input field as read-only, {@code false} to make it
   *     editable.
   * @return This InputFormField instance.
   */
  @Override
  public T setReadOnly(boolean readOnly) {
    getInputElement().setReadOnly(readOnly);
    return super.setReadOnly(readOnly);
  }

  /**
   * Checks if the input field is in read-only mode.
   *
   * @return {@code true} if the input field is in read-only mode, {@code false} if it is editable.
   */
  @Override
  public boolean isReadOnly() {
    return super.isReadOnly() || getInputElement().isReadOnly();
  }

  /**
   * Sets the value of the input field.
   *
   * @param value The value to set.
   */
  @Override
  public void setValue(V value) {
    withValue(value);
  }

  /**
   * Focuses on the input field.
   *
   * @return This InputFormField instance.
   */
  @Override
  public T focus() {
    if (!isDisabled()) {
      if (!isAttached()) {
        ElementUtil.onAttach(
            getInputElement(), mutationRecord -> getInputElement().element().focus());
      } else {
        getInputElement().element().focus();
      }
    }
    return (T) this;
  }

  /**
   * Removes focus from the input field.
   *
   * @return This InputFormField instance.
   */
  @Override
  public T unfocus() {
    if (!isAttached()) {
      ElementUtil.onAttach(
          getInputElement(),
          mutationRecord -> {
            getInputElement().element().blur();
          });
    } else {
      getInputElement().element().blur();
    }
    return (T) this;
  }

  /**
   * Checks if the input field is currently focused.
   *
   * @return {@code true} if the input field is focused, {@code false} otherwise.
   */
  @Override
  public boolean isFocused() {
    if (nonNull(DomGlobal.document.activeElement)) {
      String dominoId =
          elementOf(Js.<HTMLElement>uncheckedCast(DomGlobal.document.activeElement)).getDominoId();
      return nonNull(formElement.querySelector("[domino-uuid=\"" + dominoId + "\"]"));
    }
    return false;
  }

  /**
   * Allows customization and manipulation of the input element.
   *
   * @param handler The handler function for customizing the input element.
   * @return This InputFormField instance.
   */
  public T withInputElement(ChildHandler<T, DominoElement<E>> handler) {
    handler.apply((T) this, getInputElement());
    return (T) this;
  }
}
