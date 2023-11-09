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

import elemental2.svg.SVGFEDisplacementMapElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * A class that wraps the {@link SVGFEDisplacementMapElement}, representing the {@code
 * <feDisplacementMap>} SVG element. This element is used in SVG filters to create a variety of
 * distortion effects by displacing pixels in an image according to the color values from another
 * image. As a derivative of {@link BaseElement}, this class enables the easy application and
 * manipulation of displacement maps within SVGs in the context of the Domino UI framework.
 *
 * @see BaseElement
 * @see SVGFEDisplacementMapElement
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/SVG/Element/feDisplacementMap">MDN Web
 *     Docs - SVGFEDisplacementMapElement</a>
 */
public class FEDisplacementMapElement
    extends BaseElement<SVGFEDisplacementMapElement, FEDisplacementMapElement> {

  /**
   * Factory method for creating a new {@code FEDisplacementMapElement} instance from an existing
   * {@code SVGFEDisplacementMapElement}. This method abstracts the object construction process,
   * providing a standard method for generating {@code FEDisplacementMapElement} objects within the
   * Domino UI framework.
   *
   * @param e the {@code SVGFEDisplacementMapElement} to wrap
   * @return a new {@code FEDisplacementMapElement} instance
   */
  public static FEDisplacementMapElement of(SVGFEDisplacementMapElement e) {
    return new FEDisplacementMapElement(e);
  }

  /**
   * Constructs a new {@code FEDisplacementMapElement} by wrapping the specified {@code
   * SVGFEDisplacementMapElement}. This constructor is protected to encourage the use of the factory
   * method {@code of()} for creating new instances, thereby promoting a consistent object creation
   * strategy throughout the framework.
   *
   * @param element the {@code SVGFEDisplacementMapElement} to be wrapped
   */
  public FEDisplacementMapElement(SVGFEDisplacementMapElement element) {
    super(element);
  }
}
