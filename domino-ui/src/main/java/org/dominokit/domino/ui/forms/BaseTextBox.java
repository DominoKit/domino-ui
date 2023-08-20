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

/** Abstract BaseTextBox class. */
public abstract class BaseTextBox<T extends BaseTextBox<T>>
    extends TextInputFormField<T, HTMLInputElement, String> {

  /** Constructor for BaseTextBox. */
  public BaseTextBox() {
    setDefaultValue("");
  }

  /**
   * Constructor for BaseTextBox.
   *
   * @param label a {@link java.lang.String} object
   */
  public BaseTextBox(String label) {
    this();
    setLabel(label);
  }

  /** {@inheritDoc} */
  @Override
  protected DominoElement<HTMLInputElement> createInputElement(String type) {
    return input(type).addCss(dui_field_input).toDominoElement();
  }

  /** {@inheritDoc} */
  @Override
  public String getStringValue() {
    return getValue();
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
}
