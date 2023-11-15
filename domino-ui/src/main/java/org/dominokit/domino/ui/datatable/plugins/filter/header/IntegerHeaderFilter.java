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
import org.dominokit.domino.ui.forms.IntegerBox;

/**
 * The IntegerHeaderFilter class provides a header filter for filtering integer values.
 *
 * @param <T> The type of data in the DataTable.
 */
public class IntegerHeaderFilter<T> extends DelayedHeaderFilterInput<IntegerBox, T, Integer> {

  private IntegerBox integerBox;

  /** Creates a new instance of IntegerHeaderFilter with default placeholder. */
  public IntegerHeaderFilter() {}

  /**
   * Creates a new instance of IntegerHeaderFilter with a custom placeholder.
   *
   * @param placeholder The custom placeholder to display in the filter.
   */
  public IntegerHeaderFilter(String placeholder) {
    super(placeholder);
  }

  /**
   * Creates a new instance of IntegerHeaderFilter.
   *
   * @param <T> The type of data in the DataTable.
   * @return A new instance of IntegerHeaderFilter.
   */
  public static <T> IntegerHeaderFilter<T> create() {
    return new IntegerHeaderFilter<>();
  }

  /**
   * Creates a new instance of IntegerHeaderFilter with a custom placeholder.
   *
   * @param <T> The type of data in the DataTable.
   * @param placeholder The custom placeholder to display in the filter.
   * @return A new instance of IntegerHeaderFilter with a custom placeholder.
   */
  public static <T> IntegerHeaderFilter<T> create(String placeholder) {
    return new IntegerHeaderFilter<>(placeholder);
  }

  /**
   * Gets the HTML input element used in the header filter.
   *
   * @return The HTML input element.
   */
  @Override
  protected HTMLInputElement getInputElement() {
    return integerBox.getInputElement().element();
  }

  /**
   * Creates the IntegerBox value box for the header filter.
   *
   * @return The IntegerBox value box.
   */
  @Override
  protected IntegerBox createValueBox() {
    this.integerBox = IntegerBox.create();
    return this.integerBox;
  }

  /**
   * Checks if the header filter input is empty.
   *
   * @return {@code true} if the input is empty, {@code false} otherwise.
   */
  @Override
  protected boolean isEmpty() {
    return this.integerBox.isEmptyIgnoreSpaces();
  }

  /**
   * Gets the value of the header filter input as a string.
   *
   * @return The value of the input as a string.
   */
  @Override
  protected String getValue() {
    return this.integerBox.getValue() + "";
  }

  /**
   * Gets the type of the header filter, which is INTEGER.
   *
   * @return The filter type as FilterTypes.INTEGER.
   */
  @Override
  protected FilterTypes getType() {
    return FilterTypes.INTEGER;
  }

  /** Clears the header filter by resetting the input. */
  @Override
  public void clear() {
    integerBox.withPausedChangeListeners(
        field -> {
          integerBox.clear();
          integerBox.getInputElement().element().value = "";
        });
  }

  /**
   * Gets the IntegerBox value box used in the header filter.
   *
   * @return The IntegerBox value box.
   */
  public IntegerBox getIntegerBox() {
    return integerBox;
  }
}
