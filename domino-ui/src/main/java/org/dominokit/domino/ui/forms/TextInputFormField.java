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
import static org.dominokit.domino.ui.utils.Domino.*;
import static org.dominokit.domino.ui.utils.Domino.div;

import elemental2.dom.HTMLInputElement;
import jsinterop.base.Js;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.validations.ValidationResult;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.HasPostfix;
import org.dominokit.domino.ui.utils.HasPrefix;
import org.dominokit.domino.ui.utils.LazyChild;

/**
 * The TextInputFormField class is an abstract class that extends the CountableInputFormField class
 * and provides functionality for text input fields, including prefixes, postfixes, and pattern
 * validation.
 *
 * <p>Usage Example:
 *
 * <pre>
 * // Create a TextInputFormField for text input
 * TextInputFormField&lt;TextBox, HTMLInputElement, String&gt; inputField =
 *     new TextBox()
 *         .setPlaceholder("Enter text")
 *         .setPattern("[A-Za-z0-9]+", "Only alphanumeric characters are allowed.")
 *         .withPrefixElement()
 *         .setPrefix("Prefix: ")
 *         .withPostfixElement()
 *         .setPostfix("Postfix");
 * </pre>
 *
 * @param <T> The type of the implementing subclass.
 * @param <E> The type of the HTML element.
 * @param <V> The type of the field's value.
 */
public abstract class TextInputFormField<
        T extends InputFormField<T, E, V>, E extends HTMLInputElement, V>
    extends CountableInputFormField<T, E, V> implements HasPostfix<T>, HasPrefix<T> {

  protected final LazyChild<DivElement> prefixElement;
  protected final LazyChild<DivElement> postfixElement;
  private String invalidPatternErrorMessage;
  private String typeMismatchErrorMessage;

  private void addInvalidPatternValidator() {
    addValidator(
        (target) -> {
          HTMLInputElement inputElement = Js.uncheckedCast(getInputElement().element());
          if (inputElement.validity.patternMismatch) {
            return ValidationResult.invalid(getInvalidPatternErrorMessage());
          }
          return ValidationResult.valid();
        });
  }

  private void addTypeMismatchValidator() {
    addValidator(
        (target) -> {
          HTMLInputElement inputElement = Js.uncheckedCast(getInputElement().element());
          if (inputElement.validity.typeMismatch) {
            return ValidationResult.invalid(getTypeMismatchErrorMessage());
          }
          return ValidationResult.valid();
        });
  }

  /** Creates a new TextInputFormField instance with default values. */
  public TextInputFormField() {
    prefixElement = LazyChild.of(div().addCss(dui_field_prefix), wrapperElement);
    postfixElement = LazyChild.of(div().addCss(dui_field_postfix), wrapperElement);
    addInvalidPatternValidator();
    addTypeMismatchValidator();
  }

  /**
   * Sets a postfix element for the text input field.
   *
   * @param postfix The postfix text or content.
   * @return This TextInputFormField instance.
   */
  @Override
  public T setPostfix(String postfix) {
    postfixElement.get().setTextContent(postfix);
    return (T) this;
  }

  /**
   * Gets the postfix text or content of the text input field.
   *
   * @return The postfix text or content.
   */
  @Override
  public String getPostfix() {
    if (postfixElement.isInitialized()) {
      return postfixElement.get().getTextContent();
    }
    return "";
  }

  /**
   * Sets a prefix element for the text input field.
   *
   * @param prefix The prefix text or content.
   * @return This TextInputFormField` instance.
   */
  @Override
  public T setPrefix(String prefix) {
    prefixElement.get().setTextContent(prefix);
    return (T) this;
  }

  /**
   * Gets the prefix text or content of the text input field.
   *
   * @return The prefix text or content.
   */
  @Override
  public String getPrefix() {
    if (prefixElement.isInitialized()) {
      return prefixElement.get().getTextContent();
    }
    return "";
  }

  /**
   * Gets the prefix element associated with the text input field.
   *
   * @return The prefix element as a `DivElement`.
   */
  public DivElement getPrefixElement() {
    return prefixElement.get();
  }

  /**
   * Gets the postfix element associated with the text input field.
   *
   * @return The postfix element as a `DivElement`.
   */
  public DivElement getPostfixElement() {
    return postfixElement.get();
  }

  /**
   * Initializes and retrieves the prefix element for the text input field.
   *
   * @return This `TextInputFormField` instance.
   */
  public T withPrefixElement() {
    prefixElement.get();
    return (T) this;
  }

  /**
   * Initializes and retrieves the prefix element for the text input field and applies the specified
   * handler to it.
   *
   * @param handler The handler to apply to the prefix element.
   * @return This `TextInputFormField` instance.
   */
  public T withPrefixElement(ChildHandler<T, DivElement> handler) {
    handler.apply((T) this, prefixElement.get());
    return (T) this;
  }

  /**
   * Initializes and retrieves the postfix element for the text input field.
   *
   * @return This `TextInputFormField` instance.
   */
  public T withPostfixElement() {
    postfixElement.get();
    return (T) this;
  }

  /**
   * Initializes and retrieves the postfix element for the text input field and applies the
   * specified handler to it.
   *
   * @param handler The handler to apply to the postfix element.
   * @return This `TextInputFormField` instance.
   */
  public T withPostfixElement(ChildHandler<T, DivElement> handler) {
    handler.apply((T) this, postfixElement.get());
    return (T) this;
  }

  /**
   * Gets the name attribute of the text input field.
   *
   * @return The name attribute value.
   */
  @Override
  public String getName() {
    return getInputElement().element().name;
  }

  /**
   * Sets the name attribute for the text input field.
   *
   * @param name The name attribute value to set.
   * @return This `TextInputFormField` instance.
   */
  @Override
  public T setName(String name) {
    getInputElement().element().name = name;
    return (T) this;
  }

  /**
   * Sets a regular expression pattern for the text input field.
   *
   * @param pattern The regular expression pattern.
   * @return This `TextInputFormField` instance.
   */
  public T setPattern(String pattern) {
    getInputElement().setAttribute("pattern", pattern);
    return (T) this;
  }

  /**
   * Sets a regular expression pattern for the text input field and specifies a custom error message
   * to display when the pattern is not matched.
   *
   * @param pattern The regular expression pattern.
   * @param errorMessage The custom error message to display.
   * @return This `TextInputFormField` instance.
   */
  public T setPattern(String pattern, String errorMessage) {
    setPattern(pattern);
    setInvalidPatternErrorMessage(errorMessage);
    return (T) this;
  }

  /**
   * Gets the regular expression pattern of the text input field.
   *
   * @return The regular expression pattern.
   */
  public String getPattern() {
    return getInputElement().getAttribute("pattern");
  }

  /**
   * Sets a custom error message for the "invalid pattern" validation.
   *
   * @param invalidPatternErrorMessage The custom error message to display.
   * @return This `TextInputFormField` instance.
   */
  public T setInvalidPatternErrorMessage(String invalidPatternErrorMessage) {
    this.invalidPatternErrorMessage = invalidPatternErrorMessage;
    return (T) this;
  }

  /**
   * Gets the error message for the "invalid pattern" validation.
   *
   * @return The error message for invalid pattern.
   */
  public String getInvalidPatternErrorMessage() {
    return isNull(invalidPatternErrorMessage)
        ? "Value mismatch pattern [" + getPattern() + "]"
        : invalidPatternErrorMessage;
  }

  /**
   * Sets a custom error message for the "type mismatch" validation.
   *
   * @param typeMismatchErrorMessage The custom error message to display.
   * @return This `TextInputFormField` instance.
   */
  public T setTypeMismatchErrorMessage(String typeMismatchErrorMessage) {
    this.typeMismatchErrorMessage = typeMismatchErrorMessage;
    return (T) this;
  }

  /**
   * Gets the error message for the "type mismatch" validation.
   *
   * @return The error message for type mismatch.
   */
  private String getTypeMismatchErrorMessage() {
    return isNull(typeMismatchErrorMessage) ? "Invalid value" : typeMismatchErrorMessage;
  }
}
