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

import elemental2.dom.EventListener;
import elemental2.dom.HTMLTextAreaElement;
import org.dominokit.domino.ui.forms.validations.InputAutoValidator;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.Elements;

/** a component that takes/provide a multi-line String values */
@Deprecated
public class TextArea extends AbstractValueBox<TextArea, HTMLTextAreaElement, String> {

  private EventListener autosizeListener = evt -> adjustHeight();
  private int rows;
  private boolean autoSize = false;
  private boolean emptyAsNull;
  private boolean floating;

  /** */
  public TextArea() {
    this("");
  }

  /** @param label String */
  public TextArea(String label) {
    super("", label);
    setRows(4);
    css("auto-height");
    onAttached(mutationRecord -> adjustHeight());
  }

  /** @return new TextArea instance */
  public static TextArea create() {
    return new TextArea();
  }
  /**
   * @param label String
   * @return new TextArea instance
   */
  public static TextArea create(String label) {
    return new TextArea(label);
  }

  /** {@inheritDoc} */
  @Override
  protected HTMLTextAreaElement createInputElement(String type) {
    return DominoElement.of(Elements.textarea()).css("no-resize").element();
  }

  /**
   * @param rows int default number of rows of the TextArea
   * @return same TextArea instance
   */
  public TextArea setRows(int rows) {
    this.rows = rows;
    updateRows(rows);
    return this;
  }

  private void updateRows(int rows) {
    if (rows > 1) {
      floating = isFloating();
      floating();
    } else {
      if (floating) {
        floating();
      } else {
        nonfloating();
      }
    }
    getInputElement().setAttribute("rows", rows + "");
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

  /** {@inheritDoc} */
  @Override
  protected void clearValue(boolean silent) {
    value("", silent);
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
   * The TextArea will start with initial number of rows and will automatically grow if more lines
   * are added instead of showing scrollbars
   */
  public TextArea autoSize() {
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
  public TextArea fixedSize() {
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

  /** {@inheritDoc} */
  @Override
  public String getStringValue() {
    return getValue();
  }

  /**
   * @param emptyAsNull boolean, if true empty value will be considered null otherwise its normal
   *     empty String
   * @return same TextArea instance
   */
  public TextArea setEmptyAsNull(boolean emptyAsNull) {
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

  @Override
  protected void onEnterKey() {
    // do nothing for a text area.
  }
}
