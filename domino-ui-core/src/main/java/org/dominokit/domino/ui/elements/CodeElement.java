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
 * Represents a `<code>` HTML element wrapper.
 * <p>
 * The `<code>` tag is used to define a piece of computer code. Text surrounded by `<code>` tags is typically displayed in the browser's default monospace font. This class offers a convenient way to create, manipulate, and control the behavior of `<code>` elements, facilitating their use in Java-based web applications.
 * </p>
 *
 * Example usage:
 * <pre>
 * {@code
 * HTMLElement htmlElement = ...;  // Obtain a <code> element from somewhere
 * CodeElement codeElement = CodeElement.of(htmlElement);
 * }
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/code">MDN Web Docs (code element)</a>
 */
public class CodeElement extends BaseElement<HTMLElement, CodeElement> {

  /**
   * Creates a new {@link CodeElement} instance by wrapping the provided HTML `<code>` element.
   *
   * @param e The HTML `<code>` element.
   * @return A new {@link CodeElement} instance wrapping the provided element.
   */
  public static CodeElement of(HTMLElement e) {
    return new CodeElement(e);
  }

  /**
   * Constructs a {@link CodeElement} instance by wrapping the provided HTML `<code>` element.
   *
   * @param element The HTML `<code>` element to wrap.
   */
  public CodeElement(HTMLElement element) {
    super(element);
  }
}
