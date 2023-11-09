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
import org.dominokit.domino.ui.forms.DoubleBox;

/**
 * The DoubleHeaderFilter class provides a header filter input field for filtering double values
 * with delayed search functionality.
 *
 * @param <T> The type of data in the DataTable.
 */
public class DoubleHeaderFilter<T> extends DelayedHeaderFilterInput<DoubleBox, T, Double> {

  private DoubleBox doubleBox;

  /** Creates a new instance of DoubleHeaderFilter with a default placeholder. */
  public DoubleHeaderFilter() {}

  /**
   * Creates a new instance of DoubleHeaderFilter with a specified placeholder.
   *
   * @param placeholder The placeholder text for the input field.
   */
  public DoubleHeaderFilter(String placeholder) {
    super(placeholder);
  }

  /**
   * Creates a new instance of DoubleHeaderFilter.
   *
   * @param <T> The type of data in the DataTable.
   * @return A new instance of DoubleHeaderFilter.
   */
  public static <T> DoubleHeaderFilter<T> create() {
    return new DoubleHeaderFilter<>();
  }

  /**
   * Creates a new instance of DoubleHeaderFilter with a specified placeholder.
   *
   * @param <T> The type of data in the DataTable.
   * @param placeholder The placeholder text for the input field.
   * @return A new instance of DoubleHeaderFilter with the specified placeholder.
   */
  public static <T> DoubleHeaderFilter<T> create(String placeholder) {
    return new DoubleHeaderFilter<>(placeholder);
  }

  /**
   * Gets the HTML input element used for filtering.
   *
   * @return The HTML input element.
   */
  @Override
  protected HTMLInputElement getInputElement() {
    return doubleBox.getInputElement().element();
  }

  /**
   * Creates the input field for filtering.
   *
   * @return The created input field instance.
   */
  @Override
  protected DoubleBox createValueBox() {
    this.doubleBox = DoubleBox.create();
    return this.doubleBox;
  }

  /**
   * Checks if the input field is empty.
   *
   * @return {@code true} if the input field is empty, {@code false} otherwise.
   */
  @Override
  protected boolean isEmpty() {
    return this.doubleBox.isEmptyIgnoreSpaces();
  }

  /**
   * Gets the value from the input field as a string.
   *
   * @return The value from the input field as a string.
   */
  @Override
  protected String getValue() {
    return this.doubleBox.getValue() + "";
  }

  /**
   * Gets the filter type for the input field.
   *
   * @return The filter type for the input field.
   */
  @Override
  protected FilterTypes getType() {
    return FilterTypes.DOUBLE;
  }

  /** Clears the input field. */
  @Override
  public void clear() {
    doubleBox.withPausedChangeListeners(
        field -> {
          doubleBox.clear();
          doubleBox.getInputElement().element().value = "";
        });
  }

  /**
   * Gets the DoubleBox instance used for filtering.
   *
   * @return The DoubleBox instance.
   */
  public DoubleBox getDoubleBox() {
    return doubleBox;
  }
}
