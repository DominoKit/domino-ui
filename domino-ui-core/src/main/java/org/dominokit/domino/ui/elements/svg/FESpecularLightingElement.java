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

import elemental2.svg.SVGFESpecularLightingElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * A class that encapsulates the {@link SVGFESpecularLightingElement}, which corresponds to the
 * {@code <feSpecularLighting>} SVG element. This filter primitive is used to create an image filled
 * with specular lighting effects, simulating the reflection of light on a shiny surface. It often
 * uses {@code <fePointLight>}, {@code <feDistantLight>}, or {@code <feSpotLight>} as light sources.
 * Extending {@link BaseElement}, {@code FESpecularLightingElement} allows for the convenient
 * application of specular lighting effects within SVG graphics through the Domino UI framework.
 *
 * @see BaseElement
 * @see SVGFESpecularLightingElement
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/SVG/Element/feSpecularLighting">MDN
 *     Web Docs - SVGFESpecularLightingElement</a>
 */
public class FESpecularLightingElement
    extends BaseElement<SVGFESpecularLightingElement, FESpecularLightingElement> {

  /**
   * Factory method for creating a new {@code FESpecularLightingElement} instance from an existing
   * {@code SVGFESpecularLightingElement}. This method provides a standardized way of constructing
   * {@code FESpecularLightingElement} objects, facilitating their usage and integration within SVG
   * filters as part of the Domino UI framework.
   *
   * @param e the {@code SVGFESpecularLightingElement} to wrap
   * @return a new instance of {@code FESpecularLightingElement}
   */
  public static FESpecularLightingElement of(SVGFESpecularLightingElement e) {
    return new FESpecularLightingElement(e);
  }

  /**
   * Constructs a new {@code FESpecularLightingElement} by encapsulating the provided {@code
   * SVGFESpecularLightingElement}. This constructor is protected to encourage the use of the static
   * factory method {@code of()} for creating new instances, thus ensuring a consistent approach to
   * object creation across the framework.
   *
   * @param element the {@code SVGFESpecularLightingElement} to be wrapped
   */
  public FESpecularLightingElement(SVGFESpecularLightingElement element) {
    super(element);
  }
}
