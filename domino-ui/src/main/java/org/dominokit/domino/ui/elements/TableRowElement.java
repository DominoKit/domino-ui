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

import elemental2.dom.HTMLTableRowElement;

/**
 * Represents an HTML <tr> (table row) element wrapper.
 *
 * <p>The HTML <tr> element is used to define a row in an HTML table. It can contain one or more
 * table data cells (<td>) and/or table header cells (<th>) within it. This class provides a
 * Java-based way to create, manipulate, and control the behavior of <tr> elements in web
 * applications. Example usage:
 *
 * <pre>{@code
 * HTMLTableRowElement rowElement = ...;  // Obtain a <tr> element from somewhere
 * TableRowElement row = TableRowElement.of(rowElement);
 * }</pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/tr">MDN Web Docs (tr)</a>
 */
public class TableRowElement extends BaseElement<HTMLTableRowElement, TableRowElement> {

  /**
   * Creates a new {@link TableRowElement} instance by wrapping the provided HTML <tr> element.
   *
   * @param e The HTML <tr> element to wrap.
   * @return A new {@link TableRowElement} instance wrapping the provided element.
   */
  public static TableRowElement of(HTMLTableRowElement e) {
    return new TableRowElement(e);
  }

  /**
   * Constructs a {@link TableRowElement} instance by wrapping the provided HTML <tr> element.
   *
   * @param element The HTML <tr> element to wrap.
   */
  public TableRowElement(HTMLTableRowElement element) {
    super(element);
  }
}
