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

import elemental2.svg.SVGFETurbulenceElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * Encapsulates the {@link SVGFETurbulenceElement}, corresponding to the {@code <feTurbulence>} SVG
 * element. This filter primitive creates an image using the Perlin noise function, which is useful
 * for creating different types of textures like clouds or marble. It extends {@link BaseElement},
 * providing an API for easily creating and manipulating turbulence effects within SVG documents as
 * part of the Domino UI framework.
 *
 * @see BaseElement
 * @see SVGFETurbulenceElement
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/SVG/Element/feTurbulence">MDN Web Docs
 *     - SVGFETurbulenceElement</a>
 */
public class FETurbulenceElement extends BaseElement<SVGFETurbulenceElement, FETurbulenceElement> {

  /**
   * Factory method for creating a new {@code FETurbulenceElement} instance from an existing {@code
   * SVGFETurbulenceElement}. This method abstracts the direct construction of objects, providing a
   * convenient way to instantiate {@code FETurbulenceElement} objects within the Domino UI
   * framework.
   *
   * @param e the {@code SVGFETurbulenceElement} to wrap
   * @return a new instance of {@code FETurbulenceElement}
   */
  public static FETurbulenceElement of(SVGFETurbulenceElement e) {
    return new FETurbulenceElement(e);
  }

  /**
   * Constructs a new {@code FETurbulenceElement} by wrapping the specified {@code
   * SVGFETurbulenceElement}. This constructor is protected to encourage the use of the static
   * factory method {@code of()} for creating new instances, ensuring consistent and manageable
   * object creation within the framework.
   *
   * @param element the {@code SVGFETurbulenceElement} to be wrapped
   */
  public FETurbulenceElement(SVGFETurbulenceElement element) {
    super(element);
  }
}
