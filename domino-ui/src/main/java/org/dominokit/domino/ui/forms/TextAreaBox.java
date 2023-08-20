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
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.FillerElement;
import org.dominokit.domino.ui.utils.LazyChild;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PrefixAddOn;
import org.dominokit.domino.ui.utils.PrimaryAddOn;

/** TextAreaBox class. */
public class TextAreaBox extends CountableInputFormField<TextAreaBox, HTMLTextAreaElement, String> {

  private EventListener autosizeListener = evt -> adjustHeight();
  private int rows;
  private boolean autoSize = false;

  private DivElement header;
  private LazyChild<FillerElement> headerFiller;

  /**
   * create.
   *
   * @return a {@link org.dominokit.domino.ui.forms.TextAreaBox} object
   */
  public static TextAreaBox create() {
    return new TextAreaBox();
  }

  /**
   * create.
   *
   * @param label a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.forms.TextAreaBox} object
   */
  public static TextAreaBox create(String label) {
    return new TextAreaBox(label);
  }

  /** Constructor for TextAreaBox. */
  public TextAreaBox() {
    setRows(4);
    addCss(dui_form_text_area);
    wrapperElement.appendChild(
        header =
            div()
                .addCss(
                    dui_form_text_area_header,
                    dui_hide_empty,
                    dui_flex,
                    dui_items_center,
                    dui_order_first));
    headerFiller = LazyChild.of(FillerElement.create().addCss(dui_order_30), header);
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

  /** {@inheritDoc} */
  @Override
  protected LazyChild<SpanElement> initCounterElement() {
    headerFiller.get();
    return counterElement = LazyChild.of(span().addCss(du_field_counter), header);
  }

  /** {@inheritDoc} */
  @Override
  public TextAreaBox appendChild(PrefixAddOn<?> addon) {
    header.appendChild(addon);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public TextAreaBox appendChild(PrimaryAddOn<?> addon) {
    header.appendChild(addon);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public TextAreaBox appendChild(PostfixAddOn<?> addon) {
    headerFiller.get();
    header.appendChild(addon);
    return this;
  }

  /**
   * Constructor for TextAreaBox.
   *
   * @param label a {@link java.lang.String} object
   */
  public TextAreaBox(String label) {
    this();
    setLabel(label);
  }

  /**
   * Setter for the field <code>rows</code>.
   *
   * @param rows a int
   * @return a {@link org.dominokit.domino.ui.forms.TextAreaBox} object
   */
  public TextAreaBox setRows(int rows) {
    this.rows = rows;
    updateRows(rows);
    return this;
  }

  private void updateRows(int rows) {
    getInputElement().setAttribute("rows", rows + "");
  }

  /** {@inheritDoc} */
  @Override
  public String getStringValue() {
    return getValue();
  }

  /** {@inheritDoc} */
  @Override
  protected DominoElement<HTMLTextAreaElement> createInputElement(String type) {
    return textarea()
        .addCss(dui_field_input)
        .setCssProperty("line-height", "26px")
        .toDominoElement();
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
   *
   * @return a {@link org.dominokit.domino.ui.forms.TextAreaBox} object
   */
  public TextAreaBox autoSize() {
    getInputElement().addEventListener("input", autosizeListener);
    getInputElement().style().setOverFlowY("hidden");
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
    getInputElement().style().setOverFlowY("");
    setRows(rows);
    this.autoSize = false;
    return this;
  }

  private void adjustHeight() {
    getInputElement().style().setHeight("auto");
    int scrollHeight = getInputElement().element().scrollHeight;
    if (scrollHeight < 30) {
      scrollHeight = 28;
    }
    if (autoSize) {
      getInputElement().style().setHeight(scrollHeight + "px");
    }
  }

  /** {@inheritDoc} */
  @Override
  public String getType() {
    return "text";
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

  /** {@inheritDoc} */
  @Override
  public String getName() {
    return getInputElement().element().name;
  }

  /** {@inheritDoc} */
  @Override
  public TextAreaBox setName(String name) {
    getInputElement().element().name = name;
    return this;
  }
}
