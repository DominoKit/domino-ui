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
package org.dominokit.domino.ui.datatable;

import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import elemental2.dom.HTMLElement;

/**
 * This implementation is default to show/hide any element whenever the table column visibility is
 * changed
 *
 * <p>e.g remove the column name a from a list of columns
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class DefaultColumnShowHideListener implements ColumnShowHideListener {

  private HTMLElement element;
  private boolean permanent = false;

  /**
   * Create an instance initialized with any custom element
   *
   * @param element {@link elemental2.dom.HTMLElement}
   * @return new {@link org.dominokit.domino.ui.datatable.DefaultColumnShowHideListener}
   */
  public static DefaultColumnShowHideListener of(HTMLElement element) {
    return new DefaultColumnShowHideListener(element);
  }

  /**
   * Create an instance initialized with any custom element and make it permanent
   *
   * @param element {@link elemental2.dom.HTMLElement}
   * @param permanent boolean, if true make this listener permanent so it wont be removed when the
   *     listeners are cleared
   * @return new {@link org.dominokit.domino.ui.datatable.DefaultColumnShowHideListener}
   */
  public static DefaultColumnShowHideListener of(HTMLElement element, boolean permanent) {
    return new DefaultColumnShowHideListener(element, permanent);
  }

  /**
   * Create an instance initialized with any custom element
   *
   * @param element {@link elemental2.dom.HTMLElement}
   */
  public DefaultColumnShowHideListener(HTMLElement element) {
    this.element = element;
  }

  /**
   * Create an instance initialized with any custom element and make it permanent
   *
   * @param element {@link elemental2.dom.HTMLElement}
   * @param permanent boolean, if true make this listener permanent so it wont be removed when the
   *     listeners are cleared
   */
  public DefaultColumnShowHideListener(HTMLElement element, boolean permanent) {
    this.element = element;
    this.permanent = permanent;
  }

  /** {@inheritDoc} */
  @Override
  public void onShowHide(boolean visible) {
    elements.elementOf(element).toggleDisplay(visible);
  }

  /** {@inheritDoc} */
  @Override
  public boolean isPermanent() {
    return permanent;
  }
}
