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
package org.dominokit.domino.ui.elements.svg;

import elemental2.svg.SVGEllipseElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * Encapsulates the {@link SVGEllipseElement}, an SVG element used to draw ellipses based on a
 * center point and two radii. By extending {@link BaseElement}, this class simplifies the process
 * of creating and manipulating ellipse elements within SVG graphics as part of the Domino UI
 * framework.
 *
 * @see BaseElement
 * @see SVGEllipseElement
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/SVG/Element/ellipse">MDN Web Docs -
 *     SVGEllipseElement</a>
 */
public class EllipseElement extends BaseElement<SVGEllipseElement, EllipseElement> {

  /**
   * Factory method to construct a new {@code EllipseElement} instance that encapsulates a given
   * {@code SVGEllipseElement}. This method provides a standardized way of creating {@code
   * EllipseElement} objects within the Domino UI framework.
   *
   * @param e the {@code SVGEllipseElement} to wrap
   * @return a new {@code EllipseElement} instance
   */
  public static EllipseElement of(SVGEllipseElement e) {
    return new EllipseElement(e);
  }

  /**
   * Constructs a new {@code EllipseElement} by wrapping the specified {@code SVGEllipseElement}.
   * This constructor is protected to promote the use of the factory method {@code of()} for
   * creating new instances, ensuring a consistent approach across the framework.
   *
   * @param element the {@code SVGEllipseElement} to be wrapped
   */
  public EllipseElement(SVGEllipseElement element) {
    super(element);
  }
}
