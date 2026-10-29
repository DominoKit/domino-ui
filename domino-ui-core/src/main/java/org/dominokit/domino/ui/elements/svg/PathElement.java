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

import elemental2.svg.SVGPathElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * This class provides a wrapper for the {@link SVGPathElement}, which represents an SVG path
 * element. The {@code PathElement} class allows you to work with path elements within the Domino UI
 * framework, making it easier to create and manipulate path elements in SVG graphics.
 *
 * @see BaseElement
 * @see SVGPathElement
 */
public class PathElement extends BaseElement<SVGPathElement, PathElement> {

  /**
   * Factory method for creating a new {@code PathElement} instance from an existing {@code
   * SVGPathElement}. This method provides a standardized way of wrapping {@code SVGPathElement}
   * objects within the Domino UI framework, promoting a consistent object creation pattern.
   *
   * @param e the {@code SVGPathElement} to wrap
   * @return a new instance of {@code PathElement}
   */
  public static PathElement of(SVGPathElement e) {
    return new PathElement(e);
  }

  /**
   * Constructs a new {@code PathElement} by encapsulating the provided {@code SVGPathElement}. The
   * constructor is protected to encourage the use of the static factory method {@code of()} for
   * creating new instances, ensuring uniformity across the framework.
   *
   * @param element the {@code SVGPathElement} to be wrapped
   */
  public PathElement(SVGPathElement element) {
    super(element);
  }
}
