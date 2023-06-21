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
 * Short number column header filter component that is rendered as a {@link
 * org.dominokit.domino.ui.forms.ShortBox} component
 *
 * @param <T> type of data table records
 * @author vegegoku
 * @version $Id: $Id
 */
public class ShortHeaderFilter<T> extends DelayedHeaderFilterInput<ShortBox, T, Short> {

  private ShortBox shortBox;

  /** Default constructor */
  public ShortHeaderFilter() {}

  /**
   * Create and instance with custom placeholder
   *
   * @param placeholder String
   */
  public ShortHeaderFilter(String placeholder) {
    super(placeholder);
  }

  /**
   * create a new instance
   *
   * @param <T> a T class
   * @return a {@link org.dominokit.domino.ui.datatable.plugins.filter.header.ShortHeaderFilter}
   *     object
   */
  public static <T> ShortHeaderFilter<T> create() {
    return new ShortHeaderFilter<>();
  }

  /**
   * creates a new instance with custom placeholder
   *
   * @param placeholder String
   * @param <T> type of the data table records
   * @return new instance
   */
  public static <T> ShortHeaderFilter<T> create(String placeholder) {
    return new ShortHeaderFilter<>(placeholder);
  }

  /** {@inheritDoc} */
  @Override
  protected HTMLInputElement getInputElement() {
    return shortBox.getInputElement().element();
  }

  /** {@inheritDoc} */
  @Override
  protected ShortBox createValueBox() {
    this.shortBox = ShortBox.create();
    return this.shortBox;
  }

  /** {@inheritDoc} */
  @Override
  protected boolean isEmpty() {
    return this.shortBox.isEmptyIgnoreSpaces();
  }

  /** {@inheritDoc} */
  @Override
  protected String getValue() {
    return this.shortBox.getValue() + "";
  }

  /** {@inheritDoc} */
  @Override
  protected FilterTypes getType() {
    return FilterTypes.SHORT;
  }

  /** {@inheritDoc} */
  @Override
  public void clear() {
    shortBox.withPausedChangeListeners(
        field -> {
          shortBox.clear();
          shortBox.getInputElement().element().value = "";
        });
  }

  /** @return the {@link ShortBox} wrapped in this component */
  /**
   * Getter for the field <code>shortBox</code>.
   *
   * @return a {@link org.dominokit.domino.ui.forms.ShortBox} object
   */
  public ShortBox getShortBox() {
    return shortBox;
  }
}
