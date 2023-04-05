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
 import org.dominokit.domino.ui.forms.BigDecimalBox;

 import java.math.BigDecimal;

/**
 * BigDecimal column header filter component that is rendered as a {@link BigDecimalBox} component
 *
 * @param <T> type of data table records
 */
 public class DecimalHeaderFilter<T> extends DelayedHeaderFilterInput<BigDecimal, BigDecimalBox, T> {

  private BigDecimalBox decimalBox;

  public DecimalHeaderFilter() {}

  /**
   * Create and instance with custom placeholder
   *
   * @param placeholder String
   */
  public DecimalHeaderFilter(String placeholder) {
    super(placeholder);
  }

  /** create a new instance */
  public static <T> DecimalHeaderFilter<T> create() {
    return new DecimalHeaderFilter<>();
  }

  /**
   * creates a new instance with custom placeholder
   *
   * @param placeholder String
   * @param <T> type of the data table records
   * @return new instance
   */
  public static <T> DecimalHeaderFilter<T> create(String placeholder) {
    return new DecimalHeaderFilter<>(placeholder);
  }

  /** {@inheritDoc} */
  @Override
  protected HTMLInputElement getInputElement() {
    return decimalBox.getInputElement().element();
  }

  /** {@inheritDoc} */
  @Override
  protected BigDecimalBox createValueBox() {
    this.decimalBox = BigDecimalBox.create();
    return this.decimalBox;
  }

  @Override
  protected boolean isEmpty() {
    return this.decimalBox.isEmptyIgnoreSpaces();
  }

  /** {@inheritDoc} */
  @Override
  protected String getValue() {
    return this.decimalBox.getValue() + "";
  }

  /** {@inheritDoc} */
  @Override
  protected FilterTypes getType() {
    return FilterTypes.DECIMAL;
  }

  /** {@inheritDoc} */
  @Override
  public void clear() {
      decimalBox.withPausedChangeListeners(field -> {
          decimalBox.clear();
          decimalBox.getInputElement().element().value = "";
      });
  }

  /** @return the {@link BigDecimalBox} wrapped inside this filter component */
  public BigDecimalBox getDecimalBox() {
    return decimalBox;
  }
 }
