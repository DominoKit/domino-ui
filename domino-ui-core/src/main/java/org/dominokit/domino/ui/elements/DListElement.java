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

import elemental2.dom.HTMLDListElement;

/**
 * Represents a `
 *
 * <dl>
 *   ` (description list) HTML element wrapper.
 *   <p>The `
 *   <dl>
 *     ` tag is used to create a description list that consists of term-description pairs. This
 *     class provides a convenient way to create, manipulate, and control the behavior of `
 *     <dl>
 *       ` elements, making it easier to use them in Java-based web applications. Example usage:
 *       <pre>
 * HTMLDListElement htmlElement = ...;  // Obtain a <dl> element from somewhere
 * DListElement dlElement = DListElement.of(htmlElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/dl">MDN Web Docs (dl
 *     element)</a>
 */
public class DListElement extends BaseElement<HTMLDListElement, DListElement> {

  /**
   * Creates a new {@link DListElement} instance by wrapping the provided HTML `
   *
   * <dl>
   *   ` element.
   *
   * @param e The HTML `
   *     <dl>
   *       ` element.
   * @return A new {@link DListElement} instance wrapping the provided element.
   */
  public static DListElement of(HTMLDListElement e) {
    return new DListElement(e);
  }

  /**
   * Constructs a {@link DListElement} instance by wrapping the provided HTML `
   *
   * <dl>
   *   ` element.
   *
   * @param element The HTML `
   *     <dl>
   *       ` element to wrap.
   */
  public DListElement(HTMLDListElement element) {
    super(element);
  }
}
