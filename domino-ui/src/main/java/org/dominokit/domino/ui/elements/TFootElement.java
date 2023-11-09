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
 * Represents an HTML <tfoot> element wrapper.
 * <p>
 * The HTML <tfoot> element defines a footer for an HTML <table> element. It contains information about the table's
 * footer or other metadata. Typically, the content inside a <tfoot> element consists of summary or footer information
 * related to the data presented in the table.
 * This class provides a Java-based way to create, manipulate, and control the behavior of <tfoot> elements in web
 * applications.
 * </p>
 *
 * Example usage:
 * <pre>
 * {@code
 * HTMLTableSectionElement tfootElement = ...;  // Obtain a <tfoot> element from somewhere
 * TFootElement tfoot = TFootElement.of(tfootElement);
 * }
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/tfoot">MDN Web Docs (tfoot)</a>
 */
public class TFootElement extends BaseElement<HTMLTableSectionElement, TFootElement> {

  /**
   * Creates a new {@link TFootElement} instance by wrapping the provided HTML <tfoot> element.
   *
   * @param e The HTML <tfoot> element to wrap.
   * @return A new {@link TFootElement} instance wrapping the provided element.
   */
  public static TFootElement of(HTMLTableSectionElement e) {
    return new TFootElement(e);
  }

  /**
   * Constructs a {@link TFootElement} instance by wrapping the provided HTML <tfoot> element.
   *
   * @param element The HTML <tfoot> element to wrap.
   */
  public TFootElement(HTMLTableSectionElement element) {
    super(element);
  }
}
