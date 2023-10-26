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
 * Represents a bold text HTML element (`<b>`) wrapper.
 *
 * <p>The class provides a convenient way to create, manipulate, and control the behavior of bold
 * text HTML elements. Example usage:
 *
 * <pre>
 * HTMLElement htmlElement = ...;  // Obtain a <b> element from somewhere
 * BElement boldElement = BElement.of(htmlElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/b">MDN Web Docs (b
 *     element)</a>
 */
public class BElement extends BaseElement<HTMLElement, BElement> {

  /**
   * Creates a new {@link BElement} by wrapping the provided bold text HTML element.
   *
   * @param e The bold text HTML element.
   * @return A new {@link BElement} that wraps the provided element.
   */
  public static BElement of(HTMLElement e) {
    return new BElement(e);
  }

  /**
   * Constructs an {@link BElement} by wrapping the provided bold text HTML element.
   *
   * @param element The bold text HTML element to wrap.
   */
  public BElement(HTMLElement element) {
    super(element);
  }
}
