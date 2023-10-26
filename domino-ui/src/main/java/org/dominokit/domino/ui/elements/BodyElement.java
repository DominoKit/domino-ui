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

import elemental2.dom.HTMLBodyElement;

/**
 * Represents a body HTML element (`<body>`) wrapper.
 *
 * <p>This class offers a convenient mechanism to create, manipulate, and control the behavior of
 * body HTML elements. Example usage:
 *
 * <pre>
 * HTMLBodyElement htmlElement = ...;  // Obtain a <body> element from somewhere
 * BodyElement body = BodyElement.of(htmlElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/body">MDN Web Docs (body
 *     element)</a>
 */
public class BodyElement extends BaseElement<HTMLBodyElement, BodyElement> {

  /**
   * Creates a new {@link BodyElement} by wrapping the provided body HTML element.
   *
   * @param e The body HTML element.
   * @return A new {@link BodyElement} that wraps the provided element.
   */
  public static BodyElement of(HTMLBodyElement e) {
    return new BodyElement(e);
  }

  /**
   * Constructs a {@link BodyElement} by wrapping the provided body HTML element. Also sets the CSS
   * property `--dui-z-index` to "10" for the body element.
   *
   * @param element The body HTML element to wrap.
   */
  public BodyElement(HTMLBodyElement element) {
    super(element);
    setCssProperty("--dui-z-index", "10");
  }
}
