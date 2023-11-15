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

import elemental2.dom.HTMLHRElement;

/**
 * Represents an HTML HRElement element (<hr>) wrapper.
 *
 * <p>The HTML <hr> element represents a thematic break between paragraph-level elements. It is
 * often used to separate content. This class provides a convenient way to create, manipulate, and
 * control the behavior of <hr> elements in Java-based web applications. Example usage:
 *
 * <pre>
 * HTMLHRElement hrElement = ...;  // Obtain an <hr> element from somewhere
 * HRElement hr = HRElement.of(hrElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/hr">MDN Web Docs (hr)</a>
 */
public class HRElement extends BaseElement<HTMLHRElement, HRElement> {

  /**
   * Creates a new {@link HRElement} instance by wrapping the provided HTML <hr> element.
   *
   * @param e The HTML <hr> element.
   * @return A new {@link HRElement} instance wrapping the provided element.
   */
  public static HRElement of(HTMLHRElement e) {
    return new HRElement(e);
  }

  /**
   * Constructs a {@link HRElement} instance by wrapping the provided HTML <hr> element.
   *
   * @param element The HTML <hr> element to wrap.
   */
  public HRElement(HTMLHRElement element) {
    super(element);
  }
}
