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

import elemental2.dom.HTMLTableSectionElement;

/**
 * Represents an HTML <tbody> (table body) element wrapper.
 *
 * <p>The HTML <tbody> element is used to group a set of table rows (<tr>) together in a table. It
 * is often used to separate the header and footer sections of a table from the main content. This
 * class provides a Java-based way to create, manipulate, and control the behavior of <tbody>
 * elements in web applications. Example usage:
 *
 * <pre>
 * HTMLTableSectionElement tbodyElement = ...;  // Obtain a <tbody> element from somewhere
 * TBodyElement tbody = TBodyElement.of(tbodyElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/tbody">MDN Web Docs
 *     (tbody)</a>
 */
public class TBodyElement extends BaseElement<HTMLTableSectionElement, TBodyElement> {

  /**
   * Creates a new {@link TBodyElement} instance by wrapping the provided HTML <tbody> element.
   *
   * @param e The HTML <tbody> element to wrap.
   * @return A new {@link TBodyElement} instance wrapping the provided element.
   */
  public static TBodyElement of(HTMLTableSectionElement e) {
    return new TBodyElement(e);
  }

  /**
   * Constructs a {@link TBodyElement} instance by wrapping the provided HTML <tbody> element.
   *
   * @param element The HTML <tbody> element to wrap.
   */
  public TBodyElement(HTMLTableSectionElement element) {
    super(element);
  }
}
