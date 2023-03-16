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

import elemental2.dom.HTMLElement;
import org.jboss.elemento.IsElement;

public class UtilityElement<T extends HTMLElement> extends BaseDominoElement<T, UtilityElement<T>> {

  private DominoElement<T> element;

  public static <T extends HTMLElement> UtilityElement<T> of(T element) {
    return new UtilityElement<>(element);
  }

  public static <T extends HTMLElement> UtilityElement<T> of(IsElement<T> element) {
    return new UtilityElement<>(element);
  }

  public UtilityElement(T element) {
    this.element = elementOf(element);
    init(this);
    addCss(dui_utility);
  }

  public UtilityElement(IsElement<T> element) {
    this(element.element());
  }

  @Override
  public T element() {
    return element.element();
  }
}
