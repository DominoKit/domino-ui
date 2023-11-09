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

import elemental2.svg.SVGFEDiffuseLightingElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * Encapsulates the {@link SVGFEDiffuseLightingElement} which corresponds to the {@code
 * <feDiffuseLighting>} SVG element. This filter primitive is used to achieve a lighting effect on
 * an SVG image by illuminating the input image with a simulated light source. It defines a lighting
 * effect that appears to cast diffuse light on an object. By extending {@link BaseElement}, {@code
 * FEDiffuseLightingElement} provides a convenient API for applying this effect within the Domino UI
 * framework.
 *
 * @see BaseElement
 * @see SVGFEDiffuseLightingElement
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/SVG/Element/feDiffuseLighting">MDN Web
 *     Docs - SVGFEDiffuseLightingElement</a>
 */
public class FEDiffuseLightingElement
    extends BaseElement<SVGFEDiffuseLightingElement, FEDiffuseLightingElement> {

  /**
   * Factory method to create a new {@code FEDiffuseLightingElement} instance from an existing
   * {@code SVGFEDiffuseLightingElement}. This method provides an abstracted approach to instantiate
   * {@code FEDiffuseLightingElement} objects, which is the recommended way within the Domino UI
   * framework.
   *
   * @param e the {@code SVGFEDiffuseLightingElement} to wrap
   * @return a new instance of {@code FEDiffuseLightingElement}
   */
  public static FEDiffuseLightingElement of(SVGFEDiffuseLightingElement e) {
    return new FEDiffuseLightingElement(e);
  }

  /**
   * Constructs a new {@code FEDiffuseLightingElement} by encapsulating the provided {@code
   * SVGFEDiffuseLightingElement}. This constructor is protected to encourage the use of the static
   * factory method {@code of()} for creating new instances, ensuring a consistent construction
   * methodology across the framework.
   *
   * @param element the {@code SVGFEDiffuseLightingElement} to be wrapped
   */
  public FEDiffuseLightingElement(SVGFEDiffuseLightingElement element) {
    super(element);
  }
}
