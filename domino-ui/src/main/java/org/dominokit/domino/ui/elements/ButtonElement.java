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

import elemental2.dom.HTMLButtonElement;

/**
 * Represents a button (`<button>`) HTML element wrapper.
 *
 * <p>This class provides a convenient way to create, manipulate, and control the behavior of button
 * HTML elements. Example usage:
 *
 * <pre>
 * HTMLButtonElement htmlElement = ...;  // Obtain a <button> element from somewhere
 * ButtonElement buttonElement = ButtonElement.of(htmlElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/button">MDN Web Docs
 *     (button element)</a>
 */
public class ButtonElement extends BaseElement<HTMLButtonElement, ButtonElement> {

  /**
   * Creates a new {@link ButtonElement} instance by wrapping the provided button HTML element.
   *
   * @param e The button HTML element.
   * @return A new {@link ButtonElement} instance wrapping the provided element.
   */
  public static ButtonElement of(HTMLButtonElement e) {
    return new ButtonElement(e);
  }

  /**
   * Constructs a {@link ButtonElement} instance by wrapping the provided button HTML element.
   *
   * @param element The button HTML element to wrap.
   */
  public ButtonElement(HTMLButtonElement element) {
    super(element);
  }
}
