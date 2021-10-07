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

import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.forms.validations.InputAutoValidator;
import org.jboss.elemento.Elements;

/** A component that take/provide a single line String values */
public class TextBox extends AbstractValueBox<TextBox, HTMLInputElement, String> {

  private static final String TEXT = "text";
  private boolean emptyAsNull;

  /** */
  public TextBox() {
    this(TEXT, "");
  }

  /** @param label String */
  public TextBox(String label) {
    this(TEXT, label);
  }

  /**
   * @param type String html input element type
   * @param label String
   */
  public TextBox(String type, String label) {
    super(type, label);
  }

  /** @return new TextBox instance */
  public static TextBox create() {
    return new TextBox();
  }

  /**
   * @param label String
   * @return new TextBox instance
   */
  public static TextBox create(String label) {
    return new TextBox(label);
  }

  /**
   * Creates a password field, input type <b>password</b>
   *
   * @param label String label
   * @return new TextBox instance
   */
  public static TextBox password(String label) {
    return new TextBox("password", label);
  }

  /**
   * Creates a password field, input type <b>password</b>
   *
   * @return new TextBox instance
   */
  public static TextBox password() {
    return new TextBox("password", "");
  }

  /** {@inheritDoc} */
  @Override
  protected HTMLInputElement createInputElement(String type) {
    return Elements.input(type).element();
  }

  /** {@inheritDoc} */
  @Override
  protected void clearValue() {
    value("");
  }

  /** {@inheritDoc} */
  @Override
  protected void doSetValue(String value) {
    if (nonNull(value)) {
      getInputElement().element().value = value;
    } else {
      getInputElement().element().value = "";
    }
  }

  /** {@inheritDoc} */
  @Override
  public String getValue() {
    String value = getInputElement().element().value;
    if (value.isEmpty() && isEmptyAsNull()) {
      return null;
    }
    return value;
  }

  /**
   * @param type String html input type
   * @return same TextBox instance
   */
  public TextBox setType(String type) {
    getInputElement().element().type = type;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public String getStringValue() {
    return getValue();
  }

  /**
   * @param emptyAsNull boolean, if true empty value will be considered null otherwise its normal
   *     empty String
   * @return same TextBox instance
   */
  public TextBox setEmptyAsNull(boolean emptyAsNull) {
    this.emptyAsNull = emptyAsNull;
    return this;
  }

  /** @return boolean, true is {@link #setEmptyAsNull(boolean)} */
  public boolean isEmptyAsNull() {
    return emptyAsNull;
  }

  /** {@inheritDoc} */
  @Override
  protected AutoValidator createAutoValidator(AutoValidate autoValidate) {
    return new InputAutoValidator<>(autoValidate);
  }
}
