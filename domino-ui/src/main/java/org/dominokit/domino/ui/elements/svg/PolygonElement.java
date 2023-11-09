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

import elemental2.svg.SVGPolygonElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * This class provides a wrapper for the {@link SVGPolygonElement}, which represents an SVG polygon
 * element. The {@code PolygonElement} class allows you to work with polygon elements within the
 * Domino UI framework, making it easier to create and manipulate polygon elements in SVG graphics.
 *
 * @see BaseElement
 * @see SVGPolygonElement
 */
public class PolygonElement extends BaseElement<SVGPolygonElement, PolygonElement> {

  /**
   * Factory method for creating a new {@code PolygonElement} instance from an existing {@code
   * SVGPolygonElement}. This method provides a standardized way of wrapping {@code
   * SVGPolygonElement} objects within the Domino UI framework, promoting a consistent object
   * creation pattern.
   *
   * @param e the {@code SVGPolygonElement} to wrap
   * @return a new instance of {@code PolygonElement}
   */
  public static PolygonElement of(SVGPolygonElement e) {
    return new PolygonElement(e);
  }

  /**
   * Constructs a new {@code PolygonElement} by encapsulating the provided {@code
   * SVGPolygonElement}. The constructor is protected to encourage the use of the static factory
   * method {@code of()} for creating new instances, ensuring uniformity across the framework.
   *
   * @param element the {@code SVGPolygonElement} to be wrapped
   */
  public PolygonElement(SVGPolygonElement element) {
    super(element);
  }
}
