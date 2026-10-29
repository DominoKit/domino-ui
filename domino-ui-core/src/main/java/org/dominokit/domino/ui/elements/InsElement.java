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

import elemental2.dom.HTMLModElement;

/**
 * Represents an HTML <ins> element wrapper.
 *
 * <p>The HTML <ins> element is used to represent content that has been inserted into a document,
 * typically by underlining the inserted text. This class provides a convenient way to create,
 * manipulate, and control the behavior of <ins> elements in Java-based web applications. Example
 * usage:
 *
 * <pre>
 * HTMLModElement insElement = ...;  // Obtain an <ins> element from somewhere
 * InsElement ins = InsElement.of(insElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/ins">MDN Web Docs
 *     (ins)</a>
 */
public class InsElement extends BaseElement<HTMLModElement, InsElement> {

  /**
   * Creates a new {@link InsElement} instance by wrapping the provided HTML <ins> element.
   *
   * @param e The HTML <ins> element to wrap.
   * @return A new {@link InsElement} instance wrapping the provided element.
   */
  public static InsElement of(HTMLModElement e) {
    return new InsElement(e);
  }

  /**
   * Constructs a {@link InsElement} instance by wrapping the provided HTML <ins> element.
   *
   * @param element The HTML <ins> element to wrap.
   */
  public InsElement(HTMLModElement element) {
    super(element);
  }
}
