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

import elemental2.dom.HTMLOptGroupElement;

/**
 * Represents an HTML <optgroup> (option group) element wrapper.
 *
 * <p>The HTML <optgroup> element is used to group together related options within a <select>
 * element. This class provides a convenient way to create, manipulate, and control the behavior of
 * <optgroup> elements in Java-based web applications. Example usage:
 *
 * <pre>
 * HTMLOptGroupElement optGroupElement = ...;  // Obtain an <optgroup> element from somewhere
 * OptGroupElement optGroup = OptGroupElement.of(optGroupElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/optgroup">MDN Web Docs
 *     (optgroup)</a>
 */
public class OptGroupElement extends BaseElement<HTMLOptGroupElement, OptGroupElement> {

  /**
   * Creates a new {@link OptGroupElement} instance by wrapping the provided HTML <optgroup>
   * element.
   *
   * @param e The HTML <optgroup> element to wrap.
   * @return A new {@link OptGroupElement} instance wrapping the provided element.
   */
  public static OptGroupElement of(HTMLOptGroupElement e) {
    return new OptGroupElement(e);
  }

  /**
   * Constructs a {@link OptGroupElement} instance by wrapping the provided HTML <optgroup> element.
   *
   * @param element The HTML <optgroup> element to wrap.
   */
  public OptGroupElement(HTMLOptGroupElement element) {
    super(element);
  }
}
