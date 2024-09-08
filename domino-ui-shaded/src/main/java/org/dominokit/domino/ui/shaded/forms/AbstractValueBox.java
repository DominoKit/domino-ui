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

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.shaded.forms.validations.MinLengthValidator;
import org.dominokit.domino.ui.shaded.utils.HasLength;

/**
 * A base implementation for all form field that can have a value
 *
 * @param <T> The type of the class extending from this class- for fluent API pattern
 * @param <E> The type of the root HTMLElement from the extending class
 * @param <V> The value type for the field
 */
public abstract class AbstractValueBox<
        T extends AbstractValueBox<T, E, V>, E extends HTMLElement, V>
    extends ValueBox<T, E, V> implements HasLength<T> {

  private int maxLength;
  private int minLength;
  private String minLengthErrorMessage;
  private MinLengthValidator minLengthValidator = new MinLengthValidator(this);

  /**
   * Creates and instance initialized with the input field type and a label
   *
   * @param type String type, <b>text</b>,<b>password</b>,<b>telephone</b>.. etc
   * @param label String
   */
  public AbstractValueBox(String type, String label) {
    super(type, label);
    addInputEvent();
  }

  private void addInputEvent() {
    getInputElement().addEventListener("input", evt -> updateCharacterCount());
  }

  /** {@inheritDoc} this will also set the <b>maxlength</b> attribute on the html element */
  @Override
  public T setMaxLength(int maxLength) {
    this.maxLength = maxLength;
    if (maxLength < 0) {
      getCountItem().hide();
      getInputElement().removeAttribute("maxlength");
    } else {
      getCountItem().show();
      getInputElement().setAttribute("maxlength", maxLength);
      updateCharacterCount();
    }
    return (T) this;
  }

  /**
   * set the filed value
   *
   * @param value V
   * @return same component instance
   */
  @Override
  public T value(V value) {
    super.value(value);
    updateCharacterCount();
    return (T) this;
  }

  @Override
  public T clear(boolean silent) {
    super.clear(silent);
    updateCharacterCount();
    return (T) this;
  }

  /** Updates the character count based on field string value */
  protected void updateCharacterCount() {
    if (maxLength > 0 || minLength > 0) {
      getCountItem().show();
      String value = getStringValue();
      int length = 0;
      if (nonNull(value)) {
        length = value.length();
      }
      if (length < minLength) {
        length = minLength;
      }
      getCountItem().setTextContent(length + "/" + maxLength);
    } else {
      getCountItem().hide();
    }
  }

  /** {@inheritDoc} */
  @Override
  public int getMaxLength() {
    return this.maxLength;
  }

  /** {@inheritDoc} */
  @Override
  public T setMinLength(int minLength) {
    this.minLength = minLength;
    if (minLength < 0) {
      getCountItem().hide();
      getInputElement().removeAttribute("minlength");
      removeValidator(minLengthValidator);
    } else {
      getCountItem().show();
      getInputElement().setAttribute("minlength", minLength);
      updateCharacterCount();
      addValidator(minLengthValidator);
    }
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public int getMinLength() {
    return minLength;
  }

  /** {@inheritDoc} */
  @Override
  public T setReadOnly(boolean readOnly) {
    getCountItem().toggleDisplay(!readOnly);
    return super.setReadOnly(readOnly);
  }

  /** {@inheritDoc} */
  @Override
  public boolean isEmpty() {
    String stringValue = getStringValue();
    return isNull(stringValue) || stringValue.isEmpty();
  }

  /** {@inheritDoc} */
  @Override
  public boolean isEmptyIgnoreSpaces() {
    String stringValue = getStringValue();
    return isEmpty() || stringValue.trim().isEmpty();
  }

  /**
   * @param minLengthErrorMessage String minimum length validation message
   * @return same component instance
   */
  public T setMinLengthErrorMessage(String minLengthErrorMessage) {
    this.minLengthErrorMessage = minLengthErrorMessage;
    return (T) this;
  }

  /** @return String minimum length validation message, if null return default message */
  public String getMinLengthErrorMessage() {
    return isNull(minLengthErrorMessage) ? "Minimum length is " + minLength : minLengthErrorMessage;
  }
}
