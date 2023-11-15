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

import elemental2.dom.HTMLEmbedElement;

/**
 * Represents an `<embed>` HTML element wrapper.
 *
 * <p>The `<embed>` tag defines a container for an external application or interactive content, such
 * as a plugin. This class provides a convenient way to create, manipulate, and control the behavior
 * of `<embed>` elements, making it easier to use them in Java-based web applications. Example
 * usage:
 *
 * <pre>
 * HTMLEmbedElement htmlElement = ...;  // Obtain an <embed> element from somewhere
 * EmbedElement embedElement = EmbedElement.of(htmlElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/embed">MDN Web Docs
 *     (embed element)</a>
 */
public class EmbedElement extends BaseElement<HTMLEmbedElement, EmbedElement> {

  /**
   * Creates a new {@link EmbedElement} instance by wrapping the provided HTML `<embed>` element.
   *
   * @param e The HTML `<embed>` element.
   * @return A new {@link EmbedElement} instance wrapping the provided element.
   */
  public static EmbedElement of(HTMLEmbedElement e) {
    return new EmbedElement(e);
  }

  /**
   * Constructs a {@link EmbedElement} instance by wrapping the provided HTML `<embed>` element.
   *
   * @param element The HTML `<embed>` element to wrap.
   */
  public EmbedElement(HTMLEmbedElement element) {
    super(element);
  }
}
