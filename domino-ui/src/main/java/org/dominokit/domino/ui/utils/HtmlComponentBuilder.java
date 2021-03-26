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
import elemental2.dom.Node;
import org.gwtproject.safehtml.shared.SafeHtml;
import org.jboss.elemento.HtmlContentBuilder;
import org.jboss.elemento.IsElement;

/**
 * a wrapper class that provides a basic builder pattern support for HTMLElements
 *
 * @param <E> The type of the HTMLElement
 * @param <T> the type of the wrapped {@link IsElement}
 */
public class HtmlComponentBuilder<E extends HTMLElement, T extends IsElement<E>>
    extends HtmlContentBuilder<E> {

  private T component;

  /** @param component the T {@link IsElement} component to be wrapped */
  public HtmlComponentBuilder(T component) {
    super(component.element());
    this.component = component;
  }

  /** @return the wrapped component */
  public T build() {
    return component;
  }

  /** {@inheritDoc} */
  @Override
  public HtmlComponentBuilder<E, T> innerHtml(SafeHtml html) {
    super.innerHtml(html);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HtmlComponentBuilder<E, T> add(IsElement<?> element) {
    super.add(element);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HtmlComponentBuilder<E, T> add(String text) {
    super.add(text);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HtmlComponentBuilder<E, T> add(Node element) {
    super.add(element);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HtmlComponentBuilder<E, T> addAll(HTMLElement... elements) {
    super.addAll(elements);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HtmlComponentBuilder<E, T> addAll(Iterable<?> elements) {
    super.addAll(elements);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public <F extends HTMLElement> HtmlComponentBuilder<E, T> addAll(IsElement<?>... elements) {
    super.addAll(elements);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HtmlComponentBuilder<E, T> textContent(String text) {
    super.textContent(text);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HtmlComponentBuilder<E, T> css(String... classes) {
    super.css(classes);
    return this;
  }
}
