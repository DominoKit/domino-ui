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

import elemental2.svg.SVGFEImageElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * Encapsulates the {@link SVGFEImageElement}, which corresponds to the {@code <feImage>} SVG
 * element. This element fetches external graphical content and provides the content as input to
 * other elements or filter primitives within an SVG filter. It extends {@link BaseElement}, thereby
 * providing a simple API to utilize external images in SVG filters within the Domino UI framework.
 *
 * @see BaseElement
 * @see SVGFEImageElement
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/SVG/Element/feImage">MDN Web Docs -
 *     SVGFEImageElement</a>
 */
public class FEImageElement extends BaseElement<SVGFEImageElement, FEImageElement> {

  /**
   * Factory method to create a new {@code FEImageElement} instance from an existing {@code
   * SVGFEImageElement}. This method offers a streamlined, standardized process for creating {@code
   * FEImageElement} objects within the Domino UI framework.
   *
   * @param e the {@code SVGFEImageElement} to wrap
   * @return a new {@code FEImageElement} instance
   */
  public static FEImageElement of(SVGFEImageElement e) {
    return new FEImageElement(e);
  }

  /**
   * Constructs a new {@code FEImageElement} by encapsulating the specified {@code
   * SVGFEImageElement}. This constructor is protected to encourage the use of the static factory
   * method {@code of()} for instance creation, promoting consistency and maintainability in object
   * creation within the framework.
   *
   * @param element the {@code SVGFEImageElement} to be wrapped
   */
  public FEImageElement(SVGFEImageElement element) {
    super(element);
  }
}
