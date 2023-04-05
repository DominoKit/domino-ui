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
import static org.dominokit.domino.ui.forms.FormsStyles.*;

import elemental2.dom.EventListener;
import elemental2.dom.HTMLTextAreaElement;
import org.dominokit.domino.ui.utils.DominoElement;

public class TextAreaBox extends CountableInputFormField<TextAreaBox, HTMLTextAreaElement, String> {

  private EventListener autosizeListener = evt -> adjustHeight();
  private int rows;
  private boolean autoSize = false;

  public static TextAreaBox create() {
    return new TextAreaBox();
  }

  public static TextAreaBox create(String label) {
    return new TextAreaBox(label);
  }

  public TextAreaBox() {
    setRows(4);
    addCss(dui_form_text_area);
    wrapperElement.appendChild(div().addCss(dui_form_text_area_gap));
    onAttached(mutationRecord -> adjustHeight());
    setDefaultValue("");
    getInputElement().setAttribute("data-scroll", "0");
    getInputElement()
        .addEventListener(
            "scroll",
            evt ->
                getInputElement()
                    .element()
                    .setAttribute("data-scroll", getInputElement().element().scrollTop));
  }

  public TextAreaBox(String label) {
    this();
    setLabel(label);
  }

  public TextAreaBox setRows(int rows) {
    this.rows = rows;
    updateRows(rows);
    return this;
  }

  private void updateRows(int rows) {
    getInputElement().setAttribute("rows", rows + "");
  }

  @Override
  public String getStringValue() {
    return getValue();
  }

  @Override
  protected DominoElement<HTMLTextAreaElement> createInputElement(String type) {
    return textarea().addCss(dui_field_input).toDominoElement();
  }

  /** {@inheritDoc} */
  @Override
  protected void doSetValue(String value) {
    if (nonNull(value)) {
      getInputElement().element().value = value;
      if (isAttached()) {
        adjustHeight();
      }
    } else {
      getInputElement().element().value = "";
    }
  }

  /**
   * The TextArea will start with initial number of rows and will automatically grow if more lines
   * are added instead of showing scrollbars
   */
  public TextAreaBox autoSize() {
    getInputElement().addEventListener("input", autosizeListener);
    getInputElement().style().setOverFlow("hidden");
    updateRows(1);
    this.autoSize = true;
    return this;
  }

  /**
   * The TextArea will show scrollbars when the text rows exceeds the rows from {@link
   * #setRows(int)}
   *
   * @return same TextArea instance
   */
  public TextAreaBox fixedSize() {
    getInputElement().removeEventListener("input", autosizeListener);
    getInputElement().style().setOverFlow("");
    setRows(rows);
    this.autoSize = false;
    return this;
  }

  private void adjustHeight() {
    getInputElement().style().setHeight("auto");
    int scrollHeight = getInputElement().element().scrollHeight;
    if (scrollHeight < 30) {
      scrollHeight = 22;
    }
    if (autoSize) {
      getInputElement().style().setHeight(scrollHeight + "px");
    }
  }

  @Override
  public String getType() {
    return "text";
  }

  @Override
  public String getValue() {
    String value = getInputElement().element().value;
    if (value.isEmpty() && isEmptyAsNull()) {
      return null;
    }
    return value;
  }

  @Override
  public String getName() {
    return getInputElement().element().name;
  }

  @Override
  public TextAreaBox setName(String name) {
    getInputElement().element().name = name;
    return this;
  }
}
