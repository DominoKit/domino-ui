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

import elemental2.dom.HTMLPreElement;

/**
 * Represents an HTML <pre> element wrapper.
 * <p>
 * The HTML <pre> element defines preformatted text. This element is used to display text where whitespace and line breaks
 * inside the <pre> element are rendered as written. It is often used for displaying code snippets or any text where
 * formatting is important.
 * This class provides a Java-based way to create, manipulate, and control the behavior of <pre> elements in web applications.
 * </p>
 *
 * Example usage:
 * <pre>
 * {@code
 * HTMLPreElement preElement = ...;  // Obtain a <pre> element from somewhere
 * PreElement pre = PreElement.of(preElement);
 * }
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/pre">MDN Web Docs (pre)</a>
 */
public class PreElement extends BaseElement<HTMLPreElement, PreElement> {

  /**
   * Creates a new {@link PreElement} instance by wrapping the provided HTML <pre> element.
   *
   * @param e The HTML <pre> element to wrap.
   * @return A new {@link PreElement} instance wrapping the provided element.
   */
  public static PreElement of(HTMLPreElement e) {
    return new PreElement(e);
  }

  /**
   * Constructs a {@link PreElement} instance by wrapping the provided HTML <pre> element.
   *
   * @param element The HTML <pre> element to wrap.
   */
  public PreElement(HTMLPreElement element) {
    super(element);
  }
}
