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

import elemental2.svg.SVGFESpotLightElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * Wraps the {@link SVGFESpotLightElement}, associated with the {@code <feSpotLight>} SVG element.
 * This filter primitive defines a directional light source with a given position and a spotlight
 * cone pointing towards the light target. It can be used with {@code <feDiffuseLighting>} or {@code
 * <feSpecularLighting>} to create lighting effects on SVG content. As an extension of {@link
 * BaseElement}, {@code FESpotLightElement} facilitates the integration and manipulation of spot
 * lighting within SVG documents using the Domino UI framework.
 *
 * @see BaseElement
 * @see SVGFESpotLightElement
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/SVG/Element/feSpotLight">MDN Web Docs
 *     - SVGFESpotLightElement</a>
 */
public class FESpotLightElement extends BaseElement<SVGFESpotLightElement, FESpotLightElement> {

  /**
   * Factory method for creating a new {@code FESpotLightElement} instance from an existing {@code
   * SVGFESpotLightElement}. This method abstracts the object creation process and is the preferred
   * way of constructing {@code FESpotLightElement} objects within the Domino UI framework.
   *
   * @param e the {@code SVGFESpotLightElement} to wrap
   * @return a new instance of {@code FESpotLightElement}
   */
  public static FESpotLightElement of(SVGFESpotLightElement e) {
    return new FESpotLightElement(e);
  }

  /**
   * Constructs a new {@code FESpotLightElement} by encapsulating the specified {@code
   * SVGFESpotLightElement}. This constructor is protected to encourage the use of the factory
   * method {@code of()} for creating new instances, ensuring a consistent method for object
   * creation across the framework.
   *
   * @param element the {@code SVGFESpotLightElement} to be wrapped
   */
  public FESpotLightElement(SVGFESpotLightElement element) {
    super(element);
  }
}
