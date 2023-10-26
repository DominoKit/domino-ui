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

import elemental2.svg.SVGCircleElement;

/**
 * Represents an SVG circle (`<circle>`) element wrapper.
 *
 * <p>This class provides a convenient way to create, manipulate, and control the behavior of SVG
 * circle elements. Example usage:
 *
 * <pre>{@code
 * SVGCircleElement svgElement = ...;  // Obtain a <circle> element from somewhere
 * CircleElement circleElement = CircleElement.of(svgElement);
 * }</pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/SVG/Element/circle">MDN Web Docs
 *     (circle element)</a>
 */
public class CircleElement extends BaseElement<SVGCircleElement, CircleElement> {

  /**
   * Creates a new {@link CircleElement} instance by wrapping the provided SVG circle element.
   *
   * @param e The SVG circle element.
   * @return A new {@link CircleElement} instance wrapping the provided element.
   */
  public static CircleElement of(SVGCircleElement e) {
    return new CircleElement(e);
  }

  /**
   * Constructs a {@link CircleElement} instance by wrapping the provided SVG circle element.
   *
   * @param element The SVG circle element to wrap.
   */
  public CircleElement(SVGCircleElement element) {
    super(element);
  }
}
