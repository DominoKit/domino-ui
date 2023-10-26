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
 * Represents a <header> HTML element wrapper.
 *
 * <p>The <header> tag is used to define a container for introductory content or a set of
 * navigational links in a document. It often contains the site logo, site title, site navigation,
 * or other key information about the webpage. This class provides a convenient way to create,
 * manipulate, and control the behavior of <header> elements, making it easier to use them in
 * Java-based web applications. Example usage:
 *
 * <pre>
 * HTMLElement headerElement = ...;  // Obtain a <header> element from somewhere
 * HeaderElement header = HeaderElement.of(headerElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/header">MDN Web Docs
 *     (header element)</a>
 */
public class HeaderElement extends BaseElement<HTMLElement, HeaderElement> {

  /**
   * Creates a new {@link HeaderElement} instance by wrapping the provided HTML <header> element.
   *
   * @param e The HTML <header> element.
   * @return A new {@link HeaderElement} instance wrapping the provided element.
   */
  public static HeaderElement of(HTMLElement e) {
    return new HeaderElement(e);
  }

  /**
   * Constructs a {@link HeaderElement} instance by wrapping the provided HTML <header> element.
   *
   * @param element The HTML <header> element to wrap.
   */
  public HeaderElement(HTMLElement element) {
    super(element);
  }
}
