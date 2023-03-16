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
import static org.dominokit.domino.ui.forms.FormsStyles.FIELD_INPUT;

import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.utils.DominoElement;

public class TextBox extends TextInputFormField<TextBox, HTMLInputElement, String> {

  public static TextBox create() {
    return new TextBox();
  }

  public static TextBox create(String label) {
    return new TextBox(label);
  }

  public TextBox() {
    setDefaultValue("");
  }

  public TextBox(String label) {
    this();
    setLabel(label);
  }

  @Override
  public String getType() {
    return "text";
  }

  @Override
  protected DominoElement<HTMLInputElement> createInputElement(String type) {
    return input(type).addCss(FIELD_INPUT);
  }

  @Override
  public String getStringValue() {
    return getValue();
  }

  @Override
  protected void doSetValue(String value) {
    if (nonNull(value)) {
      getInputElement().element().value = value;
    } else {
      getInputElement().element().value = "";
    }
  }

  @Override
  public String getValue() {
    String value = getInputElement().element().value;
    if (value.isEmpty() && isEmptyAsNull()) {
      return null;
    }
    return value;
  }
}
