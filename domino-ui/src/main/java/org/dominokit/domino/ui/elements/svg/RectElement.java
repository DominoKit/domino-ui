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

import elemental2.svg.SVGRectElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * This class provides a wrapper for the {@link SVGRectElement}, which represents an SVG rectangle
 * element. The {@code RectElement} class allows you to work with rectangle elements within the
 * Domino UI framework, making it easier to create and manipulate rectangle elements in SVG
 * graphics.
 *
 * @see BaseElement
 * @see SVGRectElement
 */
public class RectElement extends BaseElement<SVGRectElement, RectElement> {

  /**
   * Factory method for creating a new {@code RectElement} instance from an existing {@code
   * SVGRectElement}. This method provides a standardized way of wrapping {@code SVGRectElement}
   * objects within the Domino UI framework, promoting a consistent object creation pattern.
   *
   * @param e the {@code SVGRectElement} to wrap
   * @return a new instance of {@code RectElement}
   */
  public static RectElement of(SVGRectElement e) {
    return new RectElement(e);
  }

  /**
   * Constructs a new {@code RectElement} by encapsulating the provided {@code SVGRectElement}. The
   * constructor is protected to encourage the use of the static factory method {@code of()} for
   * creating new instances, ensuring uniformity across the framework.
   *
   * @param element the {@code SVGRectElement} to be wrapped
   */
  public RectElement(SVGRectElement element) {
    super(element);
  }
}
