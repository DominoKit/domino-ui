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

import elemental2.dom.HTMLParagraphElement;

/**
 * Represents an HTML
 *
 * <p>element wrapper.
 *
 * <p>The HTML
 *
 * <p>element represents a paragraph of text. It is a block-level element that typically contains
 * plain text but can also contain other HTML elements, such as links, images, and more. This class
 * provides a convenient way to create, manipulate, and control the behavior of
 *
 * <p>elements in Java-based web applications. Example usage:
 *
 * <pre>
 * HTMLParagraphElement paragraphElement = ...;  // Obtain a <p> element from somewhere
 * ParagraphElement paragraph = ParagraphElement.of(paragraphElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/p">MDN Web Docs (p)</a>
 */
public class ParagraphElement extends BaseElement<HTMLParagraphElement, ParagraphElement> {

  /**
   * Creates a new {@link ParagraphElement} instance by wrapping the provided HTML
   *
   * <p>element.
   *
   * @param e The HTML
   *     <p>element to wrap.
   * @return A new {@link ParagraphElement} instance wrapping the provided element.
   */
  public static ParagraphElement of(HTMLParagraphElement e) {
    return new ParagraphElement(e);
  }

  /**
   * Constructs a {@link ParagraphElement} instance by wrapping the provided HTML
   *
   * <p>element.
   *
   * @param element The HTML
   *     <p>element to wrap.
   */
  public ParagraphElement(HTMLParagraphElement element) {
    super(element);
  }
}
