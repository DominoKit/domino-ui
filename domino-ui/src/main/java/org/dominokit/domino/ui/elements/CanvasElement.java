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

import elemental2.dom.HTMLCanvasElement;

/**
 * Represents a canvas (`<canvas>`) HTML element wrapper.
 *
 * <p>This class provides a convenient way to create, manipulate, and control the behavior of canvas
 * HTML elements. Example usage:
 *
 * <pre>
 * HTMLCanvasElement htmlElement = ...;  // Obtain a <canvas> element from somewhere
 * CanvasElement canvasElement = CanvasElement.of(htmlElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/canvas">MDN Web Docs
 *     (canvas element)</a>
 */
public class CanvasElement extends BaseElement<HTMLCanvasElement, CanvasElement> {

  /**
   * Creates a new {@link CanvasElement} instance by wrapping the provided canvas HTML element.
   *
   * @param e The canvas HTML element.
   * @return A new {@link CanvasElement} instance wrapping the provided element.
   */
  public static CanvasElement of(HTMLCanvasElement e) {
    return new CanvasElement(e);
  }

  /**
   * Constructs a {@link CanvasElement} instance by wrapping the provided canvas HTML element.
   *
   * @param element The canvas HTML element to wrap.
   */
  public CanvasElement(HTMLCanvasElement element) {
    super(element);
  }
}
