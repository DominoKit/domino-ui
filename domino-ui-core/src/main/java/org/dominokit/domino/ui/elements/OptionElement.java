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

import elemental2.dom.HTMLOptionElement;

/**
 * Represents an HTML <option> element wrapper.
 *
 * <p>The HTML <option> element represents an individual choice in a <select> element. This class
 * provides a convenient way to create, manipulate, and control the behavior of <option> elements in
 * Java-based web applications. Example usage:
 *
 * <pre>
 * HTMLOptionElement optionElement = ...;  // Obtain an <option> element from somewhere
 * OptionElement option = OptionElement.of(optionElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/option">MDN Web Docs
 *     (option)</a>
 */
public class OptionElement extends BaseElement<HTMLOptionElement, OptionElement> {

  /**
   * Creates a new {@link OptionElement} instance by wrapping the provided HTML <option> element.
   *
   * @param e The HTML <option> element to wrap.
   * @return A new {@link OptionElement} instance wrapping the provided element.
   */
  public static OptionElement of(HTMLOptionElement e) {
    return new OptionElement(e);
  }

  /**
   * Constructs a {@link OptionElement} instance by wrapping the provided HTML <option> element.
   *
   * @param element The HTML <option> element to wrap.
   */
  public OptionElement(HTMLOptionElement element) {
    super(element);
  }
}
