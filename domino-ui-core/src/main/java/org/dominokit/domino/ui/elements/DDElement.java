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
 * <dd>` HTML element wrapper.
 *
 *     <p>The `
 * <dd>` tag specifies a description or value in a description list (`
 *
 *     <dl>
 *       `) element. It is typically used in conjunction with `
 *       <dt>` (term) elements to define terms and their corresponding descriptions. This class
 *           provides a convenient way to create, manipulate, and control the behavior of `
 *       <dd>` elements, making it easier to use them in Java-based web applications. Example usage:
 *           <pre>
 * HTMLElement htmlElement = ...;  // Obtain a <dd> element from somewhere
 * DDElement ddElement = DDElement.of(htmlElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/dd">MDN Web Docs (dd
 *     element)</a>
 */
public class DDElement extends BaseElement<HTMLElement, DDElement> {

  /**
   * Creates a new {@link DDElement} instance by wrapping the provided HTML `
   * <dd>` element.
   *
   * @param e The HTML `
   *     <dd>` element.
   * @return A new {@link DDElement} instance wrapping the provided element.
   */
  public static DDElement of(HTMLElement e) {
    return new DDElement(e);
  }

  /**
   * Constructs a {@link DDElement} instance by wrapping the provided HTML `
   * <dd>` element.
   *
   * @param element The HTML `
   *     <dd>` element to wrap.
   */
  public DDElement(HTMLElement element) {
    super(element);
  }
}
