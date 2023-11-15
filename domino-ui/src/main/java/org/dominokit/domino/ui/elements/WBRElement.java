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
 * Represents an HTML <wbr> (Word Break Opportunity) element wrapper.
 *
 * <p>The HTML <wbr> element represents a word break opportunity—a position within text where the
 * browser may optionally break a line, though its line-breaking rules would not otherwise create a
 * break at that location. Example usage:
 *
 * <pre>{@code
 * HTMLElement wbrElement = ...;  // Obtain a <wbr> element from somewhere
 * WBRElement wbr = WBRElement.of(wbrElement);
 * }</pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/wbr">MDN Web Docs
 *     (wbr)</a>
 */
public class WBRElement extends BaseElement<HTMLElement, WBRElement> {

  /**
   * Creates a new {@link WBRElement} instance by wrapping the provided HTML <wbr> element.
   *
   * @param e The HTML <wbr> element to wrap.
   * @return A new {@link WBRElement} instance wrapping the provided element.
   */
  public static WBRElement of(HTMLElement e) {
    return new WBRElement(e);
  }

  /**
   * Constructs a {@link WBRElement} instance by wrapping the provided HTML <wbr> element.
   *
   * @param element The HTML <wbr> element to wrap.
   */
  public WBRElement(HTMLElement element) {
    super(element);
  }
}
