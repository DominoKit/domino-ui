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

import elemental2.dom.HTMLModElement;

/**
 * Represents a `<del>` HTML element wrapper.
 *
 * <p>The `<del>` tag defines text that has been deleted from a document. This class provides a
 * convenient way to create, manipulate, and control the behavior of `<del>` elements, making it
 * easier to use them in Java-based web applications. Example usage:
 *
 * <pre>{@code
 * HTMLModElement htmlElement = ...;  // Obtain a <del> element from somewhere
 * DelElement delElement = DelElement.of(htmlElement);
 * }</pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/del">MDN Web Docs (del
 *     element)</a>
 */
public class DelElement extends BaseElement<HTMLModElement, DelElement> {

  /**
   * Creates a new {@link DelElement} instance by wrapping the provided HTML `<del>` element.
   *
   * @param e The HTML `<del>` element.
   * @return A new {@link DelElement} instance wrapping the provided element.
   */
  public static DelElement of(HTMLModElement e) {
    return new DelElement(e);
  }

  /**
   * Constructs a {@link DelElement} instance by wrapping the provided HTML `<del>` element.
   *
   * @param element The HTML `<del>` element to wrap.
   */
  public DelElement(HTMLModElement element) {
    super(element);
  }
}
