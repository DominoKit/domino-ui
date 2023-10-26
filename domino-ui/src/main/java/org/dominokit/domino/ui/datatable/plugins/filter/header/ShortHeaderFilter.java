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
import org.dominokit.domino.ui.forms.ShortBox;

/**
 * The ShortHeaderFilter class provides a header filter for filtering short values.
 *
 * @param <T> The type of data in the DataTable.
 */
public class ShortHeaderFilter<T> extends DelayedHeaderFilterInput<ShortBox, T, Short> {

  private ShortBox shortBox;

  /** Creates a new instance of ShortHeaderFilter with no placeholder. */
  public ShortHeaderFilter() {}

  /**
   * Creates a new instance of ShortHeaderFilter with a custom placeholder.
   *
   * @param placeholder The custom placeholder text.
   */
  public ShortHeaderFilter(String placeholder) {
    super(placeholder);
  }

  /**
   * Creates a new instance of ShortHeaderFilter.
   *
   * @return The ShortHeaderFilter instance.
   */
  public static <T> ShortHeaderFilter<T> create() {
    return new ShortHeaderFilter<>();
  }

  /**
   * Creates a new instance of ShortHeaderFilter with a custom placeholder.
   *
   * @param placeholder The custom placeholder text.
   * @return The ShortHeaderFilter instance.
   */
  public static <T> ShortHeaderFilter<T> create(String placeholder) {
    return new ShortHeaderFilter<>(placeholder);
  }

  /**
   * Gets the HTMLInputElement used in the header filter.
   *
   * @return The HTMLInputElement element.
   */
  @Override
  protected HTMLInputElement getInputElement() {
    return shortBox.getInputElement().element();
  }

  /**
   * Creates the ShortBox value box used in the header filter.
   *
   * @return The ShortBox element.
   */
  @Override
  protected ShortBox createValueBox() {
    this.shortBox = ShortBox.create();
    return this.shortBox;
  }

  /**
   * Checks if the header filter input is empty.
   *
   * @return True if the input is empty, false otherwise.
   */
  @Override
  protected boolean isEmpty() {
    return this.shortBox.isEmptyIgnoreSpaces();
  }

  /**
   * Gets the value of the header filter input as a string.
   *
   * @return The value of the input as a string.
   */
  @Override
  protected String getValue() {
    return this.shortBox.getValue() + "";
  }

  /**
   * Gets the filter type of the header filter.
   *
   * @return The filter type.
   */
  @Override
  protected FilterTypes getType() {
    return FilterTypes.SHORT;
  }

  /** Clears the header filter by setting the input value to an empty string. */
  @Override
  public void clear() {
    shortBox.withPausedChangeListeners(
        field -> {
          shortBox.clear();
          shortBox.getInputElement().element().value = "";
        });
  }

  /**
   * Gets the ShortBox used in the header filter.
   *
   * @return The ShortBox element.
   */
  public ShortBox getShortBox() {
    return shortBox;
  }
}
