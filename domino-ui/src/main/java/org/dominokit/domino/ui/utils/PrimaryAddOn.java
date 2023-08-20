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
package org.dominokit.domino.ui.utils;

import elemental2.dom.Element;
import org.dominokit.domino.ui.IsElement;

/** PrimaryAddOn class. */
public class PrimaryAddOn<T extends Element> extends BaseDominoElement<T, PrimaryAddOn<T>> {

  private DominoElement<T> element;

  /**
   * of.
   *
   * @param element a T object
   * @param <T> a T class
   * @return a {@link org.dominokit.domino.ui.utils.PrimaryAddOn} object
   */
  public static <T extends Element> PrimaryAddOn<T> of(T element) {
    return new PrimaryAddOn<>(element);
  }

  /**
   * of.
   *
   * @param element a {@link org.dominokit.domino.ui.IsElement} object
   * @param <T> a T class
   * @return a {@link org.dominokit.domino.ui.utils.PrimaryAddOn} object
   */
  public static <T extends Element> PrimaryAddOn<T> of(IsElement<T> element) {
    return new PrimaryAddOn<>(element);
  }

  /**
   * Constructor for PrimaryAddOn.
   *
   * @param element a T object
   */
  public PrimaryAddOn(T element) {
    this.element = elementOf(element);
    init(this);
    addCss(dui_primary_addon);
  }

  /**
   * Constructor for PrimaryAddOn.
   *
   * @param element a {@link org.dominokit.domino.ui.IsElement} object
   */
  public PrimaryAddOn(IsElement<T> element) {
    this(element.element());
  }

  /** {@inheritDoc} */
  @Override
  public T element() {
    return element.element();
  }
}
