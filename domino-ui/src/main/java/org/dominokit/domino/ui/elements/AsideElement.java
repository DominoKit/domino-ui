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
 * Represents an aside HTML element (`<aside>`) wrapper.
 *
 * <p>The class provides a convenient way to create, manipulate, and control the behavior of aside
 * HTML elements. Example usage:
 *
 * <pre>
 * HTMLElement htmlElement = ...;  // Obtain an aside element from somewhere
 * AsideElement asideElement = AsideElement.of(htmlElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/aside">MDN Web Docs
 *     (aside element)</a>
 */
public class AsideElement extends BaseElement<HTMLElement, AsideElement> {

  /**
   * Creates a new {@link AsideElement} by wrapping the provided aside HTML element.
   *
   * @param e The aside HTML element.
   * @return A new {@link AsideElement} that wraps the provided element.
   */
  public static AsideElement of(HTMLElement e) {
    return new AsideElement(e);
  }

  /**
   * Constructs an {@link AsideElement} by wrapping the provided aside HTML element.
   *
   * @param element The aside HTML element to wrap.
   */
  public AsideElement(HTMLElement element) {
    super(element);
  }
}
