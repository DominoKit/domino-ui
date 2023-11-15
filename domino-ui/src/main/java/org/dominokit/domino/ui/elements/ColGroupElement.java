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

import elemental2.dom.HTMLTableColElement;

/**
 * Represents a `<colgroup>` HTML element wrapper.
 *
 * <p>The `<colgroup>` tag is used to group one or more `<col>` elements in an HTML table and is
 * used for applying styles to multiple columns. This class provides a convenient way to create,
 * manipulate, and control the behavior of `<colgroup>` elements, making it easier to use them in
 * Java-based web applications. Example usage:
 *
 * <pre>{@code
 * HTMLTableColElement htmlElement = ...;  // Obtain a <colgroup> element from somewhere
 * ColGroupElement colGroupElement = ColGroupElement.of(htmlElement);
 * }</pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/colgroup">MDN Web Docs
 *     (colgroup element)</a>
 */
public class ColGroupElement extends BaseElement<HTMLTableColElement, ColGroupElement> {

  /**
   * Creates a new {@link ColGroupElement} instance by wrapping the provided HTML `<colgroup>`
   * element.
   *
   * @param e The HTML `<colgroup>` element.
   * @return A new {@link ColGroupElement} instance wrapping the provided element.
   */
  public static ColGroupElement of(HTMLTableColElement e) {
    return new ColGroupElement(e);
  }

  /**
   * Constructs a {@link ColGroupElement} instance by wrapping the provided HTML `<colgroup>`
   * element.
   *
   * @param element The HTML `<colgroup>` element to wrap.
   */
  public ColGroupElement(HTMLTableColElement element) {
    super(element);
  }
}
