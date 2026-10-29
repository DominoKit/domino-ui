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

import elemental2.dom.HTMLTableCellElement;

/**
 * Represents an HTML <th> element wrapper.
 * <p>
 * The HTML <th> element defines a header cell in an HTML <table>. It is used to represent a column header in a table.
 * This class provides a Java-based way to create, manipulate, and control the behavior of <th> elements in web
 * applications.
 * </p>
 *
 * Example usage:
 * <pre>
 * {@code
 * HTMLTableCellElement thElement = ...;  // Obtain a <th> element from somewhere
 * THElement th = THElement.of(thElement);
 * }
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/th">MDN Web Docs (th)</a>
 */
public class THElement extends BaseElement<HTMLTableCellElement, THElement> {

  /**
   * Creates a new {@link THElement} instance by wrapping the provided HTML <th> element.
   *
   * @param e The HTML <th> element to wrap.
   * @return A new {@link THElement} instance wrapping the provided element.
   */
  public static THElement of(HTMLTableCellElement e) {
    return new THElement(e);
  }

  /**
   * Constructs a {@link THElement} instance by wrapping the provided HTML <th> element.
   *
   * @param element The HTML <th> element to wrap.
   */
  public THElement(HTMLTableCellElement element) {
    super(element);
  }
}
