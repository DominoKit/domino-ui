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
 * Represents a <figure> HTML element wrapper.
 *
 * <p>The <figure> tag is used to group and represent content that is referenced from the main
 * content, often with a caption or legend. This class provides a convenient way to create,
 * manipulate, and control the behavior of <figure> elements, making it easier to use them in
 * Java-based web applications. Example usage:
 *
 * <pre>{@code
 * HTMLElement figureElement = ...;  // Obtain a <figure> element from somewhere
 * FigureElement figure = FigureElement.of(figureElement);
 * }</pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/figure">MDN Web Docs
 *     (figure element)</a>
 */
public class FigureElement extends BaseElement<HTMLElement, FigureElement> {

  /**
   * Creates a new {@link FigureElement} instance by wrapping the provided HTML <figure> element.
   *
   * @param e The HTML <figure> element.
   * @return A new {@link FigureElement} instance wrapping the provided element.
   */
  public static FigureElement of(HTMLElement e) {
    return new FigureElement(e);
  }

  /**
   * Constructs a {@link FigureElement} instance by wrapping the provided HTML <figure> element.
   *
   * @param element The HTML <figure> element to wrap.
   */
  public FigureElement(HTMLElement element) {
    super(element);
  }
}
