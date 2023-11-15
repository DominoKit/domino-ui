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
 * Represents an HTML <strong> element wrapper.
 *
 * <p>The HTML <strong> element is used to give text strong importance, and is typically displayed
 * in a bold font. This class provides a Java-based way to create, manipulate, and control the
 * behavior of <strong> elements in web applications. Example usage:
 *
 * <pre>{@code
 * HTMLElement strongElement = ...;  // Obtain a <strong> element from somewhere
 * StrongElement strong = StrongElement.of(strongElement);
 * }</pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/strong">MDN Web Docs
 *     (strong)</a>
 */
public class StrongElement extends BaseElement<HTMLElement, StrongElement> {

  /**
   * Creates a new {@link StrongElement} instance by wrapping the provided HTML <strong> element.
   *
   * @param e The HTML <strong> element to wrap.
   * @return A new {@link StrongElement} instance wrapping the provided element.
   */
  public static StrongElement of(HTMLElement e) {
    return new StrongElement(e);
  }

  /**
   * Constructs a {@link StrongElement} instance by wrapping the provided HTML <strong> element.
   *
   * @param element The HTML <strong> element to wrap.
   */
  public StrongElement(HTMLElement element) {
    super(element);
  }
}
