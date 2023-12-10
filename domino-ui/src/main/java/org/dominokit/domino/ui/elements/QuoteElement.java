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

import elemental2.dom.HTMLQuoteElement;

/**
 * Represents an HTML
 *
 * <blockquote>
 *
 * or <q> element wrapper.
 *
 * <p>The HTML
 *
 * <blockquote>
 *
 * and <q> elements are used for defining inline quotations or quotations that extend beyond one
 * line. This class provides a Java-based way to create, manipulate, and control the behavior of
 *
 * <blockquote>
 *
 * and <q> elements in web applications. Example usage:
 *
 * <pre>
 * HTMLQuoteElement quoteElement = ...;  // Obtain a <blockquote> or <q> element from somewhere
 * QuoteElement quote = QuoteElement.of(quoteElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/blockquote">MDN Web Docs
 *     (blockquote)</a>
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/q">MDN Web Docs (q)</a>
 */
public class QuoteElement extends BaseElement<HTMLQuoteElement, QuoteElement> {

  /**
   * Creates a new {@link QuoteElement} instance by wrapping the provided HTML
   *
   * <blockquote>
   *
   * or <q> element.
   *
   * @param e The HTML
   *     <blockquote>
   *     or <q> element to wrap.
   * @return A new {@link QuoteElement} instance wrapping the provided element.
   */
  public static QuoteElement of(HTMLQuoteElement e) {
    return new QuoteElement(e);
  }

  /**
   * Constructs a {@link QuoteElement} instance by wrapping the provided HTML
   *
   * <blockquote>
   *
   * or <q> element.
   *
   * @param element The HTML
   *     <blockquote>
   *     or <q> element to wrap.
   */
  public QuoteElement(HTMLQuoteElement element) {
    super(element);
  }
}
