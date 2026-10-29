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

import elemental2.dom.HTMLBRElement;

/**
 * Represents a break (`<br>
 * `) HTML element wrapper.
 *
 * <p>This class provides a convenient way to create, manipulate, and control the behavior of break
 * HTML elements. Example usage:
 *
 * <pre>
 * HTMLBRElement htmlElement = ...;  // Obtain a <br> element from somewhere
 * BRElement brElement = BRElement.of(htmlElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/br">MDN Web Docs (br
 *     element)</a>
 */
public class BRElement extends BaseElement<HTMLBRElement, BRElement> {

  /**
   * Creates a new {@link BRElement} instance by wrapping the provided break HTML element.
   *
   * @param e The break HTML element.
   * @return A new {@link BRElement} instance wrapping the provided element.
   */
  public static BRElement of(HTMLBRElement e) {
    return new BRElement(e);
  }

  /**
   * Constructs a {@link BRElement} instance by wrapping the provided break HTML element.
   *
   * @param element The break HTML element to wrap.
   */
  public BRElement(HTMLBRElement element) {
    super(element);
  }
}
