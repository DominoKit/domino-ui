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
 * Represents an HTML <small> element wrapper.
 *
 * <p>The HTML <small> element is used to represent text that should be rendered in a smaller font
 * size than the surrounding text. It is typically used to indicate disclaimers, legal notices, or
 * other content that should be presented in a smaller font size to differentiate it from the main
 * content. This class provides a Java-based way to create, manipulate, and control the behavior of
 * <small> elements in web applications. Example usage:
 *
 * <pre>
 * HTMLElement smallElement = ...;  // Obtain a <small> element from somewhere
 * SmallElement small = SmallElement.of(smallElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/small">MDN Web Docs
 *     (small)</a>
 */
public class SmallElement extends BaseElement<HTMLElement, SmallElement> {

  /**
   * Creates a new {@link SmallElement} instance by wrapping the provided HTML <small> element.
   *
   * @param e The HTML <small> element to wrap.
   * @return A new {@link SmallElement} instance wrapping the provided element.
   */
  public static SmallElement of(HTMLElement e) {
    return new SmallElement(e);
  }

  /**
   * Constructs a {@link SmallElement} instance by wrapping the provided HTML <small> element.
   *
   * @param element The HTML <small> element to wrap.
   */
  public SmallElement(HTMLElement element) {
    super(element);
  }
}
