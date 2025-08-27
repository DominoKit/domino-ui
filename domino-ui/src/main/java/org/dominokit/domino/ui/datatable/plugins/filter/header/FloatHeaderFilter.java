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
import org.dominokit.domino.ui.datatable.model.FilterType;
import org.dominokit.domino.ui.datatable.model.FilterTypes;
import org.dominokit.domino.ui.forms.FloatBox;

/**
 * The FloatHeaderFilter class provides a header filter for filtering float values.
 *
 * @param <T> The type of data in the DataTable.
 */
public class FloatHeaderFilter<T> extends DelayedHeaderFilterInput<FloatBox, T, Float> {

  private FloatBox floatBox;

  /** Creates a new instance of FloatHeaderFilter with default placeholder. */
  public FloatHeaderFilter() {}

  /**
   * Creates a new instance of FloatHeaderFilter with a custom placeholder.
   *
   * @param placeholder The custom placeholder to display in the filter.
   */
  public FloatHeaderFilter(String placeholder) {
    super(placeholder);
  }

  /**
   * Creates a new instance of FloatHeaderFilter.
   *
   * @param <T> The type of data in the DataTable.
   * @return A new instance of FloatHeaderFilter.
   */
  public static <T> FloatHeaderFilter<T> create() {
    return new FloatHeaderFilter<>();
  }

  /**
   * Creates a new instance of FloatHeaderFilter with a custom placeholder.
   *
   * @param <T> The type of data in the DataTable.
   * @param placeholder The custom placeholder to display in the filter.
   * @return A new instance of FloatHeaderFilter with a custom placeholder.
   */
  public static <T> FloatHeaderFilter<T> create(String placeholder) {
    return new FloatHeaderFilter<>(placeholder);
  }

  /**
   * Gets the HTML input element used in the header filter.
   *
   * @return The HTML input element.
   */
  @Override
  protected HTMLInputElement getInputElement() {
    return floatBox.getInputElement().element();
  }

  /**
   * Creates the FloatBox value box for the header filter.
   *
   * @return The FloatBox value box.
   */
  @Override
  protected FloatBox createValueBox() {
    this.floatBox = FloatBox.create();
    return this.floatBox;
  }

  /**
   * Checks if the header filter input is empty.
   *
   * @return {@code true} if the input is empty, {@code false} otherwise.
   */
  @Override
  protected boolean isEmpty() {
    return this.floatBox.isEmptyIgnoreSpaces();
  }

  /**
   * Gets the value of the header filter input as a string.
   *
   * @return The value of the input as a string.
   */
  @Override
  protected String getValue() {
    return this.floatBox.getValue() + "";
  }

  /**
   * Gets the type of the header filter, which is FLOAT.
   *
   * @return The filter type as FilterTypes.FLOAT.
   */
  @Override
  protected FilterType getType() {
    return FilterTypes.FLOAT;
  }

  /** Clears the header filter by resetting the input. */
  @Override
  public void clear() {
    floatBox.withPausedChangeListeners(
        field -> {
          floatBox.clear();
          floatBox.getInputElement().element().value = "";
        });
  }

  /**
   * Gets the FloatBox value box used in the header filter.
   *
   * @return The FloatBox value box.
   */
  public FloatBox getFloatBox() {
    return floatBox;
  }
}
