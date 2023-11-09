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

import elemental2.dom.HTMLElement;

/**
 * Represents an HTML <sup> element wrapper.
 *
 * <p>The HTML <sup> element is used to specify text that should be displayed as superscript.
 * Superscript text appears half a character above the normal line, and is often smaller than the
 * surrounding text. Superscript text is typically used for footnotes or exponent numbers. This
 * class provides a Java-based way to create, manipulate, and control the behavior of <sup> elements
 * in web applications. Example usage:
 *
 * <pre>
 * HTMLElement supElement = ...;  // Obtain a <sup> element from somewhere
 * SupElement sup = SupElement.of(supElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/sup">MDN Web Docs
 *     (sup)</a>
 */
public class SupElement extends BaseElement<HTMLElement, SupElement> {

  /**
   * Creates a new {@link SupElement} instance by wrapping the provided HTML <sup> element.
   *
   * @param e The HTML <sup> element to wrap.
   * @return A new {@link SupElement} instance wrapping the provided element.
   */
  public static SupElement of(HTMLElement e) {
    return new SupElement(e);
  }

  /**
   * Constructs a {@link SupElement} instance by wrapping the provided HTML <sup> element.
   *
   * @param element The HTML <sup> element to wrap.
   */
  public SupElement(HTMLElement element) {
    super(element);
  }
}
