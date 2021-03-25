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

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLBodyElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.jboss.elemento.Elements;
import org.jboss.elemento.IsElement;

/**
 * A class that can wrap any HTMLElement as domino component
 *
 * @param <E> the type of the wrapped element
 */
public class DominoElement<E extends HTMLElement> extends BaseDominoElement<E, DominoElement<E>> {

  private final E wrappedElement;

  /**
   * @param element the {@link HTMLElement} E to wrap as a DominoElement
   * @param <E> extends from {@link HTMLElement}
   * @return the {@link DominoElement} wrapping the provided element
   */
  public static <E extends HTMLElement> DominoElement<E> of(E element) {
    return new DominoElement<>(element);
  }

  /**
   * @param element the {@link IsElement} E to wrap as a DominoElement
   * @param <E> extends from {@link HTMLElement}
   * @return the {@link DominoElement} wrapping the provided element
   */
  public static <E extends HTMLElement> DominoElement<E> of(IsElement<E> element) {
    return new DominoElement<>(element.element());
  }

  /** @return a {@link DominoElement} wrapping the document {@link HTMLBodyElement} */
  public static DominoElement<HTMLBodyElement> body() {
    return new DominoElement<>(DomGlobal.document.body);
  }

  /** @return a new {@link HTMLDivElement} wrapped as a {@link DominoElement} */
  public static DominoElement<HTMLDivElement> div() {
    return DominoElement.of(Elements.div());
  }

  /** @param element the E element extending from {@link HTMLElement} */
  public DominoElement(E element) {
    this.wrappedElement = element;
    init(this);
  }

  /**
   * @return the E element that is extending from {@link HTMLElement} wrapped in this DominoElement
   */
  @Override
  public E element() {
    return wrappedElement;
  }
}
