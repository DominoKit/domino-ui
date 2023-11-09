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

import elemental2.svg.SVGFEFuncBElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * Wraps the {@link SVGFEFuncBElement}, associated with the {@code <feFuncB>} SVG element. This
 * element is used within an {@code <feComponentTransfer>} filter primitive to process the blue
 * component of the color input to the filter. By extending {@link BaseElement}, {@code
 * FEFuncBElement} provides a fluent interface for manipulating blue channel transfer functions,
 * enhancing the capabilities of SVG image processing within the Domino UI framework.
 *
 * @see BaseElement
 * @see SVGFEFuncBElement
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/SVG/Element/feFuncB">MDN Web Docs -
 *     SVGFEFuncBElement</a>
 */
public class FEFuncBElement extends BaseElement<SVGFEFuncBElement, FEFuncBElement> {

  /**
   * Factory method to create a new {@code FEFuncBElement} instance from a provided {@code
   * SVGFEFuncBElement}. This approach offers a standardized way of constructing {@code
   * FEFuncBElement} objects, facilitating their use within the broader context of the Domino UI
   * framework's SVG functionality.
   *
   * @param e the {@code SVGFEFuncBElement} to wrap
   * @return a new {@code FEFuncBElement} instance
   */
  public static FEFuncBElement of(SVGFEFuncBElement e) {
    return new FEFuncBElement(e);
  }

  /**
   * Constructs a new {@code FEFuncBElement} by encapsulating the specified {@code
   * SVGFEFuncBElement}. This constructor is protected to promote the use of the factory method
   * {@code of()} for creating instances, ensuring consistent and maintainable object creation
   * throughout the framework.
   *
   * @param element the {@code SVGFEFuncBElement} to be wrapped
   */
  public FEFuncBElement(SVGFEFuncBElement element) {
    super(element);
  }
}
