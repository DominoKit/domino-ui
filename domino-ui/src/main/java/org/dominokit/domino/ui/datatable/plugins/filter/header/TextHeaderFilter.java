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

package org.dominokit.domino.ui.datatable.plugins.filter.header;

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.datatable.model.FilterTypes;
import org.dominokit.domino.ui.forms.TextBox;

/**
 * The TextHeaderFilter class provides a header filter for filtering text values.
 *
 * @param <T> The type of data in the DataTable.
 */
public class TextHeaderFilter<T> extends DelayedHeaderFilterInput<TextBox, T, String> {

  private TextBox textBox;

  /** Creates a new instance of TextHeaderFilter with no placeholder. */
  public TextHeaderFilter() {}

  /**
   * Creates a new instance of TextHeaderFilter with a custom placeholder.
   *
   * @param placeholder The custom placeholder text.
   */
  public TextHeaderFilter(String placeholder) {
    super(placeholder);
  }

  /**
   * Creates a new instance of TextHeaderFilter.
   *
   * @return The TextHeaderFilter instance.
   */
  public static <T> TextHeaderFilter<T> create() {
    return new TextHeaderFilter<>();
  }

  /**
   * Creates a new instance of TextHeaderFilter with a custom placeholder.
   *
   * @param placeholder The custom placeholder text.
   * @return The TextHeaderFilter instance.
   */
  public static <T> TextHeaderFilter<T> create(String placeholder) {
    return new TextHeaderFilter<>(placeholder);
  }

  /**
   * Gets the HTMLInputElement used in the header filter.
   *
   * @return The HTMLInputElement element.
   */
  @Override
  protected HTMLInputElement getInputElement() {
    return this.textBox.getInputElement().element();
  }

  /**
   * Creates the TextBox value box used in the header filter.
   *
   * @return The TextBox element.
   */
  @Override
  protected TextBox createValueBox() {
    this.textBox = TextBox.create();
    return this.textBox;
  }

  /**
   * Checks if the header filter input is empty.
   *
   * @return True if the input is empty, false otherwise.
   */
  @Override
  protected boolean isEmpty() {
    return this.textBox.isEmptyIgnoreSpaces();
  }

  /**
   * Gets the value of the header filter input as a string.
   *
   * @return The value of the input as a string.
   */
  @Override
  protected String getValue() {
    return this.textBox.getValue();
  }

  /**
   * Gets the TextBox used in the header filter.
   *
   * @return The TextBox element.
   */
  public TextBox getTextBox() {
    return textBox;
  }

  /**
   * Gets the filter type of the header filter.
   *
   * @return The filter type.
   */
  @Override
  protected FilterTypes getType() {
    return FilterTypes.STRING;
  }

  /** Clears the header filter by calling the clear method on the TextBox. */
  @Override
  public void clear() {
    textBox.withPausedChangeListeners(field -> textBox.clear());
  }
}
