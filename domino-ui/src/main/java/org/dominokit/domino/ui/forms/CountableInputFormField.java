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
import static org.dominokit.domino.ui.utils.Domino.span;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.forms.validations.MaxLengthValidator;
import org.dominokit.domino.ui.forms.validations.MinLengthValidator;
import org.dominokit.domino.ui.utils.*;

/**
 * The CountableInputFormField class is an abstract class that extends the InputFormField class and
 * provides functionality for input fields with character counters, minimum and maximum lengths, and
 * placeholders.
 *
 * <p>Usage Example:
 *
 * <pre>
 * // Create a CountableInputFormField for text input
 * CountableInputFormField&lt;TextBox, HTMLInputElement, String&gt; inputField =
 *     new TextBox()
 *         .setPlaceholder("Enter text")
 *         .setMaxLength(100)
 *         .setMinLength(5)
 *         .withCounterElement();
 *
 * // Set a custom count formatter
 * inputField.setCountFormatter((count, maxCount) -&gt; count + " / " + maxCount);
 * </pre>
 *
 * @param <T> The type of the implementing subclass.
 * @param <E> The type of the HTML element.
 * @param <V> The type of the field's value.
 */
public abstract class CountableInputFormField<
        T extends InputFormField<T, E, V>, E extends HTMLElement, V>
    extends InputFormField<T, E, V>
    implements HasCounter<T>, HasMinMaxLength<T>, HasPlaceHolder<T> {

  protected SpanElement counterElement;
  protected CountFormatter countFormatter = (count, maxCount) -> count + "/" + maxCount;
  private MinLengthValidator<T, E> minLengthValidator;
  private MaxLengthValidator<T, E> maxLengthValidator;
  private CounterListener counterListener =
      (count, maxCount, formattedCount) ->
          getCountElement().setTextContent(countFormatter.format(count, getMaxCount()));

  /** Creates a new `CountableInputFormField` instance. */
  public CountableInputFormField() {}

  /**
   * Updates the character counter based on the current input length and maximum count.
   *
   * @param count The current input length.
   * @param maxCount The maximum input length allowed.
   * @return This `CountableInputFormField` instance.
   */
  @Override
  public T updateCounter(int count, int maxCount) {
    if (maxCount > 0) {
      counterListener.onCounterChanged(
          count, maxCount, countFormatter.format(count, getMaxCount()));
      minLengthValidator = new MinLengthValidator<>(this);
      maxLengthValidator = new MaxLengthValidator<>(this);
    }
    return (T) this;
  }

  private SpanElement getCountElement() {
    if (isNull(counterElement)) {
      counterElement = initCounterElement();
    }
    return counterElement;
  }

  protected SpanElement initCounterElement() {
    return counterElement = LazyChild.of(span().addCss(du_field_counter), wrapperElement).get();
  }

  public T setCounterElement(SpanElement counterElement) {
    if (nonNull(this.counterElement)) {
      this.counterElement.remove();
    }

    if (isNull(counterElement)) {
      this.counterElement = initCounterElement();
      return (T) this;
    }

    this.counterElement = counterElement.addCss(du_field_counter);
    updateCounter(getLength(), getMaxCount());
    return (T) this;
  }

  /**
   * Sets a custom formatter for the character counter.
   *
   * @param formatter The custom formatter for the character counter.
   * @return This `CountableInputFormField` instance.
   */
  public T setCountFormatter(CountFormatter formatter) {
    this.countFormatter = formatter;
    if (nonNull(getCountElement())) {
      updateCounter(getLength(), getMaxCount());
    }
    return (T) this;
  }

  /**
   * Gets the maximum character count allowed for the input field.
   *
   * @return The maximum character count allowed.
   */
  @Override
  public int getMaxLength() {
    if (getInputElement().hasAttribute(MAX_LENGTH)) {
      return Integer.parseInt(getInputElement().getAttribute(MAX_LENGTH));
    }
    return -1;
  }

  /**
   * Sets the maximum character count allowed for the input field.
   *
   * @param maxLength The maximum character count allowed.
   * @return This `CountableInputFormField` instance.
   */
  @Override
  public T setMaxLength(int maxLength) {
    if (maxLength < 0) {
      counterElement.remove();
      getInputElement().removeAttribute(MAX_LENGTH);
      removeValidator(maxLengthValidator);
    } else {
      getInputElement().setAttribute(MAX_LENGTH, maxLength);
      updateCounter(getLength(), getMaxCount());
      addValidator(maxLengthValidator);
    }
    return (T) this;
  }

  public T setMaxLength(int maxLength, SpanElement counterElement) {
    setCounterElement(counterElement);
    setMaxLength(maxLength);
    return (T) this;
  }

  /**
   * Gets the current input length.
   *
   * @return The current input length.
   */
  @Override
  public int getLength() {
    String stringValue = getStringValue();
    if (nonNull(stringValue)) {
      return getStringValue().length();
    }
    return 0;
  }

  /**
   * Gets the minimum character count allowed for the input field.
   *
   * @return The minimum character count allowed.
   */
  @Override
  public int getMinLength() {
    if (getInputElement().hasAttribute(MIN_LENGTH)) {
      return Integer.parseInt(getInputElement().getAttribute(MIN_LENGTH));
    }
    return -1;
  }

  /**
   * Sets the minimum character count allowed for the input field.
   *
   * @param minLength The minimum character count allowed.
   * @return This `CountableInputFormField` instance.
   */
  @Override
  public T setMinLength(int minLength) {
    if (minLength < 0) {
      counterElement.remove();
      getInputElement().removeAttribute(MIN_LENGTH);
      removeValidator(minLengthValidator);
    } else {
      getCountElement();
      getInputElement().setAttribute("minlength", minLength);
      updateCounter(getLength(), getMaxCount());
      addValidator(minLengthValidator);
    }
    getInputElement().setAttribute(MIN_LENGTH, minLength);
    return (T) this;
  }

  /**
   * Gets the maximum character count allowed for the input field (alias for getMaxLength).
   *
   * @return The maximum character count allowed.
   */
  @Override
  public int getMaxCount() {
    return getMaxLength();
  }

  /**
   * Gets the placeholder text for the input field.
   *
   * @return The placeholder text.
   */
  @Override
  public String getPlaceholder() {
    return getInputElement().getAttribute("placeholder");
  }

  /**
   * Sets the placeholder text for the input field.
   *
   * @param placeholder The placeholder text to set.
   * @return This `CountableInputFormField` instance.
   */
  @Override
  public T setPlaceholder(String placeholder) {
    getInputElement().setAttribute("placeholder", placeholder);
    return (T) this;
  }

  /**
   * Clears the input field's value and updates the character counter.
   *
   * @param silent {@code true} to clear the field silently, {@code false} otherwise.
   * @return This `CountableInputFormField` instance.
   */
  @Override
  public T clear(boolean silent) {
    super.clear(silent);
    return updateCounter(getLength(), getMaxCount());
  }

  /**
   * Gets the character counter element associated with the input field.
   *
   * @return The character counter element as a `SpanElement`.
   */
  public SpanElement getCounterElement() {
    return getCountElement();
  }

  /**
   * Initializes and retrieves the character counter element for the input field.
   *
   * @return This `CountableInputFormField` instance.
   */
  public T withCounterElement() {
    getCountElement();
    return (T) this;
  }

  /**
   * Initializes and retrieves the character counter element for the input field and applies the
   * specified handler to it.
   *
   * @param handler The handler to apply to the character counter element.
   * @return This `CountableInputFormField` instance.
   */
  public T withCounterElement(ChildHandler<T, SpanElement> handler) {
    handler.apply((T) this, getCountElement());
    return (T) this;
  }

  public interface CounterListener {
    void onCounterChanged(int count, int maxCount, String formattedCount);
  }
}
