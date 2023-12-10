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
 * Represents an HTML <kbd> element wrapper.
 *
 * <p>The HTML <kbd> element is used to define keyboard input. This class provides a convenient way
 * to create, manipulate, and control the behavior of <kbd> elements in Java-based web applications.
 * Example usage:
 *
 * <pre>{@code
 * HTMLElement kbdElement = ...;  // Obtain a <kbd> element from somewhere
 * KBDElement kbd = KBDElement.of(kbdElement);
 * }</pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/kbd">MDN Web Docs
 *     (kbd)</a>
 */
public class KBDElement extends BaseElement<HTMLElement, KBDElement> {

  /**
   * Creates a new {@link KBDElement} instance by wrapping the provided HTML <kbd> element.
   *
   * @param e The HTML <kbd> element to wrap.
   * @return A new {@link KBDElement} instance wrapping the provided element.
   */
  public static KBDElement of(HTMLElement e) {
    return new KBDElement(e);
  }

  /**
   * Constructs a {@link KBDElement} instance by wrapping the provided HTML <kbd> element.
   *
   * @param element The HTML <kbd> element to wrap.
   */
  public KBDElement(HTMLElement element) {
    super(element);
  }
}
