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

import elemental2.svg.SVGFEGaussianBlurElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * A class that provides a wrapper for the {@link SVGFEGaussianBlurElement}, which corresponds to
 * the {@code <feGaussianBlur>} SVG element. This filter primitive is used to blur an image by
 * applying a Gaussian blur. The class extends {@link BaseElement} to simplify the usage and
 * integration of the Gaussian blur effect within SVGs using the Domino UI framework.
 *
 * @see BaseElement
 * @see SVGFEGaussianBlurElement
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/SVG/Element/feGaussianBlur">MDN Web
 *     Docs - SVGFEGaussianBlurElement</a>
 */
public class FEGaussianBlurElement
    extends BaseElement<SVGFEGaussianBlurElement, FEGaussianBlurElement> {

  /**
   * Factory method for creating a new {@code FEGaussianBlurElement} instance from an existing
   * {@code SVGFEGaussianBlurElement}. This method abstracts the direct creation of {@code
   * FEGaussianBlurElement} objects, providing a standardized way to instantiate them within the
   * Domino UI framework.
   *
   * @param e the {@code SVGFEGaussianBlurElement} to wrap
   * @return a new {@code FEGaussianBlurElement} instance
   */
  public static FEGaussianBlurElement of(SVGFEGaussianBlurElement e) {
    return new FEGaussianBlurElement(e);
  }

  /**
   * Constructs a new {@code FEGaussianBlurElement} by encapsulating the specified {@code
   * SVGFEGaussianBlurElement}. This constructor is protected to encourage the use of the static
   * factory method {@code of()} for creating new instances, ensuring a consistent approach to
   * object creation throughout the framework.
   *
   * @param element the {@code SVGFEGaussianBlurElement} to be wrapped
   */
  public FEGaussianBlurElement(SVGFEGaussianBlurElement element) {
    super(element);
  }
}
