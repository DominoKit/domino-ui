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
 * Represents an address HTML element (`<address>`) wrapper.
 *
 * <p>This class provides a convenient way to create and manipulate the address HTML element.
 * Example usage:
 *
 * <pre>
 * HTMLElement htmlElement = ...;  // Obtain an address element from somewhere
 * AddressElement addressElement = AddressElement.of(htmlElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/address">MDN Web Docs
 *     (address element)</a>
 */
public class AddressElement extends BaseElement<HTMLElement, AddressElement> {

  /**
   * Creates a new {@link AddressElement} by wrapping the provided HTML element.
   *
   * @param e The address HTML element.
   * @return A new {@link AddressElement} that wraps the provided element.
   */
  public static AddressElement of(HTMLElement e) {
    return new AddressElement(e);
  }

  /**
   * Constructs an {@link AddressElement} by wrapping the provided address HTML element.
   *
   * @param element The address HTML element to wrap.
   */
  public AddressElement(HTMLElement element) {
    super(element);
  }
}
