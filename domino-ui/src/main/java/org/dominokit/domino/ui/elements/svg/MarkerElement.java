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

import elemental2.svg.SVGMarkerElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * This class provides a wrapper for the {@link SVGMarkerElement}, which represents an SVG marker
 * element. The {@code MarkerElement} class allows you to work with SVG markers within the Domino UI
 * framework, making it easier to create and manipulate marker elements in SVG graphics.
 *
 * @see BaseElement
 * @see SVGMarkerElement
 */
public class MarkerElement extends BaseElement<SVGMarkerElement, MarkerElement> {

  /**
   * Factory method for creating a new {@code MarkerElement} instance from an existing {@code
   * SVGMarkerElement}. This method provides a standardized way of wrapping {@code SVGMarkerElement}
   * objects within the Domino UI framework, promoting a consistent object creation pattern.
   *
   * @param e the {@code SVGMarkerElement} to wrap
   * @return a new instance of {@code MarkerElement}
   */
  public static MarkerElement of(SVGMarkerElement e) {
    return new MarkerElement(e);
  }

  /**
   * Constructs a new {@code MarkerElement} by encapsulating the provided {@code SVGMarkerElement}.
   * The constructor is protected to encourage the use of the static factory method {@code of()} for
   * creating new instances, ensuring uniformity across the framework.
   *
   * @param element the {@code SVGMarkerElement} to be wrapped
   */
  public MarkerElement(SVGMarkerElement element) {
    super(element);
  }
}
