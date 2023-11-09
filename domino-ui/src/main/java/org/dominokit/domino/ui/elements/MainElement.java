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
 * Represents an HTML <main> element wrapper.
 *
 * <p>The HTML <main> element represents the main content of a document. This class provides a
 * convenient way to create, manipulate, and control the behavior of <main> elements in Java-based
 * web applications. Example usage:
 *
 * <pre>
 * HTMLElement mainElement = ...;  // Obtain a <main> element from somewhere
 * MainElement main = MainElement.of(mainElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/main">MDN Web Docs
 *     (main)</a>
 */
public class MainElement extends BaseElement<HTMLElement, MainElement> {

  /**
   * Creates a new {@link MainElement} instance by wrapping the provided HTML <main> element.
   *
   * @param e The HTML <main> element to wrap.
   * @return A new {@link MainElement} instance wrapping the provided element.
   */
  public static MainElement of(HTMLElement e) {
    return new MainElement(e);
  }

  /**
   * Constructs a {@link MainElement} instance by wrapping the provided HTML <main> element.
   *
   * @param element The HTML <main> element to wrap.
   */
  public MainElement(HTMLElement element) {
    super(element);
  }
}
