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
 * Represents a `<dfn>` HTML element wrapper.
 *
 * <p>The `<dfn>` tag represents the defining instance of a term. This class provides a convenient
 * way to create, manipulate, and control the behavior of `<dfn>` elements, making it easier to use
 * them in Java-based web applications. Example usage:
 *
 * <pre>
 * HTMLElement htmlElement = ...;  // Obtain a <dfn> element from somewhere
 * DFNElement dfnElement = DFNElement.of(htmlElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/dfn">MDN Web Docs (dfn
 *     element)</a>
 */
public class DFNElement extends BaseElement<HTMLElement, DFNElement> {

  /**
   * Creates a new {@link DFNElement} instance by wrapping the provided HTML `<dfn>` element.
   *
   * @param e The HTML `<dfn>` element.
   * @return A new {@link DFNElement} instance wrapping the provided element.
   */
  public static DFNElement of(HTMLElement e) {
    return new DFNElement(e);
  }

  /**
   * Constructs a {@link DFNElement} instance by wrapping the provided HTML `<dfn>` element.
   *
   * @param element The HTML `<dfn>` element to wrap.
   */
  public DFNElement(HTMLElement element) {
    super(element);
  }
}
