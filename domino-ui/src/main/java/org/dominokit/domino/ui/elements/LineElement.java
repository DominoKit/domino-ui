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

import elemental2.svg.SVGLineElement;

/**
 * Represents an SVG <line> element wrapper.
 *
 * <p>The SVG <line> element is used to create a line in an SVG graphic. This class provides a
 * convenient way to create, manipulate, and control the behavior of <line> elements in Java-based
 * web applications. Example usage:
 *
 * <pre>
 * SVGLineElement lineElement = ...;  // Obtain a <line> element from somewhere
 * LineElement line = LineElement.of(lineElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/SVG/Element/line">MDN Web Docs
 *     (line)</a>
 */
public class LineElement extends BaseElement<SVGLineElement, LineElement> {

  /**
   * Creates a new {@link LineElement} instance by wrapping the provided SVG <line> element.
   *
   * @param e The SVG <line> element to wrap.
   * @return A new {@link LineElement} instance wrapping the provided element.
   */
  public static LineElement of(SVGLineElement e) {
    return new LineElement(e);
  }

  /**
   * Constructs a {@link LineElement} instance by wrapping the provided SVG <line> element.
   *
   * @param element The SVG <line> element to wrap.
   */
  public LineElement(SVGLineElement element) {
    super(element);
  }
}
