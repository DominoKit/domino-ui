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
 * Represents a <footer> HTML element wrapper.
 *
 * <p>The <footer> tag is used to define a footer for a document or section. A footer typically
 * contains information about the author, copyright, contact details, and other metadata about the
 * content. This class provides a convenient way to create, manipulate, and control the behavior of
 * <footer> elements, making it easier to use them in Java-based web applications. Example usage:
 *
 * <pre>
 * HTMLElement footerElement = ...;  // Obtain a <footer> element from somewhere
 * FooterElement footer = FooterElement.of(footerElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/footer">MDN Web Docs
 *     (footer element)</a>
 */
public class FooterElement extends BaseElement<HTMLElement, FooterElement> {

  /**
   * Creates a new {@link FooterElement} instance by wrapping the provided HTML <footer> element.
   *
   * @param e The HTML <footer> element.
   * @return A new {@link FooterElement} instance wrapping the provided element.
   */
  public static FooterElement of(HTMLElement e) {
    return new FooterElement(e);
  }

  /**
   * Constructs a {@link FooterElement} instance by wrapping the provided HTML <footer> element.
   *
   * @param element The HTML <footer> element to wrap.
   */
  public FooterElement(HTMLElement element) {
    super(element);
  }
}
