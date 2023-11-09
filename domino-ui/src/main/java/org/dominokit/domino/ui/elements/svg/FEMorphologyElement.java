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

import elemental2.svg.SVGFEMorphologyElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * Provides a wrapper for the {@link SVGFEMorphologyElement}, associated with the {@code
 * <feMorphology>} SVG element. This element is used within an SVG filter to implement morphological
 * operations like dilation or erosion on an input image. The operations are typically used to grow
 * or shrink artwork or to remove noise. By extending {@link BaseElement}, {@code
 * FEMorphologyElement} enables the easy application of these morphological effects within SVG
 * documents using the Domino UI framework.
 *
 * @see BaseElement
 * @see SVGFEMorphologyElement
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/SVG/Element/feMorphology">MDN Web Docs
 *     - SVGFEMorphologyElement</a>
 */
public class FEMorphologyElement extends BaseElement<SVGFEMorphologyElement, FEMorphologyElement> {

  /**
   * Factory method to create a new {@code FEMorphologyElement} instance from an existing {@code
   * SVGFEMorphologyElement}. This method abstracts the direct construction of objects, providing a
   * standardized, convenient way to create {@code FEMorphologyElement} objects within the Domino UI
   * framework.
   *
   * @param e the {@code SVGFEMorphologyElement} to wrap
   * @return a new instance of {@code FEMorphologyElement}
   */
  public static FEMorphologyElement of(SVGFEMorphologyElement e) {
    return new FEMorphologyElement(e);
  }

  /**
   * Constructs a new {@code FEMorphologyElement} by encapsulating the provided {@code
   * SVGFEMorphologyElement}. This constructor is protected to encourage the use of the static
   * factory method {@code of()} for creating new instances, ensuring consistent and manageable
   * object creation across the framework.
   *
   * @param element the {@code SVGFEMorphologyElement} to be wrapped
   */
  public FEMorphologyElement(SVGFEMorphologyElement element) {
    super(element);
  }
}
