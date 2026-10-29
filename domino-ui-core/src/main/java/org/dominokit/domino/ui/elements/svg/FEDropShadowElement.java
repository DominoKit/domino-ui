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

import elemental2.svg.SVGFEDropShadowElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * Wraps the {@link SVGFEDropShadowElement}, corresponding to the {@code <feDropShadow>} SVG
 * element. This filter primitive creates a drop shadow effect, giving the impression that an object
 * is raised above the objects behind it. The class extends {@link BaseElement}, allowing for easy
 * manipulation and integration of drop shadow effects within SVG graphics as part of the Domino UI
 * framework.
 *
 * @see BaseElement
 * @see SVGFEDropShadowElement
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/SVG/Element/feDropShadow">MDN Web Docs
 *     - SVGFEDropShadowElement</a>
 */
public class FEDropShadowElement extends BaseElement<SVGFEDropShadowElement, FEDropShadowElement> {

  /**
   * Factory method for creating a new {@code FEDropShadowElement} instance from an existing {@code
   * SVGFEDropShadowElement}. This method abstracts the direct construction of an object, providing
   * a standardized method for creating {@code FEDropShadowElement} objects within the Domino UI
   * framework.
   *
   * @param e the {@code SVGFEDropShadowElement} to wrap
   * @return a new instance of {@code FEDropShadowElement}
   */
  public static FEDropShadowElement of(SVGFEDropShadowElement e) {
    return new FEDropShadowElement(e);
  }

  /**
   * Constructs a new {@code FEDropShadowElement} by wrapping the provided {@code
   * SVGFEDropShadowElement}. The constructor is protected to encourage the use of the factory
   * method {@code of()} for creating new instances, ensuring a consistent object creation strategy
   * across the framework.
   *
   * @param element the {@code SVGFEDropShadowElement} to be wrapped
   */
  public FEDropShadowElement(SVGFEDropShadowElement element) {
    super(element);
  }
}
