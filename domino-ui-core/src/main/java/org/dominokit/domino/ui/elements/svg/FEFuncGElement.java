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

import elemental2.svg.SVGFEFuncGElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * A class that encapsulates the {@link SVGFEFuncGElement}, corresponding to the {@code <feFuncG>}
 * SVG element. This element targets the green color channel within an {@code <feComponentTransfer>}
 * filter primitive, allowing for fine-tuned manipulation of the image's green component. As an
 * extension of {@link BaseElement}, {@code FEFuncGElement} provides a streamlined interface for SVG
 * filter construction and manipulation within the Domino UI framework.
 *
 * @see BaseElement
 * @see SVGFEFuncGElement
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/SVG/Element/feFuncG">MDN Web Docs -
 *     SVGFEFuncGElement</a>
 */
public class FEFuncGElement extends BaseElement<SVGFEFuncGElement, FEFuncGElement> {

  /**
   * Factory method for creating a new {@code FEFuncGElement} instance from an existing {@code
   * SVGFEFuncGElement}. This method abstracts the direct construction of objects and is the
   * recommended way of creating {@code FEFuncGElement} instances within the Domino UI framework.
   *
   * @param e the {@code SVGFEFuncGElement} to wrap
   * @return a new instance of {@code FEFuncGElement}
   */
  public static FEFuncGElement of(SVGFEFuncGElement e) {
    return new FEFuncGElement(e);
  }

  /**
   * Constructs a new {@code FEFuncGElement} by encapsulating the specified {@code
   * SVGFEFuncGElement}. This constructor is protected to encourage the use of the static factory
   * method {@code of()} for creating new instances, ensuring a uniform approach to object creation
   * across the framework.
   *
   * @param element the {@code SVGFEFuncGElement} to be wrapped
   */
  public FEFuncGElement(SVGFEFuncGElement element) {
    super(element);
  }
}
