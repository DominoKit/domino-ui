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

import elemental2.svg.SVGFEColorMatrixElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * A class that wraps the {@link SVGFEColorMatrixElement}, corresponding to the {@code
 * <feColorMatrix>} SVG element. This element is a filter primitive that changes colors based on a
 * transformation matrix. It extends {@link BaseElement} to provide additional functionalities that
 * are more specific and easy to use within the Domino UI framework for SVG manipulation.
 *
 * @see BaseElement
 * @see SVGFEColorMatrixElement
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/SVG/Element/feColorMatrix">MDN Web
 *     Docs - SVGFEColorMatrixElement</a>
 */
public class FEColorMatrixElement
    extends BaseElement<SVGFEColorMatrixElement, FEColorMatrixElement> {

  /**
   * Factory method for creating a new {@code FEColorMatrixElement} instance from an existing {@code
   * SVGFEColorMatrixElement}. This method provides an abstracted way to instantiate {@code
   * FEColorMatrixElement} objects, which is preferred within the Domino UI framework.
   *
   * @param e the {@code SVGFEColorMatrixElement} to wrap
   * @return a new {@code FEColorMatrixElement} instance
   */
  public static FEColorMatrixElement of(SVGFEColorMatrixElement e) {
    return new FEColorMatrixElement(e);
  }

  /**
   * Constructs a new {@code FEColorMatrixElement} that wraps the provided {@code
   * SVGFEColorMatrixElement}. This constructor is protected to promote the use of the factory
   * method {@code of()} for creating new instances.
   *
   * @param element the {@code SVGFEColorMatrixElement} to be wrapped
   */
  public FEColorMatrixElement(SVGFEColorMatrixElement element) {
    super(element);
  }
}
