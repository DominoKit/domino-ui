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

import elemental2.dom.HTMLDivElement;

/**
 * Represents a `<div>` HTML element wrapper.
 *
 * <p>The `<div>` tag is a generic container used to group other HTML elements together and apply
 * styles or scripting to them. This class provides a convenient way to create, manipulate, and
 * control the behavior of `<div>` elements, making it easier to use them in Java-based web
 * applications. Example usage:
 *
 * <pre>
 * HTMLDivElement htmlElement = ...;  // Obtain a <div> element from somewhere
 * DivElement divElement = DivElement.of(htmlElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/div">MDN Web Docs (div
 *     element)</a>
 */
public class DivElement extends BaseElement<HTMLDivElement, DivElement> {

  /**
   * Creates a new {@link DivElement} instance by wrapping the provided HTML `<div>` element.
   *
   * @param e The HTML `<div>` element.
   * @return A new {@link DivElement} instance wrapping the provided element.
   */
  public static DivElement of(HTMLDivElement e) {
    return new DivElement(e);
  }

  /**
   * Constructs a {@link DivElement} instance by wrapping the provided HTML `<div>` element.
   *
   * @param element The HTML `<div>` element to wrap.
   */
  public DivElement(HTMLDivElement element) {
    super(element);
  }
}
