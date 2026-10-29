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

import elemental2.svg.SVGPolylineElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * This class provides a wrapper for the {@link SVGPolylineElement}, which represents an SVG
 * polyline element. The {@code PolyLineElement} class allows you to work with polyline elements
 * within the Domino UI framework, making it easier to create and manipulate polyline elements in
 * SVG graphics.
 *
 * @see BaseElement
 * @see SVGPolylineElement
 */
public class PolyLineElement extends BaseElement<SVGPolylineElement, PolyLineElement> {

  /**
   * Factory method for creating a new {@code PolyLineElement} instance from an existing {@code
   * SVGPolylineElement}. This method provides a standardized way of wrapping {@code
   * SVGPolylineElement} objects within the Domino UI framework, promoting a consistent object
   * creation pattern.
   *
   * @param e the {@code SVGPolylineElement} to wrap
   * @return a new instance of {@code PolyLineElement}
   */
  public static PolyLineElement of(SVGPolylineElement e) {
    return new PolyLineElement(e);
  }

  /**
   * Constructs a new {@code PolyLineElement} by encapsulating the provided {@code
   * SVGPolylineElement}. The constructor is protected to encourage the use of the static factory
   * method {@code of()} for creating new instances, ensuring uniformity across the framework.
   *
   * @param element the {@code SVGPolylineElement} to be wrapped
   */
  public PolyLineElement(SVGPolylineElement element) {
    super(element);
  }
}
