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

import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.datatable.model.FilterTypes;
import org.dominokit.domino.ui.forms.TextBox;

/**
 * String column header filter component that is rendered as a {@link TextBox} component
 *
 * @param <T> type of data table records
 */
public class TextHeaderFilter<T> extends DelayedHeaderFilterInput<TextBox, T, String> {

  private TextBox textBox;

  /** Default constructor */
  public TextHeaderFilter() {}

  /**
   * Create and instance with custom placeholder
   *
   * @param placeholder String
   */
  public TextHeaderFilter(String placeholder) {
    super(placeholder);
  }

  /** create a new instance */
  public static <T> TextHeaderFilter<T> create() {
    return new TextHeaderFilter<>();
  }

  /**
   * creates a new instance with custom placeholder
   *
   * @param placeholder String
   * @param <T> type of the data table records
   * @return new instance
   */
  public static <T> TextHeaderFilter<T> create(String placeholder) {
    return new TextHeaderFilter<>(placeholder);
  }

  /** {@inheritDoc} */
  @Override
  protected HTMLInputElement getInputElement() {
    return this.textBox.getInputElement().element();
  }

  /** {@inheritDoc} */
  @Override
  protected TextBox createValueBox() {
    this.textBox = TextBox.create();
    return this.textBox;
  }

  /** {@inheritDoc} */
  @Override
  protected boolean isEmpty() {
    return this.textBox.isEmptyIgnoreSpaces();
  }

  /** {@inheritDoc} */
  @Override
  protected String getValue() {
    return this.textBox.getValue();
  }

  /** @return the {@link TextBox} wrapped in this component */
  public TextBox getTextBox() {
    return textBox;
  }

  /** {@inheritDoc} */
  @Override
  protected FilterTypes getType() {
    return FilterTypes.STRING;
  }

  /** {@inheritDoc} */
  @Override
  public void clear() {
    textBox.withPausedChangeListeners(
        field -> {
          textBox.clear();
        });
  }
}
