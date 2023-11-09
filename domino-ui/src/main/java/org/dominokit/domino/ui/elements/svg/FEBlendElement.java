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

import elemental2.svg.SVGFEBlendElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * A class representing a wrapper for the {@link SVGFEBlendElement}, which corresponds to the {@code
 * <feBlend>} element in SVG. This SVG filter primitive composes two objects together ruled by a
 * certain blending mode. Extending {@link BaseElement}, the {@code FEBlendElement} class allows for
 * easy manipulation of the {@code <feBlend>} element properties within the context of the Domino UI
 * framework.
 *
 * @see BaseElement
 * @see SVGFEBlendElement
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/SVG/Element/feBlend">MDN Web Docs -
 *     SVGFEBlendElement</a>
 */
public class FEBlendElement extends BaseElement<SVGFEBlendElement, FEBlendElement> {

  /**
   * Factory method for creating a new {@code FEBlendElement} instance from an existing {@code
   * SVGFEBlendElement}. This method is the preferred means of instantiation, offering a more
   * abstract and convenient creation process within the Domino UI framework.
   *
   * @param e the {@code SVGFEBlendElement} to wrap
   * @return a new {@code FEBlendElement} instance
   */
  public static FEBlendElement of(SVGFEBlendElement e) {
    return new FEBlendElement(e);
  }

  /**
   * Constructs a new {@code FEBlendElement} that wraps the provided {@code SVGFEBlendElement}. The
   * constructor is protected to encourage the use of the factory method {@code of()} for creating
   * new instances, ensuring consistency across the framework.
   *
   * @param element the {@code SVGFEBlendElement} to be wrapped
   */
  public FEBlendElement(SVGFEBlendElement element) {
    super(element);
  }
}
