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

import elemental2.svg.SVGElement;

/**
 * Represents an HTML <svg> element wrapper.
 *
 * <p>The HTML <svg> element is used to create scalable vector graphics in web pages. It allows you
 * to create and manipulate vector images that can be scaled (resized) without a loss in quality.
 * This class provides a Java-based way to create, manipulate, and control the behavior of <svg>
 * elements in web applications. Example usage:
 *
 * <pre>
 * SVGElement svgElement = ...;  // Obtain an <svg> element from somewhere
 * SvgElement svg = SvgElement.of(svgElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/SVG">MDN Web Docs (SVG)</a>
 */
public class SvgElement extends BaseElement<SVGElement, SvgElement> {

  /**
   * Creates a new {@link SvgElement} instance by wrapping the provided HTML <svg> element.
   *
   * @param e The HTML <svg> element to wrap.
   * @return A new {@link SvgElement} instance wrapping the provided element.
   */
  public static SvgElement of(SVGElement e) {
    return new SvgElement(e);
  }

  /**
   * Constructs a {@link SvgElement} instance by wrapping the provided HTML <svg> element.
   *
   * @param element The HTML <svg> element to wrap.
   */
  public SvgElement(SVGElement element) {
    super(element);
  }
}
