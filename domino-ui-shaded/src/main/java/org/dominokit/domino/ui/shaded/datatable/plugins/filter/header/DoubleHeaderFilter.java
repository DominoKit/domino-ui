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
package org.dominokit.domino.ui.shaded.datatable.plugins.filter.header;

import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.shaded.datatable.model.FilterTypes;
import org.dominokit.domino.ui.shaded.forms.DoubleBox;

/**
 * BigDecimal column header filter component that is rendered as a {@link DoubleBox} component
 *
 * @param <T> type of data table records
 */
@Deprecated
public class DoubleHeaderFilter<T> extends DelayedHeaderFilterInput<DoubleBox, T> {

  private DoubleBox doubleBox;

  /** Default constructor */
  public DoubleHeaderFilter() {}

  /**
   * Create and instance with custom placeholder
   *
   * @param placeholder String
   */
  public DoubleHeaderFilter(String placeholder) {
    super(placeholder);
  }

  /** create a new instance */
  public static <T> DoubleHeaderFilter<T> create() {
    return new DoubleHeaderFilter<>();
  }

  /**
   * creates a new instance with custom placeholder
   *
   * @param placeholder String
   * @param <T> type of the data table records
   * @return new instance
   */
  public static <T> DoubleHeaderFilter<T> create(String placeholder) {
    return new DoubleHeaderFilter<>(placeholder);
  }

  /** {@inheritDoc} */
  @Override
  protected HTMLInputElement getInputElement() {
    return doubleBox.getInputElement().element();
  }

  /** {@inheritDoc} */
  @Override
  protected DoubleBox createValueBox() {
    this.doubleBox = DoubleBox.create();
    return this.doubleBox;
  }

  /** {@inheritDoc} */
  @Override
  protected boolean isEmpty() {
    return this.doubleBox.isEmptyIgnoreSpaces();
  }

  /** {@inheritDoc} */
  @Override
  protected String getValue() {
    return this.doubleBox.getValue() + "";
  }

  /** {@inheritDoc} */
  @Override
  protected FilterTypes getType() {
    return FilterTypes.DOUBLE;
  }

  /** {@inheritDoc} */
  @Override
  public void clear() {
    doubleBox.pauseChangeHandlers();
    doubleBox.clear();
    doubleBox.getInputElement().element().value = "";
    doubleBox.resumeChangeHandlers();
  }

  /** @return the {@link DoubleBox} wrapped in this component */
  public DoubleBox getDoubleBox() {
    return doubleBox;
  }
}
