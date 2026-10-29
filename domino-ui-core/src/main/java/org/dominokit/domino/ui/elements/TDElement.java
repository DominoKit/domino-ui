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
 * Represents an HTML <td> (table cell) element wrapper.
 *
 * <p>The HTML <td> element defines a cell of a table that contains data. It is used to create
 * individual cells within a table row (<tr>) and contains the actual data or content of the cell.
 * The content of a <td> element can include text, images, links, and other HTML elements. This
 * class provides a Java-based way to create, manipulate, and control the behavior of <td> elements
 * in web applications. Example usage:
 *
 * <pre>
 * HTMLTableCellElement tdElement = ...;  // Obtain a <td> element from somewhere
 * TDElement td = TDElement.of(tdElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/td">MDN Web Docs (td)</a>
 */
public class TDElement extends BaseElement<HTMLTableCellElement, TDElement> {

  /**
   * Creates a new {@link TDElement} instance by wrapping the provided HTML <td> element.
   *
   * @param e The HTML <td> element to wrap.
   * @return A new {@link TDElement} instance wrapping the provided element.
   */
  public static TDElement of(HTMLTableCellElement e) {
    return new TDElement(e);
  }

  /**
   * Constructs a {@link TDElement} instance by wrapping the provided HTML <td> element.
   *
   * @param element The HTML <td> element to wrap.
   */
  public TDElement(HTMLTableCellElement element) {
    super(element);
  }
}
