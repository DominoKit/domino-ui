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
import org.dominokit.domino.ui.utils.DominoElement;

/**
 * Represents a base text box component that provides foundational behaviors and attributes for text
 * input form fields.
 *
 * <p>Usage example:
 *
 * <pre>
 * BaseTextBox&lt;?&gt; boxWithoutLabel = new BaseTextBox&lt;&gt;();
 * BaseTextBox&lt;?&gt; boxWithLabel = new BaseTextBox&lt;&gt;("Input Label:");
 * </pre>
 *
 * @param <T> the type of the implementing class, used for method chaining
 * @see TextInputFormField
 */
public abstract class BaseTextBox<T extends BaseTextBox<T>>
    extends TextInputFormField<T, HTMLInputElement, String> {

  /** Default constructor to create a base text box with a default empty value. */
  public BaseTextBox() {
    setDefaultValue("");
  }

  /**
   * Constructor that initializes the base text box with the given label.
   *
   * @param label the label for the base text box
   */
  public BaseTextBox(String label) {
    this();
    setLabel(label);
  }

  /**
   * Creates an input element of the specified type and applies default CSS for the base text box.
   *
   * <p>{@inheritDoc}
   *
   * @param type the type attribute of the input element
   * @return a new instance of {@link DominoElement} of {@link HTMLInputElement} type
   */
  @Override
  protected DominoElement<HTMLInputElement> createInputElement(String type) {
    return input(type).addCss(dui_field_input).toDominoElement();
  }

  /**
   * Retrieves the string value of the base text box, which is the text input from the user.
   * {@inheritDoc}
   *
   * @return the current value of the base text box
   */
  @Override
  public String getStringValue() {
    return getValue();
  }

  /**
   * Sets the value of the base text box. If the provided value is null, the value will be set to an
   * empty string.
   *
   * <p>{@inheritDoc}
   *
   * @param value the value to be set to the base text box
   */
  @Override
  protected void doSetValue(String value) {
    if (nonNull(value)) {
      getInputElement().element().value = value;
    } else {
      getInputElement().element().value = "";
    }
  }

  /**
   * Retrieves the value of the base text box. If the value is empty and is set to be treated as
   * null, this method will return null.
   *
   * <p>
   *
   * @return the current value of the base text box or null if the value is empty and treated as
   *     null
   */
  @Override
  public String getValue() {
    String value = getInputElement().element().value;
    if (value.isEmpty() && isEmptyAsNull()) {
      return null;
    }
    return value;
  }
}
