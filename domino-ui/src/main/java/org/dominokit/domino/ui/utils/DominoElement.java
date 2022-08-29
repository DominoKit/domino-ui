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

import static elemental2.dom.DomGlobal.document;
import static org.dominokit.domino.ui.style.Styles.DUI;

import elemental2.dom.*;
import jsinterop.base.Js;
import org.dominokit.domino.ui.style.DominoStyle;
import org.jboss.elemento.Elements;
import org.jboss.elemento.Id;
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
    return new DominoElement<>(element).addCss(DUI);
  }

  /**
   * @param element the {@link IsElement} E to wrap as a DominoElement
   * @param <E> extends from {@link HTMLElement}
   * @return the {@link DominoElement} wrapping the provided element
   */
  public static <T extends HTMLElement, E extends IsElement<T>> DominoElement<T> of(E element) {
    return new DominoElement<>(element.element()).addCss(DUI);
  }

  /** @return a {@link DominoElement} wrapping the document {@link HTMLBodyElement} */
  public static DominoElement<HTMLBodyElement> body() {
    return new DominoElement<>(document.body);
  }

  /** @return a new {@link HTMLDivElement} wrapped as a {@link DominoElement} */
  public static DominoElement<HTMLDivElement> div() {
    return DominoElement.of(Elements.div());
  }

  public static DominoElement<HTMLElement> nav() {
    return DominoElement.of(Elements.nav());
  }

  public static DominoElement<HTMLHeadingElement> h4() {
    return DominoElement.of(Elements.h(4));
  }

  public static DominoElement<HTMLLabelElement> label() {
    return DominoElement.of(Elements.label());
  }

  public static DominoElement<HTMLElement> span() {
    return DominoElement.of(Elements.span());
  }

  public static DominoElement<HTMLElement> section() {
    return DominoElement.of(Elements.section());
  }

  public static DominoElement<HTMLElement> aside() {
    return DominoElement.of(Elements.aside());
  }

  public static DominoElement<HTMLElement> header() {
    return DominoElement.of(Elements.header());
  }

  /** @return a new {@link HTMLDivElement} wrapped as a {@link DominoElement} */
  public static DominoElement<HTMLPictureElement> picture() {
    return DominoElement.of(Js.<HTMLPictureElement>uncheckedCast(document.createElement("picture")))
        .addCss(DUI);
  }

  /** @param element the E element extending from {@link HTMLElement} */
  public DominoElement(E element) {
    this.wrappedElement = element;
    init(this);
  }

  public static DominoElement<HTMLInputElement> input(String type) {
    return DominoElement.of(Elements.input(type));
  }

  public static DominoElement<HTMLUListElement> ul() {
    return DominoElement.of(Elements.ul());
  }

  public static DominoElement<HTMLAnchorElement> a() {
    return DominoElement.of(Elements.a());
  }

  public static DominoElement<HTMLAnchorElement> a(String href) {
    return DominoElement.of(Elements.a(href));
  }

  public static DominoElement<HTMLLIElement> li() {
    return DominoElement.of(Elements.li());
  }

  public static DominoElement<HTMLElement> small() {
    return DominoElement.of(Elements.small());
  }

    public static DominoElement<HTMLFieldSetElement> fieldSet() {
    return DominoElement.of(Elements.fieldset());
    }

    public static String getUniqueId(){
      return Id.unique();
    }

    /**
   * @return the E element that is extending from {@link HTMLElement} wrapped in this DominoElement
   */
  @Override
  public E element() {
    return wrappedElement;
  }
}
