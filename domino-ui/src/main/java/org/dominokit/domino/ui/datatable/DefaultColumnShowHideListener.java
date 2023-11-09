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
 * A default implementation of the {@link ColumnShowHideListener} interface for showing and hiding
 * columns in a data table.
 */
public class DefaultColumnShowHideListener implements ColumnShowHideListener {

  private HTMLElement element;
  private boolean permanent = false;

  /**
   * Creates a new instance of DefaultColumnShowHideListener with the specified HTML element.
   *
   * @param element The HTML element associated with this listener.
   */
  public static DefaultColumnShowHideListener of(HTMLElement element) {
    return new DefaultColumnShowHideListener(element);
  }

  /**
   * Creates a new instance of DefaultColumnShowHideListener with the specified HTML element and
   * permanence flag.
   *
   * @param element The HTML element associated with this listener.
   * @param permanent A flag indicating whether the column should be permanently shown or hidden.
   */
  public static DefaultColumnShowHideListener of(HTMLElement element, boolean permanent) {
    return new DefaultColumnShowHideListener(element, permanent);
  }

  /**
   * Constructs a DefaultColumnShowHideListener with the specified HTML element.
   *
   * @param element The HTML element associated with this listener.
   */
  public DefaultColumnShowHideListener(HTMLElement element) {
    this.element = element;
  }

  /**
   * Constructs a DefaultColumnShowHideListener with the specified HTML element and permanence flag.
   *
   * @param element The HTML element associated with this listener.
   * @param permanent A flag indicating whether the column should be permanently shown or hidden.
   */
  public DefaultColumnShowHideListener(HTMLElement element, boolean permanent) {
    this.element = element;
    this.permanent = permanent;
  }

  /**
   * Shows or hides the associated HTML element based on the visibility flag.
   *
   * @param visible A flag indicating whether the column should be visible or hidden.
   */
  @Override
  public void onShowHide(boolean visible) {
    elements.elementOf(element).toggleDisplay(visible);
  }

  /**
   * Checks if the column should be permanently shown or hidden.
   *
   * @return {@code true} if the column is permanent, {@code false} otherwise.
   */
  @Override
  public boolean isPermanent() {
    return permanent;
  }
}
