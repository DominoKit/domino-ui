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
 * Represents a `
 * <dt>` (description term) HTML element wrapper.
 *
 *     <p>The `
 * <dt>` tag is used within a `
 *
 *     <dl>
 *       ` (description list) element to define a term or name in a description list. This class
 *       provides a convenient way to create, manipulate, and control the behavior of `
 *       <dt>` elements, making it easier to use them in Java-based web applications. Example usage:
 *           <pre>
 * HTMLElement htmlElement = ...;  // Obtain a <dt> element from somewhere
 * DTElement dtElement = DTElement.of(htmlElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/dt">MDN Web Docs (dt
 *     element)</a>
 */
public class DTElement extends BaseElement<HTMLElement, DTElement> {

  /**
   * Creates a new {@link DTElement} instance by wrapping the provided HTML `
   * <dt>` element.
   *
   * @param e The HTML `
   *     <dt>` element.
   * @return A new {@link DTElement} instance wrapping the provided element.
   */
  public static DTElement of(HTMLElement e) {
    return new DTElement(e);
  }

  /**
   * Constructs a {@link DTElement} instance by wrapping the provided HTML `
   * <dt>` element.
   *
   * @param element The HTML `
   *     <dt>` element to wrap.
   */
  public DTElement(HTMLElement element) {
    super(element);
  }
}
