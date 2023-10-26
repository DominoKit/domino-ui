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
 * Represents an abbreviation HTML element (`<abbr>`) wrapper.
 *
 * <p>This class facilitates the creation and manipulation of the abbreviation HTML element. Example
 * usage:
 *
 * <pre>{@code
 * HTMLElement htmlElement = ...;  // Obtain an abbreviation element from somewhere
 * ABBRElement abbrElement = ABBRElement.of(htmlElement);
 * }</pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/abbr">MDN Web Docs (abbr
 *     element)</a>
 */
public class ABBRElement extends BaseElement<HTMLElement, ABBRElement> {

  /**
   * Creates a new {@link ABBRElement} from the given HTML element.
   *
   * @param e The abbreviation HTML element.
   * @return A new {@link ABBRElement} wrapping the provided element.
   */
  public static ABBRElement of(HTMLElement e) {
    return new ABBRElement(e);
  }

  /**
   * Constructs an {@link ABBRElement} by wrapping the provided abbreviation HTML element.
   *
   * @param element The abbreviation HTML element to wrap.
   */
  public ABBRElement(HTMLElement element) {
    super(element);
  }
}
