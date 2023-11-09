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

import elemental2.svg.SVGFEOffsetElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * Encapsulates the {@link SVGFEOffsetElement}, which corresponds to the {@code <feOffset>} SVG
 * element. This filter primitive is used to create drop shadow effects by offsetting a source
 * graphic and combining it with the original graphic to give an illusion of shadow. As an extension
 * of {@link BaseElement}, {@code FEOffsetElement} provides a simple and efficient API for applying
 * offset effects within the SVG documents utilizing the Domino UI framework.
 *
 * @see BaseElement
 * @see SVGFEOffsetElement
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/SVG/Element/feOffset">MDN Web Docs -
 *     SVGFEOffsetElement</a>
 */
public class FEOffsetElement extends BaseElement<SVGFEOffsetElement, FEOffsetElement> {

  /**
   * Factory method for creating a new {@code FEOffsetElement} instance from an existing {@code
   * SVGFEOffsetElement}. This method simplifies the process of creating {@code FEOffsetElement}
   * objects, promoting a standardized way to utilize this filter within the Domino UI framework.
   *
   * @param e the {@code SVGFEOffsetElement} to wrap
   * @return a new instance of {@code FEOffsetElement}
   */
  public static FEOffsetElement of(SVGFEOffsetElement e) {
    return new FEOffsetElement(e);
  }

  /**
   * Constructs a new {@code FEOffsetElement} by encapsulating the specified {@code
   * SVGFEOffsetElement}. This constructor is protected to promote the use of the static factory
   * method {@code of()} for instance creation, ensuring consistency and manageability across the
   * framework.
   *
   * @param element the {@code SVGFEOffsetElement} to be wrapped
   */
  public FEOffsetElement(SVGFEOffsetElement element) {
    super(element);
  }
}
