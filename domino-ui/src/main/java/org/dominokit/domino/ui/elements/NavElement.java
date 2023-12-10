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
 * Represents an HTML <nav> element wrapper.
 *
 * <p>The HTML <nav> element represents a section of a page that contains navigation links or menus.
 * This class provides a convenient way to create, manipulate, and control the behavior of <nav>
 * elements in Java-based web applications. Example usage:
 *
 * <pre>
 * HTMLElement navElement = ...;  // Obtain a <nav> element from somewhere
 * NavElement nav = NavElement.of(navElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/nav">MDN Web Docs
 *     (nav)</a>
 */
public class NavElement extends BaseElement<HTMLElement, NavElement> {

  /**
   * Creates a new {@link NavElement} instance by wrapping the provided HTML <nav> element.
   *
   * @param e The HTML <nav> element to wrap.
   * @return A new {@link NavElement} instance wrapping the provided element.
   */
  public static NavElement of(HTMLElement e) {
    return new NavElement(e);
  }

  /**
   * Constructs a {@link NavElement} instance by wrapping the provided HTML <nav> element.
   *
   * @param element The HTML <nav> element to wrap.
   */
  public NavElement(HTMLElement element) {
    super(element);
  }
}
