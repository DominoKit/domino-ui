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
package org.dominokit.domino.ui.elements;

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLElement;

/**
 * Represents a `<cite>` HTML element wrapper.
 *
 * <p>The `<cite>` tag defines the title of a creative work (e.g. a book, a song, a movie, a TV
 * show, a painting, a sculpture, etc.). This class provides a convenient way to create, manipulate,
 * and control the behavior of `<cite>` elements. Example usage:
 *
 * <pre>
 * HTMLElement htmlElement = ...;  // Obtain a <cite> element from somewhere
 * CiteElement citeElement = CiteElement.of(htmlElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/cite">MDN Web Docs (cite
 *     element)</a>
 */
public class CiteElement extends BaseElement<HTMLElement, CiteElement> {

  /**
   * Creates a new {@link CiteElement} instance by wrapping the provided HTML `<cite>` element.
   *
   * @param e The HTML `<cite>` element.
   * @return A new {@link CiteElement} instance wrapping the provided element.
   */
  public static CiteElement of(HTMLElement e) {
    return new CiteElement(e);
  }

  /**
   * Constructs a {@link CiteElement} instance by wrapping the provided HTML `<cite>` element.
   *
   * @param element The HTML `<cite>` element to wrap.
   */
  public CiteElement(HTMLElement element) {
    super(element);
  }
}
