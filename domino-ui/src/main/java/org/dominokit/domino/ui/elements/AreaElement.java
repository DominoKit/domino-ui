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

import elemental2.dom.HTMLAreaElement;

/**
 * Represents an area HTML element (`<area>`) wrapper.
 *
 * <p>This class provides a convenient way to create, manipulate, and control the behavior of area
 * HTML elements. Example usage:
 *
 * <pre>{@code
 * HTMLAreaElement htmlElement = ...;  // Obtain an area element from somewhere
 * AreaElement areaElement = AreaElement.of(htmlElement);
 * }</pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/area">MDN Web Docs (area
 *     element)</a>
 */
public class AreaElement extends BaseElement<HTMLAreaElement, AreaElement> {

  /**
   * Creates a new {@link AreaElement} by wrapping the provided area HTML element.
   *
   * @param e The area HTML element.
   * @return A new {@link AreaElement} that wraps the provided element.
   */
  public static AreaElement of(HTMLAreaElement e) {
    return new AreaElement(e);
  }

  /**
   * Constructs an {@link AreaElement} by wrapping the provided area HTML element.
   *
   * @param element The area HTML element to wrap.
   */
  public AreaElement(HTMLAreaElement element) {
    super(element);
  }
}
