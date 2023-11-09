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

import elemental2.svg.SVGFEDistantLightElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * Encapsulates the {@link SVGFEDistantLightElement}, which corresponds to the {@code
 * <feDistantLight>} element within an SVG. This element defines a distant light source as part of
 * the SVG's lighting filter primitives, simulating a light source that is so far away that the rays
 * of light are parallel. This class extends {@link BaseElement} to provide an easy-to-use API for
 * integrating distant light effects within the Domino UI framework's SVG filter effects.
 *
 * @see BaseElement
 * @see SVGFEDistantLightElement
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/SVG/Element/feDistantLight">MDN Web
 *     Docs - SVGFEDistantLightElement</a>
 */
public class FEDistantLightElement
    extends BaseElement<SVGFEDistantLightElement, FEDistantLightElement> {

  /**
   * Factory method for creating a new {@code FEDistantLightElement} instance from an existing
   * {@code SVGFEDistantLightElement}. This method provides a standardized approach to constructing
   * {@code FEDistantLightElement} objects within the Domino UI framework, ensuring consistent
   * object creation and integration.
   *
   * @param e the {@code SVGFEDistantLightElement} to wrap
   * @return a new {@code FEDistantLightElement} instance
   */
  public static FEDistantLightElement of(SVGFEDistantLightElement e) {
    return new FEDistantLightElement(e);
  }

  /**
   * Constructs a new {@code FEDistantLightElement} by wrapping the provided {@code
   * SVGFEDistantLightElement}. The constructor is protected to promote the use of the static
   * factory method {@code of()} for creating instances, which helps maintain consistency across the
   * framework.
   *
   * @param element the {@code SVGFEDistantLightElement} to be wrapped
   */
  public FEDistantLightElement(SVGFEDistantLightElement element) {
    super(element);
  }
}
