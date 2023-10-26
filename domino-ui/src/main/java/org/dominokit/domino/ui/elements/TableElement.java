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

import elemental2.dom.HTMLTableElement;

/**
 * Represents an HTML <table> element wrapper.
 * <p>
 * The HTML <table> element is used to create tables to organize and display data in tabular form. It can
 * contain various elements like <caption>, <thead>, <tfoot>, <tbody>, <tr>, <th>, and <td> to structure
 * the table.
 * This class provides a Java-based way to create, manipulate, and control the behavior of <table> elements
 * in web applications.
 * </p>
 *
 * Example usage:
 * <pre>
 * {@code
 * HTMLTableElement tableElement = ...;  // Obtain a <table> element from somewhere
 * TableElement table = TableElement.of(tableElement);
 * }
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/table">MDN Web Docs (table)</a>
 */
public class TableElement extends BaseElement<HTMLTableElement, TableElement> {

  /**
   * Creates a new {@link TableElement} instance by wrapping the provided HTML <table> element.
   *
   * @param e The HTML <table> element to wrap.
   * @return A new {@link TableElement} instance wrapping the provided element.
   */
  public static TableElement of(HTMLTableElement e) {
    return new TableElement(e);
  }

  /**
   * Constructs a {@link TableElement} instance by wrapping the provided HTML <table> element.
   *
   * @param element The HTML <table> element to wrap.
   */
  public TableElement(HTMLTableElement element) {
    super(element);
  }
}
