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
import java.math.BigDecimal;
import org.dominokit.domino.ui.datatable.model.FilterTypes;
import org.dominokit.domino.ui.forms.BigDecimalBox;

/**
 * The DecimalHeaderFilter class provides a header filter for decimal values in a DataTable. It
 * allows users to filter data based on decimal values.
 *
 * @param <T> The type of data in the DataTable.
 */
public class DecimalHeaderFilter<T> extends DelayedHeaderFilterInput<BigDecimalBox, T, BigDecimal> {

  private BigDecimalBox decimalBox;

  /** Creates a new instance of the DecimalHeaderFilter with an empty constructor. */
  public DecimalHeaderFilter() {}

  /**
   * Creates a new instance of the DecimalHeaderFilter with a specified placeholder.
   *
   * @param placeholder The placeholder text for the input field.
   */
  public DecimalHeaderFilter(String placeholder) {
    super(placeholder);
  }

  /**
   * Creates a new instance of the DecimalHeaderFilter with default settings.
   *
   * @param <T> The type of data in the DataTable.
   * @return A new DecimalHeaderFilter instance.
   */
  public static <T> DecimalHeaderFilter<T> create() {
    return new DecimalHeaderFilter<>();
  }

  /**
   * Creates a new instance of the DecimalHeaderFilter with a specified placeholder.
   *
   * @param <T> The type of data in the DataTable.
   * @param placeholder The placeholder text for the input field.
   * @return A new DecimalHeaderFilter instance with a custom placeholder.
   */
  public static <T> DecimalHeaderFilter<T> create(String placeholder) {
    return new DecimalHeaderFilter<>(placeholder);
  }

  /**
   * Gets the HTML input element used for filtering decimal values.
   *
   * @return The HTML input element.
   */
  @Override
  protected HTMLInputElement getInputElement() {
    return decimalBox.getInputElement().element();
  }

  /**
   * Creates the BigDecimalBox for handling decimal values.
   *
   * @return The created BigDecimalBox instance.
   */
  @Override
  protected BigDecimalBox createValueBox() {
    this.decimalBox = BigDecimalBox.create();
    return this.decimalBox;
  }

  /**
   * Checks if the BigDecimalBox is empty.
   *
   * @return {@code true} if the BigDecimalBox is empty, {@code false} otherwise.
   */
  @Override
  protected boolean isEmpty() {
    return this.decimalBox.isEmptyIgnoreSpaces();
  }

  /**
   * Gets the value from the BigDecimalBox as a string.
   *
   * @return The value as a string.
   */
  @Override
  protected String getValue() {
    return this.decimalBox.getValue() + "";
  }

  /**
   * Gets the filter type for decimal values.
   *
   * @return The filter type for decimal values.
   */
  @Override
  protected FilterTypes getType() {
    return FilterTypes.DECIMAL;
  }

  /** Clears the DecimalHeaderFilter by resetting the BigDecimalBox and the input field's value. */
  @Override
  public void clear() {
    decimalBox.withPausedChangeListeners(
        field -> {
          decimalBox.clear();
          decimalBox.getInputElement().element().value = "";
        });
  }

  /**
   * Gets the BigDecimalBox instance used for filtering decimal values.
   *
   * @return The BigDecimalBox instance.
   */
  public BigDecimalBox getDecimalBox() {
    return decimalBox;
  }
}
