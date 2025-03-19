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
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.EventListener;
import elemental2.dom.HTMLTextAreaElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.FillerElement;
import org.dominokit.domino.ui.utils.IntersectionObserver;
import org.dominokit.domino.ui.utils.IntersectionObserverEntry;
import org.dominokit.domino.ui.utils.IntersectionObserverOptions;
import org.dominokit.domino.ui.utils.LazyChild;
import org.dominokit.domino.ui.utils.PostfixElement;
import org.dominokit.domino.ui.utils.PrefixElement;
import org.dominokit.domino.ui.utils.PrimaryAddOnElement;

/**
 * The TextAreaBox class is a form field component for text areas, providing features such as prefix
 * and postfix elements, auto-sizing, and value adjustments.
 *
 * <p>Usage Example:
 *
 * <pre>
 * // Create a TextAreaBox with auto-sizing
 * TextAreaBox textArea = TextAreaBox.create().autoSize().setRows(4);
 *
 * // Create a TextAreaBox with a label
 * TextAreaBox labeledTextArea = TextAreaBox.create("Comments");
 * </pre>
 *
 * @see CountableInputFormField
 * @see InputFormField
 */
public class TextAreaBox extends CountableInputFormField<TextAreaBox, HTMLTextAreaElement, String> {

  private EventListener autosizeListener = evt -> adjustHeight();
  private int rows;
  private boolean autoSize = false;

  private DivElement header;
  private FillerElement headerFiller;
  private IntersectionObserver intersectionObserver;

  /**
   * Factory method to create a new instance of {@link TextAreaBox}.
   *
   * @return a new instance of TextAreaBox
   */
  public static TextAreaBox create() {
    return new TextAreaBox();
  }

  /**
   * Factory method to create a new instance of {@link TextAreaBox} with a label.
   *
   * @param label the label for the text area
   * @return a new instance of TextAreaBox with the provided label
   */
  public static TextAreaBox create(String label) {
    return new TextAreaBox(label);
  }

  /** Creates a new TextAreaBox instance with default values. */
  public TextAreaBox() {
    setRows(4);
    addCss(dui_form_text_area);
    wrapperElement
        .appendChild(
            header =
                div()
                    .addCss(
                        dui_form_text_area_header,
                        dui_hide_empty,
                        dui_flex,
                        dui_items_center,
                        dui_order_first))
        .addCss(dui_h_inherit);
    bodyElement.addCss(dui_h_inherit);

    header.appendChild(
        headerFiller =
            FillerElement.create().addCss(dui_form_text_area_header_filler, dui_order_30));
    onAttached((e, mutationRecord) -> adjustHeight());
    setDefaultValue("");
    getInputElement().addCss(dui_h_inherit).setAttribute("data-scroll", "0");
    getInputElement()
        .addEventListener(
            "scroll",
            evt ->
                getInputElement()
                    .element()
                    .setAttribute("data-scroll", getInputElement().element().scrollTop));

    intersectionObserver =
        new IntersectionObserver(
            entries -> {
              IntersectionObserverEntry entry = entries.asList().get(0);
              if (entry.getIsIntersecting()) {
                adjustHeight();
                intersectionObserver.unobserve(this.element());
                intersectionObserver.disconnect();
              }
            },
            IntersectionObserverOptions.create());
    intersectionObserver.observe(this.element());
  }

  @Override
  protected LazyChild<SpanElement> initCounterElement() {
    return counterElement = LazyChild.of(span().addCss(du_field_counter), header);
  }

  /**
   * Creates a new TextAreaBox instance with the specified label.
   *
   * @param label The label text for the TextAreaBox.
   */
  public TextAreaBox(String label) {
    this();
    setLabel(label);
  }

  @Override
  public PrefixElement getPrefixElement() {
    return PrefixElement.of(header);
  }

  @Override
  public PostfixElement getPostfixElement() {
    return PostfixElement.of(header);
  }

  @Override
  public PrimaryAddOnElement getPrimaryAddonsElement() {
    return PrimaryAddOnElement.of(header);
  }

  /**
   * Sets the number of rows for the text area.
   *
   * @param rows The number of rows to set.
   * @return This `TextAreaBox` instance.
   */
  public TextAreaBox setRows(int rows) {
    this.rows = rows;
    updateRows(rows);
    return this;
  }

  private void updateRows(int rows) {
    getInputElement().setAttribute("rows", rows + "");
  }

  /**
   * Gets the string value of this TextAreaBox, which is equivalent to its current value.
   *
   * @return The string value of this TextAreaBox.
   */
  @Override
  public String getStringValue() {
    return getValue();
  }

  @Override
  protected DominoElement<HTMLTextAreaElement> createInputElement(String type) {
    return textarea()
        .addCss(dui_field_input)
        .setCssProperty("line-height", "26px")
        .toDominoElement();
  }

  /**
   * Sets the value of the text area.
   *
   * @param value The value to set.
   */
  @Override
  protected void doSetValue(String value) {
    if (nonNull(value)) {
      getInputElement().element().value = value;
    } else {
      getInputElement().element().value = "";
    }
    nowOrWhenAttached(this::adjustHeight);
    updateCounter(getLength(), getMaxCount());
  }

  /**
   * Enables auto-sizing for the text area, allowing it to adjust its height automatically as the
   * content grows.
   *
   * @return This `TextAreaBox` instance.
   */
  public TextAreaBox autoSize() {
    getInputElement().addEventListener("input", autosizeListener);
    getInputElement().style().setOverFlowY("hidden");
    updateRows(1);
    this.autoSize = true;
    return this;
  }

  /**
   * Disables auto-sizing for the text area, fixing its height to the specified number of rows.
   *
   * @return This `TextAreaBox` instance.
   */
  public TextAreaBox fixedSize() {
    getInputElement().removeEventListener("input", autosizeListener);
    getInputElement().style().setOverFlowY("");
    setRows(rows);
    this.autoSize = false;
    return this;
  }

  /** Adjusts the height of the text area based on its content. */
  private void adjustHeight() {

    if (autoSize) {
      getInputElement().style().setHeight("auto");
      int scrollHeight = getInputElement().element().scrollHeight;
      getInputElement().style().setHeight(Math.max(scrollHeight, 28) + "px");
    }
  }

  /**
   * Gets the type of the text area field.
   *
   * @return The type, which is always "text".
   */
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

  /**
   * Gets the name attribute of the text area.
   *
   * @return The name attribute value.
   */
  @Override
  public String getName() {
    return getInputElement().element().name;
  }

  /**
   * Sets the name attribute for the text area.
   *
   * @param name The name attribute value to set.
   * @return This `TextAreaBox` instance.
   */
  @Override
  public TextAreaBox setName(String name) {
    getInputElement().element().name = name;
    return this;
  }
}
