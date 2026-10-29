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

import elemental2.svg.SVGFEFuncAElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * Represents a wrapper for the {@link SVGFEFuncAElement}, corresponding to the {@code <feFuncA>}
 * SVG element. This element defines the alpha component transfer function for the {@code
 * <feComponentTransfer>} element, which allows for pixel-wise manipulation of an image. Extending
 * {@link BaseElement}, {@code FEFuncAElement} provides a fluent API to control the transfer
 * function for the alpha channel within the context of the Domino UI framework.
 *
 * @see BaseElement
 * @see SVGFEFuncAElement
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/SVG/Element/feFuncA">MDN Web Docs -
 *     SVGFEFuncAElement</a>
 */
public class FEFuncAElement extends BaseElement<SVGFEFuncAElement, FEFuncAElement> {

  /**
   * Factory method for creating a new {@code FEFuncAElement} instance from an existing {@code
   * SVGFEFuncAElement}. This method facilitates the instantiation of {@code FEFuncAElement}
   * objects, providing a preferred way to work with alpha transfer functions within SVG filters as
   * part of the Domino UI framework.
   *
   * @param e the {@code SVGFEFuncAElement} to wrap
   * @return a new instance of {@code FEFuncAElement}
   */
  public static FEFuncAElement of(SVGFEFuncAElement e) {
    return new FEFuncAElement(e);
  }

  /**
   * Constructs a new {@code FEFuncAElement} by encapsulating the provided {@code
   * SVGFEFuncAElement}. This constructor is protected to encourage the use of the static factory
   * method {@code of()} for creating new instances, which ensures a uniform approach to object
   * creation across the framework.
   *
   * @param element the {@code SVGFEFuncAElement} to be wrapped
   */
  public FEFuncAElement(SVGFEFuncAElement element) {
    super(element);
  }
}
