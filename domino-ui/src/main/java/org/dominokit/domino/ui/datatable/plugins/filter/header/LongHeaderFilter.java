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
import org.dominokit.domino.ui.forms.LongBox;

/**
 * Long column header filter component that is rendered as a {@link
 * org.dominokit.domino.ui.forms.LongBox} component
 *
 * @param <T> type of data table records
 */
public class LongHeaderFilter<T> extends DelayedHeaderFilterInput<LongBox, T, Long> {

  private LongBox longBox;

  /** Default constructor */
  public LongHeaderFilter() {}

  /**
   * Create and instance with custom placeholder
   *
   * @param placeholder String
   */
  public LongHeaderFilter(String placeholder) {
    super(placeholder);
  }

  /**
   * create a new instance
   *
   * @param <T> a T class
   * @return a {@link org.dominokit.domino.ui.datatable.plugins.filter.header.LongHeaderFilter}
   *     object
   */
  public static <T> LongHeaderFilter<T> create() {
    return new LongHeaderFilter<>();
  }

  /**
   * creates a new instance with custom placeholder
   *
   * @param placeholder String
   * @param <T> type of the data table records
   * @return new instance
   */
  public static <T> LongHeaderFilter<T> create(String placeholder) {
    return new LongHeaderFilter<>(placeholder);
  }

  /** {@inheritDoc} */
  @Override
  protected HTMLInputElement getInputElement() {
    return longBox.getInputElement().element();
  }

  /** {@inheritDoc} */
  @Override
  protected LongBox createValueBox() {
    this.longBox = LongBox.create();
    return this.longBox;
  }

  /** {@inheritDoc} */
  @Override
  protected boolean isEmpty() {
    return this.longBox.isEmptyIgnoreSpaces();
  }

  /** {@inheritDoc} */
  @Override
  protected String getValue() {
    return this.longBox.getValue() + "";
  }

  /** {@inheritDoc} */
  @Override
  protected FilterTypes getType() {
    return FilterTypes.LONG;
  }

  /** {@inheritDoc} */
  @Override
  public void clear() {
    longBox.withPausedChangeListeners(
        field -> {
          longBox.clear();
          longBox.getInputElement().element().value = "";
        });
  }

  /** @return the {@link LongBox} wrapped in this component */
  /**
   * Getter for the field <code>longBox</code>.
   *
   * @return a {@link org.dominokit.domino.ui.forms.LongBox} object
   */
  public LongBox getLongBox() {
    return longBox;
  }
}
