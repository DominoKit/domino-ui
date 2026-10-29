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

import elemental2.svg.SVGRadialGradientElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * This class provides a wrapper for the {@link SVGRadialGradientElement}, which represents an SVG
 * radial gradient element. The {@code RadialGradientElement} class allows you to work with radial
 * gradient elements within the Domino UI framework, making it easier to create and manipulate
 * radial gradient elements in SVG graphics.
 *
 * @see BaseElement
 * @see SVGRadialGradientElement
 */
public class RadialGradientElement
    extends BaseElement<SVGRadialGradientElement, RadialGradientElement> {

  /**
   * Factory method for creating a new {@code RadialGradientElement} instance from an existing
   * {@code SVGRadialGradientElement}. This method provides a standardized way of wrapping {@code
   * SVGRadialGradientElement} objects within the Domino UI framework, promoting a consistent object
   * creation pattern.
   *
   * @param e the {@code SVGRadialGradientElement} to wrap
   * @return a new instance of {@code RadialGradientElement}
   */
  public static RadialGradientElement of(SVGRadialGradientElement e) {
    return new RadialGradientElement(e);
  }

  /**
   * Constructs a new {@code RadialGradientElement} by encapsulating the provided {@code
   * SVGRadialGradientElement}. The constructor is protected to encourage the use of the static
   * factory method {@code of()} for creating new instances, ensuring uniformity across the
   * framework.
   *
   * @param element the {@code SVGRadialGradientElement} to be wrapped
   */
  public RadialGradientElement(SVGRadialGradientElement element) {
    super(element);
  }
}
