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
 * Represents a <figcaption> HTML element wrapper.
 *
 * <p>The <figcaption> tag is used to provide a caption or legend for a <figure> element in HTML.
 * This class provides a convenient way to create, manipulate, and control the behavior of
 * <figcaption> elements, making it easier to use them in Java-based web applications. Example
 * usage:
 *
 * <pre>
 * HTMLElement figCaptionElement = ...;  // Obtain a <figcaption> element from somewhere
 * FigCaptionElement figCaption = FigCaptionElement.of(figCaptionElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/figcaption">MDN Web Docs
 *     (figcaption element)</a>
 */
public class FigCaptionElement extends BaseElement<HTMLElement, FigCaptionElement> {

  /**
   * Creates a new {@link FigCaptionElement} instance by wrapping the provided HTML <figcaption>
   * element.
   *
   * @param e The HTML <figcaption> element.
   * @return A new {@link FigCaptionElement} instance wrapping the provided element.
   */
  public static FigCaptionElement of(HTMLElement e) {
    return new FigCaptionElement(e);
  }

  /**
   * Constructs a {@link FigCaptionElement} instance by wrapping the provided HTML <figcaption>
   * element.
   *
   * @param element The HTML <figcaption> element to wrap.
   */
  public FigCaptionElement(HTMLElement element) {
    super(element);
  }
}
