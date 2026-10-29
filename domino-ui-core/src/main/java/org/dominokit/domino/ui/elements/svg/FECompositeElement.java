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

import elemental2.svg.SVGFECompositeElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * A class that encapsulates the {@link SVGFECompositeElement}, representing the {@code
 * <feComposite>} element within SVG. This filter primitive performs the combination of two input
 * images pixel-wise in image space using one of the predefined compositing operations. This class
 * extends {@link BaseElement} to provide a robust API for working with composite operations within
 * SVG filters, as per the Domino UI framework conventions.
 *
 * @see BaseElement
 * @see SVGFECompositeElement
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/SVG/Element/feComposite">MDN Web Docs
 *     - SVGFECompositeElement</a>
 */
public class FECompositeElement extends BaseElement<SVGFECompositeElement, FECompositeElement> {

  /**
   * Factory method for creating a new {@code FECompositeElement} instance from an existing {@code
   * SVGFECompositeElement}. This method is the preferred means of instantiation and provides an
   * abstracted and convenient way to work with SVG composite filter effects within the Domino UI
   * framework.
   *
   * @param e the {@code SVGFECompositeElement} to wrap
   * @return a new {@code FECompositeElement} instance
   */
  public static FECompositeElement of(SVGFECompositeElement e) {
    return new FECompositeElement(e);
  }

  /**
   * Constructs a new {@code FECompositeElement} by wrapping the specified {@code
   * SVGFECompositeElement}. The constructor is protected to encourage the use of the static factory
   * method {@code of()} for creating new instances, ensuring a consistent approach to object
   * creation within the framework.
   *
   * @param element the {@code SVGFECompositeElement} to be wrapped
   */
  public FECompositeElement(SVGFECompositeElement element) {
    super(element);
  }
}
