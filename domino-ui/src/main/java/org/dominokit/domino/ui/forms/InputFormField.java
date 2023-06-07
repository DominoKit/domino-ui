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
import org.dominokit.domino.ui.elements.BaseElement;
import org.dominokit.domino.ui.elements.InputElement;
import org.dominokit.domino.ui.forms.validations.InputAutoValidator;
import org.dominokit.domino.ui.utils.ApplyFunction;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.ElementUtil;

public abstract class InputFormField<T extends InputFormField<T, E, V>, E extends HTMLElement, V>
    extends AbstractFormElement<T, V> implements HasInputElement<T, E> {

  private DominoElement<E> inputElement;

  public InputFormField() {
    inputElement = createInputElement(getType());
    inputElement.setAttribute("spellcheck", getConfig().isSpellCheckEnabled());
    labelForId(inputElement.getDominoId());
    wrapperElement.appendChild(inputElement);
    InputFieldInitializer.create((T) this).init((HasInputElement<T, HTMLElement>) this);
  }

  protected abstract DominoElement<E> createInputElement(String type);

  @Override
  public DominoElement<E> getInputElement() {
    return inputElement;
  }

  @Override
  public boolean isEmpty() {
    String stringValue = getStringValue();
    return isNull(stringValue) || stringValue.isEmpty();
  }

  @Override
  public boolean isEmptyIgnoreSpaces() {
    String stringValue = getStringValue();
    return isEmpty() || stringValue.trim().isEmpty();
  }

  @Override
  public T clear() {
    return clear(isClearListenersPaused() || isChangeListenersPaused());
  }

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

  @Override
  public AutoValidator createAutoValidator(ApplyFunction autoValidate) {
    return new InputAutoValidator<>(autoValidate, getInputElement());
  }

  @Override
  public T triggerChangeListeners(V oldValue, V newValue) {
    getChangeListeners()
        .forEach(changeListener -> changeListener.onValueChanged(oldValue, newValue));
    return (T) this;
  }

  @Override
  public T triggerClearListeners(V oldValue) {
    getClearListeners().forEach(clearListener -> clearListener.onValueCleared(oldValue));
    return (T) this;
  }

  @Override
  public T withValue(V value) {
    return withValue(value, isChangeListenersPaused());
  }

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

  protected abstract void doSetValue(V value);

  @Override
  public boolean isEnabled() {
    return !isDisabled();
  }

  @Override
  public boolean isDisabled() {
    return super.isDisabled() || getInputElement().isDisabled();
  }

  @Override
  public T enable() {
    getInputElement().enable();
    return super.enable();
  }

  @Override
  public T disable() {
    getInputElement().disable();
    return super.disable();
  }

  @Override
  public T setReadOnly(boolean readOnly) {
    getInputElement().setReadOnly(readOnly);
    return super.setReadOnly(readOnly);
  }

  @Override
  public boolean isReadOnly() {
    return super.isReadOnly() || getInputElement().isReadOnly();
  }

  @Override
  public void setValue(V value) {
    withValue(value);
  }

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

  @Override
  public boolean isFocused() {
    if (nonNull(DomGlobal.document.activeElement)) {
      String dominoId =
          elementOf(Js.<HTMLElement>uncheckedCast(DomGlobal.document.activeElement))
              .getDominoId();
      return nonNull(formElement.querySelector("[domino-uuid=\"" + dominoId + "\"]"));
    }
    return false;
  }

  public T withInputElement(ChildHandler<T, DominoElement<E>> handler){
    handler.apply((T)this, getInputElement());
    return (T) this;
  }
}
