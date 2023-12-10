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
import org.dominokit.domino.ui.forms.LongBox;

/**
 * The LongHeaderFilter class provides a header filter for filtering long values.
 *
 * @param <T> The type of data in the DataTable.
 */
public class LongHeaderFilter<T> extends DelayedHeaderFilterInput<LongBox, T, Long> {

  private LongBox longBox;

  /** Creates a new instance of LongHeaderFilter with default placeholder. */
  public LongHeaderFilter() {}

  /**
   * Creates a new instance of LongHeaderFilter with a custom placeholder.
   *
   * @param placeholder The custom placeholder to display in the filter.
   */
  public LongHeaderFilter(String placeholder) {
    super(placeholder);
  }

  /**
   * Creates a new instance of LongHeaderFilter.
   *
   * @param <T> The type of data in the DataTable.
   * @return A new instance of LongHeaderFilter.
   */
  public static <T> LongHeaderFilter<T> create() {
    return new LongHeaderFilter<>();
  }

  /**
   * Creates a new instance of LongHeaderFilter with a custom placeholder.
   *
   * @param <T> The type of data in the DataTable.
   * @param placeholder The custom placeholder to display in the filter.
   * @return A new instance of LongHeaderFilter with a custom placeholder.
   */
  public static <T> LongHeaderFilter<T> create(String placeholder) {
    return new LongHeaderFilter<>(placeholder);
  }

  /**
   * Gets the HTML input element used in the header filter.
   *
   * @return The HTML input element.
   */
  @Override
  protected HTMLInputElement getInputElement() {
    return longBox.getInputElement().element();
  }

  /**
   * Creates the LongBox value box for the header filter.
   *
   * @return The LongBox value box.
   */
  @Override
  protected LongBox createValueBox() {
    this.longBox = LongBox.create();
    return this.longBox;
  }

  /**
   * Checks if the header filter input is empty.
   *
   * @return {@code true} if the input is empty, {@code false} otherwise.
   */
  @Override
  protected boolean isEmpty() {
    return this.longBox.isEmptyIgnoreSpaces();
  }

  /**
   * Gets the value of the header filter input as a string.
   *
   * @return The value of the input as a string.
   */
  @Override
  protected String getValue() {
    return this.longBox.getValue() + "";
  }

  /**
   * Gets the type of the header filter, which is LONG.
   *
   * @return The filter type as FilterTypes.LONG.
   */
  @Override
  protected FilterTypes getType() {
    return FilterTypes.LONG;
  }

  /** Clears the header filter by resetting the input. */
  @Override
  public void clear() {
    longBox.withPausedChangeListeners(
        field -> {
          longBox.clear();
          longBox.getInputElement().element().value = "";
        });
  }

  /**
   * Gets the LongBox value box used in the header filter.
   *
   * @return The LongBox value box.
   */
  public LongBox getLongBox() {
    return longBox;
  }
}
