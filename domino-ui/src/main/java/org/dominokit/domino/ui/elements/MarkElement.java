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

import elemental2.dom.HTMLElement;

/**
 * Represents an HTML <mark> element wrapper.
 *
 * <p>The HTML <mark> element represents text that should be marked or highlighted. This class
 * provides a convenient way to create, manipulate, and control the behavior of <mark> elements in
 * Java-based web applications. Example usage:
 *
 * <pre>
 * HTMLElement markElement = ...;  // Obtain a <mark> element from somewhere
 * MarkElement mark = MarkElement.of(markElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/mark">MDN Web Docs
 *     (mark)</a>
 */
public class MarkElement extends BaseElement<HTMLElement, MarkElement> {

  /**
   * Creates a new {@link MarkElement} instance by wrapping the provided HTML <mark> element.
   *
   * @param e The HTML <mark> element to wrap.
   * @return A new {@link MarkElement} instance wrapping the provided element.
   */
  public static MarkElement of(HTMLElement e) {
    return new MarkElement(e);
  }

  /**
   * Constructs a {@link MarkElement} instance by wrapping the provided HTML <mark> element.
   *
   * @param element The HTML <mark> element to wrap.
   */
  public MarkElement(HTMLElement element) {
    super(element);
  }
}
