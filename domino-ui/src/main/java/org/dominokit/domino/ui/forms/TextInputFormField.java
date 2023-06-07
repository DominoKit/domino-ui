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

import elemental2.dom.HTMLInputElement;
import jsinterop.base.Js;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.validations.ValidationResult;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.HasPostfix;
import org.dominokit.domino.ui.utils.HasPrefix;
import org.dominokit.domino.ui.utils.LazyChild;

import static java.util.Objects.isNull;

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


  public TextInputFormField() {
    prefixElement = LazyChild.of(div().addCss(dui_field_prefix), wrapperElement);
    postfixElement = LazyChild.of(div().addCss(dui_field_postfix), wrapperElement);
    addInvalidPatternValidator();
    addTypeMismatchValidator();
  }

  @Override
  public T setPostfix(String postfix) {
    postfixElement.get().setTextContent(postfix);
    return (T) this;
  }

  @Override
  public String getPostfix() {
    if (postfixElement.isInitialized()) {
      return postfixElement.get().getTextContent();
    }
    return "";
  }

  @Override
  public T setPrefix(String prefix) {
    prefixElement.get().setTextContent(prefix);
    return (T) this;
  }

  @Override
  public String getPrefix() {
    if (prefixElement.isInitialized()) {
      return prefixElement.get().getTextContent();
    }
    return "";
  }

  public DivElement getPrefixElement() {
    return prefixElement.get();
  }

  public DivElement getPostfixElement() {
    return postfixElement.get();
  }

  public T withPrefixElement() {
    prefixElement.get();
    return (T) this;
  }

  public T withPrefixElement(ChildHandler<T, DivElement> handler) {
    handler.apply((T) this, prefixElement.get());
    return (T) this;
  }

  public T withPostfixElement() {
    postfixElement.get();
    return (T) this;
  }

  public T withPostfixElement(ChildHandler<T, DivElement> handler) {
    handler.apply((T) this, postfixElement.get());
    return (T) this;
  }

  @Override
  public String getName() {
    return getInputElement().element().name;
  }

  @Override
  public T setName(String name) {
    getInputElement().element().name = name;
    return (T) this;
  }


  /**
   * Sets a pattern to be used for formatting this component value, this is the <b>pattern</b> html
   * attribute
   *
   * @param pattern String
   * @return same implementing component
   */
  public T setPattern(String pattern) {
    getInputElement().setAttribute("pattern", pattern);
    return (T) this;
  }

  /**
   * Sets a pattern to be used for formatting this component value, this is the <b>pattern</b> html
   * attribute
   *
   * @param pattern String
   * @param errorMessage String error message to be used when the field value does not match the
   *     provided pattern
   * @return same implementing component
   */
  public T setPattern(String pattern, String errorMessage) {
    setPattern(pattern);
    setInvalidPatternErrorMessage(errorMessage);
    return (T) this;
  }

  /** @return the value of the <b>pattern</b> attribute of this component input element */
  public String getPattern() {
    return getInputElement().getAttribute("pattern");
  }

  /**
   * @param invalidPatternErrorMessage String error message to be used when the field value does not
   *     match the provided pattern
   * @return same implementing component instance
   */
  public T setInvalidPatternErrorMessage(String invalidPatternErrorMessage) {
    this.invalidPatternErrorMessage = invalidPatternErrorMessage;
    return (T) this;
  }

  /**
   * @return the String error message to be used when the field value does not match the provided
   *     pattern
   */
  public String getInvalidPatternErrorMessage() {
    return isNull(invalidPatternErrorMessage)
            ? "Value mismatch pattern [" + getPattern() + "]"
            : invalidPatternErrorMessage;
  }

  public T setTypeMismatchErrorMessage(String typeMismatchErrorMessage) {
    this.typeMismatchErrorMessage = typeMismatchErrorMessage;
    return (T) this;
  }

  private String getTypeMismatchErrorMessage() {
    return isNull(typeMismatchErrorMessage) ? "Invalid value" : typeMismatchErrorMessage;
  }
}
