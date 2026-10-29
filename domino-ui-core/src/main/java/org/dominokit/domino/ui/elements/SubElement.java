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
 * Represents an HTML <sub> element wrapper.
 *
 * <p>The HTML <sub> element is used to specify text that should be displayed as subscript.
 * Subscript text appears half a character below the normal line, and is often smaller than the
 * surrounding text. Subscript text is typically used in mathematical or chemical formulas. This
 * class provides a Java-based way to create, manipulate, and control the behavior of <sub> elements
 * in web applications. Example usage:
 *
 * <pre>{@code
 * HTMLElement subElement = ...;  // Obtain a <sub> element from somewhere
 * SubElement sub = SubElement.of(subElement);
 * }</pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/sub">MDN Web Docs
 *     (sub)</a>
 */
public class SubElement extends BaseElement<HTMLElement, SubElement> {

  /**
   * Creates a new {@link SubElement} instance by wrapping the provided HTML <sub> element.
   *
   * @param e The HTML <sub> element to wrap.
   * @return A new {@link SubElement} instance wrapping the provided element.
   */
  public static SubElement of(HTMLElement e) {
    return new SubElement(e);
  }

  /**
   * Constructs a {@link SubElement} instance by wrapping the provided HTML <sub> element.
   *
   * @param element The HTML <sub> element to wrap.
   */
  public SubElement(HTMLElement element) {
    super(element);
  }
}
