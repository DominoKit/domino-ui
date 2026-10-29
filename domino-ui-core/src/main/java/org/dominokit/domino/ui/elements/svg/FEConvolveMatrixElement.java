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

import elemental2.svg.SVGFEConvolveMatrixElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * Wraps the {@link SVGFEConvolveMatrixElement}, corresponding to the SVG {@code <feConvolveMatrix>}
 * element. This SVG element is used to apply a matrix convolution filter effect. Convolution
 * filters are used to apply effects such as blurring, sharpening, embossing, or edge detection to
 * an input image. Extending {@link BaseElement}, {@code FEConvolveMatrixElement} provides a fluent
 * API to use these filter effects within the Domino UI framework.
 *
 * @see BaseElement
 * @see SVGFEConvolveMatrixElement
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/SVG/Element/feConvolveMatrix">MDN Web
 *     Docs - SVGFEConvolveMatrixElement</a>
 */
public class FEConvolveMatrixElement
    extends BaseElement<SVGFEConvolveMatrixElement, FEConvolveMatrixElement> {

  /**
   * Factory method to create a new {@code FEConvolveMatrixElement} instance from an existing {@code
   * SVGFEConvolveMatrixElement}. This method offers a more convenient, abstracted way to construct
   * {@code FEConvolveMatrixElement} objects, and is the recommended practice within the Domino UI
   * framework.
   *
   * @param e the {@code SVGFEConvolveMatrixElement} to wrap
   * @return a new instance of {@code FEConvolveMatrixElement}
   */
  public static FEConvolveMatrixElement of(SVGFEConvolveMatrixElement e) {
    return new FEConvolveMatrixElement(e);
  }

  /**
   * Constructs a new {@code FEConvolveMatrixElement} by encapsulating the provided {@code
   * SVGFEConvolveMatrixElement}. This constructor is protected to encourage the use of the factory
   * method {@code of()} for creating instances, ensuring a uniform approach to object creation
   * across the framework.
   *
   * @param element the {@code SVGFEConvolveMatrixElement} to wrap
   */
  public FEConvolveMatrixElement(SVGFEConvolveMatrixElement element) {
    super(element);
  }
}
