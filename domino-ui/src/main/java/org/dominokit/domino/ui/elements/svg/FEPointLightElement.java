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

import elemental2.svg.SVGFEPointLightElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * Represents a wrapper for the {@link SVGFEPointLightElement}, associated with the {@code
 * <fePointLight>} SVG element. This filter primitive defines a point light source which can be used
 * in conjunction with {@code <feDiffuseLighting>} or {@code <feSpecularLighting>} to light an SVG
 * object, creating the effect of a light emanating from a single point in space. The {@code
 * FEPointLightElement} extends the {@link BaseElement} to facilitate easy integration and
 * manipulation of point light effects within the SVG filters as part of the Domino UI framework.
 *
 * @see BaseElement
 * @see SVGFEPointLightElement
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/SVG/Element/fePointLight">MDN Web Docs
 *     - SVGFEPointLightElement</a>
 */
public class FEPointLightElement extends BaseElement<SVGFEPointLightElement, FEPointLightElement> {

  /**
   * Factory method for creating a new {@code FEPointLightElement} instance from a provided {@code
   * SVGFEPointLightElement}. This method offers a convenient way to work with point light sources
   * within the SVG filtering effects, providing a standardized interface within the Domino UI
   * framework.
   *
   * @param e the {@code SVGFEPointLightElement} to wrap
   * @return a new instance of {@code FEPointLightElement}
   */
  public static FEPointLightElement of(SVGFEPointLightElement e) {
    return new FEPointLightElement(e);
  }

  /**
   * Constructs a new {@code FEPointLightElement} by encapsulating the given {@code
   * SVGFEPointLightElement}. This constructor is protected to encourage the use of the factory
   * method {@code of()} for creating new instances, ensuring a uniform method of object creation
   * across the framework.
   *
   * @param element the {@code SVGFEPointLightElement} to wrap
   */
  public FEPointLightElement(SVGFEPointLightElement element) {
    super(element);
  }
}
