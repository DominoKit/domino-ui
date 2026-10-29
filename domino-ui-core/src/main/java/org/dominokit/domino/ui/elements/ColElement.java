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

import elemental2.dom.HTMLTableColElement;

/**
 * Represents a `<col>` HTML element wrapper.
 *
 * <p>The `<col>` tag is used with the `<colgroup>` element to specify column properties for an HTML
 * table. This class offers a convenient way to create, manipulate, and control the behavior of
 * `<col>` elements, facilitating their use in Java-based web applications. Example usage:
 *
 * <pre>
 * HTMLTableColElement htmlElement = ...;  // Obtain a <col> element from somewhere
 * ColElement colElement = ColElement.of(htmlElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/col">MDN Web Docs (col
 *     element)</a>
 */
public class ColElement extends BaseElement<HTMLTableColElement, ColElement> {

  /**
   * Creates a new {@link ColElement} instance by wrapping the provided HTML `<col>` element.
   *
   * @param e The HTML `<col>` element.
   * @return A new {@link ColElement} instance wrapping the provided element.
   */
  public static ColElement of(HTMLTableColElement e) {
    return new ColElement(e);
  }

  /**
   * Constructs a {@link ColElement} instance by wrapping the provided HTML `<col>` element.
   *
   * @param element The HTML `<col>` element to wrap.
   */
  public ColElement(HTMLTableColElement element) {
    super(element);
  }
}
