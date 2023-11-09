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

import elemental2.dom.HTMLTableCaptionElement;

/**
 * Represents an HTML <caption> element wrapper for tables.
 *
 * <p>The HTML <caption> element is used to define a title or explanation for a table. It is placed
 * just before the table within the table's parent element. This class provides a Java-based way to
 * create, manipulate, and control the behavior of <caption> elements in web applications. Example
 * usage:
 *
 * <pre>
 * HTMLTableCaptionElement captionElement = ...;  // Obtain a <caption> element from somewhere
 * TableCaptionElement caption = TableCaptionElement.of(captionElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/caption">MDN Web Docs
 *     (caption)</a>
 */
public class TableCaptionElement extends BaseElement<HTMLTableCaptionElement, TableCaptionElement> {

  /**
   * Creates a new {@link TableCaptionElement} instance by wrapping the provided HTML <caption>
   * element.
   *
   * @param e The HTML <caption> element to wrap.
   * @return A new {@link TableCaptionElement} instance wrapping the provided element.
   */
  public static TableCaptionElement of(HTMLTableCaptionElement e) {
    return new TableCaptionElement(e);
  }

  /**
   * Constructs a {@link TableCaptionElement} instance by wrapping the provided HTML <caption>
   * element.
   *
   * @param element The HTML <caption> element to wrap.
   */
  public TableCaptionElement(HTMLTableCaptionElement element) {
    super(element);
  }
}
