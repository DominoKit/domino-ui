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
 * Represents an <em> HTML element wrapper.
 *
 * <p>The <em> tag defines emphasized text. This class provides a convenient way to create,
 * manipulate, and control the behavior of <em> elements, making it easier to use them in Java-based
 * web applications. Example usage:
 *
 * <pre>
 * HTMLElement htmlElement = ...;  // Obtain an <em> element from somewhere
 * EMElement emElement = EMElement.of(htmlElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/em">MDN Web Docs (em
 *     element)</a>
 */
public class EMElement extends BaseElement<HTMLElement, EMElement> {

  /**
   * Creates a new {@link EMElement} instance by wrapping the provided HTML <em> element.
   *
   * @param e The HTML <em> element.
   * @return A new {@link EMElement} instance wrapping the provided element.
   */
  public static EMElement of(HTMLElement e) {
    return new EMElement(e);
  }

  /**
   * Constructs a {@link EMElement} instance by wrapping the provided HTML <em> element.
   *
   * @param element The HTML <em> element to wrap.
   */
  public EMElement(HTMLElement element) {
    super(element);
  }
}
