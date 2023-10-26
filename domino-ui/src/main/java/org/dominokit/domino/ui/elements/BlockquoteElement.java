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

import elemental2.dom.HTMLQuoteElement;

/**
 * Represents a blockquote HTML element (`
 *
 * <blockquote>
 *
 * `) wrapper.
 *
 * <p>The class offers a convenient mechanism to create, manipulate, and control the behavior of
 * blockquote HTML elements. Example usage:
 *
 * <pre>{@code
 * HTMLQuoteElement htmlElement = ...;  // Obtain a <blockquote> element from somewhere
 * BlockquoteElement blockquote = BlockquoteElement.of(htmlElement);
 * }</pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/blockquote">MDN Web Docs
 *     (blockquote element)</a>
 */
public class BlockquoteElement extends BaseElement<HTMLQuoteElement, BlockquoteElement> {

  /**
   * Creates a new {@link BlockquoteElement} by wrapping the provided blockquote HTML element.
   *
   * @param e The blockquote HTML element.
   * @return A new {@link BlockquoteElement} that wraps the provided element.
   */
  public static BlockquoteElement of(HTMLQuoteElement e) {
    return new BlockquoteElement(e);
  }

  /**
   * Constructs an {@link BlockquoteElement} by wrapping the provided blockquote HTML element.
   *
   * @param element The blockquote HTML element to wrap.
   */
  public BlockquoteElement(HTMLQuoteElement element) {
    super(element);
  }
}
