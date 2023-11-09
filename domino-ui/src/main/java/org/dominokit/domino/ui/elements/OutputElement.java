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

import elemental2.dom.HTMLOutputElement;

/**
 * Represents an HTML <output> element wrapper.
 *
 * <p>The HTML <output> element represents the result of a calculation or user action. This class
 * provides a convenient way to create, manipulate, and control the behavior of <output> elements in
 * Java-based web applications. Example usage:
 *
 * <pre>
 * HTMLOutputElement outputElement = ...;  // Obtain an <output> element from somewhere
 * OutputElement output = OutputElement.of(outputElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/output">MDN Web Docs
 *     (output)</a>
 */
public class OutputElement extends BaseElement<HTMLOutputElement, OutputElement> {

  /**
   * Creates a new {@link OutputElement} instance by wrapping the provided HTML <output> element.
   *
   * @param e The HTML <output> element to wrap.
   * @return A new {@link OutputElement} instance wrapping the provided element.
   */
  public static OutputElement of(HTMLOutputElement e) {
    return new OutputElement(e);
  }

  /**
   * Constructs an {@link OutputElement} instance by wrapping the provided HTML <output> element.
   *
   * @param element The HTML <output> element to wrap.
   */
  public OutputElement(HTMLOutputElement element) {
    super(element);
  }
}
