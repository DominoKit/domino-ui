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

import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.IsElement;

/**
 * Represents an HTML InputElement element (<input>) wrapper.
 *
 * <p>The HTML <input> element is used to create interactive controls for web-based forms. This
 * class provides a convenient way to create, manipulate, and control the behavior of <input>
 * elements in Java-based web applications. Example usage:
 *
 * <pre>{@code
 * HTMLInputElement inputElement = ...;  // Obtain an <input> element from somewhere
 * InputElement input = InputElement.of(inputElement);
 * }</pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input">MDN Web Docs
 *     (input)</a>
 */
public class InputElement extends BaseElement<HTMLInputElement, InputElement> {

  /**
   * Creates a new {@link InputElement} instance by wrapping the provided HTML <input> element.
   *
   * @param e The HTML <input> element.
   * @return A new {@link InputElement} instance wrapping the provided element.
   */
  public static InputElement of(HTMLInputElement e) {
    return new InputElement(e);
  }

  /**
   * Creates a new {@link InputElement} instance by wrapping the provided {@link IsElement}
   * instance.
   *
   * @param e The {@link IsElement} instance containing the HTML <input> element.
   * @return A new {@link InputElement} instance wrapping the provided {@link IsElement}.
   */
  public static InputElement of(IsElement<HTMLInputElement> e) {
    return new InputElement(e.element());
  }

  /**
   * Constructs an {@link InputElement} instance by wrapping the provided HTML <input> element.
   *
   * @param element The HTML <input> element to wrap.
   */
  public InputElement(HTMLInputElement element) {
    super(element);
  }

  /**
   * Gets the name attribute of the input element.
   *
   * @return The name attribute value.
   */
  public String getName() {
    return element.element().name;
  }

  /**
   * Sets the name attribute of the input element.
   *
   * @param name The name attribute value to set.
   * @return This {@link InputElement} instance for method chaining.
   */
  public InputElement setName(String name) {
    element.element().name = name;
    return this;
  }

  /** @return The String value of the input element */
  public String getValue() {
    return element.element().value;
  }

  /**
   * Set the value for this input element.
   *
   * @param value String value
   * @return Same InputElement instance
   */
  public InputElement setValue(String value) {
    element.element().value = value;
    return this;
  }
}
